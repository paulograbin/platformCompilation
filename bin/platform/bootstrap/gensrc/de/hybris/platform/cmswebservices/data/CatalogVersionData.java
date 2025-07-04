/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies properties of the content catalog version.
 */
@Schema(name="CatalogVersionData", description="Specifies properties of the content catalog version.")
public  class CatalogVersionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogVersionData.uid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uid", example="electronicsContentCatalog/Staged") 	
	private String uid;

	/** <i>Generated property</i> for <code>CatalogVersionData.version</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="version", example="Staged") 	
	private String version;

	/** <i>Generated property</i> for <code>CatalogVersionData.active</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="active", example="false") 	
	private Boolean active;

	/** <i>Generated property</i> for <code>CatalogVersionData.pageDisplayConditions</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageDisplayConditions", example="[{\"typecode\" : \"ProductPage\", \"options\" : {\"id\" : \"VARIATION\", \"label\" : \"page.displaycondition.variation\"}}]") 	
	private List<DisplayConditionData> pageDisplayConditions;
	
	public CatalogVersionData()
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
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getVersion() 
	{
		return version;
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
	

}