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
import java.util.List;


import java.util.Objects;
public  class SapProductAvailabilityQueryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SapProductAvailabilityQueryData.productCode</code> property defined at extension <code>commercefacades</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>SapProductAvailabilityQueryData.units</code> property defined at extension <code>commercefacades</code>. */
	
	private List<String> units;
	
	public SapProductAvailabilityQueryData()
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
	
	public void setUnits(final List<String> units)
	{
		this.units = units;
	}

	public List<String> getUnits() 
	{
		return units;
	}
	

}