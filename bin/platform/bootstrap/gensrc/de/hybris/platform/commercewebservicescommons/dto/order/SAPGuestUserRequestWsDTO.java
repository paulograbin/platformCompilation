/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of information of a guest user
 */
@Schema(name="SAPGuestUserRequest", description="Representation of information of a guest user")
public  class SAPGuestUserRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Email of the guest user. It will be used during the guest checkout process but may be optional when creating a guest user for a cart.<br/><br/><i>Generated property</i> for <code>SAPGuestUserRequestWsDTO.email</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="email", description="Email of the guest user. It will be used during the guest checkout process but may be optional when creating a guest user for a cart.", example="xxx.yy@zz.com") 	
	private String email;
	
	public SAPGuestUserRequestWsDTO()
	{
		// default constructor
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	

}