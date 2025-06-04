/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.ExpressionData;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Negation expression
 */
@Schema(name="negationExpression", description="Negation expression")
public  class NegationExpressionData extends ExpressionData 

{



	/** Expression to negate<br/><br/><i>Generated property</i> for <code>NegationExpressionData.element</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="element", description="Expression to negate") 	
	private ExpressionData element;
	
	public NegationExpressionData()
	{
		// default constructor
	}
	
	public void setElement(final ExpressionData element)
	{
		this.element = element;
	}

	public ExpressionData getElement() 
	{
		return element;
	}
	

}