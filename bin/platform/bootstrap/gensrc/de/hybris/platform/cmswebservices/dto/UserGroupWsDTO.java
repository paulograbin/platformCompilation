/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the user group.
 */
@Schema(name="UserGroupWsDTO", description="Specifies properties of the user group.")
public  class UserGroupWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserGroupWsDTO.uid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uid", example="admin") 	
	private String uid;

	/** <i>Generated property</i> for <code>UserGroupWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name") 	
	private Map<String, String> name;
	
	public UserGroupWsDTO()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	

}