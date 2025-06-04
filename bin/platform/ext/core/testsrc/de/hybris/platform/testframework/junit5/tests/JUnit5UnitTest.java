/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@UnitTest
class JUnit5UnitTest
{
	@Test
	void successfulTest() {
		final int i = 10;
		Assertions.assertEquals(10, i);
	}
}
