/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class SapProductAvailabilityQueryContext  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SapProductAvailabilityQueryContext.products</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SapProductAvailabilityQueryData> products;
	
	public SapProductAvailabilityQueryContext()
	{
		// default constructor
	}
	
	public void setProducts(final List<SapProductAvailabilityQueryData> products)
	{
		this.products = products;
	}

	public List<SapProductAvailabilityQueryData> getProducts() 
	{
		return products;
	}
	

}