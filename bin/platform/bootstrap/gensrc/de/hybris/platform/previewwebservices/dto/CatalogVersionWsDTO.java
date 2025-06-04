/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.previewwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="catalogVersion")
public  class CatalogVersionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Catalog ID<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.catalog</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="catalog", description="Catalog ID", required=true) 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.catalogVersion</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="catalogVersion", description="Catalog version", required=true) 	
	private String catalogVersion;
	
	public CatalogVersionWsDTO()
	{
		// default constructor
	}
	
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}

	public String getCatalog() 
	{
		return catalog;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	

}