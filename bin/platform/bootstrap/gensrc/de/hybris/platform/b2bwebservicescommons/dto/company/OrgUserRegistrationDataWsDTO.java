/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of data used for user registration operations. Consists of fields used to apply to create new
			customer
		
 */
@Schema(name="OrgUserRegistrationData", description="Representation of data used for user registration operations. Consists of fields used to apply to create new customer")
public  class OrgUserRegistrationDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the user's title<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.titleCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="titleCode", description="Code of the user's title", required=false, example="mr") 	
	private String titleCode;

	/** First name of the user<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.firstName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="firstName", description="First name of the user", required=true, example="akiro") 	
	private String firstName;

	/** Last name of the user<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.lastName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="lastName", description="Last name of the user", required=true, example="nakamura") 	
	private String lastName;

	/** Email of the user<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.email</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="email", description="Email of the user", required=true, example="akiro.nakamura@rustic-hw.com") 	
	private String email;

	/** Contains info to approver, usually composed by UI with a template<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.message</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="message", description="Contains info to approver, usually composed by UI with a template", required=false, example="Please create a new account for me. Department: Ground support; Position: Chief safeguard; Report to: Steve Jackson.") 	
	private String message;

	/** Authentication identifier of a new B2B customer registration. Only needed when OTP for registration is enabled.<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.verificationTokenId</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="verificationTokenId", description="Authentication identifier of a new B2B customer registration. Only needed when OTP for registration is enabled.", required=false, example="<REG[nZbnrnhMWy2uBbzKWU/SQRVBZ7mJaiXX9/87PegvovM=]>") 	
	private String verificationTokenId;

	/** Code included in the email sent to the customer to be registered. Only needed when OTP for registration is enabled.<br/><br/><i>Generated property</i> for <code>OrgUserRegistrationDataWsDTO.verificationTokenCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="verificationTokenCode", description="Code included in the email sent to the customer to be registered. Only needed when OTP for registration is enabled.", required=false, example="W2Lihg36") 	
	private String verificationTokenCode;
	
	public OrgUserRegistrationDataWsDTO()
	{
		// default constructor
	}
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
	}
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setVerificationTokenId(final String verificationTokenId)
	{
		this.verificationTokenId = verificationTokenId;
	}

	public String getVerificationTokenId() 
	{
		return verificationTokenId;
	}
	
	public void setVerificationTokenCode(final String verificationTokenCode)
	{
		this.verificationTokenCode = verificationTokenCode;
	}

	public String getVerificationTokenCode() 
	{
		return verificationTokenCode;
	}
	

}