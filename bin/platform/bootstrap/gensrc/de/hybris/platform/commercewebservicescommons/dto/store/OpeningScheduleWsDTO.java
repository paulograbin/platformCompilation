/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.store;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.store.SpecialOpeningDayWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.store.WeekdayOpeningDayWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Opening schedule
 */
@Schema(name="OpeningSchedule", description="Representation of an Opening schedule")
public  class OpeningScheduleWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Name of the opening schedule<br/><br/><i>Generated property</i> for <code>OpeningScheduleWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the opening schedule") 	
	private String name;

	/** Code of the opening schedule<br/><br/><i>Generated property</i> for <code>OpeningScheduleWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the opening schedule") 	
	private String code;

	/** List of weekday opening days<br/><br/><i>Generated property</i> for <code>OpeningScheduleWsDTO.weekDayOpeningList</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="weekDayOpeningList", description="List of weekday opening days") 	
	private List<WeekdayOpeningDayWsDTO> weekDayOpeningList;

	/** List of special opening days<br/><br/><i>Generated property</i> for <code>OpeningScheduleWsDTO.specialDayOpeningList</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="specialDayOpeningList", description="List of special opening days") 	
	private List<SpecialOpeningDayWsDTO> specialDayOpeningList;
	
	public OpeningScheduleWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setWeekDayOpeningList(final List<WeekdayOpeningDayWsDTO> weekDayOpeningList)
	{
		this.weekDayOpeningList = weekDayOpeningList;
	}

	public List<WeekdayOpeningDayWsDTO> getWeekDayOpeningList() 
	{
		return weekDayOpeningList;
	}
	
	public void setSpecialDayOpeningList(final List<SpecialOpeningDayWsDTO> specialDayOpeningList)
	{
		this.specialDayOpeningList = specialDayOpeningList;
	}

	public List<SpecialOpeningDayWsDTO> getSpecialDayOpeningList() 
	{
		return specialDayOpeningList;
	}
	

}