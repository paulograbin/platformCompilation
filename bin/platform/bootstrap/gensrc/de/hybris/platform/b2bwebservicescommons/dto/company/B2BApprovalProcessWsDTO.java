/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of an organizational approval process
 */
@Schema(name="B2BApprovalProcess", description="Representation of an organizational approval process")
public  class B2BApprovalProcessWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the Organizational Approval Process<br/><br/><i>Generated property</i> for <code>B2BApprovalProcessWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="code", description="Code of the Organizational Approval Process", required=true, example="accApproval") 	
	private String code;

	/** Name of the Organizational Approval Process<br/><br/><i>Generated property</i> for <code>B2BApprovalProcessWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Name of the Organizational Approval Process", example="Escalation Approval with Merchant Check") 	
	private String name;
	
	public B2BApprovalProcessWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}