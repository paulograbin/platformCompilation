/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Textual representation of a conflict.
 */
@Schema(name="CCPConflict", description="Textual representation of a conflict.")
public  class ConflictWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Language-dependent conflict text.<br/><br/><i>Generated property</i> for <code>ConflictWsDTO.text</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="text", description="Language-dependent conflict text.", example="It is not possible to select the extra audio package and the docking station T20 in parallel. Review your selections.") 	
	private String text;
	
	public ConflictWsDTO()
	{
		// default constructor
	}
	
	public void setText(final String text)
	{
		this.text = text;
	}

	public String getText() 
	{
		return text;
	}
	

}