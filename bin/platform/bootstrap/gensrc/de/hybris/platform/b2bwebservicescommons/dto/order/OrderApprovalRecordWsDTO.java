/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionTypeWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Details of one order approval record
 */
@Schema(name="OrderApprovalRecord", description="Details of one order approval record")
public  class OrderApprovalRecordWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of permission types related to this approval record.<br/><br/><i>Generated property</i> for <code>OrderApprovalRecordWsDTO.permissionTypes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="permissionTypes", description="List of permission types related to this approval record.") 	
	private List<B2BPermissionTypeWsDTO> permissionTypes;

	/** Principal responsible to this approval record.<br/><br/><i>Generated property</i> for <code>OrderApprovalRecordWsDTO.approver</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approver", description="Principal responsible to this approval record.") 	
	private PrincipalWsDTO approver;

	/** Status of the order approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalRecordWsDTO.statusDisplay</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="statusDisplay", description="Status of the order approval.", example="Pending approval") 	
	private String statusDisplay;

	/** Any comments the approver (or the workflow system) added to the approval item.<br/><br/><i>Generated property</i> for <code>OrderApprovalRecordWsDTO.comments</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="comments", description="Any comments the approver (or the workflow system) added to the approval item.", example="Submitted for approval") 	
	private String comments;
	
	public OrderApprovalRecordWsDTO()
	{
		// default constructor
	}
	
	public void setPermissionTypes(final List<B2BPermissionTypeWsDTO> permissionTypes)
	{
		this.permissionTypes = permissionTypes;
	}

	public List<B2BPermissionTypeWsDTO> getPermissionTypes() 
	{
		return permissionTypes;
	}
	
	public void setApprover(final PrincipalWsDTO approver)
	{
		this.approver = approver;
	}

	public PrincipalWsDTO getApprover() 
	{
		return approver;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setComments(final String comments)
	{
		this.comments = comments;
	}

	public String getComments() 
	{
		return comments;
	}
	

}