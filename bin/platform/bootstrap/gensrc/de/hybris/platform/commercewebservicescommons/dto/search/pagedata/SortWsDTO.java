/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.pagedata;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation a Sort option
 *
 * @deprecated Use de.hybris.platform.webservicescommons.dto.SortWsDTO instead
 */
@Schema(name="Sort", description="Representation a Sort option")
@Deprecated(since = "6.5", forRemoval = true)
public  class SortWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of Sort<br/><br/><i>Generated property</i> for <code>SortWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of Sort") 	
	private String code;

	/** Name of Sort<br/><br/><i>Generated property</i> for <code>SortWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of Sort") 	
	private String name;

	/** Flag stating when Sort is selected<br/><br/><i>Generated property</i> for <code>SortWsDTO.selected</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="selected", description="Flag stating when Sort is selected") 	
	private Boolean selected;
	
	public SortWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setSelected(final Boolean selected)
	{
		this.selected = selected;
	}

	public Boolean getSelected() 
	{
		return selected;
	}
	

}