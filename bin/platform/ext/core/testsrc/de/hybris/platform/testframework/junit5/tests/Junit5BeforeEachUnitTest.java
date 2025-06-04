/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class Junit5BeforeEachUnitTest
{
	private int comparedValue;

	@BeforeEach
	public void setUp()
	{
		comparedValue = 15;
	}

	@Test
	void test_valueSetBefore_equals()
	{
		Assertions.assertEquals(15, comparedValue);
	}

	@Test
	void test_valueSetBefore_notEquals()
	{
		Assertions.assertNotEquals(10, comparedValue);
	}
}
