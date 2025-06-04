/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.facetdata;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Spell Checker Suggestion
 */
@Schema(name="SpellingSuggestion", description="Representation of a Spell Checker Suggestion")
public  class SpellingSuggestionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Spelling suggestion<br/><br/><i>Generated property</i> for <code>SpellingSuggestionWsDTO.suggestion</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="suggestion", description="Spelling suggestion") 	
	private String suggestion;

	/** Query for spelling suggestion<br/><br/><i>Generated property</i> for <code>SpellingSuggestionWsDTO.query</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="query", description="Query for spelling suggestion") 	
	private String query;
	
	public SpellingSuggestionWsDTO()
	{
		// default constructor
	}
	
	public void setSuggestion(final String suggestion)
	{
		this.suggestion = suggestion;
	}

	public String getSuggestion() 
	{
		return suggestion;
	}
	
	public void setQuery(final String query)
	{
		this.query = query;
	}

	public String getQuery() 
	{
		return query;
	}
	

}