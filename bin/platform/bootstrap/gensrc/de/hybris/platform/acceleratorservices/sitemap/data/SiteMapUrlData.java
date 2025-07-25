/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.sitemap.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class SiteMapUrlData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SiteMapUrlData.loc</code> property defined at extension <code>acceleratorservices</code>. */
	
	private String loc;

	/** <i>Generated property</i> for <code>SiteMapUrlData.images</code> property defined at extension <code>acceleratorservices</code>. */
	
	private List<String> images;
	
	public SiteMapUrlData()
	{
		// default constructor
	}
	
	public void setLoc(final String loc)
	{
		this.loc = loc;
	}

	public String getLoc() 
	{
		return loc;
	}
	
	public void setImages(final List<String> images)
	{
		this.images = images;
	}

	public List<String> getImages() 
	{
		return images;
	}
	

}