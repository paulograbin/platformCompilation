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
import de.hybris.platform.basecommerce.enums.StockLevelStatus;


import java.util.Objects;
public  class SapUnitAvailabilityData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SapUnitAvailabilityData.quantity</code> property defined at extension <code>commercefacades</code>. */
	
	private Long quantity;

	/** <i>Generated property</i> for <code>SapUnitAvailabilityData.status</code> property defined at extension <code>commercefacades</code>. */
	
	private StockLevelStatus status;

	/** <i>Generated property</i> for <code>SapUnitAvailabilityData.unit</code> property defined at extension <code>commercefacades</code>. */
	
	private String unit;
	
	public SapUnitAvailabilityData()
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
	
	public void setStatus(final StockLevelStatus status)
	{
		this.status = status;
	}

	public StockLevelStatus getStatus() 
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