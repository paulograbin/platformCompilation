/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Unit
 */
@Schema(name="SAPUnit", description="Representation of a Unit")
public  class SAPUnitWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the unit<br/><br/><i>Generated property</i> for <code>SAPUnitWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the unit") 	
	private String code;

	/** Name of the unit<br/><br/><i>Generated property</i> for <code>SAPUnitWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the unit") 	
	private String name;

	/** Code of the unit is used to check availability, which can be retrieved either from 'code' without any integration, from 'sapCode' with SAP OMSA integration, or potentially from another source through custom integration with a stock service.<br/><br/><i>Generated property</i> for <code>SAPUnitWsDTO.availabilityCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="availabilityCode", description="Code of the unit is used to check availability, which can be retrieved either from 'code' without any integration, from 'sapCode' with SAP OMSA integration, or potentially from another source through custom integration with a stock service.") 	
	private String availabilityCode;

	/** Code of the SAP unit<br/><br/><i>Generated property</i> for <code>SAPUnitWsDTO.sapCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sapCode", description="Code of the SAP unit") 	
	private String sapCode;
	
	public SAPUnitWsDTO()
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
	
	public void setAvailabilityCode(final String availabilityCode)
	{
		this.availabilityCode = availabilityCode;
	}

	public String getAvailabilityCode() 
	{
		return availabilityCode;
	}
	
	public void setSapCode(final String sapCode)
	{
		this.sapCode = sapCode;
	}

	public String getSapCode() 
	{
		return sapCode;
	}
	

}