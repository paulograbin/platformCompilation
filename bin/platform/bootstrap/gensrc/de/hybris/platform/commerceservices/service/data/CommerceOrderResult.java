/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.core.model.order.OrderModel;


import java.util.Objects;
public  class CommerceOrderResult  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** the OrderModel<br/><br/><i>Generated property</i> for <code>CommerceOrderResult.order</code> property defined at extension <code>commerceservices</code>. */
	
	private OrderModel order;
	
	public CommerceOrderResult()
	{
		// default constructor
	}
	
	public void setOrder(final OrderModel order)
	{
		this.order = order;
	}

	public OrderModel getOrder() 
	{
		return order;
	}
	

}