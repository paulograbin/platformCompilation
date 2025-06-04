/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.savedorderformsocc.dto;

import java.io.Serializable;


import java.util.Objects;
public  class OrderFormEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderFormEntryWsDTO.sku</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private String sku;

	/** <i>Generated property</i> for <code>OrderFormEntryWsDTO.quantity</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private Integer quantity;
	
	public OrderFormEntryWsDTO()
	{
		// default constructor
	}
	
	public void setSku(final String sku)
	{
		this.sku = sku;
	}

	public String getSku() 
	{
		return sku;
	}
	
	public void setQuantity(final Integer quantity)
	{
		this.quantity = quantity;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}
	

}