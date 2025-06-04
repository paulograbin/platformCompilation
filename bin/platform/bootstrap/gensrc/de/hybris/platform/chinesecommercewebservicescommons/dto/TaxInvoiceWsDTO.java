/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * data type of tax invoice
 */
@Schema(name="TaxInvoice", description="data type of tax invoice")
public  class TaxInvoiceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** recipient type<br/><br/><i>Generated property</i> for <code>TaxInvoiceWsDTO.recipientType</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="recipientType", description="recipient type", example="INDIVIDUAL") 	
	private String recipientType;

	/** name of recipient<br/><br/><i>Generated property</i> for <code>TaxInvoiceWsDTO.recipient</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="recipient", description="name of recipient") 	
	private String recipient;

	/** taxpayer identification number<br/><br/><i>Generated property</i> for <code>TaxInvoiceWsDTO.taxpayerID</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="taxpayerID", description="taxpayer identification number") 	
	private String taxpayerID;
	
	public TaxInvoiceWsDTO()
	{
		// default constructor
	}
	
	public void setRecipientType(final String recipientType)
	{
		this.recipientType = recipientType;
	}

	public String getRecipientType() 
	{
		return recipientType;
	}
	
	public void setRecipient(final String recipient)
	{
		this.recipient = recipient;
	}

	public String getRecipient() 
	{
		return recipient;
	}
	
	public void setTaxpayerID(final String taxpayerID)
	{
		this.taxpayerID = taxpayerID;
	}

	public String getTaxpayerID() 
	{
		return taxpayerID;
	}
	

}