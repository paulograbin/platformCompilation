/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.internal.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.exceptions.ModelRemovalException;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.internal.model.impl.ItemModelCloneCreator;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class ComposedTypeCloneIntegrationTest extends ServicelayerTransactionalBaseTest
{
	private static final String TITLE_TYPE_CODE = "Title";
	private static final String CUSTOM_SHORT_CODE = "customCode";

	/* Type Fields */
	private static final String TYPE_SHORT_CODE = "myType";
	private static final String TYPE_NAME = "My Type";
	private static final String TYPE_DESCRIPTION = "My Type description";


	/* Inherited Attribute Fields */
	private static final String INHERITED_ATTRIBUTE_SHORT_CODE = "inheritedCustomAttribute";
	private static final String INHERITED_ATTRIBUTE_NAME = "My inherited attribute name";
	private static final String INHERITED_ATTRIBUTE_DESCRIPTION = "My inherited attribute description";
	private static final String INHERITED_ATTRIBUTE_VALUE_EN = "My inherited attribute Value";
	private static final String INHERITED_ATTRIBUTE_VALUE_DE = "Mein geerbter Attributwert";

	/* type codes */
	private static final String LOCALIZED_STRING_TYPE_CODE = "localized:java.lang.String";

	private ItemModelCloneCreator itemModelCloneCreator;

	@Resource
	private ModelService modelService;

	@Resource
	private TypeService typeService;

	@Resource
	private I18NService i18nService;
	

	private TitleModel customModel = null;
	private ComposedTypeModel customType = null;
	private AttributeDescriptorModel inheritedAttributeDescriptorModel = null;

	@Before
	public void setup()
	{
		getOrCreateLanguage("en");
		getOrCreateLanguage("de");

		itemModelCloneCreator = new ItemModelCloneCreator(modelService, i18nService, typeService);
	}

	@After
	public void tearDown()
	{
		try
		{
			/* Clear up the data */
			if (customModel != null)
			{
				modelService.remove(customModel);
				customModel = null;
			}

			if (inheritedAttributeDescriptorModel != null)
			{
				deleteAttribute(typeService.getComposedTypeForCode(TITLE_TYPE_CODE));
				inheritedAttributeDescriptorModel = null;
			}

			if (customType != null)
			{
				modelService.remove(customType);
				customType = null;
			}
		}
		catch (ModelRemovalException modelRemovalException)
		{
			// Ignore
		}

	}

	@Test
	public void testCloneSavedWithLocalizedMap()
	{
		/* 1) Create a custom attribute against the Title type */
		inheritedAttributeDescriptorModel = createAttribute();

		/* 2) Create a new custom type based on the Title type */
		customType = createCustomType(Locale.ENGLISH);

		customModel = modelService.create(customType.getCode());
		customModel.setCode(CUSTOM_SHORT_CODE);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE,
		                               Map.of(Locale.ENGLISH, INHERITED_ATTRIBUTE_VALUE_EN,
		                                      Locale.GERMAN, INHERITED_ATTRIBUTE_VALUE_DE));
		modelService.save(customModel);

		/* clone */
		final TitleModel clonedCustomModel = (TitleModel) itemModelCloneCreator.copy(customModel);

		assertNotSame("The custom model and its clone should not refer to the same object",
		              customModel, clonedCustomModel);

		assertEquals("The code of the custom model and its clone should be equal",
		             customModel.getCode(), clonedCustomModel.getCode());

		validateClonedProperty(clonedCustomModel, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.ENGLISH, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.GERMAN, customModel);
	}

	@Test
	public void testCloneNotSavedWithLocalizedMap()
	{
		/* 1) Create a custom attribute against the Title type */
		inheritedAttributeDescriptorModel = createAttribute();

		/* 2) Create a new custom type based on the Title type */
		customType = createCustomType(Locale.ENGLISH);

		customModel = modelService.create(customType.getCode());
		customModel.setCode(CUSTOM_SHORT_CODE);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE,
		                               Map.of(Locale.ENGLISH, INHERITED_ATTRIBUTE_VALUE_EN,
		                                      Locale.GERMAN, INHERITED_ATTRIBUTE_VALUE_DE));

		/* clone */
		final TitleModel clonedCustomModel = (TitleModel) itemModelCloneCreator.copy(customModel);

		assertNotSame("The custom model and its clone should not refer to the same object",
		              customModel, clonedCustomModel);

		assertEquals("The code of the custom model and its clone should be equal",
		             customModel.getCode(), clonedCustomModel.getCode());

		validateClonedProperty(clonedCustomModel, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.ENGLISH, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.GERMAN, customModel);
		modelService.save(customModel);
	}

	@Test
	public void testCloneSavedWithoutLocalizedMap()
	{
		/* 1) Create a custom attribute against the Title type */
		inheritedAttributeDescriptorModel = createAttribute();

		/* 2) Create a new custom type based on the Title type */
		customType = createCustomType(Locale.ENGLISH);

		customModel = modelService.create(customType.getCode());
		customModel.setCode(CUSTOM_SHORT_CODE);

		final Locale saveLocale = i18nService.getCurrentLocale();
		i18nService.setCurrentLocale(Locale.ENGLISH);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, INHERITED_ATTRIBUTE_VALUE_EN);
		i18nService.setCurrentLocale(Locale.GERMAN);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, INHERITED_ATTRIBUTE_VALUE_DE);
		i18nService.setCurrentLocale(saveLocale);

		modelService.save(customModel);

		/* clone */
		final TitleModel clonedCustomModel = (TitleModel) itemModelCloneCreator.copy(customModel);

		assertNotSame("The custom model and its clone should not refer to the same object",
		              customModel, clonedCustomModel);

		assertEquals("The code of the custom model and its clone should be equal",
		             customModel.getCode(), clonedCustomModel.getCode());

		validateClonedProperty(clonedCustomModel, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.ENGLISH, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.GERMAN, customModel);
	}

	/**
	 * Test case for CXEC-41175
	 */
	@Test
	public void testCloneSavedWithNullAsAttributeValue()
	{
		/* 1) Create a custom attribute against the Title type */
		inheritedAttributeDescriptorModel = createAttribute();

		/* 2) Create a new custom type based on the Title type */
		customType = createCustomType(Locale.ENGLISH);

		customModel = modelService.create(customType.getCode());
		customModel.setCode(CUSTOM_SHORT_CODE);

		final Locale saveLocale = i18nService.getCurrentLocale();
		i18nService.setCurrentLocale(Locale.ENGLISH);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, null);
		i18nService.setCurrentLocale(Locale.GERMAN);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, null);
		i18nService.setCurrentLocale(saveLocale);

		modelService.save(customModel);

		/* clone */
		final TitleModel clonedCustomModel = (TitleModel) itemModelCloneCreator.copy(customModel);

		assertNotSame("The custom model and its clone should not refer to the same object",
				customModel, clonedCustomModel);

		assertEquals("The code of the custom model and its clone should be equal",
				customModel.getCode(), clonedCustomModel.getCode());

		Object sourceProperty = modelService.getAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE);
		Object clonedProperty = modelService.getAttributeValue(clonedCustomModel, INHERITED_ATTRIBUTE_SHORT_CODE);
		assertThat(sourceProperty).isNull();
		assertThat(clonedProperty).isNull();

	}

	/**
	 * Test case for CXEC-41175 where map of <Locale,Object> is empty
	 */
	@Test
	public void testCloneSavedWithEmptyLocalizedMap()
	{
		/* 1) Create a custom attribute against the Title type */
		inheritedAttributeDescriptorModel = createAttribute();

		/* 2) Create a new custom type based on the Title type */
		customType = createCustomType(Locale.ENGLISH);

		customModel = modelService.create(customType.getCode());
		customModel.setCode(CUSTOM_SHORT_CODE);
		Map<Locale, Object> emptyMap = Map.of();
		Assert.assertThrows(IllegalArgumentException.class,
				() -> modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, emptyMap));
	}

	@Test
	public void testCloneNotSavedWithoutLocalizedMap()
	{
		/* 1) Create a custom attribute against the Title type */
		inheritedAttributeDescriptorModel = createAttribute();

		/* 2) Create a new custom type based on the Title type */
		customType = createCustomType(Locale.ENGLISH);

		customModel = modelService.create(customType.getCode());
		customModel.setCode(CUSTOM_SHORT_CODE);

		final Locale saveLocale = i18nService.getCurrentLocale();
		i18nService.setCurrentLocale(Locale.ENGLISH);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, INHERITED_ATTRIBUTE_VALUE_EN);
		i18nService.setCurrentLocale(Locale.GERMAN);
		modelService.setAttributeValue(customModel, INHERITED_ATTRIBUTE_SHORT_CODE, INHERITED_ATTRIBUTE_VALUE_DE);
		i18nService.setCurrentLocale(saveLocale);

		/* clone */
		final TitleModel clonedCustomModel = (TitleModel) itemModelCloneCreator.copy(customModel);

		assertNotSame("The custom model and its clone should not refer to the same object",
		              customModel, clonedCustomModel);

		assertEquals("The code of the custom model and its clone should be equal",
		             customModel.getCode(), clonedCustomModel.getCode());

		validateClonedProperty(clonedCustomModel, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.ENGLISH, customModel);
		validateClonedLocalizedProperty(clonedCustomModel, Locale.GERMAN, customModel);
		modelService.save(customModel);
	}


	private void deleteAttribute(final ComposedTypeModel enclosingType)
	{
		Optional.ofNullable(enclosingType).ifPresent(composedTypeModel -> {
			final AttributeDescriptorModel attributeDescriptorModel =
					typeService.getAttributeDescriptor(composedTypeModel,
					                                   INHERITED_ATTRIBUTE_SHORT_CODE);
			modelService.remove(attributeDescriptorModel);
		});
	}
	
	private AttributeDescriptorModel createAttribute()
	{
		final ComposedTypeModel enclosingType = typeService.getComposedTypeForCode(TITLE_TYPE_CODE);

		final AttributeDescriptorModel attributeDescriptorModel = modelService.create(AttributeDescriptorModel.class);
		attributeDescriptorModel.setQualifier(INHERITED_ATTRIBUTE_SHORT_CODE);
		attributeDescriptorModel.setGenerate(Boolean.FALSE);
		attributeDescriptorModel.setPartOf(Boolean.TRUE);
		attributeDescriptorModel.setName(INHERITED_ATTRIBUTE_NAME, Locale.ENGLISH);
		attributeDescriptorModel.setDescription(INHERITED_ATTRIBUTE_DESCRIPTION, Locale.ENGLISH);
		attributeDescriptorModel.setOptional(Boolean.TRUE);
		attributeDescriptorModel.setEncrypted(Boolean.FALSE);
		attributeDescriptorModel.setEnclosingType(enclosingType);
		attributeDescriptorModel.setSearch(Boolean.FALSE);
		attributeDescriptorModel.setAttributeType(typeService.getTypeForCode(LOCALIZED_STRING_TYPE_CODE));

		modelService.save(attributeDescriptorModel);
		modelService.refresh(enclosingType);

		return attributeDescriptorModel;
	}

	public ComposedTypeModel createCustomType(final Locale locale)
	{

		final ComposedTypeModel parentTypeModel = typeService.getComposedTypeForCode(TITLE_TYPE_CODE);
		final ComposedTypeModel composedTypeModel = modelService.create(parentTypeModel.getClass());
		composedTypeModel.setSuperType(parentTypeModel);
		composedTypeModel.setCode(TYPE_SHORT_CODE);
		composedTypeModel.setName(TYPE_NAME, locale);
		composedTypeModel.setDescription(TYPE_DESCRIPTION, locale);
		composedTypeModel.setGenerate(Boolean.FALSE);
		composedTypeModel.setAutocreate(Boolean.FALSE);
		composedTypeModel.setSingleton(parentTypeModel.getSingleton());
		composedTypeModel.setCatalogItemType(Boolean.FALSE);

		modelService.save(composedTypeModel);

		return composedTypeModel;
	}

	private void validateClonedLocalizedProperty(final TitleModel clonedModel, final Locale locale,
	                                             final TitleModel sourceModel)
	{
		final Object sourceProperty = modelService.getAttributeValue(sourceModel, INHERITED_ATTRIBUTE_SHORT_CODE, locale);
		final Object clonedProperty = modelService.getAttributeValue(clonedModel, INHERITED_ATTRIBUTE_SHORT_CODE, locale);
		assertThat(clonedProperty).isNotNull().isEqualTo(sourceProperty);
	}

	private void validateClonedProperty(final TitleModel clonedModel, final TitleModel sourceModel)
	{
		final Locale saveLocale = i18nService.getCurrentLocale();
		i18nService.setCurrentLocale(Locale.ENGLISH);
		Object sourceProperty = modelService.getAttributeValue(sourceModel, INHERITED_ATTRIBUTE_SHORT_CODE);
		Object clonedProperty = modelService.getAttributeValue(clonedModel, INHERITED_ATTRIBUTE_SHORT_CODE);
		assertThat(clonedProperty).isNotNull().isEqualTo(sourceProperty);

		i18nService.setCurrentLocale(Locale.GERMAN);
		sourceProperty = modelService.getAttributeValue(sourceModel, INHERITED_ATTRIBUTE_SHORT_CODE);
		clonedProperty = modelService.getAttributeValue(clonedModel, INHERITED_ATTRIBUTE_SHORT_CODE);
		assertThat(clonedProperty).isNotNull().isEqualTo(sourceProperty);

		i18nService.setCurrentLocale(saveLocale);
	}
}
