/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import de.hybris.platform.couponwebservices.dto.AbstractCouponWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Single code coupon
 */
@Schema(name="singleCodeCoupon", description="Single code coupon")
public  class SingleCodeCouponWsDTO extends AbstractCouponWsDTO 

{



	/** <i>Generated property</i> for <code>SingleCodeCouponWsDTO.maxRedemptionsPerCustomer</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="maxRedemptionsPerCustomer") 	
	private Integer maxRedemptionsPerCustomer;

	/** <i>Generated property</i> for <code>SingleCodeCouponWsDTO.maxTotalRedemptions</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="maxTotalRedemptions") 	
	private Integer maxTotalRedemptions;
	
	public SingleCodeCouponWsDTO()
	{
		// default constructor
	}
	
	public void setMaxRedemptionsPerCustomer(final Integer maxRedemptionsPerCustomer)
	{
		this.maxRedemptionsPerCustomer = maxRedemptionsPerCustomer;
	}

	public Integer getMaxRedemptionsPerCustomer() 
	{
		return maxRedemptionsPerCustomer;
	}
	
	public void setMaxTotalRedemptions(final Integer maxTotalRedemptions)
	{
		this.maxTotalRedemptions = maxTotalRedemptions;
	}

	public Integer getMaxTotalRedemptions() 
	{
		return maxTotalRedemptions;
	}
	

}