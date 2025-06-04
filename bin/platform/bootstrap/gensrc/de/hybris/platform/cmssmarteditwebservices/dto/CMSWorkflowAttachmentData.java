/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the CMS workflow attachment data.
 */
@Schema(name="CMSWorkflowAttachmentData", description="Specifies properties of the CMS workflow attachment data.")
public  class CMSWorkflowAttachmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.pageUid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pageUid", example="homepage") 	
	private String pageUid;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.pageName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pageName", example="Homepage") 	
	private String pageName;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="catalogName", example="{\"en\": \"Electronics Content Catalog\", \"de\": \"Elektronikkatalog\"}") 	
	private Map<String,String> catalogName;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="catalogVersion", example="Staged") 	
	private String catalogVersion;
	
	public CMSWorkflowAttachmentData()
	{
		// default constructor
	}
	
	public void setPageUid(final String pageUid)
	{
		this.pageUid = pageUid;
	}

	public String getPageUid() 
	{
		return pageUid;
	}
	
	public void setPageName(final String pageName)
	{
		this.pageName = pageName;
	}

	public String getPageName() 
	{
		return pageName;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogName(final Map<String,String> catalogName)
	{
		this.catalogName = catalogName;
	}

	public Map<String,String> getCatalogName() 
	{
		return catalogName;
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