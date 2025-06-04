/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerJUnit5BaseTest;
import de.hybris.platform.servicelayer.user.UserService;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

@IntegrationTest
class JUnit5IntegrationTest extends ServicelayerJUnit5BaseTest
{
	@Resource
	private UserService userService;

	@Test
	void successfulTest()
	{
		assertThat(userService).isNotNull();
	}
}
