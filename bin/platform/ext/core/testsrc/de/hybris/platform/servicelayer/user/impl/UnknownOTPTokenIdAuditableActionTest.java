/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.user.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AuditableActions;
import de.hybris.platform.audit.AuditableActionsUtil;
import de.hybris.platform.audit.actions.AuditableActionHandler;
import de.hybris.platform.core.enums.SAPUserVerificationPurpose;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import javax.annotation.Resource;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@IntegrationTest
public class UnknownOTPTokenIdAuditableActionTest extends ServicelayerBaseTest
{

	public static final String TEST_USER_UID = "testUser@sap.com";
	@Resource
	private DefaultSapUserVerificationTokenService userVerificationTokenService;

	private AuditableActionHandler testAuditableActionHandler;
	private Supplier<AuditableActionHandler> originalActionHandler;

	private Optional<AuditableActions.Action> getAuditableAction(final String actionName)
	{

		final ArgumentCaptor<AuditableActions.Action> argCaptor = ArgumentCaptor.forClass(AuditableActions.Action.class);
		verify(testAuditableActionHandler, atLeastOnce()).auditAction(argCaptor.capture());

		return argCaptor.getAllValues().stream().filter(action -> actionName.equals(action.getActionName())).findFirst();

	}

	@Before
	public void setUp()
	{
		testAuditableActionHandler = mock(AuditableActionHandler.class);
		originalActionHandler = AuditableActionsUtil.getAuditableActionHandlerFactory();
		AuditableActionsUtil.setAuditableActionHandlerFactory(() -> testAuditableActionHandler);
	}

	@After
	public void tearDown()
	{
		AuditableActionsUtil.setAuditableActionHandlerFactory(originalActionHandler);
	}

	@Test
	public void shouldAuditUnknownTokenIdWhenLookupNonExistingTokenWithUser()
	{
		//given
		final String tokenId = "UnknownTokenId";

		//when, then
		assertThatThrownBy(
				() -> userVerificationTokenService.lookupTokenWithUser(SAPUserVerificationPurpose.LOGIN, tokenId)).isInstanceOf(
				UnknownIdentifierException.class);

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction("unknown OTP tokenId");
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry("verificationPurpose", SAPUserVerificationPurpose.LOGIN.getCode()), entry("tokenId", tokenId));

	}

	@Test
	public void shouldAuditUnknownTokenIdWhenLookupNonExistingTokenWithoutUser()
	{
		//given
		final String tokenId = "UnknownTokenId";

		//when, then
		assertThatThrownBy(() -> userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN, tokenId)).isInstanceOf(
				UnknownIdentifierException.class);

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction("unknown OTP tokenId");
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry("verificationPurpose", SAPUserVerificationPurpose.LOGIN.getCode()), entry("tokenId", tokenId));

	}

	@Test
	public void shouldNotGenerateAuditUnknownTokenIdWhenLookupExistingToken()
	{
		//given
		final var userVerificationTokenData = userVerificationTokenService.create(SAPUserVerificationPurpose.LOGIN, TEST_USER_UID);
		final String tokenId = userVerificationTokenData.getTokenId();
		try
		{

			//when
			userVerificationTokenService.lookupToken(SAPUserVerificationPurpose.LOGIN, tokenId);

			//then no audit actions of type "unknown OTP tokenId" are created
			final Optional<AuditableActions.Action> optionalAction = getAuditableAction("unknown OTP tokenId");
			assertThat(optionalAction).isEmpty();

		}
		finally
		{
			//cleanup
			userVerificationTokenService.deleteToken(userVerificationTokenData.getToken());
		}
	}



}


