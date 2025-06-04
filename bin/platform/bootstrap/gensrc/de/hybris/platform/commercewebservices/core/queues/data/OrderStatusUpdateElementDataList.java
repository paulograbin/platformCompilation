/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.queues.data;

import java.io.Serializable;
import de.hybris.platform.commercewebservices.core.queues.data.OrderStatusUpdateElementData;
import java.util.List;


import java.util.Objects;
public  class OrderStatusUpdateElementDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderStatusUpdateElementDataList.orderStatusUpdateElements</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<OrderStatusUpdateElementData> orderStatusUpdateElements;
	
	public OrderStatusUpdateElementDataList()
	{
		// default constructor
	}
	
	public void setOrderStatusUpdateElements(final List<OrderStatusUpdateElementData> orderStatusUpdateElements)
	{
		this.orderStatusUpdateElements = orderStatusUpdateElements;
	}

	public List<OrderStatusUpdateElementData> getOrderStatusUpdateElements() 
	{
		return orderStatusUpdateElements;
	}
	

}