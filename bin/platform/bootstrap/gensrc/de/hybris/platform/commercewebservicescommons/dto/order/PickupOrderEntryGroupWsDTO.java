/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.store.PointOfServiceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Pickup Order Entry Group
 */
@Schema(name="PickupOrderEntryGroup", description="Representation of a Pickup Order Entry Group")
public  class PickupOrderEntryGroupWsDTO extends OrderEntryGroupWsDTO 

{



	/** Delivery point of service<br/><br/><i>Generated property</i> for <code>PickupOrderEntryGroupWsDTO.deliveryPointOfService</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryPointOfService", description="Delivery point of service") 	
	private PointOfServiceWsDTO deliveryPointOfService;

	/** Distance calculated to pickup place<br/><br/><i>Generated property</i> for <code>PickupOrderEntryGroupWsDTO.distance</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="distance", description="Distance calculated to pickup place") 	
	private Double distance;
	
	public PickupOrderEntryGroupWsDTO()
	{
		// default constructor
	}
	
	public void setDeliveryPointOfService(final PointOfServiceWsDTO deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}

	public PointOfServiceWsDTO getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
	
	public void setDistance(final Double distance)
	{
		this.distance = distance;
	}

	public Double getDistance() 
	{
		return distance;
	}
	

}