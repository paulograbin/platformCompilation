/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.facetdata;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.SearchStateWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Breadcrumb
 */
@Schema(name="Breadcrumb", description="Representation of a Breadcrumb")
public  class BreadcrumbWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the facet<br/><br/><i>Generated property</i> for <code>BreadcrumbWsDTO.facetCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="facetCode", description="Code of the facet") 	
	private String facetCode;

	/** Name of the facet<br/><br/><i>Generated property</i> for <code>BreadcrumbWsDTO.facetName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="facetName", description="Name of the facet") 	
	private String facetName;

	/** Value code of the facet<br/><br/><i>Generated property</i> for <code>BreadcrumbWsDTO.facetValueCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="facetValueCode", description="Value code of the facet") 	
	private String facetValueCode;

	/** Value name of the facet<br/><br/><i>Generated property</i> for <code>BreadcrumbWsDTO.facetValueName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="facetValueName", description="Value name of the facet") 	
	private String facetValueName;

	/** Remove query<br/><br/><i>Generated property</i> for <code>BreadcrumbWsDTO.removeQuery</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="removeQuery", description="Remove query") 	
	private SearchStateWsDTO removeQuery;

	/** Truncate query<br/><br/><i>Generated property</i> for <code>BreadcrumbWsDTO.truncateQuery</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="truncateQuery", description="Truncate query") 	
	private SearchStateWsDTO truncateQuery;
	
	public BreadcrumbWsDTO()
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
	
	public void setRemoveQuery(final SearchStateWsDTO removeQuery)
	{
		this.removeQuery = removeQuery;
	}

	public SearchStateWsDTO getRemoveQuery() 
	{
		return removeQuery;
	}
	
	public void setTruncateQuery(final SearchStateWsDTO truncateQuery)
	{
		this.truncateQuery = truncateQuery;
	}

	public SearchStateWsDTO getTruncateQuery() 
	{
		return truncateQuery;
	}
	

}