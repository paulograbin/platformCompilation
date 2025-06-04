/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.UserGroupWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a User Group List
 */
@Schema(name="UserGroupList", description="Representation of a User Group List")
public  class UserGroupListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of user groups<br/><br/><i>Generated property</i> for <code>UserGroupListWsDTO.userGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="userGroups", description="List of user groups") 	
	private List<UserGroupWsDTO> userGroups;

	/** Total number<br/><br/><i>Generated property</i> for <code>UserGroupListWsDTO.totalNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalNumber", description="Total number") 	
	private Integer totalNumber;

	/** Page size<br/><br/><i>Generated property</i> for <code>UserGroupListWsDTO.pageSize</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="pageSize", description="Page size") 	
	private Integer pageSize;

	/** Number of pages<br/><br/><i>Generated property</i> for <code>UserGroupListWsDTO.numberOfPages</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="numberOfPages", description="Number of pages") 	
	private Integer numberOfPages;

	/** Current page<br/><br/><i>Generated property</i> for <code>UserGroupListWsDTO.currentPage</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currentPage", description="Current page") 	
	private Integer currentPage;
	
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
	
	public void setTotalNumber(final Integer totalNumber)
	{
		this.totalNumber = totalNumber;
	}

	public Integer getTotalNumber() 
	{
		return totalNumber;
	}
	
	public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public Integer getPageSize() 
	{
		return pageSize;
	}
	
	public void setNumberOfPages(final Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}

	public Integer getNumberOfPages() 
	{
		return numberOfPages;
	}
	
	public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}

	public Integer getCurrentPage() 
	{
		return currentPage;
	}
	

}