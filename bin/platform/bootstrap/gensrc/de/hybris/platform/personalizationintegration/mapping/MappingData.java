/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationintegration.mapping;

import java.io.Serializable;
import de.hybris.platform.personalizationintegration.mapping.SegmentMappingData;
import java.util.List;


import java.util.Objects;
public  class MappingData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MappingData.segments</code> property defined at extension <code>personalizationintegration</code>. */
	
	private List<SegmentMappingData> segments;
	
	public MappingData()
	{
		// default constructor
	}
	
	public void setSegments(final List<SegmentMappingData> segments)
	{
		this.segments = segments;
	}

	public List<SegmentMappingData> getSegments() 
	{
		return segments;
	}
	

}