/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.commerceservices.service.data.ApiMessageKind;


import java.util.Objects;
public  class ApiMessageData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ApiMessageData.kind</code> property defined at extension <code>commerceservices</code>. */
	
	private ApiMessageKind kind;

	/** <i>Generated property</i> for <code>ApiMessageData.code</code> property defined at extension <code>commerceservices</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>ApiMessageData.message</code> property defined at extension <code>commerceservices</code>. */
	
	private String message;

	/** <i>Generated property</i> for <code>ApiMessageData.target</code> property defined at extension <code>commerceservices</code>. */
	
	private String target;
	
	public ApiMessageData()
	{
		// default constructor
	}
	
	public void setKind(final ApiMessageKind kind)
	{
		this.kind = kind;
	}

	public ApiMessageKind getKind() 
	{
		return kind;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setTarget(final String target)
	{
		this.target = target;
	}

	public String getTarget() 
	{
		return target;
	}
	

}