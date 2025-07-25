/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.core.model.type.SearchRestrictionModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.CoreBasicDataCreator;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.persistence.SystemEJB;
import de.hybris.platform.persistence.security.DeprecatedPasswordEncoder;
import de.hybris.platform.persistence.security.EJBPasswordEncoderDeprecatedException;
import de.hybris.platform.persistence.security.PasswordEncoderFactory;
import de.hybris.platform.persistence.security.PlainTextPasswordEncoder;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.TestImportCsvUtil;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.event.events.AfterSessionUserChangeEvent;
import de.hybris.platform.servicelayer.exceptions.ClassMismatchException;
import de.hybris.platform.servicelayer.exceptions.ModelRemovalException;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.model.ModelContextUtils;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.exceptions.CannotDecodePasswordException;
import de.hybris.platform.servicelayer.user.exceptions.PasswordEncoderNotFoundException;
import de.hybris.platform.servicelayer.user.impl.DefaultUserService;
import de.hybris.platform.servicelayer.user.interceptors.ModifySystemUsersInterceptor;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.RandomTextUtils;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.quality.Strictness;
import org.springframework.context.ApplicationListener;

import com.google.common.collect.Sets;


@IntegrationTest
public class UserServiceTest extends ServicelayerBaseTest
{
	private MockitoSession mockito;

	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	@Resource
	private TypeService typeService;

	@Resource
	private EventService eventService;

	@Resource(name = "testImportCsvUtil")
	protected TestImportCsvUtil importCsvUtil;

	@Resource(name = "core.passwordEncoderFactory")
	private PasswordEncoderFactory encoderFactory;

	@Mock
	private ApplicationListener<AfterSessionUserChangeEvent> userChangeListener;

	private static final String TEST_AGENT1 = "testagent";
	private static final String TEST_AGENT2 = "testagent2";

	private final PropertyConfigSwitcher adminPasswordRequired = new PropertyConfigSwitcher("admin.password.required");

	@Before
	public void setUp() throws Exception
	{
		mockito = Mockito.mockitoSession().initMocks(this).strictness(Strictness.LENIENT).startMocking();

		final User jaloUser = UserManager.getInstance().getAnonymousCustomer();

		final CoreBasicDataCreator creator = new CoreBasicDataCreator();
		creator.createBasicC2L();
		creator.createBasicUserGroups();

		assertFalse("Groups is empty (Jalo)", jaloUser.getGroups().isEmpty());
		final UserGroup userGroup = UserManager.getInstance().getUserGroupByGroupID("customergroup");
		assertNotNull(userGroup);
		assertTrue(jaloUser.isMemberOf(userGroup));
		Config.setParameter(DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED, "true");
	}

	@After
	public void tearDown() throws Exception
	{
		mockito.finishMocking();
		adminPasswordRequired.switchBackToDefault();
		Config.setParameter(DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED, "false");
	}

	@Test
	public void testGetUserForUIDFails()
	{
		//null test
		try
		{
			userService.getUserForUID(null);
			fail("exception was expected but didn't happen");
		}
		catch (final IllegalArgumentException e)
		{
			//ok here
		}
		catch (final Exception e)
		{
			fail("unexpected exception");
		}

		//empty test
		try
		{
			userService.getUserForUID("");
			fail("exception was expected but didn't happen");
		}
		catch (final UnknownIdentifierException e)
		{
			// ok here
		}
		catch (final Exception e)
		{
			fail("unexpected exception");
		}

		//unknown test
		try
		{
			userService.getUserForUID("sgagvgaw2kw1okskvfs");
			fail("exception was expected but didn't happen");
		}
		catch (final UnknownIdentifierException e)
		{
			//ok here
		}
		catch (final Exception e)
		{
			fail("unexpected exception");
		}
	}

	@Test
	public void testSetAndGetCurrentUser()
	{
		final UserModel admin = userService.getAdminUser();

		userService.setCurrentUser(admin);

		final UserModel gotUser = userService.getCurrentUser();

		assertEquals("no admin user", admin, gotUser);
	}

	@Test
	public void testGetCurrentUser()
	{
		final UserModel user = userService.getAnonymousUser();

		// set user in jalo session
		JaloSession.getCurrentSession().setUser((User) modelService.getSource(user));

		// get current from user service
		final UserModel actual = userService.getCurrentUser();

		assertNotNull("Current user is null.", actual);
		assertEquals("Current user differs.", user, actual);
	}

