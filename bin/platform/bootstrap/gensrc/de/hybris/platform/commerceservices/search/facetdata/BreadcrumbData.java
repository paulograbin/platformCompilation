/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.facetdata;

import java.io.Serializable;


import java.util.Objects;
/**
 * POJO representing a section of the Breadcrumb.
 */
public  class BreadcrumbData<STATE>  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BreadcrumbData<STATE>.facetCode</code> property defined at extension <code>commerceservices</code>. */
	
	private String facetCode;

	/** <i>Generated property</i> for <code>BreadcrumbData<STATE>.facetName</code> property defined at extension <code>commerceservices</code>. */
	
	private String facetName;

	/** <i>Generated property</i> for <code>BreadcrumbData<STATE>.facetValueCode</code> property defined at extension <code>commerceservices</code>. */
	
	private String facetValueCode;

	/** <i>Generated property</i> for <code>BreadcrumbData<STATE>.facetValueName</code> property defined at extension <code>commerceservices</code>. */
	
	private String facetValueName;

	/** <i>Generated property</i> for <code>BreadcrumbData<STATE>.removeQuery</code> property defined at extension <code>commerceservices</code>. */
	
	private STATE removeQuery;

	/** <i>Generated property</i> for <code>BreadcrumbData<STATE>.truncateQuery</code> property defined at extension <code>commerceservices</code>. */
	
	private STATE truncateQuery;
	
	public BreadcrumbData()
	{
		// default constructor
	}
	
	public void setFacetCode(final String facetCode)
	{
		this.facetCode = facetCode;
	}

	public String getFacetCode() 
	{
		return facetCode;
	}
	
	public void setFacetName(final String facetName)
	{
		this.facetName = facetName;
	}

	public String getFacetName() 
	{
		return facetName;
	}
	
	public void setFacetValueCode(final String facetValueCode)
	{
		this.facetValueCode = facetValueCode;
	}

	public String getFacetValueCode() 
	{
		return facetValueCode;
	}
	
	public void setFacetValueName(final String facetValueName)
	{
		this.facetValueName = facetValueName;
	}

	public String getFacetValueName() 
	{
		return facetValueName;
	}
	
	public void setRemoveQuery(final STATE removeQuery)
	{
		this.removeQuery = removeQuery;
	}

	public STATE getRemoveQuery() 
	{
		return removeQuery;
	}
	
	public void setTruncateQuery(final STATE truncateQuery)
	{
		this.truncateQuery = truncateQuery;
	}

	public STATE getTruncateQuery() 
	{
		return truncateQuery;
	}
	

}