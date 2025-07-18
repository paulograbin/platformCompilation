/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * CRUD permission values for any specific principal and type.
 */
@Schema(name="PermissionValues", description="CRUD permission values for any specific principal and type.")
public  class PermissionValuesWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Specifies if permission to read the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesWsDTO.read</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="read", description="Specifies if permission to read the type should be granted.") 	
	private Boolean read;

	/** Specifies if permission to create the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesWsDTO.create</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="create", description="Specifies if permission to create the type should be granted.") 	
	private Boolean create;

	/** Specifies if permission to update the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesWsDTO.change</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="change", description="Specifies if permission to update the type should be granted.") 	
	private Boolean change;

	/** Specifies if permission to delete the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesWsDTO.remove</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="remove", description="Specifies if permission to delete the type should be granted.") 	
	private Boolean remove;

	/** Specifies if permission to change permissions on the type should be granted.<br/><br/><i>Generated property</i> for <code>PermissionValuesWsDTO.changerights</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="changerights", description="Specifies if permission to change permissions on the type should be granted.") 	
	private Boolean changerights;
	
	public PermissionValuesWsDTO()
	{
		// default constructor
	}
	
	public void setRead(final Boolean read)
	{
		this.read = read;
	}

	public Boolean getRead() 
	{
		return read;
	}
	
	public void setCreate(final Boolean create)
	{
		this.create = create;
	}

	public Boolean getCreate() 
	{
		return create;
	}
	
	public void setChange(final Boolean change)
	{
		this.change = change;
	}

	public Boolean getChange() 
	{
		return change;
	}
	
	public void setRemove(final Boolean remove)
	{
		this.remove = remove;
	}

	public Boolean getRemove() 
	{
		return remove;
	}
	
	public void setChangerights(final Boolean changerights)
	{
		this.changerights = changerights;
	}

	public Boolean getChangerights() 
	{
		return changerights;
	}
	

}