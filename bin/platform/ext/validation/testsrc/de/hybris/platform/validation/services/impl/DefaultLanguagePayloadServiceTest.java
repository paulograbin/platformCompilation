package de.hybris.platform.validation.services.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.validation.constants.ValidationConstants;
import de.hybris.platform.validation.payloads.language.Language;
import de.hybris.platform.validation.services.InterfaceGenerator;
import de.hybris.platform.validation.services.LanguagePayloadService;

import javax.annotation.Resource;

import java.util.Locale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@IntegrationTest
public class DefaultLanguagePayloadServiceTest extends ServicelayerBaseTest
{
	@Resource
	private InterfaceGenerator interfaceGenerator;
	@Resource
	private LanguagePayloadService languagePayloadService;
	@Resource
	private ModelService modelService;
	@Resource
	private CommonI18NService commonI18NService;

	private static String getExpectedInterfaceName(final LanguageModel languageModel)
	{
		return ValidationConstants.LANGUAGE_PAYLOAD_INTERFACE_NAME_PREFIX + languageModel.getPk().toString();
	}

	private LanguageModel getOrCreateLanguageModel(final String isoCode)
	{
		try
		{
			return commonI18NService.getLanguage(isoCode);
		}
		catch (final Exception e)
		{
			final LanguageModel languageModel = modelService.create(LanguageModel.class);
			languageModel.setIsocode(isoCode);
			modelService.save(languageModel);
			return languageModel;
		}
	}

	@Test
	public void shouldGenerateLanguagePayloadInterfaceForLanguageModel()
	{
		//given
		final LanguageModel languageModel = getOrCreateLanguageModel(Locale.US.getLanguage());

		//when
		final Class<?> actual = languagePayloadService.getOrGenerateInterface(languageModel);

		//then
		assertNotNull(actual);
		assertEquals(getExpectedInterfaceName(languageModel), actual.getName());
		assertEquals(1, actual.getInterfaces().length);
		assertEquals(Language.class, actual.getInterfaces()[0]);
	}

	@Test
	public void shouldExtractLanguagePKFromLanguagePayload()
	{
		//given
		final var languageModel = getOrCreateLanguageModel(Locale.US.getLanguage());
		final Class<? extends Language> language = languagePayloadService.getOrGenerateInterface(languageModel);

		//when
		final String actual = languagePayloadService.extractLanguagePk(language);

		//then
		assertNotNull(actual);
		assertTrue(languageModel.getPk().toString().equalsIgnoreCase(actual));
	}

	@Test
	public void shouldThrowExceptionWhenPrefixIsInvalid()
	{
		//given
		final Class<?> superClass = Language.class;
		final String invalidInterfaceNamePrefix = "com.invalid.prefix.text.InvalidPrefixTestInterface";
		final Class<? extends Language> language = (Class<? extends Language>) interfaceGenerator.getOrGenerateInterface(
				invalidInterfaceNamePrefix, superClass);
		try
		{
			//when
			languagePayloadService.extractLanguagePk(language);
		}
		catch (final IllegalArgumentException actual)
		{
			// then
			assertEquals("Language subclass has invalid prefix", actual.getMessage());
		}
	}

	@Test
	public void shouldThrowExceptionWhenMissingPkSuffix()
	{
		//given
		final Class<?> superClass = Language.class;
		final String invalidInterfaceNamePrefix = ValidationConstants.LANGUAGE_PAYLOAD_INTERFACE_NAME_PREFIX;
		final Class<? extends Language> language = (Class<? extends Language>) interfaceGenerator.getOrGenerateInterface(
				invalidInterfaceNamePrefix, superClass);
		try
		{
			//when
			languagePayloadService.extractLanguagePk(language);
		}
		catch (final IllegalArgumentException actual)
		{
			// then
			assertEquals("Missing suffix of the Language subclass", actual.getMessage());
		}
	}

}
