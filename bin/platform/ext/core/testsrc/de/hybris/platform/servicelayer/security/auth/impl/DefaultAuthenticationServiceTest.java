/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.security.auth.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.JaloConnection;
import de.hybris.platform.jalo.security.JaloSecurityException;
import de.hybris.platform.persistence.security.EJBPasswordEncoderNotFoundException;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.security.auth.AuthenticationService;
import de.hybris.platform.servicelayer.security.auth.InvalidCredentialsException;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.exceptions.PasswordEncoderNotFoundException;
import de.hybris.platform.servicelayer.user.impl.DefaultUserService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.RandomTextUtils;
import de.hybris.platform.util.TestPropertiesUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.Sets;


@IntegrationTest
public class DefaultAuthenticationServiceTest extends ServicelayerTransactionalBaseTest
{
	private static final Logger LOG = Logger.getLogger(DefaultAuthenticationServiceTest.class.getName());

	private static final String TEST_USER = "delluriel";

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Resource
	private AuthenticationService authenticationService;

	@Resource
	private ModelService modelService;

	@Resource
	private UserService userService;

	private UserModel testUser;
	private UserModel anonymous;

	private static final PropertyConfigSwitcher anonymousLoginDisabled = new PropertyConfigSwitcher(
			DefaultAuthenticationService.LOGIN_ANONYMOUS_ALWAYS_DISABLED);

	private static Properties testProperties;

	@BeforeClass
	public static void beforeAll()
	{
		testProperties = TestPropertiesUtils.loadTestPropertiesFor(DefaultAuthenticationServiceTest.class);
	}

	@Before
	public void setUp()
	{
		anonymous = userService.getUserForUID("anonymous");

		testUser = modelService.create(UserModel.class);
		testUser.setUid("testUser");
		modelService.save(testUser);
		userService.setPassword(testUser.getUid(), testProperties.getProperty("testuser.password"), "bcrypt");

		assertThat(userService.getCurrentUser()).isEqualTo(anonymous);
	}

	@After
	public void tearDown()
	{
		anonymousLoginDisabled.switchBackToDefault();
	}

	@Test
	public void testLoginLogout() throws InvalidCredentialsException, JaloSecurityException
	{
		final UserModel result = authenticationService.login(testUser.getUid(), testProperties.getProperty("testuser.password"));

		assertThat(result).isEqualTo(testUser);
		assertThat(userService.getCurrentUser()).isEqualTo(testUser);

		authenticationService.logout();

		assertThat(userService.getCurrentUser()).isEqualTo(anonymous);

		// create session for test tear down
		jaloSession = JaloConnection.getInstance().createAnonymousCustomerSession();
	}

	@Test(expected = InvalidCredentialsException.class)
	public void testLoginWithEmptyPassword() throws InvalidCredentialsException, EJBPasswordEncoderNotFoundException
	{
		//given
		final UserModel emp = createUserWithEmptyPassword();

		//when
		authenticationService.login(emp.getName(), "");
	}

	private UserModel createUserWithEmptyPassword()
	{
		final UserModel emp = modelService.create(EmployeeModel.class);
		final String value = UUID.randomUUID().toString();
		emp.setUid(value);
		emp.setName(value);
		emp.setGroups(Sets.newHashSet(userService.getAdminUserGroup()));
		modelService.saveAll();
		return emp;
	}

	@Test(expected = InvalidCredentialsException.class)
	public void testLoginWrongPwd() throws InvalidCredentialsException
	{
		authenticationService.login(testUser.getUid(), RandomTextUtils.randomText(5));
	}

	@Test(expected = InvalidCredentialsException.class)
	public void testLoginWrongUser() throws InvalidCredentialsException
	{
		authenticationService.login("bla", testProperties.getProperty("testuser.password"));
	}

	@Test
	public void shouldThrowInvalidCredentialsExceptionWhenLoginIsDisabled()
	{
		// given
		testUser.setLoginDisabled(true);
		modelService.save(testUser);

		try
		{
			// when
			authenticationService.login(testUser.getUid(), testProperties.getProperty("testuser.password"));
			fail("should throw InvalidCredentialsException");
		}
		catch (final InvalidCredentialsException e)
		{
			// then
			assertThat(e.getMessage()).isEqualTo("invalid credentials");
		}
	}

	@Test
	public void shouldThrowInvalidCredentialsExceptionWhenUserIsDeactivated()
	{
		// given
		testUser.setDeactivationDate(Date.from(Instant.now().minus(Duration.ofHours(4))));
		modelService.save(testUser);

		try
		{
			// when
			authenticationService.login(testUser.getUid(), RandomTextUtils.randomText(3));
			fail("should throw InvalidCredentialsException");
		}
		catch (final InvalidCredentialsException e)
		{
			// then
			assertThat(e.getMessage()).isEqualTo("invalid credentials");
		}
	}

