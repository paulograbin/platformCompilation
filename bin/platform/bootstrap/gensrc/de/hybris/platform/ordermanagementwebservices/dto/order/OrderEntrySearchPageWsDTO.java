/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import java.util.List;


import java.util.Objects;
public  class OrderEntrySearchPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderEntrySearchPageWsDTO.sorts</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<SortWsDTO> sorts;

	/** <i>Generated property</i> for <code>OrderEntrySearchPageWsDTO.pagination</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private PaginationWsDTO pagination;

	/** <i>Generated property</i> for <code>OrderEntrySearchPageWsDTO.orderEntries</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<OrderEntryWsDTO> orderEntries;
	
	public OrderEntrySearchPageWsDTO()
	{
		// default constructor
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
	
	public void setOrderEntries(final List<OrderEntryWsDTO> orderEntries)
	{
		this.orderEntries = orderEntries;
	}

	public List<OrderEntryWsDTO> getOrderEntries() 
	{
		return orderEntries;
	}
	

}