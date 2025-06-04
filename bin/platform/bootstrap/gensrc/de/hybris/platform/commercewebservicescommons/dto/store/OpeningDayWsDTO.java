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
import de.hybris.platform.commercewebservicescommons.dto.store.TimeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * List of OpeningDay
 */
@Schema(name="OpeningDay", description="List of OpeningDay")
public  class OpeningDayWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Starting time of opening day<br/><br/><i>Generated property</i> for <code>OpeningDayWsDTO.openingTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="openingTime", description="Starting time of opening day") 	
	private TimeWsDTO openingTime;

	/** Closing time of opening day<br/><br/><i>Generated property</i> for <code>OpeningDayWsDTO.closingTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="closingTime", description="Closing time of opening day") 	
	private TimeWsDTO closingTime;
	
	public OpeningDayWsDTO()
	{
		// default constructor
	}
	
	public void setOpeningTime(final TimeWsDTO openingTime)
	{
		this.openingTime = openingTime;
	}

	public TimeWsDTO getOpeningTime() 
	{
		return openingTime;
	}
	
	public void setClosingTime(final TimeWsDTO closingTime)
	{
		this.closingTime = closingTime;
	}

	public TimeWsDTO getClosingTime() 
	{
		return closingTime;
	}
	

}