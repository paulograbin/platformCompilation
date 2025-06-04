/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.DayRangeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Amount due in the specified day range.
 */
@Schema(name="DueBalanceRange", description="Amount due in the specified day range.")
public  class DueBalanceRangeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Maximum and minimum limits of the day range.<br/><br/><i>Generated property</i> for <code>DueBalanceRangeWsDTO.dayRange</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="dayRange", description="Maximum and minimum limits of the day range.") 	
	private DayRangeWsDTO dayRange;

	/** Amount due in the specified range.<br/><br/><i>Generated property</i> for <code>DueBalanceRangeWsDTO.amount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="amount", description="Amount due in the specified range.", example="$300.00") 	
	private String amount;
	
	public DueBalanceRangeWsDTO()
	{
		// default constructor
	}
	
	public void setDayRange(final DayRangeWsDTO dayRange)
	{
		this.dayRange = dayRange;
	}

	public DayRangeWsDTO getDayRange() 
	{
		return dayRange;
	}
	
	public void setAmount(final String amount)
	{
		this.amount = amount;
	}

	public String getAmount() 
	{
		return amount;
	}
	

}