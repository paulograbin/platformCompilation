/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.cronjob.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.cronjob.model.TriggerModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.cronjob.TriggerDao;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DefaultTriggerDaoTest extends ServicelayerBaseTest
{
	@Resource
	private TriggerDao triggerDao;

	@Resource
	private ModelService modelService;

	@Resource
	private I18NService i18NService;

	private long timeFirst;
	private long timeLast;
	private String jobCode;

	@Before
	public void setUp()
	{
		jobCode = "cleanUpJob-" + RandomStringUtils.randomAlphanumeric(6);
		final TriggerModel trigger1;
		final TriggerModel trigger2;

		final ServicelayerJobModel job = modelService.create(ServicelayerJobModel.class);
		job.setCode(jobCode);
		job.setSpringId("cleanUpJobPerformable");
		modelService.save(job);
		trigger1 = modelService.create(TriggerModel.class);
		trigger1.setCronExpression("5 * * * * ? *");
		trigger1.setJob(job);
		trigger1.setActive(Boolean.TRUE);
		modelService.save(trigger1);
		trigger2 = modelService.create(TriggerModel.class);
		trigger2.setCronExpression("10 * * * * ? *");
		trigger2.setJob(job);
		trigger2.setActive(Boolean.TRUE);
		modelService.save(trigger2);

		final Calendar date = Calendar.getInstance();
		date.setTime(trigger1.getActivationTime());
		assertThat(date.get(Calendar.SECOND)).isEqualTo(5);

		date.setTime(trigger2.getActivationTime());
		assertThat(date.get(Calendar.SECOND)).isEqualTo(10);

		timeFirst = trigger1.getActivationTime().getTime();
		timeLast = trigger2.getActivationTime().getTime();

		if (timeFirst > timeLast)
		{
			timeFirst = timeLast;
			timeLast = trigger1.getActivationTime().getTime();
		}
	}

	@Test
	public void testFindActiveTriggersBoth()
	{
		final List<TriggerModel> triggerModels = triggerDao.findActiveTriggers(getCalendar(timeLast + 10));
		validateResult(2, triggerModels);
	}

	@Test
	public void testFindActiveTriggersTrigger1()
	{
		final List<TriggerModel> triggerModels = triggerDao.findActiveTriggers(getCalendar(timeLast - 10));
		validateResult(1, triggerModels);
	}

	@Test
	public void testFindActiveTriggersNone()
	{
		final List<TriggerModel> triggerModels = triggerDao.findActiveTriggers(getCalendar(timeFirst - 10));
		validateResult(0, triggerModels);
	}

	private Calendar getCalendar(final long miliseconds)
	{
		final Calendar calendar = Calendar.getInstance(i18NService.getCurrentTimeZone(), i18NService.getCurrentLocale());
		calendar.setTimeInMillis(miliseconds);

		return calendar;
	}

	private void validateResult(final int expectedNumber, final List<TriggerModel> triggerModels)
	{
		final List<String> adequateTriggerInfos = filterAdequateTriggers(triggerModels);
		assertThat(adequateTriggerInfos).hasSize(expectedNumber);
	}

	private List<String> filterAdequateTriggers(final Collection<TriggerModel> triggers)
	{
		return triggers.stream().filter(t -> t.getJob() != null && t.getJob().getCode().equals(jobCode))
				.map(this::getTriggerInfo).toList();
	}

	private String getTriggerInfo(final TriggerModel triggerModel)
	{
		return "[trigger: " + triggerModel.toString() + " cronExp: " + triggerModel.getCronExpression() + " job: "
				+ triggerModel.getJob() + " jobCode: "
				+ (triggerModel.getJob() != null ? triggerModel.getJob().getCode() : "(no job)") + " cj: "
				+ triggerModel.getCronJob() + " cjCode: "
				+ (triggerModel.getCronJob() != null ? triggerModel.getCronJob().getCode() : "(no cronJob)") + "] ";
	}
}
