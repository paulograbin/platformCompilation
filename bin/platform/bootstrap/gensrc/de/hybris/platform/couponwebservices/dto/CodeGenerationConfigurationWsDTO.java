/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Code generation configuration
 */
@Schema(name="codeGenerationConfiguration", description="Code generation configuration")
public  class CodeGenerationConfigurationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.name</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.codeSeparator</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="codeSeparator") 	
	private String codeSeparator;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.couponPartCount</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="couponPartCount") 	
	private Integer couponPartCount;

	/** <i>Generated property</i> for <code>CodeGenerationConfigurationWsDTO.couponPartLength</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="couponPartLength") 	
	private Integer couponPartLength;
	
	public CodeGenerationConfigurationWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCodeSeparator(final String codeSeparator)
	{
		this.codeSeparator = codeSeparator;
	}

	public String getCodeSeparator() 
	{
		return codeSeparator;
	}
	
	public void setCouponPartCount(final Integer couponPartCount)
	{
		this.couponPartCount = couponPartCount;
	}

	public Integer getCouponPartCount() 
	{
		return couponPartCount;
	}
	
	public void setCouponPartLength(final Integer couponPartLength)
	{
		this.couponPartLength = couponPartLength;
	}

	public Integer getCouponPartLength() 
	{
		return couponPartLength;
	}
	

}