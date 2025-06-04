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
 * Representation of a Point of service
 */
@Schema(name="ASMPointOfService", description="Representation of a Point of service")
public  class ASMPointOfServiceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Display name of the point of service<br/><br/><i>Generated property</i> for <code>ASMPointOfServiceWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Display name of the point of service", example="Nakano") 	
	private String name;

	/** The identifier of the point of service<br/><br/><i>Generated property</i> for <code>ASMPointOfServiceWsDTO.id</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="id", description="The identifier of the point of service", example="NAKANO") 	
	private String id;
	
	public ASMPointOfServiceWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	

}