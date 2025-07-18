/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.searchservices.data;

import java.io.Serializable;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.solrfacetsearch.data.SolrSearchQueryData;


import java.util.Objects;
public  class SnSearchQueryConverterData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SnSearchQueryConverterData.indexTypeId</code> property defined at extension <code>commerceservices</code>. */
	
	private String indexTypeId;

	/** <i>Generated property</i> for <code>SnSearchQueryConverterData.searchQuery</code> property defined at extension <code>commerceservices</code>. */
	
	private SolrSearchQueryData searchQuery;

	/** <i>Generated property</i> for <code>SnSearchQueryConverterData.pageable</code> property defined at extension <code>commerceservices</code>. */
	
	private PageableData pageable;
	
	public SnSearchQueryConverterData()
	{
		// default constructor
	}
	
	public void setIndexTypeId(final String indexTypeId)
	{
		this.indexTypeId = indexTypeId;
	}

	public String getIndexTypeId() 
	{
		return indexTypeId;
	}
	
	public void setSearchQuery(final SolrSearchQueryData searchQuery)
	{
		this.searchQuery = searchQuery;
	}

	public SolrSearchQueryData getSearchQuery() 
	{
		return searchQuery;
	}
	
	public void setPageable(final PageableData pageable)
	{
		this.pageable = pageable;
	}

	public PageableData getPageable() 
	{
		return pageable;
	}
	

}