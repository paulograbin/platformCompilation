/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class NamedQueryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NamedQueryData.namedQuery</code> property defined at extension <code>cmsfacades</code>. */
	
	private String namedQuery;

	/** <i>Generated property</i> for <code>NamedQueryData.params</code> property defined at extension <code>cmsfacades</code>. */
	
	private String params;

	/** <i>Generated property</i> for <code>NamedQueryData.sort</code> property defined at extension <code>cmsfacades</code>. */
	
	private String sort;

	/** <i>Generated property</i> for <code>NamedQueryData.pageSize</code> property defined at extension <code>cmsfacades</code>. */
	
	private String pageSize;

	/** <i>Generated property</i> for <code>NamedQueryData.currentPage</code> property defined at extension <code>cmsfacades</code>. */
	
	private String currentPage;

	/** <i>Generated property</i> for <code>NamedQueryData.queryType</code> property defined at extension <code>cmsfacades</code>. */
	
	private Class<?> queryType;
	
	public NamedQueryData()
	{
		// default constructor
	}
	
	public void setNamedQuery(final String namedQuery)
	{
		this.namedQuery = namedQuery;
	}

	public String getNamedQuery() 
	{
		return namedQuery;
	}
	
	public void setParams(final String params)
	{
		this.params = params;
	}

	public String getParams() 
	{
		return params;
	}
	
	public void setSort(final String sort)
	{
		this.sort = sort;
	}

	public String getSort() 
	{
		return sort;
	}
	
	public void setPageSize(final String pageSize)
	{
		this.pageSize = pageSize;
	}

	public String getPageSize() 
	{
		return pageSize;
	}
	
	public void setCurrentPage(final String currentPage)
	{
		this.currentPage = currentPage;
	}

	public String getCurrentPage() 
	{
		return currentPage;
	}
	
	public void setQueryType(final Class<?> queryType)
	{
		this.queryType = queryType;
	}

	public Class<?> getQueryType() 
	{
		return queryType;
	}
	

}