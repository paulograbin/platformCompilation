/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.util.encryption;

import de.hybris.bootstrap.annotations.UnitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


@UnitTest
public class EnhancedValueEncryptionSupportTest
{
	@Test
	public void shouldCalculateDataTypeForEmptyString()
	{
		final EnhancedValueEncryptorSupport.DataType dataType = EnhancedValueEncryptorSupport.resolveDataTypeForCipherTextToBeDecrypted("");
		assertThat(dataType).isEqualTo(EnhancedValueEncryptorSupport.DataType.FALLBACK_TYPE);
	}

	@Test
	public void shouldCalculateDataTypeForString()
	{
		final EnhancedValueEncryptorSupport.DataType dataType = EnhancedValueEncryptorSupport.resolveDataTypeForCipherTextToBeDecrypted(
				EnhancedValueEncryptorSupport.generateSignature(EnhancedValueEncryptorSupport.DataType.STRING_DATA_TYPE) + "test");
		assertThat(dataType).isEqualTo(EnhancedValueEncryptorSupport.DataType.STRING_DATA_TYPE);
	}

	@Test
	public void shouldCalculateDataTypeForByteArray()
	{
		final EnhancedValueEncryptorSupport.DataType dataType = EnhancedValueEncryptorSupport.resolveDataTypeForCipherTextToBeDecrypted(
				EnhancedValueEncryptorSupport.generateSignature(EnhancedValueEncryptorSupport.DataType.BYTE_DATA_TYPE) + "test");
		assertThat(dataType).isEqualTo(EnhancedValueEncryptorSupport.DataType.BYTE_DATA_TYPE);
	}

	@Test
	public void shouldCalculateDataTypeForUnknownType()
	{
		final EnhancedValueEncryptorSupport.DataType dataType = EnhancedValueEncryptorSupport.resolveDataTypeForCipherTextToBeDecrypted(
				";Z;");
		assertThat(dataType).isEqualTo(EnhancedValueEncryptorSupport.DataType.FALLBACK_TYPE);
	}
}
