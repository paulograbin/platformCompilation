/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode;

import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;


/**
 * Store a pair of key in one file, read keys separately
 */
public interface KeyPairReadService
{
	/**
	 * Read private key from key pair file
	 * 
	 * @param file
	 *           key store file
	 * @return private key
	 * @throws IOException
	 *            IOException
	 */
	PrivateKey getPrivateKey(final File file) throws IOException;

	/**
	 * Read public key string from key pair file
	 * 
	 * @param file
	 *           key store file
	 * @return public key string
	 * @throws IOException
	 *            IOException
	 */
	String getPublicKey(final File file) throws IOException;
}
