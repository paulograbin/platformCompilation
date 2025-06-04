/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.testframework.runlistener;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;

import com.google.common.collect.ImmutableMap;


@UnitTest
public class CustomActionsRunListenerTest
{

	private Map<Integer, List<CustomRunListener>> originalListeners;

	@Before
	public void setUp()
	{
		originalListeners = CustomActionsRunListener.getOrderedListeners();
	}

	@After
	public void tearDown()
	{
		CustomActionsRunListener.setOrderedListeners(originalListeners);
	}

	@Test
	public void shouldExecuteCustomListenersObeyingPriority() throws Exception
	{
		// given
		final List<CustomRunListener> orderOfStarting = new ArrayList<>();
		final List<CustomRunListener> orderOfFinishing = new ArrayList<>();

		final CustomRunListener l1 = new TestCustomRunListener(1, orderOfStarting, orderOfFinishing);
		final CustomRunListener l21 = new TestCustomRunListener(2, orderOfStarting, orderOfFinishing);
		final CustomRunListener l22 = new TestCustomRunListener(2, orderOfStarting, orderOfFinishing);
		final CustomRunListener l23 = new TestCustomRunListener(2, orderOfStarting, orderOfFinishing);
		final CustomRunListener l3 = new TestCustomRunListener(3, orderOfStarting, orderOfFinishing);

		final CustomActionsRunListener tested = new CustomActionsRunListener()
		{
			@Override
			Map<String, CustomRunListener> getCustomListenerBeans()
			{
				return ImmutableMap.of(
						"l1", l1,
						"l22", l22,
						"l3", l3,
						"l23", l23,
						"l21", l21);
			}
		};
		tested.initListeners();

		// when testRunStarted is called
		final Description collector = Description.createTestDescription(CustomActionsRunListenerTest.class, "description");
		tested.testRunStarted(collector);

		// then
		assertThat(orderOfStarting).hasSize(5)
		                           .containsExactly(l1, l22, l23, l21, l3);

		// when testRunFinished is called
		tested.testRunFinished(new Result());

		// then
		assertThat(orderOfFinishing).hasSize(5)
		                            .containsExactly(l3, l21, l23, l22, l1);
	}

	class TestCustomRunListener extends CustomRunListener
	{

		private final int prio;
		private final List<CustomRunListener> orderOfStarting;
		private final List<CustomRunListener> orderOfFinishing;

		public TestCustomRunListener(final int prio, final List<CustomRunListener> orderOfStarting,
		                             final List<CustomRunListener> orderOfFinishing)
		{
			this.prio = prio;
			this.orderOfStarting = orderOfStarting;
			this.orderOfFinishing = orderOfFinishing;
		}

		@Override
		public int getPriority()
		{
			return prio;
		}

		@Override
		public void testRunStarted(final Description description)
		{
			this.orderOfStarting.add(this);
		}

		@Override
		public void testRunFinished(final Result result)
		{
			this.orderOfFinishing.add(this);
		}
	}
}
