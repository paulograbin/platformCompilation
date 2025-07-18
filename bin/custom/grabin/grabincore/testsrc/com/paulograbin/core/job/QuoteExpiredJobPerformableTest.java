/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.paulograbin.core.job;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.enums.QuoteNotificationType;
import de.hybris.platform.commerceservices.order.CommerceQuoteService;
import de.hybris.platform.commerceservices.order.dao.CommerceQuoteDao;
import de.hybris.platform.core.enums.QuoteState;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.time.TimeService;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class QuoteExpiredJobPerformableTest
{
	@Mock
	protected Set<QuoteState> supportedQuoteStatuses;

	@Mock
	protected CommerceQuoteDao commerceQuoteDao;

	@Mock
	private EventService eventService;

	@Mock
	private ModelService modelService;

	@Mock
	private TimeService timeService;

	@Mock
	private CommerceQuoteService commerceQuoteService;

	@Spy
	@InjectMocks
	private final QuoteExpiredJobPerformable job = new QuoteExpiredJobPerformable();

	@Test
	public void testPerform()
	{
		final Date date1 = new GregorianCalendar(2017, 1, 25, 10, 0, 0).getTime();
		final Date date2 = new GregorianCalendar(2017, 1, 25, 18, 0, 0).getTime(); // current date

		// Mock current date time
		doReturn(date2).when(timeService).getCurrentTime();

		// Mock search results
		final SearchResult<QuoteModel> searchResult = mock(SearchResult.class);
		final QuoteModel quote1 = buildQuoteModel(date1);
		final QuoteModel quote2 = buildQuoteModel(date2);
		doReturn(Arrays.asList(quote1, quote2)).when(searchResult).getResult();
		doReturn(searchResult).when(commerceQuoteDao).findQuotesExpired(eq(date2), any(QuoteNotificationType.class), anySet());
		doReturn(mock(QuoteModel.class)).when(commerceQuoteService).createQuoteSnapshotWithState(any(QuoteModel.class), eq(QuoteState.EXPIRED));

		// Mock cron job
		final CronJobModel cronJob = mock(CronJobModel.class);

		job.perform(cronJob);

		verify(commerceQuoteDao).findQuotesExpired(eq(date2), eq(QuoteNotificationType.EXPIRED), eq(supportedQuoteStatuses));

		searchResult.getResult().stream().forEach(quoteModel -> {
			verify(commerceQuoteService).createQuoteSnapshotWithState(eq(quoteModel), eq(QuoteState.EXPIRED));
		});
		verify(eventService, times(2)).publishEvent(argThat(hasProperty("quote", notNullValue())));
	}

	private QuoteModel buildQuoteModel(final Date expiryTime)
	{
		final QuoteModel quoteModel = mock(QuoteModel.class);
		return quoteModel;
	}
}
