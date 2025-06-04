/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.SAPInvoiceWsDTO;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import de.hybris.platform.webservicescommons.dto.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Invoice List
 */
@Schema(name="SAPInvoiceList", description="Representation of an Invoice List")
public  class SAPInvoicesWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** list of invoice<br/><br/><i>Generated property</i> for <code>SAPInvoicesWsDTO.invoices</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="invoices", description="list of invoice") 	
	private List<SAPInvoiceWsDTO> invoices;

	/** sorting information<br/><br/><i>Generated property</i> for <code>SAPInvoicesWsDTO.sorts</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sorts", description="sorting information") 	
	private List<SortWsDTO> sorts;

	/** pagination information<br/><br/><i>Generated property</i> for <code>SAPInvoicesWsDTO.pagination</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="pagination", description="pagination information") 	
	private PaginationWsDTO pagination;
	
	public SAPInvoicesWsDTO()
	{
		// default constructor
	}
	
	public void setInvoices(final List<SAPInvoiceWsDTO> invoices)
	{
		this.invoices = invoices;
	}

	public List<SAPInvoiceWsDTO> getInvoices() 
	{
		return invoices;
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