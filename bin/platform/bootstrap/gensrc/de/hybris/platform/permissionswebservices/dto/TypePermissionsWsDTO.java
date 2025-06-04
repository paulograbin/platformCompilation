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
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Type with CRUD permission assignment values.
 */
@Schema(name="TypePermissions", description="Type with CRUD permission assignment values.")
public  class TypePermissionsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** A Type specifying which type the permission assignment values are for.<br/><br/><i>Generated property</i> for <code>TypePermissionsWsDTO.type</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="type", description="A Type specifying which type the permission assignment values are for.", required=true) 	
	private String type;

	/** Type with CRUD permission assignment values.<br/><br/><i>Generated property</i> for <code>TypePermissionsWsDTO.permissions</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="permissions", description="Type with CRUD permission assignment values.", required=true) 	
	private PermissionValuesWsDTO permissions;
	
	public TypePermissionsWsDTO()
	{
		// default constructor
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setPermissions(final PermissionValuesWsDTO permissions)
	{
		this.permissions = permissions;
	}

	public PermissionValuesWsDTO getPermissions() 
	{
		return permissions;
	}
	

}