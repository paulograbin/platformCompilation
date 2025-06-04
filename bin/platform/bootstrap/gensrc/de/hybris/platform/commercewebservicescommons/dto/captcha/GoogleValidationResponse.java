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
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of captcha configuration for a base store
 *
 * @deprecated only used in GoogleRecaptchaV2ValidationStrategy and it has been deprecated
 */
@Deprecated(since = "2211", forRemoval = true)
public  class GoogleValidationResponse  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>GoogleValidationResponse.success</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private Boolean success;

	/** <i>Generated property</i> for <code>GoogleValidationResponse.challengeTime</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private Date challengeTime;

	/** <i>Generated property</i> for <code>GoogleValidationResponse.hostName</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private String hostName;

	/** <i>Generated property</i> for <code>GoogleValidationResponse.errorCodes</code> property defined at extension <code>commercewebservicescommons</code>. */
	
	private List<String> errorCodes;
	
	public GoogleValidationResponse()
	{
		// default constructor
	}
	
	public void setSuccess(final Boolean success)
	{
		this.success = success;
	}

	public Boolean getSuccess() 
	{
		return success;
	}
	
	public void setChallengeTime(final Date challengeTime)
	{
		this.challengeTime = challengeTime;
	}

	public Date getChallengeTime() 
	{
		return challengeTime;
	}
	
	public void setHostName(final String hostName)
	{
		this.hostName = hostName;
	}

	public String getHostName() 
	{
		return hostName;
	}
	
	public void setErrorCodes(final List<String> errorCodes)
	{
		this.errorCodes = errorCodes;
	}

	public List<String> getErrorCodes() 
	{
		return errorCodes;
	}
	

}