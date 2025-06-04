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
import de.hybris.platform.commercefacades.order.data.Accuracy;
import java.util.Date;


import java.util.Objects;
public  class EntryArrivalSlotData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Represents the number of items expected to arrive.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlotData.quantity</code> property defined at extension <code>commercefacades</code>. */
	
	private Double quantity;

	/** The date associated with the expected arrival at.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlotData.at</code> property defined at extension <code>commercefacades</code>. */
	
	private Date at;

	/** Describes the accuracy of the arrival at as estimated, or unknown.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlotData.accuracy</code> property defined at extension <code>commercefacades</code>. */
	
	private Accuracy accuracy;
	
	public EntryArrivalSlotData()
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
	

}