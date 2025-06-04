/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webservicescommons.dto.error;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Error message
 */
@Schema(name="error", description="Error message")
public  class ErrorWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type of the error e.g. 'LowStockError'.<br/><br/><i>Generated property</i> for <code>ErrorWsDTO.type</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="type", description="Type of the error e.g. 'LowStockError'.") 	
	private String type;

	/** Additional classification specific for each error type e.g. 'noStock'.<br/><br/><i>Generated property</i> for <code>ErrorWsDTO.reason</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="reason", description="Additional classification specific for each error type e.g. 'noStock'.") 	
	private String reason;

	/** Descriptive, human readable error message.<br/><br/><i>Generated property</i> for <code>ErrorWsDTO.message</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="message", description="Descriptive, human readable error message.") 	
	private String message;

	/** Type of the object related to the error e.g. 'entry'.<br/><br/><i>Generated property</i> for <code>ErrorWsDTO.subjectType</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="subjectType", description="Type of the object related to the error e.g. 'entry'.") 	
	private String subjectType;

	/** Identifier of the related object e.g. '1'.<br/><br/><i>Generated property</i> for <code>ErrorWsDTO.subject</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="subject", description="Identifier of the related object e.g. '1'.") 	
	private String subject;

	/** Error code<br/><br/><i>Generated property</i> for <code>ErrorWsDTO.errorCode</code> property defined at extension <code>webservicescommons</code>. */
@Schema(name="errorCode", description="Error code") 	
	private String errorCode;

	/** <i>Generated property</i> for <code>ErrorWsDTO.language</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="language", example="English") 	
	private String language;

	/** <i>Generated property</i> for <code>ErrorWsDTO.position</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="position", example="1") 	
	private Integer position;

	/** <i>Generated property</i> for <code>ErrorWsDTO.exceptionMessage</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="exceptionMessage") 	
	private String exceptionMessage;
	
	public ErrorWsDTO()
	{
		// default constructor
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setReason(final String reason)
	{
		this.reason = reason;
	}

	public String getReason() 
	{
		return reason;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public void setSubjectType(final String subjectType)
	{
		this.subjectType = subjectType;
	}

	public String getSubjectType() 
	{
		return subjectType;
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setErrorCode(final String errorCode)
	{
		this.errorCode = errorCode;
	}

	public String getErrorCode() 
	{
		return errorCode;
	}
	
	public void setLanguage(final String language)
	{
		this.language = language;
	}

	public String getLanguage() 
	{
		return language;
	}
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

	public Integer getPosition() 
	{
		return position;
	}
	
	public void setExceptionMessage(final String exceptionMessage)
	{
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() 
	{
		return exceptionMessage;
	}
	

}