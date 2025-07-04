/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the cms item search.
 */
@Schema(name="CMSItemSearchWsDTO", description="Specifies properties of the cms item search.")
public  class CMSItemSearchWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.mask</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="mask") 	
	private String mask;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.typeCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="typeCode", example="CMSParagraphComponent") 	
	private String typeCode;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.typeCodes</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="typeCodes", example="[\"CMSParagraphComponent\", \"CMSLinkComponent\"]") 	
	private String typeCodes;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.catalogId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogVersion", example="Staged") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.itemSearchParams</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemSearchParams") 	
	private String itemSearchParams;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.fields</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="fields") 	
	private String fields;
	
	public CMSItemSearchWsDTO()
	{
		// default constructor
	}
	
	public void setMask(final String mask)
	{
		this.mask = mask;
	}

	public String getMask() 
	{
		return mask;
	}
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	
	public void setTypeCodes(final String typeCodes)
	{
		this.typeCodes = typeCodes;
	}

	public String getTypeCodes() 
	{
		return typeCodes;
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
	
	public void setItemSearchParams(final String itemSearchParams)
	{
		this.itemSearchParams = itemSearchParams;
	}

	public String getItemSearchParams() 
	{
		return itemSearchParams;
	}
	
	public void setFields(final String fields)
	{
		this.fields = fields;
	}

	public String getFields() 
	{
		return fields;
	}
	

}