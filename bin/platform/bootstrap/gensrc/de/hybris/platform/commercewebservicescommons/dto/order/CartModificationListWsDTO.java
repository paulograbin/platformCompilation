/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.CartModificationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Cart modification list
 */
@Schema(name="CartModificationList", description="Representation of a Cart modification list")
public  class CartModificationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of cart modifications<br/><br/><i>Generated property</i> for <code>CartModificationListWsDTO.cartModifications</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="cartModifications", description="List of cart modifications") 	
	private List<CartModificationWsDTO> cartModifications;
	
	public CartModificationListWsDTO()
	{
		// default constructor
	}
	
	public void setCartModifications(final List<CartModificationWsDTO> cartModifications)
	{
		this.cartModifications = cartModifications;
	}

	public List<CartModificationWsDTO> getCartModifications() 
	{
		return cartModifications;
	}
	

}