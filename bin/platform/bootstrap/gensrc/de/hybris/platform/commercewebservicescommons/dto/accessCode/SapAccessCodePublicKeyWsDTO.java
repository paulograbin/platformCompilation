/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.accessCode;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="SAPAccessCodePublicKey")
public  class SapAccessCodePublicKeyWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The public key to decrypt an SAP access code<br/><br/><i>Generated property</i> for <code>SapAccessCodePublicKeyWsDTO.publicKey</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="publicKey", description="The public key to decrypt an SAP access code", required=true, example="eyAiY2FydElkIjogIjAwMDAzMDAyIiwgImNyZWF0aW9") 	
	private String publicKey;
	
	public SapAccessCodePublicKeyWsDTO()
	{
		// default constructor
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