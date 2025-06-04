/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.queues;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.queues.ProductExpressUpdateElementWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Product Express Update Element List
 */
@Schema(name="ProductExpressUpdateElementList", description="Representation of a Product Express Update Element List")
public  class ProductExpressUpdateElementListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of product express update element<br/><br/><i>Generated property</i> for <code>ProductExpressUpdateElementListWsDTO.productExpressUpdateElements</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productExpressUpdateElements", description="List of product express update element") 	
	private List<ProductExpressUpdateElementWsDTO> productExpressUpdateElements;
	
	public ProductExpressUpdateElementListWsDTO()
	{
		// default constructor
	}
	
	public void setProductExpressUpdateElements(final List<ProductExpressUpdateElementWsDTO> productExpressUpdateElements)
	{
		this.productExpressUpdateElements = productExpressUpdateElements;
	}

	public List<ProductExpressUpdateElementWsDTO> getProductExpressUpdateElements() 
	{
		return productExpressUpdateElements;
	}
	

}