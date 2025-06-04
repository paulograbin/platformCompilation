/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Cart modification
 */
@Schema(name="CartModification", description="Representation of a Cart modification")
public  class CartModificationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Status code of cart modification<br/><br/><i>Generated property</i> for <code>CartModificationWsDTO.statusCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="statusCode", description="Status code of cart modification") 	
	private String statusCode;

	/** Quantity added with cart modification<br/><br/><i>Generated property</i> for <code>CartModificationWsDTO.quantityAdded</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantityAdded", description="Quantity added with cart modification") 	
	private Long quantityAdded;

	/** Total number of products to be created, added or updated during a cart modification. This value is always the quantity that has been requested.<br/><br/><i>Generated property</i> for <code>CartModificationWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Total number of products to be created, added or updated during a cart modification. This value is always the quantity that has been requested.") 	
	private Long quantity;

	/** Order entry<br/><br/><i>Generated property</i> for <code>CartModificationWsDTO.entry</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entry", description="Order entry") 	
	private OrderEntryWsDTO entry;

	/** Delivery mode changed<br/><br/><i>Generated property</i> for <code>CartModificationWsDTO.deliveryModeChanged</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryModeChanged", description="Delivery mode changed") 	
	private Boolean deliveryModeChanged;

	/** Status message<br/><br/><i>Generated property</i> for <code>CartModificationWsDTO.statusMessage</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="statusMessage", description="Status message") 	
	private String statusMessage;
	
	public CartModificationWsDTO()
	{
		// default constructor
	}
	
	public void setStatusCode(final String statusCode)
	{
		this.statusCode = statusCode;
	}

	public String getStatusCode() 
	{
		return statusCode;
	}
	
	public void setQuantityAdded(final Long quantityAdded)
	{
		this.quantityAdded = quantityAdded;
	}

	public Long getQuantityAdded() 
	{
		return quantityAdded;
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	
	public void setEntry(final OrderEntryWsDTO entry)
	{
		this.entry = entry;
	}

	public OrderEntryWsDTO getEntry() 
	{
		return entry;
	}
	
	public void setDeliveryModeChanged(final Boolean deliveryModeChanged)
	{
		this.deliveryModeChanged = deliveryModeChanged;
	}

	public Boolean getDeliveryModeChanged() 
	{
		return deliveryModeChanged;
	}
	
	public void setStatusMessage(final String statusMessage)
	{
		this.statusMessage = statusMessage;
	}

	public String getStatusMessage() 
	{
		return statusMessage;
	}
	

}