/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Status of the activity
 */
@Schema(name="C360ActivityStatus", description="Status of the activity")
public  class C360ActivityStatusWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Status code of the activity, e.g. READY, OPEN, CLOSED, ...<br/><br/><i>Generated property</i> for <code>C360ActivityStatusWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Status code of the activity, e.g. READY, OPEN, CLOSED, ...", example="READY") 	
	private String code;

	/** Status name of the activity, e.g. Ready, Open, Closed, ...<br/><br/><i>Generated property</i> for <code>C360ActivityStatusWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Status name of the activity, e.g. Ready, Open, Closed, ...", example="Ready") 	
	private String name;
	
	public C360ActivityStatusWsDTO()
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