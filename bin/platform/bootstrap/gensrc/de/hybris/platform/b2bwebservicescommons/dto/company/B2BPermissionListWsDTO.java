/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Order Approval Permission List
 */
@Schema(name="OrderApprovalPermissionList", description="Representation of a Order Approval Permission List")
public  class B2BPermissionListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Order Approval Permissions<br/><br/><i>Generated property</i> for <code>B2BPermissionListWsDTO.orderApprovalPermissions</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orderApprovalPermissions", description="List of Order Approval Permissions", required=true) 	
	private List<B2BPermissionWsDTO> orderApprovalPermissions;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>B2BPermissionListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts", required=true) 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>B2BPermissionListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items", required=true) 	
	private PaginationWsDTO pagination;
	
	public B2BPermissionListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderApprovalPermissions(final List<B2BPermissionWsDTO> orderApprovalPermissions)
	{
		this.orderApprovalPermissions = orderApprovalPermissions;
	}

	public List<B2BPermissionWsDTO> getOrderApprovalPermissions() 
	{
		return orderApprovalPermissions;
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