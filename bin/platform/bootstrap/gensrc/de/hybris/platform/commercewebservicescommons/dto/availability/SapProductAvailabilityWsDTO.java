/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.availability;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.availability.SapUnitAvailabilityWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of availability for a product.
 */
@Schema(name="SAPProductAvailability", description="Representation of availability for a product.")
public  class SapProductAvailabilityWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product identifier.<br/><br/><i>Generated property</i> for <code>SapProductAvailabilityWsDTO.productCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productCode", description="Product identifier.", example="3318057_A") 	
	private String productCode;

	/** List of unit availability.<br/><br/><i>Generated property</i> for <code>SapProductAvailabilityWsDTO.unitAvailabilities</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="unitAvailabilities", description="List of unit availability.") 	
	private List<SapUnitAvailabilityWsDTO> unitAvailabilities;
	
	public SapProductAvailabilityWsDTO()
	{
		// default constructor
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setUnitAvailabilities(final List<SapUnitAvailabilityWsDTO> unitAvailabilities)
	{
		this.unitAvailabilities = unitAvailabilities;
	}

	public List<SapUnitAvailabilityWsDTO> getUnitAvailabilities() 
	{
		return unitAvailabilities;
	}
	

}