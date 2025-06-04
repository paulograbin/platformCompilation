/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerinterestsocc.dto;

import java.io.Serializable;
import de.hybris.platform.customerinterestsocc.dto.ProductInterestRelationWsDTO;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import de.hybris.platform.webservicescommons.dto.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Customer interests search page
 */
@Schema(name="customerInterestsSearchPage", description="Customer interests search page")
public  class CustomerInterestsSearchResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of product interest relation<br/><br/><i>Generated property</i> for <code>CustomerInterestsSearchResultWsDTO.results</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="results", description="List of product interest relation") 	
	private List<ProductInterestRelationWsDTO> results;

	/** Sorting information<br/><br/><i>Generated property</i> for <code>CustomerInterestsSearchResultWsDTO.sorts</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="sorts", description="Sorting information") 	
	private List<SortWsDTO> sorts;

	/** Pagination information<br/><br/><i>Generated property</i> for <code>CustomerInterestsSearchResultWsDTO.pagination</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="pagination", description="Pagination information") 	
	private PaginationWsDTO pagination;
	
	public CustomerInterestsSearchResultWsDTO()
	{
		// default constructor
	}
	
	public void setResults(final List<ProductInterestRelationWsDTO> results)
	{
		this.results = results;
	}

	public List<ProductInterestRelationWsDTO> getResults() 
	{
		return results;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}