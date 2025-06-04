/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.task.impl.gateways;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.task.TaskService;
import de.hybris.platform.task.impl.AuxiliaryTablesGatewayFactory;
import de.hybris.platform.task.impl.AuxiliaryTablesSchedulerRole;
import de.hybris.platform.task.impl.AuxiliaryTablesTaskProviderTestHelper;
import de.hybris.platform.task.impl.DefaultTaskServiceBaseTest;
import de.hybris.platform.task.impl.TasksProvider;
import de.hybris.platform.util.Config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.codahale.metrics.MetricRegistry;

@IntegrationTest
public class MsSqlTasksQueueGatewayTest extends DefaultTaskServiceBaseTest
{

	protected static final int RANGE_START = 0;
	protected static final int RANGE_END = 1000;
	protected static final int NUMBER_OF_TASKS = 2000;
	protected static final int AMOUNT_OF_NODES = 20;
	protected static final int NODE_BUCKET_SIZE = (RANGE_END - RANGE_START) / AMOUNT_OF_NODES;

	/**
	 * Param used to define threshold below which, the set of integers should not be considered as randomised anymore, which should lead to test fail as a consequence.
	 * It represents ratio of amount of numbers that were used and assigned to tasks to the amount of all available numbers from the range.
	 * 1 - means that all possible numbers from predefined range, were assigned to tasks.
	 * 0,7 - means that only 70% of all possible numbers were used.
	 * E.g. For the ratio 0.6 and range 1-1000, if there will be only 590 numbers used the test should fail, but for 610, it should pass.
	 */
	protected static final double MIN_DISTRIBUTION_THRESHOLD = 0.6;
	/**
	 * Param used to define maximum numbers of range_values that stays the same between first and second generation of random numbers for range_values.
	 * To ensure proper distribution of tasks between nodes, we need to ensure that range_values are random. If the output random numbers are the same
	 * or close to the same between generations, it means the randomisation process is broken.
	 */
	protected static final int MAX_ALLOWED_RECURRING_RANGE_VALUES_AS_PERCENTAGE = 10;
	protected static final int MAX_ALLOWED_RECURRING_RANGE_VALUES = (MAX_ALLOWED_RECURRING_RANGE_VALUES_AS_PERCENTAGE * NUMBER_OF_TASKS) / 100;

	/**
	 * The maximum standard deviation of the distribution of tasks among nodes.
	 *
	 * This constant specifies the acceptable upper limit for the variability
	 * in the number of tasks assigned to each node in a distributed system.
	 * It is used to ensure that the load is nearly evenly distributed across
	 * all nodes. A lower standard deviation indicates a more uniform distribution
	 * of tasks, which is generally desired to optimize resource utilization and
	 * performance.
	 */
	protected static final double MAX_STANDARD_DEVIATION_FOR_TASK_DISTRIBUTION_AMONG_NODES = 50;

	protected static final String NODE_GROUP = "testNodeGroup";
	protected static final String COUNT_TASKS_PER_NODE_QUERY = "SELECT COUNT(*) FROM %s WHERE RANGE_VALUE BETWEEN %s AND %s";

	private static final Logger LOGGER = LoggerFactory.getLogger(MsSqlTasksQueueGatewayTest.class);


	@Resource
	private AuxiliaryTablesGatewayFactory auxiliaryTablesGatewayFactory;
	@Resource
	private MetricRegistry metricRegistry;
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private TypeService typeService;
	@Resource
	private TaskService taskService;

	private TestSchedulerRole schedulerRole;
	private TasksQueueGateway gateway;
	private AuxiliaryTablesTaskProviderTestHelper testHelper;

	@BeforeClass
	public static void beforeAll()
	{
		assumeThat(Config.getDatabaseName(), is(Config.DatabaseName.SQLSERVER));
	}

	@Before
	public void setUp()
	{
		testHelper = new AuxiliaryTablesTaskProviderTestHelper(taskService, jdbcTemplate, typeService,
				auxiliaryTablesGatewayFactory, modelService);
		testHelper.disableTaskEngine();
		schedulerRole = new TestSchedulerRole(auxiliaryTablesGatewayFactory, metricRegistry, typeService);
		gateway = auxiliaryTablesGatewayFactory.getTasksQueueGateway();

		prepareTable(gateway);
		testHelper.prepareTasks(NUMBER_OF_TASKS, NODE_GROUP);
	}

	@After
	public void tearDown()
	{
		testHelper.cleanUpTasks();
		testHelper.enableTaskEngine();
	}

	/**
	 * The aim of this test is to verify that the pseudo-random numbers assigned to the range_value's attribute
	 * meet criteria for sufficient randomness. This is measured by passing the {@link MsSqlTasksQueueGatewayTest#MIN_DISTRIBUTION_THRESHOLD}.
	 * Ensuring this level of randomness is crucial for equal allocation of tasks among nodes
	 */
	@Test
	public void shouldAssignProperlyDistributedRangeToTasksWhenSchedulingThemInAuxTaskQueue()
	{
		gateway.addTasks(schedulerRole.getTasksQuery(RANGE_START, RANGE_END),
				schedulerRole.getExpiredTasksQuery(RANGE_START, RANGE_END), Instant.now(), RANGE_START, RANGE_END);
		final List<Integer> rangeList = jdbcTemplate.queryForList("SELECT RANGE_VALUE FROM " + gateway.getTableName(),
				Integer.class);
		final double rangeOccupancyFactor = calculateRangeOccupancyFactor(rangeList);

		assertThat(rangeOccupancyFactor).isGreaterThan(MIN_DISTRIBUTION_THRESHOLD);
	}

