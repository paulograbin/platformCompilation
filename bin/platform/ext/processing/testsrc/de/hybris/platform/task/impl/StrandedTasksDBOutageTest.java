/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.task.impl;

import static de.hybris.platform.task.impl.StrandedTasksResolutionHandler.REMOVE_STRANDED_TASK_ON_DELETE_FAILURE;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.given;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.jdbcwrapper.DBOutageSimulator;
import de.hybris.platform.jdbcwrapper.HybrisDataSource;
import de.hybris.platform.jdbcwrapper.JUnitJDBCConnectionPool;
import de.hybris.platform.scripting.model.ScriptModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.RetryLaterException;
import de.hybris.platform.task.TaskConditionModel;
import de.hybris.platform.task.TaskModel;
import de.hybris.platform.task.TaskRunner;
import de.hybris.platform.task.TaskService;
import de.hybris.platform.task.TaskTimeoutException;
import de.hybris.platform.task.action.ScriptingTaskRunner;
import de.hybris.platform.task.model.ScriptingTaskModel;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.testframework.assertions.assertj.TestLogListenerAssert;
import de.hybris.platform.testframework.log.TestLogListener;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.retry.support.RetryTemplate;

import com.codahale.metrics.MetricRegistry;

/**
 * Test verifies cases of failure to complete the task executor strategy stage as a result of a database failure simulation.
 * <p>
 * In case of failure the task is registered in stranded tasks registry and should be later marked as failed or be removed depend on "remove.stranded.task.on.delete.failure" configuration flag.
 */
@IntegrationTest
public class StrandedTasksDBOutageTest extends ServicelayerBaseTest
{
	private static final Duration TIMEOUT = Duration.ofSeconds(30L);
	private static final String REMOVE_MESSAGE = "Removed task with pk: ";
	private static final String MARK_TASK_FAILED_MESSAGE = "Marked as failed task with pk: ";
	private static final boolean EXPIRED = true;
	private static final boolean REMOVE_STRANDED_TASK_ON_DELETE_FAILURE_VALUE = true;

	@Resource
	private TaskService taskService;
	@Resource
	private ModelService modelService;
	@Resource
	private EventService eventService;
	@Resource
	private ScheduleAndTriggerStrategy scheduleAndTriggerStrategy;
	@Resource
	protected StrandedTasksLogic strandedTasksLogic;
	@Resource
	protected TaskDAO taskDao;
	@Resource
	private MetricRegistry metricRegistry;
	@Resource
	private RetryTemplate taskEngineRetryTemplate;
	@Resource
	private TasksProvider tasksProvider;
	@Resource(name = "scriptingTaskRunner")
	private TaskRunner<TaskModel> taskRunner;

	private DefaultTaskService testTaskService;
	private boolean taskEngineWasRunningBefore;
	private DBOutageTestTaskExecutionStrategy taskExecutionStrategySpy;
	private JUnitJDBCConnectionPool connectionPool;
	private DBOutageSimulator dbOutageSimulator;
	private final TestLogListener testLogListener = new TestLogListener();
	private final PropertyConfigSwitcher removeStrandedTaskSwitcher = new PropertyConfigSwitcher(
			REMOVE_STRANDED_TASK_ON_DELETE_FAILURE);


	@Before
	public void setUp() throws Exception
	{
		prepareDBOutageSimulator();
		stopTaskEngine();
		spyTaskEngineLogic();
		testLogListener.attach();
	}

	@After
	public void tearDown() throws Exception
	{
		testLogListener.detach();
		cleanUpDBOutageSimulator();
		removeStrandedTaskSwitcher.switchBackToDefault();
		cleanUpTaskEngineLogic();
		restoreTaskEngine();
	}

	@Test
	public void shouldRemoveStrandedTaskWhenDBOutageOnFinish()
	{
		removeStrandedTaskSwitcher.switchToValue("true");
		runTestScenario(!EXPIRED, REMOVE_STRANDED_TASK_ON_DELETE_FAILURE_VALUE);
	}

	@Test
	public void shouldMarkAsFailedStrandedTaskWhenDBOutageOnFinish()
	{
		removeStrandedTaskSwitcher.switchToValue("false");
		runTestScenario(!EXPIRED, !REMOVE_STRANDED_TASK_ON_DELETE_FAILURE_VALUE);
	}

	@Test
	public void shouldRemoveStrandedExpiredTaskWhenDBOutageOnFinish()
	{
		removeStrandedTaskSwitcher.switchToValue("true");
		runTestScenario(EXPIRED, REMOVE_STRANDED_TASK_ON_DELETE_FAILURE_VALUE);
	}

