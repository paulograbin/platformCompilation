/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class SAPAttachmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SAPAttachmentData.id</code> property defined at extension <code>commercefacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SAPAttachmentData.filename</code> property defined at extension <code>commercefacades</code>. */
	
	private String filename;

	/** <i>Generated property</i> for <code>SAPAttachmentData.attachmentReference</code> property defined at extension <code>commercefacades</code>. */
	
	private String attachmentReference;
	
	public SAPAttachmentData()
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
	
	public void setAttachmentReference(final String attachmentReference)
	{
		this.attachmentReference = attachmentReference;
	}

	public String getAttachmentReference() 
	{
		return attachmentReference;
	}
	

}