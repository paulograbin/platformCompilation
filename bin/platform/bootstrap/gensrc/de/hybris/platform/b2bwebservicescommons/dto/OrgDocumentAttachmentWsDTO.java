/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="OrgDocumentAttachment")
public  class OrgDocumentAttachmentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Organizational document attachment identifier.<br/><br/><i>Generated property</i> for <code>OrgDocumentAttachmentWsDTO.id</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="id", description="Organizational document attachment identifier.", example="INPG-00100001") 	
	private String id;
	
	public OrgDocumentAttachmentWsDTO()
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
	

}