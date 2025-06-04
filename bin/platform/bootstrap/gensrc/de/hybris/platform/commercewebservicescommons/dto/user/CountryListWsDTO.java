/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.CountryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of countries
 */
@Schema(name="CountryList", description="List of countries")
public  class CountryListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** This is the list of Country fields that should be returned in the response body<br/><br/><i>Generated property</i> for <code>CountryListWsDTO.countries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="countries", description="This is the list of Country fields that should be returned in the response body") 	
	private List<CountryWsDTO> countries;
	
	public CountryListWsDTO()
	{
		// default constructor
	}
	
	public void setCountries(final List<CountryWsDTO> countries)
	{
		this.countries = countries;
	}

	public List<CountryWsDTO> getCountries() 
	{
		return countries;
	}
	

}