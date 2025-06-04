/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.store;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Time
 */
@Schema(name="Time", description="Representation of a Time")
public  class TimeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Hour part of the time data<br/><br/><i>Generated property</i> for <code>TimeWsDTO.hour</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="hour", description="Hour part of the time data") 	
	private Byte hour;

	/** Minute part of the time data<br/><br/><i>Generated property</i> for <code>TimeWsDTO.minute</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="minute", description="Minute part of the time data") 	
	private Byte minute;

	/** Formatted hour<br/><br/><i>Generated property</i> for <code>TimeWsDTO.formattedHour</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="formattedHour", description="Formatted hour") 	
	private String formattedHour;

	/** Meridiem indicator<br/><br/><i>Generated property</i> for <code>TimeWsDTO.meridiemIndicator</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="meridiemIndicator", description="Meridiem indicator") 	
	private String meridiemIndicator;
	
	public TimeWsDTO()
	{
		// default constructor
	}
	
	public void setHour(final Byte hour)
	{
		this.hour = hour;
	}

	public Byte getHour() 
	{
		return hour;
	}
	
	public void setMinute(final Byte minute)
	{
		this.minute = minute;
	}

	public Byte getMinute() 
	{
		return minute;
	}
	
	public void setFormattedHour(final String formattedHour)
	{
		this.formattedHour = formattedHour;
	}

	public String getFormattedHour() 
	{
		return formattedHour;
	}
	
	public void setMeridiemIndicator(final String meridiemIndicator)
	{
		this.meridiemIndicator = meridiemIndicator;
	}

	public String getMeridiemIndicator() 
	{
		return meridiemIndicator;
	}
	

}