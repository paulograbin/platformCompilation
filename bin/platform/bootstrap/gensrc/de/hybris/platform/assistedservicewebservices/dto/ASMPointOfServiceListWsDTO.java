/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.ASMPointOfServiceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Point of Service List
 */
@Schema(name="ASMPointOfServiceList", description="Representation of a Point of Service List")
public  class ASMPointOfServiceListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of points of service<br/><br/><i>Generated property</i> for <code>ASMPointOfServiceListWsDTO.pointOfServices</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="pointOfServices", description="List of points of service") 	
	private List<ASMPointOfServiceWsDTO> pointOfServices;
	
	public ASMPointOfServiceListWsDTO()
	{
		// default constructor
	}
	
	public void setPointOfServices(final List<ASMPointOfServiceWsDTO> pointOfServices)
	{
		this.pointOfServices = pointOfServices;
	}

	public List<ASMPointOfServiceWsDTO> getPointOfServices() 
	{
		return pointOfServices;
	}
	

}