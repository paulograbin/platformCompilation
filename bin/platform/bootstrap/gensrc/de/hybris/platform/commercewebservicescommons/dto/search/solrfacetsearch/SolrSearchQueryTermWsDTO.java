/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.solrfacetsearch;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Solr Search Query Term
 */
@Schema(name="SolrSearchQueryTerm", description="Representation of a Solr Search Query Term")
public  class SolrSearchQueryTermWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Key of solr search query term<br/><br/><i>Generated property</i> for <code>SolrSearchQueryTermWsDTO.key</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="key", description="Key of solr search query term") 	
	private String key;

	/** Value of solr search query term<br/><br/><i>Generated property</i> for <code>SolrSearchQueryTermWsDTO.value</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="value", description="Value of solr search query term") 	
	private String value;
	
	public SolrSearchQueryTermWsDTO()
	{
		// default constructor
	}
	
	public void setKey(final String key)
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
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