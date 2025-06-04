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
 * Representation of information for sending a token to restore a forgotten password.
 */
@Schema(name="PasswordRestoreTokenInput", description="Representation of information for sending a token to restore a forgotten password.")
public  class PasswordRestoreTokenInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** User login identifier. Target to receive the token.<br/><br/><i>Generated property</i> for <code>PasswordRestoreTokenInputWsDTO.loginId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="loginId", description="User login identifier. Target to receive the token.", required=true, example="keenreviewer@sap.com") 	
	private String loginId;
	
	public PasswordRestoreTokenInputWsDTO()
	{
		// default constructor
	}
	
	public void setLoginId(final String loginId)
	{
		this.loginId = loginId;
	}

	public String getLoginId() 
	{
		return loginId;
	}
	

}