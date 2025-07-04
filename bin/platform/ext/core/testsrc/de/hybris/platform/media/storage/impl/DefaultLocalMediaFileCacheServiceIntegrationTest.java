/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.media.storage.impl;

import static de.hybris.platform.media.storage.impl.DefaultMediaCacheCleanupService.EVICTED_FILE_MARKER;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.threadregistry.RegistrableThread;
import de.hybris.platform.media.exceptions.MediaStoreException;
import de.hybris.platform.media.storage.LocalMediaFileCacheService;
import de.hybris.platform.media.storage.LocalMediaFileCacheService.StreamGetter;
import de.hybris.platform.media.storage.MediaStorageConfigService.MediaFolderConfig;
import de.hybris.platform.media.storage.impl.DefaultMediaStorageConfigService.DefaultSettingKeys;
import de.hybris.platform.regioncache.CacheController;
import de.hybris.platform.regioncache.key.CacheKey;
import de.hybris.platform.regioncache.region.CacheRegion;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.util.MediaUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.bouncycastle.util.encoders.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.quality.Strictness;

import com.google.common.collect.ImmutableList;
import com.google.common.io.CountingInputStream;

@IntegrationTest
public class DefaultLocalMediaFileCacheServiceIntegrationTest extends ServicelayerBaseTest
{
	private static final Logger LOG = Logger.getLogger(DefaultLocalMediaFileCacheServiceIntegrationTest.class);
	private static final String TENANT_ID = Registry.getCurrentTenantNoFallback().getTenantID();
	private static final String CACHE_FOLDER = "cache";
	private static final String FOLDER_QUALIFIER = "fooBar";
	private static final String FOLDER_PATH = FOLDER_QUALIFIER;
	private static final String MEDIA_LOCATION_IN_STORAGE = FOLDER_PATH + "/h94/h05/12345";
	private static final String MEDIA_LOCATION_IN_STORAGE_WITH_SPECIAL_CHARACTERS_AFTER_ENCODING = FOLDER_PATH
			+ "/h94/h05/__ニュース.jpg";

	@Resource(name = "defaultCacheController")
	private CacheController cacheController;
	@Resource(name = "localMediaFileCacheService")
	private LocalMediaFileCacheService localMediaFileCacheService;

	private MockitoSession mockito;

	@Mock
	private MediaFolderConfig folderConfig;
	@Mock
	private InputStream inputStream;
	@Mock
	private StreamGetter streamGetter;
	@Mock
	private StreamGetter streamGetterWithSpecialCharacters;

	@Before
	public void setUp() throws Exception
	{
		mockito = Mockito.mockitoSession().initMocks(this).strictness(Strictness.LENIENT).startMocking();
		cleanUpCache();
	}

	@After
	public void cleanUp()
	{
		mockito.finishMocking();
		cleanUpCache();
	}

	private void cleanUpCache()
	{
		try
		{
			final CacheRegion mediaCacheRegion = getMediaCacheRegion();
			final Collection<CacheKey> allKeys = mediaCacheRegion.getAllKeys();
			for (final CacheKey cacheKey : allKeys)
			{
				if (TENANT_ID.equalsIgnoreCase(cacheKey.getTenantId()))
				{
					mediaCacheRegion.remove(cacheKey, false);
				}
			}

			FileUtils.deleteDirectory(new File(MediaUtil.getLocalStorageDataDir() + "/cache"));
		}
		catch (final IOException e)
		{
			LOG.error("Cannot clean out testing cache directory");
		}
	}

	private CacheRegion getMediaCacheRegion()
	{
		final Optional<CacheRegion> mediaCacheRegion = cacheController.getRegions()
		                                                              .stream()
		                                                              .filter(MediaCacheRegion.class::isInstance)
		                                                              .findFirst();
		assertThat(mediaCacheRegion).isPresent();
		return mediaCacheRegion.get();
	}

