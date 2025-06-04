/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a user group
 */
@Schema(name="UserGroup", description="Representation of a user group")
public  class UserGroupWsDTO extends PrincipalWsDTO 

{



	/** List of members<br/><br/><i>Generated property</i> for <code>UserGroupWsDTO.members</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="members", description="List of members") 	
	private List<PrincipalWsDTO> members;

	/** List of subgroups<br/><br/><i>Generated property</i> for <code>UserGroupWsDTO.subGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="subGroups", description="List of subgroups") 	
	private List<UserGroupWsDTO> subGroups;

	/** Number of members<br/><br/><i>Generated property</i> for <code>UserGroupWsDTO.membersCount</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="membersCount", description="Number of members") 	
	private Integer membersCount;
	
	public UserGroupWsDTO()
	{
		// default constructor
	}
	
	public void setMembers(final List<PrincipalWsDTO> members)
	{
		this.members = members;
	}

	public List<PrincipalWsDTO> getMembers() 
	{
		return members;
	}
	
	public void setSubGroups(final List<UserGroupWsDTO> subGroups)
	{
		this.subGroups = subGroups;
	}

	public List<UserGroupWsDTO> getSubGroups() 
	{
		return subGroups;
	}
	
	public void setMembersCount(final Integer membersCount)
	{
		this.membersCount = membersCount;
	}

	public Integer getMembersCount() 
	{
		return membersCount;
	}
	

}