/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.jalo.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.persistence.security.PasswordEncoder;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultUserPasswordCheckingStrategyTest
{

	private static final String UID = "uid";
	private static final String PASSWORD = RandomStringUtils.randomAlphabetic(3);
	private static final String ENCODED_PASSWORD = RandomStringUtils.randomAlphabetic(5);
	private static final String ENCODED_PASSWORD_2 = RandomStringUtils.randomAlphabetic(6);
	private static final String ENC = "enc";
	private static final String ENC_2 = "enc2";

	@Spy
	private DefaultUserPasswordCheckingStrategy strategy;

	@Mock
	private User user;

	@Mock
	private PasswordEncoder encoder;
	@Mock
	private PasswordEncoder encoder2;

	@Test
	public void shouldReturnFalseForEmptyPassword()
	{
		assertThat(strategy.checkPassword(user, null)).isFalse();
		assertThat(strategy.checkPassword(user, "")).isFalse();
		verifyNoMoreInteractions(user, encoder, encoder2);
	}

	@Test
	public void shouldReturnTrueForValidPassword()
	{
		// given
		doReturn(UID).when(user).getUid();
		doReturn(ENC).when(user).getPasswordEncoding();
		doReturn(ENCODED_PASSWORD).when(user).getEncodedPassword();
		doReturn(encoder).when(strategy).getPasswordEncoder(ENC);
		doReturn(true).when(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		doReturn(false).when(strategy).isReencodeEnabled();

		// when
		final boolean valid = strategy.checkPassword(user, PASSWORD);

		// then
		assertThat(valid).isTrue();
		verify(user).getUid();
		verify(user).getEncodedPassword();
		verify(user).getPasswordEncoding();
		verify(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		verifyNoMoreInteractions(user, encoder, encoder2);
	}

	@Test
	public void shouldReturnFalseForInvalidPassword()
	{
		// given
		doReturn(UID).when(user).getUid();
		doReturn(ENC).when(user).getPasswordEncoding();
		doReturn(ENCODED_PASSWORD).when(user).getEncodedPassword();
		doReturn(encoder).when(strategy).getPasswordEncoder(ENC);
		doReturn(false).when(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);

		// when
		final boolean valid = strategy.checkPassword(user, PASSWORD);

		// then
		assertThat(valid).isFalse();
		verify(user).getUid();
		verify(user).getEncodedPassword();
		verify(user).getPasswordEncoding();
		verify(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		verifyNoMoreInteractions(user, encoder, encoder2);
	}

	@Test
	public void shouldReencodePasswordWhenItNeedsUpdate()
	{
		// given
		doReturn(UID).when(user).getUid();
		doReturn(ENC).when(user).getPasswordEncoding();
		doReturn(ENCODED_PASSWORD).when(user).getEncodedPassword();
		doReturn(encoder).when(strategy).getPasswordEncoder(any());
		doReturn(true).when(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		doReturn(true).when(strategy).isReencodeEnabled();
		doReturn(true).when(encoder).needsUpgrade(ENCODED_PASSWORD);
		doReturn(ENC_2).when(strategy).getDefaultPasswordEncoding();
		doReturn(encoder2).when(strategy).getPasswordEncoder(ENC_2);
		doReturn(ENCODED_PASSWORD_2).when(encoder2).encode(UID, PASSWORD);

		// when
		final boolean valid = strategy.checkPassword(user, PASSWORD);

		// then
		assertThat(valid).isTrue();
		verify(user).getUid();
		verify(user).getEncodedPassword();
		verify(user).getPasswordEncoding();
		verify(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		verify(encoder).needsUpgrade(ENCODED_PASSWORD);
		verify(encoder2).encode(UID, PASSWORD);
		verify(user).setEncodedPassword(ENCODED_PASSWORD_2, ENC_2);
		verifyNoMoreInteractions(user, encoder, encoder2);
	}

	@Test
	public void shouldReencodePasswordWhenEncodingChanged()
	{
		// given
		doReturn(UID).when(user).getUid();
		doReturn(ENC).when(user).getPasswordEncoding();
		doReturn(ENCODED_PASSWORD).when(user).getEncodedPassword();
		doReturn(encoder).when(strategy).getPasswordEncoder(any());
		doReturn(true).when(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		doReturn(true).when(strategy).isReencodeEnabled();
		doReturn(ENC_2).when(strategy).getDefaultPasswordEncoding();
		doReturn(encoder2).when(strategy).getPasswordEncoder(ENC_2);
		doReturn(ENCODED_PASSWORD_2).when(encoder2).encode(UID, PASSWORD);

		// when
		final boolean valid = strategy.checkPassword(user, PASSWORD);

		// then
		assertThat(valid).isTrue();
		verify(user).getUid();
		verify(user).getEncodedPassword();
		verify(user).getPasswordEncoding();
		verify(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		verify(encoder).needsUpgrade(ENCODED_PASSWORD);
		verify(encoder2).encode(UID, PASSWORD);
		verify(user).setEncodedPassword(ENCODED_PASSWORD_2, ENC_2);
		verifyNoMoreInteractions(user, encoder, encoder2);
	}

	@Test
	public void shouldNotReencodeInvalidPasswordWhenEncodingChanged()
	{
		// given
		doReturn(UID).when(user).getUid();
		doReturn(ENC).when(user).getPasswordEncoding();
		doReturn(ENCODED_PASSWORD).when(user).getEncodedPassword();
		doReturn(encoder).when(strategy).getPasswordEncoder(ENC);
		doReturn(true).when(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		doReturn(true).when(strategy).isReencodeEnabled();
		doReturn(ENC_2).when(strategy).getDefaultPasswordEncoding();
		doReturn(encoder2).when(strategy).getPasswordEncoder(ENC_2);
		doReturn(ENCODED_PASSWORD_2).when(encoder2).encode(UID, PASSWORD);

		// when
		final boolean valid = strategy.checkPassword(user, PASSWORD);

		// then
		assertThat(valid).isTrue();
		verify(user).getUid();
		verify(user).getEncodedPassword();
		verify(user).getPasswordEncoding();
		verify(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		verify(encoder).needsUpgrade(ENCODED_PASSWORD);
		verify(encoder2).encode(UID, PASSWORD);
		verify(user).setEncodedPassword(ENCODED_PASSWORD_2, ENC_2);
		verifyNoMoreInteractions(user, encoder, encoder2);
	}

	@Test
	public void shouldNotReencodeWhenPropertyNotSet()
	{
		// given
		doReturn(UID).when(user).getUid();
		doReturn(ENC).when(user).getPasswordEncoding();
		doReturn(ENCODED_PASSWORD).when(user).getEncodedPassword();
		doReturn(encoder).when(strategy).getPasswordEncoder(ENC);
		doReturn(true).when(encoder).check(UID, ENCODED_PASSWORD, PASSWORD);
		doReturn(false).when(strategy).isReencodeEnabled();

		// when
		final boolean valid = strategy.checkPassword(user, PASSWORD);

		// then
		assertThat(valid).isTrue();
		verify(user).getUid();
		verify(user).getEncodedPassword();
		verify(user).getPasswordEncoding();
		verifyNoMoreInteractions(user);
	}

}
