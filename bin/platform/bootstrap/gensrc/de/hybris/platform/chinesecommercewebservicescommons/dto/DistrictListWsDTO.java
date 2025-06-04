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
import de.hybris.platform.chinesecommercewebservicescommons.dto.DistrictWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * list of district
 */
@Schema(name="DistrictList", description="list of district")
public  class DistrictListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** list of district<br/><br/><i>Generated property</i> for <code>DistrictListWsDTO.districts</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="districts", description="list of district") 	
	private List<DistrictWsDTO> districts;
	
	public DistrictListWsDTO()
	{
		// default constructor
	}
	
	public void setDistricts(final List<DistrictWsDTO> districts)
	{
		this.districts = districts;
	}

	public List<DistrictWsDTO> getDistricts() 
	{
		return districts;
	}
	

}