/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.allocation;

import java.io.Serializable;
import java.util.Collection;


import java.util.Objects;
public  class DeclineEntries  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeclineEntries.entries</code> property defined at extension <code>warehousing</code>. */
	
	private Collection<DeclineEntry> entries;
	
	public DeclineEntries()
	{
		// default constructor
	}
	
	public void setEntries(final Collection<DeclineEntry> entries)
	{
		this.entries = entries;
	}

	public Collection<DeclineEntry> getEntries() 
	{
		return entries;
	}
	

}