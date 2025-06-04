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
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.StockWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.VariantOptionQualifierWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of a Variant Option
 */
@Schema(name="VariantOption", description="Representation of a Variant Option")
public  class VariantOptionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the variant option<br/><br/><i>Generated property</i> for <code>VariantOptionWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the variant option") 	
	private String code;

	/** Stock value of the variant option<br/><br/><i>Generated property</i> for <code>VariantOptionWsDTO.stock</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="stock", description="Stock value of the variant option") 	
	private StockWsDTO stock;

	/** Url address of the variant option<br/><br/><i>Generated property</i> for <code>VariantOptionWsDTO.url</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="url", description="Url address of the variant option") 	
	private String url;

	/** Price data information of the variant option<br/><br/><i>Generated property</i> for <code>VariantOptionWsDTO.priceData</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="priceData", description="Price data information of the variant option") 	
	private PriceWsDTO priceData;

	/** List of variant option qualifiers<br/><br/><i>Generated property</i> for <code>VariantOptionWsDTO.variantOptionQualifiers</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="variantOptionQualifiers", description="List of variant option qualifiers") 	
	private Collection<VariantOptionQualifierWsDTO> variantOptionQualifiers;
	
	public VariantOptionWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setStock(final StockWsDTO stock)
	{
		this.stock = stock;
	}

	public StockWsDTO getStock() 
	{
		return stock;
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setPriceData(final PriceWsDTO priceData)
	{
		this.priceData = priceData;
	}

	public PriceWsDTO getPriceData() 
	{
		return priceData;
	}
	
	public void setVariantOptionQualifiers(final Collection<VariantOptionQualifierWsDTO> variantOptionQualifiers)
	{
		this.variantOptionQualifiers = variantOptionQualifiers;
	}

	public Collection<VariantOptionQualifierWsDTO> getVariantOptionQualifiers() 
	{
		return variantOptionQualifiers;
	}
	

}