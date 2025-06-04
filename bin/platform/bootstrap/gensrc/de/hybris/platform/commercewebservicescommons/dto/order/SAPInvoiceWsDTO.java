/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of an Invoice
 */
@Schema(name="SAPInvoice", description="Representation of an Invoice")
public  class SAPInvoiceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Invoice Id<br/><br/><i>Generated property</i> for <code>SAPInvoiceWsDTO.invoiceId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="invoiceId", description="Invoice Id", example="9560887") 	
	private String invoiceId;

	/** Invoice creation date<br/><br/><i>Generated property</i> for <code>SAPInvoiceWsDTO.createdAt</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="createdAt", description="Invoice creation date", example="2020-09-16T04:55:09.505Z") 	
	private Date createdAt;

	/** Total invoiced amount<br/><br/><i>Generated property</i> for <code>SAPInvoiceWsDTO.totalAmount</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalAmount", description="Total invoiced amount") 	
	private PriceWsDTO totalAmount;

	/** Net invoiced amount<br/><br/><i>Generated property</i> for <code>SAPInvoiceWsDTO.netAmount</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="netAmount", description="Net invoiced amount") 	
	private PriceWsDTO netAmount;

	/** External system identifier where the invoice resides.<br/><br/><i>Generated property</i> for <code>SAPInvoiceWsDTO.externalSystemId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="externalSystemId", description="External system identifier where the invoice resides.", example="S4SALES") 	
	private String externalSystemId;
	
	public SAPInvoiceWsDTO()
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
	
	public void setCreatedAt(final Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}
	
	public void setTotalAmount(final PriceWsDTO totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public PriceWsDTO getTotalAmount() 
	{
		return totalAmount;
	}
	
	public void setNetAmount(final PriceWsDTO netAmount)
	{
		this.netAmount = netAmount;
	}

	public PriceWsDTO getNetAmount() 
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