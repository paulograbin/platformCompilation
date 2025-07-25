/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.cronjob.impl;

import static de.hybris.platform.servicelayer.cronjob.impl.JobModelTestUtils.initCatalogVersionSyncJobModel;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncJobModel;
import de.hybris.platform.cronjob.model.BatchJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.cronjob.model.TriggerModel;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.google.common.base.Throwables;


/**
 * Tests {@link TriggerModel}'s {@link JobModel} assignment.
 */
@IntegrationTest
public class TriggerJobValidateInterceptorTest extends ServicelayerBaseTest
{

	private static final String TEST_JOB = "TEST_JOB";

	@Resource
	private TriggerJobValidateInterceptor triggerJobValidator;

	@Resource
	private ModelService modelService;

	@Test
	public void testAssignInvalidJobModel()
	{

		final TriggerModel model = new TriggerModel();
		final JobModel jobModel = new BatchJobModel();
		jobModel.setCode(TEST_JOB);
		modelService.save(jobModel);
		model.setJob(jobModel);


		final Throwable throwable = Assertions.catchThrowable(() -> modelService.save(model));

		assertThat(throwable).isNotNull().isInstanceOf(ModelSavingException.class);
		assertThat(Throwables.getRootCause(throwable)).isInstanceOf(InterceptorException.class) //
		                                              .hasMessageContaining(
				                                              "Assigned Job either does not implements de.hybris.platform.cronjob.jalo.TriggerableJob or is not an instance of de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel!")
		                                              .hasFieldOrPropertyWithValue("interceptor", triggerJobValidator);


	}

	@Test
	public void testAssignValidServicelayerJobModel() throws Throwable
	{
		final TriggerModel model = new TriggerModel();
		final ServicelayerJobModel jobModel = new ServicelayerJobModel();
		jobModel.setCode(TEST_JOB);
		jobModel.setSpringId("TEST_ID");
		modelService.save(jobModel);
		model.setJob(jobModel);

		final Throwable throwable = Assertions.catchThrowable(() -> modelService.save(model));

		assertThat(throwable).isNull();
	}

	@Test
	public void testAssignNullModel() throws Throwable
	{
		final TriggerModel model = new TriggerModel();
		model.setJob(null);

		final Throwable throwable = Assertions.catchThrowable(() -> modelService.save(model));

		assertThat(throwable).isNotNull().isInstanceOf(ModelSavingException.class);
		assertThat(Throwables.getRootCause(throwable)).isInstanceOf(JaloInvalidParameterException.class)
		                                              .hasMessage(
				                                              "Cannot create trigger! No value for CronJob OR Job is given. Need only one value!");
	}

	@Test
	public void testAssignValidTriggerableJob() throws Throwable
	{
		final TriggerModel model = new TriggerModel();
		final CatalogVersionSyncJobModel jobModel = initCatalogVersionSyncJobModel(this.modelService);
		model.setJob(jobModel);

		final Throwable throwable = Assertions.catchThrowable(() -> modelService.save(model));

		assertThat(throwable).isNull();
	}

}
