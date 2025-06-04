/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the CMS workflow action.
 */
@Schema(name="CMSWorkflowAction", description="Specifies properties of the CMS workflow action.")
public  class CMSWorkflowActionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="0000000C") 	
	private String code;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name", example="{\"en\": \"Approve\", \"en_US\": \"Approve\"}") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="description", example="{\"en\": \"Decision for approving content\", \"en_US\": \"Decision for approving content\"}") 	
	private Map<String,String> description;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.actionType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="actionType", example="START") 	
	private String actionType;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.status</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="status", example="IN_PROGRESS") 	
	private String status;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.isCurrentUserParticipant</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="isCurrentUserParticipant", example="true") 	
	private boolean isCurrentUserParticipant;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.startedAgoInMillis</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="startedAgoInMillis", example="5283") 	
	private Long startedAgoInMillis;

	/** <i>Generated property</i> for <code>CMSWorkflowActionWsDTO.decisions</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="decisions", example="[{\"code\": \"PageTranslationSendDEForReview\", \"description\": {\"en\": \"Decision for sending DE language for review\"}, \"name\": {\"en\": \"Send for Review\"}}]") 	
	private List<CMSWorkflowDecisionWsDTO> decisions;
	
	public CMSWorkflowActionWsDTO()
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
	
	public void setActionType(final String actionType)
	{
		this.actionType = actionType;
	}

	public String getActionType() 
	{
		return actionType;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setIsCurrentUserParticipant(final boolean isCurrentUserParticipant)
	{
		this.isCurrentUserParticipant = isCurrentUserParticipant;
	}

	public boolean isIsCurrentUserParticipant() 
	{
		return isCurrentUserParticipant;
	}
	
	public void setStartedAgoInMillis(final Long startedAgoInMillis)
	{
		this.startedAgoInMillis = startedAgoInMillis;
	}

	public Long getStartedAgoInMillis() 
	{
		return startedAgoInMillis;
	}
	
	public void setDecisions(final List<CMSWorkflowDecisionWsDTO> decisions)
	{
		this.decisions = decisions;
	}

	public List<CMSWorkflowDecisionWsDTO> getDecisions() 
	{
		return decisions;
	}
	

}