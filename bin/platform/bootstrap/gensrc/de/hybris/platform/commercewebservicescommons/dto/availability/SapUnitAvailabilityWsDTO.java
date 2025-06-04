/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.availability;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of availability in a particular unit.
 */
@Schema(name="SAPUnitAvailability", description="Representation of availability in a particular unit.")
public  class SapUnitAvailabilityWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Available quantity.<br/><br/><i>Generated property</i> for <code>SapUnitAvailabilityWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Available quantity.", example="25") 	
	private Long quantity;

	/** Status of availability. Possible values can be IN_STOCK, OUT_OF_STOCK, LOW_STOCK.<br/><br/><i>Generated property</i> for <code>SapUnitAvailabilityWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="status", description="Status of availability. Possible values can be IN_STOCK, OUT_OF_STOCK, LOW_STOCK.", example="IN_STOCK") 	
	private String status;

	/** Code of the unit of measure.<br/><br/><i>Generated property</i> for <code>SapUnitAvailabilityWsDTO.unit</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="unit", description="Code of the unit of measure.", example="PC") 	
	private String unit;
	
	public SapUnitAvailabilityWsDTO()
	{
		// default constructor
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setUnit(final String unit)
	{
		this.unit = unit;
	}

	public String getUnit() 
	{
		return unit;
	}
	

}