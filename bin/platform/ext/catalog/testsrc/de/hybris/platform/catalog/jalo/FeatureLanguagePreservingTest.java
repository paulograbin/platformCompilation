package de.hybris.platform.catalog.jalo;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import de.hybris.platform.catalog.jalo.classification.ClassAttributeAssignment;
import de.hybris.platform.catalog.jalo.synchronization.CatalogVersionSyncJob;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.product.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.Test;

public class FeatureLanguagePreservingTest extends PLA_12514_Test
{
	@Test
	public void testHiddenFeatureLanguagePreserving() throws Exception
	{
		// 1. setup
		final List<Language> allLanguages = createLanguages(4);
		final Language language0 = allLanguages.get(0);
		final Language language1 = allLanguages.get(1);
		final Language language2 = allLanguages.get(2);
		final Language language3 = allLanguages.get(3);
		final List<Language> syncLanguages = Arrays.asList(language1, language2);
		final ClassAttributeAssignment clAttr = createClassificationAttribute();
		final CatalogVersion src = createCatalogVersion("cat", "src", syncLanguages);
		final CatalogVersion tgt = createCatalogVersion("cat", "tgt", syncLanguages);

		final Product product = createProductWithLocalizedFeatures("prod", src, clAttr, syncLanguages);
		assertEquals(Collections.EMPTY_MAP, product.getAllName());
		final Map<Language, String> syncLocFValues = new HashMap<Language, String>();
		syncLocFValues.put(language1, assembleValue(language1));
		syncLocFValues.put(language2, assembleValue(language2));

		assertLocalizedFeatureValues(product, clAttr, syncLocFValues, allLanguages);

		final CatalogVersionSyncJob job = createSyncJob(src, tgt, null, 1);

		// 2. run sync first time

		final SyncItemCronJob cronJob = job.newExecution();
		job.perform(cronJob, true);


		// 3. validate

		assertLocalizedFeatureValues(product, clAttr, syncLocFValues, allLanguages);

		final Product pCopy = (Product) CatalogManager.getInstance().getCounterpartItem(product, tgt);
		assertNotNull(pCopy);

		assertLocalizedFeatureValues(pCopy, clAttr, syncLocFValues, allLanguages);

		// 4. add values for non-sync languages to both src and tgt ( shall NOT overwrite each other )
		final Map<Language, String> newTgtFValues = new HashMap<Language, String>(syncLocFValues);
		newTgtFValues.put(language0, "l0 tgt");
		newTgtFValues.put(language3, "l3 tgt");
		setFeatureValues(pCopy, clAttr, newTgtFValues);
		assertLocalizedFeatureValues(pCopy, clAttr, newTgtFValues, allLanguages);
		final Map<Language, String> newSrcFValues = new HashMap<Language, String>(syncLocFValues);
		newSrcFValues.put(language0, "l0 src");
		newSrcFValues.put(language3, "l3 src");
		final Date prevModDate = product.getModificationTime();
		setFeatureValues(product, clAttr, newSrcFValues);
		assertLocalizedFeatureValues(product, clAttr, newSrcFValues, allLanguages);

		// 5. make src product modified to trigger re-sync

		final Map<Language, String> names = new HashMap<Language, String>();
		names.put(language1, "l1 name");
		names.put(language2, "l2 name");
		// make sure mod timestamp is really changed even on mysql
		Awaitility.await().pollInSameThread()
		          .atMost(1, TimeUnit.SECONDS)
		          .pollInterval(100, TimeUnit.MILLISECONDS)
		          .until(() -> product.getModificationTime() != prevModDate);
		product.setAllName(names);
		assertEquals(names, product.getAllName());
		assertEquals(Collections.EMPTY_MAP, pCopy.getAllName());

		// 6. run sync again

		final SyncItemCronJob cronJob2 = job.newExecution();
		job.perform(cronJob2, true);

		// 7. validate names getting copied but non-sync features getting preserved

		assertEquals(names, product.getAllName());
		assertEquals(names, pCopy.getAllName());

		assertLocalizedFeatureValues(product, clAttr, newSrcFValues, allLanguages);
		assertLocalizedFeatureValues(pCopy, clAttr, newTgtFValues, allLanguages);
	}
}
