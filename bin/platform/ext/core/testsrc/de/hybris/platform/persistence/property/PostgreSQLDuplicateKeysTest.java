/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.persistence.property;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.test.TestItemModel;
import de.hybris.platform.core.model.test.TestItemType2Model;
import de.hybris.platform.directpersistence.impl.DefaultWritePersistenceGateway;
import de.hybris.platform.jdbcwrapper.ConnectionImpl;
import de.hybris.platform.jdbcwrapper.HybrisJdbcTemplate;
import de.hybris.platform.persistence.EJBInternalException;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.test.TestThreadsHolder;
import de.hybris.platform.tx.Transaction;
import de.hybris.platform.tx.TransactionBody;
import de.hybris.platform.util.AppendSpringConfiguration;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.Utilities;
import de.hybris.platform.util.persistence.PersistenceUtils;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@IntegrationTest
@AppendSpringConfiguration("/test/PostgreSQLDuplicateKeysTest-context.xml")
public class PostgreSQLDuplicateKeysTest extends ServicelayerBaseTest
{
	private static final int NUMBER_OF_THREADS = 10;
	private static final int TIMEOUT = 10;

	private static final String FOO_BAR = "fooBar" + UUID.randomUUID();
	private static final String TEST_ITEM_LP_CONSTRAINT_NAME = "junit_testitemlp_pkey";
	private static final String TEST_ITEM_PROPS_CONSTRAINT_NAME = "junit_props_pkey";

	private static final String TEST_DUMP_PROPERTY = "testDumpProperty";

	private static final String UPDATE_LP_TABLE_SQL_TO_MOCK = "UPDATE junit_testitemlp SET p_testproperty2=? WHERE ITEMPK=? AND LANGPK=?";
	private static final String UPDATE_PROPS_TABLE_SQL_TO_MOCK = "UPDATE junit_props SET VALUESTRING1=?,VALUE1=? WHERE ITEMPK=? AND REALNAME=?";

	@Resource
	private ModelService modelService;
	@Resource
	private DefaultWritePersistenceGateway writePersistenceGateway;
	@Resource
	private HybrisJdbcTemplate spyJdbcTemplate;

	private TestItemType2Model testItem;

	@BeforeClass
	public static void setUpClass() {
		Assume.assumeTrue(Config.isPostgreSQLUsed());
	}

	@Before
	public void setUp()
	{
		writePersistenceGateway.init();
	}

	@After
	public void tearDown()
	{
		modelService.remove(testItem);
	}

	@Test
	public void shouldNotAbortDbTxOnUniquenessViolationOnLpTablesSLDMode()
	{
		//BatchCollector tries to update lp table first. If row not exists then UpdateRowResultCheck tries to insert it.
		//to reproduce a case when multiple threads are trying to insert into lp table
		//we need to mock update to always return 0 updated rows
		doReturn(new int[] { 0 }).when(spyJdbcTemplate)
				.batchUpdate(eq(UPDATE_LP_TABLE_SQL_TO_MOCK), any(BatchPreparedStatementSetter.class));

		//given
		testItem = createTestItem();
		final Runnable runnable = updateLocalizedAttributeAndExecuteStatementAfterErrorInTxSLDMode(testItem);

		//when updating localized attribute concurrently and uniqueness violation occurs
		final var threadsHolder = runConcurrently(runnable, NUMBER_OF_THREADS, TIMEOUT);

		// then insert will fail on uniqueness violation but UpdateRowResultCheck will retry updating the row
		// without ON CONFLICT DO NOTHING clause transaction on db level would be aborted
		assertFalse(threadsHolder.hasErrors(),
				() -> "unexpected exceptions: \n" + threadsHolder.getErrors().values().stream().map(Throwable::getMessage)
				.collect(Collectors.joining("[...]\n")));

		verify(spyJdbcTemplate, times(NUMBER_OF_THREADS)).batchUpdate(eq(UPDATE_LP_TABLE_SQL_TO_MOCK), any(BatchPreparedStatementSetter.class));

		modelService.refresh(testItem);
		assertEquals(FOO_BAR, testItem.getLocalizedFooBar(Locale.ENGLISH));
	}

