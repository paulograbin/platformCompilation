/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available workflow templates.
 */
@Schema(name="WorkflowTemplateListWsDTO", description="Specifies a list of available workflow templates.")
public  class WorkflowTemplateListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowTemplateListWsDTO.templates</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="templates") 	
	private List<WorkflowTemplateWsDTO> templates;
	
	public WorkflowTemplateListWsDTO()
	{
		// default constructor
	}
	
	public void setTemplates(final List<WorkflowTemplateWsDTO> templates)
	{
		this.templates = templates;
	}

	public List<WorkflowTemplateWsDTO> getTemplates() 
	{
		return templates;
	}
	

}