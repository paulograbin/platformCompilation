/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.order.ReplenishmentOrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Replenishment Order List
 */
@Schema(name="ReplenishmentOrderList", description="Representation of a Replenishment Order List")
public  class ReplenishmentOrderListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Replenishment Orders<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderListWsDTO.replenishmentOrders</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="replenishmentOrders", description="List of Replenishment Orders") 	
	private List<ReplenishmentOrderWsDTO> replenishmentOrders;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items") 	
	private PaginationWsDTO pagination;
	
	public ReplenishmentOrderListWsDTO()
	{
		// default constructor
	}
	
	public void setReplenishmentOrders(final List<ReplenishmentOrderWsDTO> replenishmentOrders)
	{
		this.replenishmentOrders = replenishmentOrders;
	}

	public List<ReplenishmentOrderWsDTO> getReplenishmentOrders() 
	{
		return replenishmentOrders;
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