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
import de.hybris.platform.assistedservicewebservices.dto.C360TicketCategoryWsDTO;
import de.hybris.platform.assistedservicewebservices.dto.C360TicketStatusWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a ticket
 */
@Schema(name="C360Ticket", description="Representation of a ticket")
public  class C360TicketWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Id of the ticket<br/><br/><i>Generated property</i> for <code>C360TicketWsDTO.id</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="id", description="Id of the ticket", required=true, example="00000000") 	
	private String id;

	/** Subject of the ticket<br/><br/><i>Generated property</i> for <code>C360TicketWsDTO.subject</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="subject", description="Subject of the ticket", example="Ticket Subject 00000001") 	
	private String subject;

	/** Category of the ticket<br/><br/><i>Generated property</i> for <code>C360TicketWsDTO.category</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="category", description="Category of the ticket") 	
	private C360TicketCategoryWsDTO category;

	/** Status of the ticket<br/><br/><i>Generated property</i> for <code>C360TicketWsDTO.status</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="status", description="Status of the ticket") 	
	private C360TicketStatusWsDTO status;

	/** Date of ticket creation<br/><br/><i>Generated property</i> for <code>C360TicketWsDTO.createdAt</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="createdAt", description="Date of ticket creation", example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date createdAt;

	/** Date of ticket update<br/><br/><i>Generated property</i> for <code>C360TicketWsDTO.updatedAt</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="updatedAt", description="Date of ticket update", example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date updatedAt;
	
	public C360TicketWsDTO()
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
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setCategory(final C360TicketCategoryWsDTO category)
	{
		this.category = category;
	}

	public C360TicketCategoryWsDTO getCategory() 
	{
		return category;
	}
	
	public void setStatus(final C360TicketStatusWsDTO status)
	{
		this.status = status;
	}

	public C360TicketStatusWsDTO getStatus() 
	{
		return status;
	}
	
	public void setCreatedAt(final Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}
	
	public void setUpdatedAt(final Date updatedAt)
	{
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt() 
	{
		return updatedAt;
	}
	

}