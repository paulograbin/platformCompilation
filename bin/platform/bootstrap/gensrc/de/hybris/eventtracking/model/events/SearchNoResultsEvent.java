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

public  class SearchNoResultsEvent extends AbstractTrackingEvent 
{


	/** <i>Generated property</i> for <code>SearchNoResultsEvent.searchTerm</code> property defined at extension <code>eventtrackingmodel</code>. */
	
	private String searchTerm;
	
	public SearchNoResultsEvent()
	{
		super();
	}

	public SearchNoResultsEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setSearchTerm(final String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	public String getSearchTerm() 
	{
		return searchTerm;
	}
	


}
