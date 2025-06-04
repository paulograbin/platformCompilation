/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorservices.document.data;

import java.io.Serializable;
import java.math.BigDecimal;


import java.util.Objects;
public  class B2BDragAndDropData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BDragAndDropData.amount</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private BigDecimal amount;

	/** <i>Generated property</i> for <code>B2BDragAndDropData.useNumber</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String useNumber;

	/** <i>Generated property</i> for <code>B2BDragAndDropData.payNumber</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String payNumber;
	
	public B2BDragAndDropData()
	{
		// default constructor
	}
	
	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	public BigDecimal getAmount() 
	{
		return amount;
	}
	
	public void setUseNumber(final String useNumber)
	{
		this.useNumber = useNumber;
	}

	public String getUseNumber() 
	{
		return useNumber;
	}
	
	public void setPayNumber(final String payNumber)
	{
		this.payNumber = payNumber;
	}

	public String getPayNumber() 
	{
		return payNumber;
	}
	

}