	@Test
	public void testSetCurrentUser()
	{
		JaloSession.getCurrentSession().setUser(UserManager.getInstance().getAdminEmployee());

		// setup final application listener for AfterUserChangedEvent
		doNothing().when(userChangeListener).onApplicationEvent(any(AfterSessionUserChangeEvent.class));
		try
		{
			eventService.registerEventListener(userChangeListener);

			// get a user reference
			final UserModel user = userService.getAnonymousUser();

			// set current user
			userService.setCurrentUser(user);

			// user set on jalo session?
			final UserModel actual = modelService.get(JaloSession.getCurrentSession().getUser());

			assertNotNull("Current user is null.", actual);
			assertEquals("Current user differs.", user, actual);

			// event received?
			Mockito.verify(userChangeListener, Mockito.times(1))
			       .onApplicationEvent(Mockito.argThat(new ArgumentMatcher<AfterSessionUserChangeEvent>()
			       {
				       @Override
				       public boolean matches(final AfterSessionUserChangeEvent event)
				       {
					       return event.getSource().equals(JaloSession.getCurrentSession());
				       }

			       }));
		}
		finally
		{
			eventService.unregisterEventListener(userChangeListener);
		}
	}

	@Test
	public void testGetUserForUIDWithClass()
	{
		try
		{
			userService.getUserForUID("anonymous", EmployeeModel.class);
			fail();
		}
		catch (final ClassMismatchException e)
		{
			// ok
		}

		try
		{
			userService.getUserForUID("admin", CustomerModel.class);
			fail();
		}
		catch (final ClassMismatchException e)
		{
			// ok
		}

		final EmployeeModel admin1 = userService.getUserForUID("admin", EmployeeModel.class);
		final CustomerModel anon2 = userService.getUserForUID("anonymous", CustomerModel.class);

		final UserModel anon3 = userService.getUserForUID("anonymous", UserModel.class);
		final UserModel admin3 = userService.getUserForUID("admin", UserModel.class);

		assertNotNull(admin1);
		assertEquals(EmployeeModel.class, admin1.getClass());

		assertNotNull(anon2);
		assertEquals(CustomerModel.class, anon2.getClass());

		assertNotNull(anon3);
		assertNotNull(admin3);
		assertEquals(CustomerModel.class, anon3.getClass());
		assertEquals(EmployeeModel.class, admin3.getClass());
	}

	@Test
	public void testGetUserForUID()
	{
		final UserModel user = userService.getUserForUID("anonymous");
		assertNotNull("User", user);
		assertEquals("Login", "anonymous", user.getUid());
	}

	@Test
	public void testGetAllUserGroupsForUser()
	{
		final User jaloUser = UserManager.getInstance().getAnonymousCustomer();

		final UserModel user = userService.getUserForUID("anonymous");

		assertEquals(jaloUser.getPK(), user.getPk());
		assertNotNull("User", user);

		final Collection<UserGroupModel> groups = userService.getAllUserGroupsForUser(user);
		assertNotNull("Groups", groups);

		assertFalse(modelService.isModified(user));
		assertTrue(ModelContextUtils.getItemModelContext(user).isLoaded(UserModel.GROUPS));
		assertFalse(ModelContextUtils.getItemModelContext(user).isDirty(UserModel.GROUPS));

		final Set<PrincipalGroupModel> groupsDirect = user.getGroups();
		assertTrue(groups.containsAll(groupsDirect));

		final UserGroup userGroup = UserManager.getInstance().getUserGroupByGroupID("customergroup");
		assertNotNull(userGroup);
		assertTrue(jaloUser.isMemberOf(userGroup));
		assertTrue(jaloUser.getGroups().contains(userGroup));
		assertFalse("Groups is empty(Jalo)", jaloUser.getGroups().isEmpty());
		assertFalse("Groups is empty", groups.isEmpty());
	}

