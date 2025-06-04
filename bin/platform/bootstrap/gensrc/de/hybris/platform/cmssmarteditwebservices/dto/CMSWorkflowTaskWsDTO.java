/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="CMSWorkflowTaskWsDTO")
public  class CMSWorkflowTaskWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowTaskWsDTO.action</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="action") 	
	private CMSWorkflowActionWsDTO action;

	/** <i>Generated property</i> for <code>CMSWorkflowTaskWsDTO.attachments</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="attachments") 	
	private List<CMSWorkflowAttachmentData> attachments;
	
	public CMSWorkflowTaskWsDTO()
	{
		// default constructor
	}
	
	public void setAction(final CMSWorkflowActionWsDTO action)
	{
		this.action = action;
	}

	public CMSWorkflowActionWsDTO getAction() 
	{
		return action;
	}
	
	public void setAttachments(final List<CMSWorkflowAttachmentData> attachments)
	{
		this.attachments = attachments;
	}

	public List<CMSWorkflowAttachmentData> getAttachments() 
	{
		return attachments;
	}
	

}