/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import de.hybris.platform.commercewebservicescommons.dto.catalog.AbstractCatalogItemWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CategoryHierarchyWsDTO;
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
	

}