	@Test
	public void testModifySystemUsersInterceptorForRemove()
	{
		final UserModel anon = userService.getAnonymousUser();
		final UserModel admin = userService.getAdminUser();
		final UserGroupModel admingroup = userService.getAdminUserGroup();

		removePrincipal(anon);
		removePrincipal(admin);
		removePrincipal(admingroup);

		assertNotNull(userService.getAnonymousUser());
		assertNotNull(userService.getAdminUser());
		assertNotNull(userService.getAdminUserGroup());
	}


	@Test
	public void testModifySystemUsersInterceptorForModify()
	{
		final UserModel anon = userService.getAnonymousUser();
		final UserModel admin = userService.getAdminUser();
		final UserGroupModel admingroup = userService.getAdminUserGroup();

		modifyPrincipal(anon);
		modifyPrincipal(admin);
		modifyPrincipal(admingroup);

		assertEquals("anonymous id was changed", "anonymous", userService.getAnonymousUser().getUid());
		assertEquals("admin id was changed", "admin", userService.getAdminUser().getUid());
		assertEquals("admingroup id was changed", "admingroup", userService.getAdminUserGroup().getUid());
	}

	/*
	 * this method tries to remove the given principal which should fail!
	 */
	private void removePrincipal(final PrincipalModel principal)
	{
		try
		{
			modelService.remove(principal);
			fail("there should be a ModelSavingException!");
		}
		catch (final ModelRemovalException e)
		{
			assertTrue("The cause was not an InterceptorException!", e.getCause() instanceof InterceptorException);
			final InterceptorException ie = (InterceptorException) e.getCause();
			assertTrue(ie.getInterceptor() instanceof ModifySystemUsersInterceptor);
			assertTrue(
					"You received a message " + e.getCause().getMessage()
							+ "\n, but it should contain 'It is not allowed to remove the system account: !' ",
					e.getCause().getMessage().contains("It is not allowed to remove the system account: "));
		}
		catch (final Exception e)
		{
			fail("Got exception different as ModelSavingException");
		}
	}

	/*
	 * this method tries to modify the uid for the given principal and save this. This should fail!
	 */
	private void modifyPrincipal(final PrincipalModel principal)
	{
		try
		{
			principal.setUid("xxx");
			modelService.save(principal);
			fail("there should be a ModelSavingException!");
		}
		catch (final ModelSavingException e)
		{
			assertTrue("The cause was not an InterceptorException!", e.getCause() instanceof InterceptorException);
			final InterceptorException ie = (InterceptorException) e.getCause();
			assertTrue(ie.getInterceptor() instanceof ModifySystemUsersInterceptor);
			assertTrue(
					"You received a message " + e.getCause().getMessage()
							+ "\n, but it should contain 'It is not allowed to modify the UID for the system account: ' ",
					e.getCause().getMessage().contains("It is not allowed to modify the UID for the system account: "));
		}
		catch (final Exception e)
		{
			fail("Got exception different as ModelSavingException");

		}
		finally
		{
			modelService.refresh(principal);
		}
	}

	@Test
	public void testGetSystemUsersWithRestrictedUser()
	{
		final CustomerModel user = modelService.create(CustomerModel.class);
		user.setUid("xxx");
		modelService.save(user);

		final SearchRestrictionModel searchRestriction = modelService.create(SearchRestrictionModel.class);
		searchRestriction.setActive(Boolean.TRUE);
		searchRestriction.setGenerate(Boolean.TRUE);
		searchRestriction.setCode("test_restriction");
		searchRestriction.setPrincipal(user);
		searchRestriction.setQuery("{" + PrincipalModel.UID + "} NOT IN ( 'anonymous', 'admin', 'admingroup' )");
		searchRestriction.setRestrictedType(typeService.getComposedTypeForClass(PrincipalModel.class));
		modelService.save(searchRestriction);

		userService.setCurrentUser(user);
		assertNotNull(userService.getAnonymousUser());
		assertNotNull(userService.getAdminUser());
		assertNotNull(userService.getAdminUserGroup());

		modelService.remove(searchRestriction); //just in case...
	}

	@Test
	public void testGetTitleForCode()
	{
		final TitleModel title = modelService.create(TitleModel.class);
		title.setCode("chef");
		title.setName("Cheffe");

		modelService.save(title);

		final TitleModel current = userService.getTitleForCode(title.getCode());
		assertNotNull("Title is null.", current);
		assertEquals("Title differs.", title, current);
	}

