/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.SapProductAvailabilityData;
import java.util.List;


import java.util.Objects;
public  class SapAvailabilityData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SapAvailabilityData.availabilityItems</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SapProductAvailabilityData> availabilityItems;
	
	public SapAvailabilityData()
	{
		// default constructor
	}
	
	public void setAvailabilityItems(final List<SapProductAvailabilityData> availabilityItems)
	{
		this.availabilityItems = availabilityItems;
	}

	public List<SapProductAvailabilityData> getAvailabilityItems() 
	{
		return availabilityItems;
	}
	

}