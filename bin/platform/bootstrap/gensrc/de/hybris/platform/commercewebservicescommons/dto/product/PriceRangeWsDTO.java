/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Price Range
 */
@Schema(name="PriceRange", description="Representation of a Price Range")
public  class PriceRangeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Maximum value of the Price Range<br/><br/><i>Generated property</i> for <code>PriceRangeWsDTO.maxPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="maxPrice", description="Maximum value of the Price Range") 	
	private PriceWsDTO maxPrice;

	/** Minium value of the Price Range<br/><br/><i>Generated property</i> for <code>PriceRangeWsDTO.minPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="minPrice", description="Minium value of the Price Range") 	
	private PriceWsDTO minPrice;
	
	public PriceRangeWsDTO()
	{
		// default constructor
	}
	
	public void setMaxPrice(final PriceWsDTO maxPrice)
	{
		this.maxPrice = maxPrice;
	}

	public PriceWsDTO getMaxPrice() 
	{
		return maxPrice;
	}
	
	public void setMinPrice(final PriceWsDTO minPrice)
	{
		this.minPrice = minPrice;
	}

	public PriceWsDTO getMinPrice() 
	{
		return minPrice;
	}
	

}