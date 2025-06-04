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
 * Coupon status
 */
@Schema(name="couponStatus", description="Coupon status")
public  class CouponStatusWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The coupon Id is a mandatory property<br/><br/><i>Generated property</i> for <code>CouponStatusWsDTO.couponId</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="couponId", description="The coupon Id is a mandatory property") 	
	private String couponId;

	/** Coupons status<br/><br/><i>Generated property</i> for <code>CouponStatusWsDTO.active</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="active", description="Coupons status") 	
	private Boolean active;
	
	public CouponStatusWsDTO()
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
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final CouponStatusWsDTO other = (CouponStatusWsDTO) o;
		return Objects.equals(getCouponId(), other.getCouponId());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = couponId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}