/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commercefacades.search.data.SearchQueryData;
import de.hybris.platform.commerceservices.search.facetdata.FacetData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SortData;
import java.util.List;


import java.util.Objects;
public  class OrderHistoriesData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderHistoriesData.orders</code> property defined at extension <code>commercefacades</code>. */
	
	private List<OrderHistoryData> orders;

	/** <i>Generated property</i> for <code>OrderHistoriesData.sorts</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>OrderHistoriesData.pagination</code> property defined at extension <code>commercefacades</code>. */
	
	private PaginationData pagination;

	/** <i>Generated property</i> for <code>OrderHistoriesData.facets</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private List<FacetData<SearchQueryData>> facets;
	
	public OrderHistoriesData()
	{
		// default constructor
	}
	
	public void setOrders(final List<OrderHistoryData> orders)
	{
		this.orders = orders;
	}

	public List<OrderHistoryData> getOrders() 
	{
		return orders;
	}
	
	public void setSorts(final List<SortData> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortData> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationData pagination)
	{
		this.pagination = pagination;
	}

	public PaginationData getPagination() 
	{
		return pagination;
	}
	
	public void setFacets(final List<FacetData<SearchQueryData>> facets)
	{
		this.facets = facets;
	}

	public List<FacetData<SearchQueryData>> getFacets() 
	{
		return facets;
	}
	

}