	@Test
	public void shouldMarkAsFailedStrandedExpiredTaskWhenDBOutageOnFinish()
	{
		removeStrandedTaskSwitcher.switchToValue("false");
		runTestScenario(EXPIRED, !REMOVE_STRANDED_TASK_ON_DELETE_FAILURE_VALUE);
	}

	private void runTestScenario(final boolean testExpired, final boolean removeExpected)
	{
		withTaskService(() -> {
			final String testId = UUID.randomUUID().toString();
			final TaskModel testTask = prepareTask(testId, testExpired);
			final TaskConditionModel testTaskCondition = prepareCondition(testTask, testId);
			final Date expectedExpirationDate = testTask.getExpirationDate();

			testTaskService.scheduleTask(testTask);
			if (!testExpired)
			{
				testTaskService.triggerEvent(testId);
			}

			waitForAssert(TIMEOUT, testTask, this::isInStrandedRegistry);

			dbOutageSimulator.disable();

			waitForAssert(TIMEOUT, testTask, this::isNotInStrandedRegistry);

			if (!removeExpected)
			{
				assertThat(isMarkedAsFailed(testTask)).isTrue();
			}

			assertThat(isRemoved(testTask)).isSameAs(removeExpected);
			assertThat(isRemoved(testTaskCondition)).isSameAs(removeExpected);

			final PK expectedTaskPK = testTask.getPk();
			assertLogsCreated(expectedTaskPK, removeExpected ? REMOVE_MESSAGE : MARK_TASK_FAILED_MESSAGE);

			verify(taskExecutionStrategySpy, times(testExpired ? 0 : 1)).run(eq(testTaskService), eq(taskRunner),
					argThat(task -> isExpectedTask(task, expectedTaskPK)));

			final ArgumentMatcher<Throwable> timeoutMatcher = e -> isTimeoutException(e, expectedTaskPK, expectedExpirationDate);

			verify(taskExecutionStrategySpy).finished(eq(testTaskService), eq(taskRunner),
					argThat(task -> isExpectedTask(task, expectedTaskPK)),
					testExpired ? argThat(timeoutMatcher) : isNull());

		});
	}

	private boolean isExpectedTask(final TaskModel task, final PK expectedPK)
	{
		return task.getPk().equals(expectedPK);
	}

	private boolean isTimeoutException(final Throwable exception, final PK pk, final Date taskExpirationDate)
	{
		return exception instanceof TaskTimeoutException timeoutException
				&& timeoutException.getMessage().equals("task " + pk + " timed out")
				&& timeoutException.getExpirationDate().equals(taskExpirationDate);
	}

	private void stopTaskEngine()
	{
		taskEngineWasRunningBefore = taskService.getEngine().isRunning();
		if (taskEngineWasRunningBefore)
		{
			taskService.getEngine().stop();
		}
	}

	private void restoreTaskEngine()
	{
		if (taskEngineWasRunningBefore)
		{
			taskService.getEngine().start();
		}
	}

	private void spyTaskEngineLogic()
	{
		final DBOutageTestTaskExecutionStrategy taskExecutionStrategy = DBOutageTestTaskExecutionStrategy.create(
				modelService, ScriptingTaskRunner.class, dbOutageSimulator::enable
		);
		taskExecutionStrategySpy = spy(taskExecutionStrategy);

		testTaskService = new DefaultTaskService();
		testTaskService.setModelService(modelService);
		testTaskService.setEventService(eventService);
		testTaskService.setStrandedTasksLogic(strandedTasksLogic);
		testTaskService.setTaskDao(taskDao);
		testTaskService.setMetricRegistry(metricRegistry);
		testTaskService.setScheduleAndTriggerStrategy(scheduleAndTriggerStrategy);
		testTaskService.setTaskEngineRetryTemplate(taskEngineRetryTemplate);
		testTaskService.setTasksProvider(tasksProvider);
		testTaskService.setTaskExecutionStrategies(List.of(taskExecutionStrategySpy));
	}

	private void cleanUpTaskEngineLogic()
	{
		if (testTaskService.getEngine().isRunning())
		{
			testTaskService.getEngine().stop();
		}
		testTaskService.setModelService(null);
		testTaskService.setEventService(null);
		testTaskService.setStrandedTasksLogic(null);
		testTaskService.setTaskDao(null);
		testTaskService.setMetricRegistry(null);
		testTaskService.setScheduleAndTriggerStrategy(null);
		testTaskService.setTaskEngineRetryTemplate(null);
		testTaskService.setTasksProvider(null);
		testTaskService.setTaskExecutionStrategies(List.of());
		testTaskService = null;
	}

