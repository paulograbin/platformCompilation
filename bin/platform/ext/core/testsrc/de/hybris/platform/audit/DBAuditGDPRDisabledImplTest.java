/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.audit;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DBAuditGDPRDisabledImplTest extends AbstractDBAuditHandlerTest
{

	@Before
	@Override
	public void setUp()
	{
		super.setUp();
		disableGDPRAudit();

		assertThat(auditEnablementService.isAuditEnabledForType(UserModel._TYPECODE)).isFalse();
		assertThat(auditEnablementService.isAuditEnabledForType(TitleModel._TYPECODE)).isFalse();
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForTxInsertWithLegacyPersistence()
			throws Exception
	{
		//when
		final PK titlePk = txInsertWithLegacyPersistence();

		//then
		assertDbAuditLogForCreation(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertNoneOfLogsMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, PROPS_SELECT_PATTERN, TITLE_SELECT_ALL_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_INSERT_PATTERN);

		//Assert LazySldContainer usage
		assertOnlyLazySldContainerUsed(titlePk, 1);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForTxUpdateWithLegacyPersistence()
			throws Exception
	{
		//when
		final PK titlePk = txUpdateWithLegacyPersistence();

		//then
		assertDbAuditForUpdate(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertNoneOfLogsMatches(jdbcLogSqlText, PROPS_SELECT_PATTERN, TITLE_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_UPDATE_PATTERN, 1);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_LP_UPDATE_PATTERN, 1);


		//Assert LazySldContainer usage
		assertOnlyLazySldContainerUsed(titlePk, 2);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForTxRemoveWithLegacyPersistence() throws Exception
	{
		//when
		final PK titlePk = txRemoveWithLegacyPersistence();

		//then
		assertDbAuditForRemoval(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, DELETE_FROM_PATTERN, 3);

		//Assert LazySldContainer usage
		assertOnlyLazySldContainerUsed(titlePk, 1);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForTxInsertWithDirectPersistence()
			throws Exception
	{
		//when
		final PK titlePk = txInsertWithDirectPersistence();

		//then
		assertDbAuditLogForCreation(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertNoneOfLogsMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLE_SELECT_ALL_PATTERN, PROPS_SELECT_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_INSERT_PATTERN);

		//Assert LazySldContainer is used
		assertOnlyLazySldContainerUsed(titlePk, 1);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForTxUpdateWithDirectPersistence()
			throws Exception
	{
		//when
		final PK titlePk = txUpdateWithDirectPersistence();

		//then
		assertDbAuditForUpdate(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertNoneOfLogsMatches(jdbcLogSqlText, TITLE_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_UPDATE_PATTERN, 1);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_LP_UPDATE_PATTERN, 1);

		//Assert LazySldContainer is used
		assertOnlyLazySldContainerUsed(titlePk, 2);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForTxRemoveWithDirectPersistence()
			throws Exception
	{
		//when
		final PK titlePk = txRemoveWithDirectPersistence();

		//then
		assertDbAuditForRemoval(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertNoneOfLogsMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLE_SELECT_ALL_PATTERN, PROPS_SELECT_PATTERN,
				TITLE_LP_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, DELETE_FROM_PATTERN, 3);

		//Assert LazySldContainer is used
		assertOnlyLazySldContainerUsed(titlePk, 1);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForDbAuditForNonTransactionalRemove()
	{
		//when
		final PK titlePk = nonTransactionalRemove();

		//then
		assertDbAuditForRemoval(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, DELETE_FROM_PATTERN, 3);

		//Assert LazySldContainer usage
		assertOnlyLazySldContainerUsed(titlePk, 1);
	}

	@Test
	public void shouldNotGenerateAdditionalSldDatabaseQueriesForNonTransactionalInsertOperation()
	{
		//when
		final PK titlePk = nonTransactionalInsertOperation();

		//then
		assertDbAuditLogForCreation(titlePk);

		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());

		assertNoneOfLogsMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, PROPS_SELECT_PATTERN, TITLE_LP_SELECT_ALL_PATTERN);
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLES_INSERT_PATTERN, 1);
		//Not generated by Audit Logging
		assertLogMatchesWithPkAndPattern(jdbcLogSqlText, titlePk, TITLE_SELECT_ALL_PATTERN, 1);

		//Assert LazySldContainer usage
		assertOnlyLazySldContainerUsed(titlePk, 1);
	}

	private void assertOnlyLazySldContainerUsed(final PK titlePk, final int occurrences)
	{
		assertNonLazySldContainerUsageLogged(titlePk).occurrences(0);
		assertLazySldContainerUsageLogged(titlePk).occurrences(occurrences);
		assertAccessToWrappedSldContainerLogged(titlePk).occurrences(0);
	}
}
