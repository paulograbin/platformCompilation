/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationservices.trigger.expression;

import java.io.Serializable;
import java.util.Collection;


import java.util.Objects;
public  class CxExpressionContext  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CxExpressionContext.segments</code> property defined at extension <code>personalizationservices</code>. */
	
	private Collection<String> segments;
	
	public CxExpressionContext()
	{
		// default constructor
	}
	
	public void setSegments(final Collection<String> segments)
	{
		this.segments = segments;
	}

	public Collection<String> getSegments() 
	{
		return segments;
	}
	

}