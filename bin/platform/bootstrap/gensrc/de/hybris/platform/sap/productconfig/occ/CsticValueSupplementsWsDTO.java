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
 * Enriches an attribute value with supplementary pricing data.
 */
@Schema(name="CCPAttributeValuePricing", description="Enriches an attribute value with supplementary pricing data.")
public  class CsticValueSupplementsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Value key.<br/><br/><i>Generated property</i> for <code>CsticValueSupplementsWsDTO.attributeValueKey</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="attributeValueKey", description="Value key.", example="MET_BLUE") 	
	private String attributeValueKey;

	/** Price of attribute value.<br/><br/><i>Generated property</i> for <code>CsticValueSupplementsWsDTO.priceValue</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="priceValue", description="Price of attribute value.") 	
	private PriceWsDTO priceValue;

	/** Obsolete price that has been reduced due to the applied discounts.<br/><br/><i>Generated property</i> for <code>CsticValueSupplementsWsDTO.obsoletePriceValue</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="obsoletePriceValue", description="Obsolete price that has been reduced due to the applied discounts.") 	
	private PriceWsDTO obsoletePriceValue;
	
	public CsticValueSupplementsWsDTO()
	{
		// default constructor
	}
	
	public void setAttributeValueKey(final String attributeValueKey)
	{
		this.attributeValueKey = attributeValueKey;
	}

	public String getAttributeValueKey() 
	{
		return attributeValueKey;
	}
	
	public void setPriceValue(final PriceWsDTO priceValue)
	{
		this.priceValue = priceValue;
	}

	public PriceWsDTO getPriceValue() 
	{
		return priceValue;
	}
	
	public void setObsoletePriceValue(final PriceWsDTO obsoletePriceValue)
	{
		this.obsoletePriceValue = obsoletePriceValue;
	}

	public PriceWsDTO getObsoletePriceValue() 
	{
		return obsoletePriceValue;
	}
	

}