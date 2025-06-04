/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a request of replacing an existing user's login id.
 */
@Schema(name="ReplaceLoginIdInput", description="Representation of a request of replacing an existing user's login id.")
public  class ReplaceLoginIdInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** New login id that is a unique string to identify a user.<br/><br/><i>Generated property</i> for <code>ReplaceLoginIdInputWsDTO.newLoginId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="newLoginId", description="New login id that is a unique string to identify a user.", required=true, example="mark.rivers@pronto-hw.com") 	
	private String newLoginId;

	/** User password<br/><br/><i>Generated property</i> for <code>ReplaceLoginIdInputWsDTO.password</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="password", description="User password", required=true, example="It'sMyPwd!0") 	
	private String password;
	
	public ReplaceLoginIdInputWsDTO()
	{
		// default constructor
	}
	
	public void setNewLoginId(final String newLoginId)
	{
		this.newLoginId = newLoginId;
	}

	public String getNewLoginId() 
	{
		return newLoginId;
	}
	
	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	

}