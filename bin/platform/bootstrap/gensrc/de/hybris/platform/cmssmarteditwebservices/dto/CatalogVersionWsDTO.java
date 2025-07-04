/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.DisplayConditionData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="catalogVersion")
public  class CatalogVersionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogVersionWsDTO.active</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="active") 	
	private Boolean active;

	/** <i>Generated property</i> for <code>CatalogVersionWsDTO.pageDisplayConditions</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pageDisplayConditions") 	
	private List<DisplayConditionData> pageDisplayConditions;

	/** <i>Generated property</i> for <code>CatalogVersionWsDTO.thumbnailUrl</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="thumbnailUrl") 	
	private String thumbnailUrl;

	/** <i>Generated property</i> for <code>CatalogVersionWsDTO.version</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="version") 	
	private String version;

	/** <i>Generated property</i> for <code>CatalogVersionWsDTO.uuid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>CatalogVersionWsDTO.homepage</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="homepage") 	
	private HomePageWsDTO homepage;
	
	public CatalogVersionWsDTO()
	{
		// default constructor
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
	
	public void setThumbnailUrl(final String thumbnailUrl)
	{
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl() 
	{
		return thumbnailUrl;
	}
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getVersion() 
	{
		return version;
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setHomepage(final HomePageWsDTO homepage)
	{
		this.homepage = homepage;
	}

	public HomePageWsDTO getHomepage() 
	{
		return homepage;
	}
	

}