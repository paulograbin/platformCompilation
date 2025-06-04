/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customercouponocc.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Customer coupon operation request.
 */
@Schema(name="SAPCustomerCouponOperationRequest", description="Customer coupon operation request.")
public  class SAPCustomerCouponOperationRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Coupon code. A valid coupon code can be used to get a discount.<br/><br/><i>Generated property</i> for <code>SAPCustomerCouponOperationRequestWsDTO.couponCode</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="couponCode", description="Coupon code. A valid coupon code can be used to get a discount.", required=true, example="VCHR-H8BC-Y3D5-34AL") 	
	private String couponCode;
	
	public SAPCustomerCouponOperationRequestWsDTO()
	{
		// default constructor
	}
	
	public void setCouponCode(final String couponCode)
	{
		this.couponCode = couponCode;
	}

	public String getCouponCode() 
	{
		return couponCode;
	}
	

}