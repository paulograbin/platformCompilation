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
 * Representation of the input for sending a verification code.
 */
@Schema(name="SendVerificationCodeInput", description="Representation of the input for sending a verification code.")
public  class SendVerificationCodeInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer's mobile number. Target to receive verification code.<br/><br/><i>Generated property</i> for <code>SendVerificationCodeInputWsDTO.mobileNumber</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="mobileNumber", description="Customer's mobile number. Target to receive verification code.", required=true, example="+86 12345678901") 	
	private String mobileNumber;
	
	public SendVerificationCodeInputWsDTO()
	{
		// default constructor
	}
	
	public void setMobileNumber(final String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() 
	{
		return mobileNumber;
	}
	

}