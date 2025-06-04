/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Coupon generated code
 */
@Schema(name="couponGeneratedCode", description="Coupon generated code")
public  class CouponGeneratedCodeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CouponGeneratedCodeWsDTO.code</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>CouponGeneratedCodeWsDTO.link</code> property defined at extension <code>couponwebservices</code>. */
@Schema(name="link") 	
	private String link;
	
	public CouponGeneratedCodeWsDTO()
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
	
	public void setLink(final String link)
	{
		this.link = link;
	}

	public String getLink() 
	{
		return link;
	}
	

}