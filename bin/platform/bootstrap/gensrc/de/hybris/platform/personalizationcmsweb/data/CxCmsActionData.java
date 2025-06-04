/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationcmsweb.data;

import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Action details
 */
@Schema(name="action", description="Action details")
public  class CxCmsActionData extends ActionData 

{



	/** ID of the component<br/><br/><i>Generated property</i> for <code>CxCmsActionData.componentId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="componentId", description="ID of the component") 	
	private String componentId;

	/** Identifier of the component's catalog<br/><br/><i>Generated property</i> for <code>CxCmsActionData.componentCatalog</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="componentCatalog", description="Identifier of the component's catalog") 	
	private String componentCatalog;

	/** ID of the component's container<br/><br/><i>Generated property</i> for <code>CxCmsActionData.containerId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="containerId", description="ID of the component's container") 	
	private String containerId;
	
	public CxCmsActionData()
	{
		// default constructor
	}
	
	public void setComponentId(final String componentId)
	{
		this.componentId = componentId;
	}

	public String getComponentId() 
	{
		return componentId;
	}
	
	public void setComponentCatalog(final String componentCatalog)
	{
		this.componentCatalog = componentCatalog;
	}

	public String getComponentCatalog() 
	{
		return componentCatalog;
	}
	
	public void setContainerId(final String containerId)
	{
		this.containerId = containerId;
	}

	public String getContainerId() 
	{
		return containerId;
	}
	

}