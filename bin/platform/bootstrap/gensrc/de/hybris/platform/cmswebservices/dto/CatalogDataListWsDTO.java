/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available catalog data.
 */
@Schema(name="CatalogDataListWsDTO", description="Specifies a list of available catalog data.")
public  class CatalogDataListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogDataListWsDTO.catalogIds</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogIds", example="[\"electronicsContentCatalog\", \"electronicsProductCatalog\"]") 	
	private List<String> catalogIds;
	
	public CatalogDataListWsDTO()
	{
		// default constructor
	}
	
	public void setCatalogIds(final List<String> catalogIds)
	{
		this.catalogIds = catalogIds;
	}

	public List<String> getCatalogIds() 
	{
		return catalogIds;
	}
	

}