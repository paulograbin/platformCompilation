/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode;

import de.hybris.platform.accesscode.exceptions.AccessCodeException;


/**
 * Access code service
 */
public interface AccessCodeService
{
	/**
	 * Generate access code for input payload
	 * 
	 * @param payload
	 *           payload to be signed and encoded to build access code
	 * @return generated access code
	 * @throws AccessCodeException
	 *            access code exception
	 */
	String buildAccessCode(final String payload) throws AccessCodeException;

	/**
	 * Get public key
	 * 
	 * @return public key
	 * @throws AccessCodeException
	 *            access code exception
	 */
	String getAccessCodePublicKeyString() throws AccessCodeException;
}
