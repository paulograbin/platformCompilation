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
import de.hybris.platform.customerticketingocc.dto.ticket.TicketEventAttachmentWsDTO;
import de.hybris.platform.customerticketingocc.dto.ticket.TicketStatusWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Ticket event object.
 */
@Schema(name="TicketEvent", description="Ticket event object.")
public  class TicketEventWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Event code is specific to each event. It is used to identify an event.<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.code</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="code", description="Event code is specific to each event. It is used to identify an event.", example="00000A15") 	
	private String code;

	/** Name of user who created this ticket event.<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.author</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="author", description="Name of user who created this ticket event.", example="Mark Rivers") 	
	private String author;

	/** Date and time of event creation.<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.createdAt</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="createdAt", description="Date and time of event creation.", example="2021-01-13T10:06:57+0000") 	
	private Date createdAt;

	/** Detailed description of the question.<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.message</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="message", description="Detailed description of the question.", required=true, example="The drill was damaged when I received it. Could you please send me a replacement?") 	
	private String message;

	/** Whether an agent added this event.<br/><br/><i>Generated property</i> for <code>TicketEventWsDTO.addedByAgent</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="addedByAgent", description="Whether an agent added this event.", example="false") 	
	private Boolean addedByAgent;

	/** <i>Generated property</i> for <code>TicketEventWsDTO.ticketEventAttachments</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="ticketEventAttachments") 	
	private List<TicketEventAttachmentWsDTO> ticketEventAttachments;

	/** <i>Generated property</i> for <code>TicketEventWsDTO.toStatus</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="toStatus") 	
	private TicketStatusWsDTO toStatus;
	
	public TicketEventWsDTO()
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
	
	public void setAuthor(final String author)
	{
		this.author = author;
	}

	public String getAuthor() 
	{
		return author;
	}
	
	public void setCreatedAt(final Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setAddedByAgent(final Boolean addedByAgent)
	{
		this.addedByAgent = addedByAgent;
	}

	public Boolean getAddedByAgent() 
	{
		return addedByAgent;
	}
	
	public void setTicketEventAttachments(final List<TicketEventAttachmentWsDTO> ticketEventAttachments)
	{
		this.ticketEventAttachments = ticketEventAttachments;
	}

	public List<TicketEventAttachmentWsDTO> getTicketEventAttachments() 
	{
		return ticketEventAttachments;
	}
	
	public void setToStatus(final TicketStatusWsDTO toStatus)
	{
		this.toStatus = toStatus;
	}

	public TicketStatusWsDTO getToStatus() 
	{
		return toStatus;
	}
	

}