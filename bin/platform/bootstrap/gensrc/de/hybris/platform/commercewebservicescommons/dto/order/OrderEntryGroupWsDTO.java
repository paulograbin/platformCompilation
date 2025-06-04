/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of an Order Entry Group
 */
@Schema(name="OrderEntryGroup", description="Representation of an Order Entry Group")
public  class OrderEntryGroupWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Total price with tax<br/><br/><i>Generated property</i> for <code>OrderEntryGroupWsDTO.totalPriceWithTax</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalPriceWithTax", description="Total price with tax") 	
	private PriceWsDTO totalPriceWithTax;

	/** List of order entries<br/><br/><i>Generated property</i> for <code>OrderEntryGroupWsDTO.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entries", description="List of order entries") 	
	private Collection<OrderEntryWsDTO> entries;

	/** Quantity of order entries in a group<br/><br/><i>Generated property</i> for <code>OrderEntryGroupWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Quantity of order entries in a group") 	
	private Long quantity;
	
	public OrderEntryGroupWsDTO()
	{
		// default constructor
	}
	
	public void setTotalPriceWithTax(final PriceWsDTO totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}

	public PriceWsDTO getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
	
	public void setEntries(final Collection<OrderEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public Collection<OrderEntryWsDTO> getEntries() 
	{
		return entries;
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