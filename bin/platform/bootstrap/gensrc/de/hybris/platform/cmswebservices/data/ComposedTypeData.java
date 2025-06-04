/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the composed type.
 */
@Schema(name="ComposedTypeData", description="Specifies properties of the composed type.")
public  class ComposedTypeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComposedTypeData.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="000000RW") 	
	private String code;

	/** <i>Generated property</i> for <code>ComposedTypeData.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>ComposedTypeData.description</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="description") 	
	private Map<String,String> description;
	
	public ComposedTypeData()
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
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

	public Map<String,String> getName() 
	{
		return name;
	}
	
	public void setDescription(final Map<String,String> description)
	{
		this.description = description;
	}

	public Map<String,String> getDescription() 
	{
		return description;
	}
	

}