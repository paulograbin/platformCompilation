/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.oauth2.audit.listeners;

import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.CLIENT_ID;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.createNotAllowedAuthentication;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.createOAuth2Client;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.createOAuthUsernamePasswordAuthenticationToken;
import static de.hybris.platform.oauth2.audit.listeners.OAuth2AuthenticationTestHelper.getBruteForceLoginAttempts;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.oauth2.model.SAPBruteForceOAuthLoginAttemptsModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.listener.util.OAuthUsernamePasswordAuthenticationToken;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

@IntegrationTest
public class OAuth2AuthenticationSuccessEventListenerTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;

	@Resource(name = "defaultAuthSuccessListener")
	private OAuth2AuthenticationSuccessEventListener listener;

	@Resource
	private FlexibleSearchService flexibleSearchService;

	@Test
	public void shouldResetFailedLoginAttemptsOnSuccessfulLogin()
	{
		//given
		createOAuth2Client(modelService);
		final OAuthUsernamePasswordAuthenticationToken oAuthUsernamePasswordAuthenticationToken = createOAuthUsernamePasswordAuthenticationToken(
				CLIENT_ID);
		createBruteForceLoginAttemptsModel(CLIENT_ID, 3);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(3);

		//when
		listener.onApplicationEvent(createAuthenticationSuccessEvent(oAuthUsernamePasswordAuthenticationToken));

		//then
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isZero();
	}

	@Test
	public void shouldNotResetFailedLoginAttemptsOnSuccessfulLoginWhenDifferentClientId()
	{
		//given
		createOAuth2Client(modelService);
		createBruteForceLoginAttemptsModel(CLIENT_ID, 3);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(3);

		//when
		listener.onApplicationEvent(
				createAuthenticationSuccessEvent(createOAuthUsernamePasswordAuthenticationToken("differentClientId")));

		//then
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(3);
	}

	@Test
	public void shouldNotResetFailedLoginAttemptsOnSuccessfulLoginWhenAuthenticationIsNotAllowedForEvent()
	{
		//given
		createOAuth2Client(modelService);
		createBruteForceLoginAttemptsModel(CLIENT_ID, 3);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(3);

		//when
		listener.onApplicationEvent(createAuthenticationSuccessEvent(createNotAllowedAuthentication(CLIENT_ID)));

		//then
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService).getAttempts()).isEqualTo(3);
	}

	@Test
	public void shouldNotResetFailedLoginAttemptsOnSuccessfulLoginWhenAttemptsNull()
	{
		//given
		createOAuth2Client(modelService);
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService)).isNull();

		//when
		listener.onApplicationEvent(createAuthenticationSuccessEvent(createNotAllowedAuthentication(CLIENT_ID)));

		//then
		assertThat(getBruteForceLoginAttempts(CLIENT_ID, flexibleSearchService)).isNull();
	}

	private AuthenticationSuccessEvent createAuthenticationSuccessEvent(final Authentication authentication)
	{
		return new AuthenticationSuccessEvent(authentication);
	}

	private void createBruteForceLoginAttemptsModel(final String clientId, final Integer failedAttempts)
	{
		final SAPBruteForceOAuthLoginAttemptsModel attempts = modelService.create(SAPBruteForceOAuthLoginAttemptsModel.class);
		attempts.setClientId(clientId);
		attempts.setAttempts(failedAttempts);
		modelService.save(attempts);
	}
}
