/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Delivery mode
 */
@Schema(name="DeliveryMode", description="Representation of a Delivery mode")
public  class DeliveryModeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the delivery mode<br/><br/><i>Generated property</i> for <code>DeliveryModeWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the delivery mode", example="premium-gross") 	
	private String code;

	/** Name of the delivery mode<br/><br/><i>Generated property</i> for <code>DeliveryModeWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the delivery mode", example="Premium Delivery") 	
	private String name;

	/** Description of the delivery mode<br/><br/><i>Generated property</i> for <code>DeliveryModeWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the delivery mode", example="1-2 business days") 	
	private String description;

	/** Cost of the delivery<br/><br/><i>Generated property</i> for <code>DeliveryModeWsDTO.deliveryCost</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryCost", description="Cost of the delivery", example="14.99") 	
	private PriceWsDTO deliveryCost;
	
	public DeliveryModeWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setDeliveryCost(final PriceWsDTO deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

	public PriceWsDTO getDeliveryCost() 
	{
		return deliveryCost;
	}
	

}