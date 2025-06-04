/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import de.hybris.platform.couponwebservices.dto.CouponStatusWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Abstract coupon
 */
@Schema(name="abstractCoupon", description="Abstract coupon")
public abstract  class AbstractCouponWsDTO extends CouponStatusWsDTO 

{



	/** <i>Generated property</i> for <code>AbstractCouponWsDTO.name</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="name") 	
	private String name;

	/** Start date/time (UTC timezone) string representation in ISO-8601 format<br/><br/><i>Generated property</i> for <code>AbstractCouponWsDTO.startDate</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="startDate", description="Start date/time (UTC timezone) string representation in ISO-8601 format") 	
	private String startDate;

	/** End date/time (UTC timezone) string representation in ISO-8601 format<br/><br/><i>Generated property</i> for <code>AbstractCouponWsDTO.endDate</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="endDate", description="End date/time (UTC timezone) string representation in ISO-8601 format") 	
	private String endDate;
	
	public AbstractCouponWsDTO()
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
	
	public void setStartDate(final String startDate)
	{
		this.startDate = startDate;
	}

	public String getStartDate() 
	{
		return startDate;
	}
	
	public void setEndDate(final String endDate)
	{
		this.endDate = endDate;
	}

	public String getEndDate() 
	{
		return endDate;
	}
	

}