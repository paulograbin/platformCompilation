/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.jupiter.api.Test;

@UnitTest
class JUnit5PackagePrivateSuperClassTest
{
	@Test
	void testSomething()
	{
		final String testString = "test";
		assertEquals("test", testString);
	}
}