	@Test
	public void testGetUserGroupForUID()
	{
		final UserGroupModel group = modelService.create(UserGroupModel.class);
		group.setUid("Testgroup");
		group.setName("Testgroup");

		modelService.save(group);

		final UserGroupModel current = userService.getUserGroupForUID(group.getUid());
		assertNotNull("Group is null.", current);
		assertEquals("Group differs.", group, current);
	}

	@Test
	public void testGetPasswordWithPlainEncoding() throws ConsistencyCheckException
	{
		final String plainTextPassword = RandomTextUtils.randomText(3);
		final EmployeeModel testUser = modelService.create(EmployeeModel.class);
		testUser.setUid("testUser");
		modelService.save(testUser);
		userService.setPassword(testUser.getUid(), plainTextPassword, "plain");

		assertTrue(encoderFactory.getEncoder(testUser.getPasswordEncoding())
		                         .check(testUser.getUid(), testUser.getEncodedPassword(), plainTextPassword));

		try
		{
			final User axel = UserManager.getInstance().createEmployee("axel");
			axel.setName("Axel");
			axel.setPassword(RandomTextUtils.randomText(4), "bcrypt");
			userService.getPassword(axel.getUID());
			fail("expected " + CannotDecodePasswordException.class.getName());
		}
		catch (final CannotDecodePasswordException e)
		{
			//fine!
		}
	}

	@Test
	public void testSetPasswordWithUnknownEncoding()
	{

		final EmployeeModel axel = modelService.create(EmployeeModel.class);
		axel.setUid("axel2");
		axel.setName("Axel2");
		modelService.save(axel);

		final String testPassword = RandomTextUtils.randomText(4);

		try
		{
			userService.setPassword(axel.getUid(), testPassword, "enc");
			fail("expected " + PasswordEncoderNotFoundException.class.getName());
		}
		catch (final PasswordEncoderNotFoundException e)
		{
			//fine!
		}

		assertThat(axel.getEncodedPassword()).isNull();
		assertThat(axel.getPasswordEncoding()).isEqualTo(SystemEJB.DEFAULT_ENCODING);


		axel.setPasswordEncoding("enc");
		try
		{

			userService.setPassword(axel.getUid(), testPassword);
			fail("expected " + PasswordEncoderNotFoundException.class.getName());
		}
		catch (final PasswordEncoderNotFoundException e)
		{
			//fine!
		}


		assertThat(axel.getEncodedPassword()).isNull();
		assertThat(axel.getPasswordEncoding()).isEqualTo("enc");

	}

	@Test
	public void testSetPassword()
	{
		final EmployeeModel user = modelService.create(EmployeeModel.class);
		user.setUid("222");
		modelService.save(user);
		assertTrue(modelService.isUpToDate(user));
		assertFalse(modelService.isNew(user));
		assertFalse(modelService.isModified(user));

		userService.setPassword(user.getUid(), RandomTextUtils.randomText(8));

		assertTrue(modelService.isUpToDate(user));
		assertFalse(modelService.isNew(user));
		assertFalse(modelService.isModified(user));
		assertEquals(((DefaultUserService) userService).getDefaultPasswordEncoding(), user.getPasswordEncoding());

		final String passwordPlain = RandomTextUtils.randomText(13);
		userService.setPassword(user.getUid(), passwordPlain, "plain");
		assertTrue(encoderFactory.getEncoder(user.getPasswordEncoding())
		                         .check(user.getUid(), user.getEncodedPassword(), passwordPlain));
	}

	@Test
	public void shouldThrowExceptionWhenUsingPlainTextEncodingToSetPasswordWhileLegacyEncodingDisabled() throws ConsistencyCheckException
	{
		final String legacyPasswordEncodingEnabled = Config.getParameter(DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED);
		Config.setParameter(DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED, "false");

		final User jaloUser = UserManager.getInstance().createEmployee(RandomTextUtils.randomText(4));

		assertThatThrownBy(() -> jaloUser.setPassword(RandomTextUtils.randomText(8), "plain"))
				.isInstanceOf(EJBPasswordEncoderDeprecatedException.class)
				.hasMessageEndingWith("PlainTextPasswordEncoder is deprecated and cannot be used anymore!");

		Config.setParameter(DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED, legacyPasswordEncodingEnabled);
	}

