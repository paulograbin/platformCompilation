/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
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
 * User DTO
 */
@Schema(name="user", description="User DTO")
public  class UserWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserWsDTO.addresses</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="addresses") 	
	private List<AddressWsDTO> addresses;

	/** First Name<br/><br/><i>Generated property</i> for <code>UserWsDTO.firstName</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="firstName", description="First Name", required=true) 	
	private String firstName;

	/** Last Name<br/><br/><i>Generated property</i> for <code>UserWsDTO.lastName</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="lastName", description="Last Name", required=true) 	
	private String lastName;

	/** <i>Generated property</i> for <code>UserWsDTO.info</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="info") 	
	private String info;

	/** Billing Address<br/><br/><i>Generated property</i> for <code>UserWsDTO.billingAddress</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="billingAddress", description="Billing Address") 	
	private AddressWsDTO billingAddress;

	/** Shipping Address<br/><br/><i>Generated property</i> for <code>UserWsDTO.shippingAddress</code> property defined at extension <code>ywebservices</code>. */
@Schema(name="shippingAddress", description="Shipping Address") 	
	private AddressWsDTO shippingAddress;
	
	public UserWsDTO()
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
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setInfo(final String info)
	{
		this.info = info;
	}

	public String getInfo() 
	{
		return info;
	}
	
	public void setBillingAddress(final AddressWsDTO billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public AddressWsDTO getBillingAddress() 
	{
		return billingAddress;
	}
	
	public void setShippingAddress(final AddressWsDTO shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public AddressWsDTO getShippingAddress() 
	{
		return shippingAddress;
	}
	

}