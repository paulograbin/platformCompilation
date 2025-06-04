/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionResultWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Promotion result list
 */
@Schema(name="PromotionResultList", description="Representation of a Promotion result list")
public  class PromotionResultListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of promotion results<br/><br/><i>Generated property</i> for <code>PromotionResultListWsDTO.promotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="promotions", description="List of promotion results") 	
	private List<PromotionResultWsDTO> promotions;
	
	public PromotionResultListWsDTO()
	{
		// default constructor
	}
	
	public void setPromotions(final List<PromotionResultWsDTO> promotions)
	{
		this.promotions = promotions;
	}

	public List<PromotionResultWsDTO> getPromotions() 
	{
		return promotions;
	}
	

}