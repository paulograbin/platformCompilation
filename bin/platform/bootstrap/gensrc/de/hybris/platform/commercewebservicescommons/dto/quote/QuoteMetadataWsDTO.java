/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of quote metadata.
 */
@Schema(name="QuoteMetadata", description="Representation of quote metadata.")
public  class QuoteMetadataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Name of the quote.<br/><br/><i>Generated property</i> for <code>QuoteMetadataWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Name of the quote.", required=true, example="Quote Name") 	
	private String name;

	/** Description of the quote.<br/><br/><i>Generated property</i> for <code>QuoteMetadataWsDTO.description</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="description", description="Description of the quote.", required=false, example="Quote Description") 	
	private String description;

	/** Expiration time of the quote.<br/><br/><i>Generated property</i> for <code>QuoteMetadataWsDTO.expirationTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="expirationTime", description="Expiration time of the quote.", required=true, example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date expirationTime;
	
	public QuoteMetadataWsDTO()
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
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	

}