	@Test
	public void shouldNotAbortDbTxOnUniquenessViolationOnPropsTablesSLDMode()
	{
		//BatchCollector tries to update lp table first. If row not exists then UpdateRowResultCheck tries to insert it.
		//to reproduce a case when multiple threads are trying to insert into lp table
		//we need to mock update to always return 0 updated rows
		doReturn(new int[] { 0 }).when(spyJdbcTemplate)
				.batchUpdate(eq(UPDATE_PROPS_TABLE_SQL_TO_MOCK), any(BatchPreparedStatementSetter.class));

		//given
		testItem = createTestItem();
		final Runnable runnable = updateTestItemPropertyAndExecuteStatementAfterErrorInTxSLDMode(testItem);

		//when updating property concurrently and uniqueness violation occurs
		final var threadsHolder = runConcurrently(runnable, NUMBER_OF_THREADS, TIMEOUT);

		// then insert will fail on uniqueness violation but UpdateRowResultCheck will retry updating the row
		// without ON CONFLICT DO NOTHING clause transaction on db level would be aborted
		assertFalse(threadsHolder.hasErrors(),
				() -> "unexpected exceptions: \n" + threadsHolder.getErrors().values().stream().map(Throwable::getMessage)
						.collect(Collectors.joining("[...]\n")));

		verify(spyJdbcTemplate, times(NUMBER_OF_THREADS)).batchUpdate(eq(UPDATE_PROPS_TABLE_SQL_TO_MOCK), any(BatchPreparedStatementSetter.class));

		modelService.refresh(testItem);
		assertEquals(TEST_DUMP_PROPERTY, testItem.getTestDumpProperty(), "TestItem testDumpProperty should be updated by one of the threads");
	}

	@Test
	public void shouldNotAbortDbTxOnUniquenessViolationOnLpTablesJaloMode()
	{
		//given
		testItem = createTestItem();

		//when updating localized attribute concurrently and uniqueness violation occurs
		final Runnable runnable = updateLocalizedAttributeAndExecuteStatementAfterErrorInTxJaloMode(testItem);

		// then execution of the next statement should be allowed inside the transaction
		final var threadsHolder = runConcurrently(runnable, NUMBER_OF_THREADS, TIMEOUT);

		assertTrue(threadsHolder.hasErrors(), "at least one worker should fail on uniqueness violation");

		final var errors = threadsHolder.getErrors().values().stream()
				.collect(Collectors.partitioningBy(PostgreSQLDuplicateKeysTest::isUniquenessViolation));
		final var uniquenessViolationExceptions = errors.get(true);
		final var unexpectedExceptions = errors.get(false);

		assertTrue(unexpectedExceptions.isEmpty(),
				() -> "unexpected exceptions: \n" + unexpectedExceptions.stream().map(Throwable::getMessage)
						.collect(Collectors.joining("[...]\n")));

		assertTrue(uniquenessViolationExceptions.stream()
						.allMatch(e ->
								e.getMessage() != null &&
										e.getMessage().contains("duplicate key value violates unique constraint \"" + TEST_ITEM_LP_CONSTRAINT_NAME + "\"")),
				"uniqueness violation should be on " + TEST_ITEM_LP_CONSTRAINT_NAME + " constraint");

		modelService.refresh(testItem);
		assertEquals(FOO_BAR, testItem.getLocalizedFooBar(Locale.ENGLISH), "testItem name should be updated by one of the threads");
	}

