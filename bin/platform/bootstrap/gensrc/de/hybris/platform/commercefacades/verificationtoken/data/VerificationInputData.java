/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.verificationtoken.data;

import java.io.Serializable;


import java.util.Objects;
public  class VerificationInputData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>VerificationInputData.loginId</code> property defined at extension <code>commercefacades</code>. */
	
	private String loginId;

	/** <i>Generated property</i> for <code>VerificationInputData.verificationTokenId</code> property defined at extension <code>commercefacades</code>. */
	
	private String verificationTokenId;

	/** <i>Generated property</i> for <code>VerificationInputData.verificationTokenCode</code> property defined at extension <code>commercefacades</code>. */
	
	private String verificationTokenCode;
	
	public VerificationInputData()
	{
		// default constructor
	}
	
	public void setLoginId(final String loginId)
	{
		this.loginId = loginId;
	}

	public String getLoginId() 
	{
		return loginId;
	}
	
	public void setVerificationTokenId(final String verificationTokenId)
	{
		this.verificationTokenId = verificationTokenId;
	}

	public String getVerificationTokenId() 
	{
		return verificationTokenId;
	}
	
	public void setVerificationTokenCode(final String verificationTokenCode)
	{
		this.verificationTokenCode = verificationTokenCode;
	}

	public String getVerificationTokenCode() 
	{
		return verificationTokenCode;
	}
	

}