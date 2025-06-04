/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.solrfacetsearch;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Solr Search Query
 */
@Schema(name="SolrSearchQuery", description="Representation of a Solr Search Query")
public  class SolrSearchQueryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of category<br/><br/><i>Generated property</i> for <code>SolrSearchQueryWsDTO.categoryCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="categoryCode", description="Code of category") 	
	private String categoryCode;
	
	public SolrSearchQueryWsDTO()
	{
		// default constructor
	}
	
	public void setCategoryCode(final String categoryCode)
	{
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() 
	{
		return categoryCode;
	}
	

}