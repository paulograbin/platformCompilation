/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestPropertiesUtils
{

	private TestPropertiesUtils()
	{
	}

	public static Properties loadTestPropertiesFor(final Class<?> testClass)
	{
		try (final InputStream is = testClass.getResourceAsStream("/test/" + testClass.getSimpleName() + ".properties"))
		{
			final Properties properties = new Properties();
			properties.load(is);
			return properties;
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
