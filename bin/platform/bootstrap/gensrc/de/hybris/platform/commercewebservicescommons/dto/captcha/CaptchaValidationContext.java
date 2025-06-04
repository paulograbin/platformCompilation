/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.captcha;

import java.io.Serializable;


import java.util.Objects;
/**
 * Representation of captcha configuration for a base store
 */
public  class CaptchaValidationContext  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CaptchaValidationContext.captchaToken</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String captchaToken;

	/** <i>Generated property</i> for <code>CaptchaValidationContext.remoteIp</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String remoteIp;

	/** <i>Generated property</i> for <code>CaptchaValidationContext.baseSiteId</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String baseSiteId;

	/** <i>Generated property</i> for <code>CaptchaValidationContext.baseStoreId</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String baseStoreId;

	/** <i>Generated property</i> for <code>CaptchaValidationContext.referer</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String referer;

	/** <i>Generated property</i> for <code>CaptchaValidationContext.captchaCheckEnabled</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private boolean captchaCheckEnabled;
	
	public CaptchaValidationContext()
	{
		// default constructor
	}
	
	public void setCaptchaToken(final String captchaToken)
	{
		this.captchaToken = captchaToken;
	}

	public String getCaptchaToken() 
	{
		return captchaToken;
	}
	
	public void setRemoteIp(final String remoteIp)
	{
		this.remoteIp = remoteIp;
	}

	public String getRemoteIp() 
	{
		return remoteIp;
	}
	
	public void setBaseSiteId(final String baseSiteId)
	{
		this.baseSiteId = baseSiteId;
	}

	public String getBaseSiteId() 
	{
		return baseSiteId;
	}
	
	public void setBaseStoreId(final String baseStoreId)
	{
		this.baseStoreId = baseStoreId;
	}

	public String getBaseStoreId() 
	{
		return baseStoreId;
	}
	
	public void setReferer(final String referer)
	{
		this.referer = referer;
	}

	public String getReferer() 
	{
		return referer;
	}
	
	public void setCaptchaCheckEnabled(final boolean captchaCheckEnabled)
	{
		this.captchaCheckEnabled = captchaCheckEnabled;
	}

	public boolean isCaptchaCheckEnabled() 
	{
		return captchaCheckEnabled;
	}
	

}