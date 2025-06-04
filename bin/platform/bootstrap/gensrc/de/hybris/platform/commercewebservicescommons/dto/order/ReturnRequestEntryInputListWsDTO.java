/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.ReturnRequestEntryInputWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a return request entry input list for an order
 */
@Schema(name="ReturnRequestEntryInputList", description="Representation of a return request entry input list for an order")
public  class ReturnRequestEntryInputListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the order which return request is related to<br/><br/><i>Generated property</i> for <code>ReturnRequestEntryInputListWsDTO.orderCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="orderCode", description="Code of the order which return request is related to", required=true, example="00000001") 	
	private String orderCode;

	/** Return request entry inputs which contain information about the order entries which are requested to be returned<br/><br/><i>Generated property</i> for <code>ReturnRequestEntryInputListWsDTO.returnRequestEntryInputs</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="returnRequestEntryInputs", description="Return request entry inputs which contain information about the order entries which are requested to be returned", required=true) 	
	private List<ReturnRequestEntryInputWsDTO> returnRequestEntryInputs;
	
	public ReturnRequestEntryInputListWsDTO()
	{
		// default constructor
	}
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	
	public void setReturnRequestEntryInputs(final List<ReturnRequestEntryInputWsDTO> returnRequestEntryInputs)
	{
		this.returnRequestEntryInputs = returnRequestEntryInputs;
	}

	public List<ReturnRequestEntryInputWsDTO> getReturnRequestEntryInputs() 
	{
		return returnRequestEntryInputs;
	}
	

}