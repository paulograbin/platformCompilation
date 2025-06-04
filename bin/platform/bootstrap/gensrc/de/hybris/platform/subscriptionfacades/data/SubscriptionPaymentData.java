/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;
import java.util.Map;


import java.util.Objects;
public  class SubscriptionPaymentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SubscriptionPaymentData.parameters</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private Map<String, String> parameters;

	/** <i>Generated property</i> for <code>SubscriptionPaymentData.postUrl</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String postUrl;
	
	public SubscriptionPaymentData()
	{
		// default constructor
	}
	
	public void setParameters(final Map<String, String> parameters)
	{
		this.parameters = parameters;
	}

	public Map<String, String> getParameters() 
	{
		return parameters;
	}
	
	public void setPostUrl(final String postUrl)
	{
		this.postUrl = postUrl;
	}

	public String getPostUrl() 
	{
		return postUrl;
	}
	

}