/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.order.DayOfWeekWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Schedule Replenishment Form
 */
@Schema(name="ScheduleReplenishmentForm", description="Representation of a Schedule Replenishment Form")
public  class ScheduleReplenishmentFormWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** First day for replenishment order<br/><br/><i>Generated property</i> for <code>ScheduleReplenishmentFormWsDTO.replenishmentStartDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="replenishmentStartDate", description="First day for replenishment order", example="2020-12-31T09:00:00+0000") 	
	private Date replenishmentStartDate;

	/** How frequent replenishment should be activated expressed in days. Mandatory with
				'recurrencePeriod=DAILY'.
			<br/><br/><i>Generated property</i> for <code>ScheduleReplenishmentFormWsDTO.numberOfDays</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="numberOfDays", description="How frequent replenishment should be activated expressed in days. Mandatory with 'recurrencePeriod=DAILY'.", example="14") 	
	private String numberOfDays;

	/** How frequent replenishment should be activated expressed in weeks. Mandatory with
				'recurrencePeriod=WEEKLY'.
			<br/><br/><i>Generated property</i> for <code>ScheduleReplenishmentFormWsDTO.numberOfWeeks</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="numberOfWeeks", description="How frequent replenishment should be activated expressed in weeks. Mandatory with 'recurrencePeriod=WEEKLY'.", example="1") 	
	private String numberOfWeeks;

	/** On which date of month replenishment should be activated. Mandatory with
				'recurrencePeriod=MONTHLY'.
			<br/><br/><i>Generated property</i> for <code>ScheduleReplenishmentFormWsDTO.nthDayOfMonth</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="nthDayOfMonth", description="On which date of month replenishment should be activated. Mandatory with 'recurrencePeriod=MONTHLY'.", example="1") 	
	private String nthDayOfMonth;

	/** Replenishment recurrence period. Available values are DAILY, WEEKLY and MONTHLY.
				DAILY requires 'numberOfDays'.
				WEEKLY requires 'daysOfWeek' AND 'numberOfWeeks'.
				MONTHLY requires 'nthDayOfMonth'.
			<br/><br/><i>Generated property</i> for <code>ScheduleReplenishmentFormWsDTO.recurrencePeriod</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="recurrencePeriod", description="Replenishment recurrence period. Available values are DAILY, WEEKLY and MONTHLY. DAILY requires 'numberOfDays'. WEEKLY requires 'daysOfWeek' AND 'numberOfWeeks'. MONTHLY requires 'nthDayOfMonth'.", example="WEEKLY") 	
	private String recurrencePeriod;

	/** List of days of week on which replenishment should occur. Mandatory with
				'recurrencePeriod=WEEKLY'.
			<br/><br/><i>Generated property</i> for <code>ScheduleReplenishmentFormWsDTO.daysOfWeek</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="daysOfWeek", description="List of days of week on which replenishment should occur. Mandatory with 'recurrencePeriod=WEEKLY'.") 	
	private List<DayOfWeekWsDTO> daysOfWeek;
	
	public ScheduleReplenishmentFormWsDTO()
	{
		// default constructor
	}
	
	public void setReplenishmentStartDate(final Date replenishmentStartDate)
	{
		this.replenishmentStartDate = replenishmentStartDate;
	}

	public Date getReplenishmentStartDate() 
	{
		return replenishmentStartDate;
	}
	
	public void setNumberOfDays(final String numberOfDays)
	{
		this.numberOfDays = numberOfDays;
	}

	public String getNumberOfDays() 
	{
		return numberOfDays;
	}
	
	public void setNumberOfWeeks(final String numberOfWeeks)
	{
		this.numberOfWeeks = numberOfWeeks;
	}

	public String getNumberOfWeeks() 
	{
		return numberOfWeeks;
	}
	
	public void setNthDayOfMonth(final String nthDayOfMonth)
	{
		this.nthDayOfMonth = nthDayOfMonth;
	}

	public String getNthDayOfMonth() 
	{
		return nthDayOfMonth;
	}
	
	public void setRecurrencePeriod(final String recurrencePeriod)
	{
		this.recurrencePeriod = recurrencePeriod;
	}

	public String getRecurrencePeriod() 
	{
		return recurrencePeriod;
	}
	
	public void setDaysOfWeek(final List<DayOfWeekWsDTO> daysOfWeek)
	{
		this.daysOfWeek = daysOfWeek;
	}

	public List<DayOfWeekWsDTO> getDaysOfWeek() 
	{
		return daysOfWeek;
	}
	

}