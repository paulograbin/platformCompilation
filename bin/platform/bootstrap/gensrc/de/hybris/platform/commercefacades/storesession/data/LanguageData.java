/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.storesession.data;

import java.io.Serializable;


import java.util.Objects;
public  class LanguageData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>LanguageData.isocode</code> property defined at extension <code>commercefacades</code>. */
	
	private String isocode;

	/** <i>Generated property</i> for <code>LanguageData.name</code> property defined at extension <code>commercefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>LanguageData.nativeName</code> property defined at extension <code>commercefacades</code>. */
	
	private String nativeName;

	/** <i>Generated property</i> for <code>LanguageData.active</code> property defined at extension <code>commercefacades</code>. */
	
	private boolean active;

	/** <i>Generated property</i> for <code>LanguageData.required</code> property defined at extension <code>cmsfacades</code>. */
	
	private boolean required;
	
	public LanguageData()
	{
		// default constructor
	}
	
	public void setIsocode(final String isocode)
	{
		this.isocode = isocode;
	}

	public String getIsocode() 
	{
		return isocode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setNativeName(final String nativeName)
	{
		this.nativeName = nativeName;
	}

	public String getNativeName() 
	{
		return nativeName;
	}
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

	public boolean isActive() 
	{
		return active;
	}
	
	public void setRequired(final boolean required)
	{
		this.required = required;
	}

	public boolean isRequired() 
	{
		return required;
	}
	

}