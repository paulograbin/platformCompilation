/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CatalogWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Catalog List
 */
@Schema(name="CatalogList", description="Representation of a Catalog List")
public  class CatalogListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of catalog items<br/><br/><i>Generated property</i> for <code>CatalogListWsDTO.catalogs</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="catalogs", description="List of catalog items") 	
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