/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Theme
 */
@Schema(name="Theme", description="Theme")
public  class Theme  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The theme key<br/><br/><i>Generated property</i> for <code>Theme.code</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="code", description="The theme key", required=true, example="sap_fiori_3") 	
	private String code;

	/** The localised theme name<br/><br/><i>Generated property</i> for <code>Theme.name</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="name", description="The localised theme name", example="SAP Fiori Light") 	
	private String name;
	
	public Theme()
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
	

}