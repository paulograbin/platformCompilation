/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="SAPPaymentMethod")
public  class PaymentMethodWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Payment Method Code<br/><br/><i>Generated property</i> for <code>PaymentMethodWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Payment Method Code", required=true, example="CreditCard") 	
	private String code;

	/** Payment Method Name<br/><br/><i>Generated property</i> for <code>PaymentMethodWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Payment Method Name", required=true, example="Credit Card") 	
	private String name;
	
	public PaymentMethodWsDTO()
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
	

}