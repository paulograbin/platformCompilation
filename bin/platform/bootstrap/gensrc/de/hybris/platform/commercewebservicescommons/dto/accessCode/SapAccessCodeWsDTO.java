/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.accessCode;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="SAPAccessCode")
public  class SapAccessCodeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Representation of an SAP access code<br/><br/><i>Generated property</i> for <code>SapAccessCodeWsDTO.accessCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="accessCode", description="Representation of an SAP access code", required=true, example="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQ") 	
	private String accessCode;
	
	public SapAccessCodeWsDTO()
	{
		// default constructor
	}
	
	public void setAccessCode(final String accessCode)
	{
		this.accessCode = accessCode;
	}

	public String getAccessCode() 
	{
		return accessCode;
	}
	

}