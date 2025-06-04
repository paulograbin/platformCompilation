/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketCategoryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of ticket categories.
 */
@Schema(name="TicketCategoryList", description="List of ticket categories.")
public  class TicketCategoryListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketCategoryListWsDTO.ticketCategories</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="ticketCategories") 	
	private List<TicketCategoryWsDTO> ticketCategories;
	
	public TicketCategoryListWsDTO()
	{
		// default constructor
	}
	
	public void setTicketCategories(final List<TicketCategoryWsDTO> ticketCategories)
	{
		this.ticketCategories = ticketCategories;
	}

	public List<TicketCategoryWsDTO> getTicketCategories() 
	{
		return ticketCategories;
	}
	

}