/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.impex.jalo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.media.Media;
import de.hybris.platform.jalo.media.MediaManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


@IntegrationTest
public class DefaultExportMediaHandlerTest extends AbstractImpExTest
{
	@Test
	public void testExportDataSingleTextEntry() throws IOException, JaloBusinessException
	{
		final String entryContent = "This is the temporary file content";

		final Media media = MediaManager.getInstance().createMedia("testMediaCron");
		final File testFile = Files.createTempFile("mediaImportTest", ".txt").toFile();

		try (final BufferedWriter bw = new BufferedWriter(new FileWriter(testFile)))
		{
			bw.write(entryContent);
			bw.close();
			media.setFile(testFile);
		}

		assertNotNull(media.getFile());

		final DefaultExportMediaHandler handler = new DefaultExportMediaHandler();
		handler.setMediaFile(new ImpExZip());

		final String entryName = handler.exportData(media);

		handler.getMediaFile().close();

		assertNotNull(handler.getMediaFile().getFile());

		final ZipFile zipFile = new ZipFile(handler.getMediaFile().getFile().getAbsolutePath());
		final Enumeration<? extends ZipEntry> exportedEntries = zipFile.entries();
		assertTrue(exportedEntries.hasMoreElements());

		final ZipEntry exportedEntry = exportedEntries.nextElement();
		assertEquals(entryName, exportedEntry.getName());

		try (final InputStream stream = zipFile.getInputStream(exportedEntry))
		{
			final String exportedEntryContent = IOUtils.toString(stream);
			assertTrue(exportedEntryContent.contains(entryContent));

			assertFalse(exportedEntries.hasMoreElements());
		}
	}
}