	@Test
	public void shouldCacheFileOnlyOnceWhenRequestingMediaWithTheSameLocationMultipleTimes() throws IOException
	{
		// given
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		final StreamContainer container = new StreamContainer();

		try
		{
			// when
			runThreadsWithLatch(500, () -> {
				final InputStream stream = localMediaFileCacheService.storeOrGetAsStream(folderConfig,
						MEDIA_LOCATION_IN_STORAGE,
						streamGetter);
				if (stream == null)
				{
					fail("Got null stream");
				}
				else
				{
					container.addStream(stream);
				}
			});
		}
		finally
		{
			for (final InputStream stream : container.getStreams())
			{
				closeStream(stream);
			}
		}

		// then
		assertThat(
				getMediaCacheRegion().get(
						new DefaultLocalMediaFileCacheService.MediaCacheKey(TENANT_ID, CACHE_FOLDER, MEDIA_LOCATION_IN_STORAGE)))
				.isNotNull();
		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasOneFileInCache();
	}

	@Test
	public void shouldNotRemoveFilesAfterInvalidationUntilAllClientsCloseTheStreams() throws IOException
	{
		// given
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		final StreamContainer container = new StreamContainer();

		try
		{
			// given
			runThreadsWithLatch(500, () -> {
				final InputStream stream = localMediaFileCacheService.storeOrGetAsStream(folderConfig,
						MEDIA_LOCATION_IN_STORAGE,
						streamGetter);
				if (stream == null)
				{
					fail("Got null stream");
				}
				else
				{
					container.addStream(stream);
				}
			});
			localMediaFileCacheService.removeFromCache(folderConfig, MEDIA_LOCATION_IN_STORAGE);

			// then
			assertThat(container.getStreams()).hasSize(500);
			assertThat(
					getMediaCacheRegion().get(
							new DefaultLocalMediaFileCacheService.MediaCacheKey(TENANT_ID, CACHE_FOLDER,
									MEDIA_LOCATION_IN_STORAGE)))
					.isNull();
			CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasOneFileInCache();
		}
		finally
		{
			for (final InputStream stream : container.getStreams())
			{
				closeStream(stream);
			}
		}

		// now file from disk cache should be removed (after closing all streams)
		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasNoFileInCache();
	}

