/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketAssociatedObjectWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketCategoryWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketEventWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketStatusWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Ticket object.
 */
@Schema(name="Ticket", description="Ticket object.")
public  class TicketWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Ticket identifier.<br/><br/><i>Generated property</i> for <code>TicketWsDTO.id</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="id", description="Ticket identifier.", example="00000001") 	
	private String id;

	/** Customer identifier.<br/><br/><i>Generated property</i> for <code>TicketWsDTO.customerId</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="customerId", description="Customer identifier.", example="1000001") 	
	private String customerId;

	/** Subject of ticket.<br/><br/><i>Generated property</i> for <code>TicketWsDTO.subject</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="subject", description="Subject of ticket.", example="My drill is broken.") 	
	private String subject;

	/** Date and time of ticket creation.<br/><br/><i>Generated property</i> for <code>TicketWsDTO.createdAt</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="createdAt", description="Date and time of ticket creation.", example="2021-01-13T10:06:57+0000") 	
	private Date createdAt;

	/** Date and time of last modification.<br/><br/><i>Generated property</i> for <code>TicketWsDTO.modifiedAt</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="modifiedAt", description="Date and time of last modification.", example="2021-01-13T10:06:57+0000") 	
	private Date modifiedAt;

	/** <i>Generated property</i> for <code>TicketWsDTO.availableStatusTransitions</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="availableStatusTransitions") 	
	private List<TicketStatusWsDTO> availableStatusTransitions;

	/** <i>Generated property</i> for <code>TicketWsDTO.associatedTo</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="associatedTo") 	
	private TicketAssociatedObjectWsDTO associatedTo;

	/** <i>Generated property</i> for <code>TicketWsDTO.status</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="status") 	
	private TicketStatusWsDTO status;

	/** <i>Generated property</i> for <code>TicketWsDTO.ticketEvents</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="ticketEvents") 	
	private List<TicketEventWsDTO> ticketEvents;

	/** <i>Generated property</i> for <code>TicketWsDTO.ticketCategory</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="ticketCategory") 	
	private TicketCategoryWsDTO ticketCategory;
	
	public TicketWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerId() 
	{
		return customerId;
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setCreatedAt(final Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}
	
	public void setModifiedAt(final Date modifiedAt)
	{
		this.modifiedAt = modifiedAt;
	}

	public Date getModifiedAt() 
	{
		return modifiedAt;
	}
	
	public void setAvailableStatusTransitions(final List<TicketStatusWsDTO> availableStatusTransitions)
	{
		this.availableStatusTransitions = availableStatusTransitions;
	}

	public List<TicketStatusWsDTO> getAvailableStatusTransitions() 
	{
		return availableStatusTransitions;
	}
	
	public void setAssociatedTo(final TicketAssociatedObjectWsDTO associatedTo)
	{
		this.associatedTo = associatedTo;
	}

	public TicketAssociatedObjectWsDTO getAssociatedTo() 
	{
		return associatedTo;
	}
	
	public void setStatus(final TicketStatusWsDTO status)
	{
		this.status = status;
	}

	public TicketStatusWsDTO getStatus() 
	{
		return status;
	}
	
	public void setTicketEvents(final List<TicketEventWsDTO> ticketEvents)
	{
		this.ticketEvents = ticketEvents;
	}

	public List<TicketEventWsDTO> getTicketEvents() 
	{
		return ticketEvents;
	}
	
	public void setTicketCategory(final TicketCategoryWsDTO ticketCategory)
	{
		this.ticketCategory = ticketCategory;
	}

	public TicketCategoryWsDTO getTicketCategory() 
	{
		return ticketCategory;
	}
	

}