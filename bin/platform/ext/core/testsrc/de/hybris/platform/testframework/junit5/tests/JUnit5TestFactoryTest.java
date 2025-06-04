/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

/**
 * This class demonstrates the use of JUnit 5's Dynamic Tests feature.
 * Dynamic Tests allow the creation and execution of tests dynamically at runtime, as opposed to standard tests
 * which are defined at compile time.
 * <p>
 * In this example, the generateTestCases() method generates a Dynamic Test for each integer in the range between
 * 0 and 9. For each of these tests, the integer value is asserted to be less than 10.
 * <p>
 * Dynamic Tests can be helpful in scenarios where the set of test cases needs to be determined programmatically,
 * such as generating tests based on values stored in a file or received from a server, or when the same test logic
 * needs to be applied to a large number of inputs.
 *
 * @see org.junit.jupiter.api.TestFactory
 * @see org.junit.jupiter.api.DynamicTest
 */
@UnitTest
class JUnit5TestFactoryTest
{
	@TestFactory
	Stream<DynamicTest> generateTestCases()
	{
		final Stream<Integer> inputStream = IntStream.range(0, 10).boxed();
		final Function<Integer, String> displayName = input -> "Test input: " + input + " should be smaller than 10";
		final ThrowingConsumer<Integer> testExecutor = input -> assertTrue(input < 10);

		return DynamicTest.stream(inputStream, displayName, testExecutor);
	}

}
