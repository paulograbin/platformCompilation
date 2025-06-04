/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.ExpressionData;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Expression trigger
 */
@Schema(name="expressionTrigger", description="Expression trigger")
public  class ExpressionTriggerData extends TriggerData 

{



	/** Details of the expression<br/><br/><i>Generated property</i> for <code>ExpressionTriggerData.expression</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="expression", description="Details of the expression") 	
	private ExpressionData expression;
	
	public ExpressionTriggerData()
	{
		// default constructor
	}
	
	public void setExpression(final ExpressionData expression)
	{
		this.expression = expression;
	}

	public ExpressionData getExpression() 
	{
		return expression;
	}
	

}