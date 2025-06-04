/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import de.hybris.platform.commercewebservicescommons.dto.catalog.AbstractCatalogItemWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CatalogVersionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of a Catalog
 */
@Schema(name="Catalog", description="Representation of a Catalog")
public  class CatalogWsDTO extends AbstractCatalogItemWsDTO 

{



	/** List of versions of catalog<br/><br/><i>Generated property</i> for <code>CatalogWsDTO.catalogVersions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="catalogVersions", description="List of versions of catalog") 	
	private Collection<CatalogVersionWsDTO> catalogVersions;
	
	public CatalogWsDTO()
	{
		// default constructor
	}
	
	public void setCatalogVersions(final Collection<CatalogVersionWsDTO> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

	public Collection<CatalogVersionWsDTO> getCatalogVersions() 
	{
		return catalogVersions;
	}
	

}