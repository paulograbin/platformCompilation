/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationpromotionsweb.data;

import java.io.Serializable;
import de.hybris.platform.personalizationpromotionsweb.data.PromotionRuleWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of promotion rules
 */
@Schema(name="segmentList", description="List of promotion rules")
public  class PromotionRuleListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of promotion rules<br/><br/><i>Generated property</i> for <code>PromotionRuleListWsDTO.promotions</code> property defined at extension <code>personalizationpromotionsweb</code>. */
@Schema(name="promotions", description="List of promotion rules") 	
	private List<PromotionRuleWsDTO> promotions;
	
	public PromotionRuleListWsDTO()
	{
		// default constructor
	}
	
	public void setPromotions(final List<PromotionRuleWsDTO> promotions)
	{
		this.promotions = promotions;
	}

	public List<PromotionRuleWsDTO> getPromotions() 
	{
		return promotions;
	}
	

}