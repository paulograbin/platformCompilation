/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.audit;

import static de.hybris.platform.persistence.audit.internal.impl.DefaultDBAuditEnablementService.DBAUDIT_DISABLED_PROPERTY;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.audit.actions.AuditableActionHandler;
import de.hybris.platform.audit.demo.AuditTestConfigManager;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.directpersistence.cache.LazySLDDataContainer;
import de.hybris.platform.directpersistence.cache.SLDDataContainer;
import de.hybris.platform.directpersistence.statement.sql.FluentSqlBuilder;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.persistence.audit.AuditType;
import de.hybris.platform.persistence.audit.AuditableChange;
import de.hybris.platform.persistence.audit.AuditableOperations;
import de.hybris.platform.persistence.audit.DBAuditHandler;
import de.hybris.platform.persistence.audit.impl.AuditDataProvider;
import de.hybris.platform.persistence.audit.internal.AuditEnablementService;
import de.hybris.platform.persistence.audit.internal.DBAuditEnablementService;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionExecutionBody;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.testframework.assertions.assertj.TestLogListenerAssert;
import de.hybris.platform.testframework.log.TestLogListener;
import de.hybris.platform.testframework.seed.TestDataCreator;
import de.hybris.platform.tx.Transaction;
import de.hybris.platform.util.persistence.PersistenceUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.log4j.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.collect.Sets;

public abstract class AbstractDBAuditHandlerTest extends ServicelayerBaseTest implements AuditableTest
{

	/*
	Patterns for logs check
	 */
	protected static final Pattern PROPS_SELECT_PATTERN = Pattern.compile(
			"SELECT[\\p{Graph}|\\s]+FROM[\\p{Graph}|\\s]+props[\\p{Graph}|\\s]*");
	protected static final Pattern TITLE_SELECT_ALL_PATTERN = Pattern.compile(
			"SELECT\\s+\\*\\s+FROM[\\p{Graph}|\\s]+titles\\s+[\\p{Graph}|\\s]*");
	protected static final Pattern TITLE_LP_SELECT_ALL_PATTERN = Pattern.compile(
			"SELECT\\s+\\*\\s+FROM[\\p{Graph}|\\s]+titleslp[\\p{Graph}|\\s]*");
	protected static final Pattern TITLES_INSERT_PATTERN = Pattern.compile("INSERT\\s+INTO[\\s|\\p{Graph}]+titles\\s+.*");
	protected static final Pattern TITLES_UPDATE_PATTERN = Pattern.compile("UPDATE[\\p{Graph}|\\s]+titles\\s+.*");
	protected static final Pattern TITLES_LP_UPDATE_PATTERN = Pattern.compile("UPDATE[\\p{Graph}|\\s]+titleslp\\s+.*");
	protected static final Pattern DELETE_FROM_PATTERN = Pattern.compile("DELETE\\s+FROM.*");

	/**
	 * Test data constants
	 */
	private static final String TITLE_FOR_UPDATE_CODE_LEGACY = UUID.randomUUID().toString();
	private static final String TITLE_FOR_REMOVE_CODE_LEGACY = UUID.randomUUID().toString();
	private static final String TITLE_FOR_UPDATE_CODE_SLD = UUID.randomUUID().toString();
	private static final String TITLE_FOR_REMOVE_CODE_SLD = UUID.randomUUID().toString();
	private static final String TITLE_FOR_REMOVE_CODE_NO_TX = UUID.randomUUID().toString();
	private static final String TITLE_FOR_NO_CHANGE_UPDATE_SLD_CODE = UUID.randomUUID().toString();
	private static final String TITLE_FOR_NO_CHANGE_UPDATE_LEGACY_CODE = UUID.randomUUID().toString();
	public static final String DEFAULT_TITLE_NAME = "testTitleName-" + UUID.randomUUID();

	/**
	 * Test data
	 */
	private TitleModel titleModelForLegacyUpdate;
	private TitleModel titleModelForLegacyRemove;
	private TitleModel titleModelForSldUpdate;
	private TitleModel titleModelForSldRemove;
	private TitleModel titleModelForNoTxRemove;
	private TitleModel titleModelForSldNoChangeUpdate;
	private TitleModel titleModelForLegacyNoChangeUpdate;

