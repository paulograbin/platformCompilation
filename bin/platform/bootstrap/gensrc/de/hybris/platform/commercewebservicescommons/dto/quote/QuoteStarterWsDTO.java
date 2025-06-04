/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Object for the quote creation, either cartId or quoteCode must be specified.
 */
@Schema(name="QuoteStarter", description="Object for the quote creation, either cartId or quoteCode must be specified.")
public  class QuoteStarterWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** CartId of the cart from which the quote will be created.<br/><br/><i>Generated property</i> for <code>QuoteStarterWsDTO.cartId</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="cartId", description="CartId of the cart from which the quote will be created.", required=false, example="0003050") 	
	private String cartId;

	/** Code of the quote for the requote action.<br/><br/><i>Generated property</i> for <code>QuoteStarterWsDTO.quoteCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="quoteCode", description="Code of the quote for the requote action.", required=false, example="0003060") 	
	private String quoteCode;
	
	public QuoteStarterWsDTO()
	{
		// default constructor
	}
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		return cartId;
	}
	
	public void setQuoteCode(final String quoteCode)
	{
		this.quoteCode = quoteCode;
	}

	public String getQuoteCode() 
	{
		return quoteCode;
	}
	

}