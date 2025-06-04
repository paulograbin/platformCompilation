/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.spring.security;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.enums.SAPUserVerificationPurpose;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.core.model.user.UserPasswordChangeAuditModel;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.persistence.security.PasswordEncoderFactory;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserIdDecorationService;
import de.hybris.platform.servicelayer.user.UserIdDecorationStrategy;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.impl.DefaultSapUserVerificationTokenService;
import de.hybris.platform.servicelayer.user.impl.DefaultUserIdDecorationService;
import de.hybris.platform.test.TestThreadsHolder;
import de.hybris.platform.tx.Transaction;
import de.hybris.platform.tx.TransactionBody;
import de.hybris.platform.util.Config;
import de.hybris.platform.validator.AuthenticationValidator;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;

import javax.annotation.Resource;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import java.time.LocalDate;
import java.time.ZoneId;

import com.google.common.collect.Sets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@IntegrationTest
public class CoreAuthenticationProviderTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;

	@Resource
	private DefaultUserIdDecorationService defaultUserIdDecorationService;

	@Resource
	private DefaultSapUserVerificationTokenService userVerificationTokenService;

	@Resource(name = "core.passwordEncoderFactory")
	private PasswordEncoderFactory encoderFactory;

	@Resource(name = "wsUserDetailsService")
	private CoreUserDetailsService coreUserDetailsService;

	@Resource
	private AuthenticationValidator<User> userAuthenticationValidator;

	@Resource
	private UserService userService;

	private UserManager userManager;
	private final CoreAuthenticationProvider coreAuthenticationProvider = spy(CoreAuthenticationProvider.class);
	private final RejectUserPreAuthenticationChecks rejectUserPreAuthenticationChecks = spy(
			RejectUserPreAuthenticationChecks.class);

	private static final String USER_ID = "test@sap.com";
	private static final String USER_NAME = "Test User";
	private static final String USER_PASSWORD = RandomStringUtils.randomAlphabetic(4);
	private static final String FOO_DECORATOR = "|foo";
	private static final String BAR_DECORATOR = "|bar";

	@Before
	public void setUp()
	{
		userManager = UserManager.getInstance();
		coreAuthenticationProvider.setUserDetailsService(coreUserDetailsService);
		coreAuthenticationProvider.setPreAuthenticationChecks(rejectUserPreAuthenticationChecks);
		coreAuthenticationProvider.setUserVerificationTokenService(userVerificationTokenService);
		coreAuthenticationProvider.setValidators(List.of(userAuthenticationValidator));
		coreAuthenticationProvider.setModelService(modelService);
	}

	@After
	public void tearDown()
	{
		userManager.setUserIdDecorationService(defaultUserIdDecorationService);
	}

	@Test
	public void shouldAuthenticateExistingUser()
	{
		//given
		enableOTPLoginConfiguration(false);
		createUser(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	@Test
	public void testCredentialsExpiredExceptionWithFallBackExpireDateIsElapsed()
	{
		// GIVEN: A user with a password change audit model that is older than 40 days with no password expiry period
		// set on the user groups, so it considers the default password expiry period as 30 days.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID);
		createUserAudit(userModel,40);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			coreAuthenticationProvider.authenticate(testAuthentication);
		}).withMessage("Password expired for the user: Test User");

		// THEN : the user is not disabled; the password change audit model is older than 30 days
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
	}

	@Test
	public void testUserDisabledWithInitialPasswordFallBackExpireDateIsElapsed()
	{
		// GIVEN: A user with a password change audit model that is older than 40 days with no initial password expiry period
		// set on the user groups, so it considers the default initial password expiry period as 30 days.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID, true);
		createUserAudit(userModel, 40);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		assertThatExceptionOfType(DisabledException.class).isThrownBy(() -> {
			coreAuthenticationProvider.authenticate(testAuthentication);
		}).withMessage("Initial password expired for the user: Test User");

		// THEN : the user is disabled, because the password change audit model is older than 30 days
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isTrue();
	}

	@Test
	public void testCredentialsExpiredExceptionWithInactivePasswordFallBackExpireDateIsElapsed()
	{
		// GIVEN: A user with last login in 40 days before
		// no configuration on the user groups, so it considers the default inactive password fallback as 30 days.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUserWithLastLogin(USER_ID, 40, null, null);
		createUserAudit(userModel, 40);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			coreAuthenticationProvider.authenticate(testAuthentication);
		}).withMessage("Inactive password expired for the user: Test User");

		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
		assertThat(userModel.getLastLogin()).isCloseTo(getExceptedPersistedLastLoginDate(40), 1000 * 60 * 60 * 24); // Allow a day of tolerance for edge cases
	}

	@Test
	public void testCredentialsExpiredExceptionThatPicksLeastConfiguredDate()
	{
		// GIVEN: A user with a password change audit model that is older than 30 days with password expiry period
		// on one of the user group as 20 days and other user group with 40.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID, 20, 40);
		createUserAudit(userModel,30);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			coreAuthenticationProvider.authenticate(testAuthentication);
		}).withMessage("Password expired for the user: Test User");

		// THEN : the user is not disabled; the password change audit model is older than 20 days (which is the least expiry days)
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();

	}

	@Test
	public void testUserWInitialPasswordIsDisabledThatPicksLeastConfiguredDate()
	{
		// GIVEN: A user with a password change audit model that is older than 30 days with initial password expiry period
		// on one of the user group as 20 days and other user group with 40.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID, 20, 40, true);
		createUserAudit(userModel, 30);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		assertThatExceptionOfType(DisabledException.class).isThrownBy(() -> {
			coreAuthenticationProvider.authenticate(testAuthentication);
		}).withMessage("Initial password expired for the user: Test User");

		// THEN : the user is disabled because the password change audit model is older than 20 days (which is the least expiry days)
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isTrue();
	}

	@Test
	public void testCredentialsExpiredExceptionForInactivePasswordPicksLeastConfiguredDate()
	{
		// GIVEN: A user with a last login of 30 days
		// on one of the user group inactive password expiration as 20 days and other user group with 40.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUserWithLastLogin(USER_ID, 30, 20, 40);
		createUserAudit(userModel, 40);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			coreAuthenticationProvider.authenticate(testAuthentication);
		}).withMessage("Inactive password expired for the user: Test User");

		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
		assertThat(userModel.getLastLogin()).isCloseTo(getExceptedPersistedLastLoginDate(30), 1000 * 60 * 60 * 24); // Allow a day of tolerance for edge cases
	}

	@Test
	public void testNoCredentialsExpiredExceptionWithFallbackExpireDateIsNotElapsed()
	{
		// GIVEN: A user with a password change audit model that is older than 20 days with no password expiry period
		// set on the user groups, so it considers the default password expiry period as 30 days.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID);
		createUserAudit(userModel,20);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		coreAuthenticationProvider.authenticate(testAuthentication);

		// THEN : the user is not disabled because the password change audit model is not older than 30 days
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
	}

	@Test
	public void testUserIsNotDisabledWithInitialPasswordFallbackExpireDateIsNotElapsed()
	{
		// GIVEN: A user with a password change audit model that is older than 20 days with no initial password expiry period
		// set on the user groups, so it considers the default initial password expiry period as 30 days.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID, true);
		createUserAudit(userModel, 20);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		coreAuthenticationProvider.authenticate(testAuthentication);

		// THEN : the user is not disabled because the password change audit model is not older than 30 days
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
	}

	@Test
	public void testNoCredentialsExpiredExceptionInactivePasswordWithFallbackExpireDateIsNotElapsed()
	{
		// GIVEN: A user with last login 20 days before with no configuration on the user groups, so it considers the default inactive password fallback period as 30 days.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUserWithLastLogin(USER_ID, 20, null, null);
		createUserAudit(userModel, 40);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		coreAuthenticationProvider.authenticate(testAuthentication);

		// THEN : the user is not disabled because the password change audit model is not older than 30 days
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
		assertThat(userModel.getLastLogin()).isCloseTo(getExceptedPersistedLastLoginDate(0), 1000 * 60 * 60 * 24); // Allow a day of tolerance for edge cases
	}


	@Test
	public void testNoCredentialsExpiredExceptionWithConfiguredExpireDateAsZero()
	{
		// GIVEN: A user with a password change audit model on one of the user group as 0 days and other user group with 10.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID,0,10);
		createUserAudit(userModel,20);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		coreAuthenticationProvider.authenticate(testAuthentication);

		// THEN : the user is not disabled because the user group have a value configured as 0 days
		// that means the password never expires
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
	}

	@Test
	public void testUserIsNotDisabledWithInitialPasswordConfiguredExpireDateAsZero()
	{
		// GIVEN: A user with a password change audit model on one of the user group as 0 days and other user group with 10 for initial password expiration.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUser(USER_ID, 0, 10, true);
		createUserAudit(userModel, 20);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		coreAuthenticationProvider.authenticate(testAuthentication);

		// THEN : the user is not disabled because the user group have a value configured as 0 days
		// that means the password never expires
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
	}

	@Test
	public void testNoCredentialsExpiredExceptionForInactivePasswordWithConfiguredExpireDateAsZero()
	{
		// GIVEN: A user with last login 20 days before on one of the user group as 0 days and other user group with 10.
		enableOTPLoginConfiguration(false);
		UserModel userModel = createUserWithLastLogin(USER_ID, 20, 0, 15);
		createUserAudit(userModel, 20);

		// WHEN: the user is validated
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		coreAuthenticationProvider.authenticate(testAuthentication);

		// THEN : the user is not disabled because the user group have a value configured as 0 days
		// that means the password never expires
		modelService.refresh(userModel);
		assertThat(userModel.isLoginDisabled()).isFalse();
		assertThat(userModel.getLastLogin()).isCloseTo(getExceptedPersistedLastLoginDate(0), 1000 * 60 * 60 * 24); // Allow a day of tolerance for edge cases
	}


	@Test
	public void shouldSucceedToAuthenticateExistingCustomerIfValidUsernameAndPasswordProvidedAndOTPIsDisabled()
	{
		//given
		enableOTPLoginConfiguration(false);
		createCustomer(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	@Test
	public void shouldSucceedToAuthenticateExistingEmployeeIfValidUsernameAndPasswordProvidedAndOTPIsDisabled()
	{
		//given
		enableOTPLoginConfiguration(false);
		createEmployee(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	@Test
	public void shouldSucceedToAuthenticateExistingEmployeeIfValidUsernameAndPasswordProvidedAndOTPIsEnabled()
	{
		//given
		enableOTPLoginConfiguration(true);
		createEmployee(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	@Test
	public void shouldAuthenticateExistingCustomerIfValidVerificationTokenIsProvidedAndOTPIsEnabled()
	{

		//given
		enableOTPLoginConfiguration(true);
		createCustomer(USER_ID);


		final var verificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, USER_ID);
		final var tokenId = verificationTokenData.getTokenId();

		final var anotherVerificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, USER_ID);

		final Authentication testAuthentication = createTestAuthentication(verificationTokenData.getTokenId(), verificationTokenData.getTokenCode());

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
		//verification token is consumed (does not exist any more)
		assertThatThrownBy(() -> userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN, tokenId)).isInstanceOf(
				UnknownIdentifierException.class);
		//user is not able to authenticate with the same verification token again
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);
		//another verification token still exists as it was not consumed
		assertThat(userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN,
				anotherVerificationTokenData.getTokenId())).isNotNull();
	}

	@Test
	public void shouldFailToAuthenticateExistingCustomerAndRemoveTokenIfVerificationTokenIsValidAndVerificationCodeDoesNotMatchForXTimesAndOTPIsEnabled()
	{

		//given
		enableOTPLoginConfiguration(true);
		createCustomer(USER_ID);

		final var verificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, USER_ID);
		final var tokenId = verificationTokenData.getTokenId();


		final Authentication testAuthentication = createTestAuthentication(verificationTokenData.getTokenId(), "invalid");

		//when, then
		final var maxNumberOfFailedAttempts = Config.getInt("otp.customer.login.max.failed.attempts", 3);

		for (int i = 0; i < maxNumberOfFailedAttempts; i++)
		{
			assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
					BadCredentialsException.class);

			if (i < maxNumberOfFailedAttempts - 1)
			{
				//verification token is still present the failure attempts was increased
				assertThat(userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN,
						verificationTokenData.getTokenId()).getFailedVerificationAttempts()).isEqualTo(i + 1);
			}
		}

		//verification token is removed after the last failed attempt
		assertThatThrownBy(() -> userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN, tokenId)).isInstanceOf(
				UnknownIdentifierException.class);

	}

	@Test
	public void shouldFailToAuthenticateExistingCustomerAndRemoveTokenIfVerificationTokenIsValidAndVerificationCodeDoesNotMatchForXTimesAndOTPIsEnabledForConcurrentRequests()
	{

		//given
		enableOTPLoginConfiguration(true);
		createCustomer(USER_ID);

		final var verificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, USER_ID);
		final var tokenId = verificationTokenData.getTokenId();


		final Authentication testAuthentication = createTestAuthentication(verificationTokenData.getTokenId(), "invalid");

		//when, then
		final var maxNumberOfFailedAttempts = Config.getInt("otp.customer.login.max.failed.attempts", 3);


		final TestThreadsHolder<Runnable> workerThreads = new TestThreadsHolder<>(maxNumberOfFailedAttempts, true)
		{
			@Override
			public Runnable newRunner(final int threadNumber)
			{

				return new FailedAuthenticationRunner(testAuthentication, tokenId);
			}
		};
		workerThreads.startAll();

		// then
		assertThat(workerThreads.waitAndDestroy(60)).isTrue();
		//after third failed attempt there is one error with the infromation that the token no longer can be found
		assertThat(workerThreads.getErrors().entrySet()).hasSize(1);
		//verification token is removed after the last failed attempt
		assertThat(workerThreads.getErrors().values().iterator().next().getMessage()).contains("Verification token not found");
	}


	class FailedAuthenticationRunner implements Runnable
	{
		final Authentication testAuthentication;
		final String tokenId;

		FailedAuthenticationRunner(final Authentication testAuthentication, final String tokenId)
		{
			this.testAuthentication = testAuthentication;
			this.tokenId = tokenId;
		}

		@Override
		public void run()
		{
			try
			{
				Transaction.current().execute(new TransactionBody()
				{
					@Override
					public <T> T execute()
					{
						assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
								AuthenticationException.class);


						userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN, tokenId)
								.getFailedVerificationAttempts();

						return null;
					}
				});
			}
			catch (final Exception e)
			{
				throw new RuntimeException(e);
			}
		}
	}

	@Test
	public void shouldFailToAuthenticateExistingCustomerIfProvidedVerificationTokenIsOutdatedAndOTPIsEnabled()
	{
		//given
		enableOTPLoginConfiguration(true);
		createCustomer(USER_ID);
		final int outdatedTtl = -1;

		final var verificationTokenData = userVerificationTokenService.createVerificationToken(SAPUserVerificationPurpose.LOGIN,
				USER_ID, outdatedTtl);
		final var tokenId = verificationTokenData.getTokenId();

		final Authentication testAuthentication = createTestAuthentication(verificationTokenData.getTokenId(), verificationTokenData.getTokenCode());

		//when, then
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);

		//outdated verification token is not retrievable as it got deleted
		assertThatThrownBy(() -> userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN, tokenId)).isInstanceOf(
				UnknownIdentifierException.class);
	}

	@Test
	public void shouldFailToAuthenticateExistingCustomerIfVerificationTokenIsMissingAndOTPIsEnabled()
	{

		//given
		enableOTPLoginConfiguration(true);
		createCustomer(USER_ID);


		final var verificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, USER_ID);
		final String noneExistingTokenId= "LNG-missing-verification-token-length-40";

		final Authentication testAuthentication = createTestAuthentication(noneExistingTokenId, verificationTokenData.getTokenCode());

		//when, then
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);

		//verification token is not consumed
		assertThat(userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN,
				verificationTokenData.getTokenId())).isNotNull();
	}

	@Test
	public void shouldFailToAuthenticateExistingCustomerIfValidVerificationTokenAndOTPIsDisabled()
	{

		//given
		enableOTPLoginConfiguration(false);
		createCustomer(USER_ID);


		final var verificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, USER_ID);

		final Authentication testAuthentication = createTestAuthentication(verificationTokenData.getTokenId(), verificationTokenData.getTokenCode());

		//when, then
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);

		//verification token is not consumed
		assertThat(userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN,
				verificationTokenData.getTokenId())).isNotNull();
	}

	@Test
	public void shouldFailToAuthenticateExistingCustomerIfValidUsernameAndPasswordProvidedAndOTPIsEnabled()
	{

		//given
		enableOTPLoginConfiguration(true);
		createCustomer(USER_ID);


		final var verificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN,
				USER_ID);

		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when, then
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);

		//verification token is not consumed
		assertThat(userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN,
				verificationTokenData.getTokenId())).isNotNull();
	}

	@Test
	public void shouldThrowExceptionWhenAuthenticatingNotExistingUser()
	{
		//given
		enableOTPLoginConfiguration(false);
		createUser(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(UUID.randomUUID().toString(), USER_PASSWORD);

		//when, then
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);
	}

	@Test
	public void shouldAuthenticateUserWithDecoratedUserId()
	{
		//given
		enableOTPLoginConfiguration(false);
		final UserIdDecorationStrategy fooDecorationStrategy = mock(UserIdDecorationStrategy.class);
		when(fooDecorationStrategy.decorateUserId(USER_ID)).thenReturn(Optional.of(USER_ID + FOO_DECORATOR));
		configureUserIdDecorationService(List.of(fooDecorationStrategy));
		createCustomerWithDecoratedUserId(USER_ID, FOO_DECORATOR);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	@Test
	public void shouldAuthenticateUserWithDecoratedUserIdByManyStrategies()
	{
		//given
		enableOTPLoginConfiguration(false);
		final UserIdDecorationStrategy fooDecorationStrategy = mock(UserIdDecorationStrategy.class);
		final UserIdDecorationStrategy barDecorationStrategy = mock(UserIdDecorationStrategy.class);
		when(fooDecorationStrategy.decorateUserId(anyString())).thenAnswer(i -> Optional.of(returnFirstArg(i) + FOO_DECORATOR));
		when(barDecorationStrategy.decorateUserId(anyString())).thenAnswer(i -> Optional.of(returnFirstArg(i) + BAR_DECORATOR));
		configureUserIdDecorationService(List.of(fooDecorationStrategy, barDecorationStrategy));
		createCustomerWithDecoratedUserId(USER_ID, FOO_DECORATOR, BAR_DECORATOR);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	@Test
	public void shouldLookUpUserByPKWhenAuthenticatingAndPKIsNotNull()
	{
		//given
		enableOTPLoginConfiguration(false);
		createUser(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);

		//when
		coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		verify(coreAuthenticationProvider, times(1)).getUserByPK(any());
		verify(coreAuthenticationProvider, times(0)).getUserByLogin(any());
		verify(rejectUserPreAuthenticationChecks, times(1)).getUserByPK(any());
		verify(rejectUserPreAuthenticationChecks, times(0)).getUserByLogin(any());
	}

	@Test
	public void shouldLookUpUserByLoginWhenAuthenticatingAndPKIsNull()
	{
		//given
		enableOTPLoginConfiguration(false);
		createUser(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		when(coreAuthenticationProvider.retrieveUser(USER_ID)).thenReturn(getCoreUserDetailsWithNullPK(USER_ID));

		//when
		coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		verify(coreAuthenticationProvider, times(1)).getUserByLogin(any());
		verify(coreAuthenticationProvider, times(0)).getUserByPK(any());
		verify(rejectUserPreAuthenticationChecks, times(1)).getUserByLogin(any());
		verify(rejectUserPreAuthenticationChecks, times(0)).getUserByPK(any());
	}

	@Test
	public void shouldLookUpUserByLoginWhenAuthenticatingAndUserDetailsIsNotInstanceOfCoreUserDetails()
	{
		//given
		enableOTPLoginConfiguration(false);
		createUser(USER_ID);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		when(coreAuthenticationProvider.retrieveUser(USER_ID)).thenReturn(getUserDetails(USER_ID));

		//when
		coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		verify(coreAuthenticationProvider, times(1)).getUserByLogin(any());
		verify(coreAuthenticationProvider, times(0)).getUserByPK(any());
	}

	@Test
	public void shouldThrowExceptionIfStrategyIsNotAwareOfAlreadyDecoratedUserID()
	{
		/* the exception will be thrown in case that configured UserIdDecorationStrategy is not resistance for situations where
		the such strategy can decorate the same user identifier many times */

		//given
		enableOTPLoginConfiguration(false);
		final UserIdDecorationStrategy fooDecorationStrategy = mock(UserIdDecorationStrategy.class);
		when(fooDecorationStrategy.decorateUserId(anyString())).thenAnswer(i -> Optional.of(returnFirstArg(i) + FOO_DECORATOR));
		configureUserIdDecorationService(List.of(fooDecorationStrategy));
		createUserWithDecoratedUserId(USER_ID, FOO_DECORATOR);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		when(coreAuthenticationProvider.getPKFromUserDetails(any())).thenReturn(null);

		//when, then
		assertThatThrownBy(() -> coreAuthenticationProvider.authenticate(testAuthentication)).isInstanceOf(
				BadCredentialsException.class);
	}

	@Test
	public void shouldAuthenticateUserIfStrategyIsAwareOfAlreadyDecoratedUserID()
	{
		//given
		enableOTPLoginConfiguration(false);
		final UserIdDecorationStrategy awareAlreadyDecoratedUserIdDecorationStrategy = mock(UserIdDecorationStrategy.class);
		when(awareAlreadyDecoratedUserIdDecorationStrategy.decorateUserId(USER_ID)).thenReturn(
				Optional.of(USER_ID + FOO_DECORATOR));
		when(awareAlreadyDecoratedUserIdDecorationStrategy.decorateUserId(USER_ID + FOO_DECORATOR)).thenReturn(Optional.empty());
		configureUserIdDecorationService(List.of(awareAlreadyDecoratedUserIdDecorationStrategy));
		createCustomerWithDecoratedUserId(USER_ID, FOO_DECORATOR);
		final Authentication testAuthentication = createTestAuthentication(USER_ID, USER_PASSWORD);
		when(coreAuthenticationProvider.getPKFromUserDetails(any())).thenReturn(null);

		//when
		final Authentication authentication = coreAuthenticationProvider.authenticate(testAuthentication);

		//then
		assertThat(authentication).isNotNull();
	}

	private void enableOTPLoginConfiguration(final boolean isEnabled)
	{
		coreAuthenticationProvider.setOneTimeLoginPasswordEnabled(isEnabled);
		coreUserDetailsService.setOneTimeLoginPasswordEnabled(isEnabled);
	}

	private CoreUserDetails getCoreUserDetailsWithNullPK(final String userId)
	{
		final CoreUserDetails coreUserDetails = coreUserDetailsService.loadUserByUsername(userId);

		return new CoreUserDetails(coreUserDetails.getUsername(), coreUserDetails.getPassword(), coreUserDetails.isEnabled(),
				coreUserDetails.isAccountNonExpired(), coreUserDetails.isCredentialsNonExpired(),
				coreUserDetails.isAccountNonLocked(), coreUserDetails.getAuthorities(), coreUserDetails.getLanguageISO(), null);
	}

	private org.springframework.security.core.userdetails.User getUserDetails(final String userId)
	{
		final CoreUserDetails coreUserDetails = coreUserDetailsService.loadUserByUsername(userId);

		return new org.springframework.security.core.userdetails.User(coreUserDetails.getUsername(),
				coreUserDetails.getPassword(), coreUserDetails.isEnabled(),
				coreUserDetails.isAccountNonExpired(), coreUserDetails.isCredentialsNonExpired(),
				coreUserDetails.isAccountNonLocked(), coreUserDetails.getAuthorities());
	}

	private UserModel createUser(final String userId)
	{
		return createUser(userId, false);
	}

	private UserModel createUser(final String userId, final boolean isInitialPassword)
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(userId);
		user.setPassword(USER_PASSWORD);
		user.setName(USER_NAME);
		user.setInitialPassword(isInitialPassword);

		modelService.save(user);

		return user;
	}


	private UserModel createUserWithLastLogin (final String userId, final int before, final Integer group1InactivePasswordExpirationDays, final Integer group2InactivePasswordExpirationDays)
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(userId);
		user.setPassword(USER_PASSWORD);
		user.setName(USER_NAME);
		user.setInitialPassword(false);
		user.setLastLogin(subtractDays(new Date(), before));
		final UserGroupModel group1 = createUserGroup(UUID.randomUUID().toString(), "group1", 36135, 36135, group1InactivePasswordExpirationDays);
		final UserGroupModel group2 = createUserGroup(UUID.randomUUID().toString(), "group2", 36135, 36135, group2InactivePasswordExpirationDays);
		user.setGroups(Sets.newHashSet(group1, group2));
		modelService.saveAll(user, group1, group2);
		return user;
	}


	private OAuthClientDetailsModel createOAuthClient(final String clientId, final String clientSecret)
	{
		final OAuthClientDetailsModel client = modelService.create(OAuthClientDetailsModel.class);
		client.setClientSecret(clientSecret);
		client.setClientId(clientId);
		modelService.save(client);

		return client;
	}

	private UserModel createUser(final String userId, final int expiryDaysGroup1, final int expiryDaysGroup2)
	{
		return createUser(userId, expiryDaysGroup1, expiryDaysGroup2, false);
	}

	private UserModel createUser(final String userId, final int expiryDaysGroup1, final int expiryDaysGroup2, final boolean isInitialPassword)
	{
		final UserModel user = createUser(userId, isInitialPassword);

		final UserGroupModel group1 = createUserGroup(UUID.randomUUID().toString(), "group1", expiryDaysGroup1, expiryDaysGroup1, expiryDaysGroup1);
		final UserGroupModel group2 = createUserGroup(UUID.randomUUID().toString(), "group2", expiryDaysGroup2, expiryDaysGroup2, expiryDaysGroup2);

		user.setGroups(Sets.newHashSet(group1, group2));

		modelService.saveAll(user, group1, group2);

		return user;
	}

	public UserGroupModel createUserGroup(final String userGroupUid, final String userGroupName)
	{
		return createUserGroup(userGroupUid, userGroupName, null, null, null);
	}

	public UserGroupModel createUserGroup(final String userGroupUid, final String userGroupName, final Integer expiryDays, final Integer initialPasswordExpiryDays, final Integer inactiveExpiryDays)
	{
		final UserGroupModel userGroup = modelService.create(UserGroupModel.class);
		userGroup.setUid(userGroupUid);
		userGroup.setName(userGroupName);
		userGroup.setPasswordExpiryPeriodDays(expiryDays);
		userGroup.setInitialPasswordExpiryPeriodDays(initialPasswordExpiryDays);
		userGroup.setInactivePasswordExpiryPeriodDays(inactiveExpiryDays);
		modelService.save(userGroup);
		return userGroup;
	}

	private void createUserAudit(final UserModel userModel, final int days)
	{
		UserPasswordChangeAuditModel auditModel = modelService.create(UserPasswordChangeAuditModel._TYPECODE);

		auditModel.setCreationtime(subtractDays(new Date(), days));
		auditModel.setEncodedPassword(USER_PASSWORD);
		auditModel.setUid(USER_ID);
		auditModel.setUserPK(userModel.getPk().getLong());
		auditModel.setPasswordEncoding("MD5");
		modelService.save(auditModel);
	}

	protected Date subtractDays(final Date date, final int days)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, -days);
		return calendar.getTime();
	}

	private void createUserWithDecoratedUserId(final String userId, final String... decorators)
	{
		createUser(decorateUserIdWithDecorators(userId, decorators));
	}

	private void createCustomer(final String userId)
	{
		final CustomerModel user = modelService.create(CustomerModel.class);
		user.setUid(userId);
		user.setPassword(USER_PASSWORD);

		modelService.save(user);
	}

	private void createEmployee(final String userId)
	{
		final EmployeeModel user = modelService.create(EmployeeModel.class);
		user.setUid(userId);
		user.setPassword(USER_PASSWORD);

		modelService.save(user);
	}

	private void createCustomerWithDecoratedUserId(final String userId, final String... decorators)
	{
		createCustomer(decorateUserIdWithDecorators(userId, decorators));
	}

	private String decorateUserIdWithDecorators(final String userId, final String... decorators)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(userId);

		for (final String decorator : decorators)
		{
			stringBuilder.append(decorator);
		}

		return stringBuilder.toString();
	}

	private Authentication createTestAuthentication(final String principal, final String credentials)
	{

		return new UsernamePasswordAuthenticationToken(principal, credentials);
	}

	private static String returnFirstArg(final InvocationOnMock invocation)
	{
		return (String) invocation.getArguments()[0];
	}

	private void configureUserIdDecorationService(final List<UserIdDecorationStrategy> userIdDecorationStrategies)
	{
		final UserIdDecorationService userIdDecorationService = new DefaultUserIdDecorationService(userIdDecorationStrategies);

		userManager.setUserIdDecorationService(userIdDecorationService);
	}

	private Date getExceptedPersistedLastLoginDate (final int daysAgo)
	{
		LocalDate ret = LocalDate.now().minusDays(daysAgo);

		// Convert LocalDate to Date for comparison
		return Date.from(ret.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
