/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Feature Value
 */
@Schema(name="FeatureValue", description="Representation of a Feature Value")
public  class FeatureValueWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Value of the feature<br/><br/><i>Generated property</i> for <code>FeatureValueWsDTO.value</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="value", description="Value of the feature") 	
	private String value;
	
	public FeatureValueWsDTO()
	{
		// default constructor
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	

}