package de.hybris.platform.processengine.synchronus;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.definition.ProcessDefinition;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.definition.ProcessDefinitionId;
import de.hybris.platform.processengine.helpers.ProcessParameterHelper;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.model.DynamicProcessDefinitionModel;
import de.hybris.platform.processengine.model.ProcessTaskModel;
import de.hybris.platform.processengine.process.ProcessengineTaskRunner;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.task.RetryLaterException;
import de.hybris.platform.task.TaskService;
import de.hybris.platform.testframework.BulkPropertyConfigSwitcher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@IntegrationTest
public class SynchProcessRefreshTaskIntegrationTest extends AbstractProcessEngineIntegrationTest
{
	BulkPropertyConfigSwitcher bulkPropertyConfigSwitcher = new BulkPropertyConfigSwitcher();
	@Resource
	private ModelService modelService;
	@Resource
	private BusinessProcessService businessProcessService;
	@Resource
	private TaskService taskService;
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;
	@Resource
	private ProcessParameterHelper processParameterHelper;
	@Resource
	private TransactionTemplate transactionTemplate;
	@Resource
	private SessionService sessionService;
	@Resource
	private UserService userService;
	private boolean restartTaskEngine = false;

	@Before
	public void setUp()
	{

	}

	private void stopTaskEngine()
	{
		if (taskService.getEngine().isRunning())
		{
			taskService.getEngine().stop();
			restartTaskEngine = true;
		}
	}

	@After
	public void tearDown() throws Exception
	{
		bulkPropertyConfigSwitcher.switchAllBack();

		if (!taskService.getEngine().isRunning() && restartTaskEngine)
		{
			taskService.getEngine().start();
		}
	}

	@Test
	public void shouldRetryRefreshingOnceWhenTaskIsNotUpToDate()
	{
		setNumberOfRefreshRetriesProperty(1);
		// expected 3 refreshes, because 1 refresh before processing and 1 refresh + 1 retry after processing
		testRetryLaterExceptionThrownAfterNRetries(3);
	}


	@Test
	public void shouldRetryRefreshingFiveTimesWhenTaskIsNotUpToDate()
	{
		setNumberOfRefreshRetriesProperty(5);
		// expected 6 refreshes, because 1 refresh before processing and 1 refresh + 5 retries after processing
		testRetryLaterExceptionThrownAfterNRetries(7);
	}


	@Test
	public void shouldNotRetryRefreshingWhenTaskIsNotUpToDateAndPropertyIsZero()
	{
		setNumberOfRefreshRetriesProperty(0);
		// expected 2 refreshes, because 1 refresh before processing and 1 refresh after processing (no retries)
		testRetryLaterExceptionThrownAfterNRetries(2);
	}

	@Test
	public void shouldNotRetryRefreshingWhenTaskIsNotUpToDateAndPropertyIsNegative()
	{
		setNumberOfRefreshRetriesProperty(-1);
		// expected 2 refreshes, because 1 refresh before processing and 1 refresh after processing (no retries)
		testRetryLaterExceptionThrownAfterNRetries(2);
	}

	@Test
	public void shouldRetryRefreshingDefaultNumberOfTimesWhenTaskIsNotUpToDateAndPropertyIsNotSet()
	{
		setNumberOfRefreshRetriesProperty("");
		// expected 3 refreshes, because 1 refresh before processing and 1 refresh + 1 retry (default value)
		testRetryLaterExceptionThrownAfterNRetries(3);
	}


	@Test
	public void shouldRetryRefreshingDefaultNumberOfTimesWhenTaskIsNotUpToDateAndPropertyIsInvalid()
	{
		setNumberOfRefreshRetriesProperty("notANumber");
		// expected 3 refreshes, because 1 refresh before processingand 1 refresh + 1 retry (default value)
		testRetryLaterExceptionThrownAfterNRetries(3) ;
	}


