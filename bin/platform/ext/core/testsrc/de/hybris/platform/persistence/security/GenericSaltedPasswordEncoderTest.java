/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.persistence.security;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.testframework.BulkPropertyConfigSwitcher;
import de.hybris.platform.testframework.HybrisJUnit4Test;
import de.hybris.platform.util.Config;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class GenericSaltedPasswordEncoderTest extends HybrisJUnit4Test
{

	private final BulkPropertyConfigSwitcher propertyConfigSwitcher = new BulkPropertyConfigSwitcher();
	private PasswordEncoderFactory passwordEncoderFactory;

	@Before
	public void prepareTest()
	{
		propertyConfigSwitcher.switchToValue(DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED, "true");
		passwordEncoderFactory = Registry.getApplicationContext().getBean("core.passwordEncoderFactory",
				PasswordEncoderFactory.class);
	}

	@After
	public void tearDown() throws Exception
	{
		propertyConfigSwitcher.switchAllBack();
	}

	@Test(expected = RuntimeException.class)
	public void nonExistingAlgorithmShouldThrowException()
	{
		DigestCalculator.getInstance("noneSuch");
	}

	@Test
	public void testDigestCalculator()
	{
		final PasswordEncoder deprecatedEncoder = passwordEncoderFactory.getEncoder("md5");
		final PasswordEncoder genericEncoder = Registry.getApplicationContext()
		                                               .getBean("md5PasswordEncoder", PasswordEncoder.class);
		final String password = RandomStringUtils.randomAlphanumeric(16);

		assertThat(deprecatedEncoder.encode("uid", password)).isEqualTo(genericEncoder.encode("uid", password));
	}
}