	@Test
	public void shouldStoreStreamInLocalCacheIfItDoesntExistsAndReturnItAsFileInputStream() throws IOException
	{
		// given
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		InputStream stream = null;

		try
		{
			// when
			stream = localMediaFileCacheService.storeOrGetAsStream(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

			// then
			verify(streamGetter).getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE);
			assertThat(stream).isNotNull();
			assertThat(getStreamNumBytesForStream(stream)).isEqualTo(
					getStreamNumBytesForStream(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)));
		}
		finally
		{
			closeStream(stream);
		}
	}

	@Test
	public void shouldReturnFileInputStreamOfAlreadyCachedStream() throws IOException
	{
		// given (store initially)
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		InputStream stream1 = null;
		InputStream stream2 = null;
		try
		{
			stream1 = localMediaFileCacheService.storeOrGetAsStream(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

			// when
			stream2 = localMediaFileCacheService.storeOrGetAsStream(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

			// then
			verify(streamGetter).getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE);
			assertThat(stream2).isNotNull();
			assertThat(getStreamNumBytesForStream(stream2))
					.isEqualTo(getStreamNumBytesForStream(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)));
		}
		finally
		{
			closeStream(stream1);
			closeStream(stream2);
		}
	}

	@Test
	public void shouldNotThrowExceptionsWhenLocationWithSpecialCharacters() throws IOException
	{
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetterWithSpecialCharacters.getStream(folderConfig,
				MEDIA_LOCATION_IN_STORAGE_WITH_SPECIAL_CHARACTERS_AFTER_ENCODING)).willReturn(
				inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		try (final InputStream ignored = localMediaFileCacheService.storeOrGetAsStream(folderConfig,
				MEDIA_LOCATION_IN_STORAGE_WITH_SPECIAL_CHARACTERS_AFTER_ENCODING,
				streamGetterWithSpecialCharacters))
		{
			verify(streamGetterWithSpecialCharacters).getStream(folderConfig,
					MEDIA_LOCATION_IN_STORAGE_WITH_SPECIAL_CHARACTERS_AFTER_ENCODING);
		}
		catch (final MediaStoreException ex)
		{
			fail("Should not throw exceptions when storing media with special characters. " + ex.getMessage());
		}
	}

	@Test
	public void shouldStoreStreamInLocalCacheIfItDoesntExistsAndReturnItAsRegularFile() throws IOException
	{
		//given
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		// when
		final File file = localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

		// then
		verify(streamGetter).getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE);
		assertThat(file).isNotNull();
	}

	@Test
	public void MissingItemImplshouldReturnRegularFileOfAlreadyCachedStream() throws IOException
	{
		// given (store initially)
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

		// when
		final File file = localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

		// then
		verify(streamGetter).getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE);
		assertThat(file).isNotNull();
	}

	@Test
	public void shouldRemoveCachedFileFromDiskWhenDirectDeleteWasCalled() throws IOException
	{
		// given (store initially)
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		InputStream stream = null;
		try
		{
			stream = localMediaFileCacheService.storeOrGetAsStream(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);
		}
		catch (final IllegalStateException e)
		{
			fail("Stream from cached should be backed by existing file in disk cache");
		}
		finally
		{
			closeStream(stream);
		}

		// when
		localMediaFileCacheService.removeFromCache(folderConfig, MEDIA_LOCATION_IN_STORAGE);

		// then
		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasNoFileInCache();
	}

	@Test
	public void shouldWriteEvictionMarkerFileForCachedFileTakenAsFileByTheClientInsteadRemovingFileOnEviction() throws IOException
	{
		// given
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

		// when
		localMediaFileCacheService.removeFromCache(folderConfig, MEDIA_LOCATION_IN_STORAGE);

		// then
		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasOneFileInCache().hasEvictionMarker();
	}

	@Test
	public void shouldEvictExistingCacheUnitWhenItsUnderlyingFileWasDeletedAccidentally() throws IOException
	{
		// given
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		final File file = localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);

		// when (Don't do this in real life)
		assertThat(file.delete()).isTrue();

		// then
		final File newFile = localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);
		assertThat(file.getAbsolutePath()).isNotEqualTo(newFile.getAbsolutePath());
	}

	@Test
	public void shouldNotStoreFileInTheCacheIfItIsBiggerThanEntireDeclaredCacheSize() throws IOException
	{
		// given
		given(inputStream.read(any(byte[].class))).willReturn(1, 1,
				1, 1,
				1, 1,
				1,
				-1);
		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(streamGetter.getSize(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(Long.valueOf(629145600));

		// when
		localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);
		final boolean isInCache = getMediaCacheRegion().containsKey(getMediaCacheKey());

		// then
		assertThat(isInCache).isFalse();
	}

	@Test
	public void shouldClearCacheAndMarkUnitTakenAsFileEvicted() throws IOException
	{
		// given
		final String anotherMediaLocationInStorage = MEDIA_LOCATION_IN_STORAGE + "1";
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1, 1, 1, 1, 1, 1, -1);

		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(streamGetter.getStream(folderConfig, anotherMediaLocationInStorage)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		// when
		localMediaFileCacheService.storeOrGetAsFile(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter);
		localMediaFileCacheService.storeOrGetAsFile(folderConfig, anotherMediaLocationInStorage, streamGetter);

		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasOneFileInCache();
		CachedFileAssert.assertThat(anotherMediaLocationInStorage).hasOneFileInCache();
		((MediaCacheRegion) getMediaCacheRegion()).clearCacheWithFiles();

		// then
		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasEvictionMarker();
		CachedFileAssert.assertThat(anotherMediaLocationInStorage).hasEvictionMarker();
	}

	@Test
	public void shouldClearCacheAndRemoveFileCorrectly() throws IOException
	{
		// given
		final String anotherMediaLocationInStorage = MEDIA_LOCATION_IN_STORAGE + "1";
		given(folderConfig.getFolderQualifier()).willReturn(FOLDER_QUALIFIER);
		given(folderConfig.getHashingDepth()).willReturn(0);
		given(inputStream.read(any(byte[].class))).willReturn(1, 1, 1, 1, 1, 1, 1, -1);

		given(streamGetter.getStream(folderConfig, MEDIA_LOCATION_IN_STORAGE)).willReturn(inputStream);
		given(streamGetter.getStream(folderConfig, anotherMediaLocationInStorage)).willReturn(inputStream);
		given(folderConfig.getParameter(DefaultSettingKeys.LOCAL_CACHE_ROOT_FOLDER_KEY.getKey(), String.class, CACHE_FOLDER))
				.willReturn(CACHE_FOLDER);

		// when
		localMediaFileCacheService.storeOrGetAsStream(folderConfig, MEDIA_LOCATION_IN_STORAGE, streamGetter)
		                          .close();
		localMediaFileCacheService.storeOrGetAsStream(folderConfig, anotherMediaLocationInStorage, streamGetter)
		                          .close();

		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasOneFileInCache();
		CachedFileAssert.assertThat(anotherMediaLocationInStorage).hasOneFileInCache();
		((MediaCacheRegion) getMediaCacheRegion()).clearCacheWithFiles();

		// then
		CachedFileAssert.assertThat(MEDIA_LOCATION_IN_STORAGE).hasNoFileInCache();
		CachedFileAssert.assertThat(anotherMediaLocationInStorage).hasNoFileInCache();
	}

	private CacheKey getMediaCacheKey()
	{
		return new DefaultLocalMediaFileCacheService.MediaCacheKey(TENANT_ID, CACHE_FOLDER, MEDIA_LOCATION_IN_STORAGE);
	}

	private long getStreamNumBytesForStream(final InputStream stream)
	{
		CountingInputStream cis = null;
		try
		{
			cis = new CountingInputStream(stream);
			return cis.getCount();
		}
		finally
		{
			closeStream(cis);
		}
	}

	private void closeStream(final InputStream stream)
	{
		if (stream != null)
		{
			IOUtils.closeQuietly(stream);
		}
	}

	private void runThreadsWithLatch(final int numThreads, final CacheTestExecutor executor)
	{
		try
		{
			final CountDownLatch latch = new CountDownLatch(numThreads);
			for (int i = 0; i < numThreads; i++)
			{
				new RegistrableThread(() -> {
					try
					{
						executor.execute();
					}
					finally
					{
						latch.countDown();
					}
				}).start();

			}
			latch.await(10, TimeUnit.SECONDS);
		}
		catch (final InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

	private interface CacheTestExecutor
	{
		void execute();
	}

	private static class CachedFileAssert extends AbstractAssert<CachedFileAssert, String>
	{
		public CachedFileAssert(final String actual)
		{
			super(actual, CachedFileAssert.class);
		}

		public static CachedFileAssert assertThat(final String actual)
		{
			return new CachedFileAssert(actual);
		}

		public CachedFileAssert hasOneFileInCache()
		{
			final File[] files = findCachedFiles();
			Assertions.assertThat(files).hasSize(1);
			return this;
		}

		public CachedFileAssert hasNoFileInCache()
		{
			final File[] files = findCachedFiles();
			Assertions.assertThat(files).isEmpty();
			return this;
		}

		public CachedFileAssert hasEvictionMarker()
		{
			final File[] markers = findMarkersForCachedFile();
			Assertions.assertThat(markers).isNotEmpty();
			Assertions.assertThat(markers).hasSize(1);
			return this;
		}


		private File[] findCachedFiles()
		{
			final File dir = new File(MediaUtil.getLocalStorageDataDir(), "/cache/fooBar");
			final FileFilter fileFilter = new WildcardFileFilter(getMediaId(actual) + "*.bin");
			return dir.listFiles(fileFilter);
		}

		private File[] findMarkersForCachedFile()
		{
			final File dir = new File(MediaUtil.getLocalStorageDataDir(), "/cache/fooBar");
			final FileFilter fileFilter = new WildcardFileFilter(getMediaId(actual) + "*.bin" + EVICTED_FILE_MARKER);
			return dir.listFiles(fileFilter);
		}

		private String getMediaId(final String location)
		{
			return new String(Base64.encode(location.getBytes()));
		}
	}

	private static class StreamContainer
	{
		private final List<InputStream> streams = new ArrayList<>();

		public synchronized void addStream(final InputStream stream)
		{
			streams.add(stream);
		}

		public List<InputStream> getStreams()
		{
			return ImmutableList.copyOf(streams);
		}
	}
}
