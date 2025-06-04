/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.suggest.data;

import java.io.Serializable;


import java.util.Objects;
public  class SuggestQueryDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SuggestQueryDTO.query</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String query;

	/** <i>Generated property</i> for <code>SuggestQueryDTO.top</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer top;
	
	public SuggestQueryDTO()
	{
		// default constructor
	}
	
	public void setQuery(final String query)
	{
		this.query = query;
	}

	public String getQuery() 
	{
		return query;
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