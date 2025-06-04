/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.extensions;

import static java.lang.String.format;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.testframework.assertions.assertj.TestLogListenerAssert;
import de.hybris.platform.testframework.log.TestLogListener;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.TestAbortedException;

@UnitTest
@ExtendWith({ MockitoExtension.class })
class LogRunExtensionTest
{
	private final TestLogListener testLogListener = new TestLogListener();

	@Mock
	private ExtensionContext context;

	@BeforeEach
	public void setUp()
	{
		testLogListener.attach();
		when(context.getTestClass()).thenReturn(Optional.of(SimpleTest.class));
	}

	@AfterEach
	public void tearDown()
	{
		testLogListener.detach();
	}

	@Test
	void shouldLogFailedTest()
	{
		//given
		final LogRunExtension logRunExtension = new LogRunExtension();
		final Throwable exception = new AssertionFailedError("testFailed");
		when(context.getDisplayName()).thenReturn("failedTest");

		//when
		logRunExtension.testFailed(context, exception);

		//then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(
				                     format("Test method %s (%s) failed!!", context.getDisplayName(), SimpleTest.class.getName()))
		                     .loggedFrom(LogRunExtension.class)
		                     .withThrowable(AssertionFailedError.class)
		                     .withLogLevel(TestLogListenerAssert.LogLevel.ERROR)
		                     .occurrences(1);

	}

	@Test
	void shouldLogAbortedTest()
	{
		//given
		final LogRunExtension logRunExtension = new LogRunExtension();
		final Throwable exception = new TestAbortedException("testAborted");
		when(context.getDisplayName()).thenReturn("abortedTest");

		//when
		logRunExtension.testAborted(context, exception);

		//then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(
				                     format("Test method %s (%s) aborted!!", context.getDisplayName(),
						                     SimpleTest.class.getName()))
		                     .loggedFrom(LogRunExtension.class)
		                     .withThrowable(TestAbortedException.class)
		                     .withLogLevel(TestLogListenerAssert.LogLevel.ERROR)
		                     .occurrences(1);

	}

	@Test
	void shouldLogTestClassStarted()
	{
		//given
		final LogRunExtension logRunExtension = new LogRunExtension();
		when(context.getDisplayName()).thenReturn("simpleTest");

		//when
		logRunExtension.beforeAll(context);

		//then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(
				                     format("Starting test class %s (%s)", context.getDisplayName(), SimpleTest.class.getName()))
		                     .loggedFrom(LogRunExtension.class)
		                     .withLogLevel(TestLogListenerAssert.LogLevel.INFO)
		                     .occurrences(1);

	}

	@Test
	void shouldLogTestMethodStarted()
	{
		//given
		final LogRunExtension logRunExtension = new LogRunExtension();
		when(context.getDisplayName()).thenReturn("testMethod");

		//when
		logRunExtension.beforeEach(context);

		//then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(
				                     format("Starting test method %s (%s)", context.getDisplayName(), SimpleTest.class.getName()))
		                     .loggedFrom(LogRunExtension.class)
		                     .withLogLevel(TestLogListenerAssert.LogLevel.INFO)
		                     .occurrences(1);

	}

	@Test
	void shouldLogTestMethodFinished()
	{
		//given
		final LogRunExtension logRunExtension = new LogRunExtension();
		when(context.getDisplayName()).thenReturn("testMethod");

		//when
		logRunExtension.afterEach(context);

		//then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(
				                     format("Finished test method %s (%s)", context.getDisplayName(), SimpleTest.class.getName()))
		                     .loggedFrom(LogRunExtension.class)
		                     .withLogLevel(TestLogListenerAssert.LogLevel.INFO)
		                     .occurrences(1);

	}

	@Test
	void shouldLogTestResult()
	{
		//given
		final LogRunExtension logRunExtension = new LogRunExtension();
		final Throwable exception = new AssertionFailedError("testFailedOrAborted");
		final Optional<String> testDisabledReason = Optional.of("testDisabledReason");
		when(context.getDisplayName()).thenReturn("SimpleTest");

		//when
		logRunExtension.beforeAll(context);
		logRunExtension.afterEach(context);
		logRunExtension.afterEach(context);
		logRunExtension.afterEach(context);
		logRunExtension.afterEach(context);
		logRunExtension.testFailed(context, exception);
		logRunExtension.testAborted(context, exception);
		logRunExtension.testAborted(context, exception);
		logRunExtension.testDisabled(context, testDisabledReason);
		logRunExtension.testDisabled(context, testDisabledReason);
		logRunExtension.testDisabled(context, testDisabledReason);
		logRunExtension.afterAll(context);

		//then
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining(
				                     format("Finished (failed) test class %s", context.getDisplayName()))
		                     .loggedFrom(LogRunExtension.class)
		                     .occurrences(1);
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining("Total run time:")
		                     .loggedFrom(LogRunExtension.class)
		                     .occurrences(1);

		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining("Failed tests count: 1")
		                     .loggedFrom(LogRunExtension.class)
		                     .occurrences(1);
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining("Disabled tests count: 3")
		                     .loggedFrom(LogRunExtension.class)
		                     .occurrences(1);
		TestLogListenerAssert.assertThat(testLogListener)
		                     .hasLog()
		                     .withMessageContaining("Aborted tests count: 2")
		                     .loggedFrom(LogRunExtension.class)
		                     .occurrences(1);
	}

	private static class SimpleTest
	{

	}

}
