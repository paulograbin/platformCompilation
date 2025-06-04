/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the page email.
 *
 * @deprecated no longer needed
 */
@Schema(name="EmailPageData", description="Specifies properties of the page email.")
@Deprecated(since = "6.6", forRemoval = true)
public  class EmailPageData extends AbstractPageData 

{



	/** <i>Generated property</i> for <code>EmailPageData.fromEmail</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="fromEmail") 	
	private Map<String,String> fromEmail;

	/** <i>Generated property</i> for <code>EmailPageData.fromName</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="fromName") 	
	private Map<String,String> fromName;
	
	public EmailPageData()
	{
		// default constructor
	}
	
	public void setFromEmail(final Map<String,String> fromEmail)
	{
		this.fromEmail = fromEmail;
	}

	public Map<String,String> getFromEmail() 
	{
		return fromEmail;
	}
	
	public void setFromName(final Map<String,String> fromName)
	{
		this.fromName = fromName;
	}

	public Map<String,String> getFromName() 
	{
		return fromName;
	}
	

}