	private void testRetryLaterExceptionThrownAfterNRetries(final int wantedNumberOfRefreshes)
	{
		stopTaskEngine();

		final ModelService spyModelService = spy(modelService);
		final ProcessengineTaskRunner processengineTaskRunner = getProcessEngineTaskRunner(
				runner -> runner.setModelService(spyModelService));

		final BusinessProcessModel businessProcessModel = givenBusinessProcess("""
				<?xml version='1.0' encoding='utf-8'?>
				<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='%s'>
					<scriptAction id='action0'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='action1'/>
					</scriptAction>
					<scriptAction id='action1'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='success'/>
					</scriptAction>
					<end id='success' state='SUCCEEDED'>Everything was fine</end>
				</process>
				""".formatted(RandomStringUtils.insecure().nextAlphabetic(15)));

		final ProcessTaskModel processTaskModel = modelService.create(ProcessTaskModel.class);
		processTaskModel.setAction("action0");
		processTaskModel.setProcess(businessProcessModel);
		processTaskModel.setRunnerBean("taskRunner");

		modelService.save(processTaskModel);

		when(spyModelService.isUpToDate(processTaskModel)).thenReturn(false);

		assertThatThrownBy(() -> processengineTaskRunner.run(taskService, processTaskModel)).isInstanceOf(
				RetryLaterException.class);

		verify(spyModelService, times(wantedNumberOfRefreshes)).refresh(processTaskModel);
	}

	@Test
	public void shouldWaitIfConsecutiveRefreshes()
	{
		final Duration expectedMinDelayBetweenRefreshes = Duration.ofMillis(500);
		setRefreshDelayProperty(expectedMinDelayBetweenRefreshes);
		testRefreshInterval(expectedMinDelayBetweenRefreshes);
	}

	@Test
	public void shouldWaitMinimalAmountWhenConfiguredValueIsZero()
	{
		setRefreshDelayProperty(Duration.ZERO);
		testRefreshInterval(Duration.ofMillis(10));
	}

	@Test
	public void shouldWaitMinimalDurationWhenConfiguredValueIsNegative()
	{
		setRefreshDelayProperty(Duration.ofMillis(-200));
		testRefreshInterval(Duration.ofMillis(10));
	}

	@Test
	public void shouldWaitDefaultDurationWhenConfiguredValueIsInvalid()
	{
		setRefreshDelayProperty("notANumber");
		testRefreshInterval(Duration.ofMillis(100));
	}

	private void testRefreshInterval(final Duration expectedMinDelayBetweenRefreshes)
	{
		testRefreshInterval(expectedMinDelayBetweenRefreshes, expectedMinDelayBetweenRefreshes.plusMillis(50));
	}

	private void testRefreshInterval(final Duration expectedMinDelayBetweenRefreshes,
	                                 final Duration expectedMaxDelayBetweenRefreshes)
	{
		stopTaskEngine();
		setNumberOfRefreshRetriesProperty("5");

		final ModelService spyModelService = spy(modelService);
		final ProcessengineTaskRunner processengineTaskRunner = getProcessEngineTaskRunner(
				runner -> runner.setModelService(spyModelService));

		final BusinessProcessModel businessProcessModel = givenBusinessProcess("""
				<?xml version='1.0' encoding='utf-8'?>
				<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='%s'>
					<scriptAction id='action0'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='action1'/>
					</scriptAction>
					<scriptAction id='action1'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='success'/>
					</scriptAction>
					<end id='success' state='SUCCEEDED'>Everything was fine</end>
				</process>
				""".formatted(RandomStringUtils.insecure().nextAlphabetic(15)));

		final ProcessTaskModel processTaskModel = modelService.create(ProcessTaskModel.class);
		processTaskModel.setAction("action0");
		processTaskModel.setProcess(businessProcessModel);
		processTaskModel.setRunnerBean("taskRunner");

		modelService.save(processTaskModel);

		final List<Instant> refreshTimes = new ArrayList<>();

		when(spyModelService.isUpToDate(processTaskModel)).then(invocationOnMock -> {
			refreshTimes.add(Instant.now());
			return false;
		});

		assertThatThrownBy(() -> processengineTaskRunner.run(taskService, processTaskModel)).isInstanceOf(
				RetryLaterException.class);

		assertThat(refreshTimes).size().isGreaterThan(2);

		//start from the third element to get interval between 3rd and 2nd refresh - first one is done before processing af an item
		for (int i = 2; i < refreshTimes.size(); i++)
		{
			final Duration between = Duration.between(refreshTimes.get(i - 1), refreshTimes.get(i));
			assertThat(between).isBetween(expectedMinDelayBetweenRefreshes, expectedMaxDelayBetweenRefreshes);
		}
	}

