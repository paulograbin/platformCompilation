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
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BApprovalProcessWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an organizational approval process list
 */
@Schema(name="B2BApprovalProcessList", description="Representation of an organizational approval process list")
public  class B2BApprovalProcessListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Organizational Approval Process<br/><br/><i>Generated property</i> for <code>B2BApprovalProcessListWsDTO.approvalProcesses</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approvalProcesses", description="List of Organizational Approval Process", required=true) 	
	private List<B2BApprovalProcessWsDTO> approvalProcesses;
	
	public B2BApprovalProcessListWsDTO()
	{
		// default constructor
	}
	
	public void setApprovalProcesses(final List<B2BApprovalProcessWsDTO> approvalProcesses)
	{
		this.approvalProcesses = approvalProcesses;
	}

	public List<B2BApprovalProcessWsDTO> getApprovalProcesses() 
	{
		return approvalProcesses;
	}
	

}