	@Test
	public void testUserIDWithSpaces()
	{
		final EmployeeModel user = modelService.create(EmployeeModel.class);
		user.setUid(" moo ");
		modelService.save(user);

		try
		{
			userService.getUserForUID("moo");
			fail("user should not be found! expected UnknownIdentifierException");
		}
		catch (final UnknownIdentifierException e)
		{
			// ok
		}
		catch (final Exception e)
		{
			fail("user should not be found!");
		}
		assertEquals(user, userService.getUserForUID(" moo "));
	}

	@Test
	public void testFailOnAdminRoleAssignmentToExistingUserWithMissingMandatoryPassword()
	{
		adminPasswordRequired.switchToValue("true");
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("testAdminUser");
		modelService.save(user);

		assertFalse(userService.isAdmin(user));

		final UserGroupModel adminGroup = userService.getAdminUserGroup();

		user.setGroups(Sets.newHashSet(adminGroup));
		try
		{
			modelService.save(user);
			fail("Exception was expected but not thrown. Should not assign admin role to user with missing password");
		}
		catch (final Exception exc)
		{
			modelService.refresh(user);
			assertFalse(userService.isAdmin(user));
			assertFalse(userService.isMemberOfGroup(user, adminGroup));
		}
	}

	@Test
	public void testAdminRoleAssignmentToExistingUserWithMissingNonMandatoryPasswordSuccessful()
	{
		adminPasswordRequired.switchToValue("false");

		final UserModel user = modelService.create(UserModel.class);
		user.setUid("testAdminUser");
		modelService.save(user);

		assertFalse(userService.isAdmin(user));

		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		user.setGroups(Sets.newHashSet(adminGroup));
		modelService.save(user);

		modelService.refresh(user);
		assertTrue(userService.isAdmin(user));
	}

	@Test
	public void testFailAdminUserCreationWithMissingMandatoryPassword()
	{
		adminPasswordRequired.switchToValue("true");
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("testAdminUser");

		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		user.setGroups(Sets.newHashSet(adminGroup));
		try
		{
			modelService.save(user);
			fail("Exception was expected but not thrown. Should not create admin user with missing password");
		}
		catch (final Exception exc)
		{
			assertFalse(userService.isUserExisting(user.getUid()));
		}
	}

	@Test
	public void testAdminUserCreationWithMissingNonMandatoryPasswordSuccessful()
	{
		adminPasswordRequired.switchToValue("false");

		final UserModel user = modelService.create(UserModel.class);
		user.setUid("testAdminUser");

		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		user.setGroups(Sets.newHashSet(adminGroup));
		modelService.save(user);

		modelService.refresh(user);
		assertTrue(userService.isAdmin(user));
	}

	@Test
	public void testFailOnAdminUserPasswordChangeToNullWhenPasswordIsMandatory()
	{
		adminPasswordRequired.switchToValue("true");

		final String testPassword = RandomTextUtils.randomText(12);
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("testAdminUser");
		userService.setPassword(user, testPassword);

		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		user.setGroups(Sets.newHashSet(adminGroup));
		modelService.save(user);
		modelService.refresh(user);
		try
		{
			userService.setEncodedPassword(user, null);
			modelService.save(user);
			fail("Exception was expected but not thrown. Should not allow empty password for user from admin group");
		}
		catch (final Exception exc)
		{
			modelService.refresh(user);
			assertTrue(userService.isAdmin(user));
			assertTrue(userService.isMemberOfGroup(user, adminGroup));
			assertTrue(encoderFactory.getEncoder(user.getPasswordEncoding())
			                         .check(user.getUid(), user.getEncodedPassword(), testPassword));
		}
	}

	@Test
	public void testFailOnAdminRoleAssignmentToAnonymousUser()
	{
		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		final CustomerModel anonymousUser = userService.getAnonymousUser();
		assertThat(userService.isMemberOfGroup(anonymousUser, adminGroup)).isFalse();

		anonymousUser.setGroups(Sets.newHashSet(adminGroup));
		try
		{
			modelService.save(anonymousUser);
			fail("Exception was expected but not thrown. Should not assign admin role to anonymous user");
		}
		catch (final Exception exc)
		{
			modelService.refresh(anonymousUser);
			assertThat(userService.isAdmin(anonymousUser)).isFalse();
			assertThat(userService.isMemberOfGroup(anonymousUser, adminGroup)).isFalse();
		}
	}

