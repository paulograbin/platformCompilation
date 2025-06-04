/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an user list used in organizational units
 */
@Schema(name="OrgUnitUserList", description="Representation of an user list used in organizational units")
public  class OrgUnitUserListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of users<br/><br/><i>Generated property</i> for <code>OrgUnitUserListWsDTO.users</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="users", description="List of users", required=true) 	
	private List<UserWsDTO> users;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>OrgUnitUserListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts", required=true) 	
	private List<SortWsDTO> sorts;

	/** Pagination items<br/><br/><i>Generated property</i> for <code>OrgUnitUserListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination items", required=true) 	
	private PaginationWsDTO pagination;
	
	public OrgUnitUserListWsDTO()
	{
		// default constructor
	}
	
	public void setUsers(final List<UserWsDTO> users)
	{
		this.users = users;
	}

	public List<UserWsDTO> getUsers() 
	{
		return users;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
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