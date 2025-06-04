/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="CustomerSuggestion")
public  class CustomerSuggestionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDTO.email</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="email") 	
	private String email;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDTO.fullName</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="fullName") 	
	private String fullName;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDTO.date</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="date") 	
	private String date;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDTO.card</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="card") 	
	private String card;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDTO.carts</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="carts") 	
	private List<String> carts;
	
	public CustomerSuggestionWsDTO()
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
	
	public void setFullName(final String fullName)
	{
		this.fullName = fullName;
	}

	public String getFullName() 
	{
		return fullName;
	}
	
	public void setDate(final String date)
	{
		this.date = date;
	}

	public String getDate() 
	{
		return date;
	}
	
	public void setCard(final String card)
	{
		this.card = card;
	}

	public String getCard() 
	{
		return card;
	}
	
	public void setCarts(final List<String> carts)
	{
		this.carts = carts;
	}

	public List<String> getCarts() 
	{
		return carts;
	}
	

}