	@Test
	public void shouldThrowRetryLaterExceptionWithDelaySetAsConfigured()
	{
		final Duration expectedRetryLaterDelay = Duration.ofSeconds(50);
		setRetryLaterExceptionDelayProperty(expectedRetryLaterDelay);

		testRetryLaterExceptionDelay(expectedRetryLaterDelay);
	}

	@Test
	public void shouldThrowRetryLaterExceptionWithMinimalDelayWhenConfiguredValueIsTooSmall()
	{
		setRetryLaterExceptionDelayProperty(Duration.ofSeconds(4));
		testRetryLaterExceptionDelay(Duration.ofSeconds(5));
	}

	@Test
	public void shouldThrowRetryLaterExceptionWithMinimalDelayWhenConfiguredValueIsZero()
	{
		setRetryLaterExceptionDelayProperty(Duration.ofSeconds(0));
		testRetryLaterExceptionDelay(Duration.ofSeconds(5));
	}

	@Test
	public void shouldThrowRetryLaterExceptionWithMinimalDelayWhenConfiguredValueIsNegative()
	{
		setRetryLaterExceptionDelayProperty(Duration.ofSeconds(-10));
		testRetryLaterExceptionDelay(Duration.ofSeconds(5));
	}

	@Test
	public void shouldThrowRetryLaterExceptionWithDefaultDelayWhenConfiguredValueIsInvalid()
	{
		setRetryLaterExceptionDelayProperty("notANumber");
		testRetryLaterExceptionDelay(Duration.ofSeconds(10));
	}

	private void testRetryLaterExceptionDelay(final Duration expectedRetryLaterDelay)
	{
		stopTaskEngine();
		setNumberOfRefreshRetriesProperty(0);

		final ModelService spyModelService = spy(modelService);
		final ProcessengineTaskRunner processengineTaskRunner = getProcessEngineTaskRunner(
				runner -> runner.setModelService(spyModelService));

		final BusinessProcessModel businessProcessModel = givenBusinessProcess("""
				<?xml version='1.0' encoding='utf-8'?>
				<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='%s'>
					<scriptAction id='action0'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='action1'/>
					</scriptAction>
					<scriptAction id='action1'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='success'/>
					</scriptAction>
					<end id='success' state='SUCCEEDED'>Everything was fine</end>
				</process>
				""".formatted(RandomStringUtils.insecure().nextAlphabetic(15)));

		final ProcessTaskModel processTaskModel = modelService.create(ProcessTaskModel.class);
		processTaskModel.setAction("action0");
		processTaskModel.setProcess(businessProcessModel);
		processTaskModel.setRunnerBean("taskRunner");

		modelService.save(processTaskModel);

		when(spyModelService.isUpToDate(processTaskModel)).thenReturn(false);

		assertThatThrownBy(() -> processengineTaskRunner.run(taskService, processTaskModel)).isInstanceOf(
				                                                                                    RetryLaterException.class)
		                                                                                    .satisfies(e -> assertThat(
				                                                                                    ((RetryLaterException) e).getDelay()).isEqualTo(
				                                                                                    expectedRetryLaterDelay.toMillis()));
	}

