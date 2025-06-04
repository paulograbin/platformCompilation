/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.testframework.RunListeners;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.TestAbortedException;


@UnitTest
@ExtendWith(MockitoExtension.class)
class RunListenerExtensionTest
{
	@Mock
	private ExtensionContext context;

	@BeforeEach
	public void setUp()
	{
		doReturn(TestWithRunListeners.class).when(context).getRequiredTestClass();
		lenient().when(context.getDisplayName()).thenReturn(TestWithRunListeners.class.getName());
	}

	@Test
	void shouldInitPropertiesWhenBeforeAllIsCalled() throws Exception
	{
		//given
		final RunListenerExtension runListenerExtension = new RunListenerExtension();

		//when
		runListenerExtension.beforeAll(context);

		//then
		assertEquals(TestWithRunListeners.class, runListenerExtension.testClass);
		assertNotNull(runListenerExtension.result);
		assertNotNull(runListenerExtension.resultListener);
		assertNotNull(runListenerExtension.runListeners);
		assertEquals(2, runListenerExtension.runListeners.size());
		assertTrue(containsListener(runListenerExtension, TestRunListener.class));
		assertTrue(containsListener(runListenerExtension, TestRunListener1.class));
		runListenerExtension.runListeners.forEach(listener -> {
			if (listener instanceof TestRunListener testListener)
			{
				assertTrue(testListener.isTestRunStartedCalled());
			}
		});
	}

	@Test
	void shouldCalculateTestResult() throws Exception
	{
		//given
		final RunListenerExtension runListenerExtension = new RunListenerExtension();
		final Throwable exception = new AssertionFailedError("testFailedOrAborted");
		final Optional<String> testDisabledReason = Optional.of("testDisabledReason");

		//when
		runListenerExtension.beforeAll(context);
		runListenerExtension.afterEach(context);
		runListenerExtension.afterEach(context);
		runListenerExtension.afterEach(context);
		runListenerExtension.afterEach(context);
		runListenerExtension.testFailed(context, exception);
		runListenerExtension.testAborted(context, exception);
		runListenerExtension.testAborted(context, exception);
		runListenerExtension.testDisabled(context, testDisabledReason);
		runListenerExtension.testDisabled(context, testDisabledReason);
		runListenerExtension.testDisabled(context, testDisabledReason);
		runListenerExtension.afterAll(context);

		//then
		assertNotNull(runListenerExtension.result);
		assertEquals(1, runListenerExtension.result.getFailureCount());
		assertEquals(2, runListenerExtension.result.getAssumptionFailureCount());
		assertEquals(3, runListenerExtension.result.getIgnoreCount());
		assertEquals(4, runListenerExtension.result.getRunCount());
		assertTrue(runListenerExtension.result.getRunTime() >= 0);
		assertNotNull(runListenerExtension.result.getFailures());
		assertEquals(1, runListenerExtension.result.getFailures().size());
		assertEquals(exception, runListenerExtension.result.getFailures().get(0).getException());
		assertFalse(runListenerExtension.result.wasSuccessful());
	}

	private static Stream<Arguments> testArgumentProvider()
	{
		return Stream.of(
				Arguments.of((BiConsumerWithException<RunListenerExtension, ExtensionContext>) RunListenerExtension::beforeEach,
						(Function<TestRunListener, Boolean>) (TestRunListener::isTestStartedCalled)),
				Arguments.of((BiConsumerWithException<RunListenerExtension, ExtensionContext>) RunListenerExtension::afterEach,
						(Function<TestRunListener, Boolean>) (TestRunListener::isTestFinishedCalled)),
				Arguments.of((BiConsumerWithException<RunListenerExtension, ExtensionContext>) RunListenerExtension::afterAll,
						(Function<TestRunListener, Boolean>) (TestRunListener::isTestRunFinishedCalled)),
				Arguments.of(
						(BiConsumerWithException<RunListenerExtension, ExtensionContext>) (listener, context) -> listener.testDisabled(
								context, Optional.of("testDisabledReason")),
						(Function<TestRunListener, Boolean>) (TestRunListener::isTestIgnoredCalled)),
				Arguments.of(
						(BiConsumerWithException<RunListenerExtension, ExtensionContext>) (listener, context) -> listener.testAborted(
								context, new TestAbortedException("testAborted")),
						(Function<TestRunListener, Boolean>) (TestRunListener::isTestAssumptionFailureCalled)),
				Arguments.of(
						(BiConsumerWithException<RunListenerExtension, ExtensionContext>) (listener, context) -> listener.testFailed(
								context, new AssertionFailedError("testFailed")),
						(Function<TestRunListener, Boolean>) (TestRunListener::isTestFailureCalled))
		);
	}

