/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.validation.services;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.validation.enums.Severity;
import de.hybris.platform.validation.exceptions.HybrisConstraintViolation;
import de.hybris.platform.validation.model.constraints.AbstractConstraintModel;
import de.hybris.platform.validation.payloads.Error;
import de.hybris.platform.validation.payloads.Info;
import de.hybris.platform.validation.payloads.Warn;
import de.hybris.platform.validation.services.impl.DefaultSeverityThresholdAwareCheckerImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintTarget;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.metadata.ConstraintDescriptor;
import javax.validation.metadata.ValidateUnwrappedValue;

import junit.framework.Assert;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Standalone test for checking Violation threshold filter logic.
 */
@UnitTest
public class ViolationSeverityTest
{
	final List<Class<? extends Payload>> order = new ArrayList<Class<? extends Payload>>();

	@Before
	public void prapare()
	{
		order.add(Info.class);
		order.add(Warn.class);
		order.add(Error.class);
	}

	@Test
	public void testWarnTreshold() throws ClassNotFoundException
	{
		final DefaultSeverityThresholdAwareCheckerImpl filter = new DefaultSeverityThresholdAwareCheckerImpl();
		filter.setThresholdLevel(Warn.class);
		filter.setSeveritiesOrder(order);

		final Set<Class<? extends Payload>> error = new HashSet<Class<? extends Payload>>();
		error.add(Error.class);

		final ConstraintDescriptor descriptorError = new TestConstraintDescriptor(error);
		final Set<Class<? extends Payload>> warn = new HashSet<Class<? extends Payload>>();
		warn.add(Warn.class);

		final ConstraintDescriptor descriptorWarn = new TestConstraintDescriptor(warn);
		final Set<Class<? extends Payload>> info = new HashSet<Class<? extends Payload>>();
		info.add(Info.class);

		final ConstraintDescriptor descriptorInfo = new TestConstraintDescriptor(info);
		final HybrisConstraintViolation violationError = new TestHybrisConstraintViolationImpl(
				buildViolationWithDescriptor(descriptorError));
		final HybrisConstraintViolation violationWarn = new TestHybrisConstraintViolationImpl(
				buildViolationWithDescriptor(descriptorWarn));
		final HybrisConstraintViolation violationInfo = new TestHybrisConstraintViolationImpl(
				buildViolationWithDescriptor(descriptorInfo));

		final Set<HybrisConstraintViolation> orginalSet = new HashSet<HybrisConstraintViolation>();
		orginalSet.add(violationError);
		orginalSet.add(violationWarn);
		orginalSet.add(violationInfo);

		Assert.assertTrue("There are violations above ,equal  " + Warn.class, filter.containsViolationsOfSeverity(orginalSet));
	}

	@Test
	public void testErrorTreshold() throws ClassNotFoundException
	{

		final DefaultSeverityThresholdAwareCheckerImpl filter = new DefaultSeverityThresholdAwareCheckerImpl();
		filter.setThresholdLevel(Error.class);
		filter.setSeveritiesOrder(order);

		final Set<Class<? extends Payload>> warn = new HashSet<Class<? extends Payload>>();
		warn.add(Warn.class);

		final ConstraintDescriptor descriptorWarn = new TestConstraintDescriptor(warn);
		final Set<Class<? extends Payload>> info = new HashSet<Class<? extends Payload>>();
		info.add(Info.class);

		final ConstraintDescriptor descriptorInfo = new TestConstraintDescriptor(info);
		final HybrisConstraintViolation violationWarn = new TestHybrisConstraintViolationImpl(
				buildViolationWithDescriptor(descriptorWarn));
		final HybrisConstraintViolation violationInfo = new TestHybrisConstraintViolationImpl(
				buildViolationWithDescriptor(descriptorInfo));
		final Set<HybrisConstraintViolation> orginalSet = new HashSet<HybrisConstraintViolation>();
		orginalSet.add(violationWarn);
		orginalSet.add(violationInfo);

		Assert.assertFalse("There are no violations above ,equal  " + Error.class,
				filter.containsViolationsOfSeverity(orginalSet));
	}

	@Test
	public void shouldNotThrowExceptionWhenOtherPayloadValuesAreNotSeverities() throws ClassNotFoundException
	{
		//given
		final DefaultSeverityThresholdAwareCheckerImpl filter = new DefaultSeverityThresholdAwareCheckerImpl();
		filter.setThresholdLevel(Error.class);
		filter.setSeveritiesOrder(order);
		final ConstraintDescriptor<?> descriptorError = new TestConstraintDescriptor(Set.of(TestPayload.class, Error.class));
		final HybrisConstraintViolation violationError = new TestHybrisConstraintViolationImpl(buildViolationWithDescriptor(descriptorError));

		//when
		final boolean actual = filter.containsViolationsOfSeverity(Set.of(violationError));

		//then
		assertTrue(actual);
	}

	private ConstraintViolation buildViolationWithDescriptor(final ConstraintDescriptor descriptorError)
	{
		return ConstraintViolationImpl.forBeanValidation("messageTemplate", Collections.emptyMap(), Collections.emptyMap(),
				"interpolatedMessage", String.class, "root", null, null,
				null, descriptorError, null);
	}


	private class TestHybrisConstraintViolationImpl implements HybrisConstraintViolation
	{
		private final ConstraintViolation violation;

		TestHybrisConstraintViolationImpl(final ConstraintViolation viol)
		{
			this.violation = viol;
		}

		@Override
		public AbstractConstraintModel getConstraintModel()
		{
			return null;
		}

		@Override
		public ConstraintViolation getConstraintViolation()
		{
			return violation;
		}

		@Override
		public String getLocalizedMessage()
		{
			return null;
		}

		@Override
		public String getMessageTemplate()
		{
			return null;
		}

		@Override
		public String getModelName()
		{
			return null;
		}

		@Override
		public String getProperty()
		{
			return null;
		}

		@Override
		public String getQualifier()
		{
			return null;
		}

		@Override
		public String getTypeName()
		{
			return null;
		}

		@Override
		public Severity getViolationSeverity()
		{
			return null;
		}
	}

	private class TestConstraintDescriptor implements ConstraintDescriptor<NotNull>
	{
		private final Set<Class<? extends Payload>> severities;

		TestConstraintDescriptor(final Set<Class<? extends Payload>> severities)
		{
			this.severities = severities;
		}

		@Override
		public NotNull getAnnotation()
		{
			return null;
		}

		@Override
		public String getMessageTemplate()
		{
			return null;
		}

		@Override
		public Map<String, Object> getAttributes()
		{
			return null;
		}

		@Override
		public Set<ConstraintDescriptor<?>> getComposingConstraints()
		{
			return null;
		}

		@Override
		public List<Class<? extends ConstraintValidator<NotNull, ?>>> getConstraintValidatorClasses()
		{
			return null;
		}

		@Override
		public Set<Class<?>> getGroups()
		{
			return null;
		}

		@Override
		public Set<Class<? extends Payload>> getPayload()
		{
			return severities;
		}

		@Override
		public ConstraintTarget getValidationAppliesTo()
		{
			return null;
		}

		@Override
		public boolean isReportAsSingleViolation()
		{
			return false;
		}

		@Override
		public ValidateUnwrappedValue getValueUnwrapping()
		{
			return null;
		}

		@Override
		public <U> U unwrap(final Class<U> aClass)
		{
			return null;
		}
	}

	private interface TestPayload extends Payload
	{
	}
}
