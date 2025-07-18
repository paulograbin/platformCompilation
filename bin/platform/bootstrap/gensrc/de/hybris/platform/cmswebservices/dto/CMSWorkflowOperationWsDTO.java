/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the CMS workflow operation.
 */
@Schema(name="CMSWorkflowOperationWsDTO", description="Specifies properties of the CMS workflow operation.")
public  class CMSWorkflowOperationWsDTO extends CMSCreateVersionWsDTO 

{



	/** <i>Generated property</i> for <code>CMSWorkflowOperationWsDTO.operation</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="operation") 	
	private String operation;

	/** <i>Generated property</i> for <code>CMSWorkflowOperationWsDTO.actionCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="actionCode", example="000001JR") 	
	private String actionCode;

	/** <i>Generated property</i> for <code>CMSWorkflowOperationWsDTO.decisionCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="decisionCode", example="000000RS") 	
	private String decisionCode;

	/** <i>Generated property</i> for <code>CMSWorkflowOperationWsDTO.comment</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="comment") 	
	private String comment;
	
	public CMSWorkflowOperationWsDTO()
	{
		// default constructor
	}
	
	public void setOperation(final String operation)
	{
		this.operation = operation;
	}

	public String getOperation() 
	{
		return operation;
	}
	
	public void setActionCode(final String actionCode)
	{
		this.actionCode = actionCode;
	}

	public String getActionCode() 
	{
		return actionCode;
	}
	
	public void setDecisionCode(final String decisionCode)
	{
		this.decisionCode = decisionCode;
	}

	public String getDecisionCode() 
	{
		return decisionCode;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	

}