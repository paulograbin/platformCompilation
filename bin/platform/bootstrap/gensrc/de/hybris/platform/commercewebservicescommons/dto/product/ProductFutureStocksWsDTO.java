/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.FutureStockWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Product Future Stocks
 */
@Schema(name="ProductFutureStocks", description="Representation of a Product Future Stocks")
public  class ProductFutureStocksWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product identifier<br/><br/><i>Generated property</i> for <code>ProductFutureStocksWsDTO.productCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productCode", description="Product identifier", example="3318057") 	
	private String productCode;

	/** List of future stocks<br/><br/><i>Generated property</i> for <code>ProductFutureStocksWsDTO.futureStocks</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="futureStocks", description="List of future stocks") 	
	private List<FutureStockWsDTO> futureStocks;
	
	public ProductFutureStocksWsDTO()
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
	
	public void setFutureStocks(final List<FutureStockWsDTO> futureStocks)
	{
		this.futureStocks = futureStocks;
	}

	public List<FutureStockWsDTO> getFutureStocks() 
	{
		return futureStocks;
	}
	

}