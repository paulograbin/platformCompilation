/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of ticket results.
 */
@Schema(name="TicketList", description="List of ticket results.")
public  class TicketListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of tickets.<br/><br/><i>Generated property</i> for <code>TicketListWsDTO.tickets</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="tickets", description="List of tickets.") 	
	private List<TicketWsDTO> tickets;

	/** Pagination of ticket list.<br/><br/><i>Generated property</i> for <code>TicketListWsDTO.pagination</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="pagination", description="Pagination of ticket list.") 	
	private PaginationWsDTO pagination;

	/** Ticket list sorting details.<br/><br/><i>Generated property</i> for <code>TicketListWsDTO.sorts</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="sorts", description="Ticket list sorting details.") 	
	private List<SortWsDTO> sorts;
	
	public TicketListWsDTO()
	{
		// default constructor
	}
	
	public void setTickets(final List<TicketWsDTO> tickets)
	{
		this.tickets = tickets;
	}

	public List<TicketWsDTO> getTickets() 
	{
		return tickets;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	

}