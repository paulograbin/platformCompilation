/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import java.util.Collection;


import java.util.Objects;
public  class OrderEntryGroupData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderEntryGroupData.totalPriceWithTax</code> property defined at extension <code>commercefacades</code>. */
	
	private PriceData totalPriceWithTax;

	/** <i>Generated property</i> for <code>OrderEntryGroupData.entries</code> property defined at extension <code>commercefacades</code>. */
	
	private Collection<OrderEntryData> entries;

	/** <i>Generated property</i> for <code>OrderEntryGroupData.quantity</code> property defined at extension <code>commercefacades</code>. */
	
	private Long quantity;
	
	public OrderEntryGroupData()
	{
		// default constructor
	}
	
	public void setTotalPriceWithTax(final PriceData totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}

	public PriceData getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
	
	public void setEntries(final Collection<OrderEntryData> entries)
	{
		this.entries = entries;
	}

	public Collection<OrderEntryData> getEntries() 
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