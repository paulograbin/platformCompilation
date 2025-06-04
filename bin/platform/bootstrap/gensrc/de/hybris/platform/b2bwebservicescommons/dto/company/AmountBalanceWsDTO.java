/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.DueBalanceRangeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Account balance details.
 */
@Schema(name="AmountBalance", description="Account balance details.")
public  class AmountBalanceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Open balance as the sum of all open transactional documents, including documents that are past the payment due date.<br/><br/><i>Generated property</i> for <code>AmountBalanceWsDTO.openBalance</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="openBalance", description="Open balance as the sum of all open transactional documents, including documents that are past the payment due date.", example="$430.45") 	
	private String openBalance;

	/** Past due balance as the sum of all open transactional documents that are past the payment due date.<br/><br/><i>Generated property</i> for <code>AmountBalanceWsDTO.pastDueBalance</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pastDueBalance", description="Past due balance as the sum of all open transactional documents that are past the payment due date.", example="$130.45") 	
	private String pastDueBalance;

	/** Current balance as the sum of all open transactional documents that are not past the payment due date.<br/><br/><i>Generated property</i> for <code>AmountBalanceWsDTO.currentBalance</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="currentBalance", description="Current balance as the sum of all open transactional documents that are not past the payment due date.", example="$300.00") 	
	private String currentBalance;

	/** Balance due for each of the defined day ranges. For example, $100 due in 1-30 days, $200 due in 31-60 days, $300 due in 61-90 days, $400 due in 91+ days.<br/><br/><i>Generated property</i> for <code>AmountBalanceWsDTO.dueBalances</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="dueBalances", description="Balance due for each of the defined day ranges. For example, $100 due in 1-30 days, $200 due in 31-60 days, $300 due in 61-90 days, $400 due in 91+ days.") 	
	private List<DueBalanceRangeWsDTO> dueBalances;
	
	public AmountBalanceWsDTO()
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
	
	public void setDueBalances(final List<DueBalanceRangeWsDTO> dueBalances)
	{
		this.dueBalances = dueBalances;
	}

	public List<DueBalanceRangeWsDTO> getDueBalances() 
	{
		return dueBalances;
	}
	

}