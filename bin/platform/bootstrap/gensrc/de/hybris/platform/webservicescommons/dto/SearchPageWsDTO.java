/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webservicescommons.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import de.hybris.platform.webservicescommons.dto.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Includes all necessary data for creating proper result in refine search
 */
@Schema(name="searchPage", description="Includes all necessary data for creating proper result in refine search")
public  class SearchPageWsDTO<RESULT>  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Result list<br/><br/><i>Generated property</i> for <code>SearchPageWsDTO<RESULT>.results</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="results", description="Result list") 	
	private List<RESULT> results;

	/** <i>Generated property</i> for <code>SearchPageWsDTO<RESULT>.sorts</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination info<br/><br/><i>Generated property</i> for <code>SearchPageWsDTO<RESULT>.pagination</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="pagination", description="Pagination info") 	
	private PaginationWsDTO pagination;
	
	public SearchPageWsDTO()
	{
		// default constructor
	}
	
	public void setResults(final List<RESULT> results)
	{
		this.results = results;
	}

	public List<RESULT> getResults() 
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