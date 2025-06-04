/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Bean used for filtering the configuration overview.
 */
@Schema(name="CCPFilterData", description="Bean used for filtering the configuration overview.")
public  class FilterDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Identifier of the filter. Can contain the UI group identifier or an enum representing different attribute facets such as 'USER_INPUT' or 'PRICE_RELEVANT'. <br/><br/><i>Generated property</i> for <code>FilterDataWsDTO.key</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="key", description="Identifier of the filter. Can contain the UI group identifier or an enum representing different attribute facets such as 'USER_INPUT' or 'PRICE_RELEVANT'.", example="USER_INPUT") 	
	private String key;

	/** Describes if filter item is selected.<br/><br/><i>Generated property</i> for <code>FilterDataWsDTO.selected</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="selected", description="Describes if filter item is selected.", example="true") 	
	private boolean selected;
	
	public FilterDataWsDTO()
	{
		// default constructor
	}
	
	public void setKey(final String key)
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
	}
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelected() 
	{
		return selected;
	}
	

}