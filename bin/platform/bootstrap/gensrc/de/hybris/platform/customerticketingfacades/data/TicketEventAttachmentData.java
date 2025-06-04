/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class TicketEventAttachmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketEventAttachmentData.id</code> property defined at extension <code>customerticketingfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>TicketEventAttachmentData.filename</code> property defined at extension <code>customerticketingfacades</code>. */
	
	private String filename;

	/** <i>Generated property</i> for <code>TicketEventAttachmentData.URL</code> property defined at extension <code>customerticketingfacades</code>. */
	
	private String URL;
	
	public TicketEventAttachmentData()
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
	
	public void setURL(final String URL)
	{
		this.URL = URL;
	}

	public String getURL() 
	{
		return URL;
	}
	

}