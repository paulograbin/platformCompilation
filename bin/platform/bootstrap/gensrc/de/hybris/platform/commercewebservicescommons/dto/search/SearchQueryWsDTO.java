/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Search Query
 */
@Schema(name="SearchQuery", description="Representation of a Search Query")
public  class SearchQueryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Value of search query<br/><br/><i>Generated property</i> for <code>SearchQueryWsDTO.value</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="value", description="Value of search query") 	
	private String value;
	
	public SearchQueryWsDTO()
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