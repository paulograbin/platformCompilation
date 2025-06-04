/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.model.events;

import java.io.Serializable;

import de.hybris.eventtracking.model.events.AbstractCartAwareTrackingEvent;

public  class CartAbandonedEvent extends AbstractCartAwareTrackingEvent 
{


	/** <i>Generated property</i> for <code>CartAbandonedEvent.cartAbandonmentReason</code> property defined at extension <code>eventtrackingmodel</code>. */
	
	private String cartAbandonmentReason;
	
	public CartAbandonedEvent()
	{
		super();
	}

	public CartAbandonedEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setCartAbandonmentReason(final String cartAbandonmentReason)
	{
		this.cartAbandonmentReason = cartAbandonmentReason;
	}

	public String getCartAbandonmentReason() 
	{
		return cartAbandonmentReason;
	}
	


}
