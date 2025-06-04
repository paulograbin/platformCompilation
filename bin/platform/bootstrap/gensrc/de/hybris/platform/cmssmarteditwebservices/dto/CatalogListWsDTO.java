/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:37 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.CatalogWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of catalogs
 */
@Schema(name="CatalogListWsDTO", description="List of catalogs")
public  class CatalogListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogListWsDTO.catalogs</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="catalogs") 	
	private List<CatalogWsDTO> catalogs;
	
	public CatalogListWsDTO()
	{
		// default constructor
	}
	
	public void setCatalogs(final List<CatalogWsDTO> catalogs)
	{
		this.catalogs = catalogs;
	}

	public List<CatalogWsDTO> getCatalogs() 
	{
		return catalogs;
	}
	

}