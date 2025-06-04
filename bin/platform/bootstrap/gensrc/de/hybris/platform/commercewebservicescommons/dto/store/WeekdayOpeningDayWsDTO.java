/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:37 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.store;

import de.hybris.platform.commercewebservicescommons.dto.store.OpeningDayWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Weekday Opening Day
 */
@Schema(name="WeekdayOpeningDay", description="Representation of a Weekday Opening Day")
public  class WeekdayOpeningDayWsDTO extends OpeningDayWsDTO 

{



	/** Text representation of week day opening day<br/><br/><i>Generated property</i> for <code>WeekdayOpeningDayWsDTO.weekDay</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="weekDay", description="Text representation of week day opening day") 	
	private String weekDay;

	/** Flag stating if weekday opening day is closed<br/><br/><i>Generated property</i> for <code>WeekdayOpeningDayWsDTO.closed</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="closed", description="Flag stating if weekday opening day is closed") 	
	private Boolean closed;
	
	public WeekdayOpeningDayWsDTO()
	{
		// default constructor
	}
	
	public void setWeekDay(final String weekDay)
	{
		this.weekDay = weekDay;
	}

	public String getWeekDay() 
	{
		return weekDay;
	}
	
	public void setClosed(final Boolean closed)
	{
		this.closed = closed;
	}

	public Boolean getClosed() 
	{
		return closed;
	}
	

}