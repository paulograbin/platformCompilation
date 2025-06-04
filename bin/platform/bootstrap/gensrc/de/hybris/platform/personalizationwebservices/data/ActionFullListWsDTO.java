/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.ActionFullData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of actions
 */
@Schema(name="ActionFullList", description="List of actions")
public  class ActionFullListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of actions<br/><br/><i>Generated property</i> for <code>ActionFullListWsDTO.actions</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="actions", description="List of actions") 	
	private List<ActionFullData> actions;

	/** Pagination details<br/><br/><i>Generated property</i> for <code>ActionFullListWsDTO.pagination</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="pagination", description="Pagination details") 	
	private PaginationWsDTO pagination;
	
	public ActionFullListWsDTO()
	{
		// default constructor
	}
	
	public void setActions(final List<ActionFullData> actions)
	{
		this.actions = actions;
	}

	public List<ActionFullData> getActions() 
	{
		return actions;
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