/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customercouponocc.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Customer coupon
 */
@Schema(name="CustomerCoupon", description="Customer coupon")
public  class CustomerCouponWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Coupon identifier<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.couponId</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="couponId", description="Coupon identifier") 	
	private String couponId;

	/** Name of the coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.name</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="name", description="Name of the coupon") 	
	private String name;

	/** Start date of the coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.startDate</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="startDate", description="Start date of the coupon") 	
	private Date startDate;

	/** End date of the coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.endDate</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="endDate", description="End date of the coupon") 	
	private Date endDate;

	/** Status of the coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.status</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="status", description="Status of the coupon", example="Effective") 	
	private String status;

	/** Description of the coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.description</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="description", description="Description of the coupon") 	
	private String description;

	/** Indicates if notification is enabled or disabled<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.notificationOn</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="notificationOn", description="Indicates if notification is enabled or disabled") 	
	private Boolean notificationOn;

	/** Indicates whether the coupon is applicable for all products<br/><br/><i>Generated property</i> for <code>CustomerCouponWsDTO.allProductsApplicable</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="allProductsApplicable", description="Indicates whether the coupon is applicable for all products") 	
	private Boolean allProductsApplicable;
	
	public CustomerCouponWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setNotificationOn(final Boolean notificationOn)
	{
		this.notificationOn = notificationOn;
	}

	public Boolean getNotificationOn() 
	{
		return notificationOn;
	}
	
	public void setAllProductsApplicable(final Boolean allProductsApplicable)
	{
		this.allProductsApplicable = allProductsApplicable;
	}

	public Boolean getAllProductsApplicable() 
	{
		return allProductsApplicable;
	}
	

}