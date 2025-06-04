/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import de.hybris.platform.b2bwebservicescommons.dto.company.OrgCustomerCreationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of data used for user modification operations. Consists of fields used to modify customer
 */
@Schema(name="OrgCustomerModification", description="Representation of data used for user modification operations. Consists of fields used to modify customer")
public  class OrgCustomerModificationWsDTO extends OrgCustomerCreationWsDTO 

{



	/** Boolean flag of whether the user is active/enabled or not<br/><br/><i>Generated property</i> for <code>OrgCustomerModificationWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="active", description="Boolean flag of whether the user is active/enabled or not", example="true") 	
	private Boolean active;

	/** Password of the user<br/><br/><i>Generated property</i> for <code>OrgCustomerModificationWsDTO.password</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="password", description="Password of the user") 	
	private String password;
	
	public OrgCustomerModificationWsDTO()
	{
		// default constructor
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
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