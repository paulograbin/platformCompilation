/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.search.data.SortOrderDTO;


import java.util.Objects;
public  class SortExpressionDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SortExpressionDTO.expression</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String expression;

	/** <i>Generated property</i> for <code>SortExpressionDTO.order</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private SortOrderDTO order;
	
	public SortExpressionDTO()
	{
		// default constructor
	}
	
	public void setExpression(final String expression)
	{
		this.expression = expression;
	}

	public String getExpression() 
	{
		return expression;
	}
	
	public void setOrder(final SortOrderDTO order)
	{
		this.order = order;
	}

	public SortOrderDTO getOrder() 
	{
		return order;
	}
	

}