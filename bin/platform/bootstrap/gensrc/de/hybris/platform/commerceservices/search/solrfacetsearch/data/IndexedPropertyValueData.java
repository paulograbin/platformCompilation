/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.solrfacetsearch.data;

import java.io.Serializable;


import java.util.Objects;
public  class IndexedPropertyValueData<INDEXED_PROPERTY_TYPE>  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexedPropertyValueData<INDEXED_PROPERTY_TYPE>.indexedProperty</code> property defined at extension <code>commerceservices</code>. */
	
	private INDEXED_PROPERTY_TYPE indexedProperty;

	/** <i>Generated property</i> for <code>IndexedPropertyValueData<INDEXED_PROPERTY_TYPE>.value</code> property defined at extension <code>commerceservices</code>. */
	
	private String value;
	
	public IndexedPropertyValueData()
	{
		// default constructor
	}
	
	public void setIndexedProperty(final INDEXED_PROPERTY_TYPE indexedProperty)
	{
		this.indexedProperty = indexedProperty;
	}

	public INDEXED_PROPERTY_TYPE getIndexedProperty() 
	{
		return indexedProperty;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	

}