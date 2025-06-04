/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Promotion Restriction
 */
@Schema(name="PromotionRestriction", description="Representation of a Promotion Restriction")
public  class PromotionRestrictionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type of the promotion restriction<br/><br/><i>Generated property</i> for <code>PromotionRestrictionWsDTO.restrictionType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="restrictionType", description="Type of the promotion restriction") 	
	private String restrictionType;

	/** Description of the promotion restriction<br/><br/><i>Generated property</i> for <code>PromotionRestrictionWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the promotion restriction") 	
	private String description;
	
	public PromotionRestrictionWsDTO()
	{
		// default constructor
	}
	
	public void setRestrictionType(final String restrictionType)
	{
		this.restrictionType = restrictionType;
	}

	public String getRestrictionType() 
	{
		return restrictionType;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	

}