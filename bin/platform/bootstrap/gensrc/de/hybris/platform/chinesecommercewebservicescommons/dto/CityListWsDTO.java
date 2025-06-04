/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import de.hybris.platform.chinesecommercewebservicescommons.dto.CityWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * list of city
 */
@Schema(name="CityList", description="list of city")
public  class CityListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** list of city<br/><br/><i>Generated property</i> for <code>CityListWsDTO.cities</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="cities", description="list of city") 	
	private List<CityWsDTO> cities;
	
	public CityListWsDTO()
	{
		// default constructor
	}
	
	public void setCities(final List<CityWsDTO> cities)
	{
		this.cities = cities;
	}

	public List<CityWsDTO> getCities() 
	{
		return cities;
	}
	

}