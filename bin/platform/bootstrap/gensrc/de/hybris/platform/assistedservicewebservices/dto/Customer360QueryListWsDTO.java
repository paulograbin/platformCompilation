/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.Customer360QueryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a list of Customer 360 data queries
 */
@Schema(name="Customer360QueryList", description="Representation of a list of Customer 360 data queries")
public  class Customer360QueryListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of the Customer 360 data being queried.<br/><br/><i>Generated property</i> for <code>Customer360QueryListWsDTO.customer360Queries</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="customer360Queries", description="List of the Customer 360 data being queried.", required=true, example="[{\"type\": \"c360StoreLocation\"}, {\"type\": \"c360ReviewList\", \"additionalRequestParameters\": {\"listSize\" : \"10\"}}, {\"type\": \"c360CouponList\"}, {\"type\": \"c360PromotionList\"}, {\"type\": \"c360CustomerCouponList\", \"additionalRequestParameters\":{\"searchQuery\" : \"Camera\", \"assignable\" : \"true\"}}, {\"type\": \"c360CustomerProductInterestList\", \"additionalRequestParameters\": {\"listSize\" : \"3\"}}, {\"type\": \"c360Cart\"}, {\"type\": \"c360SavedCart\", \"additionalRequestParameters\": {\"listSize\" : \"6\"}}, {\"type\": \"c360Overview\"}, {\"type\": \"c360CustomerProfile\"}, {\"type\": \"c360ActivityList\", \"additionalRequestParameters\": {\"listSize\" : \"30\"}}, {\"type\": \"c360TicketList\", \"additionalRequestParameters\": {\"listSize\" : \"10\"}}]") 	
	private List<Customer360QueryWsDTO> customer360Queries;
	
	public Customer360QueryListWsDTO()
	{
		// default constructor
	}
	
	public void setCustomer360Queries(final List<Customer360QueryWsDTO> customer360Queries)
	{
		this.customer360Queries = customer360Queries;
	}

	public List<Customer360QueryWsDTO> getCustomer360Queries() 
	{
		return customer360Queries;
	}
	

}