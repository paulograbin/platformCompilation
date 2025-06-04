/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.model.events;

import java.io.Serializable;

import de.hybris.eventtracking.model.events.AbstractTrackingEvent;

public  class BannerClickEvent extends AbstractTrackingEvent 
{


	/** <i>Generated property</i> for <code>BannerClickEvent.bannerId</code> property defined at extension <code>eventtrackingmodel</code>. */
	
	private String bannerId;
	
	public BannerClickEvent()
	{
		super();
	}

	public BannerClickEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setBannerId(final String bannerId)
	{
		this.bannerId = bannerId;
	}

	public String getBannerId() 
	{
		return bannerId;
	}
	


}
