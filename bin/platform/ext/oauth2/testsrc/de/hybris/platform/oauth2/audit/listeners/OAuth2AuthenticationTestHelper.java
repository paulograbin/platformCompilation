/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.oauth2.audit.listeners;

import de.hybris.platform.oauth2.model.SAPBruteForceOAuthLoginAttemptsModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.user.listener.util.OAuthUsernamePasswordAuthenticationToken;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;

import java.util.Map;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/*
 * Helper class for OAuth2AuthenticationFailureEventListenerTest and OAuth2AuthenticationSuccessEventListenerTest
 */
public final class OAuth2AuthenticationTestHelper
{
	static final String CLIENT_ID = "testClient";
	static final String TEST_SECRET = "testSecret";

	static OAuthClientDetailsModel createOAuth2Client(final ModelService modelService)
	{
		return createOAuth2Client(modelService, CLIENT_ID, TEST_SECRET);
	}

	static OAuthClientDetailsModel createOAuth2Client(final ModelService modelService, final String clientId,
													  final String clientSecret)
	{
		final OAuthClientDetailsModel client = modelService.create(OAuthClientDetailsModel.class);
		client.setClientSecret(clientSecret);
		client.setRegisteredRedirectUri(Set.of("http://localhost:9002/authserver/oauth2_implicit_callback"));
		client.setClientId(clientId);
		modelService.save(client);

		return client;
	}

	static OAuthUsernamePasswordAuthenticationToken createOAuthUsernamePasswordAuthenticationToken(final String clientId)
	{
		return new OAuthUsernamePasswordAuthenticationToken(clientId, TEST_SECRET);
	}

	static SAPBruteForceOAuthLoginAttemptsModel getBruteForceLoginAttempts(final String clientId,
	                                                                       final FlexibleSearchService flexibleSearchService)
	{
		final FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(
				String.format("SELECT {%s} FROM {%s} WHERE {%s} = ?clientId", SAPBruteForceOAuthLoginAttemptsModel.PK,
						SAPBruteForceOAuthLoginAttemptsModel._TYPECODE, SAPBruteForceOAuthLoginAttemptsModel.CLIENTID),
				Map.of("clientId", clientId));
		final SearchResult<SAPBruteForceOAuthLoginAttemptsModel> search = flexibleSearchService.search(fsQuery);
		return search.getResult().stream().findFirst().orElse(null);
	}

	static Authentication createNotAllowedAuthentication(final String clientId)
	{
		return new UsernamePasswordAuthenticationToken(clientId, TEST_SECRET);
	}
}
