/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.runtime.interf.impl;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.runtime.interf.impl.ProductConfigurationSource;


import java.util.Objects;
public  class ProductConfigurationInteractionParameters  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductConfigurationInteractionParameters.source</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
	
	private ProductConfigurationSource source;

	/** <i>Generated property</i> for <code>ProductConfigurationInteractionParameters.withDate</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
	
	private boolean withDate;
	
	public ProductConfigurationInteractionParameters()
	{
		// default constructor
	}
	
	public void setSource(final ProductConfigurationSource source)
	{
		this.source = source;
	}

	public ProductConfigurationSource getSource() 
	{
		return source;
	}
	
	public void setWithDate(final boolean withDate)
	{
		this.withDate = withDate;
	}

	public boolean isWithDate() 
	{
		return withDate;
	}
	

}