/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class DeliveryModesData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeliveryModesData.deliveryModes</code> property defined at extension <code>commercefacades</code>. */
	
	private List<? extends DeliveryModeData> deliveryModes;
	
	public DeliveryModesData()
	{
		// default constructor
	}
	
	public void setDeliveryModes(final List<? extends DeliveryModeData> deliveryModes)
	{
		this.deliveryModes = deliveryModes;
	}

	public List<? extends DeliveryModeData> getDeliveryModes() 
	{
		return deliveryModes;
	}
	

}