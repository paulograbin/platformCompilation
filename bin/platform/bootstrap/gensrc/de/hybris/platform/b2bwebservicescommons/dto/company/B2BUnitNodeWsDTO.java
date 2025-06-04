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
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitNodeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an organizational unit node
 */
@Schema(name="B2BUnitNode", description="Representation of an organizational unit node")
public  class B2BUnitNodeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Identifier of the organizational unit represented by the node<br/><br/><i>Generated property</i> for <code>B2BUnitNodeWsDTO.id</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="id", description="Identifier of the organizational unit represented by the node", required=true, example="Pronto_Retail") 	
	private String id;

	/** Name of the organizational unit represented by the node<br/><br/><i>Generated property</i> for <code>B2BUnitNodeWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Name of the organizational unit represented by the node", example="Pronto Retail") 	
	private String name;

	/** Unique identifier of organizational unit node's parent unit<br/><br/><i>Generated property</i> for <code>B2BUnitNodeWsDTO.parent</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="parent", description="Unique identifier of organizational unit node's parent unit", example="Pronto") 	
	private String parent;

	/** Boolean flag of whether organizational unit represented by the node is active<br/><br/><i>Generated property</i> for <code>B2BUnitNodeWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="active", description="Boolean flag of whether organizational unit represented by the node is active", example="true") 	
	private Boolean active;

	/** Child nodes of the organizational unit node<br/><br/><i>Generated property</i> for <code>B2BUnitNodeWsDTO.children</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="children", description="Child nodes of the organizational unit node") 	
	private List<B2BUnitNodeWsDTO> children;
	
	public B2BUnitNodeWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setParent(final String parent)
	{
		this.parent = parent;
	}

	public String getParent() 
	{
		return parent;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setChildren(final List<B2BUnitNodeWsDTO> children)
	{
		this.children = children;
	}

	public List<B2BUnitNodeWsDTO> getChildren() 
	{
		return children;
	}
	

}