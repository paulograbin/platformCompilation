/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.validation.services.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.validation.localized.LocalizedAttributeConstraint;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceStreamUtilsTest
{

	@Test
	public void shouldGroupConstraintsByAttributeAndLocale()
	{
		//given
		final var remarksConstraint = createConstraintMock(
				ProductModel.REMARKS, Locale.ENGLISH, Locale.GERMAN, Locale.FRENCH);

		final LocalizedAttributeConstraint descriptionSizeConstraint = createConstraintMock(
				ProductModel.DESCRIPTION, Locale.ENGLISH);
		final LocalizedAttributeConstraint descriptionNotNullConstraint = createConstraintMock(
				ProductModel.DESCRIPTION, Locale.ITALIAN);
		final LocalizedAttributeConstraint descriptionNotBlankConstraint = createConstraintMock(
				ProductModel.DESCRIPTION, Locale.FRENCH);

		final LocalizedAttributeConstraint nameSizeConstraint = createConstraintMock(
				ProductModel.NAME, Locale.ENGLISH, Locale.GERMAN);
		final LocalizedAttributeConstraint nameNotNullConstraint = createConstraintMock(
				ProductModel.NAME, Locale.ITALIAN, Locale.FRENCH, Locale.JAPANESE);
		final LocalizedAttributeConstraint nameNotBlankConstraint = createConstraintMock(
				ProductModel.NAME, Locale.FRENCH, Locale.GERMAN, Locale.KOREAN, Locale.ENGLISH);


		final Set<LocalizedAttributeConstraint> localizedConstraints = Set.of(
				remarksConstraint,
				descriptionSizeConstraint, descriptionNotNullConstraint, descriptionNotBlankConstraint,
				nameSizeConstraint, nameNotNullConstraint, nameNotBlankConstraint);

		//when
		final Set<AttributeLocaleConstraints> actual = ValidationServiceStreamUtils.groupByAttributeAndLocale(localizedConstraints);

		//then
		assertThat(actual).hasSize(3);

		assertRemarksConstraints(actual, remarksConstraint);
		assertDescriptionConstraints(actual, descriptionSizeConstraint, descriptionNotNullConstraint, descriptionNotBlankConstraint);
		assertNameConstraints(actual, nameSizeConstraint, nameNotNullConstraint, nameNotBlankConstraint);

	}

	private static void assertRemarksConstraints(final Set<AttributeLocaleConstraints> actual, final LocalizedAttributeConstraint constraint)
	{
		final AttributeLocaleConstraints attributeLocaleConstraints = assertConstraintForAttributeExists(actual, ProductModel.REMARKS);

		assertThat(attributeLocaleConstraints.getLocaleConstraints()).hasSize(3);
		assertThat(attributeLocaleConstraints.getLocales()).contains(Locale.ENGLISH, Locale.GERMAN, Locale.FRENCH);

		assertThat(attributeLocaleConstraints.getConstraintsForLocale(Locale.ENGLISH)).hasSize(1);
		assertThat(attributeLocaleConstraints.getConstraintsForLocale(Locale.GERMAN)).hasSize(1);
		assertThat(attributeLocaleConstraints.getConstraintsForLocale(Locale.FRENCH)).hasSize(1);

		attributeLocaleConstraints.getLocaleConstraints()
				.forEach(localeConstraints -> assertContains(localeConstraints.getConstraints(), constraint));
	}

	private void assertNameConstraints(final Set<AttributeLocaleConstraints> actual,
			final LocalizedAttributeConstraint sizeConstraint, final LocalizedAttributeConstraint notNullConstraint,
			final LocalizedAttributeConstraint notBlankConstraint)
	{
		final AttributeLocaleConstraints attributeLocaleConstraints = assertConstraintForAttributeExists(actual, ProductModel.NAME);

		assertThat(attributeLocaleConstraints.getLocaleConstraints()).hasSize(6);
		assertThat(attributeLocaleConstraints.getLocales()).contains(Locale.ENGLISH, Locale.GERMAN, Locale.FRENCH, Locale.ITALIAN,
				Locale.KOREAN, Locale.JAPANESE);

		final Set<LocalizedAttributeConstraint> englishConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.ENGLISH);
		final Set<LocalizedAttributeConstraint> germanConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.GERMAN);
		final Set<LocalizedAttributeConstraint> frenchConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.FRENCH);
		final Set<LocalizedAttributeConstraint> italianConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.ITALIAN);
		final Set<LocalizedAttributeConstraint> koreanConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.KOREAN);
		final Set<LocalizedAttributeConstraint> japaneseConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.JAPANESE);

		assertThat(englishConstraints).hasSize(2);
		assertThat(germanConstraints).hasSize(2);
		assertThat(frenchConstraints).hasSize(2);
		assertThat(italianConstraints).hasSize(1);
		assertThat(koreanConstraints).hasSize(1);
		assertThat(japaneseConstraints).hasSize(1);

		assertContains(englishConstraints, sizeConstraint, notBlankConstraint);
		assertContains(germanConstraints, sizeConstraint, notBlankConstraint);
		assertContains(frenchConstraints, notNullConstraint, notBlankConstraint);
		assertContains(italianConstraints, notNullConstraint);
		assertContains(koreanConstraints, notBlankConstraint);
		assertContains(japaneseConstraints, notNullConstraint);
	}

	private void assertDescriptionConstraints(final Set<AttributeLocaleConstraints> actual,
			final LocalizedAttributeConstraint sizeConstraint,
			final LocalizedAttributeConstraint notNullConstraint,
			final LocalizedAttributeConstraint notBlankConstraint)
	{
		final AttributeLocaleConstraints attributeLocaleConstraints = assertConstraintForAttributeExists(actual, ProductModel.DESCRIPTION);

		assertThat(attributeLocaleConstraints.getLocaleConstraints()).hasSize(3);
		assertThat(attributeLocaleConstraints.getLocales()).contains(Locale.ENGLISH, Locale.ITALIAN, Locale.FRENCH);

		final Set<LocalizedAttributeConstraint> englishConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.ENGLISH);
		final Set<LocalizedAttributeConstraint> italianConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.ITALIAN);
		final Set<LocalizedAttributeConstraint> frenchConstraints = attributeLocaleConstraints.getConstraintsForLocale(Locale.FRENCH);

		assertThat(englishConstraints).hasSize(1);
		assertThat(italianConstraints).hasSize(1);
		assertThat(frenchConstraints).hasSize(1);

		assertContains(englishConstraints, sizeConstraint);
		assertContains(italianConstraints, notNullConstraint);
		assertContains(frenchConstraints, notBlankConstraint);
	}

	private static void assertContains(final Set<LocalizedAttributeConstraint> actual, final LocalizedAttributeConstraint... constraints)
	{
		final Set<String> actualPKs = actual.stream().map(constraint -> constraint.getPK().toString()).collect(Collectors.toSet());
		final String[] expectedPKs = Arrays.stream(constraints).map(constraint -> constraint.getPK().toString()).toArray(String[]::new);
		assertThat(actualPKs).contains(expectedPKs);
	}

	private static AttributeLocaleConstraints assertConstraintForAttributeExists(final Set<AttributeLocaleConstraints> actual, final String name)
	{
		final Optional<AttributeLocaleConstraints> constraintsOptional = actual.stream()
				.filter(v -> v.getAttribute().equals(name))
				.findFirst();
		assertThat(constraintsOptional).isPresent();
		return constraintsOptional.get();
	}

	private static LocalizedAttributeConstraint createConstraintMock(final String attribute, final Locale... languages)
	{
		final LocalizedAttributeConstraint constraint = mock(LocalizedAttributeConstraint.class);

		final var mkMock = mock(PK.class);
		when(mkMock.toString()).thenReturn(attribute + "_" + Arrays.stream(languages).map(Locale::toLanguageTag).collect(Collectors.joining("_")));
		when(constraint.getPK()).thenReturn(mkMock);

		when(constraint.getAttribute()).thenReturn(attribute);

		when(constraint.getLanguages()).thenReturn(List.of(languages));

		return constraint;
	}

}
