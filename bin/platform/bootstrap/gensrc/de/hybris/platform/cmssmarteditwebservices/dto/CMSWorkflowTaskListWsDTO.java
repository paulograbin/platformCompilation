/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="CMSWorkflowTaskListWsDTO")
public  class CMSWorkflowTaskListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowTaskListWsDTO.tasks</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="tasks") 	
	private List<CMSWorkflowTaskWsDTO> tasks;

	/** <i>Generated property</i> for <code>CMSWorkflowTaskListWsDTO.pagination</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="pagination") 	
	private PaginationWsDTO pagination;
	
	public CMSWorkflowTaskListWsDTO()
	{
		// default constructor
	}
	
	public void setTasks(final List<CMSWorkflowTaskWsDTO> tasks)
	{
		this.tasks = tasks;
	}

	public List<CMSWorkflowTaskWsDTO> getTasks() 
	{
		return tasks;
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