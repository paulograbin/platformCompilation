/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingocc.dto.ticket;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Ticket category details.
 */
@Schema(name="TicketCategory", description="Ticket category details.")
public  class TicketCategoryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Localized ticket category name.<br/><br/><i>Generated property</i> for <code>TicketCategoryWsDTO.name</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="name", description="Localized ticket category name.", example="Enquiry") 	
	private String name;

	/** Ticket category identifier.<br/><br/><i>Generated property</i> for <code>TicketCategoryWsDTO.id</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="id", description="Ticket category identifier.", required=true, example="ENQUIRY") 	
	private String id;
	
	public TicketCategoryWsDTO()
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