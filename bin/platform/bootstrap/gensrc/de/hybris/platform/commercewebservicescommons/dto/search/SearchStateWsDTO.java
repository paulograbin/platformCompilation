/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.SearchQueryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Search State
 */
@Schema(name="SearchState", description="Representation of a Search State")
public  class SearchStateWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Url address of search state<br/><br/><i>Generated property</i> for <code>SearchStateWsDTO.url</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="url", description="Url address of search state") 	
	private String url;

	/** Query of search state<br/><br/><i>Generated property</i> for <code>SearchStateWsDTO.query</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="query", description="Query of search state") 	
	private SearchQueryWsDTO query;
	
	public SearchStateWsDTO()
	{
		// default constructor
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setQuery(final SearchQueryWsDTO query)
	{
		this.query = query;
	}

	public SearchQueryWsDTO getQuery() 
	{
		return query;
	}
	

}