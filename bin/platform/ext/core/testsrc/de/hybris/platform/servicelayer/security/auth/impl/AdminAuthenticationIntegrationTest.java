/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.security.auth.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.security.auth.InvalidCredentialsException;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.impl.DefaulPasswordEncoderService;
import de.hybris.platform.testframework.BulkPropertyConfigSwitcher;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;

@IntegrationTest
public class AdminAuthenticationIntegrationTest extends ServicelayerTransactionalBaseTest
{
	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	@Resource
	private PlatformTransactionManager txManager;

	@Resource
	private SessionService sessionService;

	private DefaultAuthenticationService authenticationService;

	private final BulkPropertyConfigSwitcher propertyConfigSwitcher = new BulkPropertyConfigSwitcher();

	@Before
	public void setUp()
	{
		final DefaulPasswordEncoderService passwordEncoderServiceNoPasswordCheck = mock(DefaulPasswordEncoderService.class);
		when(passwordEncoderServiceNoPasswordCheck.isValid(any(), any())).thenReturn(true);

		this.authenticationService = new DefaultAuthenticationService();
		authenticationService.setUserService(userService);
		authenticationService.setModelService(modelService);
		authenticationService.setSessionService(sessionService);
		authenticationService.setTxManager(txManager);
		authenticationService.setPasswordEncoderService(passwordEncoderServiceNoPasswordCheck);
		authenticationService.setCurrentTenant(Registry.getCurrentTenantNoFallback());
	}

	@After
	public void tearDown()
	{
		propertyConfigSwitcher.switchAllBack();
	}

	@Test
	public void loginAsAdminWithAdminLoginEnabledShouldSucceed() throws InvalidCredentialsException
	{
		//given
		propertyConfigSwitcher.switchToValue(User.ADMIN_LOGIN_ENABLED, "true");
		final UserModel admin = userService.getAdminUser();

		//when
		final UserModel retrievedAdminModel = authenticationService.login(admin.getUid(), "");

		//then
		assertThat(retrievedAdminModel).isEqualTo(admin);
	}

	@Test
	public void loginAsAdminWithAdminLoginDisabledShouldFail()
	{
		//given
		propertyConfigSwitcher.switchToValue(User.ADMIN_LOGIN_ENABLED, "false");
		final UserModel admin = userService.getAdminUser();

		//then
		assertThrows(InvalidCredentialsException.class, () -> authenticationService.login(admin.getUid(), ""));
	}
}

