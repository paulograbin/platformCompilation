/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.catalog.data;

import de.hybris.platform.commercefacades.catalog.data.AbstractCatalogItemData;
import de.hybris.platform.commercefacades.catalog.data.CategoryHierarchyData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import java.util.List;


import java.util.Objects;
public  class CategoryHierarchyData extends AbstractCatalogItemData 

{



	/** <i>Generated property</i> for <code>CategoryHierarchyData.pageSize</code> property defined at extension <code>commercefacades</code>. */
	
	private Integer pageSize;

	/** <i>Generated property</i> for <code>CategoryHierarchyData.totalNumber</code> property defined at extension <code>commercefacades</code>. */
	
	private Integer totalNumber;

	/** <i>Generated property</i> for <code>CategoryHierarchyData.currentPage</code> property defined at extension <code>commercefacades</code>. */
	
	private Integer currentPage;

	/** <i>Generated property</i> for <code>CategoryHierarchyData.numberOfPages</code> property defined at extension <code>commercefacades</code>. */
	
	private Integer numberOfPages;

	/** <i>Generated property</i> for <code>CategoryHierarchyData.subcategories</code> property defined at extension <code>commercefacades</code>. */
	
	private List<CategoryHierarchyData> subcategories;

	/** <i>Generated property</i> for <code>CategoryHierarchyData.products</code> property defined at extension <code>commercefacades</code>. */
	
	private List<ProductData> products;
	
	public CategoryHierarchyData()
	{
		// default constructor
	}
	
	public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public Integer getPageSize() 
	{
		return pageSize;
	}
	
	public void setTotalNumber(final Integer totalNumber)
	{
		this.totalNumber = totalNumber;
	}

	public Integer getTotalNumber() 
	{
		return totalNumber;
	}
	
	public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}

	public Integer getCurrentPage() 
	{
		return currentPage;
	}
	
	public void setNumberOfPages(final Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}

	public Integer getNumberOfPages() 
	{
		return numberOfPages;
	}
	
	public void setSubcategories(final List<CategoryHierarchyData> subcategories)
	{
		this.subcategories = subcategories;
	}

	public List<CategoryHierarchyData> getSubcategories() 
	{
		return subcategories;
	}
	
	public void setProducts(final List<ProductData> products)
	{
		this.products = products;
	}

	public List<ProductData> getProducts() 
	{
		return products;
	}
	

}