	@Test
	public void shouldProcessTaskAfterSuccessfulFirstRefresh()
	{
		setNumberOfRefreshRetriesProperty("1");
		testNoExceptionThrownAfterNFailedRetriesAndThenProperRefresh(0, 2);
	}

	@Test
	public void shouldProcessTaskAfterSuccessfulSecondRefresh()
	{
		setNumberOfRefreshRetriesProperty("1");
		testNoExceptionThrownAfterNFailedRetriesAndThenProperRefresh(1, 3);
	}

	private void testNoExceptionThrownAfterNFailedRetriesAndThenProperRefresh(final int numberOfFailedRefreshes,
	                                                                          final int wantedNumberOfRefreshes)
	{
		stopTaskEngine();

		final ModelService spyModelService = spy(modelService);
		final ProcessengineTaskRunner processengineTaskRunner = getProcessEngineTaskRunner(
				runner -> runner.setModelService(spyModelService));

		final BusinessProcessModel businessProcessModel = givenBusinessProcess("""
				<?xml version='1.0' encoding='utf-8'?>
				<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='%s'>
					<scriptAction id='action0'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='success'/>
					</scriptAction>
					<end id='success' state='SUCCEEDED'>Everything was fine</end>
				</process>
				""".formatted(RandomStringUtils.insecure().nextAlphabetic(15)));

		final ProcessTaskModel processTaskModel = modelService.create(ProcessTaskModel.class);
		processTaskModel.setAction("action0");
		processTaskModel.setProcess(businessProcessModel);
		processTaskModel.setRunnerBean("taskRunner");

		modelService.save(processTaskModel);

		final AtomicInteger counter = new AtomicInteger();
		when(spyModelService.isUpToDate(processTaskModel)).then(iom -> counter.getAndIncrement() >= numberOfFailedRefreshes);

		processengineTaskRunner.run(taskService, processTaskModel);

		verify(spyModelService, times(wantedNumberOfRefreshes)).refresh(processTaskModel);
	}

	@Test
	public void shouldContinueSyncProcessExecutionAfterSingleFailedRefresh()
	{
		stopTaskEngine();

		setNumberOfRefreshRetriesProperty(1);

		final ModelService spyModelService = spy(modelService);
		final ProcessDefinitionFactory spyProcessDefinitionFactory = spy(processDefinitionFactory);
		final ProcessengineTaskRunner processengineTaskRunner = getProcessEngineTaskRunner(runner -> {
			runner.setModelService(spyModelService);
			runner.setProcessDefinitionFactory(spyProcessDefinitionFactory);
		});

		final String processName = RandomStringUtils.insecure().nextAlphabetic(15);
		final BusinessProcessModel businessProcessModel = givenBusinessProcess("""
				<?xml version='1.0' encoding='utf-8'?>
				<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='%s'>
					<scriptAction id='action0' canJoinPreviousNode='true'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='action1'/>
					</scriptAction>
					<scriptAction id='action1' canJoinPreviousNode='true'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='action2'/>
					</scriptAction>
					<scriptAction id='action2' canJoinPreviousNode='true'>
						<script type='groovy'>return 'itworks';</script>
						<transition name='itworks' to='success'/>
					</scriptAction>
					<end id='success' state='SUCCEEDED'>Everything was fine</end>
				</process>
				""".formatted(processName));

		final ProcessDefinitionId processDefinitionId = ProcessDefinitionId.of(businessProcessModel);
		final ProcessDefinition spyProcessDefinition = spy(processDefinitionFactory.getProcessDefinition(processDefinitionId));

		doReturn(spyProcessDefinition).when(spyProcessDefinitionFactory).getProcessDefinition(processDefinitionId);

		final ProcessTaskModel processTaskModel = modelService.create(ProcessTaskModel.class);
		processTaskModel.setAction("action0");
		processTaskModel.setProcess(businessProcessModel);
		processTaskModel.setRunnerBean("taskRunner");

		modelService.save(processTaskModel);

		when(spyModelService.isUpToDate(processTaskModel)).thenReturn( false, true, false, true, false, true);

		processengineTaskRunner.run(taskService, processTaskModel);

		final ArgumentCaptor<String> actionIdsArgumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(spyProcessDefinition, atLeastOnce()).retrieve(actionIdsArgumentCaptor.capture());

		assertThat(actionIdsArgumentCaptor.getAllValues()).containsOnly("action0", "action1", "action2");
		// (one refresh before processing, one failed after, once successful after) * 3 actions
		verify(spyModelService, times(9)).refresh(processTaskModel);
	}


