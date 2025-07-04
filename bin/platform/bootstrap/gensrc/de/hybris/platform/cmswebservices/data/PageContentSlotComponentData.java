/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the page content slot component.
 */
@Schema(name="PageContentSlotComponentData", description="Specifies properties of the page content slot component.")
public  class PageContentSlotComponentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.pageId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageId", example="homepage") 	
	private String pageId;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.componentId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="componentId", example="AbstractCMSComponent") 	
	private String componentId;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.componentUuid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="componentUuid") 	
	private String componentUuid;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.slotId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="slotId", example="Section1Slot-Homepage") 	
	private String slotId;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.position</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="position", example="1") 	
	private Integer position;
	
	public PageContentSlotComponentData()
	{
		// default constructor
	}
	
	public void setPageId(final String pageId)
	{
		this.pageId = pageId;
	}

	public String getPageId() 
	{
		return pageId;
	}
	
	public void setComponentId(final String componentId)
	{
		this.componentId = componentId;
	}

	public String getComponentId() 
	{
		return componentId;
	}
	
	public void setComponentUuid(final String componentUuid)
	{
		this.componentUuid = componentUuid;
	}

	public String getComponentUuid() 
	{
		return componentUuid;
	}
	
	public void setSlotId(final String slotId)
	{
		this.slotId = slotId;
	}

	public String getSlotId() 
	{
		return slotId;
	}
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

	public Integer getPosition() 
	{
		return position;
	}
	

}