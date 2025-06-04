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
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Category of the ticket
 */
@Schema(name="C360TicketCategory", description="Category of the ticket")
public  class C360TicketCategoryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Category code of the ticket, for example, Problem, Complaint, Enquiry.<br/><br/><i>Generated property</i> for <code>C360TicketCategoryWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Category code of the ticket, for example, Problem, Complaint, Enquiry.", required=true, example="Enquiry") 	
	private String code;

	/** Localized category name of the ticket, for example, Problem, Complaint, Enquiry.<br/><br/><i>Generated property</i> for <code>C360TicketCategoryWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Localized category name of the ticket, for example, Problem, Complaint, Enquiry.", example="Enquiry") 	
	private String name;
	
	public C360TicketCategoryWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}