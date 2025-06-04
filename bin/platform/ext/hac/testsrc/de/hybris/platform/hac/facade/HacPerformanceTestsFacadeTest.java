/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.hac.facade;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.jdbcwrapper.HybrisDataSource;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Integration test for {@link HacPerformanceTestsFacade}
 */
@IntegrationTest
public class HacPerformanceTestsFacadeTest extends ServicelayerBaseTest
{
	private static final String CREATE_TEST_TABLE = "CREATE TABLE hacperftest ( col1 VARCHAR(10), col2 VARCHAR(10) )";
	private static final String SELECT_FROM_TEST_TABLE = "SELECT col1, col2 FROM hacperftest";
	private static final String DROP_TEST_TABLE = "DROP TABLE hacperftest";
	private static final String SELECT_FROM_METAINFORMATIONS = "SELECT * FROM metainformations";
	private static final String SELECT_FROM_TEST_TABLE_KEY = "selectFromTestTable";
	private static final String DROP_TEST_TABLE_KEY = "dropTestTable";
	private static final String DROP_TEST_TABLE_PROPERTY = "hac.performanceTest.statement." + DROP_TEST_TABLE_KEY;
	private static final String SELECT_FROM_METAINFORMATIONS_KEY = "selectFromMetainformations";
	private static final String STATEMENTS_COUNT = "statementsCount";
	private static final String STATEMENTS_PER_SECOND = "statementsPerSecond";
	private static final String TIME_PER_STATEMENT = "timePerStatement";

	@Resource
	private HacPerformanceTestsFacade hacPerformanceTestsFacade;

	@Resource
	private ConfigurationService configurationService;

	@Before
	public void setUp() throws Exception
	{
		executeStatement(CREATE_TEST_TABLE);
	}

	@After
	public void tearDown() throws Exception
	{
		executeStatement(DROP_TEST_TABLE);
	}

	@Test
	public void shouldExecuteSqlTestForLegalStatement()
	{
		// when
		final Map<String, Object> results = hacPerformanceTestsFacade.executeSqlTest(SELECT_FROM_TEST_TABLE, 0, 0);

		// then
		assertThat(results).hasSize(3)
		                   .containsKeys(STATEMENTS_COUNT, STATEMENTS_PER_SECOND, TIME_PER_STATEMENT);
	}

	@Test
	public void shouldExecuteSqlTestByKeyForLegalStatement()
	{
		// when
		final Map<String, Object> results = hacPerformanceTestsFacade.executeSqlTestByKey(SELECT_FROM_TEST_TABLE_KEY, 0, 0);

		// then
		assertThat(results).hasSize(3)
		                   .containsKeys(STATEMENTS_COUNT, STATEMENTS_PER_SECOND, TIME_PER_STATEMENT);
	}

	@Test
	public void shouldLoadPredefinedSqlStatementsFromConfigurationProperties()
	{
		// when
		final Map<String, String> availableSqlStatements = hacPerformanceTestsFacade.getAvailableSqlStatements();

		// then
		assertThat(availableSqlStatements).hasSize(2)
		                                  .containsEntry(SELECT_FROM_METAINFORMATIONS_KEY, SELECT_FROM_METAINFORMATIONS)
		                                  .containsEntry(SELECT_FROM_TEST_TABLE_KEY, SELECT_FROM_TEST_TABLE);
	}

	@Test
	public void shouldNotAllowToAddAvailableSqlStatementsAtRuntime()
	{
		try
		{
			// given
			configurationService.getConfiguration().setProperty(DROP_TEST_TABLE_PROPERTY, DROP_TEST_TABLE);

			// when
			final Map<String, String> availableSqlStatements = hacPerformanceTestsFacade.getAvailableSqlStatements();

			// then
			assertThat(availableSqlStatements).doesNotContainKey(DROP_TEST_TABLE_KEY);
		}
		finally
		{
			configurationService.getConfiguration().clearProperty(DROP_TEST_TABLE_PROPERTY);
		}
	}

	private void executeStatement(final String sql) throws SQLException
	{
		final HybrisDataSource dataSource = Registry.getCurrentTenantNoFallback().getDataSource();
		try (final Connection connection = dataSource.getConnection();
		     final PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.execute();
		}
	}

}
