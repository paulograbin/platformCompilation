/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Product configuration message.
 */
@Schema(name="CCPMessage", description="Product configuration message.")
public  class ProductConfigMessageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Message text.<br/><br/><i>Generated property</i> for <code>ProductConfigMessageWsDTO.message</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="message", description="Message text.", example="Message text.") 	
	private String message;

	/** Message severity.<br/><br/><i>Generated property</i> for <code>ProductConfigMessageWsDTO.severity</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="severity", description="Message severity.", example="INFO") 	
	private String severity;

	/** Message promotion type.<br/><br/><i>Generated property</i> for <code>ProductConfigMessageWsDTO.promoType</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="promoType", description="Message promotion type.", example="PROMO_APPLIED") 	
	private String promoType;

	/** Extended message text.<br/><br/><i>Generated property</i> for <code>ProductConfigMessageWsDTO.extendedMessage</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="extendedMessage", description="Extended message text.", example="Extended message text") 	
	private String extendedMessage;

	/** Offer expiration date.<br/><br/><i>Generated property</i> for <code>ProductConfigMessageWsDTO.endDate</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="endDate", description="Offer expiration date.", example="11/30/22") 	
	private String endDate;
	
	public ProductConfigMessageWsDTO()
	{
		// default constructor
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setSeverity(final String severity)
	{
		this.severity = severity;
	}

	public String getSeverity() 
	{
		return severity;
	}
	
	public void setPromoType(final String promoType)
	{
		this.promoType = promoType;
	}

	public String getPromoType() 
	{
		return promoType;
	}
	
	public void setExtendedMessage(final String extendedMessage)
	{
		this.extendedMessage = extendedMessage;
	}

	public String getExtendedMessage() 
	{
		return extendedMessage;
	}
	
	public void setEndDate(final String endDate)
	{
		this.endDate = endDate;
	}

	public String getEndDate() 
	{
		return endDate;
	}
	

}