/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.performance;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerJUnit5BaseTest;
import de.hybris.platform.testframework.assertions.assertj.TestLogListenerAssert;
import de.hybris.platform.testframework.log.TestLogListener;
import de.hybris.platform.testframework.performance.TestMethod;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.TestIdentifier;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.TestAbortedException;

@IntegrationTest
@ExtendWith(MockitoExtension.class)
class PerformanceTestExecutionListenerTest extends ServicelayerJUnit5BaseTest
{
	private static final String DEFAULT_PERFORMANCE_MEASUREMENT = "de.hybris.platform.testframework.performance.impl.SimpleLog4jPerformanceMeasurement";
	private final TestLogListener testLogListener = new TestLogListener();
	@Mock
	private TestIdentifier testIdentifier;
	private PerformanceTestExecutionListener performanceTestExecutionListener;

	@BeforeEach
	public void setUp()
	{
		testLogListener.attach();
		performanceTestExecutionListener = new PerformanceTestExecutionListener(DEFAULT_PERFORMANCE_MEASUREMENT);
	}

	@AfterEach
	public void tearDown()
	{
		testLogListener.detach();
	}

	@ParameterizedTest
	@EnumSource(TestExecutionResult.Status.class)
	void testExecutionFinished_whenTestSource_isMethodSource_shouldLogCorrectly(final TestExecutionResult.Status status) throws NoSuchMethodException
	{
		// given
		final MethodSource methodSource = MethodSource.from(SimpleTest.class, SimpleTest.class.getMethod("simpleTestMethod"));
		final TestMethod testMethod = new TestMethod(methodSource.getClassName(), methodSource.getMethodName());
		final String expectedLogMessage = String.format("Test method %s %s. Time taken: ", testMethod,
				getFormattedExecutionStatus(status));
		when(testIdentifier.getSource()).thenReturn(Optional.of(methodSource));
		when(testIdentifier.getType()).thenReturn(TestDescriptor.Type.TEST);
		performanceTestExecutionListener.executionStarted(testIdentifier);

		// when
		performanceTestExecutionListener.executionFinished(testIdentifier, createTestExecutionResult(status));

		// then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(expectedLogMessage)
		                     .occurrences(1);
	}

	@ParameterizedTest
	@EnumSource(TestExecutionResult.Status.class)
	void testExecutionFinished_whenTestIdentifier_isNotTest_shouldIgnore(final TestExecutionResult.Status status)
	{
		// given
		when(testIdentifier.getType()).thenReturn(TestDescriptor.Type.CONTAINER_AND_TEST);
		performanceTestExecutionListener.executionStarted(testIdentifier);

		// when
		performanceTestExecutionListener.executionFinished(testIdentifier, createTestExecutionResult(status));

		// then
		assertTrue(testLogListener.loggingEvents().isEmpty());
	}

	private TestExecutionResult createTestExecutionResult(final TestExecutionResult.Status status)
	{
		return switch (status)
		{
			case FAILED -> TestExecutionResult.failed(new Throwable());
			case ABORTED -> TestExecutionResult.aborted(new TestAbortedException());
			case SUCCESSFUL -> TestExecutionResult.successful();
		};
	}

	private String getFormattedExecutionStatus(final TestExecutionResult.Status status)
	{
		return switch (status)
		{
			case FAILED -> "failed";
			case ABORTED -> "aborted";
			case SUCCESSFUL -> "succeeded";
		};
	}

	private static class SimpleTest
	{
		public void simpleTestMethod()
		{

		}
	}
}