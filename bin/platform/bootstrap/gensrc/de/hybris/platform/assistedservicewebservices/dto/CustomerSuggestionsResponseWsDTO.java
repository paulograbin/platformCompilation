/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.CustomerSuggestionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Represents an autocomplete suggestion list of customers.
 */
@Schema(name="CustomerSuggestionsResponse", description="Represents an autocomplete suggestion list of customers.")
public  class CustomerSuggestionsResponseWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CustomerSuggestionsResponseWsDTO.suggestions</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="suggestions") 	
	private List<CustomerSuggestionWsDTO> suggestions;
	
	public CustomerSuggestionsResponseWsDTO()
	{
		// default constructor
	}
	
	public void setSuggestions(final List<CustomerSuggestionWsDTO> suggestions)
	{
		this.suggestions = suggestions;
	}

	public List<CustomerSuggestionWsDTO> getSuggestions() 
	{
		return suggestions;
	}
	

}