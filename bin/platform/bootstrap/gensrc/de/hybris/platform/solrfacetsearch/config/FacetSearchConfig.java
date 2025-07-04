/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.config;

import java.io.Serializable;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.SearchConfig;
import de.hybris.platform.solrfacetsearch.config.SolrConfig;


import java.util.Objects;
public  class FacetSearchConfig  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FacetSearchConfig.name</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>FacetSearchConfig.description</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>FacetSearchConfig.indexConfig</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private IndexConfig indexConfig;

	/** <i>Generated property</i> for <code>FacetSearchConfig.searchConfig</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private SearchConfig searchConfig;

	/** <i>Generated property</i> for <code>FacetSearchConfig.solrConfig</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private SolrConfig solrConfig;
	
	public FacetSearchConfig()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setIndexConfig(final IndexConfig indexConfig)
	{
		this.indexConfig = indexConfig;
	}

	public IndexConfig getIndexConfig() 
	{
		return indexConfig;
	}
	
	public void setSearchConfig(final SearchConfig searchConfig)
	{
		this.searchConfig = searchConfig;
	}

	public SearchConfig getSearchConfig() 
	{
		return searchConfig;
	}
	
	public void setSolrConfig(final SolrConfig solrConfig)
	{
		this.solrConfig = solrConfig;
	}

	public SolrConfig getSolrConfig() 
	{
		return solrConfig;
	}
	

}