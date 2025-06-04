/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import de.hybris.platform.commercefacades.order.data.OrderEntryGroupData;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;


import java.util.Objects;
public  class PickupOrderEntryGroupData extends OrderEntryGroupData 

{



	/** <i>Generated property</i> for <code>PickupOrderEntryGroupData.deliveryPointOfService</code> property defined at extension <code>commercefacades</code>. */
	
	private PointOfServiceData deliveryPointOfService;

	/** <i>Generated property</i> for <code>PickupOrderEntryGroupData.distance</code> property defined at extension <code>commercefacades</code>. */
	
	private Double distance;
	
	public PickupOrderEntryGroupData()
	{
		// default constructor
	}
	
	public void setDeliveryPointOfService(final PointOfServiceData deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}

	public PointOfServiceData getDeliveryPointOfService() 
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