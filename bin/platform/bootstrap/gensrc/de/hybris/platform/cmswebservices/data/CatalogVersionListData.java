/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.CatalogVersionData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available catalog versions.
 */
@Schema(name="CatalogVersionListData", description="Specifies a list of available catalog versions.")
public  class CatalogVersionListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogVersionListData.versions</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="versions") 	
	private List<CatalogVersionData> versions;
	
	public CatalogVersionListData()
	{
		// default constructor
	}
	
	public void setVersions(final List<CatalogVersionData> versions)
	{
		this.versions = versions;
	}

	public List<CatalogVersionData> getVersions() 
	{
		return versions;
	}
	

}