	@Test
	public void testFailOnSubAdminRoleAssignmentToAnonymousUser()
	{
		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		final UserGroupModel group = modelService.create(UserGroupModel.class);
		group.setUid("Testgroup");
		group.setName("Testgroup");
		modelService.save(group);

		final UserGroupModel current = userService.getUserGroupForUID(group.getUid());
		current.setGroups(Sets.newHashSet(adminGroup));
		modelService.save(current);
		modelService.refresh(current);
		assertThat(userService.isAdminGroup(current)).isTrue();

		final CustomerModel anonymousUser = userService.getAnonymousUser();
		assertThat(userService.isMemberOfGroup(anonymousUser, current)).isFalse();

		anonymousUser.setGroups(Sets.newHashSet(current));
		try
		{
			modelService.save(anonymousUser);
			fail("Exception was expected but not thrown. Should not assign admin role to anonymous user");
		}
		catch (final Exception exc)
		{
			modelService.refresh(anonymousUser);
			assertThat(userService.isAdmin(anonymousUser)).isFalse();
			assertThat(userService.isMemberOfGroup(anonymousUser, current)).isFalse();
		}
	}

	@Test
	public void testIsAdminGroup()
	{
		final UserGroupModel adminGroup = userService.getAdminUserGroup();
		assertThat(userService.isAdminGroup(adminGroup)).isTrue();

		final UserGroupModel group = modelService.create(UserGroupModel.class);
		group.setUid("Testgroup");
		group.setName("Testgroup");
		modelService.save(group);

		final UserGroupModel current = userService.getUserGroupForUID(group.getUid());
		assertThat(userService.isAdminGroup(current)).isFalse();

		current.setGroups(Sets.newHashSet(adminGroup));
		modelService.save(current);
		modelService.refresh(current);

		assertThat(userService.isAdminGroup(current)).isTrue();
	}

	@Test
	public void testNestedGroups()
	{
		// given (after impex import below) - users (testagent, testagent2), groups(parentGroup, childgroup, CustomerList1, CustomerList2)
		// member -> group assignments:
		// testagent   -> parentGroup
		// testagent2  -> childGroup
		// childGroup  -> parentGroup
		// childGroup  -> CustomerList2
		// parentGroup -> CustomerList1

		importCsvUtil.importCsv("/impex/testfiles/nestedGroups.impex", "UTF-8");

		final UserModel user1 = userService.getUserForUID(TEST_AGENT1);
		assertNotNull(user1);

		final UserModel user2 = userService.getUserForUID(TEST_AGENT2);
		assertNotNull(user2);

		final UserGroupModel parentgroup = userService.getUserGroupForUID("parentgroup");
		assertNotNull(parentgroup);

		final UserGroupModel childgroup = userService.getUserGroupForUID("childgroup");
		assertNotNull(childgroup);

		assertTrue(parentgroup.getMembers().contains(childgroup));
		assertTrue(parentgroup.getMembers().contains(user1));
		assertEquals(2, parentgroup.getMembers().size());
		assertTrue(childgroup.getMembers().contains(user2));
		assertEquals(1, childgroup.getMembers().size());

		final UserGroupModel customerList1 = userService.getUserGroupForUID("CustomerList1");
		assertNotNull(customerList1);
		assertTrue(customerList1.getMembers().contains(parentgroup));
		assertEquals(1, customerList1.getMembers().size());

		final UserGroupModel customerList2 = userService.getUserGroupForUID("CustomerList2");
		assertNotNull(customerList2);
		assertTrue(customerList2.getMembers().contains(childgroup));
		assertEquals(1, customerList1.getMembers().size());

		final Set<PrincipalGroupModel> groupsForUser1 = user1.getGroups();
		assertEquals(1, groupsForUser1.size());
		assertTrue(groupsForUser1.contains(parentgroup));

		assertEquals(1, parentgroup.getGroups().size());
		assertTrue(parentgroup.getGroups().contains(customerList1));
		assertEquals(2, childgroup.getGroups().size());
		assertTrue(childgroup.getGroups().contains(customerList2));
		assertTrue(childgroup.getGroups().contains(parentgroup));
	}

}
