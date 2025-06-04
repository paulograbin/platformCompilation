/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.model.events;

import java.io.Serializable;

import de.hybris.eventtracking.model.events.AbstractProductAwareTrackingEvent;

public  class ProductMediaViewEvent extends AbstractProductAwareTrackingEvent 
{


	/** <i>Generated property</i> for <code>ProductMediaViewEvent.productMediaType</code> property defined at extension <code>eventtrackingmodel</code>. */
	
	private String productMediaType;
	
	public ProductMediaViewEvent()
	{
		super();
	}

	public ProductMediaViewEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setProductMediaType(final String productMediaType)
	{
		this.productMediaType = productMediaType;
	}

	public String getProductMediaType() 
	{
		return productMediaType;
	}
	


}