	private void prepareDBOutageSimulator()
	{
		final HybrisDataSource dataSource = Registry.getCurrentTenant().getDataSource();
		assertThat(dataSource.getConnectionPool()).isInstanceOf(JUnitJDBCConnectionPool.class);
		connectionPool = (JUnitJDBCConnectionPool) dataSource.getConnectionPool();
		dbOutageSimulator = new DBOutageSimulator(connectionPool);
	}

	private void cleanUpDBOutageSimulator()
	{
		connectionPool.resetTestMode();
	}

	private TaskModel prepareTask(final String id, final boolean expired)
	{
		final ScriptModel script = modelService.create(ScriptModel.class);
		script.setCode(id);
		script.setActive(Boolean.TRUE);
		script.setContent("return new " + StrandedTasksDBOutageTest.NoOperationRunner.class.getName() + "();");
		modelService.save(script);

		final ScriptingTaskModel task = modelService.create(ScriptingTaskModel.class);
		task.setContext(id);
		task.setScriptURI("model://" + script.getCode());
		if (expired)
		{
			final Date scheduled = Date.from(Instant.now().minusSeconds(60L));
			final Date expires = Date.from(Instant.now().minusSeconds(1L));
			task.setExecutionDate(scheduled);
			task.setExpirationDate(expires);
		}
		else
		{
			task.setExecutionDate(new Date());
		}

		return task;
	}

	private TaskConditionModel prepareCondition(final TaskModel task, final String id)
	{
		final TaskConditionModel condition = modelService.create(TaskConditionModel.class);
		condition.setUniqueID(id);
		task.setConditions(Set.of(condition));
		return condition;
	}

	private void withTaskService(final Runnable runnable)
	{
		testTaskService.getEngine().start();
		try
		{
			runnable.run();
		}
		finally
		{
			dbOutageSimulator.disable();
			testTaskService.getEngine().stop();
		}
	}

	private boolean isInStrandedRegistry(final ItemModel itemModel)
	{
		return strandedTasksLogic.getStrandedItemsRegistry()
		                         .getStrandedItems()
		                         .contains(itemModel.getPk());
	}

	private boolean isNotInStrandedRegistry(final ItemModel itemModel)
	{
		return !isInStrandedRegistry(itemModel);
	}

	private <T extends ItemModel> void waitForAssert(final Duration timeout, final T item, final Predicate<T> check)
	{
		given().ignoreExceptions().await().pollInSameThread()
		       .timeout(timeout)
		       .untilAsserted(() -> assertThat(check.test(item)).isTrue());
	}

	private boolean isRemoved(final ItemModel item)
	{
		return modelService.isRemoved(item);
	}

	private boolean isMarkedAsFailed(final TaskModel task)
	{
		if (!isRemoved(task))
		{
			modelService.refresh(task);
		}
		return Optional.ofNullable(task.getFailed()).orElse(false);
	}

	private void assertLogsCreated(final PK pk, final String expectedMessage)
	{
		assertThat(pk).isNotNull();
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(expectedMessage + pk)
		                     .loggedFrom(StrandedTasksResolutionHandler.class)
		                     .withLogLevel(TestLogListenerAssert.LogLevel.INFO)
		                     .occurrences(1);
	}

	static class DBOutageTestTaskExecutionStrategy extends DefaultTaskExecutionStrategy
	{
		private final AtomicBoolean simulateErrorOnce = new AtomicBoolean();
		private Runnable dbSimulator;

		@Override
		public void finished(final TaskService taskService, final TaskRunner<TaskModel> runner, final TaskModel model,
		                     final Throwable error)
		{
			if (dbSimulator != null && simulateErrorOnce.compareAndSet(false, true))
			{
				dbSimulator.run();
			}
			super.finished(taskService, runner, model, error);
		}

		public void setDbSimulator(final Runnable dbSimulator)
		{
			this.dbSimulator = dbSimulator;
		}

		static DBOutageTestTaskExecutionStrategy create(final ModelService modelService,
		                                                final Class<? extends TaskRunner<? extends TaskModel>> runnerClass,
		                                                final Runnable dbSimulator)
		{
			final DBOutageTestTaskExecutionStrategy strategy = new DBOutageTestTaskExecutionStrategy();
			strategy.setModelService(modelService);
			strategy.setRunnerClass(runnerClass);
			strategy.setDbSimulator(dbSimulator);
			return strategy;
		}
	}

	static class NoOperationRunner implements TaskRunner<ScriptingTaskModel>
	{
		@Override
		public void run(final TaskService taskService, final ScriptingTaskModel task) throws RetryLaterException
		{
			// do nothing
		}

		@Override
		public void handleError(final TaskService taskService, final ScriptingTaskModel task, final Throwable error)
		{
			// do nothing
		}
	}
}
