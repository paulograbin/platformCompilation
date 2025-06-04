/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of information of a saved cart
 */
@Schema(name="SAPSavedCartRequest", description="Representation of information of a saved cart")
public  class SAPSavedCartRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Name of the saved cart.<br/><br/><i>Generated property</i> for <code>SAPSavedCartRequestWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the saved cart.", example="First cart") 	
	private String name;

	/** Description of the saved cart.<br/><br/><i>Generated property</i> for <code>SAPSavedCartRequestWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the saved cart.", example="This is my first saved cart") 	
	private String description;
	
	public SAPSavedCartRequestWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	

}