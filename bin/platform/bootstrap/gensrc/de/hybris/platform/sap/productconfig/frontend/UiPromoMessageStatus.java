/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:26 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.frontend;

import java.io.Serializable;


import java.util.Objects;
public  class UiPromoMessageStatus  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UiPromoMessageStatus.id</code> property defined at extension <code>ysapproductconfigaddon</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>UiPromoMessageStatus.showExtendedMessage</code> property defined at extension <code>ysapproductconfigaddon</code>. */
	
	private boolean showExtendedMessage;
	
	public UiPromoMessageStatus()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setShowExtendedMessage(final boolean showExtendedMessage)
	{
		this.showExtendedMessage = showExtendedMessage;
	}

	public boolean isShowExtendedMessage() 
	{
		return showExtendedMessage;
	}
	

}