/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the optional data.
 */
@Schema(name="OptionData", description="Specifies properties of the optional data.")
public  class OptionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OptionData.id</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="id", example="VARIATION") 	
	private String id;

	/** <i>Generated property</i> for <code>OptionData.label</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="label", example="page.displaycondition.variation") 	
	private String label;
	
	public OptionData()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	

}