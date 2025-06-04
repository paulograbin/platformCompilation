/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.core.security;

import static de.hybris.platform.core.security.AdminAccessRecoveryServiceConstants.INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.PasswordEncoderService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

@IntegrationTest
public class DefaultAdminAccessRecoveryServiceIntegrationTest extends ServicelayerBaseTest
{

	private static final String DEFAULT_PASSWORD_ENCODING_CONFIG_PROPERTY_KEY = "default.password.encoding";

	//@Resource
	private DefaultAdminAccessRecoveryService adminAccessRecoveryService;

	@Resource
	private UserService userService;

	@Resource
	private PasswordEncoderService passwordEncoderService;

	@Resource
	private ConfigurationService configurationService;

	@Resource
	private ModelService modelService;

	private final PropertyConfigSwitcher initialPasswordAdminPropertyConfigSwitcher = new PropertyConfigSwitcher(
			INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY);

	@Before
	public void beforeEach()
	{
		adminAccessRecoveryService = new DefaultAdminAccessRecoveryService(configurationService, userService, modelService);
	}

	@Test
	public void shouldNotBeAvailableInSpringContext()
	{

		final ThrowableAssert.ThrowingCallable throwingCallable = () -> Registry.getApplicationContext()
		                                                                        .getBean(DefaultAdminAccessRecoveryService.class);
		assertThatThrownBy(throwingCallable)
				.isInstanceOf(NoSuchBeanDefinitionException.class);
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenInitialPasswordAdminConfigurationPropertyIsNotConfigured()
	{
		// given
		initialPasswordAdminPropertyConfigSwitcher.switchToValue("");

		// when
		final ThrowableAssert.ThrowingCallable throwingCallable = () -> adminAccessRecoveryService.resetAdminPassword();

		// then
		assertThatThrownBy(throwingCallable)
				.isInstanceOf(IllegalStateException.class)
				.hasMessage(INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY + " configuration property is missing");

		initialPasswordAdminPropertyConfigSwitcher.switchBackToDefault();
	}

	@Test
	public void shouldChangeAdminPasswordToInitialPasswordAdminConfigurationPropertyValue()
	{
		// given
		final String defaultPasswordEncoding = configurationService.getConfiguration()
		                                                           .getString(DEFAULT_PASSWORD_ENCODING_CONFIG_PROPERTY_KEY);
		final EmployeeModel adminUser = userService.getAdminUser();
		final String lostPassword = RandomStringUtils.insecure().nextAlphanumeric(10);
		userService.setPasswordWithDefaultEncoding(adminUser, lostPassword);
		modelService.save(adminUser);

		final String initialAdminPassword = configurationService.getConfiguration()
		                                                        .getString(INITIALPASSWORD_ADMIN_CONFIGURATION_PROPERTY);

		// when
		adminAccessRecoveryService.resetAdminPassword();

		// then
		assertThat(passwordEncoderService.isValid(adminUser, lostPassword)).isFalse();
		assertThat(passwordEncoderService.isValid(adminUser, initialAdminPassword)).isTrue();
		assertThat(adminUser.getPasswordEncoding())
				.isEqualTo(defaultPasswordEncoding);
	}
}
