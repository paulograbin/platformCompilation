/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Consignment tracking event
 */
@Schema(name="consignmentTrackingEvent", description="Consignment tracking event")
public  class ConsignmentTrackingEventDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Date of tracking event<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingEventDataWsDTO.eventDate</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="eventDate", description="Date of tracking event") 	
	private Date eventDate;

	/** Tracking detail<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingEventDataWsDTO.detail</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="detail", description="Tracking detail") 	
	private String detail;

	/** Consignment location<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingEventDataWsDTO.location</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="location", description="Consignment location") 	
	private String location;

	/** Logistics status<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingEventDataWsDTO.referenceCode</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="referenceCode", description="Logistics status") 	
	private String referenceCode;
	
	public ConsignmentTrackingEventDataWsDTO()
	{
		// default constructor
	}
	
	public void setEventDate(final Date eventDate)
	{
		this.eventDate = eventDate;
	}

	public Date getEventDate() 
	{
		return eventDate;
	}
	
	public void setDetail(final String detail)
	{
		this.detail = detail;
	}

	public String getDetail() 
	{
		return detail;
	}
	
	public void setLocation(final String location)
	{
		this.location = location;
	}

	public String getLocation() 
	{
		return location;
	}
	
	public void setReferenceCode(final String referenceCode)
	{
		this.referenceCode = referenceCode;
	}

	public String getReferenceCode() 
	{
		return referenceCode;
	}
	

}