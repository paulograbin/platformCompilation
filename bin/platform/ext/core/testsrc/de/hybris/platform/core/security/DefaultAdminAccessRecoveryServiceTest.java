/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.core.security;

import static de.hybris.platform.core.security.AdminAccessRecoveryServiceConstants.INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.audit.AuditableActions;
import de.hybris.platform.audit.UserRelatedAuditableActions;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultAdminAccessRecoveryServiceTest
{

	@InjectMocks
	private DefaultAdminAccessRecoveryService testee;

	@Mock
	private ConfigurationService configurationService;

	@Mock
	private UserService userService;

	@Mock
	private ModelService modelService;

	@Mock
	private Configuration configuration;

	@Before
	public void beforeEach()
	{
		when(configurationService.getConfiguration())
				.thenReturn(configuration);
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenConfigurationGetStringReturnsNull()
	{
		// when
		final ThrowableAssert.ThrowingCallable throwingCallable = () -> testee.resetAdminPassword();

		//then
		assertThatThrownBy(throwingCallable)
				.isInstanceOf(IllegalStateException.class)
				.hasMessage(INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY + " configuration property is missing");
		verify(configurationService).getConfiguration();
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenConfigurationGetStringReturnsEmptyString()
	{
		// given
		when(configuration.getString(anyString()))
				.thenReturn("");

		// when
		final ThrowableAssert.ThrowingCallable throwingCallable = () -> testee.resetAdminPassword();

		//then
		assertThatThrownBy(throwingCallable)
				.isInstanceOf(IllegalStateException.class)
				.hasMessage(INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY + " configuration property is missing");
		verify(configurationService).getConfiguration();
	}

	@Test
	public void shouldSaveInitialPasswordForAdminAndTriggerAuditEvent()
	{
		try (final MockedStatic<AuditableActions> auditableActionsMockedStatic = Mockito.mockStatic(AuditableActions.class))
		{
			// given
			final String initialPass = RandomStringUtils.insecure().nextAlphabetic(10);
			when(configuration.getString(anyString()))
					.thenReturn(initialPass);
			final EmployeeModel adminUser = mock(EmployeeModel.class);
			when(userService.getAdminUser())
					.thenReturn(adminUser);
			final AuditableActions.NamedActionBuilder adminPasswordResetAuditableAction = UserRelatedAuditableActions.adminPasswordReset();

			// when
			testee.resetAdminPassword();

			// then
			verify(configurationService).getConfiguration();
			verify(configuration).getString(INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY);
			verify(userService).getAdminUser();
			verify(userService).setPasswordWithDefaultEncoding(adminUser, initialPass);
			verify(modelService).save(adminUser);
			auditableActionsMockedStatic.verify(() -> AuditableActions.audit(adminPasswordResetAuditableAction));
		}
	}

}
