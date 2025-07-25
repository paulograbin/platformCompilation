/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.data;

import java.io.Serializable;
import java.util.List;
import ywebservicespackage.data.UserData;


import java.util.Objects;
public  class UserDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserDataList.users</code> property defined at extension <code>ywebservices</code>. */
	
	private List<UserData> users;
	
	public UserDataList()
	{
		// default constructor
	}
	
	public void setUsers(final List<UserData> users)
	{
		this.users = users;
	}

	public List<UserData> getUsers() 
	{
		return users;
	}
	

}