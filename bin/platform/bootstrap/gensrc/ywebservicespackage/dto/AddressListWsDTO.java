/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import ywebservicespackage.dto.AddressWsDTO;


import java.util.Objects;
/**
 * List of addresses
 */
@Schema(name="addressList", description="List of addresses")
public  class AddressListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressListWsDTO.addresses</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="addresses") 	
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