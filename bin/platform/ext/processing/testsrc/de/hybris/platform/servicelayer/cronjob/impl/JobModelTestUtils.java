/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.cronjob.impl;

import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncJobModel;
import de.hybris.platform.servicelayer.model.ModelService;


public class JobModelTestUtils
{
	private static final String TEST_TARGET_VERSION = "TEST_TARGET_VERSION";
	private static final String TEST_SOURCE_VERSION = "TEST_SOURCE_VERSION";
	private static final String TEST_CATALOG = "TEST_CATALOG";
	private static final String TEST_JOB = "TEST_JOB";

	public static CatalogVersionSyncJobModel initCatalogVersionSyncJobModel(ModelService modelService) {
		final CatalogVersionSyncJobModel jobModel = modelService.create(CatalogVersionSyncJobModel.class);
		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId(TEST_CATALOG);
		modelService.save(catalog);
		final CatalogVersionModel source = modelService.create(CatalogVersionModel.class);
		source.setCatalog(catalog);
		source.setVersion(TEST_SOURCE_VERSION);
		modelService.save(source);
		jobModel.setSourceVersion(source);
		final CatalogVersionModel target = modelService.create(CatalogVersionModel.class);
		jobModel.setTargetVersion(target);
		target.setCatalog(catalog);
		target.setVersion(TEST_TARGET_VERSION);
		modelService.save(target);
		jobModel.setCode(TEST_JOB);
		modelService.save(jobModel);
		return jobModel;
	}
}
