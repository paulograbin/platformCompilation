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
import de.hybris.platform.permissionsfacades.data.PermissionsData;
import java.util.List;


import java.util.Objects;
public  class PermissionsDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PermissionsDataList.permissionsList</code> property defined at extension <code>permissionswebservices</code>. */
	
	private List<PermissionsData> permissionsList;
	
	public PermissionsDataList()
	{
		// default constructor
	}
	
	public void setPermissionsList(final List<PermissionsData> permissionsList)
	{
		this.permissionsList = permissionsList;
	}

	public List<PermissionsData> getPermissionsList() 
	{
		return permissionsList;
	}
	

}