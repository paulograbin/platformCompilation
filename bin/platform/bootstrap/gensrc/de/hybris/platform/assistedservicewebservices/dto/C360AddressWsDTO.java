/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.CountryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.RegionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Customer360 profile address
 */
@Schema(name="C360Address", description="Customer360 profile address")
public  class C360AddressWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Unique id value of the address which is optional while creating new address. While performing other address operations this value is the key<br/><br/><i>Generated property</i> for <code>C360AddressWsDTO.id</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="id", description="Unique id value of the address which is optional while creating new address. While performing other address operations this value is the key", example="8796098854935") 	
	private String id;

	/** First line of the address<br/><br/><i>Generated property</i> for <code>C360AddressWsDTO.line1</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="line1", description="First line of the address", example="Aizumicho") 	
	private String line1;

	/** Second line of the address<br/><br/><i>Generated property</i> for <code>C360AddressWsDTO.line2</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="line2", description="Second line of the address", example="1-4-6") 	
	private String line2;

	/** Town field<br/><br/><i>Generated property</i> for <code>C360AddressWsDTO.town</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="town", description="Town field", example="Sunnyvale") 	
	private String town;

	/** Region where address belongs to<br/><br/><i>Generated property</i> for <code>C360AddressWsDTO.region</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="region", description="Region where address belongs to") 	
	private RegionWsDTO region;

	/** Country where address is located<br/><br/><i>Generated property</i> for <code>C360AddressWsDTO.country</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="country", description="Country where address is located") 	
	private CountryWsDTO country;
	
	public C360AddressWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setLine1(final String line1)
	{
		this.line1 = line1;
	}

	public String getLine1() 
	{
		return line1;
	}
	
	public void setLine2(final String line2)
	{
		this.line2 = line2;
	}

	public String getLine2() 
	{
		return line2;
	}
	
	public void setTown(final String town)
	{
		this.town = town;
	}

	public String getTown() 
	{
		return town;
	}
	
	public void setRegion(final RegionWsDTO region)
	{
		this.region = region;
	}

	public RegionWsDTO getRegion() 
	{
		return region;
	}
	
	public void setCountry(final CountryWsDTO country)
	{
		this.country = country;
	}

	public CountryWsDTO getCountry() 
	{
		return country;
	}
	

}