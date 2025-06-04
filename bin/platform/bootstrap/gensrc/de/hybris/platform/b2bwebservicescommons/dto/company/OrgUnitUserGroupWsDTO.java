/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserGroupWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
@Schema(name="OrgUnitUserGroup")
public  class OrgUnitUserGroupWsDTO extends UserGroupWsDTO 

{



	/** Organizational Unit of the user group<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgUnit", description="Organizational Unit of the user group") 	
	private B2BUnitWsDTO orgUnit;

	/** Order approval permission of the user group<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupWsDTO.permissions</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="permissions", description="Order approval permission of the user group") 	
	private List<B2BPermissionWsDTO> permissions;

	/** List of Roles<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupWsDTO.roles</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="roles", description="List of Roles") 	
	private List<String> roles;

	/** Boolean flag of whether a user group is selected or not<br/><br/><i>Generated property</i> for <code>OrgUnitUserGroupWsDTO.selected</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="selected", description="Boolean flag of whether a user group is selected or not", example="true") 	
	private Boolean selected;
	
	public OrgUnitUserGroupWsDTO()
	{
		// default constructor
	}
	
	public void setOrgUnit(final B2BUnitWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public B2BUnitWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setPermissions(final List<B2BPermissionWsDTO> permissions)
	{
		this.permissions = permissions;
	}

	public List<B2BPermissionWsDTO> getPermissions() 
	{
		return permissions;
	}
	
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}

	public List<String> getRoles() 
	{
		return roles;
	}
	
	public void setSelected(final Boolean selected)
	{
		this.selected = selected;
	}

	public Boolean getSelected() 
	{
		return selected;
	}
	

}