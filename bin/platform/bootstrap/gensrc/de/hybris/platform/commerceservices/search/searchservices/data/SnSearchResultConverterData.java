/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.searchservices.data;

import java.io.Serializable;
import de.hybris.platform.commerceservices.search.solrfacetsearch.data.SolrSearchQueryData;
import de.hybris.platform.searchservices.admin.data.SnIndexConfiguration;
import de.hybris.platform.searchservices.admin.data.SnIndexType;


import java.util.Objects;
public  class SnSearchResultConverterData<Q,R>  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SnSearchResultConverterData<Q,R>.indexConfiguration</code> property defined at extension <code>commerceservices</code>. */
	
	private SnIndexConfiguration indexConfiguration;

	/** <i>Generated property</i> for <code>SnSearchResultConverterData<Q,R>.indexType</code> property defined at extension <code>commerceservices</code>. */
	
	private SnIndexType indexType;

	/** <i>Generated property</i> for <code>SnSearchResultConverterData<Q,R>.searchQuery</code> property defined at extension <code>commerceservices</code>. */
	
	private SolrSearchQueryData searchQuery;

	/** <i>Generated property</i> for <code>SnSearchResultConverterData<Q,R>.snSearchQuery</code> property defined at extension <code>commerceservices</code>. */
	
	private Q snSearchQuery;

	/** <i>Generated property</i> for <code>SnSearchResultConverterData<Q,R>.snSearchResult</code> property defined at extension <code>commerceservices</code>. */
	
	private R snSearchResult;
	
	public SnSearchResultConverterData()
	{
		// default constructor
	}
	
	public void setIndexConfiguration(final SnIndexConfiguration indexConfiguration)
	{
		this.indexConfiguration = indexConfiguration;
	}

	public SnIndexConfiguration getIndexConfiguration() 
	{
		return indexConfiguration;
	}
	
	public void setIndexType(final SnIndexType indexType)
	{
		this.indexType = indexType;
	}

	public SnIndexType getIndexType() 
	{
		return indexType;
	}
	
	public void setSearchQuery(final SolrSearchQueryData searchQuery)
	{
		this.searchQuery = searchQuery;
	}

	public SolrSearchQueryData getSearchQuery() 
	{
		return searchQuery;
	}
	
	public void setSnSearchQuery(final Q snSearchQuery)
	{
		this.snSearchQuery = snSearchQuery;
	}

	public Q getSnSearchQuery() 
	{
		return snSearchQuery;
	}
	
	public void setSnSearchResult(final R snSearchResult)
	{
		this.snSearchResult = snSearchResult;
	}

	public R getSnSearchResult() 
	{
		return snSearchResult;
	}
	

}