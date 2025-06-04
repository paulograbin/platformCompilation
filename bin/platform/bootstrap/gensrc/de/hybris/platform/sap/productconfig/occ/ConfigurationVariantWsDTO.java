/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ImageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Product variant of a configurable product.
 */
@Schema(name="CCPConfigurationProductVariant", description="Product variant of a configurable product.")
public  class ConfigurationVariantWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product Code.<br/><br/><i>Generated property</i> for <code>ConfigurationVariantWsDTO.productCode</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="productCode", description="Product Code.") 	
	private String productCode;

	/** Language-dependent product name.<br/><br/><i>Generated property</i> for <code>ConfigurationVariantWsDTO.name</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="name", description="Language-dependent product name.") 	
	private String name;

	/** Price data.<br/><br/><i>Generated property</i> for <code>ConfigurationVariantWsDTO.price</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="price", description="Price data.") 	
	private PriceWsDTO price;

	/** Image data.<br/><br/><i>Generated property</i> for <code>ConfigurationVariantWsDTO.imageData</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="imageData", description="Image data.") 	
	private ImageWsDTO imageData;
	
	public ConfigurationVariantWsDTO()
	{
		// default constructor
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setPrice(final PriceWsDTO price)
	{
		this.price = price;
	}

	public PriceWsDTO getPrice() 
	{
		return price;
	}
	
	public void setImageData(final ImageWsDTO imageData)
	{
		this.imageData = imageData;
	}

	public ImageWsDTO getImageData() 
	{
		return imageData;
	}
	

}