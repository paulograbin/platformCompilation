/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.validation.services.impl;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.enums.ArticleStatus;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.CompanyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.daos.LanguageDao;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.validation.enums.Severity;
import de.hybris.platform.validation.exceptions.HybrisConstraintViolation;
import de.hybris.platform.validation.model.constraints.AbstractConstraintModel;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;
import de.hybris.platform.validation.model.constraints.ConstraintGroupModel;
import de.hybris.platform.validation.model.constraints.NotBlankConstraintModel;
import de.hybris.platform.validation.model.constraints.jsr303.AbstractConstraintTest;
import de.hybris.platform.validation.model.constraints.jsr303.NotNullConstraintModel;
import de.hybris.platform.validation.model.constraints.jsr303.SizeConstraintModel;
import de.hybris.platform.validation.payloads.language.Language;
import de.hybris.platform.validation.services.ConstraintService;
import de.hybris.platform.validation.services.LanguagePayloadService;
import de.hybris.platform.validation.services.ValidationService;
import de.hybris.platform.variants.model.VariantProductModel;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.Payload;
import javax.validation.metadata.ConstraintDescriptor;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


@IntegrationTest
public class LocalizationAwareValidationServiceTest extends AbstractConstraintTest
{
	private static final String NAME_LENGTH_15 = "123456789_12345";
	private static final String NAME_LENGTH_30 = "123456789_123456789_1234567890";

	@Resource
	private LanguageDao languageDao;

	@Resource
	private ValidationService validationService;

	@Resource
	private ConstraintService constraintService;

	@Resource
	private ModelService modelService;

	@Resource
	private TypeService typeService;

	@Resource
	private CommonI18NService commonI18NService;

	@Resource
	private LanguagePayloadService languagePayloadService;

	private Collection<ConstraintGroupModel> groups;
	private CatalogModel catalog;
	private CatalogVersionModel catalogVersion;

	@Before
	public void doBefore()
	{
		getOrCreateLanguage("en");
		getOrCreateLanguage("de");
		getOrCreateLanguage("fr");
		getOrCreateLanguage("ja");
		getOrCreateLanguage("ko");
		getOrCreateLanguage("it");
		getOrCreateLanguage("es_CO");

		catalog = modelService.create(CatalogModel.class);
		catalog.setId("defaultCatalog");
		catalog.setName("defaultCatalog");

		catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setVersion("versionOne");
		catalogVersion.setCatalog(catalog);

		groups = validationService.getActiveConstraintGroups();
	}

	@After
	public void doAfter()
	{
		final List<AbstractConstraintModel> allConstraints = constraintService.getAllConstraints();
		allConstraints.forEach(c -> modelService.remove(c));
		Preconditions.checkArgument(CollectionUtils.isEmpty(constraintService.getAllConstraints()),
				"Failed to clean test constraints");

		validationService.reloadValidationEngine();
	}

	private LanguageModel getEnglish()
	{
		return languageDao.findLanguagesByCode("en").get(0);
	}

	private LanguageModel getFrench()
	{
		return languageDao.findLanguagesByCode("fr").get(0);
	}

	private LanguageModel getGerman()
	{
		return languageDao.findLanguagesByCode("de").get(0);
	}

	private LanguageModel getJapanese()
	{
		return languageDao.findLanguagesByCode("ja").get(0);
	}

	private LanguageModel getKorean()
	{
		return languageDao.findLanguagesByCode("ko").get(0);
	}

	private LanguageModel getItalian()
	{
		return languageDao.findLanguagesByCode("it").get(0);
	}

	private LanguageModel getColumbiaSpanish()
	{
		return languageDao.findLanguagesByCode("es_CO").get(0);
	}

	private NotNullConstraintModel createNotNullConstraint(final String attribute, final Severity severity, final Set<LanguageModel> languages)
	{
		final ComposedTypeModel productType = typeService.getComposedTypeForClass(ProductModel.class);
		final AttributeDescriptorModel attributeDescriptor = typeService.getAttributeDescriptor(productType, attribute);

		final NotNullConstraintModel constraint = modelService.create(NotNullConstraintModel.class);
		constraint.setId(UUID.randomUUID().toString());
		constraint.setDescriptor(attributeDescriptor);
		constraint.setLanguages(languages);
		constraint.setSeverity(severity);

		modelService.save(constraint);
		return constraint;
	}

