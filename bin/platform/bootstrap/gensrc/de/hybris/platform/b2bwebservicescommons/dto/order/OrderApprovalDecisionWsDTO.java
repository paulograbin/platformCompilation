/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Decision for an order approval
 */
@Schema(name="OrderApprovalDecision", description="Decision for an order approval")
public  class OrderApprovalDecisionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Decision from the approver when approving/rejecting an order. Typical decisions are: APPROVE, REJECT<br/><br/><i>Generated property</i> for <code>OrderApprovalDecisionWsDTO.decision</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="decision", description="Decision from the approver when approving/rejecting an order. Typical decisions are: APPROVE, REJECT", required=true, example="REJECT") 	
	private String decision;

	/** Any comments the approver (or the workflow system) adds when approving/rejecting an order.<br/><br/><i>Generated property</i> for <code>OrderApprovalDecisionWsDTO.comment</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="comment", description="Any comments the approver (or the workflow system) adds when approving/rejecting an order.", example="Rejected because montly budget was exceeded") 	
	private String comment;
	
	public OrderApprovalDecisionWsDTO()
	{
		// default constructor
	}
	
	public void setDecision(final String decision)
	{
		this.decision = decision;
	}

	public String getDecision() 
	{
		return decision;
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