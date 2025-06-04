/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.scripting.model.ScriptModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.impl.TaskDAO;
import de.hybris.platform.task.model.ScriptingTaskModel;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;


@IntegrationTest
public class TaskCacheInvalidationTest extends ServicelayerBaseTest
{
	private static final Logger LOG = Logger.getLogger(TaskCacheInvalidationTest.class.getName());

	private static final String TASK_DAO_FIELD = "dao";
	@Resource
	private ModelService modelService;

	private TaskDAO taskDAOToRestore;

	@Resource
	private TaskService taskService;

	private static ConcurrentMap<String, TaskStatus> taskStatus;
	private static ConcurrentMap<String, CountDownLatch> retryCounters;
	private static AtomicBoolean waitToProcess;
	private static final int UNASSIGNED_NODE = -1;
	private static final int TASK_DELAY_TIME = 3;

	@Before
	public void setUp()
	{
		taskStatus = new ConcurrentHashMap<>();
		retryCounters = new ConcurrentHashMap<>();
		waitToProcess = new AtomicBoolean(true);
		taskDAOToRestore = (TaskDAO) ReflectionTestUtils.getField(taskService, TASK_DAO_FIELD);
		modifyTaskDAO();
	}

	@After
	public void tearDown()
	{
		if (taskDAOToRestore != null)
		{
			ReflectionTestUtils.setField(taskService, TASK_DAO_FIELD, taskDAOToRestore);
		}
	}

	@Test
	public void shouldRefreshRunningOnClusterNodePropertyInTask()
	{
		final String id = UUID.randomUUID().toString();
		final TaskModel task = givenTestTask(id, DelayedExecutionTestRunner.class);

		taskService.scheduleTask(task);
		taskStatus.put(task.getPk().toString(), TaskStatus.PREPARED);
		assertThat(task.getRunningOnClusterNode()).isEqualTo(UNASSIGNED_NODE);

		waitForTask(TaskStatus.RUNNING, id);

		modelService.refresh(task);

		assertThat(task.getRunningOnClusterNode()).isNotEqualTo(UNASSIGNED_NODE);
		waitToProcess.set(false);

		waitForTask(TaskStatus.EXECUTED, id);
	}

	@Test
	public void shouldRefreshTaskWithCondition()
	{
		final String id = UUID.randomUUID().toString();
		final TaskModel task = givenTestTask(id, DelayedExecutionTestRunner.class);
		final TaskConditionModel condition = givenCondition(task);

		taskService.scheduleTask(task);
		taskStatus.put(task.getPk().toString(), TaskStatus.PREPARED);
		assertThat(task.getRunningOnClusterNode()).isEqualTo(UNASSIGNED_NODE);
		assertThat(condition.getConsumed()).isFalse();
		taskService.triggerEvent(id);

		waitForTask(TaskStatus.RUNNING, id);
		modelService.refresh(task);
		modelService.refresh(condition);

		assertThat(task.getRunningOnClusterNode()).isNotEqualTo(UNASSIGNED_NODE);
		assertThat(condition.getConsumed()).isTrue();
		waitToProcess.set(false);

		waitForTask(TaskStatus.EXECUTED, id);
		assertThatConditionIsFulfilled(condition);
	}

	@Test
	public void shouldRefreshTaskAfterUnlock() throws InterruptedException
	{
		final String id = UUID.randomUUID().toString();
		final TaskModel task = givenTestTask(id, ExecutionRetryDelayTestRunner.class);

		final CountDownLatch expectedRetriesCounter = new CountDownLatch(1);
		try
		{
			retryCounters.put(id, expectedRetriesCounter);
			LOG.info("Registered counter for " + id + " ( count: " + expectedRetriesCounter.getCount() + ")");

			taskService.scheduleTask(task);
			taskStatus.put(task.getPk().toString(), TaskStatus.PREPARED);
			assertThat(task.getRunningOnClusterNode()).isEqualTo(UNASSIGNED_NODE);

			waitForTask(TaskStatus.RUNNING, id);
			modelService.refresh(task);

			assertThat(task.getRunningOnClusterNode()).isNotEqualTo(UNASSIGNED_NODE);
			waitToProcess.set(false);

			waitForTask(TaskStatus.DELAYED, task.getPk().toString());
			modelService.refresh(task);

			assertThat(task.getRunningOnClusterNode()).isEqualTo(UNASSIGNED_NODE);
			waitToProcess.set(false);
			assertThat(expectedRetriesCounter.await(1, TimeUnit.MINUTES)).withFailMessage("didn't perform retry before 1 minute")
			                                                             .isTrue();

			waitForTask(TaskStatus.EXECUTED, id);
		}
		finally
		{
			retryCounters.remove(id);
		}
	}

	@Test
	public void shouldRefreshTaskWithConditionAfterUnlock() throws InterruptedException
	{
		final String id = UUID.randomUUID().toString();
		final TaskModel task = givenTestTask(id, ExecutionRetryDelayTestRunner.class);
		final TaskConditionModel condition = givenCondition(task);

		final CountDownLatch expectedRetriesCounter = new CountDownLatch(1);
		try
		{
			retryCounters.put(id, expectedRetriesCounter);
			LOG.info("Registered counter for " + id + " ( count: " + expectedRetriesCounter.getCount() + ")");

			taskService.scheduleTask(task);
			taskStatus.put(task.getPk().toString(), TaskStatus.PREPARED);
			assertThat(task.getRunningOnClusterNode()).isEqualTo(UNASSIGNED_NODE);
			assertThat(condition.getConsumed()).isFalse();
			taskService.triggerEvent(id);

			waitForTask(TaskStatus.RUNNING, id);
			modelService.refresh(task);
			modelService.refresh(condition);

			assertThat(task.getRunningOnClusterNode()).isNotEqualTo(UNASSIGNED_NODE);
			assertThat(condition.getConsumed()).isTrue();
			waitToProcess.set(false);

			waitForTask(TaskStatus.DELAYED, task.getPk().toString());
			modelService.refresh(task);

			assertThat(task.getRunningOnClusterNode()).isEqualTo(UNASSIGNED_NODE);
			waitToProcess.set(false);
			assertThat(expectedRetriesCounter.await(1, TimeUnit.MINUTES)).withFailMessage("didn't perform retry before 1 minute")
			                                                             .isTrue();

			waitForTask(TaskStatus.EXECUTED, id);
			assertThatConditionIsFulfilled(condition);
		}
		finally
		{
			retryCounters.remove(id);
		}
	}

