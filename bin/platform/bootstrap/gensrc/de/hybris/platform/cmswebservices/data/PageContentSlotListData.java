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
import de.hybris.platform.cmswebservices.data.PageContentSlotData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available page content slots.
 */
@Schema(name="PageContentSlotListData", description="Specifies a list of available page content slots.")
public  class PageContentSlotListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotListData.pageContentSlotList</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageContentSlotList") 	
	private List<PageContentSlotData> pageContentSlotList;
	
	public PageContentSlotListData()
	{
		// default constructor
	}
	
	public void setPageContentSlotList(final List<PageContentSlotData> pageContentSlotList)
	{
		this.pageContentSlotList = pageContentSlotList;
	}

	public List<PageContentSlotData> getPageContentSlotList() 
	{
		return pageContentSlotList;
	}
	

}