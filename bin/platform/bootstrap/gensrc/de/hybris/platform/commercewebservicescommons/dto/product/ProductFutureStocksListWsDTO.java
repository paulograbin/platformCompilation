/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductFutureStocksWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Product Future Stocks List
 */
@Schema(name="ProductFutureStocksList", description="Representation of a Product Future Stocks List")
public  class ProductFutureStocksListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of product future stocks<br/><br/><i>Generated property</i> for <code>ProductFutureStocksListWsDTO.productFutureStocks</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productFutureStocks", description="List of product future stocks") 	
	private List<ProductFutureStocksWsDTO> productFutureStocks;
	
	public ProductFutureStocksListWsDTO()
	{
		// default constructor
	}
	
	public void setProductFutureStocks(final List<ProductFutureStocksWsDTO> productFutureStocks)
	{
		this.productFutureStocks = productFutureStocks;
	}

	public List<ProductFutureStocksWsDTO> getProductFutureStocks() 
	{
		return productFutureStocks;
	}
	

}