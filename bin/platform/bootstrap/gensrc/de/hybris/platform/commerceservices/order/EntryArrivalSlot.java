/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order;

import java.io.Serializable;
import de.hybris.platform.commerceservices.order.Accuracy;
import java.util.Date;


import java.util.Objects;
public  class EntryArrivalSlot  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Represents the number of items expected to arrive.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlot.quantity</code> property defined at extension <code>commerceservices</code>. */
	
	private Double quantity;

	/** The date associated with the expected arrival at.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlot.at</code> property defined at extension <code>commerceservices</code>. */
	
	private Date at;

	/** Describes the accuracy of the arrival slot as estimated, or unknown.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlot.accuracy</code> property defined at extension <code>commerceservices</code>. */
	
	private Accuracy accuracy;

	/** The warehouse of arrival slot<br/><br/><i>Generated property</i> for <code>EntryArrivalSlot.warehouse</code> property defined at extension <code>commerceservices</code>. */
	
	private String warehouse;
	
	public EntryArrivalSlot()
	{
		// default constructor
	}
	
	public void setQuantity(final Double quantity)
	{
		this.quantity = quantity;
	}

	public Double getQuantity() 
	{
		return quantity;
	}
	
	public void setAt(final Date at)
	{
		this.at = at;
	}

	public Date getAt() 
	{
		return at;
	}
	
	public void setAccuracy(final Accuracy accuracy)
	{
		this.accuracy = accuracy;
	}

	public Accuracy getAccuracy() 
	{
		return accuracy;
	}
	
	public void setWarehouse(final String warehouse)
	{
		this.warehouse = warehouse;
	}

	public String getWarehouse() 
	{
		return warehouse;
	}
	

}