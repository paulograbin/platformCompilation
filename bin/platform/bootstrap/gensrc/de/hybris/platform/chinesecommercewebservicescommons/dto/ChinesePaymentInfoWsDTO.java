/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Chinese payment info
 */
@Schema(name="ChinesePaymentInfo", description="Chinese payment info")
public  class ChinesePaymentInfoWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Chinese payment info identifier<br/><br/><i>Generated property</i> for <code>ChinesePaymentInfoWsDTO.id</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="id", description="Chinese payment info identifier") 	
	private String id;

	/** Payment provider of Chinese payment info<br/><br/><i>Generated property</i> for <code>ChinesePaymentInfoWsDTO.paymentProvider</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="paymentProvider", description="Payment provider of Chinese payment info") 	
	private String paymentProvider;

	/** The serviceType which is used for payment and defined in different payment providers<br/><br/><i>Generated property</i> for <code>ChinesePaymentInfoWsDTO.serviceType</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="serviceType", description="The serviceType which is used for payment and defined in different payment providers", example="DirectPay") 	
	private String serviceType;

	/** Logo url of payment provider<br/><br/><i>Generated property</i> for <code>ChinesePaymentInfoWsDTO.paymentProviderLogo</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="paymentProviderLogo", description="Logo url of payment provider", example="/medias/wechatpay.png?context=CONTEXT") 	
	private String paymentProviderLogo;

	/** Name of payment provider<br/><br/><i>Generated property</i> for <code>ChinesePaymentInfoWsDTO.paymentProviderName</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="paymentProviderName", description="Name of payment provider") 	
	private String paymentProviderName;
	
	public ChinesePaymentInfoWsDTO()
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
	
	public void setPaymentProvider(final String paymentProvider)
	{
		this.paymentProvider = paymentProvider;
	}

	public String getPaymentProvider() 
	{
		return paymentProvider;
	}
	
	public void setServiceType(final String serviceType)
	{
		this.serviceType = serviceType;
	}

	public String getServiceType() 
	{
		return serviceType;
	}
	
	public void setPaymentProviderLogo(final String paymentProviderLogo)
	{
		this.paymentProviderLogo = paymentProviderLogo;
	}

	public String getPaymentProviderLogo() 
	{
		return paymentProviderLogo;
	}
	
	public void setPaymentProviderName(final String paymentProviderName)
	{
		this.paymentProviderName = paymentProviderName;
	}

	public String getPaymentProviderName() 
	{
		return paymentProviderName;
	}
	

}