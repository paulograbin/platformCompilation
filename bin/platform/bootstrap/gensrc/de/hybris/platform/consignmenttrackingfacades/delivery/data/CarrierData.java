/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingfacades.delivery.data;

import java.io.Serializable;


import java.util.Objects;
public  class CarrierData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CarrierData.code</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>CarrierData.name</code> property defined at extension <code>consignmenttrackingfacades</code>. */
	
	private String name;
	
	public CarrierData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}