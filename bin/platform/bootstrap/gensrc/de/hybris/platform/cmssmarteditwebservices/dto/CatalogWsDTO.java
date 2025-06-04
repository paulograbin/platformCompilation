/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.CatalogHierarchyWsDTO;
import de.hybris.platform.cmssmarteditwebservices.dto.CatalogVersionWsDTO;
import de.hybris.platform.cmssmarteditwebservices.dto.SiteWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;


import java.util.Objects;
/**
 * Catalog DTO
 */
@Schema(name="catalog", description="Catalog DTO")
public  class CatalogWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogWsDTO.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogWsDTO.name</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="name") 	
	private Map<String, String> name;

	/** <i>Generated property</i> for <code>CatalogWsDTO.versions</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="versions") 	
	private List<CatalogVersionWsDTO> versions;

	/** <i>Generated property</i> for <code>CatalogWsDTO.parents</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="parents") 	
	private List<CatalogHierarchyWsDTO> parents;

	/** <i>Generated property</i> for <code>CatalogWsDTO.sites</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="sites") 	
	private List<SiteWsDTO> sites;
	
	public CatalogWsDTO()
	{
		// default constructor
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	
	public void setVersions(final List<CatalogVersionWsDTO> versions)
	{
		this.versions = versions;
	}

	public List<CatalogVersionWsDTO> getVersions() 
	{
		return versions;
	}
	
	public void setParents(final List<CatalogHierarchyWsDTO> parents)
	{
		this.parents = parents;
	}

	public List<CatalogHierarchyWsDTO> getParents() 
	{
		return parents;
	}
	
	public void setSites(final List<SiteWsDTO> sites)
	{
		this.sites = sites;
	}

	public List<SiteWsDTO> getSites() 
	{
		return sites;
	}
	

}