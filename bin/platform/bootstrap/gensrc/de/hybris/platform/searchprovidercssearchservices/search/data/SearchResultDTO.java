/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractFacetResponseDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.NamedSortDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.SearchHitDTO;
import java.util.List;


import java.util.Objects;
public  class SearchResultDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchResultDTO.count</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer count;

	/** <i>Generated property</i> for <code>SearchResultDTO.searchHits</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SearchHitDTO> searchHits;

	/** <i>Generated property</i> for <code>SearchResultDTO.facets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractFacetResponseDTO> facets;

	/** <i>Generated property</i> for <code>SearchResultDTO.sort</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private NamedSortDTO sort;

	/** <i>Generated property</i> for <code>SearchResultDTO.availableSorts</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<NamedSortDTO> availableSorts;
	
	public SearchResultDTO()
	{
		// default constructor
	}
	
	public void setCount(final Integer count)
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}
	
	public void setSearchHits(final List<SearchHitDTO> searchHits)
	{
		this.searchHits = searchHits;
	}

	public List<SearchHitDTO> getSearchHits() 
	{
		return searchHits;
	}
	
	public void setFacets(final List<AbstractFacetResponseDTO> facets)
	{
		this.facets = facets;
	}

	public List<AbstractFacetResponseDTO> getFacets() 
	{
		return facets;
	}
	
	public void setSort(final NamedSortDTO sort)
	{
		this.sort = sort;
	}

	public NamedSortDTO getSort() 
	{
		return sort;
	}
	
	public void setAvailableSorts(final List<NamedSortDTO> availableSorts)
	{
		this.availableSorts = availableSorts;
	}

	public List<NamedSortDTO> getAvailableSorts() 
	{
		return availableSorts;
	}
	

}