/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.media.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaFolderModel;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultMediaDaoTest
{
	@Mock
	private FlexibleSearchService service;

	private DefaultMediaDao dao;

	@Before
	public void prepare()
	{
		dao = new DefaultMediaDao();
		dao.setFlexibleSearchService(service);
	}

	@Test
	public void testCaseFindMediaByCode()
	{
		final SearchResult result = Mockito.mock(SearchResult.class);

		Mockito.when(service.search(Mockito.anyString(), Mockito.anyMap())).thenReturn(result);

		dao.findMediaByCode("qualifierFoo");

		Mockito.verify(service).search(Mockito.eq("SELECT {pk} FROM {Media} WHERE {code}=?code ORDER BY {pk} ASC"),
				Mockito.argThat(new ArgumentMatcher<Map<String, Object>>()
				{
					@Override
					public boolean matches(final Map<String, Object> stringObjectMap)
					{
						Assert.assertEquals("qualifierFoo", stringObjectMap.get(MediaModel.CODE));
						return true;
					}
				}));
	}

	@Test
	public void testCaseFindMediaByCodeAndCatalogVersion()
	{
		final CatalogVersionModel catalogVersion = new CatalogVersionModel();

		final SearchResult result = Mockito.mock(SearchResult.class);

		Mockito.when(service.search(Mockito.anyString(), Mockito.anyMap())).thenReturn(result);

		dao.findMediaByCode(catalogVersion, "qualifierFoo");

		Mockito.verify(service).search(
				Mockito.eq("SELECT {pk} FROM {Media} WHERE {CatalogVersion}=?catalogVersion AND {code}=?code ORDER BY {pk} ASC"),
				Mockito.argThat(new ArgumentMatcher<Map<String, Object>>()
				{
					@Override
					public boolean matches(final Map<String, Object> stringObjectMap)
					{
						Assert.assertEquals("qualifierFoo", stringObjectMap.get(MediaModel.CODE));
						Assert.assertEquals(catalogVersion, stringObjectMap.get(MediaModel.CATALOGVERSION));
						return true;
					}
				}));
	}

	@Test
	public void testCaseFindMediaByCodeAndNullCatalogVersion()
	{

		final SearchResult result = Mockito.mock(SearchResult.class);

		Mockito.when(service.search(Mockito.anyString(), Mockito.anyMap())).thenReturn(result);

		dao.findMediaByCode(null, "qualifierFoo");

		Mockito.verify(service).search(
				Mockito.eq("SELECT {pk} FROM {Media} WHERE {CatalogVersion}=?catalogVersion AND {code}=?code ORDER BY {pk} ASC"),
				Mockito.argThat(new ArgumentMatcher<Map<String, Object>>()
				{
					@Override
					public boolean matches(final Map<String, Object> stringObjectMap)
					{
						Assert.assertEquals("qualifierFoo", stringObjectMap.get(MediaModel.CODE));
						Assert.assertEquals(null, stringObjectMap.get(MediaModel.CATALOGVERSION));
						return true;
					}
				}));
	}

	@Test
	public void testCaseFindMediaFolderByQualifier()
	{
		final SearchResult result = Mockito.mock(SearchResult.class);

		Mockito.when(service.search(Mockito.anyString(), Mockito.anyMap())).thenReturn(result);

		dao.findMediaFolderByQualifier("qualifierFoo");

		Mockito.verify(service)
		       .search(Mockito.eq("SELECT {pk} FROM {MediaFolder} WHERE {qualifier}=?qualifier ORDER BY {pk} ASC"),
				       Mockito.argThat(new ArgumentMatcher<Map<String, Object>>()
				       {
					       @Override
					       public boolean matches(final Map<String, Object> stringObjectMap)
					       {
						       Assert.assertEquals("qualifierFoo", stringObjectMap.get(MediaFolderModel.QUALIFIER));
						       return true;
					       }
				       }));
	}


	@Test
	public void testCaseFindMediaFormatByQualifier()
	{
		final SearchResult result = Mockito.mock(SearchResult.class);

		Mockito.when(service.search(Mockito.anyString(), Mockito.anyMap())).thenReturn(result);

		dao.findMediaFormatByQualifier("qualifierFoo");

		Mockito.verify(service)
		       .search(Mockito.eq("SELECT {pk} FROM {MediaFormat} WHERE {qualifier}=?qualifier ORDER BY {pk} ASC"),
				       Mockito.argThat(new ArgumentMatcher<Map<String, Object>>()
				       {
					       @Override
					       public boolean matches(final Map<String, Object> stringObjectMap)
					       {
						       Assert.assertEquals("qualifierFoo", stringObjectMap.get(MediaFormatModel.QUALIFIER));
						       return true;
					       }
				       }));
	}

	@Test
	public void testCaseFindMediasByFormatQualifiers()
	{
		final SearchResult result = Mockito.mock(SearchResult.class);

		final MediaContainerModel mediaContainer1 = Mockito.mock(MediaContainerModel.class);
		final MediaContainerModel mediaContainer2 = Mockito.mock(MediaContainerModel.class);
		final MediaModel media1 = Mockito.mock(MediaModel.class);
		final MediaModel media2 = Mockito.mock(MediaModel.class);
		final List<MediaModel> mediaList = Lists.newArrayList(media1, media2);
		final List<MediaContainerModel> containers = Lists.newArrayList(mediaContainer1, mediaContainer2);
		final List<String> formatQualifiers = Lists.newArrayList("qualify1", "qualify2");

		Mockito.when(service.search(Mockito.any(FlexibleSearchQuery.class))).thenReturn(result);
		Mockito.when(result.getResult()).thenReturn(mediaList);

		final List<MediaModel> mediaResultList = dao.findMediasByFormatQualifiers(containers, formatQualifiers);

		Assert.assertEquals(2, mediaResultList.size());
		Assert.assertTrue(mediaResultList.contains(media1));
		Assert.assertTrue(mediaResultList.contains(media2));
		Mockito.verify(service).search(Mockito.argThat(new ArgumentMatcher<FlexibleSearchQuery>()
		{
			@Override
			public boolean matches(final FlexibleSearchQuery flexibleSearchQuery)
			{
				Assert.assertEquals(
						"SELECT {pk} FROM {Media} WHERE {mediaContainer} in (?containers) AND {mediaFormat} IN ( {{ SELECT {pk} FROM {MediaFormat} WHERE ({qualifier} in (?formatQualifiers)) }} )",
						flexibleSearchQuery.getQuery());
				Assert.assertEquals(containers, flexibleSearchQuery.getQueryParameters().get("containers"));
				Assert.assertEquals(formatQualifiers, flexibleSearchQuery.getQueryParameters().get("formatQualifiers"));
				return true;
			}
		}));
	}

}
