/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.invoice.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PriceData;
import java.util.Date;


import java.util.Objects;
public  class SAPInvoiceData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SAPInvoiceData.invoiceId</code> property defined at extension <code>commercefacades</code>. */
	
	private String invoiceId;

	/** <i>Generated property</i> for <code>SAPInvoiceData.invoiceDate</code> property defined at extension <code>commercefacades</code>. */
	
	private Date invoiceDate;

	/** <i>Generated property</i> for <code>SAPInvoiceData.totalAmount</code> property defined at extension <code>commercefacades</code>. */
	
	private PriceData totalAmount;

	/** <i>Generated property</i> for <code>SAPInvoiceData.netAmount</code> property defined at extension <code>commercefacades</code>. */
	
	private PriceData netAmount;

	/** <i>Generated property</i> for <code>SAPInvoiceData.externalSystemId</code> property defined at extension <code>commercefacades</code>. */
	
	private String externalSystemId;
	
	public SAPInvoiceData()
	{
		// default constructor
	}
	
	public void setInvoiceId(final String invoiceId)
	{
		this.invoiceId = invoiceId;
	}

	public String getInvoiceId() 
	{
		return invoiceId;
	}
	
	public void setInvoiceDate(final Date invoiceDate)
	{
		this.invoiceDate = invoiceDate;
	}

	public Date getInvoiceDate() 
	{
		return invoiceDate;
	}
	
	public void setTotalAmount(final PriceData totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public PriceData getTotalAmount() 
	{
		return totalAmount;
	}
	
	public void setNetAmount(final PriceData netAmount)
	{
		this.netAmount = netAmount;
	}

	public PriceData getNetAmount() 
	{
		return netAmount;
	}
	
	public void setExternalSystemId(final String externalSystemId)
	{
		this.externalSystemId = externalSystemId;
	}

	public String getExternalSystemId() 
	{
		return externalSystemId;
	}
	

}