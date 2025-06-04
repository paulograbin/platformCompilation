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
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Order entry list consumed
 */
@Schema(name="OrderEntryList", description="Representation of an Order entry list consumed")
public  class OrderEntryListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of order entries<br/><br/><i>Generated property</i> for <code>OrderEntryListWsDTO.orderEntries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="orderEntries", description="List of order entries") 	
	private List<OrderEntryWsDTO> orderEntries;
	
	public OrderEntryListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderEntries(final List<OrderEntryWsDTO> orderEntries)
	{
		this.orderEntries = orderEntries;
	}

	public List<OrderEntryWsDTO> getOrderEntries() 
	{
		return orderEntries;
	}
	

}