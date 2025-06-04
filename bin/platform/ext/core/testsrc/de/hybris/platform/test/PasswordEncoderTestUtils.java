/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.test;

import com.google.common.collect.ObjectArrays;

public class PasswordEncoderTestUtils
{
	public static final String DEFAULT_PASSWORD_ENCODING = "default.password.encoding";
	public static final String LEGACY_PASSWORD_ENCODING_ENABLED = "legacy.password.encoding.enabled";
	public static final String PASSWORD_RE_ENCODE_ENABLED = "password.encoding.auto.update.enabled";

	public static final String ASTERISK = "*";
	public static final String PLAIN = "plain";
	public static final String MD_5 = "md5";
	public static final String SHA_256 = "sha-256";
	public static final String SHA_512 = "sha-512";
	public static final String PBKDF2 = "pbkdf2";
	public static final String ARGON_2 = "argon2";
	public static final String SCRYPT = "scrypt";
	public static final String BCRYPT = "bcrypt";

	public static final String[] DEPRECATED_ENCODINGS = { PLAIN, MD_5, SHA_256, SHA_512, PBKDF2 };
	public static final String[] NON_DEPRECATED_ENCODINGS = { ARGON_2, SCRYPT, BCRYPT };
	public static final String[] ALL_ENCONDIGS = ObjectArrays.concat(ASTERISK,
			ObjectArrays.concat(DEPRECATED_ENCODINGS, NON_DEPRECATED_ENCODINGS, String.class));


	private PasswordEncoderTestUtils()
	{
	}
}
