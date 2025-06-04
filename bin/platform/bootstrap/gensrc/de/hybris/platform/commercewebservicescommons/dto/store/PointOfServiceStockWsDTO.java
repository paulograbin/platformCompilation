/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.store;

import de.hybris.platform.commercewebservicescommons.dto.product.StockWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.store.PointOfServiceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Point Of Service Stock
 */
@Schema(name="PointOfServiceStock", description="Representation of a Point Of Service Stock")
public  class PointOfServiceStockWsDTO extends PointOfServiceWsDTO 

{



	/** Stock information about point of service<br/><br/><i>Generated property</i> for <code>PointOfServiceStockWsDTO.stockInfo</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="stockInfo", description="Stock information about point of service") 	
	private StockWsDTO stockInfo;
	
	public PointOfServiceStockWsDTO()
	{
		// default constructor
	}
	
	public void setStockInfo(final StockWsDTO stockInfo)
	{
		this.stockInfo = stockInfo;
	}

	public StockWsDTO getStockInfo() 
	{
		return stockInfo;
	}
	

}