/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.invoice.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.invoice.data.SAPInvoiceData;
import de.hybris.platform.core.servicelayer.data.PaginationData;
import de.hybris.platform.core.servicelayer.data.SortData;
import java.util.List;


import java.util.Objects;
public  class SAPInvoicesData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SAPInvoicesData.invoices</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SAPInvoiceData> invoices;

	/** <i>Generated property</i> for <code>SAPInvoicesData.sorts</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>SAPInvoicesData.pagination</code> property defined at extension <code>commercefacades</code>. */
	
	private PaginationData pagination;
	
	public SAPInvoicesData()
	{
		// default constructor
	}
	
	public void setInvoices(final List<SAPInvoiceData> invoices)
	{
		this.invoices = invoices;
	}

	public List<SAPInvoiceData> getInvoices() 
	{
		return invoices;
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
	

}