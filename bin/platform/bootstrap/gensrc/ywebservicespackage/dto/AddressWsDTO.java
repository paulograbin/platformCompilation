/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Address DTO
 */
@Schema(name="address", description="Address DTO")
public  class AddressWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressWsDTO.street</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="street") 	
	private String street;

	/** <i>Generated property</i> for <code>AddressWsDTO.town</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="town") 	
	private String town;

	/** <i>Generated property</i> for <code>AddressWsDTO.streetNumber</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="streetNumber") 	
	private String streetNumber;
	
	public AddressWsDTO()
	{
		// default constructor
	}
	
	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getStreet() 
	{
		return street;
	}
	
	public void setTown(final String town)
	{
		this.town = town;
	}

	public String getTown() 
	{
		return town;
	}
	
	public void setStreetNumber(final String streetNumber)
	{
		this.streetNumber = streetNumber;
	}

	public String getStreetNumber() 
	{
		return streetNumber;
	}
	

}