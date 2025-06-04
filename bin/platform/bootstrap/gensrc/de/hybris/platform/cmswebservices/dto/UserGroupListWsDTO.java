/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
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
 * Specifies a list of available user groups.
 */
@Schema(name="UserGroupListWsDTO", description="Specifies a list of available user groups.")
public  class UserGroupListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserGroupListWsDTO.userGroups</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="userGroups") 	
	private List<UserGroupWsDTO> userGroups;

	/** <i>Generated property</i> for <code>UserGroupListWsDTO.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public UserGroupListWsDTO()
	{
		// default constructor
	}
	
	public void setUserGroups(final List<UserGroupWsDTO> userGroups)
	{
		this.userGroups = userGroups;
	}

	public List<UserGroupWsDTO> getUserGroups() 
	{
		return userGroups;
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