	private NotBlankConstraintModel createNotBlank(final String attribute, final Severity severity, final Set<LanguageModel> languages)
	{
		return createNotBlank(attribute, severity, languages, null);
	}

	private NotBlankConstraintModel createNotBlank(final String attribute, final Severity severity, final Set<LanguageModel> languages,
	                            final Set<ConstraintGroupModel> groups)
	{
		final ComposedTypeModel productType = typeService.getComposedTypeForClass(ProductModel.class);
		final AttributeDescriptorModel attributeDescriptor = typeService.getAttributeDescriptor(productType, attribute);

		final NotBlankConstraintModel constraint = modelService.create(NotBlankConstraintModel.class);
		constraint.setId(UUID.randomUUID().toString());
		constraint.setDescriptor(attributeDescriptor);
		constraint.setLanguages(languages);
		constraint.setSeverity(severity);

		if (groups != null)
		{
			constraint.setConstraintGroups(groups);
		}

		modelService.save(constraint);
		return constraint;
	}

	private SizeConstraintModel createConstraintSizeBetween5And10(final Class clazz, final String attribute, final Severity severity,
	                                               final Set<LanguageModel> languages)
	{
		return createConstraintSize(clazz, attribute, severity, languages, 5, 10, null);
	}

	private void createConstraintSizeBetween5And10(final Class clazz, final String attribute, final Severity severity,
	                                               final Set<LanguageModel> languages, final Set<ConstraintGroupModel> groups)
	{
		createConstraintSize(clazz, attribute, severity, languages, 5, 10, groups);
	}

	private SizeConstraintModel createSizeConstraintOnProductName(final long min, final long max, final LanguageModel... languages)
	{
		return createConstraintSize(ProductModel.class, ProductModel.NAME, Severity.ERROR, Set.of(languages), min, max, null);
	}

	private SizeConstraintModel createConstraintSize(final Class clazz, final String attribute, final Severity severity,
			final Set<LanguageModel> languages, final long min, final long max, final Set<ConstraintGroupModel> groups)
	{
		final ComposedTypeModel productType = typeService.getComposedTypeForClass(clazz);
		final AttributeDescriptorModel attributeDescriptor = typeService.getAttributeDescriptor(productType, attribute);
		final SizeConstraintModel constraint = modelService.create(SizeConstraintModel.class);
		constraint.setId(UUID.randomUUID().toString());
		constraint.setMin(min);
		constraint.setMax(max);
		constraint.setDescriptor(attributeDescriptor);
		constraint.setLanguages(languages);
		constraint.setSeverity(severity);
		if (groups != null)
		{
			constraint.setConstraintGroups(groups);
		}

		modelService.save(constraint);
		return constraint;
	}

	private ProductModel createBlankProduct()
	{
		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode("a");
		product.setCatalogVersion(catalogVersion);

		return product;
	}

	private VariantProductModel createBlankVariantProduct()
	{
		final VariantProductModel product = modelService.create(VariantProductModel.class);
		product.setCode("varA");
		product.setCatalogVersion(catalogVersion);

		return product;
	}


