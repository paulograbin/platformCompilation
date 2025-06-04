/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.hybris.yprofile.dto;

import java.io.Serializable;


import java.util.Objects;
public  class Address  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>Address.title</code> property defined at extension <code>profileservices</code>. */
	
	private String title;

	/** <i>Generated property</i> for <code>Address.firstName</code> property defined at extension <code>profileservices</code>. */
	
	private String firstName;

	/** <i>Generated property</i> for <code>Address.lastName</code> property defined at extension <code>profileservices</code>. */
	
	private String lastName;

	/** <i>Generated property</i> for <code>Address.addition</code> property defined at extension <code>profileservices</code>. */
	
	private String addition;

	/** <i>Generated property</i> for <code>Address.street</code> property defined at extension <code>profileservices</code>. */
	
	private String street;

	/** <i>Generated property</i> for <code>Address.number</code> property defined at extension <code>profileservices</code>. */
	
	private String number;

	/** <i>Generated property</i> for <code>Address.zip</code> property defined at extension <code>profileservices</code>. */
	
	private String zip;

	/** <i>Generated property</i> for <code>Address.city</code> property defined at extension <code>profileservices</code>. */
	
	private String city;

	/** <i>Generated property</i> for <code>Address.country</code> property defined at extension <code>profileservices</code>. */
	
	private String country;
	
	public Address()
	{
		// default constructor
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
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
	
	public void setAddition(final String addition)
	{
		this.addition = addition;
	}

	public String getAddition() 
	{
		return addition;
	}
	
	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getStreet() 
	{
		return street;
	}
	
	public void setNumber(final String number)
	{
		this.number = number;
	}

	public String getNumber() 
	{
		return number;
	}
	
	public void setZip(final String zip)
	{
		this.zip = zip;
	}

	public String getZip() 
	{
		return zip;
	}
	
	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	
	public void setCountry(final String country)
	{
		this.country = country;
	}

	public String getCountry() 
	{
		return country;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final Address other = (Address) o;
		return Objects.equals(getTitle(), other.getTitle())

			&& Objects.equals(getFirstName(), other.getFirstName())

			&& Objects.equals(getLastName(), other.getLastName())

			&& Objects.equals(getAddition(), other.getAddition())

			&& Objects.equals(getStreet(), other.getStreet())

			&& Objects.equals(getNumber(), other.getNumber())

			&& Objects.equals(getZip(), other.getZip())

			&& Objects.equals(getCity(), other.getCity())

			&& Objects.equals(getCountry(), other.getCountry());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = title;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = firstName;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = lastName;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = addition;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = street;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = number;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = zip;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = city;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = country;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}