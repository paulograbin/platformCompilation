/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;


import java.util.Objects;
/**
 * Permissions for catalog
 */
@Schema(name="CatalogPermissions", description="Permissions for catalog")
public  class CatalogPermissionsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Catalog identifier<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.catalogId</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="catalogId", description="Catalog identifier", required=true) 	
	private String catalogId;

	/** Catalog version identifier<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.catalogVersion</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="catalogVersion", description="Catalog version identifier", required=true) 	
	private String catalogVersion;

	/** Permissions map<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.permissions</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="permissions", description="Permissions map") 	
	private Map<String, String> permissions;

	/** Sync Permissions list<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.syncPermissions</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="syncPermissions", description="Sync Permissions list") 	
	private List<SyncPermissionsWsDTO> syncPermissions;
	
	public CatalogPermissionsWsDTO()
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
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setPermissions(final Map<String, String> permissions)
	{
		this.permissions = permissions;
	}

	public Map<String, String> getPermissions() 
	{
		return permissions;
	}
	
	public void setSyncPermissions(final List<SyncPermissionsWsDTO> syncPermissions)
	{
		this.syncPermissions = syncPermissions;
	}

	public List<SyncPermissionsWsDTO> getSyncPermissions() 
	{
		return syncPermissions;
	}
	

}