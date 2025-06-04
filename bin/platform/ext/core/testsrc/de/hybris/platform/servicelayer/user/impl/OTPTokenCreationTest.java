/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.user.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.enums.SAPUserVerificationPurpose;
import de.hybris.platform.core.servicelayer.user.UserVerificationTokenData;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.user.exceptions.TooManyActiveVerificationTokensException;
import de.hybris.platform.util.Config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class OTPTokenCreationTest extends ServicelayerBaseTest
{

	private static final String TEST_USER_UID = "testUser@sap.com";
	private static final int DEFAULT_MAX_NUMBER_OF_TOKENS = 5;
	private static final String LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY = "otp.customer.login.token.maxcount.enabled";
	private String loginTokenMaxCountEnabledPropertyValue;

	@Resource
	private DefaultSapUserVerificationTokenService userVerificationTokenService;

	@Before
	public void setUp()
	{
		loginTokenMaxCountEnabledPropertyValue = Config.getString(LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY, null);
	}

	@After
	public void tearDown()
	{
		userVerificationTokenService.removeUserTokens(TEST_USER_UID);
		Config.setParameter(LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY, loginTokenMaxCountEnabledPropertyValue);
		userVerificationTokenService.clearCachedConfigValues();
	}

	@Test
	public void shouldCreateTokenIfMaxNumberOfTokensNotExceededAndTokensMaxCountCheckEnabled()
			throws TooManyActiveVerificationTokensException
	{
		//given
		final Set<UserVerificationTokenData> tokens = new HashSet<>();
		Config.setParameter(LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY, "true");

		//when
		for (int i = 0; i < DEFAULT_MAX_NUMBER_OF_TOKENS; i++)
		{
			tokens.add(userVerificationTokenService.createToken(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID));
		}

		//then
		assertEquals(DEFAULT_MAX_NUMBER_OF_TOKENS, tokens.size());
	}

	@Test
	public void shouldNotCreateTokenIfMaxNumberOfTokensExceededAndTokensMaxCountCheckEnabled()
			throws TooManyActiveVerificationTokensException
	{
		//given
		Config.setParameter(LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY, "true");

		//when
		for (int i = 0; i < DEFAULT_MAX_NUMBER_OF_TOKENS; i++)
		{
			userVerificationTokenService.createToken(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID);
		}

		//then
		assertThrows(TooManyActiveVerificationTokensException.class,
				() -> userVerificationTokenService.createToken(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID));
	}

	@Test
	public void shouldCreateTokenIfMaxNumberOfTokensExceededAndTokensMaxCountCheckNotEnabled()
			throws TooManyActiveVerificationTokensException
	{
		//given
		final Set<UserVerificationTokenData> tokens = new HashSet<>();
		Config.setParameter(LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY, "false");

		//when
		for (int i = 0; i < DEFAULT_MAX_NUMBER_OF_TOKENS; i++)
		{
			tokens.add(userVerificationTokenService.createToken(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID));
		}
		tokens.add(userVerificationTokenService.createToken(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID));

		//then
		assertTrue(tokens.size() > DEFAULT_MAX_NUMBER_OF_TOKENS);
	}

	@Test
	public void shouldCreateTokenIfMaxNumberOfTokensExceededAndTokensMaxCountCheckEnabledAndDeprecatedCreateTokenMethodCalled()
	{
		//given
		final Set<UserVerificationTokenData> tokens = new HashSet<>();
		Config.setParameter(LOGIN_TOKEN_MAX_COUNT_ENABLED_PROPERTY, "true");

		//when
		for (int i = 0; i < DEFAULT_MAX_NUMBER_OF_TOKENS; i++)
		{
			tokens.add(userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID));
		}
		tokens.add(userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID));

		//then
		assertTrue(tokens.size() > DEFAULT_MAX_NUMBER_OF_TOKENS);
	}

}
