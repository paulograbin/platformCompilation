/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.util.encryption;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Constants;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import java.util.Map;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assume;
import org.junit.Test;

@IntegrationTest
public class ValueEncryptorTest extends ServicelayerBaseTest
{
	private static final String SIGNATURE_OF_BYTE_ARRAY_ENCRYPTION = Hex.encodeHexString(";B;".getBytes());
	private static final String SIGNATURE_STRING_ENCRYPTION = Hex.encodeHexString(";S;".getBytes());

	private static final String MSG_TO_ENCRYPT = "msgToEncrypt";
	private static final String EMPTY_MSG_TO_ENCRYPT = "";

	@Test
	public void shouldEncryptStringUsingDataMethod()
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when
		final String encryptedData = engine.encryptData(MSG_TO_ENCRYPT);
		final Object decryptedData = engine.decryptData(encryptedData);
		//then
		assertThat(encryptedData).isNotEqualToIgnoringCase(MSG_TO_ENCRYPT);
		assertThat(decryptedData).isInstanceOf(String.class).isEqualTo(MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldEncryptString() throws Exception
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when
		final String encryptedData = engine.encrypt(MSG_TO_ENCRYPT);
		final String decryptedData = engine.decrypt(encryptedData);
		//then
		assertThat(encryptedData).isNotEqualToIgnoringCase(MSG_TO_ENCRYPT);
		assertThat(encryptedData.toUpperCase()).doesNotContain(SIGNATURE_STRING_ENCRYPTION);
		assertThat(encryptedData.toUpperCase()).doesNotContain(SIGNATURE_OF_BYTE_ARRAY_ENCRYPTION);
		assertThat(decryptedData).isInstanceOf(String.class).isEqualTo(MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldEncryptEmptyString()
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when
		final String encryptedData = engine.encryptData(EMPTY_MSG_TO_ENCRYPT);
		final Object decryptedData = engine.decryptData(encryptedData);
		//then
		assertThat(encryptedData).isNotEqualToIgnoringCase(EMPTY_MSG_TO_ENCRYPT);
		assertThat(decryptedData).isInstanceOf(String.class).isEqualTo(EMPTY_MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldThrowExceptionForNotSupportedType()
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		final Integer valueToEncrypt = 100;
		//when then
		assertThrows(IllegalArgumentException.class, () -> engine.encryptData(valueToEncrypt));
	}

	@Test
	public void shouldThrowExceptionForNullObject()
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when then
		assertThrows(IllegalArgumentException.class, () -> engine.encryptData(null));
	}

	@Test
	public void shouldEncryptByteArray()
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when
		final String encryptedData = engine.encryptData(MSG_TO_ENCRYPT.getBytes());
		final Object decryptedData = engine.decryptData(encryptedData);
		//then
		assertThat(decryptedData).isInstanceOf(byte[].class);
		assertThat(new String((byte[]) decryptedData)).isEqualTo(MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldDecryptDataEncryptedWithDefaultMethodToEncryption() throws Exception
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when
		final String encryptedData = engine.encrypt(MSG_TO_ENCRYPT);
		final Object decryptedData = engine.decryptData(encryptedData);
		//then
		assertThat(decryptedData).isInstanceOf(String.class).isEqualTo(MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldReturnNullIfDecryptedObjectIsNull()
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		//when
		final Object decryptedData = engine.decryptData(null);
		//then
		assertThat(decryptedData).isNull();
	}

	@Test
	public void shouldEncryptStringViaOldKeyMethods() throws Exception
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		final Map.Entry<String, SecretKey> secretKeyEntry = getSecretKeyEntry();
		//when
		final String encryptedData = engine.getEnhancedValueEncryptionStrategy()
		                                   .encryptViaOldKey(secretKeyEntry.getValue(), secretKeyEntry.getKey(),
				                                   MSG_TO_ENCRYPT);
		final String saltWithData = extractSaltWithEncryptedDataFromRawEncryptedData(encryptedData);
		final String decryptedResult = (String) engine.getEnhancedValueEncryptionStrategy()
		                                              .decryptViaOldKey(secretKeyEntry.getValue(), saltWithData);
		//then
		assertThat(decryptedResult).isInstanceOf(String.class).isEqualTo(MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldEncryptByteArrayViaOldKeyMethods() throws Exception
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		final Map.Entry<String, SecretKey> secretKeyEntry = getSecretKeyEntry();
		//when
		final String encryptedData = engine.getEnhancedValueEncryptionStrategy()
		                                   .encryptViaOldKey(secretKeyEntry.getValue(), secretKeyEntry.getKey(),
				                                   MSG_TO_ENCRYPT.getBytes());
		final String saltWithData = extractSaltWithEncryptedDataFromRawEncryptedData(encryptedData);
		final Object decryptedData = engine.getEnhancedValueEncryptionStrategy()
		                                   .decryptViaOldKey(secretKeyEntry.getValue(), saltWithData);
		//then
		assertThat(decryptedData).isInstanceOf(byte[].class);
		assertThat(new String((byte[]) decryptedData)).isEqualTo(MSG_TO_ENCRYPT);
	}

	@Test
	public void shouldDecryptDataEncryptedWithDefaultMethodToEncryptionViaOldKeyMethods() throws Exception
	{
		//given
		final ValueEncryptor engine = Registry.getMasterTenant().getValueEncryptor();
		final Map.Entry<String, SecretKey> secretKeyEntry = getSecretKeyEntry();
		//when
		final String encryptedData = engine.getBasicValueEncryptionStrategy()
		                                   .encryptViaOldKey(secretKeyEntry.getValue(), secretKeyEntry.getKey(),
				                                   MSG_TO_ENCRYPT);
		final String saltWithData = extractSaltWithEncryptedDataFromRawEncryptedData(encryptedData);
		final String decryptedResult = (String) engine.getEnhancedValueEncryptionStrategy()
		                                              .decryptViaOldKey(secretKeyEntry.getValue(), saltWithData);
		//then
		assertThat(decryptedResult).isInstanceOf(String.class).isEqualTo(MSG_TO_ENCRYPT);
	}

	private Map.Entry<String, SecretKey> getSecretKeyEntry()
	{
		final Optional<Map.Entry<String, SecretKey>> firstFindKey = getSecretKeyForTest();
		Assume.assumeFalse(firstFindKey.isEmpty());
		return firstFindKey.get();
	}

	private Optional<Map.Entry<String, SecretKey>> getSecretKeyForTest()
	{
		final Map<String, SecretKey> keyFiles = EncryptionUtil.getSecretKeysFromConfig();
		if (!keyFiles.isEmpty())
		{
			return keyFiles.entrySet().stream().findFirst();
		}
		return Optional.empty();
	}

	private static String extractSaltWithEncryptedDataFromRawEncryptedData(final String rawText)
	{
		final int index = rawText.indexOf(Constants.Encryption.SYMMETRIC_KEY_ID_DELIMITER);
		if (index > 0)
		{
			return rawText.substring(index + 1);
		}
		return rawText;
	}
}
