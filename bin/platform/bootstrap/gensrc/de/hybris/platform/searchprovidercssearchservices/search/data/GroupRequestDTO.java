/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;


import java.util.Objects;
public  class GroupRequestDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>GroupRequestDTO.expression</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String expression;

	/** <i>Generated property</i> for <code>GroupRequestDTO.top</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer top;
	
	public GroupRequestDTO()
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
	
	public void setTop(final Integer top)
	{
		this.top = top;
	}

	public Integer getTop() 
	{
		return top;
	}
	

}