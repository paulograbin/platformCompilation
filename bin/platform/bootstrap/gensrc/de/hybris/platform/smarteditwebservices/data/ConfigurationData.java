/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Configuration data
 */
@Schema(name="configurationData", description="Configuration data")
public  class ConfigurationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The configuration data key<br/><br/><i>Generated property</i> for <code>ConfigurationData.key</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="key", description="The configuration data key", required=true, example="defaultToolingLanguage") 	
	private String key;

	/** The configuration data value<br/><br/><i>Generated property</i> for <code>ConfigurationData.value</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="value", description="The configuration data value", required=true, example="en") 	
	private String value;
	
	public ConfigurationData()
	{
		// default constructor
	}
	
	public void setKey(final String key)
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	

}