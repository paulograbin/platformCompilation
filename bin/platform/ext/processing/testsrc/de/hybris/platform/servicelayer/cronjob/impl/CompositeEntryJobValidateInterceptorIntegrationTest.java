/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.cronjob.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncJobModel;
import de.hybris.platform.cronjob.model.CompositeEntryModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static de.hybris.platform.servicelayer.cronjob.impl.JobModelTestUtils.initCatalogVersionSyncJobModel;
import static org.assertj.core.api.Assertions.assertThat;


@IntegrationTest
public class CompositeEntryJobValidateInterceptorIntegrationTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;


	@Test
	public void testAssignInvalidJobModel()
	{
		final CompositeEntryModel model = modelService.create(CompositeEntryModel.class);
		final CatalogVersionSyncJobModel jobModel = initCatalogVersionSyncJobModel(this.modelService);
		model.setTriggerableJob(jobModel);
		model.setCode("testEntry");

		final Throwable throwable = Assertions.catchThrowable(() -> modelService.save(model));

		assertThat(throwable).isNull();
	}
}
