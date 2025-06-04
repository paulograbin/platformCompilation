/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.CardTypeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Payment Detail
 */
@Schema(name="C360PaymentDetail", description="Representation of a Payment Detail")
public  class C360PaymentDetailWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Unique identifier of payment detail<br/><br/><i>Generated property</i> for <code>C360PaymentDetailWsDTO.id</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="id", description="Unique identifier of payment detail", example="8796125822999") 	
	private String id;

	/** Payment card type<br/><br/><i>Generated property</i> for <code>C360PaymentDetailWsDTO.cardType</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="cardType", description="Payment card type") 	
	private CardTypeWsDTO cardType;

	/** Payment card number<br/><br/><i>Generated property</i> for <code>C360PaymentDetailWsDTO.cardNumber</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="cardNumber", description="Payment card number", example="************6182") 	
	private String cardNumber;

	/** Month of expiration of payment<br/><br/><i>Generated property</i> for <code>C360PaymentDetailWsDTO.expiryMonth</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="expiryMonth", description="Month of expiration of payment", example="02") 	
	private String expiryMonth;

	/** Year of expiration of payment<br/><br/><i>Generated property</i> for <code>C360PaymentDetailWsDTO.expiryYear</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="expiryYear", description="Year of expiration of payment", example="2999") 	
	private String expiryYear;

	/** Whether the payment information is the default one<br/><br/><i>Generated property</i> for <code>C360PaymentDetailWsDTO.defaultPayment</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="defaultPayment", description="Whether the payment information is the default one", example="true") 	
	private boolean defaultPayment;
	
	public C360PaymentDetailWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setCardType(final CardTypeWsDTO cardType)
	{
		this.cardType = cardType;
	}

	public CardTypeWsDTO getCardType() 
	{
		return cardType;
	}
	
	public void setCardNumber(final String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() 
	{
		return cardNumber;
	}
	
	public void setExpiryMonth(final String expiryMonth)
	{
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryMonth() 
	{
		return expiryMonth;
	}
	
	public void setExpiryYear(final String expiryYear)
	{
		this.expiryYear = expiryYear;
	}

	public String getExpiryYear() 
	{
		return expiryYear;
	}
	
	public void setDefaultPayment(final boolean defaultPayment)
	{
		this.defaultPayment = defaultPayment;
	}

	public boolean isDefaultPayment() 
	{
		return defaultPayment;
	}
	

}