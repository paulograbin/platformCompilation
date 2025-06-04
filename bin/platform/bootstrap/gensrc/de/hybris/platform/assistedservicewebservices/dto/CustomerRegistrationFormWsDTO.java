/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a CustomerRegistrationForm. Consists of fields required to register a new customer and is only used for ASM service.
 */
@Schema(name="CustomerRegistrationForm", description="Representation of a CustomerRegistrationForm. Consists of fields required to register a new customer and is only used for ASM service.")
public  class CustomerRegistrationFormWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** First name of the customer.<br/><br/><i>Generated property</i> for <code>CustomerRegistrationFormWsDTO.firstName</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="firstName", description="First name of the customer.", required=true, example="Brande") 	
	private String firstName;

	/** Last name of the customer.<br/><br/><i>Generated property</i> for <code>CustomerRegistrationFormWsDTO.lastName</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="lastName", description="Last name of the customer.", required=true, example="Smith") 	
	private String lastName;

	/** An email address required to create a new customer.<br/><br/><i>Generated property</i> for <code>CustomerRegistrationFormWsDTO.emailAddress</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="emailAddress", description="An email address required to create a new customer.", required=true, example="brande.smith@sap.com") 	
	private String emailAddress;
	
	public CustomerRegistrationFormWsDTO()
	{
		// default constructor
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
	
	public void setEmailAddress(final String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() 
	{
		return emailAddress;
	}
	

}