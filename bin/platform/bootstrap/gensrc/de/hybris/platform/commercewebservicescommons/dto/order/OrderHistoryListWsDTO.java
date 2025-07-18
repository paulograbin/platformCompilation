/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderHistoryWsDTO;
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
	

}