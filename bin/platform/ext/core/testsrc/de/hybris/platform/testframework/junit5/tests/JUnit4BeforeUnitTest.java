/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@UnitTest
public class JUnit4BeforeUnitTest
{
	private int comparedValue;

	@Before
	public void setUp()
	{
		comparedValue = 15;
	}

	@Test
	public void test_valueSetBefore_equals()
	{
		Assert.assertEquals(15, comparedValue);
	}

	@Test
	public void test_valueSetBefore_notEquals()
	{
		Assert.assertNotEquals(132, comparedValue);
	}
}