	private void assertThatConditionIsFulfilled(final TaskConditionModel condition)
	{
		await().atMost(10, TimeUnit.SECONDS).until(() -> modelService.isRemoved(condition));
		assertThat(modelService.isRemoved(condition)).overridingErrorMessage(
				"Condition was expected to be removed, but it wasn't.").isTrue();
	}

	private <T extends TaskRunner> TaskModel givenTestTask(final String id, final Class<T> taskRunnerClass)
	{
		final ScriptModel script = modelService.create(ScriptModel.class);
		script.setCode(id);
		script.setActive(Boolean.TRUE);
		script.setContent("return new " + taskRunnerClass.getName() + "(\"" + id + "\");");
		modelService.save(script);

		final ScriptingTaskModel task = modelService.create(ScriptingTaskModel.class);
		task.setContext(id);
		task.setScriptURI("model://" + script.getCode());
		task.setExecutionDate(getDelayedExecutionDateToAvoidRaceCondition());

		taskStatus.put(id, TaskStatus.PREPARED);
		return task;
	}

	private Date getDelayedExecutionDateToAvoidRaceCondition(){
		return Date.from(Instant.now().plus(TASK_DELAY_TIME, ChronoUnit.SECONDS));
	}

	private TaskConditionModel givenCondition(final TaskModel task)
	{
		final TaskConditionModel condition = modelService.create(TaskConditionModel.class);

		condition.setCounter(1);
		condition.setUniqueID((String) task.getContext());

		task.setConditions(Collections.singleton(condition));

		return condition;
	}

	private void waitForTask(final TaskStatus expectedStatus, final String id)
	{
		await().atMost(30, TimeUnit.SECONDS).until(() -> taskStatus.get(id).equals(expectedStatus));
		assertThat(taskStatus).containsEntry(id, expectedStatus);
	}

	private void modifyTaskDAO()
	{
		final TaskDAO dao = new TestTaskDAO(Registry.getCurrentTenantNoFallback());
		ReflectionTestUtils.setField(taskService, TASK_DAO_FIELD, dao);
	}

	public static class DelayedExecutionTestRunner implements TaskRunner<ScriptingTaskModel>
	{
		private final String executionId;

		public DelayedExecutionTestRunner(final String executionId)
		{
			this.executionId = Objects.requireNonNull(executionId);
		}

		@Override
		public void run(final TaskService taskService, final ScriptingTaskModel task) throws RetryLaterException
		{
			taskStatus.put(executionId, TaskStatus.RUNNING);
			await().atMost(10, TimeUnit.SECONDS).until(() -> !waitToProcess.get());
			taskStatus.put(executionId, TaskStatus.EXECUTED);
		}

		@Override
		public void handleError(final TaskService taskService, final ScriptingTaskModel task, final Throwable error)
		{
		}
	}

	public static final class ExecutionRetryDelayTestRunner implements TaskRunner<ScriptingTaskModel>
	{
		private final String executionId;

		public ExecutionRetryDelayTestRunner(final String executionId)
		{
			this.executionId = Objects.requireNonNull(executionId);
		}

		@Override
		public void run(final TaskService taskService, final ScriptingTaskModel task) throws RetryLaterException
		{
			LOG.info(
					TaskRetryTest.RetryDelayTaskRunner.class.getSimpleName() + ".run(" + task + " context:" + task.getContext() + " retry:" + task.getRetry() + ")");
			taskStatus.put(executionId, TaskStatus.RUNNING);
			await().atMost(10, TimeUnit.SECONDS).until(() -> !waitToProcess.get());

			if (retryCounters.get(executionId) != null && retryCounters.get(executionId).getCount() > 0)
			{
				retryCounters.get(executionId).countDown();
				waitToProcess.set(true);

				final RetryLaterException later = new RetryLaterException();
				later.setMethod(RetryLaterException.Method.LINEAR);
				later.setDelay(TimeUnit.SECONDS.toMillis(TASK_DELAY_TIME));
				throw later;
			}
			taskStatus.put(executionId, TaskStatus.EXECUTED);
		}

		@Override
		public void handleError(final TaskService taskService, final ScriptingTaskModel task, final Throwable error)
		{
			LOG.error(
					TaskRetryTest.RetryDelayTaskRunner.class.getSimpleName() + ".handleError( context:" + task.getContext() + ")",
					error);
		}
	}

	private enum TaskStatus
	{
		PREPARED, RUNNING, EXECUTED, DELAYED
	}

	private class TestTaskDAO extends TaskDAO
	{

		public TestTaskDAO(final Tenant t)
		{
			super(t);
		}

		@Override
		public void unlock(final Long pk)
		{
			super.unlock(pk);
			if (waitToProcess.get())
			{
				taskStatus.put(pk.toString(), TaskStatus.DELAYED);
			}
		}
	}
}
