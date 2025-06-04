/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BApprovalProcessWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterShallowWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an organizational unit
 */
@Schema(name="B2BUnit", description="Representation of an organizational unit")
public  class B2BUnitWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Boolean flag of whether Organizational Unit is active<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="active", description="Boolean flag of whether Organizational Unit is active", example="true") 	
	private Boolean active;

	/** Identifier of the organizational unit<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.uid</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="uid", description="Identifier of the organizational unit", required=true, example="Pronto") 	
	private String uid;

	/** Name of the organizational unit<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Name of the organizational unit", example="Pronto") 	
	private String name;

	/** Parent unit of the organizational unit<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.parentOrgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="parentOrgUnit", description="Parent unit of the organizational unit") 	
	private B2BUnitWsDTO parentOrgUnit;

	/** Approval Process of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.approvalProcess</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approvalProcess", description="Approval Process of the organizational unit node") 	
	private B2BApprovalProcessWsDTO approvalProcess;

	/** Addresses of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.addresses</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="addresses", description="Addresses of the organizational unit node") 	
	private List<AddressWsDTO> addresses;

	/** Approvers of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.approvers</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approvers", description="Approvers of the organizational unit node") 	
	private List<UserWsDTO> approvers;

	/** Managers of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.managers</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="managers", description="Managers of the organizational unit node") 	
	private List<UserWsDTO> managers;

	/** Administrators of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.administrators</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="administrators", description="Administrators of the organizational unit node") 	
	private List<UserWsDTO> administrators;

	/** Customers of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.customers</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="customers", description="Customers of the organizational unit node") 	
	private List<UserWsDTO> customers;

	/** The cost centers of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitWsDTO.costCenters</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="costCenters", description="The cost centers of the organizational unit node") 	
	private List<B2BCostCenterShallowWsDTO> costCenters;
	
	public B2BUnitWsDTO()
	{
		// default constructor
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setParentOrgUnit(final B2BUnitWsDTO parentOrgUnit)
	{
		this.parentOrgUnit = parentOrgUnit;
	}

	public B2BUnitWsDTO getParentOrgUnit() 
	{
		return parentOrgUnit;
	}
	
	public void setApprovalProcess(final B2BApprovalProcessWsDTO approvalProcess)
	{
		this.approvalProcess = approvalProcess;
	}

	public B2BApprovalProcessWsDTO getApprovalProcess() 
	{
		return approvalProcess;
	}
	
	public void setAddresses(final List<AddressWsDTO> addresses)
	{
		this.addresses = addresses;
	}

	public List<AddressWsDTO> getAddresses() 
	{
		return addresses;
	}
	
	public void setApprovers(final List<UserWsDTO> approvers)
	{
		this.approvers = approvers;
	}

	public List<UserWsDTO> getApprovers() 
	{
		return approvers;
	}
	
	public void setManagers(final List<UserWsDTO> managers)
	{
		this.managers = managers;
	}

	public List<UserWsDTO> getManagers() 
	{
		return managers;
	}
	
	public void setAdministrators(final List<UserWsDTO> administrators)
	{
		this.administrators = administrators;
	}

	public List<UserWsDTO> getAdministrators() 
	{
		return administrators;
	}
	
	public void setCustomers(final List<UserWsDTO> customers)
	{
		this.customers = customers;
	}

	public List<UserWsDTO> getCustomers() 
	{
		return customers;
	}
	
	public void setCostCenters(final List<B2BCostCenterShallowWsDTO> costCenters)
	{
		this.costCenters = costCenters;
	}

	public List<B2BCostCenterShallowWsDTO> getCostCenters() 
	{
		return costCenters;
	}
	

}