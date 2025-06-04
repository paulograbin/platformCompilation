/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.C360ActivityStatusWsDTO;
import de.hybris.platform.assistedservicewebservices.dto.C360ActivityTypeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of an activity
 */
@Schema(name="C360Activity", description="Representation of an activity")
public  class C360ActivityWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>C360ActivityWsDTO.type</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="type") 	
	private C360ActivityTypeWsDTO type;

	/** Id of the associated activity<br/><br/><i>Generated property</i> for <code>C360ActivityWsDTO.associatedTypeId</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="associatedTypeId", description="Id of the associated activity", required=true, example="00000001") 	
	private String associatedTypeId;

	/** Description of the activity<br/><br/><i>Generated property</i> for <code>C360ActivityWsDTO.description</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="description", description="Description of the activity", example="Order items: 1/ Total Amount: $19.99") 	
	private String description;

	/** <i>Generated property</i> for <code>C360ActivityWsDTO.status</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="status") 	
	private C360ActivityStatusWsDTO status;

	/** Date of activity creation<br/><br/><i>Generated property</i> for <code>C360ActivityWsDTO.createdAt</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="createdAt", description="Date of activity creation", example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date createdAt;

	/** Date of activity update<br/><br/><i>Generated property</i> for <code>C360ActivityWsDTO.updatedAt</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="updatedAt", description="Date of activity update", example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date updatedAt;
	
	public C360ActivityWsDTO()
	{
		// default constructor
	}
	
	public void setType(final C360ActivityTypeWsDTO type)
	{
		this.type = type;
	}

	public C360ActivityTypeWsDTO getType() 
	{
		return type;
	}
	
	public void setAssociatedTypeId(final String associatedTypeId)
	{
		this.associatedTypeId = associatedTypeId;
	}

	public String getAssociatedTypeId() 
	{
		return associatedTypeId;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setStatus(final C360ActivityStatusWsDTO status)
	{
		this.status = status;
	}

	public C360ActivityStatusWsDTO getStatus() 
	{
		return status;
	}
	
	public void setCreatedAt(final Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}
	
	public void setUpdatedAt(final Date updatedAt)
	{
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt() 
	{
		return updatedAt;
	}
	

}