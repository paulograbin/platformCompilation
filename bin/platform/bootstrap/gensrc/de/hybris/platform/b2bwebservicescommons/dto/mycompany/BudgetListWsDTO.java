/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.mycompany;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.mycompany.BudgetWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Budget List
 */
@Schema(name="BudgetList", description="Representation of a Budget List")
public  class BudgetListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Budgets<br/><br/><i>Generated property</i> for <code>BudgetListWsDTO.budgets</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="budgets", description="List of Budgets") 	
	private List<BudgetWsDTO> budgets;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>BudgetListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>BudgetListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items") 	
	private PaginationWsDTO pagination;
	
	public BudgetListWsDTO()
	{
		// default constructor
	}
	
	public void setBudgets(final List<BudgetWsDTO> budgets)
	{
		this.budgets = budgets;
	}

	public List<BudgetWsDTO> getBudgets() 
	{
		return budgets;
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