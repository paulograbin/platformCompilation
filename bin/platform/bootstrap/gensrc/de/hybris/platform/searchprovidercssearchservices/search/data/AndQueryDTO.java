/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractQueryDTO;
import java.util.List;


import java.util.Objects;
public  class AndQueryDTO extends AbstractQueryDTO 

{



	/** <i>Generated property</i> for <code>AndQueryDTO.queries</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractQueryDTO> queries;
	
	public AndQueryDTO()
	{
		// default constructor
	}
	
	public void setQueries(final List<AbstractQueryDTO> queries)
	{
		this.queries = queries;
	}

	public List<AbstractQueryDTO> getQueries() 
	{
		return queries;
	}
	

}