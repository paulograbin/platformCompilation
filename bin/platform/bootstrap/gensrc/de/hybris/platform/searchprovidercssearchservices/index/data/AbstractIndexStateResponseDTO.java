/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.index.data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import java.util.Objects;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
			@JsonSubTypes({
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.indexer.data.TaskIndexStateResponseDTO.class, name = "task")
			})
public abstract  class AbstractIndexStateResponseDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;
	
	public AbstractIndexStateResponseDTO()
	{
		// default constructor
	}
	

}