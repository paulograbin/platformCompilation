/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Type of the activity
 */
@Schema(name="C360ActivityType", description="Type of the activity")
public  class C360ActivityTypeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type code of the activity, e.g. ORDER, TICKET, CART, ...<br/><br/><i>Generated property</i> for <code>C360ActivityTypeWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Type code of the activity, e.g. ORDER, TICKET, CART, ...", example="ORDER") 	
	private String code;

	/** Type name of the activity, e.g. Order, Ticket, Cart, ...<br/><br/><i>Generated property</i> for <code>C360ActivityTypeWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Type name of the activity, e.g. Order, Ticket, Cart, ...", example="Order") 	
	private String name;
	
	public C360ActivityTypeWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}