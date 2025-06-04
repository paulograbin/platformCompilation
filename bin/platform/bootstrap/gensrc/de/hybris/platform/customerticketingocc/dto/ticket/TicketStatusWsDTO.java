/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Ticket status details.
 */
@Schema(name="TicketStatus", description="Ticket status details.")
public  class TicketStatusWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Localized ticket status name.<br/><br/><i>Generated property</i> for <code>TicketStatusWsDTO.name</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="name", description="Localized ticket status name.", example="Closed") 	
	private String name;

	/** Ticket status identifier.<br/><br/><i>Generated property</i> for <code>TicketStatusWsDTO.id</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="id", description="Ticket status identifier.", required=true, example="CLOSED") 	
	private String id;
	
	public TicketStatusWsDTO()
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