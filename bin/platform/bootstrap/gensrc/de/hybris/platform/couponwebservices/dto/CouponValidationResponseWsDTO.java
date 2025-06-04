/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Coupon validation response
 */
@Schema(name="couponValidationResponse", description="Coupon validation response")
public  class CouponValidationResponseWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CouponValidationResponseWsDTO.couponId</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="couponId") 	
	private String couponId;

	/** <i>Generated property</i> for <code>CouponValidationResponseWsDTO.generatedCouponCode</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="generatedCouponCode") 	
	private String generatedCouponCode;

	/** <i>Generated property</i> for <code>CouponValidationResponseWsDTO.valid</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="valid") 	
	private Boolean valid;

	/** <i>Generated property</i> for <code>CouponValidationResponseWsDTO.message</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="message") 	
	private String message;
	
	public CouponValidationResponseWsDTO()
	{
		// default constructor
	}
	
	public void setCouponId(final String couponId)
	{
		this.couponId = couponId;
	}

	public String getCouponId() 
	{
		return couponId;
	}
	
	public void setGeneratedCouponCode(final String generatedCouponCode)
	{
		this.generatedCouponCode = generatedCouponCode;
	}

	public String getGeneratedCouponCode() 
	{
		return generatedCouponCode;
	}
	
	public void setValid(final Boolean valid)
	{
		this.valid = valid;
	}

	public Boolean getValid() 
	{
		return valid;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	

}