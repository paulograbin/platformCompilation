/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.test;


import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.persistence.SystemEJB;
import de.hybris.platform.persistence.security.PasswordEncoder;
import de.hybris.platform.testframework.HybrisJUnit4TransactionalTest;
import de.hybris.platform.util.Config;

import java.util.Collection;

import org.junit.Test;


@IntegrationTest
public class DefaultPasswordEncoderConfigurationTest extends HybrisJUnit4TransactionalTest
{

	@Test
	public void testSupportedEncodingsContainsDefaultEncodingKey()
	{
		// when
		final Collection<String> encodings = Registry.getCurrentTenant().getJaloConnection().getPasswordEncoderFactory()
		                                             .getSupportedEncodings();

		// then
		assertThat(encodings)
				.contains(SystemEJB.DEFAULT_ENCODING);
	}

	@Test
	public void testDefaultPasswordEncoderInstanceIsTheSameAsEncoderForDefaultEncodingInstance()
	{
		// given
		final String defaultPasswordEncoderBeanId = Config.getParameter(
				"default.password.encoder");

		// when
		final PasswordEncoder encoderForDefaultEncoding = Registry.getCurrentTenant().getJaloConnection()
		                                    .getPasswordEncoder(SystemEJB.DEFAULT_ENCODING);
		final PasswordEncoder defaultPasswordEncoder = (PasswordEncoder) Registry.getApplicationContext()
		                                                                         .getBean(defaultPasswordEncoderBeanId);
		// then
		assertThat(defaultPasswordEncoder).isEqualTo(encoderForDefaultEncoding);
	}
}
