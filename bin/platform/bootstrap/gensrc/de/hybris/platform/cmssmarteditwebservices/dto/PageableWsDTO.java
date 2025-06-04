/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Pageable DTO
 */
@Schema(name="PageableWsDTO", description="Pageable DTO")
public  class PageableWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageableWsDTO.pageSize</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pageSize") 	
	private int pageSize;

	/** <i>Generated property</i> for <code>PageableWsDTO.currentPage</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="currentPage") 	
	private int currentPage;

	/** <i>Generated property</i> for <code>PageableWsDTO.sort</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="sort") 	
	private String sort;
	
	public PageableWsDTO()
	{
		// default constructor
	}
	
	public void setPageSize(final int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getPageSize() 
	{
		return pageSize;
	}
	
	public void setCurrentPage(final int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getCurrentPage() 
	{
		return currentPage;
	}
	
	public void setSort(final String sort)
	{
		this.sort = sort;
	}

	public String getSort() 
	{
		return sort;
	}
	

}