/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the site.
 */
@Schema(name="SiteData", description="Specifies properties of the site.")
public  class SiteData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SiteData.uid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uid", example="apparel-de") 	
	private String uid;

	/** <i>Generated property</i> for <code>SiteData.previewUrl</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="previewUrl", example="/storefront/?site=apparel-de") 	
	private String previewUrl;

	/** <i>Generated property</i> for <code>SiteData.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name", example="{\"en\" : \"Apparel Site DE\", \"de\" : \"Bekleidungs-Website DE\"}") 	
	private Map<String, String> name;

	/** <i>Generated property</i> for <code>SiteData.contentCatalogs</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="contentCatalogs", example="[\"apparel-deContentCatalog\"]") 	
	private List<String> contentCatalogs;
	
	public SiteData()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setPreviewUrl(final String previewUrl)
	{
		this.previewUrl = previewUrl;
	}

	public String getPreviewUrl() 
	{
		return previewUrl;
	}
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	
	public void setContentCatalogs(final List<String> contentCatalogs)
	{
		this.contentCatalogs = contentCatalogs;
	}

	public List<String> getContentCatalogs() 
	{
		return contentCatalogs;
	}
	

}