/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.servicelayer.ServicelayerJUnit5BaseTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

/**
 * This class serves as an example on how to use JUnit 5's advanced features i.e., Dynamic Tests and Nested Tests.
 * <p>
 * Dynamic Tests allow the creation of tests at runtime through the stream method and ThrowingConsumer functional interface.
 * This is demonstrated in the generateTestCases() method where we are generating multiple test cases dynamically.
 * <p>
 * Nested Tests allow the structuring of tests according to the tested feature's hierarchy.
 * Here we have nested a class JUnit5RepeatedTest inside JUnit5NestedTest. It provides a cleaner approach when we want
 * to write several different tests for the same method or the same class.
 * Inside the nested class, we illustrate a Repeated Test - a feature that allows to repeat a test a fixed number of times.
 * In this case, we are creating a catalogue model and saving it 10 different times, testing each time that the instance
 * was saved successfully.
 *
 * @see org.junit.jupiter.api.DynamicTest
 * @see org.junit.jupiter.api.Nested
 * @see org.junit.jupiter.api.RepeatedTest
 */
@IntegrationTest
class JUnit5NestedTest extends ServicelayerJUnit5BaseTest
{

	@TestFactory
	Stream<DynamicTest> generateTestCases()
	{
		final Stream<Integer> inputStream = IntStream.range(5, 10).boxed();
		final Function<Integer, String> displayName = input -> "Test input: " + input + " should be bigger than 4";
		final ThrowingConsumer<Integer> testExecutor = input -> assertTrue(input > 4);

		return DynamicTest.stream(inputStream, displayName, testExecutor);
	}

	@Nested
	@IntegrationTest
	class JUnit5RepeatedTest extends ServicelayerJUnit5BaseTest
	{
		private static final String CATALOG_MODEL_VERSION = "version";
		private static final String CATALOG_MODEL_ID = "id";


		@Resource
		private ModelService modelService;

		@RepeatedTest(value = 10)
		void repeatedTestCleansUpCreatedCatalogModels()
		{
			//given
			final CatalogModel catalogModel = modelService.create(CatalogModel.class);
			catalogModel.setName(CATALOG_MODEL_VERSION);
			catalogModel.setId(CATALOG_MODEL_ID);

			//when
			modelService.save(catalogModel);

			//then
			assertNotNull(catalogModel.getPk());
		}
	}
}
