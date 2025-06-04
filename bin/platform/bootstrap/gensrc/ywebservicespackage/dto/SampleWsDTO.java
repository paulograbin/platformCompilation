/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Sample DTO
 */
@Schema(name="sample", description="Sample DTO")
public  class SampleWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** sample value<br/><br/><i>Generated property</i> for <code>SampleWsDTO.value</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="value", description="sample value", required=true) 	
	private String value;
	
	public SampleWsDTO()
	{
		// default constructor
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	

}