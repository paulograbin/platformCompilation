/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.jalo;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import de.hybris.platform.catalog.constants.CatalogConstants;
import de.hybris.platform.catalog.constants.GeneratedCatalogConstants.Enumerations.ClassificationAttributeTypeEnum;
import de.hybris.platform.catalog.jalo.classification.ClassAttributeAssignment;
import de.hybris.platform.catalog.jalo.classification.ClassificationAttribute;
import de.hybris.platform.catalog.jalo.classification.ClassificationClass;
import de.hybris.platform.catalog.jalo.classification.ClassificationSystem;
import de.hybris.platform.catalog.jalo.classification.ClassificationSystemVersion;
import de.hybris.platform.catalog.jalo.classification.util.FeatureContainer;
import de.hybris.platform.catalog.jalo.classification.util.TypedFeature;
import de.hybris.platform.catalog.jalo.synchronization.CatalogVersionSyncJob;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.JaloItemNotFoundException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloAbstractTypeException;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.testframework.HybrisJUnit4Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;


/**
 * Tests preservation of localized feature values for languages <b>excluded from sync</b>.
 * <p>
 * See PLA-12514 for details.
 */
public abstract class PLA_12514_Test extends HybrisJUnit4Test
{

	CatalogVersionSyncJob createSyncJob(final CatalogVersion src, final CatalogVersion tgt,
	                                            final List<Language> syncLanguages, final int maxThreads)
	{
		final Map args = new HashMap();
		args.put(CatalogVersionSyncJob.CODE, "PLA-12514-Job");
		args.put(CatalogVersionSyncJob.SOURCEVERSION, src);
		args.put(CatalogVersionSyncJob.TARGETVERSION, tgt);
		args.put(CatalogVersionSyncJob.MAXTHREADS, Integer.valueOf(maxThreads));
		if (syncLanguages != null)
		{
			args.put(CatalogVersionSyncJob.SYNCLANGUAGES, syncLanguages);
		}
		return CatalogManager.getInstance().createCatalogVersionSyncJob(args);
	}

	void assertLocalizedFeatureValues(final Product product, final ClassAttributeAssignment clAttr,
	                                  final Map<Language, String> expected, final Collection<Language> allLanguages)
	{
		final FeatureContainer featureContainer = FeatureContainer.loadTyped(product, Collections.singletonList(clAttr));

		final TypedFeature<Object> feature = featureContainer.getFeature(clAttr);

		final SessionContext lCtx = jaloSession.createSessionContext();
		for (final Map.Entry<Language, String> e : expected.entrySet())
		{
			lCtx.setLanguage(e.getKey());
			assertEquals(Collections.singletonList(e.getValue()), feature.getValuesDirect(lCtx));
		}
		for (final Language otherLang : allLanguages)
		{
			if (!expected.containsKey(otherLang))
			{
				lCtx.setLanguage(otherLang);
				assertEquals(Collections.EMPTY_LIST, feature.getValuesDirect(lCtx));
			}
		}
	}

	String assembleValue(final Language language)
	{
		return "localized-" + language.getIsoCode();
	}

	Product createProductWithLocalizedFeatures(final String code, final CatalogVersion catalogVersion,
	                                           final ClassAttributeAssignment clAttr, final List<Language> languages)
			throws JaloGenericCreationException,
			JaloAbstractTypeException, JaloItemNotFoundException, ConsistencyCheckException
	{
		final Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(Product.CODE, code);
		attributes.put(CatalogConstants.Attributes.Product.CATALOGVERSION, catalogVersion);

		final Product product = ComposedType.newInstance(null, Product.class, attributes);

		final Map<Language, String> fValues = new HashMap<Language, String>();
		for (final Language l : languages)
		{
			fValues.put(l, assembleValue(l));
		}
		setFeatureValues(product, clAttr, fValues);

		return product;
	}

	void setFeatureValues(final Product product, final ClassAttributeAssignment clAttr, final Map<Language, String> values)
			throws ConsistencyCheckException
	{
		final FeatureContainer featureContainer = FeatureContainer.createTyped(product, Collections.singletonList(clAttr));

		final TypedFeature<Object> feature = featureContainer.getFeature(clAttr);
		final SessionContext lCtx = jaloSession.createSessionContext();
		for (final Map.Entry<Language, String> e : values.entrySet())
		{
			lCtx.setLanguage(e.getKey());
			feature.setValue(lCtx, e.getValue());
		}
		featureContainer.store();
	}

	ClassAttributeAssignment createClassificationAttribute() throws ConsistencyCheckException
	{
		final CatalogManager catalogManager = CatalogManager.getInstance();

		final ClassificationSystem clSys = catalogManager.createClassificationSystem("clsys");
		final ClassificationSystemVersion clSysVer = catalogManager
				.createClassificationSystemVersion(clSys, "ver", (Language) null);

		final ClassificationClass clClass = clSysVer.createClass("class");
		final ClassificationAttribute attr = clSysVer.createClassificationAttribute("terms");
		final ClassAttributeAssignment clAttr = clClass
				.assignAttribute(attr, ClassificationAttributeTypeEnum.STRING, null, null, 0);
		clAttr.setLocalized(true);

		return clAttr;
	}

	CatalogVersion createCatalogVersion(final String catId, final String versionId, final List<Language> languages)
	{
		final CatalogManager catalogManager = CatalogManager.getInstance();
		// get or create catalog
		Catalog cat = catalogManager.getCatalog(catId);
		if (cat == null)
		{
			cat = catalogManager.createCatalog(catId);
		}
		// create version
		final CatalogVersion catalogVersion = catalogManager.createCatalogVersion(cat, versionId, null);
		catalogVersion.setLanguages(languages);

		return catalogVersion;
	}

	List<Language> createLanguages(final int amount) throws ConsistencyCheckException
	{
		final C2LManager c2LManager = C2LManager.getInstance();
		final Language[] ret = new Language[amount];
		for (int i = 0; i < amount; i++)
		{
			ret[i] = c2LManager.createLanguage("LLL" + i);
		}
		return Arrays.asList(ret);
	}

}
