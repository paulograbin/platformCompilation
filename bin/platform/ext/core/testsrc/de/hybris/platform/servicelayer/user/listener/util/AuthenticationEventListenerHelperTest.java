/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.user.listener.util;

import static de.hybris.platform.servicelayer.user.listener.util.AuthenticationEventListenerHelper.onFailureAuthenticationEvent;
import static de.hybris.platform.servicelayer.user.listener.util.AuthenticationEventListenerHelper.onSuccessAuthenticationEvent;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.user.UserAuditLoginStrategy;

import java.util.function.Predicate;

import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

@IntegrationTest
public class AuthenticationEventListenerHelperTest extends ServicelayerBaseTest
{
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationEventListenerHelperTest.class);
	private static final String CLIENT_ID = "testClient";
	private static final String CLIENT_SECRET = "testSecret";

	@Test
	public void shouldAuditIfAuthenticationIsAllowed()
	{
		//given
		final UserAuditLoginStrategy userAuditLoginStrategy = getUserAuditLoginStrategy();
		final Predicate<Authentication> isAllowedAuthenticationForEvent = authentication ->
				authentication instanceof UsernamePasswordAuthenticationToken ||
						authentication instanceof TestAbstractAuthenticationToken;


		//when, then
		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createOAuthUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createOAuthUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 1);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createTestUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createTestUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 2);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 3);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createTestAbstractAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createTestAbstractAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 4);
	}

	@Test
	public void shouldNotAuditIfAuthenticationIsNotAllowed()
	{
		//given
		final UserAuditLoginStrategy userAuditLoginStrategy = getUserAuditLoginStrategy();
		final Predicate<Authentication> isAllowedAuthenticationForEvent = authentication ->
				authentication instanceof OAuthUsernamePasswordAuthenticationToken ||
						authentication instanceof TestUsernamePasswordAuthenticationToken;

		//when, then
		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 0);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createTestAbstractAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createTestAbstractAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 0);
	}

	@Test
	public void shouldAuditOnlyForAllowedAuthentications()
	{
		//given
		final UserAuditLoginStrategy userAuditLoginStrategy = getUserAuditLoginStrategy();
		final Predicate<Authentication> isAllowedAuthenticationForEvent = authentication ->
				authentication instanceof TestUsernamePasswordAuthenticationToken ||
						authentication instanceof OAuthUsernamePasswordAuthenticationToken;

		//when, then
		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 0);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createOAuthUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createOAuthUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 1);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createTestAbstractAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createTestAbstractAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 1);

		onFailureAuthenticationEvent(userAuditLoginStrategy, createFailureEvent(createTestUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		onSuccessAuthenticationEvent(userAuditLoginStrategy, createSuccessEvent(createTestUsernamePasswordAuthenticationToken()),
				isAllowedAuthenticationForEvent, LOG);
		verifyInvocationsOnWrongAndCorrectCredentials(userAuditLoginStrategy, 2);
	}

	private void verifyInvocationsOnWrongAndCorrectCredentials(final UserAuditLoginStrategy userAuditLoginStrategy,
	                                                           final int times)
	{
		verify(userAuditLoginStrategy, times(times)).auditUserOnWrongCredentials(anyString());
		verify(userAuditLoginStrategy, times(times)).auditUserOnCorrectCredentials(anyString());
	}

	private AuthenticationFailureBadCredentialsEvent createFailureEvent(final Authentication authentication)
	{
		return new AuthenticationFailureBadCredentialsEvent(authentication, new BadCredentialsException("Bad credentials"));
	}

	private AuthenticationSuccessEvent createSuccessEvent(final Authentication authentication)
	{
		return new AuthenticationSuccessEvent(authentication);
	}

	private UserAuditLoginStrategy getUserAuditLoginStrategy()
	{
		return Mockito.mock(UserAuditLoginStrategy.class);
	}

	private TestUsernamePasswordAuthenticationToken createTestUsernamePasswordAuthenticationToken()
	{
		return new TestUsernamePasswordAuthenticationToken(CLIENT_ID, CLIENT_SECRET);
	}

	private OAuthUsernamePasswordAuthenticationToken createOAuthUsernamePasswordAuthenticationToken()
	{
		return new OAuthUsernamePasswordAuthenticationToken(CLIENT_ID, CLIENT_SECRET);
	}

	private UsernamePasswordAuthenticationToken createUsernamePasswordAuthenticationToken()
	{
		return new UsernamePasswordAuthenticationToken(CLIENT_ID, CLIENT_SECRET);
	}

	private TestAbstractAuthenticationToken createTestAbstractAuthenticationToken()
	{
		return new TestAbstractAuthenticationToken();
	}

	private static class TestUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken
	{
		public TestUsernamePasswordAuthenticationToken(final Object principal, final Object credentials)
		{
			super(principal, credentials);
		}
	}

	private static class TestAbstractAuthenticationToken extends AbstractAuthenticationToken
	{
		public TestAbstractAuthenticationToken()
		{
			super(null);
		}

		@Override
		public Object getCredentials()
		{
			return CLIENT_ID;
		}

		@Override
		public Object getPrincipal()
		{
			return CLIENT_SECRET;
		}
	}
}
