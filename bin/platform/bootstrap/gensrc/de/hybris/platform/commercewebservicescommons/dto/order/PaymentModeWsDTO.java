/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Payment Mode
 */
@Schema(name="PaymentMode", description="Representation of a Payment Mode")
public  class PaymentModeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Payment mode code<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Payment mode code") 	
	private String code;

	/** Payment mode name<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Payment mode name") 	
	private String name;

	/** Payment mode description<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Payment mode description") 	
	private String description;

	/** Logo url of payment mode<br/><br/><i>Generated property</i> for <code>PaymentModeWsDTO.pspLogoUrl</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="pspLogoUrl", description="Logo url of payment mode", example="/medias/wechatpay.png?context=CONTEXT") 	
	private String pspLogoUrl;
	
	public PaymentModeWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setPspLogoUrl(final String pspLogoUrl)
	{
		this.pspLogoUrl = pspLogoUrl;
	}

	public String getPspLogoUrl() 
	{
		return pspLogoUrl;
	}
	

}