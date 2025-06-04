/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Object contains attachment id for sap attachment.
 */
@Schema(name="SAPAttachment", description="Object contains attachment id for sap attachment.")
public  class SAPAttachmentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Attachment identifier.<br/><br/><i>Generated property</i> for <code>SAPAttachmentWsDTO.id</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="id", description="Attachment identifier.", example="e58ed763-928c-4155-bee9-fdbaaadc15f3") 	
	private String id;

	/** The name and the extension of the attached file.<br/><br/><i>Generated property</i> for <code>SAPAttachmentWsDTO.filename</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="filename", description="The name and the extension of the attached file.", example="my_file.jpg") 	
	private String filename;
	
	public SAPAttachmentWsDTO()
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