/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.paulograbin.storefront.security;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.Constants;
import de.hybris.platform.core.enums.SAPUserVerificationPurpose;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.core.servicelayer.user.UserVerificationTokenAndUserData;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.UserVerificationTokenService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.util.Config;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class AcceleratorAuthenticationProviderTest
{
	private AcceleratorAuthenticationProvider acceleratorAuthenticationProvider;

	private Authentication authentication;

	@Mock
	private BruteForceAttackCounter bruteForceAttackCounter;

	@Mock
	private UserModel userModel;

	@Mock
	UserService userService;

	@Mock
	private BaseSiteService baseSiteService;

	@Mock
	private UserDetails userDetails;

	@Mock
	private AbstractAuthenticationToken abstractAuthenticationToken;

	@Mock
	protected UserVerificationTokenService userVerificationTokenService;

	@Before
	public void setUp()
	{
		acceleratorAuthenticationProvider = new AcceleratorAuthenticationProvider();
		acceleratorAuthenticationProvider.setBruteForceAttackCounter(bruteForceAttackCounter);
		acceleratorAuthenticationProvider.setUserService(userService);
		acceleratorAuthenticationProvider.setBaseSiteService(baseSiteService);
		acceleratorAuthenticationProvider.setUserVerificationTokenService(userVerificationTokenService);
		authentication = new UsernamePasswordAuthenticationToken("username", "password");
	}

	@Test(expected = BadCredentialsException.class)
	public void testLoginForUserNotPartOfCustomerGroup()
	{
		try (MockedStatic<Config> config = Mockito.mockStatic(Config.class))
		{
			config.when(() -> Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(false);
			final Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 2);
			userModel.setDeactivationDate(calendar.getTime());
			final UserGroupModel userGroupModel = mock(UserGroupModel.class);
			given(userService.getUserForUID(Mockito.anyString())).willReturn(userModel);
			given(userService.getUserGroupForUID(Constants.USER.CUSTOMER_USERGROUP)).willReturn(userGroupModel);
			given(Boolean.valueOf(userService.isMemberOfGroup(userModel, userGroupModel))).willReturn(Boolean.FALSE);

			acceleratorAuthenticationProvider.authenticate(authentication);
		}
	}

	@Test(expected = BadCredentialsException.class)
	public void testDisabledUserShouldNotBeConsideredABruteForceAttack()
	{
		try (MockedStatic<Config> config = Mockito.mockStatic(Config.class))
		{
			config.when(() -> Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(false);
			final String uid = "testuser@hybris.com";
			userModel.setUid(uid);
			userModel.setLoginDisabled(true);
			when(userService.getUserForUID(anyString())).thenReturn(userModel);

			acceleratorAuthenticationProvider.authenticate(authentication);
			verify(bruteForceAttackCounter).resetUserCounter(uid);
		}
	}

	@Test(expected = BadCredentialsException.class)
	public void testLoginForUserUsingUnknownToken()
	{
		try (MockedStatic<Config> config = Mockito.mockStatic(Config.class))
		{
			config.when(() -> Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(true);
			final UserVerificationTokenAndUserData userVerificationTokenAndUserData = mock(UserVerificationTokenAndUserData.class);
			given(userVerificationTokenService.lookupTokenWithUser(SAPUserVerificationPurpose.LOGIN, "username")).willReturn(userVerificationTokenAndUserData);
			given(userVerificationTokenAndUserData.getUser()).willThrow(UnknownIdentifierException.class);

			acceleratorAuthenticationProvider.authenticate(authentication);
		}
	}

	@Test
	public void testAdditionalAuthenticationChecks()
	{
		BaseSiteModel curBaseSite1 = Mockito.mock(BaseSiteModel.class);
		testAdditionalAuthenticationChecksWithParameter(false, null, curBaseSite1, false);

		BaseSiteModel curBaseSite2 = Mockito.mock(BaseSiteModel.class);
		testAdditionalAuthenticationChecksWithParameter(true, null, curBaseSite2, true);

		BaseSiteModel userBaseSite3 = Mockito.mock(BaseSiteModel.class);
		BaseSiteModel curBaseSite3 = Mockito.mock(BaseSiteModel.class);
		testAdditionalAuthenticationChecksWithParameter(true, userBaseSite3, curBaseSite3, false);

		// impossible case
		BaseSiteModel userBaseSite4 = Mockito.mock(BaseSiteModel.class);
		testAdditionalAuthenticationChecksWithParameter(true, userBaseSite4, userBaseSite4, false);

		BaseSiteModel userBaseSite5 = Mockito.mock(BaseSiteModel.class);
		BaseSiteModel curBaseSite5 = Mockito.mock(BaseSiteModel.class);
		testAdditionalAuthenticationChecksWithParameter(true, userBaseSite5, curBaseSite5, true);


		BaseSiteModel userBaseSite6 = Mockito.mock(BaseSiteModel.class);
		testAdditionalAuthenticationChecksWithParameter(false, userBaseSite6, userBaseSite6, true);
	}

	private void testAdditionalAuthenticationChecksWithParameter(final boolean expectedException, final BaseSiteModel userBaseSite,
			final BaseSiteModel currentBaseSite, final boolean isolationEnabled)
	{
		when(abstractAuthenticationToken.getCredentials()).thenReturn("defaultPassword");
		when(userDetails.getUsername()).thenReturn(StringUtils.lowerCase("defaultUserName"));

		CustomerModel currentCustomer = Mockito.mock(CustomerModel.class);
		when(userService.getUserForUID(StringUtils.lowerCase("defaultUserName"))).thenReturn(currentCustomer);

		when(currentCustomer.getSite()).thenReturn(userBaseSite);

		when(baseSiteService.getCurrentBaseSite()).thenReturn(currentBaseSite);
		when(currentBaseSite.getDataIsolationEnabled()).thenReturn(isolationEnabled);

		boolean exceptionCaught = false;
		try
		{
			acceleratorAuthenticationProvider.additionalAuthenticationChecks(userDetails, abstractAuthenticationToken);
		}
		catch (BadCredentialsException e)
		{
			exceptionCaught = true;
		}

		Assert.assertEquals(expectedException, exceptionCaught);
	}
}