	@Test
	public void shouldNotAbortDbTxOnUniquenessViolationOnPropsTablesJaloMode()
	{
		//given
		testItem = createTestItem();

		//when updating property concurrently and uniqueness violation occurs
		final Runnable runnable = updatePropertyAndExecuteStatementAfterErrorInTxJaloMode(testItem);

		// then execution of the next statement should be allowed inside the transaction
		final var threadsHolder = runConcurrently(runnable, NUMBER_OF_THREADS, TIMEOUT);

		assertTrue(threadsHolder.hasErrors(), "at least one worker should fail on uniqueness violation");

		final var errors = threadsHolder.getErrors().values().stream()
				.collect(Collectors.partitioningBy(PostgreSQLDuplicateKeysTest::isEJBInternalException));
		final var uniquenessViolationExceptions = errors.get(true);
		final var unexpectedExceptions = errors.get(false);

		assertTrue(unexpectedExceptions.isEmpty(),
				() -> "unexpected exceptions: \n" + unexpectedExceptions.stream().map(Throwable::getMessage)
						.collect(Collectors.joining("[...]\n")));

		assertTrue(uniquenessViolationExceptions.stream()
						.allMatch(e ->
								e.getMessage() != null &&
										e.getMessage().contains("duplicate key value violates unique constraint \"" + TEST_ITEM_PROPS_CONSTRAINT_NAME + "\"")),
				"uniqueness violation should be on " + TEST_ITEM_PROPS_CONSTRAINT_NAME + " constraint");

		modelService.refresh(testItem);
		assertEquals(TEST_DUMP_PROPERTY, testItem.getTestDumpProperty(), "TestItem testDumpProperty should be updated by one of the threads");
	}

	private Runnable updateLocalizedAttributeAndExecuteStatementAfterErrorInTxSLDMode(final TestItemType2Model testItem)
	{
		return executeInRunnableAnTx(() ->
		{
			updateLocalizedAttributeSLDMode(testItem.getPk());
			return null;
		});
	}

	private Runnable updateLocalizedAttributeAndExecuteStatementAfterErrorInTxJaloMode(final TestItemType2Model testItem)
	{
		return updateAttributeAndExecuteStatementAfterErrorInTx(
				() -> updateLocalizedAttributeLegacyMode(testItem.getPk()),
				PostgreSQLDuplicateKeysTest::assertIsUniquenessViolationOnLpPkey);
	}

	private Runnable updatePropertyAndExecuteStatementAfterErrorInTxJaloMode(final TestItemModel testItem)
	{
		return updateAttributeAndExecuteStatementAfterErrorInTx(
				() -> updatePropertyJaloMode(testItem.getPk()),
				PostgreSQLDuplicateKeysTest::assertIsUniquenessViolationOnPropsPkey);
	}

	private Runnable updateTestItemPropertyAndExecuteStatementAfterErrorInTxSLDMode(final TestItemModel testItem)
	{
		return executeInRunnableAnTx(() ->
		{
			updatePropertySLDMode(testItem.getPk());
			return null;
		});


	}

