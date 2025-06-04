/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderHistoryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.FacetWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Order History List
 */
@Schema(name="OrderHistoryList", description="Representation of an Order History List")
public  class OrderHistoryListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of order history items<br/><br/><i>Generated property</i> for <code>OrderHistoryListWsDTO.orders</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="orders", description="List of order history items") 	
	private List<OrderHistoryWsDTO> orders;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>OrderHistoryListWsDTO.sorts</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>OrderHistoryListWsDTO.pagination</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items") 	
	private PaginationWsDTO pagination;

	/** List of facets<br/><br/><i>Generated property</i> for <code>OrderHistoryListWsDTO.facets</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="facets", description="List of facets") 	
	private List<FacetWsDTO> facets;
	
	public OrderHistoryListWsDTO()
	{
		// default constructor
	}
	
	public void setOrders(final List<OrderHistoryWsDTO> orders)
	{
		this.orders = orders;
	}

	public List<OrderHistoryWsDTO> getOrders() 
	{
		return orders;
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
	
	public void setFacets(final List<FacetWsDTO> facets)
	{
		this.facets = facets;
	}

	public List<FacetWsDTO> getFacets() 
	{
		return facets;
	}
	

}