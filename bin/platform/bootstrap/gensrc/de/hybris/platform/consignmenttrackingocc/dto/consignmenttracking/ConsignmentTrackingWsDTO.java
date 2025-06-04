/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking;

import java.io.Serializable;
import de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking.CarrierWsDTO;
import de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking.ConsignmentTrackingEventDataWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Consignment tracking data
 */
@Schema(name="consignmentTracking", description="Consignment tracking data")
public  class ConsignmentTrackingWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Consignment status<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.statusDisplay</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="statusDisplay", description="Consignment status", example="inTransit") 	
	private String statusDisplay;

	/** Carrier details<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.carrierDetails</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="carrierDetails", description="Carrier details") 	
	private CarrierWsDTO carrierDetails;

	/** Tracking identifier<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.trackingID</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="trackingID", description="Tracking identifier") 	
	private String trackingID;

	/** The tracking url provided by the carrier<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.trackingUrl</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="trackingUrl", description="The tracking url provided by the carrier") 	
	private String trackingUrl;

	/** Target arrival date<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.targetArrivalDate</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="targetArrivalDate", description="Target arrival date") 	
	private Date targetArrivalDate;

	/** Logistics tracking information<br/><br/><i>Generated property</i> for <code>ConsignmentTrackingWsDTO.trackingEvents</code> property defined at extension <code>consignmenttrackingocc</code>. */
@Schema(name="trackingEvents", description="Logistics tracking information") 	
	private List<ConsignmentTrackingEventDataWsDTO> trackingEvents;
	
	public ConsignmentTrackingWsDTO()
	{
		// default constructor
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setCarrierDetails(final CarrierWsDTO carrierDetails)
	{
		this.carrierDetails = carrierDetails;
	}

	public CarrierWsDTO getCarrierDetails() 
	{
		return carrierDetails;
	}
	
	public void setTrackingID(final String trackingID)
	{
		this.trackingID = trackingID;
	}

	public String getTrackingID() 
	{
		return trackingID;
	}
	
	public void setTrackingUrl(final String trackingUrl)
	{
		this.trackingUrl = trackingUrl;
	}

	public String getTrackingUrl() 
	{
		return trackingUrl;
	}
	
	public void setTargetArrivalDate(final Date targetArrivalDate)
	{
		this.targetArrivalDate = targetArrivalDate;
	}

	public Date getTargetArrivalDate() 
	{
		return targetArrivalDate;
	}
	
	public void setTrackingEvents(final List<ConsignmentTrackingEventDataWsDTO> trackingEvents)
	{
		this.trackingEvents = trackingEvents;
	}

	public List<ConsignmentTrackingEventDataWsDTO> getTrackingEvents() 
	{
		return trackingEvents;
	}
	

}