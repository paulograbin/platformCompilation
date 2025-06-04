/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="CMSWorkflowEditableItemListWsDTO")
public  class CMSWorkflowEditableItemListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowEditableItemListWsDTO.editableItems</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="editableItems") 	
	private List<CMSWorkflowEditableItemWsDTO> editableItems;
	
	public CMSWorkflowEditableItemListWsDTO()
	{
		// default constructor
	}
	
	public void setEditableItems(final List<CMSWorkflowEditableItemWsDTO> editableItems)
	{
		this.editableItems = editableItems;
	}

	public List<CMSWorkflowEditableItemWsDTO> getEditableItems() 
	{
		return editableItems;
	}
	

}