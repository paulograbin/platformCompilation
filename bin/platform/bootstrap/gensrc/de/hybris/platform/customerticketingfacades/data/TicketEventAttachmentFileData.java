/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerticketingfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class TicketEventAttachmentFileData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketEventAttachmentFileData.filename</code> property defined at extension <code>customerticketingfacades</code>. */
	
	private String filename;

	/** <i>Generated property</i> for <code>TicketEventAttachmentFileData.content</code> property defined at extension <code>customerticketingfacades</code>. */
	
	private byte[] content;
	
	public TicketEventAttachmentFileData()
	{
		// default constructor
	}
	
	public void setFilename(final String filename)
	{
		this.filename = filename;
	}

	public String getFilename() 
	{
		return filename;
	}
	
	public void setContent(final byte[] content)
	{
		this.content = content;
	}

	public byte[] getContent() 
	{
		return content;
	}
	

}