/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Specifies properties of the CMS version.
 */
@Schema(name="CMSVersionWsDTO", description="Specifies properties of the CMS version.")
public  class CMSVersionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.uid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uid", example="00000000") 	
	private String uid;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.itemUUID</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemUUID") 	
	private String itemUUID;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.label</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="label", example="2.0") 	
	private String label;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="description") 	
	private String description;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.creationtime</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="creationtime", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationtime;
	
	public CMSVersionWsDTO()
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
	
	public void setItemUUID(final String itemUUID)
	{
		this.itemUUID = itemUUID;
	}

	public String getItemUUID() 
	{
		return itemUUID;
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setCreationtime(final Date creationtime)
	{
		this.creationtime = creationtime;
	}

	public Date getCreationtime() 
	{
		return creationtime;
	}
	

}