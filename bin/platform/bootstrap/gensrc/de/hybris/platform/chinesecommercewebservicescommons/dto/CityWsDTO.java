/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * data object of city
 */
@Schema(name="City", description="data object of city")
public  class CityWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** ISO 3166-1 alpha-2 standard, e.g.[countryIso]-[regionNumber]-[cityNumber]<br/><br/><i>Generated property</i> for <code>CityWsDTO.isocode</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="isocode", description="ISO 3166-1 alpha-2 standard, e.g.[countryIso]-[regionNumber]-[cityNumber]", example="CN-11-1") 	
	private String isocode;

	/** name of city<br/><br/><i>Generated property</i> for <code>CityWsDTO.name</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="name", description="name of city", example="Beijing") 	
	private String name;
	
	public CityWsDTO()
	{
		// default constructor
	}
	
	public void setIsocode(final String isocode)
	{
		this.isocode = isocode;
	}

	public String getIsocode() 
	{
		return isocode;
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