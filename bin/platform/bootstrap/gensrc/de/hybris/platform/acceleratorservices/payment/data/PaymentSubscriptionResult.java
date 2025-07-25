/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.payment.data;

import java.io.Serializable;
import  de.hybris.platform.acceleratorservices.payment.data.PaymentErrorField;
import java.util.Map;


import java.util.Objects;
public  class PaymentSubscriptionResult  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PaymentSubscriptionResult.success</code> property defined at extension <code>acceleratorservices</code>. */
	
	private boolean success;

	/** <i>Generated property</i> for <code>PaymentSubscriptionResult.decision</code> property defined at extension <code>acceleratorservices</code>. */
	
	private String decision;

	/** <i>Generated property</i> for <code>PaymentSubscriptionResult.resultCode</code> property defined at extension <code>acceleratorservices</code>. */
	
	private String resultCode;

	/** <i>Generated property</i> for <code>PaymentSubscriptionResult.errors</code> property defined at extension <code>acceleratorservices</code>. */
	
	private Map<String,PaymentErrorField> errors;
	
	public PaymentSubscriptionResult()
	{
		// default constructor
	}
	
	public void setSuccess(final boolean success)
	{
		this.success = success;
	}

	public boolean isSuccess() 
	{
		return success;
	}
	
	public void setDecision(final String decision)
	{
		this.decision = decision;
	}

	public String getDecision() 
	{
		return decision;
	}
	
	public void setResultCode(final String resultCode)
	{
		this.resultCode = resultCode;
	}

	public String getResultCode() 
	{
		return resultCode;
	}
	
	public void setErrors(final Map<String,PaymentErrorField> errors)
	{
		this.errors = errors;
	}

	public Map<String,PaymentErrorField> getErrors() 
	{
		return errors;
	}
	

}