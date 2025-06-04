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
import de.hybris.platform.b2bwebservicescommons.dto.order.OrderApprovalWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Order Approval List
 */
@Schema(name="OrderApprovalList", description="Representation of a Order Approval List")
public  class OrderApprovalListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Order Approvals<br/><br/><i>Generated property</i> for <code>OrderApprovalListWsDTO.orderApprovals</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orderApprovals", description="List of Order Approvals", required=true) 	
	private List<OrderApprovalWsDTO> orderApprovals;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>OrderApprovalListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts", required=true) 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>OrderApprovalListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items", required=true) 	
	private PaginationWsDTO pagination;
	
	public OrderApprovalListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderApprovals(final List<OrderApprovalWsDTO> orderApprovals)
	{
		this.orderApprovals = orderApprovals;
	}

	public List<OrderApprovalWsDTO> getOrderApprovals() 
	{
		return orderApprovals;
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