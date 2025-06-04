/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerinterestsocc.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductWsDTO;
import de.hybris.platform.customerinterestsocc.dto.ProductInterestEntryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Product interest relation
 */
@Schema(name="productInterestRelation", description="Product interest relation")
public  class ProductInterestRelationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product<br/><br/><i>Generated property</i> for <code>ProductInterestRelationWsDTO.product</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="product", description="Product") 	
	private ProductWsDTO product;

	/** List of product interest entry<br/><br/><i>Generated property</i> for <code>ProductInterestRelationWsDTO.productInterestEntry</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="productInterestEntry", description="List of product interest entry") 	
	private List<ProductInterestEntryWsDTO> productInterestEntry;
	
	public ProductInterestRelationWsDTO()
	{
		// default constructor
	}
	
	public void setProduct(final ProductWsDTO product)
	{
		this.product = product;
	}

	public ProductWsDTO getProduct() 
	{
		return product;
	}
	
	public void setProductInterestEntry(final List<ProductInterestEntryWsDTO> productInterestEntry)
	{
		this.productInterestEntry = productInterestEntry;
	}

	public List<ProductInterestEntryWsDTO> getProductInterestEntry() 
	{
		return productInterestEntry;
	}
	

}