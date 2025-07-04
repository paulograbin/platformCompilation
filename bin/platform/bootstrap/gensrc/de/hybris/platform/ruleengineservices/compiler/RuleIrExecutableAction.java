/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ruleengineservices.compiler;

import de.hybris.platform.ruleengineservices.compiler.RuleIrAction;
import java.util.Map;


import java.util.Objects;
public  class RuleIrExecutableAction extends RuleIrAction 

{



	/** <i>Generated property</i> for <code>RuleIrExecutableAction.actionId</code> property defined at extension <code>ruleengineservices</code>. */
	
	private String actionId;

	/** <i>Generated property</i> for <code>RuleIrExecutableAction.actionParameters</code> property defined at extension <code>ruleengineservices</code>. */
	
	private Map<String,Object> actionParameters;
	
	public RuleIrExecutableAction()
	{
		// default constructor
	}
	
	public void setActionId(final String actionId)
	{
		this.actionId = actionId;
	}

	public String getActionId() 
	{
		return actionId;
	}
	
	public void setActionParameters(final Map<String,Object> actionParameters)
	{
		this.actionParameters = actionParameters;
	}

	public Map<String,Object> getActionParameters() 
	{
		return actionParameters;
	}
	

}