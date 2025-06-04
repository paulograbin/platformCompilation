/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of actions
 */
@Schema(name="ActionList", description="List of actions")
public  class ActionListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of actions<br/><br/><i>Generated property</i> for <code>ActionListWsDTO.actions</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="actions", description="List of actions") 	
	private List<ActionData> actions;
	
	public ActionListWsDTO()
	{
		// default constructor
	}
	
	public void setActions(final List<ActionData> actions)
	{
		this.actions = actions;
	}

	public List<ActionData> getActions() 
	{
		return actions;
	}
	

}