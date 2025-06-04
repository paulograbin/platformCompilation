/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.verificationtoken;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.verificationtoken.VerificationPurposeWsDTOType;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of the input for creating a verification token.
 */
@Schema(name="CreateVerificationTokenInput", description="Representation of the input for creating a verification token.")
public  class CreateVerificationTokenInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Purpose for which the verification token is requested.<br/><br/><i>Generated property</i> for <code>CreateVerificationTokenInputWsDTO.purpose</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="purpose", description="Purpose for which the verification token is requested.", required=true) 	
	private VerificationPurposeWsDTOType purpose;

	/** User login identifier. Target to receive verification token code.<br/><br/><i>Generated property</i> for <code>CreateVerificationTokenInputWsDTO.loginId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="loginId", description="User login identifier. Target to receive verification token code.", required=true, example="keenreviewer@sap.com") 	
	private String loginId;

	/** User password to authenticate the request. This field is required when the purpose is LOGIN.<br/><br/><i>Generated property</i> for <code>CreateVerificationTokenInputWsDTO.password</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="password", description="User password to authenticate the request. This field is required when the purpose is LOGIN.", required=false, example="mypwd!0") 	
	private String password;
	
	public CreateVerificationTokenInputWsDTO()
	{
		// default constructor
	}
	
	public void setPurpose(final VerificationPurposeWsDTOType purpose)
	{
		this.purpose = purpose;
	}

	public VerificationPurposeWsDTOType getPurpose() 
	{
		return purpose;
	}
	
	public void setLoginId(final String loginId)
	{
		this.loginId = loginId;
	}

	public String getLoginId() 
	{
		return loginId;
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