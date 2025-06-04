/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.captcha;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Configuration information of captcha
 */
@Schema(name="CaptchaConfig", description="Configuration information of captcha")
public  class CaptchaConfigWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Indicates if the captcha is enabled or not<br/><br/><i>Generated property</i> for <code>CaptchaConfigWsDTO.enabled</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="enabled", description="Indicates if the captcha is enabled or not", required=false, example="true") 	
	private boolean enabled;

	/** The public key used in captcha validation<br/><br/><i>Generated property</i> for <code>CaptchaConfigWsDTO.publicKey</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="publicKey", description="The public key used in captcha validation", required=false, example="6LdeF6tgAAAAAE_T55TB0nmg--qmbnkwqC4LPQbg") 	
	private String publicKey;
	
	public CaptchaConfigWsDTO()
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