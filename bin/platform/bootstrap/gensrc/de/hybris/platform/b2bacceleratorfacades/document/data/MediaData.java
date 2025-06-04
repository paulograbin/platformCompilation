/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.document.data;

import java.io.Serializable;


import java.util.Objects;
public  class MediaData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaData.realFileName</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String realFileName;

	/** <i>Generated property</i> for <code>MediaData.downloadURL</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String downloadURL;
	
	public MediaData()
	{
		// default constructor
	}
	
	public void setRealFileName(final String realFileName)
	{
		this.realFileName = realFileName;
	}

	public String getRealFileName() 
	{
		return realFileName;
	}
	
	public void setDownloadURL(final String downloadURL)
	{
		this.downloadURL = downloadURL;
	}

	public String getDownloadURL() 
	{
		return downloadURL;
	}
	

}