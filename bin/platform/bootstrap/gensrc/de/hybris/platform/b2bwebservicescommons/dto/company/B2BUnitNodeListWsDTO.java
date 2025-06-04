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
 * Representation of an organizational unit node list
 */
@Schema(name="B2BUnitNodeList", description="Representation of an organizational unit node list")
public  class B2BUnitNodeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Unit Nodes<br/><br/><i>Generated property</i> for <code>B2BUnitNodeListWsDTO.unitNodes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="unitNodes", description="List of Unit Nodes", required=true) 	
	private List<B2BUnitNodeWsDTO> unitNodes;
	
	public B2BUnitNodeListWsDTO()
	{
		// default constructor
	}
	
	public void setUnitNodes(final List<B2BUnitNodeWsDTO> unitNodes)
	{
		this.unitNodes = unitNodes;
	}

	public List<B2BUnitNodeWsDTO> getUnitNodes() 
	{
		return unitNodes;
	}
	

}