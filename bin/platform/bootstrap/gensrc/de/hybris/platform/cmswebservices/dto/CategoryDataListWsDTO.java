/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available product categories.
 */
@Schema(name="CategoryDataListWsDTO", description="Specifies a list of available product categories.")
public  class CategoryDataListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CategoryDataListWsDTO.productCategories</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="productCategories") 	
	private List<CategoryWsDTO> productCategories;

	/** <i>Generated property</i> for <code>CategoryDataListWsDTO.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public CategoryDataListWsDTO()
	{
		// default constructor
	}
	
	public void setProductCategories(final List<CategoryWsDTO> productCategories)
	{
		this.productCategories = productCategories;
	}

	public List<CategoryWsDTO> getProductCategories() 
	{
		return productCategories;
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