/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import java.util.Set;


import java.util.Objects;
public  class AsFacetValueData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsFacetValueData.value</code> property defined at extension <code>adaptivesearch</code>. */
	
	private String value;

	/** <i>Generated property</i> for <code>AsFacetValueData.name</code> property defined at extension <code>adaptivesearch</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>AsFacetValueData.count</code> property defined at extension <code>adaptivesearch</code>. */
	
	private long count;

	/** <i>Generated property</i> for <code>AsFacetValueData.selected</code> property defined at extension <code>adaptivesearch</code>. */
	
	private boolean selected;

	/** <i>Generated property</i> for <code>AsFacetValueData.tags</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Set<String> tags;
	
	public AsFacetValueData()
	{
		// default constructor
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCount(final long count)
	{
		this.count = count;
	}

	public long getCount() 
	{
		return count;
	}
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelected() 
	{
		return selected;
	}
	
	public void setTags(final Set<String> tags)
	{
		this.tags = tags;
	}

	public Set<String> getTags() 
	{
		return tags;
	}
	

}