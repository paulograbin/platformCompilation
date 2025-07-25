/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationservices.data.UserToSegmentData;
import java.util.List;


import java.util.Objects;
public  class CxResultsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CxResultsData.segments</code> property defined at extension <code>personalizationservices</code>. */
	
	private List<UserToSegmentData> segments;
	
	public CxResultsData()
	{
		// default constructor
	}
	
	public void setSegments(final List<UserToSegmentData> segments)
	{
		this.segments = segments;
	}

	public List<UserToSegmentData> getSegments() 
	{
		return segments;
	}
	

}