/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * @deprecated no longer needed
 */
@Schema(name="ContentPageWsDTO")
@Deprecated(since = "1811", forRemoval = true)
public  class ContentPageWsDTO extends AbstractPageWsDTO 

{



	/** <i>Generated property</i> for <code>ContentPageWsDTO.label</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="label") 	
	private String label;

	/** <i>Generated property</i> for <code>ContentPageWsDTO.path</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="path") 	
	private String path;
	
	public ContentPageWsDTO()
	{
		// default constructor
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	
	public void setPath(final String path)
	{
		this.path = path;
	}

	public String getPath() 
	{
		return path;
	}
	

}