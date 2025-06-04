/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import de.hybris.platform.commercewebservicescommons.dto.product.ReferenceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Product Reference
 */
@Schema(name="ProductReference", description="Representation of a Product Reference")
public  class ProductReferenceWsDTO extends ReferenceWsDTO 

{



	/** Flag stating if product reference is preselected<br/><br/><i>Generated property</i> for <code>ProductReferenceWsDTO.preselected</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="preselected", description="Flag stating if product reference is preselected") 	
	private Boolean preselected;
	
	public ProductReferenceWsDTO()
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