	/**
	 * Properties
	 */
	private final PropertyConfigSwitcher auditAllTypesEnabledProperty = new PropertyConfigSwitcher("auditing.alltypes.enabled");
	private final PropertyConfigSwitcher disabledDbAuditForUser = new PropertyConfigSwitcher("dbaudit.user.disabled");
	private final PropertyConfigSwitcher disabledDbAuditForEmployee = new PropertyConfigSwitcher("dbaudit.employee.disabled");
	private final PropertyConfigSwitcher dbAuditDisabledProperty = new PropertyConfigSwitcher(DBAUDIT_DISABLED_PROPERTY);
	protected final PropertyConfigSwitcher allowDirectPersistenceForTitle = new PropertyConfigSwitcher(
			"direct.persistence.ignore.unsafe.type.Title");
	/**
	 * Resources
	 */
	@Resource(name = "auditingEnablementService")
	protected AuditEnablementService auditEnablementService;
	@Resource
	private DBAuditHandler dbAuditHandler;
	@Resource
	protected SessionService sessionService;
	@Resource
	protected ModelService modelService;
	@Resource
	private DBAuditEnablementService dbAuditEnablementService;
	@Resource
	private TypeService typeService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * Test utils
	 */
	private Supplier<AuditableActionHandler> originalActionHandler;
	protected final TestLogListener testLogListener = new TestLogListener();
	private AuditTestConfigManager auditTestConfigManager;
	private TestDataCreator creator;
	private AuditTestHelper auditTestHelper;
	protected final LogLevelSwitcher logLevelSwitcherAuditSldContainer = new LogLevelSwitcher(AuditDataProvider.class,
			LazySLDDataContainer.class);

	@Before
	public void setUp()
	{
		assumeAuditEnabled();
		setupTestAuditHandler();

		auditTestConfigManager = new AuditTestConfigManager(auditEnablementService);
		auditTestHelper = new AuditTestHelper();
		creator = new TestDataCreator(modelService);

		createTestData();
		createDBAuditLazySldContainerTestTitles();

		auditTestHelper.clearAuditDataForTypes(UserModel._TYPECODE, AddressModel._TYPECODE, TitleModel._TYPECODE);
		dbAuditDisabledProperty.switchToValue("false");
		dbAuditEnablementService.refreshConfiguredAuditTypes();

		testLogListener.attach();
	}

	private void setupTestAuditHandler()
	{
		final AuditableActionHandler testAuditableActionHandler = new TestSlf4jAuditableActionHandler();
		originalActionHandler = AuditableActions.getAuditableActionHandlerFactory();
		AuditableActions.setAuditableActionHandlerFactory(() -> testAuditableActionHandler);
	}

