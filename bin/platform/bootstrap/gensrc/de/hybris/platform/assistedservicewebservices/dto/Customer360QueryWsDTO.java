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
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Representation of a Customer 360 query.
 */
@Schema(name="Customer360Query", description="Representation of a Customer 360 query.")
public  class Customer360QueryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type of the returned Customer360 data. The allowed values are: 'c360StoreLocation', 'c360ReviewList', 'c360CustomerProductInterestList',
                'c360CouponList', 'c360PromotionList', 'c360CustomerCouponList', 'c360Cart', 'c360SavedCart', 'c360Overview', 'c360CustomerProfile', 'c360ActivityList', 'c360TicketList'.<br/><br/><i>Generated property</i> for <code>Customer360QueryWsDTO.type</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="type", description="Type of the returned Customer360 data. The allowed values are: 'c360StoreLocation', 'c360ReviewList', 'c360CustomerProductInterestList', 'c360CouponList', 'c360PromotionList', 'c360CustomerCouponList', 'c360Cart', 'c360SavedCart', 'c360Overview', 'c360CustomerProfile', 'c360ActivityList', 'c360TicketList'.", required=true) 	
	private String type;

	/** Additional properties that are included in the request for the data, such as timeout.<br/><br/><i>Generated property</i> for <code>Customer360QueryWsDTO.additionalRequestParameters</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="additionalRequestParameters", description="Additional properties that are included in the request for the data, such as timeout.") 	
	private Map<String, String> additionalRequestParameters;
	
	public Customer360QueryWsDTO()
	{
		// default constructor
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setAdditionalRequestParameters(final Map<String, String> additionalRequestParameters)
	{
		this.additionalRequestParameters = additionalRequestParameters;
	}

	public Map<String, String> getAdditionalRequestParameters() 
	{
		return additionalRequestParameters;
	}
	

}