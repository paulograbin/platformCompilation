/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Carrier
 */
@Schema(name="carrier", description="Carrier")
public  class CarrierWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Carrier code<br/><br/><i>Generated property</i> for <code>CarrierWsDTO.code</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="code", description="Carrier code") 	
	private String code;

	/** Carrier name<br/><br/><i>Generated property</i> for <code>CarrierWsDTO.name</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="name", description="Carrier name") 	
	private String name;
	
	public CarrierWsDTO()
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