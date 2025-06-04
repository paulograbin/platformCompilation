/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available uuid for CMS item.
 */
@Schema(name="CMSItemUuidListWsDTO", description="Specifies a list of available uuid for CMS item.")
public  class CMSItemUuidListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemUuidListWsDTO.uuids</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uuids") 	
	private List<String> uuids;

	/** <i>Generated property</i> for <code>CMSItemUuidListWsDTO.fields</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="fields") 	
	private String fields;
	
	public CMSItemUuidListWsDTO()
	{
		// default constructor
	}
	
	public void setUuids(final List<String> uuids)
	{
		this.uuids = uuids;
	}

	public List<String> getUuids() 
	{
		return uuids;
	}
	
	public void setFields(final String fields)
	{
		this.fields = fields;
	}

	public String getFields() 
	{
		return fields;
	}
	

}