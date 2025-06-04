/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.store;

import de.hybris.platform.commercewebservicescommons.dto.store.OpeningDayWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a special opening day
 */
@Schema(name="SpecialOpeningDay", description="Representation of a special opening day")
public  class SpecialOpeningDayWsDTO extends OpeningDayWsDTO 

{



	/** Date of special opening day<br/><br/><i>Generated property</i> for <code>SpecialOpeningDayWsDTO.date</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="date", description="Date of special opening day") 	
	private Date date;

	/** Text representation of the date of special opening day<br/><br/><i>Generated property</i> for <code>SpecialOpeningDayWsDTO.formattedDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="formattedDate", description="Text representation of the date of special opening day") 	
	private String formattedDate;

	/** Flag stating if special opening day is closed<br/><br/><i>Generated property</i> for <code>SpecialOpeningDayWsDTO.closed</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="closed", description="Flag stating if special opening day is closed") 	
	private Boolean closed;

	/** Name of the special opening day event<br/><br/><i>Generated property</i> for <code>SpecialOpeningDayWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the special opening day event") 	
	private String name;

	/** Comment field<br/><br/><i>Generated property</i> for <code>SpecialOpeningDayWsDTO.comment</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="comment", description="Comment field") 	
	private String comment;
	
	public SpecialOpeningDayWsDTO()
	{
		// default constructor
	}
	
	public void setDate(final Date date)
	{
		this.date = date;
	}

	public Date getDate() 
	{
		return date;
	}
	
	public void setFormattedDate(final String formattedDate)
	{
		this.formattedDate = formattedDate;
	}

	public String getFormattedDate() 
	{
		return formattedDate;
	}
	
	public void setClosed(final Boolean closed)
	{
		this.closed = closed;
	}

	public Boolean getClosed() 
	{
		return closed;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	

}