/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.UserModel;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.junit.Test;

@UnitTest
public class UserAuditLoginStrategyTest
{

	@Test
	public void shouldThrowNullPointerExceptionWhenUserIsNull()
	{
		final Throwable thrown = catchThrowable(() -> UserAuditLoginStrategy.isUserAccountLocked(null));

		assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("user must not be null");
	}

	@Test
	public void shouldLockUserAccountWhenUserIsDisabled()
	{
		final UserModel user = mock(UserModel.class);
		when(user.isLoginDisabled()).thenReturn(true);
		when(user.getDeactivationDate()).thenReturn(null);

		assertTrue(UserAuditLoginStrategy.isUserAccountLocked(user));
	}

	@Test
	public void shouldNotLockUserAccountWhenUserIsNotDisabled()
	{
		final UserModel user = mock(UserModel.class);
		when(user.isLoginDisabled()).thenReturn(false);
		when(user.getDeactivationDate()).thenReturn(null);

		assertFalse(UserAuditLoginStrategy.isUserAccountLocked(user));
	}

	@Test
	public void shouldLockUserAccountWhenUserDeactivationDateIsOlderThanCurrentDate()
	{
		final UserModel user = mock(UserModel.class);
		final Date passedDeactivationDate = Date.from(Instant.now().minusSeconds(1));
		when(user.isLoginDisabled()).thenReturn(false);
		when(user.getDeactivationDate()).thenReturn(passedDeactivationDate);

		assertTrue(UserAuditLoginStrategy.isUserAccountLocked(user));
	}

	@Test
	public void shouldNotLockUserAccountWhenUserDeactivationDateIsNotOlderThanCurrentDate()
	{
		final UserModel user = mock(UserModel.class);

		final Date futureDeactivationDate = Date.from(Instant.now().plus(Duration.ofMinutes(1L)));
		when(user.isLoginDisabled()).thenReturn(false);
		when(user.getDeactivationDate()).thenReturn(futureDeactivationDate);

		assertFalse(UserAuditLoginStrategy.isUserAccountLocked(user));
	}
}
