/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.captcha.data;

import java.io.Serializable;


import java.util.Objects;
public  class CaptchaConfigData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CaptchaConfigData.enabled</code> property defined at extension <code>commercefacades</code>. */
	
	private boolean enabled;

	/** <i>Generated property</i> for <code>CaptchaConfigData.publicKey</code> property defined at extension <code>commercefacades</code>. */
	
	private String publicKey;
	
	public CaptchaConfigData()
	{
		// default constructor
	}
	
	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
	}

	public boolean isEnabled() 
	{
		return enabled;
	}
	
	public void setPublicKey(final String publicKey)
	{
		this.publicKey = publicKey;
	}

	public String getPublicKey() 
	{
		return publicKey;
	}
	

}