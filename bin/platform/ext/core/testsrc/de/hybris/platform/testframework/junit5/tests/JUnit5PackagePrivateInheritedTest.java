/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.jupiter.api.Test;

@UnitTest
class JUnit5PackagePrivateInheritedTest extends JUnit5PackagePrivateSuperClassTest
{
	@Test
	void testInherited()
	{
		final int intTest = 1;
		assertEquals(1, intTest);
	}
}
