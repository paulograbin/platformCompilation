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
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Object that can be associated with a ticket. The object can be a cart or an order.
 */
@Schema(name="TicketAssociatedObject", description="Object that can be associated with a ticket. The object can be a cart or an order.")
public  class TicketAssociatedObjectWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Associated object code.<br/><br/><i>Generated property</i> for <code>TicketAssociatedObjectWsDTO.code</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="code", description="Associated object code.", required=true, example="00001000") 	
	private String code;

	/** Type of associated object: Cart, SavedCart or Order.<br/><br/><i>Generated property</i> for <code>TicketAssociatedObjectWsDTO.type</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="type", description="Type of associated object: Cart, SavedCart or Order.", required=true, example="Cart") 	
	private String type;

	/** Date and time of last modification.<br/><br/><i>Generated property</i> for <code>TicketAssociatedObjectWsDTO.modifiedAt</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="modifiedAt", description="Date and time of last modification.", example="2021-01-13T10:06:57+0000") 	
	private Date modifiedAt;
	
	public TicketAssociatedObjectWsDTO()
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
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setModifiedAt(final Date modifiedAt)
	{
		this.modifiedAt = modifiedAt;
	}

	public Date getModifiedAt() 
	{
		return modifiedAt;
	}
	

}