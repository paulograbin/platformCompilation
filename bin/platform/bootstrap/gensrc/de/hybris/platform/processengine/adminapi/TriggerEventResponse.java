/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.processengine.adminapi;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Response to triggered business process event
 */
@Schema(name="TriggerEventResponse", description="Response to triggered business process event")
public  class TriggerEventResponse  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Response message<br/><br/><i>Generated property</i> for <code>TriggerEventResponse.message</code> property defined at extension <code>processing</code>. */
@Schema(name="message", description="Response message") 	
	private String message;
	
	public TriggerEventResponse()
	{
		// default constructor
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	

}