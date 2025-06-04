/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.verificationtoken;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of information for obtained verification token.
 */
@Schema(name="VerificationToken", description="Representation of information for obtained verification token.")
public  class VerificationTokenWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Unique token ID generated for verification request, which is used for authentication along with the token code.<br/><br/><i>Generated property</i> for <code>VerificationTokenWsDTO.tokenId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="tokenId", description="Unique token ID generated for verification request, which is used for authentication along with the token code.", required=true, example="<LGN[nZbnrnhMWy2uBbzKWU/SQRVBZ7mJaiXX9/87PegvovM=]>") 	
	private String tokenId;

	/** Verification token expiration time in seconds.<br/><br/><i>Generated property</i> for <code>VerificationTokenWsDTO.expiresIn</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="expiresIn", description="Verification token expiration time in seconds.", required=true, example="300") 	
	private Integer expiresIn;
	
	public VerificationTokenWsDTO()
	{
		// default constructor
	}
	
	public void setTokenId(final String tokenId)
	{
		this.tokenId = tokenId;
	}

	public String getTokenId() 
	{
		return tokenId;
	}
	
	public void setExpiresIn(final Integer expiresIn)
	{
		this.expiresIn = expiresIn;
	}

	public Integer getExpiresIn() 
	{
		return expiresIn;
	}
	

}