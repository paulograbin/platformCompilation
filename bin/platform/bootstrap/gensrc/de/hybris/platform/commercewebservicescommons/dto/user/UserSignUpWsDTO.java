/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a UserSignUp. Consists of fields required to register a new customer
 */
@Schema(name="UserSignUp", description="Representation of a UserSignUp. Consists of fields required to register a new customer")
public  class UserSignUpWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** user id, unique string required to create new user. It can be email<br/><br/><i>Generated property</i> for <code>UserSignUpWsDTO.uid</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="uid", description="user id, unique string required to create new user. It can be email", required=true, example="akiro.nakamura@rustic-hw.com") 	
	private String uid;

	/** first name of the user<br/><br/><i>Generated property</i> for <code>UserSignUpWsDTO.firstName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="firstName", description="first name of the user", required=true, example="Arika") 	
	private String firstName;

	/** last name of the user<br/><br/><i>Generated property</i> for <code>UserSignUpWsDTO.lastName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="lastName", description="last name of the user", required=true, example="Nakamura") 	
	private String lastName;

	/** <i>Generated property</i> for <code>UserSignUpWsDTO.titleCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="titleCode", example="mr") 	
	private String titleCode;

	/** User password.<br/><br/><i>Generated property</i> for <code>UserSignUpWsDTO.password</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="password", description="User password.", required=true) 	
	private String password;

	/** Authentication identifier of a new B2C customer registration. Only needed when OTP for registration is enabled.<br/><br/><i>Generated property</i> for <code>UserSignUpWsDTO.verificationTokenId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="verificationTokenId", description="Authentication identifier of a new B2C customer registration. Only needed when OTP for registration is enabled.", required=false, example="<REG[nZbnrnhMWy2uBbzKWU/SQRVBZ7mJaiXX9/87PegvovM=]>") 	
	private String verificationTokenId;

	/** Code included in the email sent to the customer to be registered. Only needed when OTP for registration is enabled.<br/><br/><i>Generated property</i> for <code>UserSignUpWsDTO.verificationTokenCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="verificationTokenCode", description="Code included in the email sent to the customer to be registered. Only needed when OTP for registration is enabled.", required=false, example="W2Lihg36") 	
	private String verificationTokenCode;
	
	public UserSignUpWsDTO()
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
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
	}
	
	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
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