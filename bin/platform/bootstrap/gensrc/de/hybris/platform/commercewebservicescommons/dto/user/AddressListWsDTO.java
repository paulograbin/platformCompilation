/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Address list
 */
@Schema(name="AddressList", description="Representation of an Address list")
public  class AddressListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of addresses<br/><br/><i>Generated property</i> for <code>AddressListWsDTO.addresses</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="addresses", description="List of addresses") 	
	private List<AddressWsDTO> addresses;
	
	public AddressListWsDTO()
	{
		// default constructor
	}
	
	public void setAddresses(final List<AddressWsDTO> addresses)
	{
		this.addresses = addresses;
	}

	public List<AddressWsDTO> getAddresses() 
	{
		return addresses;
	}
	

}