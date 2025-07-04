/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import java.util.List;


import java.util.Objects;
public  class CCPaymentInfoDatas  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CCPaymentInfoDatas.paymentInfos</code> property defined at extension <code>commercefacades</code>. */
	
	private List<CCPaymentInfoData> paymentInfos;
	
	public CCPaymentInfoDatas()
	{
		// default constructor
	}
	
	public void setPaymentInfos(final List<CCPaymentInfoData> paymentInfos)
	{
		this.paymentInfos = paymentInfos;
	}

	public List<CCPaymentInfoData> getPaymentInfos() 
	{
		return paymentInfos;
	}
	

}