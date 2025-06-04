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
import java.util.List;


import java.util.Objects;
/**
 * Group expression
 */
@Schema(name="groupExpression", description="Group expression")
public  class GroupExpressionData extends ExpressionData 

{



	/** Expressions building the group expression<br/><br/><i>Generated property</i> for <code>GroupExpressionData.elements</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="elements", description="Expressions building the group expression") 	
	private List<ExpressionData> elements;

	/** Operator joining the expressions<br/><br/><i>Generated property</i> for <code>GroupExpressionData.operator</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="operator", description="Operator joining the expressions", allowableValues="AND,OR") 	
	private String operator;
	
	public GroupExpressionData()
	{
		// default constructor
	}
	
	public void setElements(final List<ExpressionData> elements)
	{
		this.elements = elements;
	}

	public List<ExpressionData> getElements() 
	{
		return elements;
	}
	
	public void setOperator(final String operator)
	{
		this.operator = operator;
	}

	public String getOperator() 
	{
		return operator;
	}
	

}