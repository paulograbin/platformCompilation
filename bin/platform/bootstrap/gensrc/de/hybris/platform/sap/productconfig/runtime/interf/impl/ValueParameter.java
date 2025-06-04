/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.runtime.interf.impl;

import java.io.Serializable;


import java.util.Objects;
public  class ValueParameter  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Value name<br/><br/><i>Generated property</i> for <code>ValueParameter.valueName</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
	
	private String valueName;

	/** Value Description<br/><br/><i>Generated property</i> for <code>ValueParameter.valueDescription</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
	
	private String valueDescription;
	
	public ValueParameter()
	{
		// default constructor
	}
	
	public void setValueName(final String valueName)
	{
		this.valueName = valueName;
	}

	public String getValueName() 
	{
		return valueName;
	}
	
	public void setValueDescription(final String valueDescription)
	{
		this.valueDescription = valueDescription;
	}

	public String getValueDescription() 
	{
		return valueDescription;
	}
	

}