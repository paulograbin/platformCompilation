/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.admin.data;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;


import java.util.Objects;
public  class SnIndexerConfiguration  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SnIndexerConfiguration.id</code> property defined at extension <code>searchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SnIndexerConfiguration.name</code> property defined at extension <code>searchservices</code>. */
	
	private Map<Locale,String> name;

	/** <i>Generated property</i> for <code>SnIndexerConfiguration.concurrency</code> property defined at extension <code>searchservices</code>. */
	
	private Integer concurrency;

	/** <i>Generated property</i> for <code>SnIndexerConfiguration.batchSize</code> property defined at extension <code>searchservices</code>. */
	
	private Integer batchSize;

	/** <i>Generated property</i> for <code>SnIndexerConfiguration.retryConfigurationId</code> property defined at extension <code>searchservices</code>. */
	
	private String retryConfigurationId;
	
	public SnIndexerConfiguration()
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
	
	public void setConcurrency(final Integer concurrency)
	{
		this.concurrency = concurrency;
	}

	public Integer getConcurrency() 
	{
		return concurrency;
	}
	
	public void setBatchSize(final Integer batchSize)
	{
		this.batchSize = batchSize;
	}

	public Integer getBatchSize() 
	{
		return batchSize;
	}
	
	public void setRetryConfigurationId(final String retryConfigurationId)
	{
		this.retryConfigurationId = retryConfigurationId;
	}

	public String getRetryConfigurationId() 
	{
		return retryConfigurationId;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final SnIndexerConfiguration other = (SnIndexerConfiguration) o;
		return Objects.equals(getId(), other.getId())

			&& Objects.equals(getName(), other.getName())

			&& Objects.equals(getConcurrency(), other.getConcurrency())

			&& Objects.equals(getBatchSize(), other.getBatchSize())

			&& Objects.equals(getRetryConfigurationId(), other.getRetryConfigurationId());


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
		attribute = concurrency;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = batchSize;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = retryConfigurationId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}