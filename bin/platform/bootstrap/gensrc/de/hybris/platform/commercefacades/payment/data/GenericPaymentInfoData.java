/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.payment.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.SAPCapturePattern;
import de.hybris.platform.commercefacades.order.data.CardTypeData;
import de.hybris.platform.commercefacades.payment.data.PaymentMethodData;


import java.util.Objects;
public  class GenericPaymentInfoData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.id</code> property defined at extension <code>commercefacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.cartId</code> property defined at extension <code>commercefacades</code>. */
	
	private String cartId;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.capturePattern</code> property defined at extension <code>commercefacades</code>. */
	
	private SAPCapturePattern capturePattern;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.paymentMethod</code> property defined at extension <code>commercefacades</code>. */
	
	private PaymentMethodData paymentMethod;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.cardNumber</code> property defined at extension <code>commercefacades</code>. */
	
	private String cardNumber;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.cardType</code> property defined at extension <code>commercefacades</code>. */
	
	private CardTypeData cardType;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.expiryMonth</code> property defined at extension <code>commercefacades</code>. */
	
	private String expiryMonth;

	/** <i>Generated property</i> for <code>GenericPaymentInfoData.expiryYear</code> property defined at extension <code>commercefacades</code>. */
	
	private String expiryYear;
	
	public GenericPaymentInfoData()
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
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		return cartId;
	}
	
	public void setCapturePattern(final SAPCapturePattern capturePattern)
	{
		this.capturePattern = capturePattern;
	}

	public SAPCapturePattern getCapturePattern() 
	{
		return capturePattern;
	}
	
	public void setPaymentMethod(final PaymentMethodData paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public PaymentMethodData getPaymentMethod() 
	{
		return paymentMethod;
	}
	
	public void setCardNumber(final String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() 
	{
		return cardNumber;
	}
	
	public void setCardType(final CardTypeData cardType)
	{
		this.cardType = cardType;
	}

	public CardTypeData getCardType() 
	{
		return cardType;
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
	

}