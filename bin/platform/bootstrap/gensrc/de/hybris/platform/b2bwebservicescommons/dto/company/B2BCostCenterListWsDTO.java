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
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a cost center list
 */
@Schema(name="B2BCostCenterList", description="Representation of a cost center list")
public  class B2BCostCenterListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of cost centers<br/><br/><i>Generated property</i> for <code>B2BCostCenterListWsDTO.costCenters</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="costCenters", description="List of cost centers") 	
	private List<B2BCostCenterWsDTO> costCenters;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>B2BCostCenterListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>B2BCostCenterListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items") 	
	private PaginationWsDTO pagination;
	
	public B2BCostCenterListWsDTO()
	{
		// default constructor
	}
	
	public void setCostCenters(final List<B2BCostCenterWsDTO> costCenters)
	{
		this.costCenters = costCenters;
	}

	public List<B2BCostCenterWsDTO> getCostCenters() 
	{
		return costCenters;
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