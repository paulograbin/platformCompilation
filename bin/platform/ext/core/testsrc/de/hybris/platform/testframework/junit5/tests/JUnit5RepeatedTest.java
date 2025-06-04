/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.servicelayer.ServicelayerJUnit5BaseTest;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.junit.jupiter.api.RepeatedTest;

/**
 * This class demonstrates the use of JUnit 5's Repeated Test feature.
 * <p>
 * RepeatedTest allows a test method to be executed multiple times in a row. In this example, the
 * repeatedTestCleansUpCreatedCatalogModels() method will be repeated 10 times. Each time, a new
 * CatalogModel instance is created and saved using the ModelService, and then the test asserts that
 * the create operation was successful by checking if the primary key (PK) for the created CatalogModel
 * is not null.
 * <p>
 * Repeated tests can be useful in scenarios where you want to verify the stability of operations under
 * repetitive execution, simulate load conditions or even in scenarios where issues appear intermittently,
 * and you need a fast and simple way to reproduce them.
 *
 * @see org.junit.jupiter.api.RepeatedTest
 */
@IntegrationTest
class JUnit5RepeatedTest extends ServicelayerJUnit5BaseTest
{
	private static final String CATALOG_MODEL_VERSION = "version";
	private static final String CATALOG_MODEL_ID = "id";


	@Resource
	private ModelService modelService;

	@RepeatedTest(value = 10)
	void repeatedTestCleansUpCreatedCatalogModels()
	{
		//given
		final CatalogModel catalogModel = modelService.create(CatalogModel.class);
		catalogModel.setName(CATALOG_MODEL_VERSION);
		catalogModel.setId(CATALOG_MODEL_ID);

		//when
		modelService.save(catalogModel);

		//then
		assertNotNull(catalogModel.getPk());
	}
}
