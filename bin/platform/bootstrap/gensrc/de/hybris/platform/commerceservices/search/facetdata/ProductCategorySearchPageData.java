/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.facetdata;

import de.hybris.platform.commerceservices.search.facetdata.ProductSearchPageData;
import java.util.List;


import java.util.Objects;
/**
 * POJO containing the result page for product or category search.
 */
public  class ProductCategorySearchPageData<STATE, RESULT, CATEGORY> extends ProductSearchPageData<STATE, RESULT> 

{



	/** <i>Generated property</i> for <code>ProductCategorySearchPageData<STATE, RESULT, CATEGORY>.subCategories</code> property defined at extension <code>commerceservices</code>. */
	
	private List<CATEGORY> subCategories;
	
	public ProductCategorySearchPageData()
	{
		// default constructor
	}
	
	public void setSubCategories(final List<CATEGORY> subCategories)
	{
		this.subCategories = subCategories;
	}

	public List<CATEGORY> getSubCategories() 
	{
		return subCategories;
	}
	

}