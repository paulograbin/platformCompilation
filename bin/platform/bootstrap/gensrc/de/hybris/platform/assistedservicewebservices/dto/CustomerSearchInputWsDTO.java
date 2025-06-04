/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Customer search query.
 */
@Schema(name="CustomerSearchInput", description="Customer search query.")
public  class CustomerSearchInputWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Parts of a customer email or name.<br/><br/><i>Generated property</i> for <code>CustomerSearchInputWsDTO.query</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="query", description="Parts of a customer email or name.", required=false, example="johndoe@example.com") 	
	private String query;

	/** ID of the order.<br/><br/><i>Generated property</i> for <code>CustomerSearchInputWsDTO.orderId</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="orderId", description="ID of the order.", required=false, example="00000001") 	
	private String orderId;

	/** ID of the customer list.<br/><br/><i>Generated property</i> for <code>CustomerSearchInputWsDTO.customerListId</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="customerListId", description="ID of the customer list.", required=false, example="customerList1") 	
	private String customerListId;
	
	public CustomerSearchInputWsDTO()
	{
		// default constructor
	}
	
	public void setQuery(final String query)
	{
		this.query = query;
	}

	public String getQuery() 
	{
		return query;
	}
	
	public void setOrderId(final String orderId)
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	
	public void setCustomerListId(final String customerListId)
	{
		this.customerListId = customerListId;
	}

	public String getCustomerListId() 
	{
		return customerListId;
	}
	

}