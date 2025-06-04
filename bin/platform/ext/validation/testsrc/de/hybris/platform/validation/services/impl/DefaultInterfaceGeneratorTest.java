/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.validation.services.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.validation.services.InterfaceGenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultInterfaceGeneratorTest
{
	private static final String PREFIX = DefaultInterfaceGeneratorTest.class.getName();

	private InterfaceGenerator subject;

	@Before
	public void setUp()
	{
		this.subject = new DefaultInterfaceGenerator();
	}

	@Test
	public void shouldGenerateInterfaceWithAGivenNameAndSuperclass()
	{
		//given
		final var interfaceName = PREFIX + "TestInterfaceWithSuperclass";
		final var superClass = Comparable.class;

		//when
		final Class<?> actual = subject.getOrGenerateInterface(interfaceName, superClass);

		//then
		assertEquals(interfaceName, actual.getName());
		assertEquals(1, actual.getInterfaces().length);
		assertEquals(superClass, actual.getInterfaces()[0]);
	}

	@Test
	public void shouldReturnExistingInterfaceIfAlreadyGenerated()
	{
		//given
		final var interfaceName = PREFIX + "ExistingTestInterface";
		final var superClass = Comparable.class;
		final Class<?> existing = subject.getOrGenerateInterface(interfaceName, superClass);

		//when
		final Class<?> actual = subject.getOrGenerateInterface(interfaceName, superClass);

		//then
		assertEquals(interfaceName, existing.getName());
		assertEquals(1, existing.getInterfaces().length);
		assertEquals(superClass, existing.getInterfaces()[0]);

		assertEquals(interfaceName, actual.getName());
		assertEquals(1, actual.getInterfaces().length);
		assertEquals(superClass, actual.getInterfaces()[0]);
	}

	@Test
	public void shouldReturnExistingInterface()
	{
		//given
		final var interfaceName = Comparable.class.getName();

		//when
		final Class<?> actual = subject.getOrGenerateInterface(interfaceName, null);

		//then
		assertEquals(interfaceName, actual.getName());
		assertEquals(1, actual.getMethods().length);
		assertEquals("compareTo", actual.getMethods()[0].getName());
	}

}
