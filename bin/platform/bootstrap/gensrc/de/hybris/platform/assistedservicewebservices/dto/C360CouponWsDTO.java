/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of coupon.
 */
@Schema(name="C360Coupon", description="Representation of coupon.")
public  class C360CouponWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Coupon code<br/><br/><i>Generated property</i> for <code>C360CouponWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Coupon code", example="CSA_COUPON_FREE_10_CAMERA") 	
	private String code;

	/** Name of the coupon<br/><br/><i>Generated property</i> for <code>C360CouponWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Name of the coupon", example="Free 10 shot camera coupon that can be applied to the cart during this session.") 	
	private String name;

	/** Whether the coupon is applied to the current cart.<br/><br/><i>Generated property</i> for <code>C360CouponWsDTO.applied</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="applied", description="Whether the coupon is applied to the current cart.", example="true") 	
	private boolean applied;
	
	public C360CouponWsDTO()
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
	
	public void setApplied(final boolean applied)
	{
		this.applied = applied;
	}

	public boolean isApplied() 
	{
		return applied;
	}
	

}