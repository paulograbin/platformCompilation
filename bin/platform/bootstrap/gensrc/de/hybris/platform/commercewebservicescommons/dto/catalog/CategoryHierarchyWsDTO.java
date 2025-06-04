/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import de.hybris.platform.commercewebservicescommons.dto.catalog.AbstractCatalogItemWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CategoryHierarchyWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Category Hierarchy
 */
@Schema(name="CategoryHierarchy", description="Representation of a Category Hierarchy")
public  class CategoryHierarchyWsDTO extends AbstractCatalogItemWsDTO 

{



	/** List of subcategory hierarchies<br/><br/><i>Generated property</i> for <code>CategoryHierarchyWsDTO.subcategories</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="subcategories", description="List of subcategory hierarchies") 	
	private List<CategoryHierarchyWsDTO> subcategories;

	/** <i>Generated property</i> for <code>CategoryHierarchyWsDTO.products</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="products") 	
	private List<ProductWsDTO> products;
	
	public CategoryHierarchyWsDTO()
	{
		// default constructor
	}
	
	public void setSubcategories(final List<CategoryHierarchyWsDTO> subcategories)
	{
		this.subcategories = subcategories;
	}

	public List<CategoryHierarchyWsDTO> getSubcategories() 
	{
		return subcategories;
	}
	
	public void setProducts(final List<ProductWsDTO> products)
	{
		this.products = products;
	}

	public List<ProductWsDTO> getProducts() 
	{
		return products;
	}
	

}