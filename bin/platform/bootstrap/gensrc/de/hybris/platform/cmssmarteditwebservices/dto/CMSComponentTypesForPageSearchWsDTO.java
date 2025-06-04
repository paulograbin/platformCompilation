/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies information needed to search for valid component types in the given page.
 */
@Schema(name="CMSComponentTypesForPageSearchWsDTO", description="Specifies information needed to search for valid component types in the given page.")
public  class CMSComponentTypesForPageSearchWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSComponentTypesForPageSearchWsDTO.pageId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pageId") 	
	private String pageId;

	/** <i>Generated property</i> for <code>CMSComponentTypesForPageSearchWsDTO.mask</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="mask") 	
	private String mask;

	/** <i>Generated property</i> for <code>CMSComponentTypesForPageSearchWsDTO.langIsoCode</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="langIsoCode") 	
	private String langIsoCode;

	/** <i>Generated property</i> for <code>CMSComponentTypesForPageSearchWsDTO.readOnly</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="readOnly") 	
	private boolean readOnly;
	
	public CMSComponentTypesForPageSearchWsDTO()
	{
		// default constructor
	}
	
	public void setPageId(final String pageId)
	{
		this.pageId = pageId;
	}

	public String getPageId() 
	{
		return pageId;
	}
	
	public void setMask(final String mask)
	{
		this.mask = mask;
	}

	public String getMask() 
	{
		return mask;
	}
	
	public void setLangIsoCode(final String langIsoCode)
	{
		this.langIsoCode = langIsoCode;
	}

	public String getLangIsoCode() 
	{
		return langIsoCode;
	}
	
	public void setReadOnly(final boolean readOnly)
	{
		this.readOnly = readOnly;
	}

	public boolean isReadOnly() 
	{
		return readOnly;
	}
	

}