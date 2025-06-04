/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="ProductSearchResultWsDTO")
public  class ProductSearchResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductSearchResultWsDTO.products</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="products") 	
	private List<ProductWsDTO> products;

	/** <i>Generated property</i> for <code>ProductSearchResultWsDTO.pagination</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pagination") 	
	private PaginationWsDTO pagination;
	
	public ProductSearchResultWsDTO()
	{
		// default constructor
	}
	
	public void setProducts(final List<ProductWsDTO> products)
	{
		this.products = products;
	}

	public List<ProductWsDTO> getProducts() 
	{
		return products;
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