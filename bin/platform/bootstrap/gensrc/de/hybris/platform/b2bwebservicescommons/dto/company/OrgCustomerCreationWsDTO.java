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
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of data used for user creation operations. Consists of fields used to create customer
 */
@Schema(name="OrgCustomerCreation", description="Representation of data used for user creation operations. Consists of fields used to create customer")
public  class OrgCustomerCreationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Email of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.email</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="email", description="Email of the user", example="akiro.nakamura@rustic-hw.com") 	
	private String email;

	/** First name of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.firstName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="firstName", description="First name of the user", example="Akiro") 	
	private String firstName;

	/** Last name of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.lastName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="lastName", description="Last name of the user", example="Nakamura") 	
	private String lastName;

	/** Code of the user's title<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.titleCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="titleCode", description="Code of the user's title", example="mr") 	
	private String titleCode;

	/** The unit of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgUnit", description="The unit of the user") 	
	private B2BUnitWsDTO orgUnit;

	/** List of organizational approvers<br/><br/><i>Generated property</i> for <code>OrgCustomerCreationWsDTO.roles</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="roles", description="List of organizational approvers") 	
	private List<String> roles;
	
	public OrgCustomerCreationWsDTO()
	{
		// default constructor
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
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
	
	public void setOrgUnit(final B2BUnitWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public B2BUnitWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}

	public List<String> getRoles() 
	{
		return roles;
	}
	

}