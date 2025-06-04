/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Feature Unit
 */
@Schema(name="FeatureUnit", description="Representation of a Feature Unit")
public  class FeatureUnitWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Symbol of the feature unit<br/><br/><i>Generated property</i> for <code>FeatureUnitWsDTO.symbol</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="symbol", description="Symbol of the feature unit") 	
	private String symbol;

	/** Name of the feature unit<br/><br/><i>Generated property</i> for <code>FeatureUnitWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the feature unit") 	
	private String name;

	/** Type of the feature unit<br/><br/><i>Generated property</i> for <code>FeatureUnitWsDTO.unitType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="unitType", description="Type of the feature unit") 	
	private String unitType;
	
	public FeatureUnitWsDTO()
	{
		// default constructor
	}
	
	public void setSymbol(final String symbol)
	{
		this.symbol = symbol;
	}

	public String getSymbol() 
	{
		return symbol;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setUnitType(final String unitType)
	{
		this.unitType = unitType;
	}

	public String getUnitType() 
	{
		return unitType;
	}
	

}