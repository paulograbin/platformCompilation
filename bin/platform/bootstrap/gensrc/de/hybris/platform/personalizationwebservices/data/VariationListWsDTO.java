/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.VariationData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of variations
 */
@Schema(name="VariationList", description="List of variations")
public  class VariationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of variations<br/><br/><i>Generated property</i> for <code>VariationListWsDTO.variations</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="variations", description="List of variations") 	
	private List<VariationData> variations;
	
	public VariationListWsDTO()
	{
		// default constructor
	}
	
	public void setVariations(final List<VariationData> variations)
	{
		this.variations = variations;
	}

	public List<VariationData> getVariations() 
	{
		return variations;
	}
	

}