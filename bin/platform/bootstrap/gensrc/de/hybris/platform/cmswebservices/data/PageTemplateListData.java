/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.PageTemplateData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available page templates.
 */
@Schema(name="PageTemplateListData", description="Specifies a list of available page templates.")
public  class PageTemplateListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTemplateListData.templates</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="templates") 	
	private List<PageTemplateData> templates;
	
	public PageTemplateListData()
	{
		// default constructor
	}
	
	public void setTemplates(final List<PageTemplateData> templates)
	{
		this.templates = templates;
	}

	public List<PageTemplateData> getTemplates() 
	{
		return templates;
	}
	

}