	@Test
	public void emptyValueShouldNotTriggerViolation()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(0);
	}

	@Test
	public void shouldConvertLanguageToLocaleWithCapitalizedLetters()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getColumbiaSpanish()));
		validationService.reloadValidationEngine();
		final Locale columbianLocale = commonI18NService.getLocaleForLanguage(getColumbiaSpanish());

		final ProductModel product = createBlankProduct();
		product.setName("plata o plomo", columbianLocale);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(1);
		assertThat(violations.iterator().next()).isInstanceOf(LocalizedHybrisConstraintViolation.class);
		final LocalizedHybrisConstraintViolation violation = (LocalizedHybrisConstraintViolation) violations.iterator().next();

		assertThat(violation.getViolationLanguage()).isEqualTo(columbianLocale);
	}

	@Test
	public void tooShortValueOnlyInEnglishShouldViolate()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("ap", Locale.ENGLISH);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(1);
	}

	@Test
	public void okValueOnlyInEnglishShouldNotViolate()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("apple", Locale.ENGLISH);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(0);
	}

	@Test
	public void okValueInEnglishAndGermanShouldNotViolate()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("apple", Locale.ENGLISH);
		product.setName("apfel", Locale.GERMAN);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(0);
	}

	@Test
	public void invalidGermanValueShouldViolate()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("apple", Locale.ENGLISH);
		product.setName("ap", Locale.GERMAN);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(1);

		final HybrisConstraintViolation violation = violations.iterator().next();
		assertThat(violation).isInstanceOf(LocalizedHybrisConstraintViolation.class);
		assertThat(((LocalizedHybrisConstraintViolation) violation).getViolationLanguage()).isEqualTo(Locale.GERMAN);
	}

	@Test
	public void invalidValuesInEnglishAndGermansShouldViolateTwice()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("ap", Locale.ENGLISH);
		product.setName("ap", Locale.GERMAN);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(2);
	}

	@Test
	public void invalidValuesInEnglishAndGermansForSubtypeShouldViolateTwice()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		// VariantProductModel is a subtype of ProductModel
		final VariantProductModel product = createBlankVariantProduct();
		product.setName("ap", Locale.ENGLISH);
		product.setName("ap", Locale.GERMAN);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(2);
	}


	@Test
	public void validValuesForDifferentConstraintsShouldPass()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.DESCRIPTION, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getFrench()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("apple", Locale.ENGLISH);
		product.setName("apfel", Locale.GERMAN);

		product.setDescription("apple", Locale.GERMAN);
		product.setDescription("pomme", Locale.FRANCE);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);

		// then
		assertThat(violations).hasSize(0);
	}

	@Test
	public void invalidValuesForDifferentConstraintsShouldViolate()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.DESCRIPTION, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getFrench()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("ap", Locale.ENGLISH);
		product.setName("ap", Locale.GERMAN);

		// german is not validated by constraint
		product.setDescription("ap", Locale.GERMAN);
		product.setDescription("po", Locale.FRANCE);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product, groups);
		final Set<HybrisConstraintViolation> nameViolations = validationService.validateProperty(product, "name", groups);
		final Set<HybrisConstraintViolation> descriptionViolations = validationService.validateProperty(product, "description",
				groups);

		// then
		assertThat(violations).hasSize(3);

		for (final HybrisConstraintViolation v : violations)
		{
			assertThat(v).isInstanceOf(LocalizedHybrisConstraintViolation.class);
		}

		assertThat(nameViolations).hasSize(2);
		assertThat(descriptionViolations).hasSize(1);
	}


	@Test
	public void shouldViolateTwoConstraintsOnSameAttribute()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
		createNotNullConstraint(ProductModel.NAME, Severity.ERROR, ImmutableSet.of(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("apple", Locale.ENGLISH);

		// when
		final Set<HybrisConstraintViolation> notNullViolations = validationService.validate(product);

		// then
		assertThat(notNullViolations).hasSize(1);
		assertViolationLocale(notNullViolations.iterator().next(), Locale.GERMAN);

		// and when
		product.setName("apf", Locale.GERMAN);
		final Set<HybrisConstraintViolation> sizeViolations = validationService.validate(product);

		// then
		assertThat(sizeViolations).hasSize(1);
		assertViolationLocale(sizeViolations.iterator().next(), Locale.GERMAN);

		product.setName("apfel", Locale.GERMAN);

		final Set<HybrisConstraintViolation> ok = validationService.validate(product);

		assertThat(ok).hasSize(0);
	}

	@Test(expected = ModelSavingException.class)
	public void disallowCreatingLocalizedConstraintOnNonLocalizableAttribute()
	{
		// CompanyModel.NAME is non-localizable
		createConstraintSizeBetween5And10(CompanyModel.class, CompanyModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
	}

	@Test
	public void allowCreatingLocalizedConstraintOnLocalizableAttribute()
	{
		// CompanyModel.LOCNAME is localizable
		createConstraintSizeBetween5And10(CompanyModel.class, CompanyModel.LOCNAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getGerman()));
	}

	@Test
	public void violationsShouldMatchConstraintsLocales()
	{
		// given
		createConstraintSizeBetween5And10(ProductModel.class, ProductModel.NAME, Severity.ERROR, ImmutableSet.of(getEnglish()));
		createNotBlank(ProductModel.NAME, Severity.WARN, ImmutableSet.of(getGerman()));

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("", Locale.ENGLISH);
		product.setName("", Locale.GERMAN);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validateProperty(product, "name");

		final LocalizedHybrisConstraintViolation enViolation = (LocalizedHybrisConstraintViolation) violations.stream()
		                                                                                                      .filter(i -> isSizeConstraint(
				                                                                                                      i))
		                                                                                                      .findFirst()
		                                                                                                      .get();
		final LocalizedHybrisConstraintViolation geViolation = (LocalizedHybrisConstraintViolation) violations.stream()
		                                                                                                      .filter(i -> !isSizeConstraint(
				                                                                                                      i))
		                                                                                                      .findFirst()
		                                                                                                      .get();

		assertThat(enViolation.getViolationLanguage()).isEqualTo(Locale.ENGLISH);
		assertThat(geViolation.getViolationLanguage()).isEqualTo(Locale.GERMAN);
	}


	private ConstraintGroupModel createConstraintGroup(final String id, final String interfaceName)
	{
		final ConstraintGroupModel newGroup = modelService.create(ConstraintGroupModel.class);
		newGroup.setId(id);
		newGroup.setInterfaceName(interfaceName);
		modelService.save(newGroup);

		return newGroup;
	}

	@Test
	public void shouldValidateGroupConstraints()
	{
		// given
		final ConstraintGroupModel notBlankGroup = createConstraintGroup("blank", "com.blank");
		final ConstraintGroupModel sizeGroup = createConstraintGroup("size", "com.size");

		createNotBlank("name", Severity.WARN, ImmutableSet.of(getGerman()), ImmutableSet.of(notBlankGroup));
		createConstraintSizeBetween5And10(ProductModel.class, "name", Severity.WARN, ImmutableSet.of(getFrench()),
				ImmutableSet.of(sizeGroup));

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("", Locale.GERMAN);
		product.setName("a", Locale.FRENCH);

		// when
		final Set<HybrisConstraintViolation> attrDefaultViolations = validationService.validateProperty(product, "name");
		final Set<HybrisConstraintViolation> attrNotBlankGroupViolations = validationService.validateProperty(product, "name",
				ImmutableSet.of(
						notBlankGroup));
		final Set<HybrisConstraintViolation> attrSizeGroupViolations = validationService.validateProperty(product, "name",
				ImmutableSet.of(
						sizeGroup));
		final Set<HybrisConstraintViolation> attrAllGroupsViolations = validationService.validateProperty(product, "name",
				ImmutableSet.of(
						sizeGroup,
						notBlankGroup));

		final Set<HybrisConstraintViolation> objDefaultViolations = validationService.validate(product);
		final Set<HybrisConstraintViolation> objNotBlankGroupViolations = validationService.validate(product,
				ImmutableSet.of(
						notBlankGroup));
		final Set<HybrisConstraintViolation> objSizeGroupViolations = validationService.validate(product,
				ImmutableSet.of(sizeGroup));
		final Set<HybrisConstraintViolation> objAllGroupsViolations = validationService.validate(product,
				ImmutableSet.of(sizeGroup,
						notBlankGroup));

		// then
		assertThat(attrDefaultViolations).isEmpty();
		assertThat(objDefaultViolations).isEmpty();

		assertNotBlankGroupViolations(attrNotBlankGroupViolations);
		assertNotBlankGroupViolations(objNotBlankGroupViolations);

		assertSizeGroupViolations(attrSizeGroupViolations);
		assertSizeGroupViolations(objSizeGroupViolations);

		assertThat(attrAllGroupsViolations).hasSize(2);
		assertThat(objAllGroupsViolations).hasSize(2);
	}

	@Test
	public void shouldTriggerDefaultGroupInLocalizedValidations()
	{
		// given
		final ConstraintGroupModel defaultGroup = validationService.getDefaultConstraintGroup();
		final ConstraintGroupModel fooGroup = createConstraintGroup("fooGroup", "com.foo");

		createNotBlank("name", Severity.WARN, ImmutableSet.of(getGerman()));
		final ProductModel product = createBlankProduct();
		product.setName("", Locale.GERMAN);
		product.setName("a", Locale.FRENCH);

		validationService.reloadValidationEngine();

		// when
		final Set<HybrisConstraintViolation> implicitDefaultViolations = validationService.validate(product);
		final Set<HybrisConstraintViolation> singleDefaultViolations = validationService.validate(product,
				ImmutableSet.of(defaultGroup));
		final Set<HybrisConstraintViolation> defaultAmongstManyViolations = validationService.validate(product,
				ImmutableSet.of(
						defaultGroup,
						fooGroup));
		final Set<HybrisConstraintViolation> noDefaultViolations = validationService.validate(product, ImmutableSet.of(fooGroup));

		// then
		isNotBlankConstraint(implicitDefaultViolations.iterator().next());
		isNotBlankConstraint(singleDefaultViolations.iterator().next());
		isNotBlankConstraint(defaultAmongstManyViolations.iterator().next());
		assertThat(noDefaultViolations).isEmpty();
	}

	@Test
	public void shouldThrowValidationErrorWhenValidatingLocalizableAttributeReturningNotString()
	{
		createNotNullConstraint(ProductModel.ARTICLESTATUS, Severity.ERROR, Sets.newHashSet(getEnglish(), getGerman()));
		validationService.reloadValidationEngine();

		final ProductModel blankProduct = createBlankProduct();
		blankProduct.setArticleStatus(Map.of(ArticleStatus.CORE_ARTICLE, "blah"), Locale.ENGLISH);

		final Set<HybrisConstraintViolation> validate = validationService.validate(blankProduct);

		assertThat(validate).hasSize(1);
		final HybrisConstraintViolation violation = validate.iterator().next();
		assertThat(violation).isInstanceOf(LocalizedHybrisConstraintViolation.class)
		                     .extracting(c -> ((LocalizedHybrisConstraintViolation) c).getViolationLanguage(),
				                     HybrisConstraintViolation::getProperty, HybrisConstraintViolation::getTypeName)
		                     .containsExactly(Locale.GERMAN, ProductModel.ARTICLESTATUS, ProductModel._TYPECODE);
	}

	@Test
	public void shouldViolateInvalidValueForMatchingConstraintLanguage()
	{
		//given
		final SizeConstraintModel givenConstraint = createSizeConstraintOnProductName(0L, 20L, getEnglish(), getGerman());

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName(NAME_LENGTH_30, Locale.GERMAN);

		//when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		//then
		assertEquals(1, violations.size());

		final HybrisConstraintViolation hybrisConstraintViolation = violations.iterator().next();
		assertHybrisConstraintViolation(givenConstraint, hybrisConstraintViolation);

		final Set<Class<? extends Payload>> actualPayloads = getPayloads(hybrisConstraintViolation);
		assertLanguagePayloadsArePresent(givenConstraint.getLanguages(), actualPayloads);
	}

	@Test
	public void shouldViolateInvalidValueForMatchingConstraintLanguageWhenMultipleConstraints()
	{
		//given
		createSizeConstraintOnProductName(5L, 20L, getGerman());
		final SizeConstraintModel givenConstraint = createSizeConstraintOnProductName(5L, 10L, getEnglish());

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName(NAME_LENGTH_15, Locale.ENGLISH);
		product.setName(NAME_LENGTH_15, Locale.GERMAN);

		//when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		//then
		assertEquals(1, violations.size());

		final HybrisConstraintViolation hybrisConstraintViolation = violations.iterator().next();
		assertHybrisConstraintViolation(givenConstraint, hybrisConstraintViolation);

		final Set<Class<? extends Payload>> payloads = getPayloads(hybrisConstraintViolation);
		assertLanguagePayloadsArePresent(givenConstraint.getLanguages(), payloads);
	}

	@Test
	public void shouldViolateInvalidValueForMatchingConstraintEvenIfExceededLimitIncludesOtherConstraintLimits()
	{
		//given
		final SizeConstraintModel givenConstraint = createSizeConstraintOnProductName(0L, 20L, getGerman());
		createSizeConstraintOnProductName(0L, 10L, getEnglish());

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName(NAME_LENGTH_30, Locale.GERMAN);

		//when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		//then
		assertEquals(1, violations.size());

		final HybrisConstraintViolation hybrisConstraintViolation = violations.iterator().next();
		assertHybrisConstraintViolation(givenConstraint, hybrisConstraintViolation);

		final Set<Class<? extends Payload>> payloads = getPayloads(hybrisConstraintViolation);
		assertLanguagePayloadsArePresent(givenConstraint.getLanguages(), payloads);
	}

	@Test
	public void shouldViolateInvalidValuesForAllMatchingConstraints()
	{
		//given
		final SizeConstraintModel constraintDE = createSizeConstraintOnProductName(0L, 20L, getGerman());
		final SizeConstraintModel constraintEN = createSizeConstraintOnProductName(0L, 10L, getEnglish());

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName(NAME_LENGTH_30, Locale.ENGLISH);
		product.setName(NAME_LENGTH_30, Locale.GERMAN);

		//when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		//then
		assertEquals(2, violations.size());

		final Map<String, SizeConstraintModel> constraintsMap = Map.of(constraintDE.getId(), constraintDE, constraintEN.getId(), constraintEN);

		violations.forEach(
				violation -> {
					final SizeConstraintModel givenConstraint = constraintsMap.get(violation.getConstraintModel().getId());
					assertHybrisConstraintViolation(givenConstraint, violation);

					final Set<Class<? extends Payload>> payloads = getPayloads(violation);
					assertLanguagePayloadsArePresent(givenConstraint.getLanguages(), payloads);
				});
	}

	@Test
	public void shouldViolateInvalidValueForAllMatchingConstraintsOfMultipleTypes()
	{
		//given
		final SizeConstraintModel sizeConstraint = createSizeConstraintOnProductName(10L, 20L, getEnglish());
		final NotBlankConstraintModel notBlankConstraint = createNotBlank(ProductModel.NAME, Severity.ERROR, Set.of(getEnglish()));

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName(" ", Locale.ENGLISH);

		//when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		//then
		assertThat(violations)
				.hasSize(2)
				.allMatch(violation -> violation instanceof LocalizedHybrisConstraintViolation);

		final Map<String, AttributeConstraintModel> constraintsMap = Map.of(
				sizeConstraint.getId(), sizeConstraint,
				notBlankConstraint.getId(), notBlankConstraint);

		violations.forEach(violation -> {
			final AttributeConstraintModel givenConstraint = constraintsMap.get(violation.getConstraintModel().getId());
			assertHybrisConstraintViolation(givenConstraint, violation);

			final Set<Class<? extends Payload>> payloads = getPayloads(violation);
			assertLanguagePayloadsArePresent(givenConstraint.getLanguages(), payloads);
		});
	}

	@Test
	public void shouldViolateInvalidValueForMatchingLanguagesWhenMultipleLanguagesAndConstraints()
	{
		// given
		final SizeConstraintModel sizeConstraintEnDe = createSizeConstraintOnProductName(5L, 10L, getEnglish(), getGerman());
		final SizeConstraintModel sizeConstraintFrEs = createSizeConstraintOnProductName(5L, 20L, getFrench(), getColumbiaSpanish());

		final NotBlankConstraintModel notBlankConstraintEnFr = createNotBlank(ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getEnglish(), getFrench()));
		final NotBlankConstraintModel notBlankConstraintDeEs = createNotBlank(ProductModel.NAME, Severity.ERROR,
				ImmutableSet.of(getColumbiaSpanish(), getGerman()));


		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("apple", Locale.ENGLISH);
		product.setName(" ", Locale.GERMAN);
		product.setName(" ", Locale.FRENCH);
		product.setName(" ", LocaleUtils.toLocale("es_CO"));

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		// then
		assertThat(violations)
				.hasSize(6)
				.allMatch(violation -> violation instanceof LocalizedHybrisConstraintViolation);

		final Map<String, AttributeConstraintModel> mapOfConstraints = Map.of(sizeConstraintEnDe.getId(), sizeConstraintEnDe,
				sizeConstraintFrEs.getId(), sizeConstraintFrEs, notBlankConstraintEnFr.getId(), notBlankConstraintEnFr,
				notBlankConstraintDeEs.getId(), notBlankConstraintDeEs);

		violations.forEach(violation -> {
			final AttributeConstraintModel givenConstraint = mapOfConstraints.get(violation.getConstraintModel().getId());
			assertHybrisConstraintViolation(givenConstraint, violation);

			final Set<Class<? extends Payload>> actualPayloads = getPayloads(violation);
			assertLanguagePayloadsArePresent(givenConstraint.getLanguages(), actualPayloads);
		});


		final Set<LocalizedHybrisConstraintViolation> sizeViolations = violations.stream()
				.filter(this::isSizeConstraint)
				.map(violation -> (LocalizedHybrisConstraintViolation)violation)
				.collect(Collectors.toSet());

		final Set<LocalizedHybrisConstraintViolation> notBlankViolations = violations.stream()
				.filter(this::isNotBlankConstraint)
				.map(violation -> (LocalizedHybrisConstraintViolation)violation)
				.collect(Collectors.toSet());


		final Set<Locale> expectedViolationLocales = Set.of(Locale.GERMAN, Locale.FRENCH, LocaleUtils.toLocale("es_CO"));
		assertViolationLocales(sizeViolations, expectedViolationLocales);
		assertViolationLocales(notBlankViolations, expectedViolationLocales);
	}

	@Test
	public void shouldViolateInvalidValuesWhenLocalizedConstraintsGroupedByAttributeAndLocale()
	{
		// given
		final NotNullConstraintModel remarksConstraint = createNotNullConstraint(
				ProductModel.REMARKS, Severity.ERROR, Set.of(getEnglish(), getGerman(), getFrench()));

		final SizeConstraintModel descriptionSizeConstraint = createConstraintSizeBetween5And10(ProductModel.class, ProductModel.DESCRIPTION, Severity.ERROR, Set.of(getEnglish()));
		final NotNullConstraintModel descriptionNotNullConstraint = createNotNullConstraint(ProductModel.DESCRIPTION, Severity.ERROR, Set.of(getItalian()));
		final NotBlankConstraintModel descriptionNotBlankConstraint = createNotBlank(ProductModel.DESCRIPTION, Severity.ERROR, Set.of(getFrench()));

		final SizeConstraintModel nameSizeConstraint = createConstraintSizeBetween5And10(ProductModel.class,
				ProductModel.NAME, Severity.ERROR, Set.of(getEnglish(), getGerman()));
		final NotNullConstraintModel nameNotNullConstraint = createNotNullConstraint(ProductModel.NAME, Severity.ERROR,
				Set.of(getItalian(), getFrench(), getJapanese()));
		final NotBlankConstraintModel nameNotBlankConstraint = createNotBlank(ProductModel.NAME, Severity.ERROR,
				Set.of(getFrench(), getGerman(), getKorean(), getEnglish()));

		validationService.reloadValidationEngine();

		final ProductModel product = createBlankProduct();
		product.setName("", Locale.ENGLISH);
		product.setName("", Locale.GERMAN);
		product.setDescription("", Locale.ENGLISH);
		product.setDescription("", Locale.GERMAN);

		// when
		final Set<HybrisConstraintViolation> violations = validationService.validate(product);

		// then
		assertThat(violations)
				.hasSize(15)
				.allMatch(violation -> violation instanceof LocalizedHybrisConstraintViolation);

		final Set<LocalizedHybrisConstraintViolation> localizedViolations = violations.stream()
				.map(LocalizedHybrisConstraintViolation.class::cast).collect(Collectors.toSet());


		assertRemarkViolations(remarksConstraint, localizedViolations);
		assertViolations(ProductModel.DESCRIPTION, 3, localizedViolations,
				Set.of(Locale.ENGLISH, Locale.ITALIAN, Locale.FRENCH),
				Set.of(descriptionSizeConstraint, descriptionNotNullConstraint, descriptionNotBlankConstraint));
		assertViolations(ProductModel.NAME, 9, localizedViolations,
				Set.of(Locale.ENGLISH, Locale.GERMAN, Locale.FRENCH, Locale.ITALIAN, Locale.KOREAN, Locale.JAPANESE),
				Set.of(nameSizeConstraint, nameNotNullConstraint, nameNotBlankConstraint));
	}

	private static void assertRemarkViolations(final NotNullConstraintModel remarksConstraint,
			final Set<LocalizedHybrisConstraintViolation> localizedViolations)
	{
		final Set<LocalizedHybrisConstraintViolation> remarksViolations = localizedViolations.stream()
				.filter(violation -> violation.getProperty().equals(ProductModel.REMARKS))
				.collect(Collectors.toSet());

		assertThat(remarksViolations).hasSize(3);
		final Set<Locale> violationLanguages = remarksViolations.stream().map(LocalizedHybrisConstraintViolation::getViolationLanguage)
				.collect(Collectors.toSet());
		assertThat(violationLanguages).contains(Locale.ENGLISH, Locale.GERMAN, Locale.FRENCH);

		final Set<String> violationPKs = remarksViolations.stream().map(violation -> violation.getConstraintModel().getId())
				.collect(Collectors.toSet());
		assertThat(violationPKs)
				.hasSize(1)
				.contains(remarksConstraint.getId());
	}

	private static void assertViolations(final String attribute, final int expectedNumberOfViolations,
			final Set<LocalizedHybrisConstraintViolation> localizedViolations,
			final Set<Locale> constraintLanguages, final Set<AttributeConstraintModel> constraints)
	{
		final Set<LocalizedHybrisConstraintViolation> violations = localizedViolations.stream()
				.filter(violation -> violation.getProperty().equals(attribute)).collect(Collectors.toSet());

		assertThat(violations).hasSize(expectedNumberOfViolations);
		final Set<Locale> violationLanguages = violations.stream()
				.map(LocalizedHybrisConstraintViolation::getViolationLanguage).collect(Collectors.toSet());
		assertThat(violationLanguages).containsAll(constraintLanguages);

		final Set<String> violationConstraintPKs = violations.stream().map(violation -> violation.getConstraintModel().getId())
				.collect(Collectors.toSet());
		final Set<String> constraintPKs = constraints.stream().map(AttributeConstraintModel::getId).collect(Collectors.toSet());
		assertThat(violationConstraintPKs).hasSize(constraints.size()).containsAll(constraintPKs);
	}

	private void assertNotBlankGroupViolations(final Set<HybrisConstraintViolation> violations)
	{
		assertThat(violations).hasSize(1);
		isNotBlankConstraint(violations.iterator().next());
	}

	private void assertSizeGroupViolations(final Set<HybrisConstraintViolation> violations)
	{
		assertThat(violations).hasSize(1);
		isSizeConstraint(violations.iterator().next());
	}

	private boolean isSizeConstraint(final HybrisConstraintViolation firstViolation)
	{
		return firstViolation.getConstraintViolation().getConstraintDescriptor().getAnnotation().annotationType().getName()
		                     .contains("Size");
	}

	private boolean isNotBlankConstraint(final HybrisConstraintViolation firstViolation)
	{
		return firstViolation.getConstraintViolation().getConstraintDescriptor().getAnnotation().annotationType().getName()
		                     .contains("NotBlank");
	}

	private void assertViolationLocale(final HybrisConstraintViolation violation, final Locale locale)
	{
		assertThat(violation).isInstanceOf(LocalizedHybrisConstraintViolation.class);
		assertThat(((LocalizedHybrisConstraintViolation) violation).getViolationLanguage()).isEqualTo(locale);
	}

	private static void assertHybrisConstraintViolation(final AttributeConstraintModel givenConstraint,
			final HybrisConstraintViolation hybrisConstraintViolation)
	{
		final String actualQualifier = hybrisConstraintViolation.getQualifier();
		final String actualConstraintModelId = hybrisConstraintViolation.getConstraintModel().getId();
		final Class<? extends Annotation> actualAnnotationType = hybrisConstraintViolation.getConstraintViolation()
				.getConstraintDescriptor()
				.getAnnotation()
				.annotationType();

		assertEquals(ProductModel._TYPECODE + "." + ProductModel.NAME, actualQualifier);
		assertEquals(givenConstraint.getId(), actualConstraintModelId);
		assertEquals(givenConstraint.getAnnotation(), actualAnnotationType);
	}

	private static void assertViolationLocales(final Set<LocalizedHybrisConstraintViolation> violations, Set<Locale> expected)
	{
		final Set<Locale> violationsLocales = violations.stream().map(LocalizedHybrisConstraintViolation::getViolationLanguage)
				.collect(Collectors.toSet());

		assertThat(violationsLocales).hasSize(expected.size());
		assertTrue(violationsLocales.containsAll(expected));
	}

	private void assertLanguagePayloadsArePresent(final Set<LanguageModel> expectedLanguages,
			final Set<Class<? extends Payload>> actualPayloads)
	{
		expectedLanguages.forEach(expectedLanguage -> assertLanguageIsPresent(expectedLanguage, actualPayloads));
	}

	private void assertLanguageIsPresent(final LanguageModel expectedLanguage, final Set<Class<? extends Payload>> actualPayload)
	{
		final Set<Class<? extends Language>> actualLocales = actualPayload.stream()
				.filter(Language.class::isAssignableFrom)
				.map(asLanguage())
				.filter(language -> languagePayloadService.extractLanguagePk(language).equalsIgnoreCase(expectedLanguage.getPk().toString()))
				.collect(Collectors.toSet());

		assertEquals(1, actualLocales.size());
	}

	private static Function<Class<? extends Payload>, Class<? extends Language>> asLanguage()
	{
		return payload -> payload.asSubclass(Language.class);
	}

	private static Set<Class<? extends Payload>> getPayloads(final HybrisConstraintViolation hybrisConstraintViolation)
	{
		final ConstraintDescriptor<?> constraintDescriptor = hybrisConstraintViolation.getConstraintViolation()
				.getConstraintDescriptor();
		return constraintDescriptor.getPayload();
	}

}
