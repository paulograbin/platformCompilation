/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the workflow template.
 */
@Schema(name="WorkflowTemplate", description="Specifies properties of the workflow template.")
public  class WorkflowTemplateWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowTemplateWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="000000RS") 	
	private String code;

	/** <i>Generated property</i> for <code>WorkflowTemplateWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name", example="{\"en\": \"Page Translation\", \"en_US\": \"Page Translation\"}") 	
	private Map<String,String> name;
	
	public WorkflowTemplateWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

	public Map<String,String> getName() 
	{
		return name;
	}
	

}