	private ProcessengineTaskRunner getProcessEngineTaskRunner(final Consumer<ProcessengineTaskRunner> customizer)
	{
		final ProcessengineTaskRunner processengineTaskRunner = new ProcessengineTaskRunner();
		processengineTaskRunner.setApplicationContext(Registry.getApplicationContext());

		processengineTaskRunner.setJdbcTemplate(jdbcTemplate);
		processengineTaskRunner.setModelService(modelService);
		processengineTaskRunner.setProcessDefinitionFactory(processDefinitionFactory);
		processengineTaskRunner.setProcessParameterHelper(processParameterHelper);
		processengineTaskRunner.setSessionService(sessionService);
		processengineTaskRunner.setTransactionTemplate(transactionTemplate);
		processengineTaskRunner.setUserService(userService);

		customizer.accept(processengineTaskRunner);

		processengineTaskRunner.afterPropertiesSet();
		return processengineTaskRunner;
	}


	private BusinessProcessModel givenBusinessProcess(final String content)
	{
		final String trimmedContent = content.trim();
		final String code = extractCodeFromContent(trimmedContent);

		final DynamicProcessDefinitionModel definition = modelService.create(DynamicProcessDefinitionModel.class);
		definition.setContent(trimmedContent);
		definition.setCode(code);
		modelService.save(definition);

		return businessProcessService.createProcess(UUID.randomUUID().toString(), code);
	}

	private String extractCodeFromContent(final String content)
	{
		try
		{
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(false);
			final Document document = factory.newDocumentBuilder()
			                                 .parse(IOUtils.toInputStream(content.trim(), StandardCharsets.UTF_8));

			final XPathExpression expr = XPathFactory.newInstance().newXPath().compile("/process/@name");
			final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

			if (nodes.getLength() != 1)
			{
				throw new IllegalArgumentException(
						"Expecting one process name in the xml content (found %d)".formatted(nodes.getLength()));
			}

			return nodes.item(0).getNodeValue();
		}
		catch (final XPathExpressionException | ParserConfigurationException | SAXException | IOException e)
		{
			throw new RuntimeException(e);
		}

	}

	private void setRefreshDelayProperty(final Duration value)
	{
		setRefreshDelayProperty(String.valueOf(value.toMillis()));
	}

	private void setRefreshDelayProperty(final String value)
	{
		bulkPropertyConfigSwitcher.switchToValue(ProcessengineTaskRunner.PROPERTY_TASK_REFRESH_RETRY_DELAY_MS, value);
	}

	private void setNumberOfRefreshRetriesProperty(final String value)
	{
		bulkPropertyConfigSwitcher.switchToValue(ProcessengineTaskRunner.PROPERTY_TASK_REFRESH_RETRY_MAX_TRIES, value);
	}

	private void setNumberOfRefreshRetriesProperty(final long value)
	{
		setNumberOfRefreshRetriesProperty(String.valueOf(value));
	}

	private void setRetryLaterExceptionDelayProperty(final Duration expectedRetryLaterDelay)
	{
		setRetryLaterExceptionDelayProperty(String.valueOf(expectedRetryLaterDelay.getSeconds()));
	}

	private void setRetryLaterExceptionDelayProperty(final String value)
	{
		bulkPropertyConfigSwitcher.switchToValue(ProcessengineTaskRunner.PROPERTY_TASK_RETRY_LATER_DELAY_S, value);
	}
}
