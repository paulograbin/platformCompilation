/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of triggers
 */
@Schema(name="TriggerList", description="List of triggers")
public  class TriggerListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of customer triggers<br/><br/><i>Generated property</i> for <code>TriggerListWsDTO.triggers</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="triggers", description="List of customer triggers") 	
	private List<TriggerData> triggers;
	
	public TriggerListWsDTO()
	{
		// default constructor
	}
	
	public void setTriggers(final List<TriggerData> triggers)
	{
		this.triggers = triggers;
	}

	public List<TriggerData> getTriggers() 
	{
		return triggers;
	}
	

}