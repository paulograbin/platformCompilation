/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available CMS versions.
 */
@Schema(name="CMSVersionListWsDTO", description="Specifies a list of available CMS versions.")
public  class CMSVersionListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSVersionListWsDTO.results</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="results", example="[{\"creationtime\" : \"2019-12-23T19:35:35+0000\", \"itemUUID\" : \"eyJpd\", \"label\" : \"newVersion\", \"uid\" : \"00000000\"}]") 	
	private List<CMSVersionWsDTO> results;

	/** <i>Generated property</i> for <code>CMSVersionListWsDTO.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"1\", \"page\" : \"0\", \"totalCount\" : \"1\", \"totalPages\" : \"1\"}") 	
	private PaginationWsDTO pagination;
	
	public CMSVersionListWsDTO()
	{
		// default constructor
	}
	
	public void setResults(final List<CMSVersionWsDTO> results)
	{
		this.results = results;
	}

	public List<CMSVersionWsDTO> getResults() 
	{
		return results;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}