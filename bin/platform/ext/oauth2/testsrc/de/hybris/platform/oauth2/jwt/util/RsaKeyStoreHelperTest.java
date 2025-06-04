/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.oauth2.jwt.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.oauth2.jwt.exceptions.JwtException;
import de.hybris.platform.oauth2.jwt.exceptions.KeyStoreProcessingException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.Signer;


@UnitTest
public class RsaKeyStoreHelperTest
{
	private static final String ALIAS = "test1";
	private static final String KEYSTORE_LOCATION = "test/keystore.jks";
	private static final String KEY_STORE_PROPERTIES_LOCATION = "/test/oauth2-test.properties";
	private static final String KEY_STORE_PASSWORD_PROPERTY = "keystore.password";
	private String password;
	ClassPathResource resource;
	RsaKeyStoreHelper keyStoreHelper;

	@Before
	public void setUp() throws IOException
	{
		resource = new ClassPathResource(KEYSTORE_LOCATION);
		keyStoreHelper = new RsaKeyStoreHelper();

		final Properties properties = new Properties();
		try (final InputStream inputStream = RsaKeyStoreHelperTest.class.getResourceAsStream(KEY_STORE_PROPERTIES_LOCATION)) {
			properties.load(inputStream);
		}

		password = properties.getProperty(KEY_STORE_PASSWORD_PROPERTY);
	}

	/**
	 * Test method for
	 * {@link de.hybris.platform.oauth2.jwt.util.RsaKeyStoreHelper#getKeyStore(java.io.InputStream, java.lang.String)}.
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetKeyStoreInputStreamString() throws FileNotFoundException, IOException
	{
		try (final FileInputStream keyStoreFileInputStream = new FileInputStream(resource.getFile()))
		{
			final KeyStore keyStore = keyStoreHelper.getKeyStore(keyStoreFileInputStream, password);
			assertNotNull(keyStore);
		}
		catch (final KeyStoreProcessingException e)
		{
			fail("test failed " + e.getMessage() + " " + e.getClass());
		}
	}

	/**
	 * Test method for
	 * {@link de.hybris.platform.oauth2.jwt.util.RsaKeyStoreHelper#getKeyStore(java.io.InputStream, java.lang.String)}.
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test(expected = KeyStoreProcessingException.class)
	public void testGetKeyStoreInputStreamStringInvalidPassword()
			throws KeyStoreProcessingException, FileNotFoundException, IOException
	{
		try (final FileInputStream keyStoreFileInputStream = new FileInputStream(resource.getFile()))
		{
			keyStoreHelper.getKeyStore(keyStoreFileInputStream, password + "invalid");
		}
	}

	/**
	 * Test method for
	 * {@link de.hybris.platform.oauth2.jwt.util.RsaKeyStoreHelper#getPrivateKey(java.security.KeyStore, java.lang.String, java.lang.String)}.
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetPrivateKey() throws FileNotFoundException, IOException
	{
		try (final FileInputStream keyStoreFileInputStream = new FileInputStream(resource.getFile()))
		{
			final KeyStore keyStore = keyStoreHelper.getKeyStore(keyStoreFileInputStream, password);
			assertNotNull(keyStore);

			final PrivateKey key = keyStoreHelper.getPrivateKey(keyStore, ALIAS, password);
			assertNotNull(key);
			assertTrue(key instanceof RSAPrivateKey);
		}
		catch (final KeyStoreProcessingException e)
		{
			fail("test failed " + e.getMessage() + " " + e.getClass());
		}
	}

	@Test(expected = NullPointerException.class)
	public void testGetPrivateKeyInvalidAlias() throws KeyStoreProcessingException, IOException
	{
		try (final FileInputStream keyStoreFileInputStream = new FileInputStream(resource.getFile()))
		{
			final KeyStore keyStore = keyStoreHelper.getKeyStore(keyStoreFileInputStream, password);
			assertNotNull(keyStore);

			keyStoreHelper.getPrivateKey(keyStore, ALIAS + "invalid", password);
		}
	}

	/**
	 * Test method for
	 * {@link de.hybris.platform.oauth2.jwt.util.RsaKeyStoreHelper#getPublicKey(java.security.KeyStore, java.lang.String)}.
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetPublicKey() throws FileNotFoundException, IOException
	{
		try (final FileInputStream keyStoreFileInputStream = new FileInputStream(resource.getFile()))
		{
			final KeyStore keyStore = keyStoreHelper.getKeyStore(keyStoreFileInputStream, password);
			assertNotNull(keyStore);

			final PublicKey key = keyStoreHelper.getPublicKey(keyStore, ALIAS);
			assertNotNull(key);
			assertTrue(key instanceof RSAPublicKey);
		}
		catch (final KeyStoreProcessingException e)
		{
			fail("test failed " + e.getMessage() + " " + e.getClass());
		}
	}

	@Test
	public void testGetSignerInputStreamStringString() throws IOException
	{
		try (final FileInputStream signerFileInputStream = new FileInputStream(resource.getFile()))
		{
			final Signer signer = keyStoreHelper.getSigner(RsaKeyStoreHelper.DEFAULT_INSTANCE_TYPE,
					signerFileInputStream, ALIAS, password);
			assertNotNull(signer);
		}
		catch (final KeyStoreProcessingException e)
		{
			fail("test failed " + e.getMessage() + " " + e.getClass());
		}
	}

	@Test
	public void buildAndVerify() throws IOException
	{
		try (final FileInputStream signerFileInputStream = new FileInputStream(resource.getFile());
			 final FileInputStream keyStoreFileInputStream = new FileInputStream(resource.getFile()))
		{
			final Signer signer = keyStoreHelper.getSigner(RsaKeyStoreHelper.DEFAULT_INSTANCE_TYPE,
					signerFileInputStream, ALIAS, password);
			final KeyStore keyStore = keyStoreHelper.getKeyStore(keyStoreFileInputStream, password);
			IdTokenHelper idTokenHelper;

			idTokenHelper = new IdTokenHelper.IdTokenBuilder(new IdTokenHelper.HeaderBuilder().getHeaders(),
					new IdTokenHelper.ClaimsBuilder().getClaims()).build();
			final Jwt jwt = idTokenHelper.encodeAndSign(signer);

			assertNotNull(
					JwtHelper.decodeAndVerify(jwt.getEncoded(), new RsaVerifier(keyStoreHelper.getPublicKey(keyStore, ALIAS))));
		}
		catch (KeyStoreProcessingException | JwtException e)
		{
			fail(e.getMessage());
		}
	}
}
