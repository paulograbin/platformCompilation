/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.jalo.synchronization;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.testframework.log.TestLogListener;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.Utilities;

import javax.annotation.Resource;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static de.hybris.platform.catalog.jalo.synchronization.SynchronizationTestHelper.create;
import static de.hybris.platform.catalog.jalo.synchronization.SynchronizationTestHelper.update;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IntegrationTest
public class SynchronizeCatalogPSQLTest extends ServicelayerTest
{
	private static final String SYNCHRONIZATION_ITEM_COPY_CREATOR_STACK_TRACES = "synchronization.itemcopycreator.stacktraces";
	private static final String CATALOG = "testCatalog" + UUID.randomUUID();
	private static final String SRC_CATALOG_VERSION = "srcCatalog";
	private static final String DST_CATALOG_VERSION = "dstCatalog";
	private static final String CATEGORY = "category";
	private static final String PRODUCT = "product";

	private final TestLogListener logListener = new TestLogListener();

	@Resource
	private ModelService modelService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	private final PropertyConfigSwitcher iccStackTracesProperty = new PropertyConfigSwitcher(SYNCHRONIZATION_ITEM_COPY_CREATOR_STACK_TRACES);

	@BeforeClass
	public static void setUpClass() {
		Assume.assumeTrue(Config.isPostgreSQLUsed());
	}

	@Before
	public void setUp()
	{
		iccStackTracesProperty.switchToValue("true");
		logListener.attach();
	}

	@After
	public void tearDown()
	{
		logListener.detach();
		iccStackTracesProperty.switchBackToDefault();
	}

	@Test
	public void shouldNotThrowPSQLExceptionInCaseOfDuplicateKey()
	{
		//given
		SynchronizationTestHelper.givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION,
				CATEGORY, PRODUCT);
		assertThat(allProductsFor(dstCatalogVersion())).isNotNull().isEmpty();

		//when
		final SynchronizationTestHelper.SyncOperation createProduct = create(productFrom(srcCatalogVersion()));
		performSynchronization(null, createProduct, createProduct, createProduct, createProduct, createProduct);

		//then
		assertThat(allProductsFor(dstCatalogVersion())).isNotNull().hasSize(1);
		assertThat(productFrom(dstCatalogVersion())).isNotNull();

		final var throwableLogEvents = logListener.loggingEvents().stream().filter(event -> event.getThrowable() != null).toList();

		assertTrue(throwableLogEvents.stream()
				.noneMatch(event -> Utilities.getRootCauseOfName(event.getThrowable(), "org.postgresql.util.PSQLException") != null));

		final Optional<SQLIntegrityConstraintViolationException> expectedException = throwableLogEvents.stream()
				.map(event -> (SQLIntegrityConstraintViolationException) Utilities.getRootCauseOfType(event.getThrowable(),
						SQLIntegrityConstraintViolationException.class))
				.filter(Objects::nonNull)
				.filter(throwable -> throwable.getMessage() != null)
				.findAny();

		assertTrue(expectedException.isPresent());
		assertTrue(expectedException.get().getMessage()
				.contains("duplicate key value violates unique constraint \"junit_products_pkey\""));
	}

	@Test
	public void shouldNotThrowPSQLExceptionInCaseOfDuplicateKeyOnLPTable()
	{
		//given
		SynchronizationTestHelper.givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION,
				CATEGORY, PRODUCT);
		final SynchronizationTestHelper.SyncOperation createProduct = create(productFrom(srcCatalogVersion()));
		performSynchronization(null, createProduct);
		assertThat(allProductsFor(dstCatalogVersion())).hasSize(1);

		//when
		final ProductModel product = productFrom(srcCatalogVersion());
		product.setName("englishName", Locale.ENGLISH);
		final SynchronizationTestHelper.SyncOperation update = update(product, productFrom(dstCatalogVersion()));
		performSynchronization(syncLanguagesCronJobConfig(Locale.ENGLISH), update, update, update, update, update);

		//then
		assertThat(allProductsFor(dstCatalogVersion())).isNotNull().hasSize(1);
		assertThat(productFrom(dstCatalogVersion())).isNotNull();

		final var throwableLogEvents = logListener.loggingEvents().stream().filter(event -> event.getThrowable() != null).toList();

		assertTrue(throwableLogEvents.stream()
				.noneMatch(event -> Utilities.getRootCauseOfName(event.getThrowable(), "org.postgresql.util.PSQLException") != null));
	}

	private SynchronizationTestHelper.ConfigureSyncCronJob syncLanguagesCronJobConfig(final Locale locale)
	{
		return cronJob -> {
			final LanguageModel languageModel = new LanguageModel();
			languageModel.setIsocode(locale.getLanguage());
			final LanguageModel languageModel1 = flexibleSearchService.getModelByExample(languageModel);

			((CatalogVersionSyncJob) cronJob.getJob()).setSyncLanguages(
					Collections.singleton(modelService.getSource(languageModel1)));
		};
	}

	private void performSynchronization(final SynchronizationTestHelper.ConfigureSyncCronJob configure,
			final SynchronizationTestHelper.SyncOperation... operations)
	{
		SynchronizationTestHelper.builder(srcCatalogVersion(), dstCatalogVersion()).configure(configure).add(operations).build()
				.performSynchronization();
	}

	private CatalogModel catalog()
	{
		final CatalogModel example = new CatalogModel();
		example.setId(CATALOG);
		return flexibleSearchService.getModelByExample(example);
	}

	private CatalogVersionModel srcCatalogVersion()
	{
		final CatalogVersionModel example = new CatalogVersionModel();
		example.setCatalog(catalog());
		example.setVersion(SRC_CATALOG_VERSION);
		return flexibleSearchService.getModelByExample(example);
	}

	private CatalogVersionModel dstCatalogVersion()
	{
		final CatalogVersionModel example = new CatalogVersionModel();
		example.setCatalog(catalog());
		example.setVersion(DST_CATALOG_VERSION);
		return flexibleSearchService.getModelByExample(example);
	}

	private ProductModel productFrom(final CatalogVersionModel catalogVersion)
	{
		final ProductModel example = new ProductModel();
		example.setCatalogVersion(catalogVersion);
		example.setCode(PRODUCT);
		return flexibleSearchService.getModelByExample(example);
	}

	private Collection<ProductModel> allProductsFor(final CatalogVersionModel catalogVersion)
	{
		final ProductModel example = new ProductModel();
		example.setCatalogVersion(catalogVersion);
		return flexibleSearchService.getModelsByExample(example);
	}
}
