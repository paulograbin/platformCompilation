/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTOType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;


import java.util.Objects;
/**
 * Representation of a Price
 */
@Schema(name="Price", description="Representation of a Price")
public  class PriceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Currency iso format<br/><br/><i>Generated property</i> for <code>PriceWsDTO.currencyIso</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currencyIso", description="Currency iso format", example="USD") 	
	private String currencyIso;

	/** Value of price in BigDecimal format<br/><br/><i>Generated property</i> for <code>PriceWsDTO.value</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="value", description="Value of price in BigDecimal format") 	
	private BigDecimal value;

	/** Type of the price<br/><br/><i>Generated property</i> for <code>PriceWsDTO.priceType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="priceType", description="Type of the price") 	
	private PriceWsDTOType priceType;

	/** Value of price formatted<br/><br/><i>Generated property</i> for <code>PriceWsDTO.formattedValue</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="formattedValue", description="Value of price formatted") 	
	private String formattedValue;

	/** Minimum quantity of the price value<br/><br/><i>Generated property</i> for <code>PriceWsDTO.minQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="minQuantity", description="Minimum quantity of the price value") 	
	private Long minQuantity;

	/** Maximum quantity of the price value<br/><br/><i>Generated property</i> for <code>PriceWsDTO.maxQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="maxQuantity", description="Maximum quantity of the price value") 	
	private Long maxQuantity;
	
	public PriceWsDTO()
	{
		// default constructor
	}
	
	public void setCurrencyIso(final String currencyIso)
	{
		this.currencyIso = currencyIso;
	}

	public String getCurrencyIso() 
	{
		return currencyIso;
	}
	
	public void setValue(final BigDecimal value)
	{
		this.value = value;
	}

	public BigDecimal getValue() 
	{
		return value;
	}
	
	public void setPriceType(final PriceWsDTOType priceType)
	{
		this.priceType = priceType;
	}

	public PriceWsDTOType getPriceType() 
	{
		return priceType;
	}
	
	public void setFormattedValue(final String formattedValue)
	{
		this.formattedValue = formattedValue;
	}

	public String getFormattedValue() 
	{
		return formattedValue;
	}
	
	public void setMinQuantity(final Long minQuantity)
	{
		this.minQuantity = minQuantity;
	}

	public Long getMinQuantity() 
	{
		return minQuantity;
	}
	
	public void setMaxQuantity(final Long maxQuantity)
	{
		this.maxQuantity = maxQuantity;
	}

	public Long getMaxQuantity() 
	{
		return maxQuantity;
	}
	

}