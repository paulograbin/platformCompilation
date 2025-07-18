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
import de.hybris.platform.commercewebservicescommons.dto.order.DeliveryModeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Delivery mode list
 */
@Schema(name="DeliveryModeList", description="Representation of a Delivery mode list")
public  class DeliveryModeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of delivery modes<br/><br/><i>Generated property</i> for <code>DeliveryModeListWsDTO.deliveryModes</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryModes", description="List of delivery modes") 	
	private List<DeliveryModeWsDTO> deliveryModes;
	
	public DeliveryModeListWsDTO()
	{
		// default constructor
	}
	
	public void setDeliveryModes(final List<DeliveryModeWsDTO> deliveryModes)
	{
		this.deliveryModes = deliveryModes;
	}

	public List<DeliveryModeWsDTO> getDeliveryModes() 
	{
		return deliveryModes;
	}
	

}