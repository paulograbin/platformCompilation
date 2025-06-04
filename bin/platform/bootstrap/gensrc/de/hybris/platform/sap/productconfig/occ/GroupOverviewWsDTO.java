/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.occ.GroupOverviewWsDTO;
import de.hybris.platform.sap.productconfig.occ.OverviewCsticValueWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a group in the context of the product configuration overview.
 */
@Schema(name="CCPGroupOverview", description="Representation of a group in the context of the product configuration overview.")
public  class GroupOverviewWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Group Identifier.<br/><br/><i>Generated property</i> for <code>GroupOverviewWsDTO.id</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="id", description="Group Identifier.", example="1-CONF_LAPTOP.GROUP1") 	
	private String id;

	/** Language-dependent group description.<br/><br/><i>Generated property</i> for <code>GroupOverviewWsDTO.groupDescription</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="groupDescription", description="Language-dependent group description.", example="Audio Options") 	
	private String groupDescription;

	/** Type of group.<br/><br/><i>Generated property</i> for <code>GroupOverviewWsDTO.groupType</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="groupType", description="Type of group.", example="CONFLICT") 	
	private String groupType;

	/** Attribute values.<br/><br/><i>Generated property</i> for <code>GroupOverviewWsDTO.characteristicValues</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="characteristicValues", description="Attribute values.") 	
	private List<OverviewCsticValueWsDTO> characteristicValues;

	/** List of subordinate groups.<br/><br/><i>Generated property</i> for <code>GroupOverviewWsDTO.subGroups</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="subGroups", description="List of subordinate groups.") 	
	private List<GroupOverviewWsDTO> subGroups;
	
	public GroupOverviewWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setGroupDescription(final String groupDescription)
	{
		this.groupDescription = groupDescription;
	}

	public String getGroupDescription() 
	{
		return groupDescription;
	}
	
	public void setGroupType(final String groupType)
	{
		this.groupType = groupType;
	}

	public String getGroupType() 
	{
		return groupType;
	}
	
	public void setCharacteristicValues(final List<OverviewCsticValueWsDTO> characteristicValues)
	{
		this.characteristicValues = characteristicValues;
	}

	public List<OverviewCsticValueWsDTO> getCharacteristicValues() 
	{
		return characteristicValues;
	}
	
	public void setSubGroups(final List<GroupOverviewWsDTO> subGroups)
	{
		this.subGroups = subGroups;
	}

	public List<GroupOverviewWsDTO> getSubGroups() 
	{
		return subGroups;
	}
	

}