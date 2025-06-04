/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.permissionswebservices.dto.PermissionsWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of permissions
 */
@Schema(name="PermissionsList", description="List of permissions")
public  class PermissionsListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PermissionsListWsDTO.permissionsList</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="permissionsList") 	
	private List<PermissionsWsDTO> permissionsList;
	
	public PermissionsListWsDTO()
	{
		// default constructor
	}
	
	public void setPermissionsList(final List<PermissionsWsDTO> permissionsList)
	{
		this.permissionsList = permissionsList;
	}

	public List<PermissionsWsDTO> getPermissionsList() 
	{
		return permissionsList;
	}
	

}