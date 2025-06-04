/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import  de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.catalog.enums.ProductReferenceTypeEnum;
import de.hybris.platform.commerceservices.product.data.ReferenceData;


import java.util.Objects;
public  class ProductReferenceData extends ReferenceData<ProductReferenceTypeEnum,ProductData> 

{



	/** <i>Generated property</i> for <code>ProductReferenceData.preselected</code> property defined at extension <code>commercefacades</code>. */
	
	private Boolean preselected;
	
	public ProductReferenceData()
	{
		// default constructor
	}
	
	public void setPreselected(final Boolean preselected)
	{
		this.preselected = preselected;
	}

	public Boolean getPreselected() 
	{
		return preselected;
	}
	

}