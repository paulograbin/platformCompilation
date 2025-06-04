/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.ExpressionData;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Segment expression
 */
@Schema(name="segmentExpression", description="Segment expression")
public  class SegmentExpressionData extends ExpressionData 

{



	/** Segment code<br/><br/><i>Generated property</i> for <code>SegmentExpressionData.code</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="code", description="Segment code") 	
	private String code;
	
	public SegmentExpressionData()
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
	

}