	private void createDBAuditLazySldContainerTestTitles()
	{
		titleModelForLegacyUpdate = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_UPDATE_CODE_LEGACY, DEFAULT_TITLE_NAME));
		titleModelForLegacyRemove = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_REMOVE_CODE_LEGACY, DEFAULT_TITLE_NAME));
		titleModelForSldUpdate = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_UPDATE_CODE_SLD, DEFAULT_TITLE_NAME));
		titleModelForSldRemove = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_REMOVE_CODE_SLD, DEFAULT_TITLE_NAME));
		titleModelForNoTxRemove = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_REMOVE_CODE_NO_TX, DEFAULT_TITLE_NAME));
		titleModelForLegacyNoChangeUpdate = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_NO_CHANGE_UPDATE_LEGACY_CODE, DEFAULT_TITLE_NAME));
		titleModelForSldNoChangeUpdate = auditTestHelper.createItem(
				() -> creator.createTitle(TITLE_FOR_NO_CHANGE_UPDATE_SLD_CODE, DEFAULT_TITLE_NAME));
	}

	@After
	public void cleanup()
	{
		TestJDBCLogger.disable();
		testLogListener.detach();

		logLevelSwitcherAuditSldContainer.restoreDefaultLevel();
		allowDirectPersistenceForTitle.switchBackToDefault();

		if (originalActionHandler != null)
		{
			AuditableActions.setAuditableActionHandlerFactory(originalActionHandler);
		}
		auditTestConfigManager.resetAuditConfiguration();
		auditTestHelper.clearAuditDataForTypes("User", "Address", "Title");
		auditTestHelper.removeCreatedItems();
		auditAllTypesEnabledProperty.switchBackToDefault();
		disabledDbAuditForUser.switchBackToDefault();
		disabledDbAuditForEmployee.switchBackToDefault();
		dbAuditDisabledProperty.switchBackToDefault();
		dbAuditEnablementService.refreshConfiguredAuditTypes();
	}

	@Test
	public void shouldNotThrowExceptionWhenStateBeforeAndAfterIsNullForCombinedCreateAndUpdateInTxWithLegacyPersistence() throws Exception
	{
		//when
		final PK titlePk = txInsertAndRemoveInSingleTxWithLegacy();

		//then
		//CXEC-40870
		//Depending on usage of LazySLDContainer in audit, there might be no logs or one log
		assertDbAuditLogged().atMostOccurrences(1);
		assertItemPkLogged(titlePk).atMostOccurrences(1);
		assertCreationLogged().atMostOccurrences(1);
		assertDeletionLogged().occurrences(0);
	}

	@Test
	public void shouldNotThrowExceptionWhenStateBeforeAndAfterIsNullForCombinedCreateAndUpdateInTxWithDirectPersistence() throws Exception
	{
		//when
		final PK titlePk = txInsertAndRemoveInSingleTxWithDirectPersistence();

		//then
		//CXEC-40870
		//Depending on usage of LazySLDContainer in audit, there might be no logs or one log
		assertDbAuditLogged().atMostOccurrences(1);
		assertItemPkLogged(titlePk).atMostOccurrences(1);
		assertCreationLogged().atMostOccurrences(1);
		assertDeletionLogged().occurrences(0);
	}

	@Test
	public void shouldNotThrowExceptionForNullStateBeforeAndAfterDeleteOperationWithTxLegacy() throws Exception
	{
		//given
		final TitleModel titleModelForRemoval = createTitleModelOutsideTitleCreator();
		final PK titlePk = titleModelForRemoval.getPk();

		//and
		//Clear logs from test item creation
		testLogListener.detach();
		testLogListener.attach();

		//Simulate other node removes item from db and our model is not aware of it
		//Or removal happens in unfortunate moment when audit starts do fetch state of object and Model is not aware of it
		jdbcTemplate.update(getSqlDeleteForTitle(), titlePk.getLong());

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//when
		tx.execute(() ->
				PersistenceUtils.doWithLegacyPersistence(() -> {
					modelService.remove(titleModelForRemoval);
					return null;
				}));
		//CXEC-40870
		//Depending on usage of LazySLDContainer in audit, there might be no logs or one log
		assertDbAuditLogged().atMostOccurrences(1);
		assertItemPkLogged(titlePk).atMostOccurrences(1);
		assertDeletionLogged().atMostOccurrences(1);
	}

	@Test
	public void shouldNotThrowExceptionForNullStateBeforeAndAfterDeleteOperationWithTxSld() throws Exception
	{
		//given
		final TitleModel titleModelForRemoval = createTitleModelOutsideTitleCreator();
		final PK titlePk = titleModelForRemoval.getPk();

		//and
		//Clear logs from test item creation
		testLogListener.detach();
		testLogListener.attach();

		//Simulate other node removes item from db and our model is not aware of it
		//Or removal happens in unfortunate moment when audit starts do fetch state of object and Model is not aware of it
		jdbcTemplate.update(getSqlDeleteForTitle(), titlePk.getLong());

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//when
		tx.execute(() ->
				PersistenceUtils.doWithSLDPersistence(() -> {
					modelService.remove(titleModelForRemoval);
					return null;
				}));

		//then
		//CXEC-40870
		//Depending on usage of LazySLDContainer in audit, there might be no logs or one log
		assertDbAuditLogged().atMostOccurrences(1);
		assertItemPkLogged(titlePk).atMostOccurrences(1);
		assertDeletionLogged().atMostOccurrences(1);
	}

	@Test
	public void shouldNotThrowExceptionForNullStateBeforeAndAfterDeleteOperationWithNoTx()
	{
		//given
		final TitleModel titleModelForRemoval = createTitleModelOutsideTitleCreator();
		final PK titlePk = titleModelForRemoval.getPk();

		//and
		//Clear logs from test item creation
		testLogListener.detach();
		testLogListener.attach();

		//Simulate other node removes item from db and our model is not aware of it
		//Or removal happens in unfortunate moment when audit starts do fetch state of object and Model is not aware of it
		jdbcTemplate.update(getSqlDeleteForTitle(), titlePk.getLong());

		//and
		sessionService.executeInLocalView(new SessionExecutionBody()
		{
			@Override
			public void executeWithoutResult()
			{
				modelService.disableTransactions();
				modelService.remove(titleModelForRemoval);
			}
		});

		//CXEC-40870
		//Depending on usage of LazySLDContainer in audit, there might be no logs or one log
		assertDbAuditLogged().atMostOccurrences(1);
		assertItemPkLogged(titlePk).atMostOccurrences(1);
		assertDeletionLogged().atMostOccurrences(1);
	}

	@Test
	public void testDirectAuditSingle()
	{
		//given
		final Triple<AuditableChange, PK, PK> mockAuditableChange = mockAuditableChange(AuditType.CREATION);

		//when
		dbAuditHandler.auditOperation(mockAuditableChange.getLeft());

		//then
		assertCreationLogged().occurrences(1);
		assertItemPkLogged(mockAuditableChange.getMiddle()).occurrences(1);
		assertTypePkLogged(mockAuditableChange.getRight()).occurrences(1);
		assertMessageLogged("dummyMessage").occurrences(0);
	}

	@Test
	public void testDirectAuditSingleWithMessage()
	{
		//given
		final Triple<AuditableChange, PK, PK> mockAuditableChange = mockAuditableChange(AuditType.CREATION);

		//when
		dbAuditHandler.auditOperation(mockAuditableChange.getLeft(), "dummyMessage");

		//then
		assertCreationLogged().occurrences(1);
		assertItemPkLogged(mockAuditableChange.getMiddle()).occurrences(1);
		assertItemPkLogged(mockAuditableChange.getRight()).occurrences(1);
		assertMessageLogged("dummyMessage").occurrences(1);
	}

	@Test
	public void testDirectAuditMultiple()
	{
		//given
		final Triple<AuditableChange, PK, PK> mockAuditableChange1 = mockAuditableChange(AuditType.CREATION);
		final Triple<AuditableChange, PK, PK> mockAuditableChange2 = mockAuditableChange(AuditType.MODIFICATION);

		//when
		dbAuditHandler.auditOperation(mockAuditableChange1.getLeft());
		dbAuditHandler.auditOperation(mockAuditableChange2.getLeft());

		//then
		assertDbAuditLogged().occurrences(2);
		assertMessageLogged("dummyMessage").occurrences(0);

		assertCreationLogged().occurrences(1);
		assertItemPkLogged(mockAuditableChange1.getMiddle()).occurrences(1);
		assertTypePkLogged(mockAuditableChange1.getRight()).occurrences(1);

		assertUpdateLogged().occurrences(1);
		assertItemPkLogged(mockAuditableChange2.getMiddle()).occurrences(1);
		assertTypePkLogged(mockAuditableChange2.getRight()).occurrences(1);
	}
	@Test
	public void shouldNotCreateDbAuditWhenBeforeAndAfterAreEmpty()
	{
		//given
		final AuditableChange mockAuditableChange = mockEmptyAuditableChange();

		//when
		dbAuditHandler.auditOperation(mockAuditableChange);

		//then
		assertDbAuditLogged().occurrences(0);
	}

	@Test
	public void testDirectAuditMultipleWithMessage()
	{
		//given
		final Triple<AuditableChange, PK, PK> mockAuditableChange1 = mockAuditableChange(AuditType.CREATION);
		final Triple<AuditableChange, PK, PK> mockAuditableChange2 = mockAuditableChange(AuditType.MODIFICATION);

		//when
		dbAuditHandler.auditOperation(mockAuditableChange1.getLeft(), "dummyMessage");
		dbAuditHandler.auditOperation(mockAuditableChange2.getLeft(), "dummyMessage");

		//then
		assertDbAuditLogged().occurrences(2);
		assertMessageLogged("dummyMessage").occurrences(2);

		assertUpdateLogged().occurrences(1);
		assertItemPkLogged(mockAuditableChange1.getMiddle()).occurrences(1);
		assertTypePkLogged(mockAuditableChange1.getRight()).occurrences(1);

		assertUpdateLogged().occurrences(1);
		assertItemPkLogged(mockAuditableChange2.getMiddle()).occurrences(1);
		assertTypePkLogged(mockAuditableChange2.getRight()).occurrences(1);
	}

	private Triple<AuditableChange, PK, PK> mockAuditableChange(final AuditType auditType)
	{
		final AuditableChange auditableChange = Mockito.mock(AuditableChange.class);
		final SLDDataContainer sldDataContainer = Mockito.mock(SLDDataContainer.class);
		final PK pk = PK.createCounterPK(20);
		final PK typePk = PK.createCounterPK(30);

		Mockito.doReturn(sldDataContainer).when(auditableChange).getBefore();
		Mockito.doReturn(Boolean.TRUE).when(auditableChange).isMeaningful();
		Mockito.doReturn(auditType).when(auditableChange).calculateAuditType();

		Mockito.doReturn(pk).when(sldDataContainer).getPk();
		Mockito.doReturn(typePk).when(sldDataContainer).getTypePk();

		return Triple.of(auditableChange, pk, typePk);
	}

	private AuditableChange mockEmptyAuditableChange()
	{
		final AuditableChange auditableChange = Mockito.mock(AuditableChange.class);
		Mockito.doReturn(null).when(auditableChange).getBefore();
		Mockito.doReturn(null).when(auditableChange).getAfter();
		Mockito.when(auditableChange.calculateAuditType()).thenCallRealMethod();
		return auditableChange;
	}
	@Test
	public void testMultiple()
	{
		//when
		final UserModel user = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");
		final UserGroupModel group1 = creator.createUserGroup(RandomStringUtils.randomAlphabetic(15), "group1");
		final UserGroupModel group2 = creator.createUserGroup(RandomStringUtils.randomAlphabetic(15), "group2");
		user.setGroups(Sets.newHashSet(group1, group2));

		modelService.saveAll(user, group1, group2);
		//then
		assertItemPkLogged(user.getPk()).occurrences(2);
		assertItemPkLogged(group1.getPk()).occurrences(2);
		assertItemPkLogged(group2.getPk()).occurrences(2);
	}

	@Test
	public void testMultipleMixed()
	{
		//given
		disabledDbAuditForUser.switchToValue("true");
		dbAuditEnablementService.refreshConfiguredAuditTypes();

		//when
		final UserModel user = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");
		final UserGroupModel group1 = creator.createUserGroup(RandomStringUtils.randomAlphabetic(15), "group1");
		final UserGroupModel group2 = creator.createUserGroup(RandomStringUtils.randomAlphabetic(15), "group2");
		user.setGroups(Sets.newHashSet(group1, group2));

		modelService.saveAll(user, group1, group2);
		//then
		assertItemPkLogged(user.getPk()).occurrences(0);
		assertItemPkLogged(group1.getPk()).occurrences(2);
		assertItemPkLogged(group2.getPk()).occurrences(2);
	}

	@Test
	public void testTransactionRollback()
	{
		//given
		UserModel user;

		//when
		final Transaction tx = Transaction.current();
		tx.begin();
		try
		{
			user = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");
		}
		finally
		{
			tx.rollback();
		}

		//then
		assertItemPkLogged(user.getPk()).occurrences(0);
	}

	@Test
	public void testNoTransaction()
	{
		//given
		final UserModel userModel = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");

		//when
		final User user = modelService.getSource(userModel);
		user.setDescription("test");

		//then
		assertItemPkLogged(userModel.getPk()).occurrences(2);
	}

	@Test
	public void testDisabledDataAudit()
	{
		//given
		disabledDbAuditForUser.switchToValue("true");
		dbAuditEnablementService.refreshConfiguredAuditTypes();

		//when
		final UserModel user = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");

		//then
		assertItemPkLogged(user.getPk()).occurrences(0);
	}

	@Test
	public void testDisabledDataAuditSuperType()
	{
		//given
		disabledDbAuditForUser.switchToValue("true");
		dbAuditEnablementService.refreshConfiguredAuditTypes();

		//when
		final UserModel employee = creator.createEmployee(RandomStringUtils.randomAlphabetic(15), "employee");

		//then
		assertItemPkLogged(employee.getPk()).occurrences(0);
	}

	@Test
	public void testDisabledDataAuditSubType()
	{
		//given
		disabledDbAuditForEmployee.switchToValue("true");
		dbAuditEnablementService.refreshConfiguredAuditTypes();

		//when
		final UserModel user = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");

		//then
		assertItemPkLogged(user.getPk()).occurrences(1);
	}

	@Test
	public void shouldNotAuditActionsWhenDisabledInSession()
	{
		final UserModel user = sessionService.executeInLocalView(new SessionExecutionBody()
		{
			@Override
			public UserModel execute()
			{
				dbAuditEnablementService.disableAuditInSession();
				return creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");
			}
		});

		assertItemPkLogged(user.getPk()).occurrences(0);
	}

	@Test
	public void shouldReEnableActionAuditingWhenOnceDisabled()
	{
		final UserModel user = sessionService.executeInLocalView(new SessionExecutionBody()
		{
			@Override
			public UserModel execute()
			{
				dbAuditEnablementService.disableAuditInSession();
				creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");

				dbAuditEnablementService.enableAuditInSession();
				return creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");
			}
		});

		assertItemPkLogged(user.getPk()).occurrences(1);
	}

	@Test
	public void shouldNotFailOnClearAuditAndItemCreationWithTx() throws Exception
	{
		Transaction.current().execute(() -> {
			final UserModel user = creator.createUser(RandomStringUtils.randomAlphabetic(15), "user");
			AuditableOperations.clearCurrentAuditOperationsFor(user.getItemtype());
			return null;
		});
	}

	@Test
	public void shouldNotCreateAuditLogsForEmptyUpdateUsingLegacyPersistence() throws Exception
	{
		//given
		final String newTitleName = titleModelForLegacyNoChangeUpdate.getName();

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		TestJDBCLogger.enable(true, "titles,props");

		//when
		final PK titlePk = tx.execute(() ->
				PersistenceUtils.doWithLegacyPersistence(() -> {
					titleModelForLegacyNoChangeUpdate.setName(newTitleName);
					modelService.save(titleModelForLegacyNoChangeUpdate);
					return titleModelForSldNoChangeUpdate.getPk();
				}));

		//then
		assertDbAuditLogged().occurrences(0);
		assertItemPkLogged(titlePk).occurrences(0);
		assertUpdateLogged().occurrences(0);
		assertDeletionLogged().occurrences(0);
		assertCreationLogged().occurrences(0);


		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertNoneOfLogsMatches(jdbcLogSqlText, PROPS_SELECT_PATTERN, TITLE_SELECT_ALL_PATTERN,
				TITLES_INSERT_PATTERN);


		//Assert neither Standard nor Lazy container is used
		assertNonLazySldContainerUsageLogged(titlePk).occurrences(0);
		assertLazySldContainerUsageLogged(titlePk).occurrences(0);
		assertAccessToWrappedSldContainerLogged(titlePk).occurrences(0);
	}

	@Test
	public void shouldNotCreateAuditLogsForEmptyUpdateUsingSldPersistence() throws Exception
	{
		//given
		final String newTitleName = titleModelForSldNoChangeUpdate.getName();

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		allowDirectPersistenceForTitle.switchToValue("true");
		TestJDBCLogger.enable(true, "titles,props");

		//when
		final PK titlePk = tx.execute(() ->
				PersistenceUtils.doWithSLDPersistence(() -> {
					titleModelForSldNoChangeUpdate.setName(newTitleName);
					modelService.save(titleModelForSldNoChangeUpdate);
					return titleModelForSldNoChangeUpdate.getPk();
				}));

		//then
		assertDbAuditLogged().occurrences(0);
		assertItemPkLogged(titlePk).occurrences(0);
		assertUpdateLogged().occurrences(0);
		assertDeletionLogged().occurrences(0);
		assertCreationLogged().occurrences(0);


		//Assert JDBC logs
		final List<String> jdbcLogSqlText = omitLogsComesFromAfterSaveEventPublisherThread(
				TestJDBCLogger.getAllLogDataAsSqlText());
		assertNoneOfLogsMatches(jdbcLogSqlText, PROPS_SELECT_PATTERN, TITLE_SELECT_ALL_PATTERN,
				TITLES_INSERT_PATTERN);


		//Assert neither Standard nor Lazy container is used
		assertNonLazySldContainerUsageLogged(titlePk).occurrences(0);
		assertLazySldContainerUsageLogged(titlePk).occurrences(0);
		assertAccessToWrappedSldContainerLogged(titlePk).occurrences(0);
	}

	protected void enableGDPRAudit()
	{
		auditAllTypesEnabledProperty.switchToValue("true");
		auditTestConfigManager.enableAuditingForTypes(UserModel._TYPECODE, AddressModel._TYPECODE, TitleModel._TYPECODE);
	}

	protected void disableGDPRAudit()
	{
		auditAllTypesEnabledProperty.switchToValue("false");
		auditTestConfigManager.disableAuditingForTypes(UserModel._TYPECODE, AddressModel._TYPECODE, TitleModel._TYPECODE);
	}

	private void createTestData()
	{
		final UserModel user = auditTestHelper.createItem(() -> creator.createUser("adam", "Adam"));
		final TitleModel title = auditTestHelper.createItem(() -> creator.createTitle("Mr", "Mister"));
		final AddressModel address = auditTestHelper.createItem(() -> creator.createAddress("Somewhere", "Else", user));

		address.setTitle(title);
		modelService.save(address);

		user.setDefaultPaymentAddress(address);
		modelService.save(user);
	}

	public static class TestSlf4jAuditableActionHandler implements AuditableActionHandler
	{
		private static final Logger LOG = LoggerFactory.getLogger(TestSlf4jAuditableActionHandler.class);

		@Override
		public void auditAction(final AuditableActions.Action action)
		{
			LOG.warn("Action {} {}", action.getActionName(), action.getActionAttributes());
		}
	}

	protected TestLogListenerAssert assertNonLazySldContainerUsageLogged(final PK pk)
	{
		return TestLogListenerAssert.assertThat(testLogListener)
		                            .hasLog()
		                            .withMessageContaining("Using non-lazy SLDDataContainer for PK: " + pk)
		                            .loggedFrom(
				                            AuditDataProvider.class);
	}


	protected TestLogListenerAssert assertLazySldContainerUsageLogged(final PK pk)
	{
		return TestLogListenerAssert.assertThat(testLogListener)
		                            .hasLog()
		                            .withMessageContaining("Using lazy SLDDataContainer for PK: " + pk)
		                            .loggedFrom(
				                            AuditDataProvider.class);
	}

	protected TestLogListenerAssert assertAccessToWrappedSldContainerLogged(final PK pk)
	{
		return TestLogListenerAssert.assertThat(testLogListener)
		                            .hasLog()
		                            .withMessageContaining("Lazy loading SLDDataContainer for PK: " + pk)
		                            .loggedFrom(LazySLDDataContainer.class);
	}

	protected TestLogListenerAssert assertItemPkLogged(final PK pk)
	{
		return assertAuditLogHasValue("PK=" + pk.toString());
	}

	protected TestLogListenerAssert assertTypePkLogged(final PK pk)
	{
		return assertAuditLogHasValue("typePK=" + pk.toString());
	}

	protected TestLogListenerAssert assertCreationLogged()
	{
		return assertAuditLogHasValue("changeType=CREATION");
	}

	protected TestLogListenerAssert assertDeletionLogged()
	{
		return assertAuditLogHasValue("changeType=DELETION");
	}

	protected TestLogListenerAssert assertUpdateLogged()
	{
		return assertAuditLogHasValue("changeType=MODIFICATION");
	}

	protected TestLogListenerAssert assertMessageLogged(final String message)
	{
		return assertAuditLogHasValue("message=" + message);
	}

	protected TestLogListenerAssert assertDbAuditLogged()
	{
		return assertAuditLogHasValue("DB_AUDIT");
	}

	protected TestLogListenerAssert assertAuditLogHasValue(final String message)
	{
		return TestLogListenerAssert.assertThat(testLogListener).hasLog().withMessageContaining(message)
		                            .loggedFrom(TestSlf4jAuditableActionHandler.class);
	}

	protected void assertNoneOfLogsMatches(final List<String> jdbcLogSqlText, final Pattern... patterns)
	{
		for (final var singleLog : jdbcLogSqlText)
		{
			for (final var pattern : patterns)
			{
				assertThat(singleLog).doesNotMatch(pattern);
			}
		}
	}

	protected void assertNoneOfLogsMatchesWithPkAndPattern(final List<String> jdbcLogSqlText, final PK pk,
	                                                       final Pattern... patterns)
	{
		for (final var singleLog : jdbcLogSqlText)
		{
			for (final var pattern : patterns)
			{
				assertThat(singleLog.contains(pk.toString()) && pattern.matcher(singleLog).matches()).isFalse();
			}
		}
	}

	protected void assertLogMatchesWithPkAndPattern(final List<String> jdbcLogSqlText, final PK pk, final Pattern... patterns)
	{
		for (final var pattern : patterns)
		{
			final boolean hasMatch = jdbcLogSqlText.stream()
			                                       .anyMatch(sqlText -> pattern.matcher(sqlText).matches() && sqlText.contains(
					                                       pk.toString()));
			assertThat(hasMatch).isTrue();
		}
	}

	protected void assertLogMatchesWithPkAndPattern(final List<String> jdbcLogSqlText, final PK pk, final Pattern pattern)
	{
		final boolean hasMatch = jdbcLogSqlText.stream()
		                                       .anyMatch(sqlText -> pattern.matcher(sqlText).matches() && sqlText.contains(
				                                       pk.toString()));
		assertThat(hasMatch).isTrue();
	}

	protected void assertLogMatchesWithPkAndPattern(final List<String> jdbcLogSqlText, final PK pk, final Pattern pattern,
	                                                final int expectedOccurrences)
	{
		final long occurrences = jdbcLogSqlText.stream()
		                                       .filter(sqlText -> pattern.matcher(sqlText).matches() && sqlText.contains(
				                                       pk.toString()))
		                                       .count();
		assertThat(occurrences).isEqualTo(expectedOccurrences);
	}

	protected void assertDbAuditLogForCreation(final PK pk)
	{
		assertDbAuditLogged().occurrences(1);
		assertItemPkLogged(pk).occurrences(1);
		assertCreationLogged().occurrences(1);
	}

	protected void assertDbAuditForUpdate(final PK titlePk)
	{
		assertDbAuditLogged().occurrences(1);
		assertItemPkLogged(titlePk).occurrences(1);
		assertUpdateLogged().occurrences(1);
	}

	protected void assertDbAuditForRemoval(final PK titlePk)
	{
		assertDbAuditLogged().occurrences(1);
		assertItemPkLogged(titlePk).occurrences(1);
		assertDeletionLogged().occurrences(1);
	}


	protected PK txInsertWithLegacyPersistence() throws Exception
	{
		//given
		final TitleModel titleModel = modelService.create(TitleModel.class);
		titleModel.setCode(UUID.randomUUID().toString());

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		TestJDBCLogger.enable(true, "titles,props");

		//when
		tx.execute(() ->
				PersistenceUtils.doWithLegacyPersistence(() -> {
					modelService.save(titleModel);
					return null;
				}));

		return titleModel.getPk();
	}

	protected PK txInsertAndRemoveInSingleTxWithLegacy() throws Exception
	{
		//given
		final TitleModel titleModel = modelService.create(TitleModel.class);
		titleModel.setCode(UUID.randomUUID().toString());

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		TestJDBCLogger.enable(true,"titles,props");

		//when
		return tx.execute(() ->
				PersistenceUtils.doWithLegacyPersistence(() -> {
					modelService.save(titleModel);
					modelService.remove(titleModel);
					return titleModel.getPk();
				}));

	}


	protected PK txUpdateWithLegacyPersistence() throws Exception
	{
		//given
		final String newTitleName = "newTitleName";
		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		TestJDBCLogger.enable(true,"titles,props");
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);

		//when
		return tx.execute(() ->
				PersistenceUtils.doWithLegacyPersistence(() -> {
					titleModelForLegacyUpdate.setName(newTitleName);
					modelService.save(titleModelForLegacyUpdate);
					return titleModelForLegacyUpdate.getPk();
				}));
	}

	protected PK txRemoveWithLegacyPersistence() throws Exception
	{
		//given
		final PK titlePk = titleModelForLegacyRemove.getPk();

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		TestJDBCLogger.enable(true, "titles,props");
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);

		//when
		tx.execute(() ->
				PersistenceUtils.doWithLegacyPersistence(() -> {
					modelService.remove(titlePk);
					return null;
				}));
		return titlePk;
	}

	protected PK txUpdateWithDirectPersistence() throws Exception
	{
		//given
		final String newTitleName = "newTitleName";

		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		allowDirectPersistenceForTitle.switchToValue("true");
		TestJDBCLogger.enable(true, "titles,props");

		//when
		tx.execute(() ->
				PersistenceUtils.doWithSLDPersistence(() -> {
					titleModelForSldUpdate.setName(newTitleName);
					modelService.save(titleModelForSldUpdate);
					return null;
				}));

		return titleModelForSldUpdate.getPk();
	}

	protected PK txInsertWithDirectPersistence() throws Exception
	{
		//given
		final String titleCode = "title-55712323177" + UUID.randomUUID();
		final TitleModel titleModel = modelService.create(TitleModel.class);
		titleModel.setCode(titleCode);

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		allowDirectPersistenceForTitle.switchToValue("true");
		TestJDBCLogger.enable(true, "titles,props");

		//when
		tx.execute(() ->
				PersistenceUtils.doWithSLDPersistence(() -> {
					modelService.save(titleModel);
					return null;
				}));

		return titleModel.getPk();
	}

	protected PK txInsertAndRemoveInSingleTxWithDirectPersistence() throws Exception
	{
		//given
		final String titleCode = "title-" + UUID.randomUUID();
		final TitleModel titleModel = modelService.create(TitleModel.class);
		titleModel.setCode(titleCode);

		//and
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		allowDirectPersistenceForTitle.switchToValue("true");
		TestJDBCLogger.enable(true,"titles,props");

		//when
		return tx.execute(() ->
				PersistenceUtils.doWithSLDPersistence(() -> {
					modelService.save(titleModel);
					modelService.remove(titleModel);
					return titleModel.getPk();
				}));

	}

	protected PK txRemoveWithDirectPersistence() throws Exception
	{
		//given
		final Transaction tx = Transaction.current();
		assertThat(tx.isRunning()).isFalse();

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		allowDirectPersistenceForTitle.switchToValue("true");
		TestJDBCLogger.enable(true, "titles,props");

		//and
		final PK titlePk = titleModelForSldRemove.getPk();

		//when
		tx.execute(() ->
				PersistenceUtils.doWithSLDPersistence(() -> {
					modelService.remove(titleModelForSldRemove);
					return null;
				}));
		return titlePk;
	}


	protected PK nonTransactionalRemove()
	{
		//given
		final PK titlePk = titleModelForNoTxRemove.getPk();

		//and
		final Map<String, Object> sessionParams = Map.of(SessionContext.TRANSACTION_IN_CREATE_DISABLED, Boolean.TRUE,
				PersistenceUtils.PERSISTENCE_LEGACY_MODE, Boolean.TRUE);

		//and
		TestJDBCLogger.enable(true, "titles,props");
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);

		//when
		sessionService.executeInLocalViewWithParams(sessionParams, new SessionExecutionBody()
		{
			@Override
			public void executeWithoutResult()
			{
				modelService.remove(titleModelForNoTxRemove);
			}
		});
		return titlePk;
	}

	protected PK nonTransactionalInsertOperation()
	{
		//given
		final String titleCode = "title-23409534898067" + UUID.randomUUID();
		final TitleModel titleModel = modelService.create(TitleModel.class);
		titleModel.setCode(titleCode);

		//and
		final Map<String, Object> sessionParams = Map.of(SessionContext.TRANSACTION_IN_CREATE_DISABLED, Boolean.TRUE,
				PersistenceUtils.PERSISTENCE_LEGACY_MODE, Boolean.TRUE);

		//and
		//Cleanup done in @After method
		logLevelSwitcherAuditSldContainer.switchLevel(Level.DEBUG);
		TestJDBCLogger.enable(true, "titles,props");

		//when
		sessionService.executeInLocalViewWithParams(sessionParams, new SessionExecutionBody()
		{
			@Override
			public void executeWithoutResult()
			{
				modelService.save(titleModel);
			}
		});

		return titleModel.getPk();
	}

	static List<String> omitLogsComesFromAfterSaveEventPublisherThread(final List<String> jdbcLogSqlText)
	{
		return jdbcLogSqlText.stream().filter(log -> !log.contains("AfterSaveEventPublisherThread")).toList();
	}

	private String getSqlDeleteForTitle()
	{
		ComposedTypeModel titleType = typeService.getComposedTypeForCode(TitleModel._TYPECODE);

		return FluentSqlBuilder.genericBuilder()
		                       .delete()
		                       .from(titleType.getTable())
		                       .where()
		                       .field(TitleModel.PK)
		                       .isEqual()
		                       .toSql();
	}

	/**
	 * Allows to create TitleModel without registration for removal in @After method
	 */
	private TitleModel createTitleModelOutsideTitleCreator()
	{
		final String titleCode = "testCode" + UUID.randomUUID();
		final String titleName = "testName123" + UUID.randomUUID();

		TitleModel titleModelForRemoval = modelService.create(TitleModel.class);
		titleModelForRemoval.setCode(titleCode);
		titleModelForRemoval.setName(titleName);
		modelService.save(titleModelForRemoval);

		return titleModelForRemoval;
	}

}
