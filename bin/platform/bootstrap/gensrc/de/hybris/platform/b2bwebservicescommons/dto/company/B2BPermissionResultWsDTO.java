/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionTypeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Details of an order approval permission result related to an order
 */
@Schema(name="OrderApprovalPermissionResult", description="Details of an order approval permission result related to an order")
public  class B2BPermissionResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Name of the approver responsible for this permission result.<br/><br/><i>Generated property</i> for <code>B2BPermissionResultWsDTO.approverName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approverName", description="Name of the approver responsible for this permission result.") 	
	private String approverName;

	/** Any comments the approver added to the approval item.<br/><br/><i>Generated property</i> for <code>B2BPermissionResultWsDTO.approverNotes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approverNotes", description="Any comments the approver added to the approval item.", example="The order is rejected due to insufficient budget") 	
	private String approverNotes;

	/** Permission type related to the permission result.<br/><br/><i>Generated property</i> for <code>B2BPermissionResultWsDTO.permissionType</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="permissionType", description="Permission type related to the permission result.") 	
	private B2BPermissionTypeWsDTO permissionType;

	/** Status of the order approval.<br/><br/><i>Generated property</i> for <code>B2BPermissionResultWsDTO.statusDisplay</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="statusDisplay", description="Status of the order approval.", example="Pending approval") 	
	private String statusDisplay;
	
	public B2BPermissionResultWsDTO()
	{
		// default constructor
	}
	
	public void setApproverName(final String approverName)
	{
		this.approverName = approverName;
	}

	public String getApproverName() 
	{
		return approverName;
	}
	
	public void setApproverNotes(final String approverNotes)
	{
		this.approverNotes = approverNotes;
	}

	public String getApproverNotes() 
	{
		return approverNotes;
	}
	
	public void setPermissionType(final B2BPermissionTypeWsDTO permissionType)
	{
		this.permissionType = permissionType;
	}

	public B2BPermissionTypeWsDTO getPermissionType() 
	{
		return permissionType;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	

}