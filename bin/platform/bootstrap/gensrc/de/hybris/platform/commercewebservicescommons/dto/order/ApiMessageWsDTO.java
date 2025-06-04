/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * 
            Representation of supplementary info, warning messages, even when the business APIs successfully execute their operations.
        
 */
@Schema(name="ApiMessage", description="Representation of supplementary info, warning messages, even when the business APIs successfully execute their operations.")
public  class ApiMessageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type of message, e.g. info, warning<br/><br/><i>Generated property</i> for <code>ApiMessageWsDTO.kind</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="kind", description="Type of message, e.g. info, warning") 	
	private String kind;

	/** A unique identifier for the message<br/><br/><i>Generated property</i> for <code>ApiMessageWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="A unique identifier for the message") 	
	private String code;

	/** A human-readable description of the message<br/><br/><i>Generated property</i> for <code>ApiMessageWsDTO.message</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="message", description="A human-readable description of the message") 	
	private String message;

	/** Reference(s) to the specific part(s) of the cart that the message pertains to<br/><br/><i>Generated property</i> for <code>ApiMessageWsDTO.target</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="target", description="Reference(s) to the specific part(s) of the cart that the message pertains to") 	
	private String target;
	
	public ApiMessageWsDTO()
	{
		// default constructor
	}
	
	public void setKind(final String kind)
	{
		this.kind = kind;
	}

	public String getKind() 
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