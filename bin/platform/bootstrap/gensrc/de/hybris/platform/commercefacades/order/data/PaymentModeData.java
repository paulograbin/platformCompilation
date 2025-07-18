/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;


import java.util.Objects;
public  class PaymentModeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PaymentModeData.code</code> property defined at extension <code>commercefacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>PaymentModeData.name</code> property defined at extension <code>commercefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>PaymentModeData.description</code> property defined at extension <code>commercefacades</code>. */
	
	private String description;
	
	public PaymentModeData()
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
	

}