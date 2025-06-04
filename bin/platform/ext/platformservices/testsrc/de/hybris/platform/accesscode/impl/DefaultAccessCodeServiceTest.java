/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.accesscode.exceptions.AccessCodeException;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.apache.commons.configuration.Configuration;
import org.apache.logging.log4j.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultAccessCodeServiceTest
{
	private static final String TEST_PAYLOAD = "{ \"cartId\": \"00003002\", \"creationTime\":1669705991 }";;
	@Spy
	AbstractKeyPairReadService keyPairReadService;

	@Mock
	ConfigurationService configurationService;

	@Mock
	Configuration configuration;

	@InjectMocks
	DefaultAccessCodeService accessCodeService;

	@Before
	public void setup() throws IOException, URISyntaxException
	{
		Mockito.when(configurationService.getConfiguration()).thenReturn(configuration);
		final URL url = getClass().getResource("/platformservices/test/accessCode/accessCode_keypair.pem");
		final String ketStorePath = Paths.get(url.toURI()).toFile().getAbsolutePath();
		Mockito.when(configuration.getString("accessCode.keyStore.file")).thenReturn(ketStorePath);
	}

	@Test
	public void testGenerateAccessCodeAndCanBeVerified() throws Exception
	{
		final String accessCode = accessCodeService.buildAccessCode(TEST_PAYLOAD);

		System.out.println("---access code value start--");
		System.out.println(accessCode);
		System.out.println("---access code value end--");

		final String[] array = accessCode.split("\\.");
		final String encodedData = array[0];
		final String signatureString = array[1];

		final Signature signature = Signature.getInstance("SHA256withRSA");

		signature.initVerify(this.parsePublicKey(accessCodeService.getAccessCodePublicKeyString()));
		signature.update(encodedData.getBytes());
		assertTrue(signature.verify(Base64.getUrlDecoder().decode(signatureString)));
		assertEquals(TEST_PAYLOAD, new String(Base64.getUrlDecoder().decode(encodedData), StandardCharsets.UTF_8));
	}

	public PublicKey parsePublicKey(final String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		final byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
		final X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyBytes);
		return KeyFactory.getInstance("RSA").generatePublic(spec);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPayloadIsNullExpectException() throws AccessCodeException
	{
		accessCodeService.buildAccessCode(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPayloadIsEmptyExpectException() throws AccessCodeException
	{
		accessCodeService.buildAccessCode(Strings.EMPTY);
	}

	@Test(expected = AccessCodeException.class)
	public void testWhenNoAccessCodePrivateKeyExpectAccessCodeException() throws AccessCodeException
	{
		Mockito.when(accessCodeService.getAccessCodePrivateKey()).thenReturn(null);
		accessCodeService.buildAccessCode(TEST_PAYLOAD);
	}

	@Test(expected = AccessCodeException.class)
	public void testWhenNotValidPrivateKeyExpectAccessCodeException() throws AccessCodeException
	{
		final PrivateKey privateKey = Mockito.mock(PrivateKey.class);
		Mockito.when(accessCodeService.getAccessCodePrivateKey()).thenReturn(privateKey);
		accessCodeService.buildAccessCode(TEST_PAYLOAD);
	}
}
