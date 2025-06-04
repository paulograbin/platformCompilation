/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.document.data;

import java.io.Serializable;
import org.springframework.core.io.ByteArrayResource;


import java.util.Objects;
public  class AttachmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AttachmentData.fileName</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String fileName;

	/** <i>Generated property</i> for <code>AttachmentData.fileContent</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private ByteArrayResource fileContent;

	/** <i>Generated property</i> for <code>AttachmentData.fileType</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String fileType;
	
	public AttachmentData()
	{
		// default constructor
	}
	
	public void setFileName(final String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	
	public void setFileContent(final ByteArrayResource fileContent)
	{
		this.fileContent = fileContent;
	}

	public ByteArrayResource getFileContent() 
	{
		return fileContent;
	}
	
	public void setFileType(final String fileType)
	{
		this.fileType = fileType;
	}

	public String getFileType() 
	{
		return fileType;
	}
	

}