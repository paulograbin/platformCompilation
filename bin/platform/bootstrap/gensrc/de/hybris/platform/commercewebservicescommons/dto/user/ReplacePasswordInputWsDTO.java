/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a request of replacing an existing user's password
 */
@Schema(name="ReplacePasswordInput", description="Representation of a request of replacing an existing user's password")
public  class ReplacePasswordInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Current password of the customer.<br/><br/><i>Generated property</i> for <code>ReplacePasswordInputWsDTO.oldPassword</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="oldPassword", description="Current password of the customer.", required=true, example="It'sMyPwd!0") 	
	private String oldPassword;

	/** New password of the customer.<br/><br/><i>Generated property</i> for <code>ReplacePasswordInputWsDTO.newPassword</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="newPassword", description="New password of the customer.", required=true, example="It'sMyPwd!1") 	
	private String newPassword;
	
	public ReplacePasswordInputWsDTO()
	{
		// default constructor
	}
	
	public void setOldPassword(final String oldPassword)
	{
		this.oldPassword = oldPassword;
	}

	public String getOldPassword() 
	{
		return oldPassword;
	}
	
	public void setNewPassword(final String newPassword)
	{
		this.newPassword = newPassword;
	}

	public String getNewPassword() 
	{
		return newPassword;
	}
	

}