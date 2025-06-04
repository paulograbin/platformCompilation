/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AsCatalogVersion;


import java.util.Objects;
public  class AbstractAsSearchProfile  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.catalogVersion</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsCatalogVersion catalogVersion;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.code</code> property defined at extension <code>adaptivesearch</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.indexType</code> property defined at extension <code>adaptivesearch</code>. */
	
	private String indexType;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.queryContext</code> property defined at extension <code>adaptivesearch</code>. */
	
	private String queryContext;
	
	public AbstractAsSearchProfile()
	{
		// default constructor
	}
	
	public void setCatalogVersion(final AsCatalogVersion catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public AsCatalogVersion getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setIndexType(final String indexType)
	{
		this.indexType = indexType;
	}

	public String getIndexType() 
	{
		return indexType;
	}
	
	public void setQueryContext(final String queryContext)
	{
		this.queryContext = queryContext;
	}

	public String getQueryContext() 
	{
		return queryContext;
	}
	

}