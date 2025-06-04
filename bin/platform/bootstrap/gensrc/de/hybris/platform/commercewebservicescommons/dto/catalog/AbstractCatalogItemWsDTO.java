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
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of an Abstract Catalog Item
 */
@Schema(name="AbstractCatalogItem", description="Representation of an Abstract Catalog Item")
public  class AbstractCatalogItemWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Identifier of abstract catalog item<br/><br/><i>Generated property</i> for <code>AbstractCatalogItemWsDTO.id</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="id", description="Identifier of abstract catalog item") 	
	private String id;

	/** Date of last modification<br/><br/><i>Generated property</i> for <code>AbstractCatalogItemWsDTO.lastModified</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="lastModified", description="Date of last modification") 	
	private Date lastModified;

	/** Name of abstract catalog item<br/><br/><i>Generated property</i> for <code>AbstractCatalogItemWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of abstract catalog item") 	
	private String name;

	/** Url address of abstract catalog item<br/><br/><i>Generated property</i> for <code>AbstractCatalogItemWsDTO.url</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="url", description="Url address of abstract catalog item") 	
	private String url;
	
	public AbstractCatalogItemWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setLastModified(final Date lastModified)
	{
		this.lastModified = lastModified;
	}

	public Date getLastModified() 
	{
		return lastModified;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	

}