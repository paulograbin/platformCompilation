/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Product List
 */
@Schema(name="ProductList", description="Representation of a Product List")
public  class ProductListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of products<br/><br/><i>Generated property</i> for <code>ProductListWsDTO.products</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="products", description="List of products") 	
	private List<ProductWsDTO> products;

	/** Catalog of product list<br/><br/><i>Generated property</i> for <code>ProductListWsDTO.catalog</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="catalog", description="Catalog of product list") 	
	private String catalog;

	/** Version of product list<br/><br/><i>Generated property</i> for <code>ProductListWsDTO.version</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="version", description="Version of product list") 	
	private String version;

	/** Total product count<br/><br/><i>Generated property</i> for <code>ProductListWsDTO.totalProductCount</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalProductCount", description="Total product count") 	
	private Integer totalProductCount;

	/** Total page count<br/><br/><i>Generated property</i> for <code>ProductListWsDTO.totalPageCount</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalPageCount", description="Total page count") 	
	private Integer totalPageCount;

	/** Number of current page<br/><br/><i>Generated property</i> for <code>ProductListWsDTO.currentPage</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currentPage", description="Number of current page") 	
	private Integer currentPage;
	
	public ProductListWsDTO()
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
	
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}

	public String getCatalog() 
	{
		return catalog;
	}
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getVersion() 
	{
		return version;
	}
	
	public void setTotalProductCount(final Integer totalProductCount)
	{
		this.totalProductCount = totalProductCount;
	}

	public Integer getTotalProductCount() 
	{
		return totalProductCount;
	}
	
	public void setTotalPageCount(final Integer totalPageCount)
	{
		this.totalPageCount = totalPageCount;
	}

	public Integer getTotalPageCount() 
	{
		return totalPageCount;
	}
	
	public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}

	public Integer getCurrentPage() 
	{
		return currentPage;
	}
	

}