/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.SapUnitAvailabilityData;
import java.util.List;


import java.util.Objects;
public  class SapProductAvailabilityData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SapProductAvailabilityData.productCode</code> property defined at extension <code>commercefacades</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>SapProductAvailabilityData.unitAvailabilities</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SapUnitAvailabilityData> unitAvailabilities;
	
	public SapProductAvailabilityData()
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
	
	public void setUnitAvailabilities(final List<SapUnitAvailabilityData> unitAvailabilities)
	{
		this.unitAvailabilities = unitAvailabilities;
	}

	public List<SapUnitAvailabilityData> getUnitAvailabilities() 
	{
		return unitAvailabilities;
	}
	

}