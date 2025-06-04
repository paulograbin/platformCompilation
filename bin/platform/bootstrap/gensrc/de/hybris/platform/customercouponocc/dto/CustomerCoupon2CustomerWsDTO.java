/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customercouponocc.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import de.hybris.platform.customercouponocc.dto.CustomerCouponWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Customer coupon for customer
 */
@Schema(name="CustomerCoupon2Customer", description="Customer coupon for customer")
public  class CustomerCoupon2CustomerWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer coupon<br/><br/><i>Generated property</i> for <code>CustomerCoupon2CustomerWsDTO.coupon</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="coupon", description="Customer coupon") 	
	private CustomerCouponWsDTO coupon;

	/** Customer<br/><br/><i>Generated property</i> for <code>CustomerCoupon2CustomerWsDTO.customer</code> property defined at extension <code>customercouponocc</code>. */
@Schema(name="customer", description="Customer") 	
	private UserWsDTO customer;
	
	public CustomerCoupon2CustomerWsDTO()
	{
		// default constructor
	}
	
	public void setCoupon(final CustomerCouponWsDTO coupon)
	{
		this.coupon = coupon;
	}

	public CustomerCouponWsDTO getCoupon() 
	{
		return coupon;
	}
	
	public void setCustomer(final UserWsDTO customer)
	{
		this.customer = customer;
	}

	public UserWsDTO getCustomer() 
	{
		return customer;
	}
	

}