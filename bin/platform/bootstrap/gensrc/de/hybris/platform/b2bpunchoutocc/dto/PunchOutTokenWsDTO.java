/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bpunchoutocc.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="PunchOutToken")
public  class PunchOutTokenWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The access token issued by the authorization server<br/><br/><i>Generated property</i> for <code>PunchOutTokenWsDTO.accessToken</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="accessToken", description="The access token issued by the authorization server", required=true, example="1uEhL4lj58n1zX9R0aICC7-ng2c") 	
	private String accessToken;

	/** The access token type provides the client with the information
                required to successfully utilize the access token to make a protected
                resource request (along with type-specific attributes). The client
                MUST NOT use an access token if it does not understand or does not
                trust the token type.
            <br/><br/><i>Generated property</i> for <code>PunchOutTokenWsDTO.tokenType</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="tokenType", description="The access token type provides the client with the information required to successfully utilize the access token to make a protected resource request (along with type-specific attributes). The client MUST NOT use an access token if it does not understand or does not trust the token type.", required=true, example="bearer") 	
	private String tokenType;
	
	public PunchOutTokenWsDTO()
	{
		// default constructor
	}
	
	public void setAccessToken(final String accessToken)
	{
		this.accessToken = accessToken;
	}

	public String getAccessToken() 
	{
		return accessToken;
	}
	
	public void setTokenType(final String tokenType)
	{
		this.tokenType = tokenType;
	}

	public String getTokenType() 
	{
		return tokenType;
	}
	

}