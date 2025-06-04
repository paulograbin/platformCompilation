/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.AbstractPageData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available pages.
 *
 * @deprecated no longer needed
 */
@Schema(name="PageListData", description="Specifies a list of available pages.")
@Deprecated(since = "6.6", forRemoval = true)
public  class PageListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageListData.pages</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pages") 	
	private List<AbstractPageData> pages;

	/** <i>Generated property</i> for <code>PageListData.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public PageListData()
	{
		// default constructor
	}
	
	public void setPages(final List<AbstractPageData> pages)
	{
		this.pages = pages;
	}

	public List<AbstractPageData> getPages() 
	{
		return pages;
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