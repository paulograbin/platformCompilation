/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import de.hybris.platform.commercewebservicescommons.dto.catalog.AbstractCatalogItemWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CategoryHierarchyWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of a Catalog Version
 */
@Schema(name="CatalogVersion", description="Representation of a Catalog Version")
public  class CatalogVersionWsDTO extends AbstractCatalogItemWsDTO 

{



	/** List of category hierarchies<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.categories</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="categories", description="List of category hierarchies") 	
	private Collection<CategoryHierarchyWsDTO> categories;
	
	public CatalogVersionWsDTO()
	{
		// default constructor
	}
	
	public void setCategories(final Collection<CategoryHierarchyWsDTO> categories)
	{
		this.categories = categories;
	}

	public Collection<CategoryHierarchyWsDTO> getCategories() 
	{
		return categories;
	}
	

}