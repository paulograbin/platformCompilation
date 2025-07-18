/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.spi.data;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import java.util.Objects;
public  class AbstractSnSearchProviderConfiguration  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractSnSearchProviderConfiguration.id</code> property defined at extension <code>searchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>AbstractSnSearchProviderConfiguration.name</code> property defined at extension <code>searchservices</code>. */
	
	private Map<Locale,String> name;

	/** <i>Generated property</i> for <code>AbstractSnSearchProviderConfiguration.listeners</code> property defined at extension <code>searchservices</code>. */
	
	private List<String> listeners;

	/** <i>Generated property</i> for <code>AbstractSnSearchProviderConfiguration.additionalParameters</code> property defined at extension <code>searchservices</code>. */
	
	private Map<String,String> additionalParameters;
	
	public AbstractSnSearchProviderConfiguration()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setName(final Map<Locale,String> name)
	{
		this.name = name;
	}

	public Map<Locale,String> getName() 
	{
		return name;
	}
	
	public void setListeners(final List<String> listeners)
	{
		this.listeners = listeners;
	}

	public List<String> getListeners() 
	{
		return listeners;
	}
	
	public void setAdditionalParameters(final Map<String,String> additionalParameters)
	{
		this.additionalParameters = additionalParameters;
	}

	public Map<String,String> getAdditionalParameters() 
	{
		return additionalParameters;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AbstractSnSearchProviderConfiguration other = (AbstractSnSearchProviderConfiguration) o;
		return Objects.equals(getId(), other.getId())

			&& Objects.equals(getName(), other.getName())

			&& Objects.equals(getListeners(), other.getListeners())

			&& Objects.equals(getAdditionalParameters(), other.getAdditionalParameters());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = id;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = name;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = listeners;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = additionalParameters;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}