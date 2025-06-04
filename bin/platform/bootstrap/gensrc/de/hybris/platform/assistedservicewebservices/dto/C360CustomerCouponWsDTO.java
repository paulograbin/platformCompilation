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
 * Representation of customer coupon.
 */
@Schema(name="C360CustomerCoupon", description="Representation of customer coupon.")
public  class C360CustomerCouponWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer coupon code<br/><br/><i>Generated property</i> for <code>C360CustomerCouponWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Customer coupon code", example="A480_20_OFF") 	
	private String code;

	/** Name of the customer coupon.<br/><br/><i>Generated property</i> for <code>C360CustomerCouponWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Name of the customer coupon.", example="Buy PowerShot A480 and get $20 off") 	
	private String name;

	/** Description of the customer coupon.<br/><br/><i>Generated property</i> for <code>C360CustomerCouponWsDTO.description</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="description", description="Description of the customer coupon.", example="Buy a PowerShot A480 camera today and get $20 off coupon for your next shopping tour.") 	
	private String description;
	
	public C360CustomerCouponWsDTO()
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
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	

}