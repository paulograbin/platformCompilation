/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commons.jalo;

import de.hybris.bootstrap.annotations.UnitTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@UnitTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test/dummy-test-spring.xml")
//just for sake to run an autowiring
public class FOPFormatterTest
{
	private static final Logger LOG = Logger.getLogger(FOPFormatterTest.class);

	final FOPFormatter formatter = new FOPFormatter()
	{
		//to make this as unit test
		@Override
		String getConfigurationKey()
		{
			return FOPFormatter.DEFAULT_FOP_CONFIG_CLASSPATH;
		}

		//to make sure we recognize mime not only by its extension
		@Override
		File createTempFile() throws IOException
		{
			return Files.createTempFile("foo", "bar").toFile();
		}
	};


	@Value("classpath:commons/unittest/xmlfo_testsample.xml")
	private org.springframework.core.io.Resource sampleFile;

	@Test
	public void testFormat() throws Exception
	{
		File tempfile = null;
		try
		{
			tempfile = formatter.transform(sampleFile.getInputStream(), sampleFile.getInputStream());
			Assert.assertTrue("Should be correctly recognized as a pdf file ", formatter.validate(tempfile));
		}
		finally
		{
			FileUtils.deleteQuietly(tempfile);
		}

	}
}
