/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import de.hybris.platform.couponwebservices.dto.AbstractCouponWsDTO;
import de.hybris.platform.couponwebservices.dto.CouponGeneratedCodeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Multi code coupon
 */
@Schema(name="multiCodeCoupon", description="Multi code coupon")
public  class MultiCodeCouponWsDTO extends AbstractCouponWsDTO 

{



	/** Mandatory field. Represents the name of the CodeGenerationConfiguration, available in the system<br/><br/><i>Generated property</i> for <code>MultiCodeCouponWsDTO.codeGenerationConfiguration</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="codeGenerationConfiguration", description="Mandatory field. Represents the name of the CodeGenerationConfiguration, available in the system") 	
	private String codeGenerationConfiguration;

	/** Mandatory field<br/><br/><i>Generated property</i> for <code>MultiCodeCouponWsDTO.couponCodeNumber</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="couponCodeNumber", description="Mandatory field") 	
	private Long couponCodeNumber;

	/** List of media codes containing the generated codes<br/><br/><i>Generated property</i> for <code>MultiCodeCouponWsDTO.generatedCodes</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="generatedCodes", description="List of media codes containing the generated codes") 	
	private List<CouponGeneratedCodeWsDTO> generatedCodes;
	
	public MultiCodeCouponWsDTO()
	{
		// default constructor
	}
	
	public void setCodeGenerationConfiguration(final String codeGenerationConfiguration)
	{
		this.codeGenerationConfiguration = codeGenerationConfiguration;
	}

	public String getCodeGenerationConfiguration() 
	{
		return codeGenerationConfiguration;
	}
	
	public void setCouponCodeNumber(final Long couponCodeNumber)
	{
		this.couponCodeNumber = couponCodeNumber;
	}

	public Long getCouponCodeNumber() 
	{
		return couponCodeNumber;
	}
	
	public void setGeneratedCodes(final List<CouponGeneratedCodeWsDTO> generatedCodes)
	{
		this.generatedCodes = generatedCodes;
	}

	public List<CouponGeneratedCodeWsDTO> getGeneratedCodes() 
	{
		return generatedCodes;
	}
	

}