/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

/**
 * This class demonstrates the usage of JUnit 5's Test Template feature through a basic example.
 * Test Templates are tests that can be invoked multiple times, potentially with different parameters or setup.
 * They are ideal for representing test cases that are essentially the same procedure with varying inputs.
 * <p>
 * Using the @TestTemplate annotation, the testTemplate() method is a template for a test that is run
 * multiple times with different input values. The input values are provided by the
 * MyTestTemplateInvocationContextProvider class.
 * <p>
 * The MyTestTemplateInvocationContextProvider class provides the data and name for each invocation of the
 * testTemplate(). It does this by implementing the TestTemplateInvocationContextProvider interface and
 * is registered with the @ExtendWith annotation.
 * <p>
 * In this specific example, the testTemplate() method is run twice with the inputs 'lemon' and 'apple'.
 * It verifies that the input value is contained within a predefined list of fruits.
 *
 * @see org.junit.jupiter.api.TestTemplate
 * @see org.junit.jupiter.api.extension.TestTemplateInvocationContext
 * @see org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider
 */
@UnitTest
class JUnit5TestTemplateTest
{
	final List<String> fruits = Arrays.asList("apple", "banana", "lemon");

	@TestTemplate
	@ExtendWith(MyTestTemplateInvocationContextProvider.class)
	void testTemplate(final String fruit)
	{
		assertTrue(fruits.contains(fruit));
	}

	public static class MyTestTemplateInvocationContextProvider implements TestTemplateInvocationContextProvider
	{

		@Override
		public boolean supportsTestTemplate(final ExtensionContext context)
		{
			return true;
		}

		@Override
		public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(final ExtensionContext context)
		{

			return Stream.of(invocationContext("lemon"), invocationContext("apple"));
		}

		private TestTemplateInvocationContext invocationContext(final String parameter)
		{
			return new TestTemplateInvocationContext()
			{
				@Override
				public String getDisplayName(final int invocationIndex)
				{
					return parameter;
				}

				@Override
				public List<Extension> getAdditionalExtensions()
				{
					return Collections.singletonList(new ParameterResolver()
					{
						@Override
						public boolean supportsParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext)
						{
							return parameterContext.getParameter().getType().equals(String.class);
						}

						@Override
						public Object resolveParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext)
						{
							return parameter;
						}
					});
				}
			};
		}
	}
}