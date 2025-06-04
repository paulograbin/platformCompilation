/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.audit;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.user.UserModel;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DBAuditGDPREnabledImplTest extends AbstractDBAuditHandlerTest
{

	@Before
	@Override
	public void setUp()
	{
		super.setUp();
		enableGDPRAudit();
		assertThat(auditEnablementService.isAuditEnabledForType(UserModel._TYPECODE)).isTrue();
	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForTxInsertWithLegacyPersistence()
			throws Exception
	{
		//given
		final PK titlePk = txInsertWithLegacyPersistence();

		//then
		assertDbAuditLogForCreation(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_INSERT_PATTERN, PROPS_SELECT_PATTERN,
				TITLE_SELECT_ALL_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN);

		//Assert NonLazySldContainer usage
		assertNonLazySldContainerUsed(titlePk, 1);

	}


	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForTxUpdateWithLegacyPersistence()
			throws Exception
	{
		//given
		final PK titlePk = txUpdateWithLegacyPersistence();

		//then
		assertDbAuditForUpdate(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_UPDATE_PATTERN, PROPS_SELECT_PATTERN,
				TITLE_SELECT_ALL_PATTERN,
				TITLES_LP_UPDATE_PATTERN);

		//Assert NonLazySldContainer usage
		assertNonLazySldContainerUsed(titlePk, 2);

	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesTxRemoveWithLegacyPersistence() throws Exception
	{
		//given
		final PK titlePk = txRemoveWithLegacyPersistence();

		//then
		assertDbAuditForRemoval(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, DELETE_FROM_PATTERN, 3);

		//Assert NonLazySldContainer usage
		assertNonLazySldContainerUsed(titlePk, 1);

	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForTxInsertWithDirectPersistence()
			throws Exception
	{
		final PK titlePk = txInsertWithDirectPersistence();

		//then
		assertDbAuditLogForCreation(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_INSERT_PATTERN, TITLE_SELECT_ALL_PATTERN,
				PROPS_SELECT_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN);

		//Assert NonLazySldContainer is used
		assertNonLazySldContainerUsed(titlePk, 1);

	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForTxUpdateWithDirectPersistence()
			throws Exception
	{
		//given
		final PK titlePk = txUpdateWithDirectPersistence();

		//then
		assertDbAuditForUpdate(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_UPDATE_PATTERN, TITLE_SELECT_ALL_PATTERN,
				TITLES_LP_UPDATE_PATTERN,
				PROPS_SELECT_PATTERN);

		//Assert NonLazySldContainer is used
		assertNonLazySldContainerUsed(titlePk, 2);

	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForTxRemoveWithDirectPersistence()
			throws Exception
	{
		//given
		final PK titlePk = txRemoveWithDirectPersistence();

		//then
		assertDbAuditForRemoval(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLE_SELECT_ALL_PATTERN, PROPS_SELECT_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, DELETE_FROM_PATTERN, 3);

		//Assert NonLazySldContainer is used
		assertNonLazySldContainerUsed(titlePk, 1);

	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForNonTransactionalRemove()
	{
		//given
		final PK titlePk = nonTransactionalRemove();
		//then
		assertDbAuditForRemoval(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, DELETE_FROM_PATTERN, 3);

		//Assert NonLazySldContainer usage
		assertNonLazySldContainerUsed(titlePk, 1);

	}

	@Test
	public void shouldGenerateAdditionalSldDatabaseQueriesForNonTransactionalInsertOperation()
	{
		//given
		final PK titlePk = nonTransactionalInsertOperation();

		//then
		assertDbAuditLogForCreation(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_INSERT_PATTERN, PROPS_SELECT_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN,
				TITLE_SELECT_ALL_PATTERN);

		//Assert NonLazySldContainer usage
		assertNonLazySldContainerUsed(titlePk, 1);
	}

	private void assertNonLazySldContainerUsed(final PK titlePk, final int occurrences)
	{
		assertNonLazySldContainerUsageLogged(titlePk).atLeastOccurrences(occurrences);
		assertLazySldContainerUsageLogged(titlePk).occurrences(0);
		assertAccessToWrappedSldContainerLogged(titlePk).occurrences(0);
	}

}
