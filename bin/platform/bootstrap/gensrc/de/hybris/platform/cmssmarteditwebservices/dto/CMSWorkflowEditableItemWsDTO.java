/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Contains information about whether the item from a workflow is editable by session user or not.
 */
@Schema(name="CMSWorkflowEditableItemWsDTO", description="Contains information about whether the item from a workflow is editable by session user or not.")
public  class CMSWorkflowEditableItemWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowEditableItemWsDTO.uid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>CMSWorkflowEditableItemWsDTO.uuid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="uuid") 	
	private String uuid;

	/** Indicates whether the session user can edit the item from a workflow or not.<br/><br/><i>Generated property</i> for <code>CMSWorkflowEditableItemWsDTO.editableByUser</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="editableByUser", description="Indicates whether the session user can edit the item from a workflow or not.") 	
	private boolean editableByUser;

	/** 
				Contains the workflow code where item can be edited. It either contains the code of the oldest workflow that contains item or null if there is no workflow. Is used by SmartEdit ui to restrict user from editing an item in a workflow that is not the oldest one.
			<br/><br/><i>Generated property</i> for <code>CMSWorkflowEditableItemWsDTO.editableInWorkflow</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="editableInWorkflow", description="Contains the workflow code where item can be edited. It either contains the code of the oldest workflow that contains item or null if there is no workflow. Is used by SmartEdit ui to restrict user from editing an item in a workflow that is not the oldest one.") 	
	private String editableInWorkflow;
	
	public CMSWorkflowEditableItemWsDTO()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setEditableByUser(final boolean editableByUser)
	{
		this.editableByUser = editableByUser;
	}

	public boolean isEditableByUser() 
	{
		return editableByUser;
	}
	
	public void setEditableInWorkflow(final String editableInWorkflow)
	{
		this.editableInWorkflow = editableInWorkflow;
	}

	public String getEditableInWorkflow() 
	{
		return editableInWorkflow;
	}
	

}