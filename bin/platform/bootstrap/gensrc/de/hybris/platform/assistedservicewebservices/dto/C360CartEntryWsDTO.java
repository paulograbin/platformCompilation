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
 * Representation of a Cart Entry
 */
@Schema(name="C360CartEntry", description="Representation of a Cart Entry")
public  class C360CartEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Number of items in the cart entry<br/><br/><i>Generated property</i> for <code>C360CartEntryWsDTO.quantity</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="quantity", description="Number of items in the cart entry", example="1") 	
	private Long quantity;

	/** Base price of the cart entry<br/><br/><i>Generated property</i> for <code>C360CartEntryWsDTO.basePrice</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="basePrice", description="Base price of the cart entry", example="$10.00") 	
	private String basePrice;

	/** Total price of the cart entry<br/><br/><i>Generated property</i> for <code>C360CartEntryWsDTO.totalPrice</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="totalPrice", description="Total price of the cart entry", example="$10.00") 	
	private String totalPrice;

	/** Product code of the cart entry<br/><br/><i>Generated property</i> for <code>C360CartEntryWsDTO.productCode</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="productCode", description="Product code of the cart entry", example="23355") 	
	private String productCode;
	
	public C360CartEntryWsDTO()
	{
		// default constructor
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	
	public void setBasePrice(final String basePrice)
	{
		this.basePrice = basePrice;
	}

	public String getBasePrice() 
	{
		return basePrice;
	}
	
	public void setTotalPrice(final String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public String getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	

}