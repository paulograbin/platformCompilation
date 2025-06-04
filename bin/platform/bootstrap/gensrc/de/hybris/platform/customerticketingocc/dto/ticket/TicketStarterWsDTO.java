/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketAssociatedObjectWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketCategoryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Basic information about the ticket.
 */
@Schema(name="TicketStarter", description="Basic information about the ticket.")
public  class TicketStarterWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Subject of ticket.<br/><br/><i>Generated property</i> for <code>TicketStarterWsDTO.subject</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="subject", description="Subject of ticket.", required=true, example="My drill is broken.") 	
	private String subject;

	/** Detailed description of the question.<br/><br/><i>Generated property</i> for <code>TicketStarterWsDTO.message</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="message", description="Detailed description of the question.", required=true, example="The drill was damaged when I received it. Could you please send me a replacement?") 	
	private String message;

	/** <i>Generated property</i> for <code>TicketStarterWsDTO.ticketCategory</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="ticketCategory") 	
	private TicketCategoryWsDTO ticketCategory;

	/** <i>Generated property</i> for <code>TicketStarterWsDTO.associatedTo</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="associatedTo") 	
	private TicketAssociatedObjectWsDTO associatedTo;
	
	public TicketStarterWsDTO()
	{
		// default constructor
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setTicketCategory(final TicketCategoryWsDTO ticketCategory)
	{
		this.ticketCategory = ticketCategory;
	}

	public TicketCategoryWsDTO getTicketCategory() 
	{
		return ticketCategory;
	}
	
	public void setAssociatedTo(final TicketAssociatedObjectWsDTO associatedTo)
	{
		this.associatedTo = associatedTo;
	}

	public TicketAssociatedObjectWsDTO getAssociatedTo() 
	{
		return associatedTo;
	}
	

}