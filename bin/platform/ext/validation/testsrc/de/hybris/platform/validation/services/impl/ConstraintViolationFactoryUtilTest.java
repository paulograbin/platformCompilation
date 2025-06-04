/*
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.validation.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.type.impl.DefaultTypeService;
import de.hybris.platform.validation.enums.Severity;
import de.hybris.platform.validation.messages.ResourceBundleProvider;
import de.hybris.platform.validation.model.constraints.AbstractConstraintModel;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;
import de.hybris.platform.validation.payloads.Error;
import de.hybris.platform.validation.payloads.language.LanguageTest;
import de.hybris.platform.validation.services.InterfaceGenerator;
import de.hybris.platform.validation.services.LanguagePayloadService;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ConstraintViolationFactoryUtilTest
{
	private ConstraintViolationFactoryUtil subject;
	@Mock
	private ModelService modelService;
	@Mock
	private ResourceBundleProvider bundleProvider;
	@Mock
	private I18NService i18nService;
	@Mock
	private ConstraintViolation<TestPojo> constraintViolation;
	@Mock
	private ConstraintDescriptor<? extends Object> constraintDescriptor;
	@Mock
	private LanguagePayloadService languagePayloadService;
	@Mock
	private InterfaceGenerator interfaceGenerator;
	@Mock
	private TypeService typeService;
	@Mock
	private ComposedTypeModel composedTypeModel;

	@Before
	public void setUp()
	{
		subject = new ConstraintViolationFactoryUtil(modelService, typeService, bundleProvider, i18nService, languagePayloadService);
	}

	private record TestPojo(@NotNull String value)
	{
	}

	@Test
	public void shouldReturnEmptySetForNotExistingType()
	{
		// given
		final var typeService = new DefaultTypeService();
		typeService.setModelService(modelService);
		final var factory = new ConstraintViolationFactoryUtil(modelService, typeService, bundleProvider, i18nService,
				languagePayloadService);

		when(constraintViolation.getRootBeanClass()).thenReturn(TestPojo.class);
		when(modelService.getModelType(TestPojo.class)).thenReturn(null);
		
		// when
		final Set<AbstractConstraintModel> actual = factory.buildConstraintModelForLocalizedMessage(constraintViolation);

		// then
		assertNotNull(actual);
		assertTrue(actual.isEmpty());
	}

	@Test
	public void shouldExtractSeverityWhenPayloadContainsMoreValues()
	{
		// given
		doReturn(constraintDescriptor).when(constraintViolation).getConstraintDescriptor();
		when(constraintDescriptor.getPayload()).thenReturn(Set.of(TestPayload.class, Error.class));

		// when
		final Severity actual = subject.extractSeverity(constraintViolation);

		// then
		assertNotNull(actual);
		assertEquals(Severity.ERROR, actual);
	}

	@Test
	public void shouldFindMatchingConstraintByLanguageModelId()
	{
		//given
		final ConstraintViolation<TestPojo> constraintViolation = mockConstraintViolation(mockConstraintDescriptor(Size.class));
		final LanguageModel languageMock = languageMock("Test");
		mockComposedTypeModel(languageMock);

		final var languagePayloadService = new DefaultLanguagePayloadService(interfaceGenerator);
		subject = new ConstraintViolationFactoryUtil(modelService, typeService, bundleProvider, i18nService, languagePayloadService);

		//when
		final Set<AbstractConstraintModel> constraints = subject.buildConstraintModelForLocalizedMessage(composedTypeModel, constraintViolation);

		assertEquals(1, constraints.size());

		final AbstractConstraintModel constraint = constraints.iterator().next();
		assertEquals(Size.class, constraint.getAnnotation());

		assertTrue(constraint instanceof AttributeConstraintModel);
		final AttributeConstraintModel attributeConstraintModel = (AttributeConstraintModel) constraint;

		assertEquals("value", attributeConstraintModel.getQualifier());
		assertEquals(1, attributeConstraintModel.getLanguages().size());
		assertTrue(attributeConstraintModel.getLanguages().contains(languageMock));
	}

	private void mockComposedTypeModel(final LanguageModel langauge)
	{
		final Set<AbstractConstraintModel> constraintMocks = Set.of(attributeConstraintModelMock(Size.class, Set.of(langauge)));
		when(composedTypeModel.getConstraints()).thenReturn(constraintMocks);
	}

	private AttributeConstraintModel attributeConstraintModelMock(final Class<Size> annotation, final Set<LanguageModel> languages)
	{
		final AttributeConstraintModel attributeConstraintModel = mock(AttributeConstraintModel.class);
		when(attributeConstraintModel.getAnnotation()).thenReturn(annotation);
		when(attributeConstraintModel.getSeverity()).thenReturn(Severity.ERROR);
		when(attributeConstraintModel.getQualifier()).thenReturn("value");
		when(attributeConstraintModel.getLanguages()).thenReturn(languages);
		return attributeConstraintModel;
	}

	private LanguageModel languageMock( final String id)
	{
		final LanguageModel languageModel = mock(LanguageModel.class);
		final PK pk = mock(PK.class);
		when(pk.toString()).thenReturn(id);
		when(languageModel.getPk()).thenReturn(pk);
		return languageModel;
	}

	private ConstraintViolation<TestPojo> mockConstraintViolation(final ConstraintDescriptor<?> constraintDescriptor)
	{
		final ConstraintViolation<TestPojo> constraintViolation = (ConstraintViolation<TestPojo>) mock(ConstraintViolation.class);
		when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createPathFromString("value"));
		doReturn(constraintDescriptor).when(constraintViolation).getConstraintDescriptor();
		return constraintViolation;
	}

	private ConstraintDescriptor<?> mockConstraintDescriptor(final Class<? extends Annotation> annotationType)
	{
		final Annotation annotation = mock(Annotation.class);
		doReturn(annotationType).when(annotation).annotationType();

		final ConstraintDescriptor<? extends Annotation> constraintDescriptor = (ConstraintDescriptor<? extends Annotation>) mock(
				ConstraintDescriptor.class);
		doReturn(annotation).when(constraintDescriptor).getAnnotation();
		when(constraintDescriptor.getPayload()).thenReturn(Set.of(LanguageTest.class, Error.class));
		return constraintDescriptor;
	}

	private interface TestPayload extends Payload
	{
	}

}
