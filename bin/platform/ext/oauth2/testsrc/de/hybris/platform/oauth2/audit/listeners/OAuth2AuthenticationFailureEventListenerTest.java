/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.oauth2.audit.listeners;

import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.CLIENT_ID;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.createNotAllowedAuthentication;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.createOAuth2Client;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.createOAuthUsernamePasswordAuthenticationToken;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.getBruteForceLoginAttempts;
import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.oauth2.model.SAPBruteForceOAuthLoginAttemptsModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@IntegrationTest
public class OAuth2AuthenticationFailureEventListenerTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;

	@Resource(name = "defaultAuthFailureListener")
	private OAuth2AuthenticationFailureEventListener listener;

	@Resource
	private FlexibleSearchService flexibleSearchService;


	private final PropertyConfigSwitcher oauth2MaxAuthenticationAttempts = new PropertyConfigSwitcher(
			"oauth2.maxAuthenticationAttempts");

	@After
	public void tearDown()
	{
		oauth2MaxAuthenticationAttempts.switchBackToDefault();
	}

	@Test
	public void shouldAuditFailedLoginAttempts()
	{
		//given
		oauth2MaxAuthenticationAttempts.switchToValue("5");
		createOAuth2Client(modelService);
		final AuthenticationFailureBadCredentialsEvent failureEvent = createAuthenticationBadCredentialsEvent(
				createOAuthUsernamePasswordAuthenticationToken(CLIENT_ID), createBadCredentialsException());

		//when, then
		listener.onApplicationEvent(failureEvent);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(1);
		listener.onApplicationEvent(failureEvent);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(2);
		listener.onApplicationEvent(failureEvent);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(3);
	}

	@Test
	public void shouldNotAuditFailedLoginAttemptsIfAuthenticationIsNotAllowedForEvent()
	{
		//given
		oauth2MaxAuthenticationAttempts.switchToValue("5");
		createOAuth2Client(modelService);
		final AuthenticationFailureBadCredentialsEvent failureEvent = createAuthenticationBadCredentialsEvent(
				createNotAllowedAuthentication(CLIENT_ID), createBadCredentialsException());

		//when
		listener.onApplicationEvent(failureEvent);
		listener.onApplicationEvent(failureEvent);

		//then
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService)).isNull();
	}

	@Test
	public void shouldDisableOAuth2ClientIfMaxFailedLoginAttemptsReached()
	{
		//given
		oauth2MaxAuthenticationAttempts.switchToValue("3");
		final OAuthClientDetailsModel oAuth2Client = createOAuth2Client(modelService);
		assertThat(oAuth2Client.getDisabled()).isFalse();
		final AuthenticationFailureBadCredentialsEvent failureEvent = createAuthenticationBadCredentialsEvent(
				createOAuthUsernamePasswordAuthenticationToken(CLIENT_ID), createBadCredentialsException());

		//when
		listener.onApplicationEvent(failureEvent);
		listener.onApplicationEvent(failureEvent);
		listener.onApplicationEvent(failureEvent);

		//then
		modelService.refresh(oAuth2Client);
		assertThat(oAuth2Client.getDisabled()).isTrue();
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isZero();
	}

	@Test
	public void shouldNotAuditFailedLoginAttemptsForUnknownClient()
	{
		//given
		final String unknownClientId = "unknownClient";
		oauth2MaxAuthenticationAttempts.switchToValue("3");

		//when
		listener.onApplicationEvent(
				createAuthenticationBadCredentialsEvent(createOAuthUsernamePasswordAuthenticationToken(unknownClientId),
						createBadCredentialsException()));

		//then
		final SAPBruteForceOAuthLoginAttemptsModel attempts = getBruteForceLoginAttempts(unknownClientId, flexibleSearchService);
		assertThat(attempts).isNull();
	}

	@Test
	public void shouldNotAuditFailedLoginAttemptsForPublicClient()
	{
		//given
		final String publicClientId = "publicClient";
		oauth2MaxAuthenticationAttempts.switchToValue("3");

		final OAuthClientDetailsModel oAuth2Client = createOAuth2Client(modelService, publicClientId, null);
		assertThat(oAuth2Client.getDisabled()).isFalse();
		final SAPBruteForceOAuthLoginAttemptsModel attemptsBefore = getBruteForceLoginAttempts(publicClientId,
				flexibleSearchService);
		assertThat(attemptsBefore).isNull();

		final AuthenticationFailureBadCredentialsEvent failureEvent = createAuthenticationBadCredentialsEvent(
				createOAuthUsernamePasswordAuthenticationToken(publicClientId), createBadCredentialsException());

		//when
		listener.onApplicationEvent(failureEvent);
		listener.onApplicationEvent(failureEvent);
		listener.onApplicationEvent(failureEvent);

		//then
		assertThat(oAuth2Client.getDisabled()).isFalse();
		final SAPBruteForceOAuthLoginAttemptsModel attemptsAfter = getBruteForceLoginAttempts(publicClientId,
				flexibleSearchService);
		assertThat(attemptsAfter).isNull();
	}

	private AuthenticationFailureBadCredentialsEvent createAuthenticationBadCredentialsEvent(
			final Authentication authentication, final AuthenticationException authenticationException)
	{
		return new AuthenticationFailureBadCredentialsEvent(authentication, authenticationException);
	}

	private BadCredentialsException createBadCredentialsException()
	{
		return new BadCredentialsException("Bad credentials");
	}
}
