/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.storesession;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Currency
 */
@Schema(name="Currency", description="Representation of a Currency")
public  class CurrencyWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the currency in iso format<br/><br/><i>Generated property</i> for <code>CurrencyWsDTO.isocode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="isocode", description="Code of the currency in iso format") 	
	private String isocode;

	/** Name of the currency<br/><br/><i>Generated property</i> for <code>CurrencyWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the currency") 	
	private String name;

	/** Boolean flag whether currency is active<br/><br/><i>Generated property</i> for <code>CurrencyWsDTO.active</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="active", description="Boolean flag whether currency is active") 	
	private Boolean active;

	/** Symbol of the currency<br/><br/><i>Generated property</i> for <code>CurrencyWsDTO.symbol</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="symbol", description="Symbol of the currency") 	
	private String symbol;
	
	public CurrencyWsDTO()
	{
		// default constructor
	}
	
	public void setIsocode(final String isocode)
	{
		this.isocode = isocode;
	}

	public String getIsocode() 
	{
		return isocode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setSymbol(final String symbol)
	{
		this.symbol = symbol;
	}

	public String getSymbol() 
	{
		return symbol;
	}
	

}