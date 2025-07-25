/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Consignment Entry
 */
@Schema(name="ConsignmentEntry", description="Representation of a Consignment Entry")
public  class ConsignmentEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Order entry of Consignment entry<br/><br/><i>Generated property</i> for <code>ConsignmentEntryWsDTO.orderEntry</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="orderEntry", description="Order entry of Consignment entry") 	
	private OrderEntryWsDTO orderEntry;

	/** Quantity value of Consignment entry<br/><br/><i>Generated property</i> for <code>ConsignmentEntryWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Quantity value of Consignment entry") 	
	private Long quantity;

	/** Shipped quantity<br/><br/><i>Generated property</i> for <code>ConsignmentEntryWsDTO.shippedQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="shippedQuantity", description="Shipped quantity") 	
	private Long shippedQuantity;

	/** <i>Generated property</i> for <code>ConsignmentEntryWsDTO.quantityDeclined</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="quantityDeclined") 	
	private Long quantityDeclined;

	/** <i>Generated property</i> for <code>ConsignmentEntryWsDTO.quantityPending</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="quantityPending") 	
	private Long quantityPending;

	/** <i>Generated property</i> for <code>ConsignmentEntryWsDTO.quantityShipped</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="quantityShipped") 	
	private Long quantityShipped;
	
	public ConsignmentEntryWsDTO()
	{
		// default constructor
	}
	
	public void setOrderEntry(final OrderEntryWsDTO orderEntry)
	{
		this.orderEntry = orderEntry;
	}

	public OrderEntryWsDTO getOrderEntry() 
	{
		return orderEntry;
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	
	public void setShippedQuantity(final Long shippedQuantity)
	{
		this.shippedQuantity = shippedQuantity;
	}

	public Long getShippedQuantity() 
	{
		return shippedQuantity;
	}
	
	public void setQuantityDeclined(final Long quantityDeclined)
	{
		this.quantityDeclined = quantityDeclined;
	}

	public Long getQuantityDeclined() 
	{
		return quantityDeclined;
	}
	
	public void setQuantityPending(final Long quantityPending)
	{
		this.quantityPending = quantityPending;
	}

	public Long getQuantityPending() 
	{
		return quantityPending;
	}
	
	public void setQuantityShipped(final Long quantityShipped)
	{
		this.quantityShipped = quantityShipped;
	}

	public Long getQuantityShipped() 
	{
		return quantityShipped;
	}
	

}