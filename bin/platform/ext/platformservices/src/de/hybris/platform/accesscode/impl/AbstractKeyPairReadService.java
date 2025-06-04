/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode.impl;

import de.hybris.platform.accesscode.KeyPairReadService;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;


/**
 * AbstractKeyPairReadService provide a functionality that can read a pair of key from one key store file. The key store
 * file, start/end line of the key pair must be injected in the children beans configuration.
 */
public class AbstractKeyPairReadService implements KeyPairReadService
{

	/**
	 * Get private key from key store file
	 * 
	 * @return private key string
	 * @throws IOException
	 */
	@Override
	public PrivateKey getPrivateKey(final File file) throws IOException
	{
		try (final PEMParser pemParser = new PEMParser(new FileReader(file, StandardCharsets.UTF_8)))
		{
			PrivateKey privateKey = null;
			Object object;

			while ((object = pemParser.readObject()) != null)
			{
				if (object instanceof final PrivateKeyInfo privateKeyInfo)
				{
					final JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
					privateKey = converter.getPrivateKey(privateKeyInfo);
					break;
				}
			}
			return privateKey;
		}
	}

	/**
	 * Get public key from key store file
	 * 
	 * @return public key string
	 * @throws IOException
	 */
	@Override
	public String getPublicKey(final File file) throws IOException
	{
		try (final PEMParser pemParser = new PEMParser(new FileReader(file, StandardCharsets.UTF_8)))
		{
			Object object;

			while ((object = pemParser.readObject()) != null)
			{
				if (object instanceof final SubjectPublicKeyInfo subjectPublicKeyInfo)
				{
					final JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
					converter.getPublicKey(subjectPublicKeyInfo);
					final byte[] encoded = subjectPublicKeyInfo.getEncoded();
					return new String(Base64.getEncoder().encode(encoded), StandardCharsets.UTF_8);
				}
			}

			return StringUtils.EMPTY;
		}
	}
}
