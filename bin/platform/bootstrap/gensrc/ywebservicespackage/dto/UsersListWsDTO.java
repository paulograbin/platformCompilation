/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import ywebservicespackage.dto.UserWsDTO;


import java.util.Objects;
/**
 * User list
 */
@Schema(name="usersList", description="User list")
public  class UsersListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UsersListWsDTO.users</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="users") 	
	private List<UserWsDTO> users;
	
	public UsersListWsDTO()
	{
		// default constructor
	}
	
	public void setUsers(final List<UserWsDTO> users)
	{
		this.users = users;
	}

	public List<UserWsDTO> getUsers() 
	{
		return users;
	}
	

}