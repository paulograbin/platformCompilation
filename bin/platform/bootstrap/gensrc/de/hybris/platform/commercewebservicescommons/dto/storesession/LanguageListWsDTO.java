/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.storesession;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.storesession.LanguageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Lists all available languages (all languages used for a particular store). If the list of languages for a base store is empty, a list of all languages available in the system will be returned
 */
@Schema(name="LanguageList", description="Lists all available languages (all languages used for a particular store). If the list of languages for a base store is empty, a list of all languages available in the system will be returned")
public  class LanguageListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** This is the list of Language fields that should be returned in the response body<br/><br/><i>Generated property</i> for <code>LanguageListWsDTO.languages</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="languages", description="This is the list of Language fields that should be returned in the response body") 	
	private List<LanguageWsDTO> languages;
	
	public LanguageListWsDTO()
	{
		// default constructor
	}
	
	public void setLanguages(final List<LanguageWsDTO> languages)
	{
		this.languages = languages;
	}

	public List<LanguageWsDTO> getLanguages() 
	{
		return languages;
	}
	

}