/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.facetdata;

import de.hybris.platform.commercewebservicescommons.dto.product.CategoryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.ProductSearchPageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation od a Product Category Search Page
 */
@Schema(name="ProductCategorySearchPage", description="Representation od a Product Category Search Page")
public  class ProductCategorySearchPageWsDTO extends ProductSearchPageWsDTO 

{



	/** List of subcategories<br/><br/><i>Generated property</i> for <code>ProductCategorySearchPageWsDTO.subCategories</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="subCategories", description="List of subcategories") 	
	private List<CategoryWsDTO> subCategories;
	
	public ProductCategorySearchPageWsDTO()
	{
		// default constructor
	}
	
	public void setSubCategories(final List<CategoryWsDTO> subCategories)
	{
		this.subCategories = subCategories;
	}

	public List<CategoryWsDTO> getSubCategories() 
	{
		return subCategories;
	}
	

}