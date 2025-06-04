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
 * Representation of the input for binding/unbinding a mobile number for a customer.
 */
@Schema(name="ReplaceMobileNumberInput", description="Representation of the input for binding/unbinding a mobile number for a customer.")
public  class ReplaceMobileNumberInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer's mobile number.<br/><br/><i>Generated property</i> for <code>ReplaceMobileNumberInputWsDTO.mobileNumber</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="mobileNumber", description="Customer's mobile number.", required=false, example="+86 12345678901") 	
	private String mobileNumber;

	/** Verification code.<br/><br/><i>Generated property</i> for <code>ReplaceMobileNumberInputWsDTO.verificationCode</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="verificationCode", description="Verification code.", required=true, example="1234") 	
	private String verificationCode;
	
	public ReplaceMobileNumberInputWsDTO()
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
	
	public void setVerificationCode(final String verificationCode)
	{
		this.verificationCode = verificationCode;
	}

	public String getVerificationCode() 
	{
		return verificationCode;
	}
	

}