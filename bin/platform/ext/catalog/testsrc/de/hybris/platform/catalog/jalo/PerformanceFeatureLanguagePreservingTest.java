package de.hybris.platform.catalog.jalo;

import de.hybris.bootstrap.annotations.PerformanceTest;
import de.hybris.platform.catalog.jalo.classification.ClassAttributeAssignment;
import de.hybris.platform.catalog.jalo.synchronization.CatalogVersionSyncJob;
import de.hybris.platform.jalo.c2l.Language;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PerformanceTest
public class PerformanceFeatureLanguagePreservingTest extends PLA_12514_Test
{
	private static final Logger LOG = LoggerFactory.getLogger(PerformanceFeatureLanguagePreservingTest.class);

	@Test
	public void testPerformance() throws Exception
	{
		final int PRODUCTS = 10000;
		final int THREADS = 4;

		final CatalogVersionSyncJob job = createPerfCatalogAndJob(PRODUCTS, THREADS);

		{
			final SyncItemCronJob cronJob = job.newExecution();
			final long time1 = System.currentTimeMillis();
			job.perform(cronJob, true);
			final long time2 = System.currentTimeMillis();

			LOG.info("PLA-12514 performance test (products:" + PRODUCTS + " threads:" + THREADS + " initial sync) took "
					+ ((time2 - time1) / 1000) + " seconds");
		}

		{
			final SyncItemCronJob cronJob = job.newExecution();
			cronJob.setForceUpdate(true);

			final long time1 = System.currentTimeMillis();
			job.perform(cronJob, true);
			final long time2 = System.currentTimeMillis();

			LOG.info("PLA-12514 performance test (products:" + PRODUCTS + " threads:" + THREADS + " update sync) took "
					+ ((time2 - time1) / 1000) + " seconds");
		}
	}

	private CatalogVersionSyncJob createPerfCatalogAndJob(final int products, final int maxThreads) throws Exception
	{
		final List<Language> allLanguages = createLanguages(2);
		final ClassAttributeAssignment clAttr = createClassificationAttribute();
		final CatalogVersion src = createCatalogVersion("perfCat", "src", allLanguages);
		final CatalogVersion tgt = createCatalogVersion("perfCat", "tgt", allLanguages);

		for (int i = 0; i < products; i++)
		{
			createProductWithLocalizedFeatures("perfProd" + i, src, clAttr, allLanguages);
		}

		return createSyncJob(src, tgt, allLanguages, maxThreads);
	}


}
