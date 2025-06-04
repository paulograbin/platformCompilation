/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the page.
 */
@Schema(name="PageableWsDTO", description="Specifies properties of the page.")
public  class PageableWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageableWsDTO.pageSize</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageSize", example="2") 	
	private int pageSize;

	/** <i>Generated property</i> for <code>PageableWsDTO.currentPage</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="currentPage", example="1") 	
	private int currentPage;

	/** <i>Generated property</i> for <code>PageableWsDTO.sort</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="sort", example="Name") 	
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