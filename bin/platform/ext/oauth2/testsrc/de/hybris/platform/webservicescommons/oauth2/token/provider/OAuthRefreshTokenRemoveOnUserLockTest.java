/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.webservicescommons.oauth2.token.provider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.springframework.security.oauth2.common.OAuth2AccessToken.REFRESH_TOKEN;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.oauth2.util.SHAGenerator;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;
import de.hybris.platform.webservicescommons.model.OAuthRefreshTokenModel;
import de.hybris.platform.webservicescommons.oauth2.token.dao.OAuthTokenDao;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

/**
 * Integration test for {@link de.hybris.platform.oauth2.services.impl.DefaultHybrisOpenIDTokenServices}.
 * Verifies that refresh token is removed when user is disabled or deactivated.
 */
@IntegrationTest
public class OAuthRefreshTokenRemoveOnUserLockTest extends ServicelayerBaseTest
{
	private static final String TEST_USER = "test_user";
	private static final String TEST_SCOPE = "test_scope";
	private static final String CLIENT_ID = "test_client";
	private static final String DISABLED_USER_MESSAGE = "User is disabled";
	private static final String INVALID_REFRESH_TOKEN_MESSAGE = "Invalid refresh token";

	@Resource
	private OAuthTokenDao oauthTokenDao;
	@Resource
	private ModelService modelService;
	@Resource
	private AuthorizationServerTokenServices oauthTokenServices;
	private UserModel testUser;
	private OAuth2AccessToken userAccessToken;
	private OAuth2AccessToken clientOnlyAccessToken;


	@Before
	public void setup()
	{
		final OAuthClientDetailsModel testClient = createTestClient();
		testUser = createTestUser();
		modelService.saveAll(testClient, testUser);
		clientOnlyAccessToken = createAccessToken(true);
		userAccessToken = createAccessToken(false);
	}

	private OAuthClientDetailsModel createTestClient()
	{
		final OAuthClientDetailsModel client = new OAuthClientDetailsModel();
		client.setClientId(CLIENT_ID);
		client.setAuthorizedGrantTypes(Set.of(REFRESH_TOKEN));
		return client;
	}

	private UserModel createTestUser()
	{
		final UserModel user = new UserModel();
		user.setUid(TEST_USER);
		user.setLoginDisabled(Boolean.FALSE);
		return user;
	}

	private static TokenRequest createTokenRequest()
	{
		return new TokenRequest(null, CLIENT_ID, List.of(TEST_SCOPE), REFRESH_TOKEN);
	}

	private static OAuth2Authentication createAuthentication(final boolean clientOnly)
	{
		final OAuth2Request oAuth2Request = new OAuth2Request(null, CLIENT_ID, null, true, Set.of(TEST_SCOPE),
				null, null, null, null);

		return new OAuth2Authentication(oAuth2Request, clientOnly ? null : new TestingAuthenticationToken(TEST_USER, null));
	}

	private OAuth2AccessToken createAccessToken(final boolean clientOnly)
	{
		final OAuth2AccessToken accessToken = oauthTokenServices.createAccessToken(createAuthentication(clientOnly));
		assertThat(accessToken).isNotNull();
		assertThat(accessToken.getRefreshToken()).isNotNull();
		return accessToken;
	}

	private OAuthRefreshTokenModel getRefreshTokenModel(final OAuth2AccessToken accessToken)
	{
		final String refreshTokenId = SHAGenerator.generateSHA256Signature(accessToken.getRefreshToken().getValue());
		final OAuthRefreshTokenModel refreshTokenModel = oauthTokenDao.findRefreshTokenById(refreshTokenId);
		assertThat(refreshTokenModel).isNotNull();
		return refreshTokenModel;
	}

	private void assertThatRefreshTokenCannotBeReused(final String refreshTokenValue)
	{
		final Throwable invalidTokenError = catchThrowable(
				() -> oauthTokenServices.refreshAccessToken(refreshTokenValue, createTokenRequest()));

		assertThat(invalidTokenError).as("Removed refresh token cannot be reused")
		                             .isInstanceOf(InvalidGrantException.class).hasMessage(INVALID_REFRESH_TOKEN_MESSAGE);
	}