	@ParameterizedTest
	@MethodSource("testArgumentProvider")
	void shouldCallCorrespondingMethodsForRunListeners(
			final BiConsumerWithException<RunListenerExtension, ExtensionContext> callbackMethod,
			final Function<RunListener, Boolean> verifyFunction)
			throws Exception
	{
		//given
		final RunListenerExtension runListenerExtension = new RunListenerExtension();
		runListenerExtension.beforeAll(context);

		//when
		callbackMethod.accept(runListenerExtension, context);

		//then
		runListenerExtension.runListeners.forEach(listener -> {
			if (listener instanceof TestRunListener testListener)
			{
				assertTrue(verifyFunction.apply(testListener));
			}
		});
	}

	private boolean containsListener(final RunListenerExtension runListenerExtension,
	                                 final Class<? extends RunListener> listenerClass)
	{
		return runListenerExtension.runListeners.stream().anyMatch(listener -> listener.getClass().equals(listenerClass));
	}

	public static class TestRunListener extends RunListener
	{
		private boolean testRunStartedCalled = false;
		private boolean testRunFinishedCalled = false;
		private boolean testStartedCalled = false;
		private boolean testFinishedCalled = false;
		private boolean testFailureCalled = false;
		private boolean testAssumptionFailureCalled = false;
		private boolean testIgnoredCalled = false;


		@Override
		public void testRunStarted(final Description description) throws Exception
		{
			testRunStartedCalled = true;
		}

		@Override

		public void testRunFinished(final Result result) throws Exception
		{
			testRunFinishedCalled = true;
		}

		@Override
		public void testStarted(final Description description) throws Exception
		{
			testStartedCalled = true;
		}

		@Override
		public void testFinished(final Description description) throws Exception
		{
			testFinishedCalled = true;
		}

		@Override
		public void testFailure(final Failure failure) throws Exception
		{
			testFailureCalled = true;
		}

		@Override
		public void testAssumptionFailure(final Failure failure)
		{
			testAssumptionFailureCalled = true;
		}

		@Override
		public void testIgnored(final Description description) throws Exception
		{
			testIgnoredCalled = true;
		}

		public boolean isTestRunStartedCalled()
		{
			return testRunStartedCalled;
		}

		public boolean isTestRunFinishedCalled()
		{
			return testRunFinishedCalled;
		}

		public boolean isTestStartedCalled()
		{
			return testStartedCalled;
		}

		public boolean isTestFinishedCalled()
		{
			return testFinishedCalled;
		}

		public boolean isTestFailureCalled()
		{
			return testFailureCalled;
		}

		public boolean isTestAssumptionFailureCalled()
		{
			return testAssumptionFailureCalled;
		}

		public boolean isTestIgnoredCalled()
		{
			return testIgnoredCalled;
		}
	}

	public static class TestRunListener1 extends TestRunListener
	{

	}

	@RunListeners({ TestRunListener.class, TestRunListener1.class })
	private static class TestWithRunListeners
	{

	}

	public static interface BiConsumerWithException<T, U>
	{
		void accept(T t, U u) throws Exception;
	}
}
