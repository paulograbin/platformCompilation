/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.consent;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a Consent
 */
@Schema(name="Consent", description="Representation of a Consent")
public  class ConsentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of consent<br/><br/><i>Generated property</i> for <code>ConsentWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of consent") 	
	private String code;

	/** Date of consenting<br/><br/><i>Generated property</i> for <code>ConsentWsDTO.consentGivenDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="consentGivenDate", description="Date of consenting") 	
	private Date consentGivenDate;

	/** Consent withdrawn date<br/><br/><i>Generated property</i> for <code>ConsentWsDTO.consentWithdrawnDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="consentWithdrawnDate", description="Consent withdrawn date") 	
	private Date consentWithdrawnDate;
	
	public ConsentWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setConsentGivenDate(final Date consentGivenDate)
	{
		this.consentGivenDate = consentGivenDate;
	}

	public Date getConsentGivenDate() 
	{
		return consentGivenDate;
	}
	
	public void setConsentWithdrawnDate(final Date consentWithdrawnDate)
	{
		this.consentWithdrawnDate = consentWithdrawnDate;
	}

	public Date getConsentWithdrawnDate() 
	{
		return consentWithdrawnDate;
	}
	

}