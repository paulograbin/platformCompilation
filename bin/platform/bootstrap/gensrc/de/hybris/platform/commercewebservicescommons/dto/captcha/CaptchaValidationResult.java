/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.captcha;

import java.io.Serializable;


import java.util.Objects;
/**
 * Representation of captcha validation result
 */
public  class CaptchaValidationResult  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CaptchaValidationResult.success</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private boolean success;

	/** <i>Generated property</i> for <code>CaptchaValidationResult.reason</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String reason;
	
	public CaptchaValidationResult()
	{
		// default constructor
	}
	
	public void setSuccess(final boolean success)
	{
		this.success = success;
	}

	public boolean isSuccess() 
	{
		return success;
	}
	
	public void setReason(final String reason)
	{
		this.reason = reason;
	}

	public String getReason() 
	{
		return reason;
	}
	

}