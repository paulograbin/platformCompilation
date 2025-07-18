/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.HomePageData;
import java.util.List;
import java.util.Map;


import java.util.Objects;
public  class CatalogVersionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogVersionData.name</code> property defined at extension <code>cmsfacades</code>. */
	
	private Map<String, String> name;

	/** <i>Generated property</i> for <code>CatalogVersionData.active</code> property defined at extension <code>cmsfacades</code>. */
	
	private Boolean active;

	/** <i>Generated property</i> for <code>CatalogVersionData.pageDisplayConditions</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<DisplayConditionData> pageDisplayConditions;

	/** <i>Generated property</i> for <code>CatalogVersionData.version</code> property defined at extension <code>cmsfacades</code>. */
	
	private String version;

	/** <i>Generated property</i> for <code>CatalogVersionData.thumbnailUrl</code> property defined at extension <code>cmsfacades</code>. */
	
	private String thumbnailUrl;

	/** <i>Generated property</i> for <code>CatalogVersionData.uuid</code> property defined at extension <code>cmsfacades</code>. */
	
	private String uuid;

	/** <i>Generated property</i> for <code>CatalogVersionData.homepage</code> property defined at extension <code>cmsfacades</code>. */
	
	private HomePageData homepage;
	
	public CatalogVersionData()
	{
		// default constructor
	}
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setPageDisplayConditions(final List<DisplayConditionData> pageDisplayConditions)
	{
		this.pageDisplayConditions = pageDisplayConditions;
	}

	public List<DisplayConditionData> getPageDisplayConditions() 
	{
		return pageDisplayConditions;
	}
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getVersion() 
	{
		return version;
	}
	
	public void setThumbnailUrl(final String thumbnailUrl)
	{
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl() 
	{
		return thumbnailUrl;
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setHomepage(final HomePageData homepage)
	{
		this.homepage = homepage;
	}

	public HomePageData getHomepage() 
	{
		return homepage;
	}
	

}