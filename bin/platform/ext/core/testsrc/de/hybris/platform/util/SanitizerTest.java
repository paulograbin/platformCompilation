/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.util;

import static de.hybris.platform.util.Sanitizer.sanitize;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SanitizerTest
{

	@Test
	public void testSanitizer()
	{
		for (char c = 0; c < 1000; c++)
		{
			// given
			final String expected = Character.isISOControl(c) ? "" : String.valueOf(c).trim();

			// when
			final String actual = sanitize(String.valueOf(c));

			// then
			assertThat(actual).isEqualTo(expected);
		}
	}

	@Test
	public void testSanitizerManually()
	{
		assertThat(sanitize("\u0000")).isEmpty();
		assertThat(sanitize("\u0001")).isEmpty();
		assertThat(sanitize("\u0008")).isEmpty();
		assertThat(sanitize("\u000C")).isEmpty();
		assertThat(sanitize("\u0019")).isEmpty();

		assertThat(sanitize("\b")).isEmpty();
		assertThat(sanitize("\t")).isEmpty();
		assertThat(sanitize("\n")).isEmpty();
		assertThat(sanitize("\f")).isEmpty();
		assertThat(sanitize("\r")).isEmpty();

		assertThat(sanitize("Sample log")).isEqualTo("Sample log");
		assertThat(sanitize("Following request was perfomed: https://example.com/\nINFO Fake log"))
				.isEqualTo("Following request was perfomed: https://example.com/INFO Fake log");
	}

}