	@Test
	public void shouldEvenlyDistributeTasksBetweenNodes()
	{
		gateway.addTasks(schedulerRole.getTasksQuery(RANGE_START, RANGE_END),
				schedulerRole.getExpiredTasksQuery(RANGE_START, RANGE_END), Instant.now(), RANGE_START, RANGE_END);
		final SummaryStatistics stats = new SummaryStatistics();
		for (int i = RANGE_START; i < RANGE_END; i = i + NODE_BUCKET_SIZE)
		{
			final String countTasksPerGivenNodeQuery = String.format(COUNT_TASKS_PER_NODE_QUERY, gateway.getTableName(), i,
					i + NODE_BUCKET_SIZE - 1);
			final Integer numberOfTasksInBucket = jdbcTemplate.queryForObject(countTasksPerGivenNodeQuery, Integer.class);
			stats.addValue(
					Optional.ofNullable(numberOfTasksInBucket)
					        .orElseThrow(() -> new IllegalStateException("Expected non-null value")));
		}

		assertThat(stats.getStandardDeviation()).isLessThan(MAX_STANDARD_DEVIATION_FOR_TASK_DISTRIBUTION_AMONG_NODES);
	}

	@Test
	public void shouldAssignDifferentValueRangeEachTimeTaskIsTransferredToAuxiliaryTable()
	{
		gateway.addTasks(schedulerRole.getTasksQuery(RANGE_START, RANGE_END),
				schedulerRole.getExpiredTasksQuery(RANGE_START, RANGE_END), Instant.now(), RANGE_START, RANGE_END);

		final List<TasksAuxiliaryQueueModel> primaryAuxTasks = getAllTasksFromAuxTable();

		prepareTable(gateway);
		gateway.addTasks(schedulerRole.getTasksQuery(RANGE_START, RANGE_END),
				schedulerRole.getExpiredTasksQuery(RANGE_START, RANGE_END), Instant.now(), RANGE_START, RANGE_END);

		final List<TasksAuxiliaryQueueModel> secondaryAuxTasks = getAllTasksFromAuxTable();

		final List<TasksAuxiliaryQueueModel> tasksWithRecurringRandomValues = primaryAuxTasks.stream()
		                                                                                    .filter(secondaryAuxTasks::contains)
		                                                                                    .toList();

		assertThat(tasksWithRecurringRandomValues.size()).isLessThan(MAX_ALLOWED_RECURRING_RANGE_VALUES);
	}

	protected double calculateRangeOccupancyFactor(final List<Integer> rangeList)
	{
		final Set<Integer> rangeSet = new HashSet<>(rangeList);
		return ((double) rangeSet.size()) / (RANGE_END - RANGE_START);
	}

	protected void assertTableExists(final String tableName)
	{

		testHelper.assertTableExists(tableName);
	}

	protected void prepareTable(final BaseGateway gateway)
	{
		cleanUpTable(gateway);
		gateway.createTable();
		assertTableExists(gateway.getTableName());
	}

	protected void cleanUpTable(final BaseGateway gateway)
	{
		try
		{
			gateway.dropTable();
		}
		catch (final Exception e)
		{
			LOGGER.warn("exception while dropping table {}", gateway.getTableName(), e);
		}
	}

	private List<TasksAuxiliaryQueueModel> getAllTasksFromAuxTable()
	{

		return jdbcTemplate.query("SELECT PK, RANGE_VALUE FROM " + gateway.getTableName(),
				new RowMapper<TasksAuxiliaryQueueModel>()
				{
					@Override
					public TasksAuxiliaryQueueModel mapRow(final ResultSet rs, final int rowNum) throws SQLException
					{
						final TasksAuxiliaryQueueModel task = new TasksAuxiliaryQueueModel();
						task.setPk(rs.getLong(1));
						task.setRangeValue(rs.getInt(2));
						return task;
					}
				});
	}

	@Override
	protected TasksProvider getTasksProvider()
	{
		return null;
	}

	private static class TestSchedulerRole extends AuxiliaryTablesSchedulerRole
	{

		public TestSchedulerRole(final AuxiliaryTablesGatewayFactory gatewayFactory, final MetricRegistry metricRegistry,
		                         final TypeService typeService)
		{
			this.setGatewayFactory(gatewayFactory);
			this.setMetricRegistry(metricRegistry);
			this.setTypeService(typeService);
		}

		@Override
		protected String getConditionsQuery()
		{
			return super.getConditionsQuery();
		}

		@Override
		protected String getExpiredTasksQuery(final int rangeStart, final int rangeEnd)
		{
			return super.getExpiredTasksQuery(rangeStart, rangeEnd);
		}

		@Override
		protected String getTasksQuery(final int rangeStart, final int rangeEnd, final boolean processTriggerTask)
		{
			return super.getTasksQuery(rangeStart, rangeEnd, processTriggerTask);
		}

		@Override
		protected String getTasksQuery(final int rangeStart, final int rangeEnd)
		{
			return super.getTasksQuery(rangeStart, rangeEnd);
		}
	}

	private static class TasksAuxiliaryQueueModel
	{
		long pk;
		int rangeValue;

		public void setPk(final long pk)
		{
			this.pk = pk;
		}

		public void setRangeValue(final int rangeValue)
		{
			this.rangeValue = rangeValue;
		}

		public long getPk()
		{
			return pk;
		}

		public int getRangeValue()
		{
			return rangeValue;
		}

		@Override
		public boolean equals(final Object o)
		{
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			final TasksAuxiliaryQueueModel that = (TasksAuxiliaryQueueModel) o;
			return pk == that.pk && rangeValue == that.rangeValue;
		}
	}

}