	@Test
	public void shouldRemoveRefreshTokenWhenUserIsDisabled()
	{
		// given
		final OAuthRefreshTokenModel refreshTokenModel = getRefreshTokenModel(userAccessToken);
		testUser.setLoginDisabled(Boolean.TRUE);
		modelService.save(testUser);

		// when
		final Throwable disabledUserError = catchThrowable(
				() -> oauthTokenServices.refreshAccessToken(userAccessToken.getRefreshToken().getValue(), createTokenRequest()));
		//then
		assertThat(disabledUserError).isInstanceOf(InvalidGrantException.class).hasMessage(DISABLED_USER_MESSAGE);
		assertThat(modelService.isRemoved(refreshTokenModel)).as("Refresh token should be removed for the disabled user")
		                                                     .isTrue();

		assertThatRefreshTokenCannotBeReused(userAccessToken.getRefreshToken().getValue());
	}

	@Test
	public void shouldRemoveRefreshTokenWhenUserIsDeactivated()
	{
		// given
		final OAuthRefreshTokenModel refreshTokenModel = getRefreshTokenModel(userAccessToken);
		testUser.setDeactivationDate(Date.from(Instant.now().minusSeconds(60L)));
		modelService.save(testUser);

		// when
		final Throwable error = catchThrowable(
				() -> oauthTokenServices.refreshAccessToken(userAccessToken.getRefreshToken().getValue(), createTokenRequest()));
		//then
		assertThat(error).isInstanceOf(InvalidGrantException.class).hasMessage(DISABLED_USER_MESSAGE);
		assertThat(modelService.isRemoved(refreshTokenModel)).as("Refresh token should be removed for the deactivated user")
		                                                     .isTrue();

		assertThatRefreshTokenCannotBeReused(userAccessToken.getRefreshToken().getValue());
	}

	@Test
	public void shouldRefreshTokenWhenUserIsNotLocked()
	{
		// when
		final OAuth2AccessToken newOAuth2AccessToken = oauthTokenServices.refreshAccessToken(
				userAccessToken.getRefreshToken().getValue(), createTokenRequest());

		//then
		assertThat(newOAuth2AccessToken).as("New access token should be created").isNotNull();
		assertThat(newOAuth2AccessToken.getValue()).as("New access token has different value than the old one")
		                                           .isNotEqualTo(userAccessToken.getValue());
		assertThat(newOAuth2AccessToken.getRefreshToken()).as("Refresh token of the new access token should exist").isNotNull();
	}

	@Test
	public void shouldRemoveRefreshTokenWhenUserIsRemoved()
	{
		// given
		final OAuthRefreshTokenModel refreshTokenModel = getRefreshTokenModel(userAccessToken);
		modelService.remove(testUser);

		// when
		final Throwable invalidTokenError = catchThrowable(
				() -> oauthTokenServices.refreshAccessToken(userAccessToken.getRefreshToken().getValue(), createTokenRequest()));
		//then
		assertThat(invalidTokenError).isInstanceOf(InvalidGrantException.class).hasMessage(INVALID_REFRESH_TOKEN_MESSAGE);
		assertThat(modelService.isRemoved(refreshTokenModel)).as("Refresh token should be removed when user is removed")
		                                                     .isTrue();
	}

	@Test
	public void shouldRefreshTokenWhenClientOnlyAuthentication()
	{
		// when
		final OAuth2AccessToken newOAuth2AccessToken = oauthTokenServices.refreshAccessToken(
				clientOnlyAccessToken.getRefreshToken().getValue(), createTokenRequest());

		//then
		assertThat(newOAuth2AccessToken).as("New access token for the client should be created").isNotNull();
		assertThat(newOAuth2AccessToken.getValue()).as("New access token for the client has different value than the old one")
		                                           .isNotEqualTo(clientOnlyAccessToken.getValue());
		assertThat(newOAuth2AccessToken.getRefreshToken()).as("Refresh token of the new access token for the client should exist")
		                                                  .isNotNull();
	}
}
