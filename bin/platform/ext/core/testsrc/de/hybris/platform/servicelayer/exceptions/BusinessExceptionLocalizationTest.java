/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.exceptions;

import static org.assertj.core.api.Java6Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.i18n.L10NService;
import de.hybris.platform.servicelayer.i18n.exceptions.ExceptionLocalizer;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Locale;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class BusinessExceptionLocalizationTest extends ServicelayerBaseTest
{
	private static final String ERROR_MESSAGE = "error message";
	private static final String ERROR_MESSAGE_KEY = "exception.mandatoryattributesvalidator.missing";
	private static final String PARAM_1 = "param1";
	private static final String PARAM_2 = "param2";
	private static final String PARAM_3 = "param3";
	private static final String LOCALIZED_PARAM_PREFIX = "localized";
	private static final String LOCALIZED_MESSAGE_EN = "missing values for %s in model %s to create a new %s";
	private static final String LOCALIZED_MESSAGE_DE = "fehlende Werte für %s in Modell %s zum Erstellen einer neuen %s";

	@Resource
	private L10NService l10nService;

	@Resource
	private I18NService i18nService;

	@Resource
	private CommonI18NService commonI18NService;

	@Resource
	private ModelService modelService;

	private Locale currentLocale;

	@Before
	public void prepare()
	{
		currentLocale = i18nService.getCurrentLocale();
		try
		{
			commonI18NService.getLanguage(Locale.GERMAN.getLanguage());
		}
		catch (final UnknownIdentifierException e)
		{
			final LanguageModel language = modelService.create(LanguageModel.class);
			language.setIsocode(Locale.GERMAN.getLanguage());
			modelService.save(language);
		}
	}

	@After
	public void cleanup()
	{
		if (currentLocale != null)
		{
			i18nService.setCurrentLocale(currentLocale);
		}
	}

	@Test
	public void shouldReturnLocalizedMessage()
	{
		//given
		final String expectedMessageEn = String.format(LOCALIZED_MESSAGE_EN, PARAM_1, PARAM_2, PARAM_3);
		final String expectedMessageDe = String.format(LOCALIZED_MESSAGE_DE, PARAM_1, PARAM_2, PARAM_3);
		final ExceptionLocalizer localizer = new ExceptionLocalizer(ERROR_MESSAGE_KEY, new Object[]{ PARAM_1, PARAM_2, PARAM_3 },
				l10nService);
		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, localizer);

		//when
		i18nService.setCurrentLocale(Locale.ENGLISH);
		String result = localizableException.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(expectedMessageEn);

		//when
		i18nService.setCurrentLocale(Locale.GERMAN);
		result = localizableException.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(expectedMessageDe);
	}

	@Test
	public void shouldReturnLocalizedMessageWithDefaultL10NService()
	{
		//given
		final String expectedMessageEn = String.format(LOCALIZED_MESSAGE_EN, PARAM_1, PARAM_2, PARAM_3);
		final String expectedMessageDe = String.format(LOCALIZED_MESSAGE_DE, PARAM_1, PARAM_2, PARAM_3);
		final ExceptionLocalizer localizer = new ExceptionLocalizer(ERROR_MESSAGE_KEY, new Object[]{ PARAM_1, PARAM_2, PARAM_3 });

		assertThat(localizer.getL10NService()).isEqualTo(l10nService); //l10nService is set even if not passed in constructor

		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, localizer);

		//when
		i18nService.setCurrentLocale(Locale.ENGLISH);
		String result = localizableException.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(expectedMessageEn);

		//when
		i18nService.setCurrentLocale(Locale.GERMAN);
		result = localizableException.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(expectedMessageDe);
	}

	@Test
	public void shouldReturnLocalizedMessageWithMappedParameterWhenCustomMapperIsUsed()
	{
		//given
		final String expectedMessageEn = String.format(LOCALIZED_MESSAGE_EN, LOCALIZED_PARAM_PREFIX + PARAM_1,
				LOCALIZED_PARAM_PREFIX + PARAM_2, LOCALIZED_PARAM_PREFIX + PARAM_3);
		final String expectedMessageDe = String.format(LOCALIZED_MESSAGE_DE, LOCALIZED_PARAM_PREFIX + PARAM_1,
				LOCALIZED_PARAM_PREFIX + PARAM_2, LOCALIZED_PARAM_PREFIX + PARAM_3);
		final ExceptionLocalizer localizer = new ExceptionLocalizer(ERROR_MESSAGE_KEY, new Object[]{ PARAM_1, PARAM_2, PARAM_3 },
				l10nService);
		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, localizer);

		//when
		i18nService.setCurrentLocale(Locale.ENGLISH);
		String result = localizableException.getLocalizedMessage(p -> LOCALIZED_PARAM_PREFIX + p);

		//then
		assertThat(result).isEqualTo(expectedMessageEn);

		//when
		i18nService.setCurrentLocale(Locale.GERMAN);
		result = localizableException.getLocalizedMessage(p -> LOCALIZED_PARAM_PREFIX + p);

		//then
		assertThat(result).isEqualTo(expectedMessageDe);
	}

	@Test
	public void shouldReturnLocalizedMessageWithOriginalParametersWhenCustomMapperIsNull()
	{
		//given
		final String expectedMessageEn = String.format(LOCALIZED_MESSAGE_EN, PARAM_1, PARAM_2, PARAM_3);
		final ExceptionLocalizer localizer = new ExceptionLocalizer(ERROR_MESSAGE_KEY, new Object[]{ PARAM_1, PARAM_2, PARAM_3 },
				l10nService);
		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, localizer);

		//when
		i18nService.setCurrentLocale(Locale.ENGLISH);
		final String result = localizableException.getLocalizedMessage(null);

		//then
		assertThat(result).isEqualTo(expectedMessageEn);
	}

	@Test
	public void shouldReturnDefaultErrorMessageWhenNoLocalizer()
	{
		//given
		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, null);

		//when
		String result = localizableException.getLocalizedMessage();

		//then
		assertThat(result).isEqualTo(ERROR_MESSAGE);

		//when
		result = localizableException.getLocalizedMessage(null);

		//then
		assertThat(result).isEqualTo(ERROR_MESSAGE);
	}

	@Test
	public void shouldHaveLocalizedMessageWhenExceptionLocalizerIsPresent()
	{
		//given
		final ExceptionLocalizer localizer = new ExceptionLocalizer(ERROR_MESSAGE_KEY, new Object[]{ PARAM_1, PARAM_2, PARAM_3 },
				l10nService);
		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, localizer);

		//when
		final boolean result = localizableException.hasLocalizedMessage();

		//then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldNotHaveLocalizedMessageWhenExceptionLocalizerIsNotPresent()
	{
		//given
		final BusinessException localizableException = new BusinessException(ERROR_MESSAGE, null, null);

		//when
		final boolean result = localizableException.hasLocalizedMessage();

		//then
		assertThat(result).isFalse();
	}
}
