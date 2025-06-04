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
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Object containing a set of fields for ticket attachment.
 */
@Schema(name="TicketEventAttachment", description="Object containing a set of fields for ticket attachment.")
public  class TicketEventAttachmentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Attachment identifier.<br/><br/><i>Generated property</i> for <code>TicketEventAttachmentWsDTO.id</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="id", description="Attachment identifier.", example="001") 	
	private String id;

	/** The name and the extension of the attached file.<br/><br/><i>Generated property</i> for <code>TicketEventAttachmentWsDTO.filename</code> property defined at extension <code>customerticketingocc</code>. */
@Schema(name="filename", description="The name and the extension of the attached file.", example="my_file.jpg") 	
	private String filename;
	
	public TicketEventAttachmentWsDTO()
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
	
	public void setFilename(final String filename)
	{
		this.filename = filename;
	}

	public String getFilename() 
	{
		return filename;
	}
	

}