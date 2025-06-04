/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.user;

import static de.hybris.platform.test.PasswordEncoderTestUtils.ALL_ENCONDIGS;
import static de.hybris.platform.test.PasswordEncoderTestUtils.DEPRECATED_ENCODINGS;
import static de.hybris.platform.test.PasswordEncoderTestUtils.LEGACY_PASSWORD_ENCODING_ENABLED;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.persistence.security.DeprecatedPasswordEncoder;
import de.hybris.platform.persistence.security.EJBPasswordEncoderDeprecatedException;
import de.hybris.platform.persistence.security.PasswordEncoderException;
import de.hybris.platform.persistence.security.PasswordEncoderFactory;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.exceptions.CannotDecodePasswordException;
import de.hybris.platform.servicelayer.user.exceptions.PasswordEncoderNotFoundException;
import de.hybris.platform.servicelayer.user.impl.DefaulPasswordEncoderService;
import de.hybris.platform.testframework.BulkPropertyConfigSwitcher;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.RandomTextUtils;

import java.util.UUID;
import java.util.function.Supplier;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.assertj.core.api.ThrowableAssert;
import org.junit.After;
import org.junit.Test;


@IntegrationTest
public class PasswordEncoderServiceTest extends ServicelayerBaseTest
{
	private static final Logger LOG = Logger.getLogger(PasswordEncoderServiceTest.class.getName());

	private final BulkPropertyConfigSwitcher propertyConfigSwitcher = new BulkPropertyConfigSwitcher();

	@Resource
	private DefaulPasswordEncoderService passwordEncoderService;

	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	@Resource(name = "core.passwordEncoderFactory")
	private PasswordEncoderFactory encoderFactory;

	@After
	public void tearDown() throws Exception
	{
		propertyConfigSwitcher.switchAllBack();
	}

	@Test
	public void testEncodeWithPasswordEncoderNotFoundException()
	{
		final UserModel user = new UserModel();
		final String password = RandomTextUtils.randomText(3);
		final String encoding = "xxx";

		assertFalse(passwordEncoderService.getSupportedEncodings().contains(encoding));
		assertThatThrownBy(() -> passwordEncoderService.encode(user, password, encoding))
				.isInstanceOf(PasswordEncoderNotFoundException.class);
	}

	@Test
	public void encodeWithPlainEncoding()
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		final String plainTextPassword = RandomTextUtils.randomText(3);

		withLegacyPasswordEncodersAllowed(() -> {
			final String encodedPassword = passwordEncoderService.encode(user, plainTextPassword,
					PasswordEncoderConstants.DEFAULT_ENCODING);

			user.setPasswordEncoding(PasswordEncoderConstants.DEFAULT_ENCODING);
			user.setEncodedPassword(encodedPassword);

			assertTrue(modelService.isNew(user));
			assertTrue(passwordEncoderService.isValid(user, plainTextPassword));
			return null;
		});
	}

	@Test
	public void testEncodeWithNullEncoding()
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		final String plainTextPassword = RandomTextUtils.randomText(3);

		final String encodedPassword = withLegacyPasswordEncodersAllowed(
				() -> passwordEncoderService.encode(user, plainTextPassword, null));

		assertTrue(encoderFactory.getEncoder(null).check(user.getUid(), encodedPassword, plainTextPassword));
	}

	@Test
	public void defaultEncodingExists()
	{
		assertTrue(passwordEncoderService.isSupportedEncoding(PasswordEncoderConstants.DEFAULT_ENCODING));
		assertTrue(passwordEncoderService.getSupportedEncodings().contains(PasswordEncoderConstants.DEFAULT_ENCODING));
	}

	@Test
	public void testIsValidAndDecodePassword()
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		user.setPasswordEncoding(PasswordEncoderConstants.DEFAULT_ENCODING);
		final String plainTextPassword = RandomTextUtils.randomText(3);
		user.setEncodedPassword(withLegacyPasswordEncodersAllowed(
				() -> passwordEncoderService.encode(user, plainTextPassword, user.getPasswordEncoding())));

		assertTrue(passwordEncoderService.isValid(user, plainTextPassword));
		assertTrue(encoderFactory.getEncoder(user.getPasswordEncoding())
		                         .check(user.getUid(), user.getEncodedPassword(), plainTextPassword));
	}

	@Test
	public void testCannotDecodeException()
	{
		//this test makes only sense if we have an encoding which throws such exception
		assertTrue(passwordEncoderService.isSupportedEncoding("MD5"));
		assertTrue(passwordEncoderService.isSupportedEncoding("md5"));

		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		user.setPasswordEncoding("md5");

		assertThatThrownBy(() -> passwordEncoderService.decode(user))
				.isInstanceOf(CannotDecodePasswordException.class);
	}

	@Test
	public void testDecodeWithPasswordEncoderNotFoundException()
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		user.setPasswordEncoding("xx11");

		assertThatThrownBy(() -> passwordEncoderService.decode(user))
				.isInstanceOf(PasswordEncoderNotFoundException.class);
	}

	@Test
	public void testSetPasswordWithAllEncodings()
	{
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, "true");
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		modelService.save(user);

		for (final String enc : ALL_ENCONDIGS)
		{
			LOG.info("testing password encoding '" + enc + "'");
			final String plain = "pwd_" + enc;
			userService.setPassword(user, plain, enc);
			modelService.save(user);
			assertTrue(passwordEncoderService.isValid(user, plain));
			assertTrue(!passwordEncoderService.isValid(user, plain + "x"));
		}
	}

	@Test
	public void testSetPasswordWithDeprecatedEncodingsForLegacyFlagDisabled()
	{
		// given
		propertyConfigSwitcher.switchToValue(LEGACY_PASSWORD_ENCODING_ENABLED, "false");
		final UserModel user = modelService.create(UserModel.class);
		user.setUid("xxx");
		modelService.save(user);

		for (final String enc : DEPRECATED_ENCODINGS)
		{
			final String plain = "pwd_" + enc;

			//when
			final ThrowableAssert.ThrowingCallable throwingCallable = () -> userService.setPassword(user, plain, enc);

			//then
			assertThatThrownBy(throwingCallable)
					.isInstanceOf(EJBPasswordEncoderDeprecatedException.class);
		}
	}

	@Test
	public void testValidMethodWithPBKDF2()
	{
		//given
		PasswordEncoderException exception = null;
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(UUID.randomUUID().toString());
		user.setPasswordEncoding("pbkdf2");
		modelService.save(user);
		final String somePlainPassword = RandomTextUtils.randomText(17);

		//when
		try
		{
			passwordEncoderService.isValid(user, somePlainPassword);
		}
		catch (final PasswordEncoderException e)
		{
			exception = e;
		}

		//then
		assertThat(exception).isNotNull();
		assertThat(exception.getMessage()).contains("Exception while checking encoded password for user: " + user.getPk());
		assertThat(exception.getMessage()).doesNotContain(somePlainPassword);
	}

	static <T> T withLegacyPasswordEncodersAllowed(final Supplier<T> logic)
	{
		final PropertyConfigSwitcher configSwitcher = new PropertyConfigSwitcher(
				DeprecatedPasswordEncoder.LEGACY_PASSWORD_ENCODING_ENABLED);
		try
		{
			configSwitcher.switchToValue("true");
			return logic.get();
		}
		finally
		{
			configSwitcher.switchBackToDefault();
		}
	}

}
