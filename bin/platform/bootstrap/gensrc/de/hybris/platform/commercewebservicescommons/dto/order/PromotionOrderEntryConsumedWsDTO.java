/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Promotion order entry consumed
 */
@Schema(name="PromotionOrderEntryConsumed", description="Representation of a Promotion order entry consumed")
public  class PromotionOrderEntryConsumedWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Order entry code<br/><br/><i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Order entry code") 	
	private String code;

	/** Adjusted unit price for promotion order entry<br/><br/><i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.adjustedUnitPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="adjustedUnitPrice", description="Adjusted unit price for promotion order entry") 	
	private Double adjustedUnitPrice;

	/** Order entry number<br/><br/><i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.orderEntryNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="orderEntryNumber", description="Order entry number") 	
	private Integer orderEntryNumber;

	/** Quantity of promotion order entry<br/><br/><i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Quantity of promotion order entry") 	
	private Long quantity;
	
	public PromotionOrderEntryConsumedWsDTO()
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
	
	public void setAdjustedUnitPrice(final Double adjustedUnitPrice)
	{
		this.adjustedUnitPrice = adjustedUnitPrice;
	}

	public Double getAdjustedUnitPrice() 
	{
		return adjustedUnitPrice;
	}
	
	public void setOrderEntryNumber(final Integer orderEntryNumber)
	{
		this.orderEntryNumber = orderEntryNumber;
	}

	public Integer getOrderEntryNumber() 
	{
		return orderEntryNumber;
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	

}