/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.hybris.yprofile.dto;

import java.io.Serializable;


import java.util.Objects;
public  class Consumer  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>Consumer.ref</code> property defined at extension <code>profileservices</code>. */
	
	private String ref;

	/** <i>Generated property</i> for <code>Consumer.type</code> property defined at extension <code>profileservices</code>. */
	
	private String type;
	
	public Consumer()
	{
		// default constructor
	}
	
	public void setRef(final String ref)
	{
		this.ref = ref;
	}

	public String getRef() 
	{
		return ref;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final Consumer other = (Consumer) o;
		return Objects.equals(getRef(), other.getRef())

			&& Objects.equals(getType(), other.getType());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = ref;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = type;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}