/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
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
 * Specifies properties of the CMS workflow decision.
 */
@Schema(name="CMSWorkflowDecision", description="Specifies properties of the CMS workflow decision.")
public  class CMSWorkflowDecisionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="PageTranslationSendDEForReview") 	
	private String code;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name", example="{\"en\": \"Send for Review\", \"en_US\": \"Send for Review\"}") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="description", example="{\"en\": \"Decision for sending DE language for review\", \"en_US\": \"Decision for sending DE language for review\"}") 	
	private Map<String,String> description;
	
	public CMSWorkflowDecisionWsDTO()
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
	
	public void setDescription(final Map<String,String> description)
	{
		this.description = description;
	}

	public Map<String,String> getDescription() 
	{
		return description;
	}
	

}