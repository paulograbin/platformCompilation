/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.StructureWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * The list of structures for a type code.
 *
 * @deprecated no longer needed
 */
@Schema(name="StructureListWsDTO", description="The list of structures for a type code.")
@Deprecated(since = "1811", forRemoval = true)
public  class StructureListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StructureListWsDTO.structures</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="structures") 	
	private List<StructureWsDTO> structures;
	
	public StructureListWsDTO()
	{
		// default constructor
	}
	
	public void setStructures(final List<StructureWsDTO> structures)
	{
		this.structures = structures;
	}

	public List<StructureWsDTO> getStructures() 
	{
		return structures;
	}
	

}