	private <R> Runnable executeInRunnableAnTx(Supplier<R> supplier)
	{
		return () ->
		{
			try
			{
				Transaction.current().execute(new TransactionBody()
				{
					@Override
					public <T> T execute() throws Exception
					{
						supplier.get();
						return null;
					}
				});
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		};
	}

	private TestThreadsHolder<Runnable> runConcurrently(final Runnable runnable, final int numberOfThreads,
			final int timeoutSeconds)
	{
		final var threadsHolder = new TestThreadsHolder<>(numberOfThreads, runnable, true);
		threadsHolder.startAll();
		assertTrue(threadsHolder.waitForAll(timeoutSeconds, TimeUnit.SECONDS),
				"not all worker finished after " + timeoutSeconds + "s");
		return threadsHolder;
	}

	private TestItemType2Model createTestItem()
	{
		final TestItemType2Model item = modelService.create(TestItemType2Model.class);
		modelService.save(item);
		return item;
	}

	private void updateLocalizedAttribute(final PK pk)
	{
		final TestItemType2Model item = modelService.get(pk);
		item.setLocalizedFooBar(FOO_BAR, Locale.ENGLISH);
		modelService.save(item);
	}

	private void updateLocalizedAttributeSLDMode(final PK pk)
	{
		PersistenceUtils.doWithSLDPersistence(() -> {
			updateLocalizedAttribute(pk);
			return null;
		});
	}

	private void updateLocalizedAttributeLegacyMode(final PK pk)
	{
		PersistenceUtils.doWithLegacyPersistence(() -> {
			updateLocalizedAttribute(pk);
			return null;
		});
	}

	private void updatePropertyJaloMode(final PK pk)
	{
		PersistenceUtils.doWithLegacyPersistence(() -> {
			updateProperty(pk);
			return null;
		});
	}

	private void updatePropertySLDMode(final PK pk)
	{
		PersistenceUtils.doWithSLDPersistence(() -> {
			updateProperty(pk);
			return null;
		});
	}

	private void updateProperty(final PK pk)
	{
		final TestItemModel item = modelService.get(pk);
		item.setTestDumpProperty(TEST_DUMP_PROPERTY);
		modelService.save(item);
	}

	@FunctionalInterface
	private interface AttributeUpdater
	{
		void updateAttribute();
	}

	private Runnable updateAttributeAndExecuteStatementAfterErrorInTx(final AttributeUpdater attributeUpdater,
			final Consumer<Throwable> uniquenessViolationAssertion)
	{
		return () -> {
			boolean commit = false;
			final var tx = Transaction.current();
			try
			{
				tx.begin();

				attributeUpdater.updateAttribute();
				commit = true;
			}
			catch (final ModelSavingException e)
			{
				// one thread wins race and updates the item, others should fail on uniqueness violation
				// what is expected here
				uniquenessViolationAssertion.accept(e);
				assertTransactionIsRunningAndRollbackOnly(Transaction.current());

				// execution of this statement should be allowed inside the transaction after error
				// it means that transaction on database level was not aborted
				tryExecuteStatementOrThrow();

				throw e;
			}
			finally
			{
				// race winner commits, others rollback tx
				if (commit)
				{
					tx.commit();
				}
				else
				{
					tx.rollback();
				}
			}
		};
	}

	private static void tryExecuteStatementOrThrow()
	{
		try (final ConnectionImpl conn = Transaction.current().getTXBoundConnection())
		{
			conn.createStatement().execute("SELECT 1");
		}
		catch (final SQLException e2)
		{
			throw new AssertionFailedError("transaction on database level should not be aborted after uniqueness violation", e2);
		}
	}

	private static void assertIsUniquenessViolationOnLpPkey(final Throwable e)
	{
		assertTrue(
				isUniquenessViolation(e) &&
						e.getMessage() != null &&
						e.getMessage().contains("duplicate key value violates unique constraint \"" + TEST_ITEM_LP_CONSTRAINT_NAME + "\""),
				"should fail on \"" + TEST_ITEM_LP_CONSTRAINT_NAME + "\" uniqueness violation but was: " + e.getClass() + ": " + e.getMessage());
	}

	private static void assertIsUniquenessViolationOnPropsPkey(final Throwable e)
	{
		assertTrue(
				isEJBInternalException(e) &&
						e.getMessage() != null &&
						e.getMessage().contains("duplicate key value violates unique constraint \"" + TEST_ITEM_PROPS_CONSTRAINT_NAME + "\""),
				"should fail on \"" + TEST_ITEM_PROPS_CONSTRAINT_NAME + "\" uniqueness violation but was: " + e.getClass() + ": " + e.getMessage());
	}

	private static boolean isUniquenessViolation(final Throwable e)
	{
		return Utilities.getRootCauseOfType(e, SQLIntegrityConstraintViolationException.class) != null;
	}

	private static boolean isEJBInternalException(final Throwable e)
	{
		return Utilities.getRootCauseOfType(e, EJBInternalException.class) != null;
	}

	private static void assertTransactionIsRunningAndRollbackOnly(final Transaction transaction)
	{
		assertTrue(transaction.isRunning(), "transaction should be running after uniqueness violation");
		assertTrue(transaction.isRollbackOnly(), "transaction should be rollback-only after uniqueness violation");
	}
}
