/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Pagination info
 */
@Schema(name="pagination", description="Pagination info")
public  class PaginationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Number of elements on this page<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.count</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="count", description="Number of elements on this page") 	
	private Integer count;

	/** Total number of elements<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.totalCount</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="totalCount", description="Total number of elements") 	
	private Long totalCount;

	/** Current page number<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.page</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="page", description="Current page number") 	
	private Integer page;

	/** Total number of pages<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.totalPages</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="totalPages", description="Total number of pages") 	
	private Integer totalPages;

	/** Indicates if there is next page<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.hasNext</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="hasNext", description="Indicates if there is next page") 	
	private Boolean hasNext;

	/** Indicates if there is previous page<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.hasPrevious</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="hasPrevious", description="Indicates if there is previous page") 	
	private Boolean hasPrevious;
	
	public PaginationWsDTO()
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
	
	public void setTotalCount(final Long totalCount)
	{
		this.totalCount = totalCount;
	}

	public Long getTotalCount() 
	{
		return totalCount;
	}
	
	public void setPage(final Integer page)
	{
		this.page = page;
	}

	public Integer getPage() 
	{
		return page;
	}
	
	public void setTotalPages(final Integer totalPages)
	{
		this.totalPages = totalPages;
	}

	public Integer getTotalPages() 
	{
		return totalPages;
	}
	
	public void setHasNext(final Boolean hasNext)
	{
		this.hasNext = hasNext;
	}

	public Boolean getHasNext() 
	{
		return hasNext;
	}
	
	public void setHasPrevious(final Boolean hasPrevious)
	{
		this.hasPrevious = hasPrevious;
	}

	public Boolean getHasPrevious() 
	{
		return hasPrevious;
	}
	

}