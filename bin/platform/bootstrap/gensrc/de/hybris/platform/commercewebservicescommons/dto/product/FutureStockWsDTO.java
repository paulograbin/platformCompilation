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
import de.hybris.platform.commercewebservicescommons.dto.product.StockWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a Future Stock
 */
@Schema(name="FutureStock", description="Representation of a Future Stock")
public  class FutureStockWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Stock information of future stock<br/><br/><i>Generated property</i> for <code>FutureStockWsDTO.stock</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="stock", description="Stock information of future stock") 	
	private StockWsDTO stock;

	/** Date of future stock<br/><br/><i>Generated property</i> for <code>FutureStockWsDTO.date</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="date", description="Date of future stock", example="2056-12-31T09:00:00+0000") 	
	private Date date;

	/** Date of future stock expressed in text value<br/><br/><i>Generated property</i> for <code>FutureStockWsDTO.formattedDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="formattedDate", description="Date of future stock expressed in text value", example="31/12/2056") 	
	private String formattedDate;
	
	public FutureStockWsDTO()
	{
		// default constructor
	}
	
	public void setStock(final StockWsDTO stock)
	{
		this.stock = stock;
	}

	public StockWsDTO getStock() 
	{
		return stock;
	}
	
	public void setDate(final Date date)
	{
		this.date = date;
	}

	public Date getDate() 
	{
		return date;
	}
	
	public void setFormattedDate(final String formattedDate)
	{
		this.formattedDate = formattedDate;
	}

	public String getFormattedDate() 
	{
		return formattedDate;
	}
	

}