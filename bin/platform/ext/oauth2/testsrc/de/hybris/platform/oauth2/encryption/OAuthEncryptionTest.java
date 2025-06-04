/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.oauth2.encryption;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.oauth2.model.OAuthAuthorizationCodeModel;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.webservicescommons.model.OAuthAccessTokenModel;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;
import de.hybris.platform.webservicescommons.model.OAuthRefreshTokenModel;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.common.util.SerializationUtils;

@IntegrationTest
public class OAuthEncryptionTest extends ServicelayerTest
{
	private static final String SIGNATURE_OF_BYTE_ARRAY_ENCRYPTION_LOWER_CASE = Hex.encodeHexString(";B;".getBytes());
	private static final RowMapper<String> BYTE_ARRAY_ROW_MAPPER_TO_HEX_LOWER_CASE = (rs, rowNum) -> encodeHexStringLowerCase(
			rs.getBytes(1));
	@Resource
	private ModelService modelService;
	@Resource
	private TypeService typeService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	public void shouldVerifyIfOAuthAccessTokenFieldsAreEncrypted()
	{
		final String uniqueString = uniqueString();
		final OAuthClientDetailsModel client = modelService.create(OAuthClientDetailsModel.class);
		client.setClientId(uniqueString());
		modelService.save(client);

		final OAuthAccessTokenModel accessToken = modelService.create(OAuthAccessTokenModel.class);
		accessToken.setTokenId(uniqueString);
		accessToken.setToken(SerializationUtils.serialize(uniqueString));
		accessToken.setAuthenticationId(uniqueString);
		accessToken.setAuthentication(SerializationUtils.serialize(uniqueString));
		accessToken.setClient(client);
		modelService.save(accessToken);

		final String hexUniqueString = Hex.encodeHexString(uniqueString.getBytes());
		final String queryToken = generateQueryForField(typeService.getAttributeDescriptor(OAuthAccessTokenModel._TYPECODE,
				OAuthAccessTokenModel.TOKEN));
		final List<String> encryptedTokenFields = getHexFormattedRowsForQuery(
				queryToken, BYTE_ARRAY_ROW_MAPPER_TO_HEX_LOWER_CASE);
		checkAssertions(encryptedTokenFields, hexUniqueString);

		final String queryAuthentication = generateQueryForField(
				typeService.getAttributeDescriptor(OAuthAccessTokenModel._TYPECODE,
						OAuthAccessTokenModel.AUTHENTICATION));
		final List<String> encryptedAuthenticationFields = getHexFormattedRowsForQuery(
				queryAuthentication, BYTE_ARRAY_ROW_MAPPER_TO_HEX_LOWER_CASE);
		checkAssertions(encryptedAuthenticationFields, hexUniqueString);
	}

	@Test
	public void shouldVerifyIfOAuthAuthorizationCodeFieldIsEncrypted()
	{
		final String uniqueString = uniqueString();
		final OAuthAuthorizationCodeModel authorizationCode = modelService.create(OAuthAuthorizationCodeModel.class);
		authorizationCode.setCode(uniqueString);
		authorizationCode.setAuthentication(SerializationUtils.serialize(uniqueString));
		modelService.save(authorizationCode);

		final String queryAuthorization = generateQueryForField(
				typeService.getAttributeDescriptor(OAuthAuthorizationCodeModel._TYPECODE,
						OAuthAuthorizationCodeModel.AUTHENTICATION));
		final List<String> encryptedAuthenticationFields = getHexFormattedRowsForQuery(
				queryAuthorization, BYTE_ARRAY_ROW_MAPPER_TO_HEX_LOWER_CASE);
		final String hexUniqueString = Hex.encodeHexString(uniqueString.getBytes());
		checkAssertions(encryptedAuthenticationFields, hexUniqueString);
	}

	@Test
	public void shouldVerifyIfOAuthRefreshTokenFieldsAreEncrypted()
	{
		final String uniqueString = uniqueString();
		final OAuthRefreshTokenModel refreshToken = modelService.create(OAuthRefreshTokenModel.class);
		refreshToken.setTokenId(uniqueString);
		refreshToken.setToken(SerializationUtils.serialize(uniqueString));
		refreshToken.setAuthentication(SerializationUtils.serialize(uniqueString));
		modelService.save(refreshToken);

		final String hexUniqueString = Hex.encodeHexString(uniqueString.getBytes());
		final String queryToken = generateQueryForField(typeService.getAttributeDescriptor(OAuthRefreshTokenModel._TYPECODE,
				OAuthRefreshTokenModel.TOKEN));
		final List<String> encryptedTokenFields = getHexFormattedRowsForQuery(
				queryToken, BYTE_ARRAY_ROW_MAPPER_TO_HEX_LOWER_CASE);
		checkAssertions(encryptedTokenFields, hexUniqueString);

		final String queryAuthentication = generateQueryForField(
				typeService.getAttributeDescriptor(OAuthRefreshTokenModel._TYPECODE,
						OAuthRefreshTokenModel.AUTHENTICATION));
		final List<String> encryptedAuthenticationFields = getHexFormattedRowsForQuery(
				queryAuthentication, BYTE_ARRAY_ROW_MAPPER_TO_HEX_LOWER_CASE);
		checkAssertions(encryptedAuthenticationFields, hexUniqueString);
	}

	private static void checkAssertions(final List<String> encryptedTokenFields, final String hexUniqueString)
	{
		assertThat(encryptedTokenFields).isNotEmpty();
		encryptedTokenFields.forEach(string -> {
			assertThat(string).doesNotContain(hexUniqueString);
			assertThat(string).contains(SIGNATURE_OF_BYTE_ARRAY_ENCRYPTION_LOWER_CASE);
		});
	}

	private String uniqueString()
	{
		return UUID.randomUUID().toString();
	}

	private static String encodeHexStringLowerCase(final byte[] array)
	{
		assertThat(array).as("Byte array field read from the result set cannot be null").isNotNull();
		return Hex.encodeHexString(array);
	}

	private String generateQueryForField(final AttributeDescriptorModel attributeDescriptorModel)
	{
		final String databaseColumn = attributeDescriptorModel.getDatabaseColumn();
		return String.format("select %s FROM %s ", databaseColumn,
				attributeDescriptorModel.getEnclosingType().getTable());
	}

	private List<String> getHexFormattedRowsForQuery(final String query, final RowMapper<String> rowMapper)
	{
		return jdbcTemplate.query(query, rowMapper);
	}
}
