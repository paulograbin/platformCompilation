/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.oauth2.audit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.user.listener.util.OAuthUsernamePasswordAuthenticationToken;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Unit test for {@link OAuthClientAuthenticationManager}
 */
@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class OAuthClientAuthenticationManagerTest
{
	private static final String BAD_CREDENTIALS_MESSAGE = "Bad credentials";
	@Mock
	private AuthenticationProvider authenticationProvider;
	@Mock
	private AuthenticationEventPublisher eventPublisher;
	@Mock
	private UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
	@Mock
	private Authentication otherAuthenticationToken;
	private ProviderManager parentProviderManagerSpy;
	private OAuthClientAuthenticationManager oauthClientAuthenticationManagerSpy;
	private ProviderManager mainProviderManager;


	@Before
	public void setUp() throws Exception
	{
		final ProviderManager parentProviderManager = new ProviderManager(List.of(authenticationProvider));
		parentProviderManager.setAuthenticationEventPublisher(eventPublisher);
		parentProviderManager.afterPropertiesSet();
		parentProviderManagerSpy = spy(parentProviderManager);

		final OAuthClientAuthenticationManager oAuthClientAuthenticationManager = new OAuthClientAuthenticationManager(
				parentProviderManagerSpy);
		oauthClientAuthenticationManagerSpy = spy(oAuthClientAuthenticationManager);

		mainProviderManager = new ProviderManager(List.of(), oauthClientAuthenticationManagerSpy);
		mainProviderManager.afterPropertiesSet();

		when(authenticationProvider.supports(any())).thenReturn(true);
	}

	@Test
	public void shouldConvertAuthenticationObjectAndAuthenticateSuccessfully()
	{
		when(authenticationProvider.authenticate(any(OAuthUsernamePasswordAuthenticationToken.class))).thenAnswer(
				returnsFirstArg());

		final Authentication authenticationResult = mainProviderManager.authenticate(usernamePasswordAuthenticationToken);

		final Authentication authenticationTokenCaptured = verifyAuthenticationProcess(usernamePasswordAuthenticationToken);
		verify(eventPublisher).publishAuthenticationSuccess(authenticationTokenCaptured);
		assertThat(authenticationResult).isSameAs(authenticationTokenCaptured);
	}

	@Test
	public void shouldConvertAuthenticationObjectAndThrowAuthenticationException()
	{
		final AuthenticationException authenticationException = new BadCredentialsException(BAD_CREDENTIALS_MESSAGE);
		when(authenticationProvider.authenticate(any(OAuthUsernamePasswordAuthenticationToken.class)))
				.thenThrow(authenticationException);

		final Throwable throwable = catchThrowable(() -> mainProviderManager.authenticate(usernamePasswordAuthenticationToken));

		assertThat(throwable)
				.as("authentication should fail with BadCredentialsException")
				.isInstanceOf(BadCredentialsException.class)
				.hasMessage(BAD_CREDENTIALS_MESSAGE);
		final Authentication authenticationTokenCaptured = verifyAuthenticationProcess(usernamePasswordAuthenticationToken);
		verify(eventPublisher).publishAuthenticationFailure(authenticationException, authenticationTokenCaptured);
	}

	@Test
	public void shouldNotConvertAuthenticationObjectAndAuthenticateSuccessfully()
	{
		when(authenticationProvider.authenticate(any(Authentication.class))).thenAnswer(returnsFirstArg());

		final Authentication authenticationResult = mainProviderManager.authenticate(otherAuthenticationToken);

		final Authentication authenticationTokenCaptured = verifyAuthenticationProcess(otherAuthenticationToken);
		verify(eventPublisher).publishAuthenticationSuccess(authenticationTokenCaptured);
		assertThat(authenticationResult).isSameAs(authenticationTokenCaptured);
	}

	@Test
	public void shouldNotConvertAuthenticationObjectAndThrowAuthenticationException()
	{
		final AuthenticationException authenticationException = new BadCredentialsException(BAD_CREDENTIALS_MESSAGE);
		when(authenticationProvider.authenticate(any(Authentication.class))).thenThrow(authenticationException);

		final Throwable throwable = catchThrowable(() -> mainProviderManager.authenticate(otherAuthenticationToken));

		assertThat(throwable)
				.as("authentication should fail with BadCredentialsException")
				.isInstanceOf(BadCredentialsException.class)
				.hasMessage(BAD_CREDENTIALS_MESSAGE);

		final Authentication authenticationTokenCaptured = verifyAuthenticationProcess(otherAuthenticationToken);
		verify(eventPublisher).publishAuthenticationFailure(authenticationException, authenticationTokenCaptured);
	}

	private Authentication verifyAuthenticationProcess(final Authentication authenticationToken)
	{
		verify(oauthClientAuthenticationManagerSpy).authenticate(authenticationToken);
		final ArgumentCaptor<Authentication> authenticationTokenCaptor = ArgumentCaptor.forClass(Authentication.class);
		verify(parentProviderManagerSpy).authenticate(authenticationTokenCaptor.capture());
		final Authentication authenticationTokenCaptured = authenticationTokenCaptor.getValue();
		verify(authenticationProvider).authenticate(authenticationTokenCaptured);

		if (authenticationToken instanceof UsernamePasswordAuthenticationToken)
		{
			assertThat(authenticationTokenCaptured)
					.as("authentication token of type UsernamePasswordAuthenticationToken should be converted to OAuthUsernamePasswordAuthenticationToken")
					.isInstanceOf(OAuthUsernamePasswordAuthenticationToken.class);
		}
		else
		{
			assertThat(authenticationTokenCaptured)
					.as("authentication token of type other than UsernamePasswordAuthenticationToken should not be converted to OAuthUsernamePasswordAuthenticationToken")
					.isNotInstanceOf(OAuthUsernamePasswordAuthenticationToken.class);
		}
		return authenticationTokenCaptured;
	}
}
