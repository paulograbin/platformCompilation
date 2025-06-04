/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.C360CartEntryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Cart Data
 */
@Schema(name="C360CartData", description="Representation of a Cart Data")
public  class C360CartDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Cart code for a given customer<br/><br/><i>Generated property</i> for <code>C360CartDataWsDTO.code</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="code", description="Cart code for a given customer", example="00000001") 	
	private String code;

	/** Total price of the cart<br/><br/><i>Generated property</i> for <code>C360CartDataWsDTO.totalPrice</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="totalPrice", description="Total price of the cart", example="$100.00") 	
	private String totalPrice;

	/** Total number of items in the cart<br/><br/><i>Generated property</i> for <code>C360CartDataWsDTO.totalItemCount</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="totalItemCount", description="Total number of items in the cart", example="1") 	
	private Integer totalItemCount;

	/** List of entries in the cart<br/><br/><i>Generated property</i> for <code>C360CartDataWsDTO.entries</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="entries", description="List of entries in the cart") 	
	private List<C360CartEntryWsDTO> entries;
	
	public C360CartDataWsDTO()
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
	
	public void setTotalPrice(final String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public String getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setTotalItemCount(final Integer totalItemCount)
	{
		this.totalItemCount = totalItemCount;
	}

	public Integer getTotalItemCount() 
	{
		return totalItemCount;
	}
	
	public void setEntries(final List<C360CartEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<C360CartEntryWsDTO> getEntries() 
	{
		return entries;
	}
	

}