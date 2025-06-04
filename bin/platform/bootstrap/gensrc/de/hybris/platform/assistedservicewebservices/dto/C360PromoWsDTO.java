/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of promotion
 */
@Schema(name="C360Promotion", description="Representation of promotion")
public  class C360PromoWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Promotion code<br/><br/><i>Generated property</i> for <code>C360PromoWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Promotion code", example="CSA_DISCOUNT_CART_ABOVE_1000_10_DISCOUNT") 	
	private String code;

	/** Name of promotion<br/><br/><i>Generated property</i> for <code>C360PromoWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Name of promotion", example="Activated 10% Discount for Cart Over $1,000.00") 	
	private String name;

	/** Message of promotion<br/><br/><i>Generated property</i> for <code>C360PromoWsDTO.message</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="message", description="Message of promotion", example="The cart total is over $1,000.00 therefore a 10% discount has been applied.") 	
	private String message;

	/** Whether the promotion is applied to cart<br/><br/><i>Generated property</i> for <code>C360PromoWsDTO.applied</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="applied", description="Whether the promotion is applied to cart", example="true") 	
	private boolean applied;
	
	public C360PromoWsDTO()
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
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
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