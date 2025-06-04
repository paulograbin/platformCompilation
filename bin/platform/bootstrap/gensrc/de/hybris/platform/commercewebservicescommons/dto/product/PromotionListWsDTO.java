/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Promotion list
 */
@Schema(name="PromotionList", description="Representation of a Promotion list")
public  class PromotionListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of promotions<br/><br/><i>Generated property</i> for <code>PromotionListWsDTO.promotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="promotions", description="List of promotions") 	
	private List<PromotionWsDTO> promotions;
	
	public PromotionListWsDTO()
	{
		// default constructor
	}
	
	public void setPromotions(final List<PromotionWsDTO> promotions)
	{
		this.promotions = promotions;
	}

	public List<PromotionWsDTO> getPromotions() 
	{
		return promotions;
	}
	

}