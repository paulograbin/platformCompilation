/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.validator.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.mockStatic;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.core.model.user.UserPasswordChangeAuditModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;

import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.Calendar;

/**
 * Test class for {@link DefaultUserAuthenticationValidator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultUserAuthenticationValidatorTest {

	@Mock
	private UserService userService;

	@Mock
	private ModelService modelService;

	@Mock
	private User user;

	@Mock
	private User iniUser;

	@Mock
	private UserGroupModel userGroup1;

	@Mock
	private UserGroupModel userGroup2;

	@Mock
	private UserModel userModel;

	@Mock
	private UserModel iniUserModel;

	@Mock
	private UserPasswordChangeAuditModel auditModel;

	@InjectMocks
	private DefaultUserAuthenticationValidator validator;

	MockedStatic<Config> configMockedStatic;

	@Before
	public void setUp()
	{
		user = spy(User.class);
		iniUser = spy(User.class);
		PK userPK = mock(PK.class);
		PK iniUserPK = mock(PK.class);
		when(user.getPK()).thenReturn(userPK);
		when(iniUser.getPK()).thenReturn(iniUserPK);
		when(modelService.get(user.getPK())).thenReturn(userModel);
		when(modelService.get(iniUser.getPK())).thenReturn(iniUserModel);
		when(userService.getUserAudits(userModel)).thenReturn(List.of(auditModel));
		when(userService.getUserAudits(iniUserModel)).thenReturn(List.of(auditModel));
		when(userModel.getAllGroups()).thenReturn(Set.of(userGroup1, userGroup2));
		when(iniUserModel.getAllGroups()).thenReturn(Set.of(userGroup1, userGroup2));
		when(userModel.isInitialPassword()).thenReturn(false);
		when(iniUserModel.isInitialPassword()).thenReturn(true);
		when(userModel.getName()).thenReturn("testUser");
		when(iniUserModel.getName()).thenReturn("iniTestUser");
		when(userGroup1.getPasswordExpiryPeriodDays()).thenReturn(null);
		when(userGroup2.getPasswordExpiryPeriodDays()).thenReturn(null);
		when(userGroup1.getInactivePasswordExpiryPeriodDays()).thenReturn(null);
		when(userGroup2.getInactivePasswordExpiryPeriodDays()).thenReturn(null);
		when(userGroup1.getInitialPasswordExpiryPeriodDays()).thenReturn(null);
		when(userGroup2.getInitialPasswordExpiryPeriodDays()).thenReturn(null);
		configMockedStatic = mockStatic(Config.class);
		configMockedStatic.when(() -> Config.getInt(DefaultUserAuthenticationValidator.EXPIRY_FALLBACK_DAYS_PROPS, 30))
		                  .thenReturn(30);
		configMockedStatic.when(() -> Config.getInt(DefaultUserAuthenticationValidator.INACTIVITY_EXPIRY_FALLBACK_DAYS_PROPS, 30))
		                  .thenReturn(30);
		configMockedStatic.when(
				                  () -> Config.getInt(DefaultUserAuthenticationValidator.INITIAL_PASSWORD_EXPIRY_FALLBACK_DAYS_PROPS, 30))
		                  .thenReturn(30);
	}

	@After
	public void tearDown()
	{
		configMockedStatic.close();
	}

	@Test
	public void validateCredentialsExpiredExceptionThrown()
	{

		// GIVEN: A user with a password change audit model that is older than 40 days with no password expiry period
		// set on the user groups, so it considers the default password expiry period as 30 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 40)); // 40 days ago

		// WHEN: the user is validated
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			validator.validate(user);
		}).withMessage("Password expired for the user: testUser");

		// THEN : the user is disabled, because the password change audit model is older than 30 days
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateInactiveUserCredentialsExpiredExceptionThrown()
	{
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20));
		// GIVEN: A user with last login that is older than 40 days with no inactive password expiry period
		// set on the user groups, so it considers the default password expiry period as 30 days.
		when(userModel.getLastLogin()).thenReturn(subtractDays(new Date(), 40)); // 40 days ago

		// WHEN: the user is validated
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			validator.validate(user);
		}).withMessage("Inactive password expired for the user: testUser");

		// THEN : the user is not disabled
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateIniUserIsDisabled()
	{

		// GIVEN: A user with an initial password change audit model that is older than 40 days with no initial password expiry period
		// set on the user groups, so it considers the default initial password expiry period as 30 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 40)); // 40 days ago // 40 days ago

		// WHEN: the user is validated
		assertThatExceptionOfType(DisabledException.class).isThrownBy(() -> {
			validator.validate(iniUser);
		}).withMessage("Initial password expired for the user: iniTestUser");

		// THEN : the user is disabled, because the initial password is older than 30 days
		verify(iniUserModel).setLoginDisabled(true);
	}

	@Test
	public void validateUserIsNotCredentialsExpiredExceptionThrown()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with no password expiry period
		// set on the user groups, so it considers the default password expiry period as 30 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago

		// WHEN: the user is validated
		validator.validate(user);

		// THEN : the user is mot disabled because the password change audit model is not older than 30 days
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateActiveUserIsNotCredentialsExpiredExceptionThrown()
	{
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20));
		// GIVEN: A user with a password change audit model that is older than 20 days with no password expiry period
		// set on the user groups, so it considers the default password expiry period as 30 days.
		when(userModel.getLastLogin()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago

		// WHEN: the user is validated
		validator.validate(user);

		// THEN : the user is mot disabled because the password change audit model is not older than 30 days
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateIniUserIsNotDisabled()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with no initial password expiry period
		// set on the user groups, so it considers the default initial password expiry period as 30 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago

		// WHEN: the user is validated
		validator.validate(iniUser);

		// THEN : the user is mot disabled because the password change audit model is not older than 30 days
		verify(iniUserModel, never()).setLoginDisabled(true);
	}

    @Test
    public void validateUserWithConfiguredExpireDateIsNotElapsed() {

        // GIVEN: A user with a password change audit model that is older than 20 days with password expiry period
        // set on one of the user group as 25 days.
        when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
        when(userGroup1.getPasswordExpiryPeriodDays()).thenReturn(25);

        // WHEN: the user is validated
        validator.validate(user);

        // THEN : the user is not disabled because the password change audit model is not older than configured 25 days
        verify(userModel, never()).setLoginDisabled(true);
    }

	@Test
	public void validateUserWithConfiguredInitialPasswordExpireDateIsNotElapsed()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with password expiry period
		// set on one of the user group as 25 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getInitialPasswordExpiryPeriodDays()).thenReturn(25);

		// WHEN: the user is validated
		validator.validate(iniUser);

		// THEN : the user is mot disabled because the password change audit model is not older than configured 25 days
		verify(iniUserModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateUserWithConfiguredInactivePasswordExpireDateIsNotElapsed()
	{
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20));
		// GIVEN: A user with latest login that is older than 20 days with password expiry period
		// set on one of the user group as 25 days.
		when(userModel.getLastLogin()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getInactivePasswordExpiryPeriodDays()).thenReturn(25);

		// WHEN: the user is validated
		validator.validate(user);

		// THEN : the user is mot disabled because the password change audit model is not older than configured 25 days
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateUserWithConfiguredExpireDateIsElapsed()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with password expiry period
		// set on one of the user group as 15 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getPasswordExpiryPeriodDays()).thenReturn(15);

		// WHEN: the user is validated
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			validator.validate(user);
		}).withMessage("Password expired for the user: testUser");

		// THEN : the user is not disabled
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateUserWithConfiguredInitialPasswordExpireDateIsElapsed()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with initial password expiry period
		// set on one of the user group as 15 days.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getInitialPasswordExpiryPeriodDays()).thenReturn(15);

		// WHEN: the user is validated
		assertThatExceptionOfType(DisabledException.class).isThrownBy(() -> {
			validator.validate(iniUser);
		}).withMessage("Initial password expired for the user: iniTestUser");

		// THEN : the user is disabled because the password change audit model is older than 15 days
		verify(iniUserModel).setLoginDisabled(true);
	}

	@Test
	public void validateUserWithConfiguredInactivePasswordExpireDateIsElapsed()
	{
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20));
		// GIVEN: A user with latest login that is older than 20 days with password expiry period
		// set on one of the user group as 15 days.
		when(userModel.getLastLogin()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getInactivePasswordExpiryPeriodDays()).thenReturn(15);

		// WHEN: the user is validated
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			validator.validate(user);
		}).withMessage("Inactive password expired for the user: testUser");

		// THEN : the user is not disabled
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateUserThatPicksLeastConfiguredDate()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with password expiry period
		// on one of the user group as 15 days and other user group with 30.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getPasswordExpiryPeriodDays()).thenReturn(15);
		when(userGroup2.getPasswordExpiryPeriodDays()).thenReturn(30);

		// WHEN: the user is validated
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			validator.validate(user);
		}).withMessage("Password expired for the user: testUser");


		// THEN : the user is not disabled; the password change audit model is older than 15 days (which is the least expiry days)
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateIniUserThatPicksLeastConfiguredDate()
	{

		// GIVEN: A user with a password change audit model that is older than 20 days with password expiry period
		// on one of the user group as 15 days and other user group with 30.
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getInitialPasswordExpiryPeriodDays()).thenReturn(15);
		when(userGroup2.getInitialPasswordExpiryPeriodDays()).thenReturn(30);

		// WHEN: the user is validated
		assertThatExceptionOfType(DisabledException.class).isThrownBy(() -> {
			validator.validate(iniUser);
		}).withMessage("Initial password expired for the user: iniTestUser");


		// THEN : the user is disabled because the password change audit model is older than 15 days (which is the least expiry days)
		verify(iniUserModel).setLoginDisabled(true);
	}

	@Test
	public void validateInactiveUserThatPicksLeastConfiguredDate()
	{
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20));
		// GIVEN: A user with latest login that is older than 20 days with password expiry period
		// on one of the user group as 15 days and other user group with 30.
		when(userModel.getLastLogin()).thenReturn(subtractDays(new Date(), 20)); // 20 days ago
		when(userGroup1.getInactivePasswordExpiryPeriodDays()).thenReturn(15);
		when(userGroup2.getInactivePasswordExpiryPeriodDays()).thenReturn(30);

		// WHEN: the user is validated
		assertThatExceptionOfType(CredentialsExpiredException.class).isThrownBy(() -> {
			validator.validate(user);
		}).withMessage("Inactive password expired for the user: testUser");


		// THEN : the user is not disabled
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateUserWithConfiguredExpireDateAsZero()
	{

		// GIVEN: A user with a password change audit model on one of the user group as 0 days
		when(userGroup1.getPasswordExpiryPeriodDays()).thenReturn(0);

		// WHEN: the user is validated
		validator.validate(user);

		// THEN : the user is mot disabled because the user group have a value configured as 0 days
		// that means the password never expires
		verify(userModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateIniUserWithConfiguredExpireDateAsZero()
	{

		// GIVEN: A user with a password change audit model on one of the user group as 0 days
		when(userGroup1.getInitialPasswordExpiryPeriodDays()).thenReturn(0);

		// WHEN: the user is validated
		validator.validate(iniUser);

		// THEN : the user is mot disabled because the user group have a value configured as 0 days
		// that means the password never expires
		verify(iniUserModel, never()).setLoginDisabled(true);
	}

	@Test
	public void validateInactiveUserWithConfiguredExpireDateAsZero()
	{
		when(auditModel.getCreationtime()).thenReturn(subtractDays(new Date(), 20));
		// GIVEN: A user with inactive password on one of the user group as 0 days
		when(userGroup1.getInactivePasswordExpiryPeriodDays()).thenReturn(0);

		// WHEN: the user is validated
		validator.validate(user);

		// THEN : the user is mot disabled because the user group have a value configured as 0 days
		// that means the password never expires
		verify(userModel, never()).setLoginDisabled(true);
	}

    protected Date subtractDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTime();
    }
}