	@Test
	public void shouldLoginWhenUserIsDeactivatedInFuture() throws InvalidCredentialsException
	{
		// given
		testUser.setDeactivationDate(Date.from(Instant.now().plus(Duration.ofHours(4))));
		modelService.save(testUser);


		final UserModel result = authenticationService.login(testUser.getUid(), testProperties.getProperty("testuser.password"));
		assertThat(result).isEqualTo(testUser);
		assertThat(userService.getCurrentUser()).isEqualTo(testUser);
	}


	@Test
	public void shouldThrowInvalidCredentialsExceptionWhenPasswordEncodingIsWrongOrNotKnown()
	{
		// given
		final String password = RandomTextUtils.randomText(3);
		testUser.setPasswordEncoding("someNonExistend");

		try
		{
			// when
			authenticationService.login(testUser.getUid(), password);
			fail("should throw InvalidCredentialsException");
		}
		catch (final InvalidCredentialsException e)
		{
			// then
			assertThat(e.getMessage()).isEqualTo("invalid credentials");
		}
	}

	@Test
	public void testCheckCredentials() throws InvalidCredentialsException
	{
		final UserModel result = authenticationService.checkCredentials(testUser.getUid(), testProperties.getProperty("testuser.password"));

		assertThat(result).isEqualTo(testUser);
		assertThat(userService.getCurrentUser()).isEqualTo(anonymous);
	}

	@Test(expected = InvalidCredentialsException.class)
	public void testCheckCredentialsWrongPwd() throws InvalidCredentialsException
	{
		authenticationService.checkCredentials(testUser.getUid(), RandomTextUtils.randomText(4));
	}

	@Test(expected = InvalidCredentialsException.class)
	public void testCheckCredentialsWrongUser() throws InvalidCredentialsException
	{
		authenticationService.checkCredentials("bla", RandomTextUtils.randomText(3));
	}

	@Test
	public void testEncodedPasswords() throws ConsistencyCheckException
	{
		final UserModel foo = new UserModel();
		modelService.initDefaults(foo);
		foo.setUid("testuser.encoded");
		modelService.save(foo);
		final String password = RandomTextUtils.randomText(6);
		userService.setPassword("testuser.encoded", password, "bcrypt");
		try
		{
			authenticationService.checkCredentials(foo.getUid(), password);
			LOG.info("Authetication successful!");
		}
		catch (final InvalidCredentialsException e)
		{
			fail(e.getMessage());
		}
	}

	/**
	 * small test for getting the encoder not found exception
	 */
	@Test(expected = PasswordEncoderNotFoundException.class)
	public void testFalseEncoding()
	{
		userService.setPassword(testUser.getUid(), RandomTextUtils.randomText(6), "blub");
		fail("there should be no 'blub' encoding - so expected an exception here");
	}


	@Test
	public void testChangePassword() throws Exception
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(TEST_USER);
		user.setName(TEST_USER);

		modelService.save(user);

		final String password = RandomTextUtils.randomText(4);
		userService.setPassword(TEST_USER, password, "argon2");

		final UserModel userAgain = userService.getUserForUID(TEST_USER);
		assertThat(userAgain).isNotNull();
		assertThat(userAgain.getPasswordEncoding()).isEqualTo("argon2");


		authenticationService.checkCredentials(TEST_USER, password);

		final String password2 = RandomTextUtils.randomText(7);
		userService.setPassword(TEST_USER, password2, "bcrypt");
		modelService.refresh(userAgain);
		assertThat(userAgain.getPasswordEncoding()).isEqualTo("bcrypt");


		authenticationService.checkCredentials(TEST_USER, password2);

		final String password3 = RandomTextUtils.randomText(7);
		userService.setPassword(TEST_USER, password3, "bcrypt");
		assertThat(userAgain.getPasswordEncoding()).isEqualTo("bcrypt"); // THIS ASSERT WILL FAIL WITH THE REPORTED VALUE BEING "*"

		authenticationService.checkCredentials(TEST_USER, password3);
	}

	@Test
	public void shouldThrowInvalidCredentialsExceptionWhenUserIsAnonymousAndAnonymousLoginIsDisabled()
			throws InvalidCredentialsException
	{
		// given
		anonymousLoginDisabled.switchToValue("true");

		// then
		thrown.expect(InvalidCredentialsException.class);
		thrown.expectMessage("Anonymous login is disabled");

		// when
		authenticationService.login(anonymous.getUid(), anonymous.getEncodedPassword());

	}
}
