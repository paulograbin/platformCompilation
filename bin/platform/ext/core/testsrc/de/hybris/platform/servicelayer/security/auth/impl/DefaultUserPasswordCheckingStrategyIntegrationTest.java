/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.security.auth.impl;

import static de.hybris.platform.test.PasswordEncoderTestUtils.ALL_ENCONDIGS;
import static de.hybris.platform.test.PasswordEncoderTestUtils.ARGON_2;
import static de.hybris.platform.test.PasswordEncoderTestUtils.BCRYPT;
import static de.hybris.platform.test.PasswordEncoderTestUtils.DEFAULT_PASSWORD_ENCODING;
import static de.hybris.platform.test.PasswordEncoderTestUtils.LEGACY_PASSWORD_ENCODING_ENABLED;
import static de.hybris.platform.test.PasswordEncoderTestUtils.PASSWORD_RE_ENCODE_ENABLED;
import static de.hybris.platform.test.PasswordEncoderTestUtils.SHA_512;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.user.DefaultUserPasswordCheckingStrategy;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.persistence.SystemEJB;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.testframework.BulkPropertyConfigSwitcher;
import de.hybris.platform.util.Config;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class DefaultUserPasswordCheckingStrategyIntegrationTest extends ServicelayerTransactionalBaseTest
{
	private static final String TEST_PASSWORD = RandomStringUtils.randomAlphabetic(3);
	private static final String TRUE = Boolean.TRUE.toString().toLowerCase();
	private static final String FALSE = Boolean.FALSE.toString().toLowerCase();
	private final BulkPropertyConfigSwitcher propertyConfigSwitcher = new BulkPropertyConfigSwitcher();
	private final DefaultUserPasswordCheckingStrategy userPasswordCheckingStrategy = new DefaultUserPasswordCheckingStrategy();
	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	private UserModel employeeModel;
	private User employee;

	@Before
	public void setUp()
	{
		employeeModel = modelService.create(EmployeeModel.class);
		employeeModel.setUid(UUID.randomUUID().toString());
		modelService.saveAll();

		employee = modelService.getSource(employeeModel);
	}

	@After
	public void tearDown() throws Exception
	{
		propertyConfigSwitcher.switchAllBack();
	}

	protected String getRealEncoding(final String optionalEncoding)
	{
		if (StringUtils.isBlank(optionalEncoding) || SystemEJB.DEFAULT_ENCODING.equalsIgnoreCase(optionalEncoding))
		{
			return Config.getString(DEFAULT_PASSWORD_ENCODING, SystemEJB.DEFAULT_ENCODING);
		}
		else
		{
			return optionalEncoding;
		}
	}

	@Test
	public void shouldCheckValidAndInvalidPasswordsForAllEncodingsWhenReencodeIsDisabled()
	{
		// given
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(PASSWORD_RE_ENCODE_ENABLED, FALSE);

		for (final String enc : ALL_ENCONDIGS)
		{
			// when
			userService.setPassword(employeeModel.getUid(), TEST_PASSWORD, enc);

			// then
			assertThat(userPasswordCheckingStrategy.checkPassword(employee, TEST_PASSWORD)).isTrue();
			assertThat(userPasswordCheckingStrategy.checkPassword(employee, TEST_PASSWORD + "x")).isFalse();
			assertThat(employee.getPasswordEncoding()).isEqualTo(getRealEncoding(enc));
		}
	}

	@Test
	public void shouldReencodePasswordWhenDefaultEncodingChanged()
	{
		//given
		final String oldEncoding = BCRYPT;
		final String newEncoding = ARGON_2;
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(PASSWORD_RE_ENCODE_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(DEFAULT_PASSWORD_ENCODING, newEncoding);
		userService.setPassword(employeeModel.getUid(), TEST_PASSWORD, oldEncoding);
		final String oldEncodedPassword = employeeModel.getEncodedPassword();

		//when
		final boolean valid = userPasswordCheckingStrategy.checkPassword(employee, TEST_PASSWORD);

		//then
		assertThat(valid).isTrue();
		assertThat(employee.getEncodedPassword()).isNotEqualTo(oldEncodedPassword);
		assertThat(employee.getPasswordEncoding()).isEqualTo(newEncoding);
	}

	@Test
	public void shouldReencodePasswordWhenEncodingIsDeprecated()
	{
		//given
		final String oldEncoding = SHA_512;
		final String newEncoding = BCRYPT;
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(PASSWORD_RE_ENCODE_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(DEFAULT_PASSWORD_ENCODING, newEncoding);
		userService.setPassword(employeeModel.getUid(), TEST_PASSWORD, oldEncoding);
		final String oldEncodedPassword = employeeModel.getEncodedPassword();

		//when
		final boolean valid = userPasswordCheckingStrategy.checkPassword(employee, TEST_PASSWORD);

		//then
		assertThat(valid).isTrue();
		assertThat(employee.getEncodedPassword()).isNotEqualTo(oldEncodedPassword);
		assertThat(employee.getPasswordEncoding()).isEqualTo(newEncoding);
	}

	@Test
	public void shouldNotReencodePasswordWhenDefaultEncodingDidNotChange()
	{
		//given
		final String encoding = SHA_512;
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(PASSWORD_RE_ENCODE_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(DEFAULT_PASSWORD_ENCODING, encoding);
		userService.setPassword(employeeModel.getUid(), TEST_PASSWORD, encoding);
		final String oldEncodedPassword = employeeModel.getEncodedPassword();

		//when
		final boolean valid = userPasswordCheckingStrategy.checkPassword(employee, TEST_PASSWORD);

		//then
		assertThat(valid).isTrue();
		assertThat(employee.getEncodedPassword()).isEqualTo(oldEncodedPassword);
		assertThat(employee.getPasswordEncoding()).isEqualTo(encoding);
	}

	@Test
	public void shouldNotReencodePasswordWhenEncodingsAreDifferentButFlagIsDisabled()
	{
		//given
		final String oldEncoding = SHA_512;
		final String newEncoding = BCRYPT;
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, TRUE);
		propertyConfigSwitcher.switchToValue(PASSWORD_RE_ENCODE_ENABLED, FALSE);
		propertyConfigSwitcher.switchToValue(DEFAULT_PASSWORD_ENCODING, newEncoding);
		userService.setPassword(employeeModel.getUid(), TEST_PASSWORD, oldEncoding);
		final String oldEncodedPassword = employeeModel.getEncodedPassword();

		//when
		final boolean valid = userPasswordCheckingStrategy.checkPassword(employee, TEST_PASSWORD);

		//then
		assertThat(valid).isTrue();
		assertThat(employeeModel.getEncodedPassword()).isEqualTo(oldEncodedPassword);
		assertThat(employeeModel.getPasswordEncoding()).isEqualTo(oldEncoding);
	}

}
