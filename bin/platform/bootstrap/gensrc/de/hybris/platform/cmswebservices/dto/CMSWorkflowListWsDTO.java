/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
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
 * Specifies a list of available CMS workflows.
 */
@Schema(name="CMSWorkflowListWsDTO", description="Specifies a list of available CMS workflows.")
public  class CMSWorkflowListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowListWsDTO.workflows</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="workflows") 	
	private List<CMSWorkflowWsDTO> workflows;

	/** <i>Generated property</i> for <code>CMSWorkflowListWsDTO.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public CMSWorkflowListWsDTO()
	{
		// default constructor
	}
	
	public void setWorkflows(final List<CMSWorkflowWsDTO> workflows)
	{
		this.workflows = workflows;
	}

	public List<CMSWorkflowWsDTO> getWorkflows() 
	{
		return workflows;
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