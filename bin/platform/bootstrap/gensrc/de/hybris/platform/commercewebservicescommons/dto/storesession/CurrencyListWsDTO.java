/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.storesession;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Currency List
 */
@Schema(name="CurrencyList", description="Representation of a Currency List")
public  class CurrencyListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of currencies<br/><br/><i>Generated property</i> for <code>CurrencyListWsDTO.currencies</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currencies", description="List of currencies") 	
	private List<CurrencyWsDTO> currencies;
	
	public CurrencyListWsDTO()
	{
		// default constructor
	}
	
	public void setCurrencies(final List<CurrencyWsDTO> currencies)
	{
		this.currencies = currencies;
	}

	public List<CurrencyWsDTO> getCurrencies() 
	{
		return currencies;
	}
	

}