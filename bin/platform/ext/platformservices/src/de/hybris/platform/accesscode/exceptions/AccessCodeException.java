/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode.exceptions;

/**
 * Exception during generate access code
 */
public class AccessCodeException extends Exception
{
	/**
	 * @param message
	 *           exception message
	 * @param cause
	 *           root cause
	 */
	public AccessCodeException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
}
