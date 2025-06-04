/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.accesscode.impl;

import static org.junit.Assert.assertEquals;

import de.hybris.bootstrap.annotations.UnitTest;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultAccessCodeKeyPairReadServiceTest
{

	private static final String PUBLIC_KEY = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAsxm4fTX2FzksWTYzdb/n"
			+ "HBncU9OpSQFWfMazDrfGn4EsJ+ScBUAYZFCjeCt77+811FZTnwGR9rRWEp1rjEQl"
			+ "3WWHWv20w6sSW8Ew4p2aQcaadUWC2XB+5B2n7KhK4TE0Dwxaljhl46hyEOEwf0Tr"
			+ "MAv/2nZWOZ83HOKTUWzrvWbeB8bfWMeiL3ID5giEaHksSvdgxeHURzx4cqLFQ5VV"
			+ "a8h03w7BOx0xyat3HE7wTmxbLsYs2+gC2chSXDAzMjJHO6YBHYA62XQX1Jff2ddj"
			+ "30AdVN24/H+CjugOs2qBuANFgwy5g7lh816wKHQ18a2ZmzOLUAsjKe7cU3G50RDP"
			+ "F4nX5aT+LRpYr+UWxqoGHY+ngPLsoFIgouBcSVwtw/bsSF+Ml6jAjCVD/KQFsBNj"
			+ "FDGiOCFigLpDFtX6QdWHrp6LIwpgFdHIcGHwJ3kuKcMiBbQQ40MiynURo4xn6ld0"
			+ "ameG/HjBTrt9qcPCAPCtXc2UCD25xgNjYyiMs4305BZrRO/kK/mqor7zog4L+9rM"
			+ "62gBgLw4BLbPZV97MdwJTcYqEqOnul+QZeVbdnFChfDbJR9gSA8Dd6G9gJ3KGkbY"
			+ "Z99buehWjpN/CfUuy7mQjEsIBjyQB93HW5HxbZNLH3h+FWfV135FG6STiCC9hTsX" + "o/2Rm4ZcSvkYhYr9L6usnV0CAwEAAQ==";

	@Spy
	AbstractKeyPairReadService accessCodeKeyPairReadService;

	File file;

	@Before
	public void setup() throws URISyntaxException
	{
		final URL url = getClass().getResource("/platformservices/test/accessCode/accessCode_keypair.pem");
		file = new File(Paths.get(url.toURI()).toFile().getAbsolutePath());
	}

	@Test
	public void testGetCorrectPublicKey() throws IOException
	{
		assertEquals(PUBLIC_KEY, accessCodeKeyPairReadService.getPublicKey(file));
	}

	@Test(expected = IOException.class)
	public void testWhenFileNotExitExpectIOException() throws IOException
	{
		final String notExistPath = "/test/accessCode_keypair.pem";
		accessCodeKeyPairReadService.getPublicKey(new File(notExistPath));
	}
}
