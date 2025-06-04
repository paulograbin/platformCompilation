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
 * data object of district
 */
@Schema(name="District", description="data object of district")
public  class DistrictWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** ISO 3166-1 alpha-2 standard, e.g.[countryIso]-[regionNumber]-[cityNumber]-[districtNumber]<br/><br/><i>Generated property</i> for <code>DistrictWsDTO.isocode</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="isocode", description="ISO 3166-1 alpha-2 standard, e.g.[countryIso]-[regionNumber]-[cityNumber]-[districtNumber]") 	
	private String isocode;

	/** name of district<br/><br/><i>Generated property</i> for <code>DistrictWsDTO.name</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="name", description="name of district", example="Dongcheng District") 	
	private String name;
	
	public DistrictWsDTO()
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