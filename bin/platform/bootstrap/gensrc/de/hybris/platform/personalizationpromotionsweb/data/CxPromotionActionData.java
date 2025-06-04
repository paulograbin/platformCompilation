/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationpromotionsweb.data;

import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * CxPromotionAction details
 */
@Schema(name="cxPromotionAction", description="CxPromotionAction details")
public  class CxPromotionActionData extends ActionData 

{



	/** ID of the promotion<br/><br/><i>Generated property</i> for <code>CxPromotionActionData.promotionId</code> property defined at extension <code>personalizationpromotionsweb</code>. */
@Schema(name="promotionId", description="ID of the promotion") 	
	private String promotionId;
	
	public CxPromotionActionData()
	{
		// default constructor
	}
	
	public void setPromotionId(final String promotionId)
	{
		this.promotionId = promotionId;
	}

	public String getPromotionId() 
	{
		return promotionId;
	}
	

}