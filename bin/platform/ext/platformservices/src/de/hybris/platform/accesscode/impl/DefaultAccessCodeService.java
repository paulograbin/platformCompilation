/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode.impl;

import de.hybris.platform.accesscode.AccessCodeService;
import de.hybris.platform.accesscode.KeyPairReadService;
import de.hybris.platform.accesscode.exceptions.AccessCodeException;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;


/**
 * DefaultAccessCodeService provides a service to generate access code by input payload and configured PKCS#8 format rsa
 * private key and a service to get the configured X509 format rsa public key. token format is
 * base64url.encode(payload)+"."+ signature. signature =
 * base64url.encode(RSA256.sign(SHA-256(base64url.encode(payload)), private secret key) )
 */
public class DefaultAccessCodeService implements AccessCodeService
{
	private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
	private static final String KEY_STORE_FILE_KEY = "accessCode.keyStore.file";
	private ConfigurationService configurationService;
	private KeyPairReadService keyPairReadService;

	/**
	 * @return Access code public key, parse the configured access code public key and trim the start line and end line.
	 * @throws AccessCodeException
	 *            when has not config a valid X509 format rsa public key in configuration
	 */
	public String getAccessCodePublicKeyString() throws AccessCodeException
	{
		try
		{
			return getKeyPairReadService().getPublicKey(new File(getKeyStoreFile()));
		}
		catch (final IOException e)
		{
			throw new AccessCodeException("Public key stored can not be parsed to be a rsa public key.", e);
		}
	}

	private String getKeyStoreFile()
	{
		return getConfigurationService().getConfiguration().getString(KEY_STORE_FILE_KEY);
	}

	/**
	 * @param payload
	 *           the payload to be encoded and signed
	 * @return signature generated according to payload
	 * @throws AccessCodeException
	 *            when has not config a valid PKCS#8 format rsa private key in configuration.
	 */
	public String buildAccessCode(final String payload) throws AccessCodeException
	{
		if (payload == null || payload.isEmpty())
		{
			throw new IllegalArgumentException("Access code payload can not be empty.");
		}

		final String encodedPayload = base64UrlEncodeToString(payload);
		final String signedPayload = sign(encodedPayload);
		return encodedPayload + "." + signedPayload;
	}

	private String base64UrlEncodeToString(final String src)
	{
		return Base64.getUrlEncoder().encodeToString(src.getBytes(StandardCharsets.UTF_8));
	}

	private String sign(final String encodedPayload) throws AccessCodeException
	{
		try
		{
			final Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initSign(getAccessCodePrivateKey());
			signature.update(encodedPayload.getBytes(StandardCharsets.UTF_8));
			final byte[] sign = signature.sign();

			return base64UrlEncodeToString(sign);
		}
		catch (final NoSuchAlgorithmException | SignatureException | InvalidKeyException e)
		{
			throw new AccessCodeException(String.format("Get signature failed, reason is: [%s]", e.getMessage()), e);
		}
	}

	protected PrivateKey getAccessCodePrivateKey() throws AccessCodeException
	{
		try
		{
			return getKeyPairReadService().getPrivateKey(new File(getKeyStoreFile()));
		}
		catch (final IOException e)
		{
			throw new AccessCodeException("Private key stored can not be parsed to a RSAPrivateKey.", e);
		}
	}

	private String base64UrlEncodeToString(final byte[] src)
	{
		return Base64.getUrlEncoder().encodeToString(src);
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	public void setKeyPairReadService(final KeyPairReadService keyPairReadService)
	{
		this.keyPairReadService = keyPairReadService;
	}

	public KeyPairReadService getKeyPairReadService()
	{
		return keyPairReadService;
	}
}


