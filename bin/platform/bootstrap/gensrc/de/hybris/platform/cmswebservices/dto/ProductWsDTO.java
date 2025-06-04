/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the product.
 */
@Schema(name="ProductWsDTO", description="Specifies properties of the product.")
public  class ProductWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="489702") 	
	private String code;

	/** <i>Generated property</i> for <code>ProductWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>ProductWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="description") 	
	private Map<String,String> description;

	/** <i>Generated property</i> for <code>ProductWsDTO.thumbnailMediaCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="thumbnailMediaCode") 	
	private String thumbnailMediaCode;

	/** <i>Generated property</i> for <code>ProductWsDTO.catalogId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>ProductWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogVersion", example="Online") 	
	private String catalogVersion;
	
	public ProductWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

	public Map<String,String> getName() 
	{
		return name;
	}
	
	public void setDescription(final Map<String,String> description)
	{
		this.description = description;
	}

	public Map<String,String> getDescription() 
	{
		return description;
	}
	
	public void setThumbnailMediaCode(final String thumbnailMediaCode)
	{
		this.thumbnailMediaCode = thumbnailMediaCode;
	}

	public String getThumbnailMediaCode() 
	{
		return thumbnailMediaCode;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
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