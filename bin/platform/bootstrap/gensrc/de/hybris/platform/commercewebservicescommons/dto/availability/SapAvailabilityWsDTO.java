/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.availability;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.availability.SapProductAvailabilityWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of availability for a list of products.
 */
@Schema(name="SAPAvailability", description="Representation of availability for a list of products.")
public  class SapAvailabilityWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of product availability.<br/><br/><i>Generated property</i> for <code>SapAvailabilityWsDTO.availabilityItems</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="availabilityItems", description="List of product availability.") 	
	private List<SapProductAvailabilityWsDTO> availabilityItems;
	
	public SapAvailabilityWsDTO()
	{
		// default constructor
	}
	
	public void setAvailabilityItems(final List<SapProductAvailabilityWsDTO> availabilityItems)
	{
		this.availabilityItems = availabilityItems;
	}

	public List<SapProductAvailabilityWsDTO> getAvailabilityItems() 
	{
		return availabilityItems;
	}
	

}