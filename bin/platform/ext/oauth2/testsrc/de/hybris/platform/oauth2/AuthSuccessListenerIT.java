/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.oauth2;

import static de.hybris.platform.oauth2.AuthFailureListstenerIT.findClientAttempts;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.oauth2.model.SAPBruteForceOAuthLoginAttemptsModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.listener.util.OAuthUsernamePasswordAuthenticationToken;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

@IntegrationTest
public class AuthSuccessListenerIT extends ServicelayerTransactionalBaseTest
{
	public final static String testId = "testclient";
	@Resource(name = "authSuccessListener")
	private ApplicationListener listener;
	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService search;
	@Resource(name = "modelService")
	private ModelService model;

	@Test(expected = ModelNotFoundException.class)
	public void ignoreSuccess() throws Exception
	{
		listener.onApplicationEvent(new AuthenticationSuccessEvent(new OAuthUsernamePasswordAuthenticationToken(testId, "pwd")));
		findClientAttempts(search, testId);
	}

	@Test
	public void resetAttempts() throws Exception
	{
		final SAPBruteForceOAuthLoginAttemptsModel attempts = model.create(SAPBruteForceOAuthLoginAttemptsModel.class);
		attempts.setClientId(testId);
		attempts.setAttempts(Integer.valueOf(1));
		model.save(attempts);
		listener.onApplicationEvent(new AuthenticationSuccessEvent(new OAuthUsernamePasswordAuthenticationToken(testId, "pwd")));
		assertThat(findClientAttempts(search, testId).getAttempts()).isZero();
	}
}
