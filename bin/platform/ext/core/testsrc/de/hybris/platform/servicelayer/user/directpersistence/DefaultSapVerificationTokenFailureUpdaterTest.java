/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.user.directpersistence;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.util.Utilities;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultSapVerificationTokenFailureUpdaterTest
{
	private static final String TABLE_NAME = "SAPUserVerificationToken";
	private static final String FAILED_ATTEMPTS_COLUMN = "failedAttempts";

	private JdbcTemplate jdbcTemplate;
	private DefaultSapVerificationTokenFailureUpdater updater;

	@Before
	public void setUp()
	{
		jdbcTemplate = mock(JdbcTemplate.class);
		updater = new DefaultSapVerificationTokenFailureUpdater(jdbcTemplate, TABLE_NAME, FAILED_ATTEMPTS_COLUMN);
	}

	@Test
	public void increaseFailedVerificationAttemptsReturnsUpdatedValueWhenUpdateIsSuccessful()
	{
		PK verificationTokenPk = PK.fromLong(12345L);
		when(jdbcTemplate.query(anyString(), ArgumentMatchers.<RowMapper<Integer>>any(), anyLong())).thenReturn(List.of(5));

		try (MockedStatic<Utilities> utilitiesMock = mockStatic(Utilities.class))
		{
			int result = updater.increaseFailedVerificationAttempts(verificationTokenPk);

			assertEquals(5, result);
			verify(jdbcTemplate).query(anyString(), ArgumentMatchers.<RowMapper<Integer>>any(), eq(verificationTokenPk.getLong()));
			utilitiesMock.verify(() -> Utilities.invalidateCache(verificationTokenPk));
		}
	}

	@Test
	public void increaseFailedVerificationAttemptsReturnsMinusOneWhenUpdateFails()
	{
		PK verificationTokenPk = PK.fromLong(12345L);
		when(jdbcTemplate.query(anyString(), ArgumentMatchers.<RowMapper<Integer>>any(), anyLong())).thenReturn(
				Collections.emptyList());

		try (MockedStatic<Utilities> utilitiesMock = mockStatic(Utilities.class))
		{
			int result = updater.increaseFailedVerificationAttempts(verificationTokenPk);

			assertEquals(-1, result);
			verify(jdbcTemplate).query(anyString(), ArgumentMatchers.<RowMapper<Integer>>any(), eq(verificationTokenPk.getLong()));
			utilitiesMock.verify(() -> Utilities.invalidateCache(verificationTokenPk));
		}
	}

	@Test
	public void increaseFailedVerificationAttemptsThrowsExceptionWhenJdbcTemplateThrowsException()
	{
		PK verificationTokenPk = PK.fromLong(12345L);
		when(jdbcTemplate.update(anyString(), eq(12345L))).thenThrow(new RuntimeException("Database error"));

		try (MockedStatic<Utilities> utilitiesMock = mockStatic(Utilities.class))
		{
			assertThrows(RuntimeException.class, () -> updater.increaseFailedVerificationAttempts(verificationTokenPk));
			verify(jdbcTemplate, never()).query(anyString(), ArgumentMatchers.<RowMapper<Integer>>any(),
					eq(verificationTokenPk.getLong()));
			utilitiesMock.verify(() -> Utilities.invalidateCache(verificationTokenPk), never());
		}
	}
}
