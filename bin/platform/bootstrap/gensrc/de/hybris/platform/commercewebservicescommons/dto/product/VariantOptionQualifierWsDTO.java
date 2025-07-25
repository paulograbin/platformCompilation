/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ImageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Variant Option Qualifier
 */
@Schema(name="VariantOptionQualifier", description="Representation of a Variant Option Qualifier")
public  class VariantOptionQualifierWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Qualifier<br/><br/><i>Generated property</i> for <code>VariantOptionQualifierWsDTO.qualifier</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="qualifier", description="Qualifier") 	
	private String qualifier;

	/** Name of variant option qualifier<br/><br/><i>Generated property</i> for <code>VariantOptionQualifierWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of variant option qualifier") 	
	private String name;

	/** Value of variant option qualifier<br/><br/><i>Generated property</i> for <code>VariantOptionQualifierWsDTO.value</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="value", description="Value of variant option qualifier") 	
	private String value;

	/** Image associated with variant option qualifier<br/><br/><i>Generated property</i> for <code>VariantOptionQualifierWsDTO.image</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="image", description="Image associated with variant option qualifier") 	
	private ImageWsDTO image;
	
	public VariantOptionQualifierWsDTO()
	{
		// default constructor
	}
	
	public void setQualifier(final String qualifier)
	{
		this.qualifier = qualifier;
	}

	public String getQualifier() 
	{
		return qualifier;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setImage(final ImageWsDTO image)
	{
		this.image = image;
	}

	public ImageWsDTO getImage() 
	{
		return image;
	}
	

}