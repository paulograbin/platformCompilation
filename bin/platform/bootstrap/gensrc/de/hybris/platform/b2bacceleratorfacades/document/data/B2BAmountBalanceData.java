/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.document.data;

import java.io.Serializable;
import  java.lang.String;
import de.hybris.platform.b2bacceleratorfacades.document.data.B2BNumberOfDayRangeData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Account balance details.
 */
@Schema(name="AmountBalance", description="Account balance details.")
public  class B2BAmountBalanceData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Open balance as the sum of all open transactional documents, including documents that are past the payment due date.<br/><br/><i>Generated property</i> for <code>B2BAmountBalanceData.openBalance</code> property defined at extension <code>b2bacceleratorfacades</code>. */
@Schema(name="openBalance", description="Open balance as the sum of all open transactional documents, including documents that are past the payment due date.") 	
	private String openBalance;

	/** Past due balance as the sum of all open transactional documents that are past the payment due date.<br/><br/><i>Generated property</i> for <code>B2BAmountBalanceData.pastDueBalance</code> property defined at extension <code>b2bacceleratorfacades</code>. */
@Schema(name="pastDueBalance", description="Past due balance as the sum of all open transactional documents that are past the payment due date.") 	
	private String pastDueBalance;

	/** Current balance as the sum of all open transactional documents that are not past the payment due date.<br/><br/><i>Generated property</i> for <code>B2BAmountBalanceData.currentBalance</code> property defined at extension <code>b2bacceleratorfacades</code>. */
@Schema(name="currentBalance", description="Current balance as the sum of all open transactional documents that are not past the payment due date.") 	
	private String currentBalance;

	/** <i>Generated property</i> for <code>B2BAmountBalanceData.dueBalance</code> property defined at extension <code>b2bacceleratorfacades</code>. */
@Schema(name="dueBalance") 	
	private Map<B2BNumberOfDayRangeData,String> dueBalance;
	
	public B2BAmountBalanceData()
	{
		// default constructor
	}
	
	public void setOpenBalance(final String openBalance)
	{
		this.openBalance = openBalance;
	}

	public String getOpenBalance() 
	{
		return openBalance;
	}
	
	public void setPastDueBalance(final String pastDueBalance)
	{
		this.pastDueBalance = pastDueBalance;
	}

	public String getPastDueBalance() 
	{
		return pastDueBalance;
	}
	
	public void setCurrentBalance(final String currentBalance)
	{
		this.currentBalance = currentBalance;
	}

	public String getCurrentBalance() 
	{
		return currentBalance;
	}
	
	public void setDueBalance(final Map<B2BNumberOfDayRangeData,String> dueBalance)
	{
		this.dueBalance = dueBalance;
	}

	public Map<B2BNumberOfDayRangeData,String> getDueBalance() 
	{
		return dueBalance;
	}
	

}