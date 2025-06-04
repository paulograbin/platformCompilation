/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.AccuracyWsDTOType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Records of item arrivals facilitate the tracking and management of item quantities, associated arrival times, and certainty levels. These records distinguish between guaranteed, estimated, and unknown arrival scenarios.
 */
@Schema(name="EntryArrivalSlotWsDTO", description="Records of item arrivals facilitate the tracking and management of item quantities, associated arrival times, and certainty levels. These records distinguish between guaranteed, estimated, and unknown arrival scenarios.")
public  class EntryArrivalSlotWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Represents the number of items expected to arrive.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlotWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Represents the number of items expected to arrive.", example="12") 	
	private Double quantity;

	/** The date associated with the expected arrival slot.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlotWsDTO.at</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="at", description="The date associated with the expected arrival slot.", example="2024-01-18T17:40:46+05:30") 	
	private Date at;

	/** The accuracy of the arrival slot as estimated, or unknown.<br/><br/><i>Generated property</i> for <code>EntryArrivalSlotWsDTO.accuracy</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="accuracy", description="The accuracy of the arrival slot as estimated, or unknown.", example="ESTIMATED") 	
	private AccuracyWsDTOType accuracy;
	
	public EntryArrivalSlotWsDTO()
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
	
	public void setAccuracy(final AccuracyWsDTOType accuracy)
	{
		this.accuracy = accuracy;
	}

	public AccuracyWsDTOType getAccuracy() 
	{
		return accuracy;
	}
	

}