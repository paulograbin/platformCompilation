/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.model.events;

import java.io.Serializable;

import de.hybris.eventtracking.model.events.AbstractTrackingEvent;

public  class AbstractCartAwareTrackingEvent extends AbstractTrackingEvent 
{


	/** <i>Generated property</i> for <code>AbstractCartAwareTrackingEvent.cartId</code> property defined at extension <code>eventtrackingmodel</code>. */
	
	private String cartId;
	
	public AbstractCartAwareTrackingEvent()
	{
		super();
	}

	public AbstractCartAwareTrackingEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		return cartId;
	}
	


}
