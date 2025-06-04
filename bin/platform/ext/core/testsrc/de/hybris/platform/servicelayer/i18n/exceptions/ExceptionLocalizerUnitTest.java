/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.i18n.exceptions;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.i18n.L10NService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionLocalizerUnitTest
{
	private static final String MESSAGE_KEY = "message.key";
	private static final String LOCALIZED_MESSAGE = "Localized message";
	private static final String PARAM_1 = "param1";
	private static final String PARAM_2 = "param2";
	private static final String LOCALIZED_PARAM_PREFIX = "localized";
	private static final Object[] PARAMETERS = { PARAM_1, PARAM_2 };

	@Mock
	private L10NService l10NService;

	@Test
	public void shouldReturnLocalizedMessage()
	{
		//given
		final ExceptionLocalizer localizer = new ExceptionLocalizer(MESSAGE_KEY, PARAMETERS, l10NService);
		when(l10NService.getLocalizedString(MESSAGE_KEY, PARAMETERS)).thenReturn(LOCALIZED_MESSAGE);

		//when
		final String result = localizer.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(LOCALIZED_MESSAGE);
	}

	@Test
	public void shouldReturnLocalizedMessageWhenNoParameters()
	{

		//given
		final ExceptionLocalizer localizer = new ExceptionLocalizer(MESSAGE_KEY, l10NService);
		when(l10NService.getLocalizedString(MESSAGE_KEY)).thenReturn(LOCALIZED_MESSAGE);

		//when
		final String result = localizer.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(LOCALIZED_MESSAGE);
	}

	@Test
	public void shouldReturnNullWhenNoMessageKey()
	{

		//given
		final ExceptionLocalizer localizer = new ExceptionLocalizer(null, l10NService);

		//when
		final String result = localizer.getLocalizedMessage();

		//then
		assertThat(result).isNull();
	}

	@Test
	public void shouldSetDefaultL10NServiceWhenNoOneProvided()
	{
		final ExceptionLocalizer localizer = new ExceptionLocalizer(MESSAGE_KEY);
		final L10NService defaultL10NService = localizer.getL10NService();

		assertThat(defaultL10NService).isEqualTo(Registry.getApplicationContext().getBean("l10nService", L10NService.class));
	}

	@Test
	public void shouldUseMappedParametersWhenCustomParamMapperIsUsed()
	{
		//given
		final ExceptionLocalizer localizer = new ExceptionLocalizer(MESSAGE_KEY, PARAMETERS, l10NService);
		final Object[] localizedParameters = { LOCALIZED_PARAM_PREFIX + PARAM_1, LOCALIZED_PARAM_PREFIX + PARAM_2 };
		when(l10NService.getLocalizedString(MESSAGE_KEY, localizedParameters)).thenReturn(LOCALIZED_MESSAGE);

		//when
		final String result = localizer.getLocalizedMessage(p -> LOCALIZED_PARAM_PREFIX + p);

		//then
		assertThat(result).isEqualTo(LOCALIZED_MESSAGE);
	}

	@Test
	public void shouldUseOriginalParametersWhenCustomParamMapperIsNull()
	{
		//given
		final ExceptionLocalizer localizer = new ExceptionLocalizer(MESSAGE_KEY, PARAMETERS, l10NService);
		when(l10NService.getLocalizedString(MESSAGE_KEY, PARAMETERS)).thenReturn(LOCALIZED_MESSAGE);

		//when
		final String result = localizer.getLocalizedMessage(null);

		//then
		assertThat(result).isEqualTo(LOCALIZED_MESSAGE);
	}
}
