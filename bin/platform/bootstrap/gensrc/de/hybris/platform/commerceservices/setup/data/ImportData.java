/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.setup.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import java.util.Objects;
public  class ImportData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ImportData.productCatalogName</code> property defined at extension <code>commerceservices</code>. */
	
	private String productCatalogName;

	/** <i>Generated property</i> for <code>ImportData.contentCatalogNames</code> property defined at extension <code>commerceservices</code>. */
	
	private List<String> contentCatalogNames;

	/** <i>Generated property</i> for <code>ImportData.storeNames</code> property defined at extension <code>commerceservices</code>. */
	
	private List<String> storeNames;

	/** <i>Generated property</i> for <code>ImportData.siteNames</code> property defined at extension <code>commerceservices</code>. */
	
	private List<String> siteNames;

	/** <i>Generated property</i> for <code>ImportData.solrParams</code> property defined at extension <code>commerceservices</code>. */
	
	private Map<String,Map<String,Object>> solrParams;
	
	public ImportData()
	{
		// default constructor
	}
	
	public void setProductCatalogName(final String productCatalogName)
	{
		this.productCatalogName = productCatalogName;
	}

	public String getProductCatalogName() 
	{
		return productCatalogName;
	}
	
	public void setContentCatalogNames(final List<String> contentCatalogNames)
	{
		this.contentCatalogNames = contentCatalogNames;
	}

	public List<String> getContentCatalogNames() 
	{
		return contentCatalogNames;
	}
	
	public void setStoreNames(final List<String> storeNames)
	{
		this.storeNames = storeNames;
	}

	public List<String> getStoreNames() 
	{
		return storeNames;
	}
	
	public void setSiteNames(final List<String> siteNames)
	{
		this.siteNames = siteNames;
	}

	public List<String> getSiteNames() 
	{
		return siteNames;
	}
	
	public void setSolrParams(final Map<String,Map<String,Object>> solrParams)
	{
		this.solrParams = solrParams;
	}

	public Map<String,Map<String,Object>> getSolrParams() 
	{
		return solrParams;
	}
	

}