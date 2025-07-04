/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.KeywordModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;

import org.apache.commons.lang.NotImplementedException;

/**
 * Provides access to Keyword.
 * <p>
 * A keyword can be used to allow convenient searches on catalog elements. Keywords are bound to the catalog elements
 * {@link CategoryModel} and {@link ProductModel}.
 *
 * @spring.bean keywordService
 */
public interface KeywordService
{

	/**
	 * Returns the Keyword for the specified keyword value and <code>CatalogVersion</code>.
	 *
	 * @param catalogVersion The <code>CatalogVersion</code> the <code>Keyword</code> belongs to.
	 * @param keywordValue   The value of the searched <code>Keyword</code>.
	 * @return The matching <code>Keyword</code>.
	 * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException   when keyword not found.
	 * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException when more than one found.
	 */
	KeywordModel getKeyword(final CatalogVersionModel catalogVersion, final String keywordValue);


	/**
	 * Returns the Keyword for the specified keyword value and <code>CatalogVersion</code>.
	 *
	 * @param typeCode       The code of type (or subtype) of keyword to allow to search for subclasses
	 * @param catalogVersion The <code>CatalogVersion</code> the <code>Keyword</code> belongs to.
	 * @param keywordValue   The value of the searched <code>Keyword</code>.
	 * @return The matching <code>Keyword</code>.
	 * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException   when keyword not found.
	 * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException when more than one found.
	 */
	KeywordModel getKeyword(String typeCode, CatalogVersionModel catalogVersion, String keywordValue);

	/**
	 * Returns the Keyword for the specified keyword value, <code>CatalogVersion</code> and <code>Language</code>.
	 *
	 * @param catalogVersion The <code>CatalogVersion</code> the <code>Keyword</code> belongs to.
	 * @param keywordValue   The value of the searched <code>Keyword</code>.
	 * @param language       The <code>Language</code> the <code>Keyword</code> is in.
	 * @return The matching <code>Keyword</code>.
	 * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException   when keyword not found.
	 * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException when more than one found.
	 * @throws org.apache.commons.lang.NotImplementedException                         when method is not implemented.
	 */
	default KeywordModel getKeyword(final CatalogVersionModel catalogVersion, final String keywordValue,
	                                final LanguageModel language)
	{
		throw new NotImplementedException();
	}
}
