/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.subscriptionfacades.data.BillingTimePriceData;


import java.util.Objects;
public  class OrderEntryPriceData extends BillingTimePriceData 

{



	/** <i>Generated property</i> for <code>OrderEntryPriceData.basePrice</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private PriceData basePrice;

	/** <i>Generated property</i> for <code>OrderEntryPriceData.defaultPrice</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private boolean defaultPrice;
	
	public OrderEntryPriceData()
	{
		// default constructor
	}
	
	public void setBasePrice(final PriceData basePrice)
	{
		this.basePrice = basePrice;
	}

	public PriceData getBasePrice() 
	{
		return basePrice;
	}
	
	public void setDefaultPrice(final boolean defaultPrice)
	{
		this.defaultPrice = defaultPrice;
	}

	public boolean isDefaultPrice() 
	{
		return defaultPrice;
	}
	

}