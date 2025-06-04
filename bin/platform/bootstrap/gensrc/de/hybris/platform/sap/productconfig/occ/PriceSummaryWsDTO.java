/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Prices on overall product configuration level.
 */
@Schema(name="CCPConfigurationOverallPricing", description="Prices on overall product configuration level.")
public  class PriceSummaryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Base price.<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.basePrice</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="basePrice", description="Base price.") 	
	private PriceWsDTO basePrice;

	/** Summarized price of the selected options.<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.selectedOptions</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="selectedOptions", description="Summarized price of the selected options.") 	
	private PriceWsDTO selectedOptions;

	/** Total price.<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.currentTotal</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="currentTotal", description="Total price.") 	
	private PriceWsDTO currentTotal;

	/** Savings that occur because discounts have been applied to one or more attribute values of the configuration.<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.currentTotalSavings</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="currentTotalSavings", description="Savings that occur because discounts have been applied to one or more attribute values of the configuration.") 	
	private PriceWsDTO currentTotalSavings;
	
	public PriceSummaryWsDTO()
	{
		// default constructor
	}
	
	public void setBasePrice(final PriceWsDTO basePrice)
	{
		this.basePrice = basePrice;
	}

	public PriceWsDTO getBasePrice() 
	{
		return basePrice;
	}
	
	public void setSelectedOptions(final PriceWsDTO selectedOptions)
	{
		this.selectedOptions = selectedOptions;
	}

	public PriceWsDTO getSelectedOptions() 
	{
		return selectedOptions;
	}
	
	public void setCurrentTotal(final PriceWsDTO currentTotal)
	{
		this.currentTotal = currentTotal;
	}

	public PriceWsDTO getCurrentTotal() 
	{
		return currentTotal;
	}
	
	public void setCurrentTotalSavings(final PriceWsDTO currentTotalSavings)
	{
		this.currentTotalSavings = currentTotalSavings;
	}

	public PriceWsDTO getCurrentTotalSavings() 
	{
		return currentTotalSavings;
	}
	

}