/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.payment;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.PaymentDetailsWsDTO;
import de.hybris.platform.ordermanagementwebservices.dto.payment.PaymentTransactionEntryWsDTO;
import java.math.BigDecimal;
import java.util.List;


import java.util.Objects;
public  class PaymentTransactionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.code</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.currencyIsocode</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String currencyIsocode;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.entries</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<PaymentTransactionEntryWsDTO> entries;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.paymentInfo</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private PaymentDetailsWsDTO paymentInfo;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.paymentProvider</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String paymentProvider;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.plannedAmount</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private BigDecimal plannedAmount;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.requestId</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String requestId;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.requestToken</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String requestToken;

	/** <i>Generated property</i> for <code>PaymentTransactionWsDTO.versionID</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String versionID;
	
	public PaymentTransactionWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCurrencyIsocode(final String currencyIsocode)
	{
		this.currencyIsocode = currencyIsocode;
	}

	public String getCurrencyIsocode() 
	{
		return currencyIsocode;
	}
	
	public void setEntries(final List<PaymentTransactionEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<PaymentTransactionEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setPaymentInfo(final PaymentDetailsWsDTO paymentInfo)
	{
		this.paymentInfo = paymentInfo;
	}

	public PaymentDetailsWsDTO getPaymentInfo() 
	{
		return paymentInfo;
	}
	
	public void setPaymentProvider(final String paymentProvider)
	{
		this.paymentProvider = paymentProvider;
	}

	public String getPaymentProvider() 
	{
		return paymentProvider;
	}
	
	public void setPlannedAmount(final BigDecimal plannedAmount)
	{
		this.plannedAmount = plannedAmount;
	}

	public BigDecimal getPlannedAmount() 
	{
		return plannedAmount;
	}
	
	public void setRequestId(final String requestId)
	{
		this.requestId = requestId;
	}

	public String getRequestId() 
	{
		return requestId;
	}
	
	public void setRequestToken(final String requestToken)
	{
		this.requestToken = requestToken;
	}

	public String getRequestToken() 
	{
		return requestToken;
	}
	
	public void setVersionID(final String versionID)
	{
		this.versionID = versionID;
	}

	public String getVersionID() 
	{
		return versionID;
	}
	

}