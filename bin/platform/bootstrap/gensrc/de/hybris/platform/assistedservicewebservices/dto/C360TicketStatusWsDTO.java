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
 * Status of the ticket
 */
@Schema(name="C360TicketStatus", description="Status of the ticket")
public  class C360TicketStatusWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Status code of the ticket, for example, New, Open, Closed.<br/><br/><i>Generated property</i> for <code>C360TicketStatusWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Status code of the ticket, for example, New, Open, Closed.", required=true, example="Open") 	
	private String code;

	/** Localized status name of the ticket, for example, New, Open, Closed.<br/><br/><i>Generated property</i> for <code>C360TicketStatusWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Localized status name of the ticket, for example, New, Open, Closed.", example="Open") 	
	private String name;
	
	public C360TicketStatusWsDTO()
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