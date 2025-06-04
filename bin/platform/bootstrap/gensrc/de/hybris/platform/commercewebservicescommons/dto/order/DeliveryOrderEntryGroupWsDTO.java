/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Delivery Order Entry Group
 */
@Schema(name="DeliveryOrderEntryGroup", description="Representation of a Delivery Order Entry Group")
public  class DeliveryOrderEntryGroupWsDTO extends OrderEntryGroupWsDTO 

{



	/** Delivery address for order entry group<br/><br/><i>Generated property</i> for <code>DeliveryOrderEntryGroupWsDTO.deliveryAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryAddress", description="Delivery address for order entry group") 	
	private AddressWsDTO deliveryAddress;
	
	public DeliveryOrderEntryGroupWsDTO()
	{
		// default constructor
	}
	
	public void setDeliveryAddress(final AddressWsDTO deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public AddressWsDTO getDeliveryAddress() 
	{
		return deliveryAddress;
	}
	

}