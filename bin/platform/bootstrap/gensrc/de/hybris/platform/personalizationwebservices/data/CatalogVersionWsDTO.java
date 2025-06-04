/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Catalog version
 */
@Schema(name="CatalogVersion", description="Catalog version")
public  class CatalogVersionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.catalog</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="catalog", description="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.version</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="version", description="Catalog version") 	
	private String version;
	
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
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getVersion() 
	{
		return version;
	}
	

}