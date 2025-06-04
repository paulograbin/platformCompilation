/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketAssociatedObjectWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of ticket associated objects.
 */
@Schema(name="TicketAssociatedObjectList", description="List of ticket associated objects.")
public  class TicketAssociatedObjectListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketAssociatedObjectListWsDTO.ticketAssociatedObjects</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="ticketAssociatedObjects") 	
	private List<TicketAssociatedObjectWsDTO> ticketAssociatedObjects;
	
	public TicketAssociatedObjectListWsDTO()
	{
		// default constructor
	}
	
	public void setTicketAssociatedObjects(final List<TicketAssociatedObjectWsDTO> ticketAssociatedObjects)
	{
		this.ticketAssociatedObjects = ticketAssociatedObjects;
	}

	public List<TicketAssociatedObjectWsDTO> getTicketAssociatedObjects() 
	{
		return ticketAssociatedObjects;
	}
	

}