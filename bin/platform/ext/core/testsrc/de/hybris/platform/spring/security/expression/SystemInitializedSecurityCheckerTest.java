/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.spring.security.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.jalo.JaloConnection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SystemInitializedSecurityCheckerTest {
	private final SystemInitializedSecurityChecker systemInitializedSecurityChecker = new SystemInitializedSecurityChecker();

	@Mock
	private JaloConnection connection;

	@Mock
	private Tenant tenant;

	@Before
	public void setUp()
	{
		when(tenant.getJaloConnection()).thenReturn(connection);
	}

	@Test
	public void testSystemIsInitialized_shouldReturnTrue()
	{
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			// given
			registryMockedStatic.when(Registry::hasCurrentTenant).thenReturn(true);
			registryMockedStatic.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			when(connection.isSystemInitialized()).thenReturn(true);

			// when then
			assertThat(systemInitializedSecurityChecker.isInitialized()).isTrue();
		}
	}

	@Test
	public void testSystemIsInitialized_shouldReturnFalse()
	{
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			// given
			registryMockedStatic.when(Registry::hasCurrentTenant).thenReturn(true);
			registryMockedStatic.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			when(connection.isSystemInitialized()).thenReturn(false);

			// when then
			assertThat(systemInitializedSecurityChecker.isInitialized()).isFalse();
		}
	}

	@Test
	public void testSystemIsNotInitialized_shouldReturnTrue()
	{
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			// given
			registryMockedStatic.when(Registry::hasCurrentTenant).thenReturn(true);
			registryMockedStatic.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			when(connection.isSystemInitialized()).thenReturn(false);

			// when then
			assertThat(systemInitializedSecurityChecker.isNotInitialized()).isTrue();
		}
	}

	@Test
	public void testSystemIsNotInitialized_shouldReturnFalse()
	{
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			// given
			registryMockedStatic.when(Registry::hasCurrentTenant).thenReturn(true);
			registryMockedStatic.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			when(connection.isSystemInitialized()).thenReturn(true);

			// when then
			assertThat(systemInitializedSecurityChecker.isNotInitialized()).isFalse();
		}
	}
}