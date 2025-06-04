/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.util;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomTextUtils
{

	private RandomTextUtils()
	{
	}

	public static String randomText(final int length)
	{
		return RandomStringUtils.randomAlphabetic(length);
	}
}
