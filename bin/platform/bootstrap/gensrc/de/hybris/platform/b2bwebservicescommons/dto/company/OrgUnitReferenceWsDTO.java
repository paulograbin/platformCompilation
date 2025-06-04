/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Reference to organizational unit.
 */
@Schema(name="OrgUnitReference", description="Reference to organizational unit.")
public  class OrgUnitReferenceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Identifier of the organizational unit.<br/><br/><i>Generated property</i> for <code>OrgUnitReferenceWsDTO.uid</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="uid", description="Identifier of the organizational unit.", required=true, example="Pronto") 	
	private String uid;

	/** Name of the organizational unit.<br/><br/><i>Generated property</i> for <code>OrgUnitReferenceWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Name of the organizational unit.", example="Pronto") 	
	private String name;
	
	public OrgUnitReferenceWsDTO()
	{
		// default constructor
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
	

}