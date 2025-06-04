/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.permissionswebservices.dto.CatalogPermissionsWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Catalog permissions list
 */
@Schema(name="CatalogPermissionsList", description="Catalog permissions list")
public  class CatalogPermissionsListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogPermissionsListWsDTO.permissionsList</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="permissionsList") 	
	private List<CatalogPermissionsWsDTO> permissionsList;
	
	public CatalogPermissionsListWsDTO()
	{
		// default constructor
	}
	
	public void setPermissionsList(final List<CatalogPermissionsWsDTO> permissionsList)
	{
		this.permissionsList = permissionsList;
	}

	public List<CatalogPermissionsWsDTO> getPermissionsList() 
	{
		return permissionsList;
	}
	

}