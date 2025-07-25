/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ruleengineservices.compiler;

import java.io.Serializable;
import de.hybris.platform.ruleengineservices.compiler.RuleIrVariable;
import de.hybris.platform.ruleengineservices.compiler.RuleIrVariablesContainer;
import java.util.Map;


import java.util.Objects;
public  class RuleIrVariablesContainer  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RuleIrVariablesContainer.name</code> property defined at extension <code>ruleengineservices</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>RuleIrVariablesContainer.parent</code> property defined at extension <code>ruleengineservices</code>. */
	
	private RuleIrVariablesContainer parent;

	/** <i>Generated property</i> for <code>RuleIrVariablesContainer.children</code> property defined at extension <code>ruleengineservices</code>. */
	
	private Map<String,RuleIrVariablesContainer> children;

	/** <i>Generated property</i> for <code>RuleIrVariablesContainer.variables</code> property defined at extension <code>ruleengineservices</code>. */
	
	private Map<String,RuleIrVariable> variables;

	/** <i>Generated property</i> for <code>RuleIrVariablesContainer.path</code> property defined at extension <code>ruleengineservices</code>. */
	
	private String[] path;
	
	public RuleIrVariablesContainer()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setParent(final RuleIrVariablesContainer parent)
	{
		this.parent = parent;
	}

	public RuleIrVariablesContainer getParent() 
	{
		return parent;
	}
	
	public void setChildren(final Map<String,RuleIrVariablesContainer> children)
	{
		this.children = children;
	}

	public Map<String,RuleIrVariablesContainer> getChildren() 
	{
		return children;
	}
	
	public void setVariables(final Map<String,RuleIrVariable> variables)
	{
		this.variables = variables;
	}

	public Map<String,RuleIrVariable> getVariables() 
	{
		return variables;
	}
	
	public void setPath(final String[] path)
	{
		this.path = path;
	}

	public String[] getPath() 
	{
		return path;
	}
	

}