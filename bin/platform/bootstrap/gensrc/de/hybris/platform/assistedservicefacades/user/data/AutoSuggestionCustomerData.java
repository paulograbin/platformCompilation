/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicefacades.user.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class AutoSuggestionCustomerData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.email</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String email;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.value</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String value;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.date</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String date;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.card</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String card;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.carts</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private List<String> carts;
	
	public AutoSuggestionCustomerData()
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
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
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