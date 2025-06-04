/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.PageContentSlotComponentData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available page content slot components.
 */
@Schema(name="PageContentSlotComponentListData", description="Specifies a list of available page content slot components.")
public  class PageContentSlotComponentListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotComponentListData.pageContentSlotComponentList</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageContentSlotComponentList") 	
	private List<PageContentSlotComponentData> pageContentSlotComponentList;
	
	public PageContentSlotComponentListData()
	{
		// default constructor
	}
	
	public void setPageContentSlotComponentList(final List<PageContentSlotComponentData> pageContentSlotComponentList)
	{
		this.pageContentSlotComponentList = pageContentSlotComponentList;
	}

	public List<PageContentSlotComponentData> getPageContentSlotComponentList() 
	{
		return pageContentSlotComponentList;
	}
	

}