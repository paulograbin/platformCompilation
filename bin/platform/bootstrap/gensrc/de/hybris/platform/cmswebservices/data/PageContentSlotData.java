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
 * Specifies properties of the page content slot.
 */
@Schema(name="PageContentSlotData", description="Specifies properties of the page content slot.")
public  class PageContentSlotData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotData.pageId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageId", example="homepage") 	
	private String pageId;

	/** <i>Generated property</i> for <code>PageContentSlotData.slotId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="slotId", example="Section1Slot-Homepage") 	
	private String slotId;

	/** <i>Generated property</i> for <code>PageContentSlotData.position</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="position", example="1") 	
	private String position;

	/** <i>Generated property</i> for <code>PageContentSlotData.slotShared</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="slotShared", example="true") 	
	private boolean slotShared;

	/** <i>Generated property</i> for <code>PageContentSlotData.slotStatus</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="slotStatus") 	
	private String slotStatus;
	
	public PageContentSlotData()
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
	
	public void setSlotId(final String slotId)
	{
		this.slotId = slotId;
	}

	public String getSlotId() 
	{
		return slotId;
	}
	
	public void setPosition(final String position)
	{
		this.position = position;
	}

	public String getPosition() 
	{
		return position;
	}
	
	public void setSlotShared(final boolean slotShared)
	{
		this.slotShared = slotShared;
	}

	public boolean isSlotShared() 
	{
		return slotShared;
	}
	
	public void setSlotStatus(final String slotStatus)
	{
		this.slotStatus = slotStatus;
	}

	public String getSlotStatus() 
	{
		return slotStatus;
	}
	

}