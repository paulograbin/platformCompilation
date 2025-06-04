/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.ConsignmentEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.DeliveryModeWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.EntryArrivalSlotWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.store.PointOfServiceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.warehousingwebservices.dto.order.PackagingInfoWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Consignment
 */
@Schema(name="Consignment", description="Representation of a Consignment")
public  class ConsignmentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Consignment code<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Consignment code") 	
	private String code;

	/** Consignment tracking identifier<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.trackingID</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="trackingID", description="Consignment tracking identifier") 	
	private String trackingID;

	/** Consignment status<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="status", description="Consignment status") 	
	private String status;

	/** Consignment status display<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.statusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="statusDisplay", description="Consignment status display") 	
	private String statusDisplay;

	/** Consignment status date<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.statusDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="statusDate", description="Consignment status date") 	
	private Date statusDate;

	/** List of consignment entries<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entries", description="List of consignment entries") 	
	private List<ConsignmentEntryWsDTO> entries;

	/** Shipping address<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.shippingAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="shippingAddress", description="Shipping address") 	
	private AddressWsDTO shippingAddress;

	/** Delivery point of service<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.deliveryPointOfService</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryPointOfService", description="Delivery point of service") 	
	private PointOfServiceWsDTO deliveryPointOfService;

	/** Consignment item arrival slot<br/><br/><i>Generated property</i> for <code>ConsignmentWsDTO.arrivalSlot</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="arrivalSlot", description="Consignment item arrival slot") 	
	private EntryArrivalSlotWsDTO arrivalSlot;

	/** <i>Generated property</i> for <code>ConsignmentWsDTO.orderCode</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="orderCode") 	
	private String orderCode;

	/** <i>Generated property</i> for <code>ConsignmentWsDTO.shippingDate</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="shippingDate", example="2021-01-13T10:06:57+0000") 	
	private Date shippingDate;

	/** <i>Generated property</i> for <code>ConsignmentWsDTO.deliveryMode</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="deliveryMode") 	
	private DeliveryModeWsDTO deliveryMode;

	/** <i>Generated property</i> for <code>ConsignmentWsDTO.warehouseCode</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="warehouseCode") 	
	private String warehouseCode;

	/** <i>Generated property</i> for <code>ConsignmentWsDTO.packagingInfo</code> property defined at extension <code>warehousingwebservices</code>. */
@Schema(name="packagingInfo") 	
	private PackagingInfoWsDTO packagingInfo;
	
	public ConsignmentWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setTrackingID(final String trackingID)
	{
		this.trackingID = trackingID;
	}

	public String getTrackingID() 
	{
		return trackingID;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setStatusDate(final Date statusDate)
	{
		this.statusDate = statusDate;
	}

	public Date getStatusDate() 
	{
		return statusDate;
	}
	
	public void setEntries(final List<ConsignmentEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<ConsignmentEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setShippingAddress(final AddressWsDTO shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public AddressWsDTO getShippingAddress() 
	{
		return shippingAddress;
	}
	
	public void setDeliveryPointOfService(final PointOfServiceWsDTO deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}

	public PointOfServiceWsDTO getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
	
	public void setArrivalSlot(final EntryArrivalSlotWsDTO arrivalSlot)
	{
		this.arrivalSlot = arrivalSlot;
	}

	public EntryArrivalSlotWsDTO getArrivalSlot() 
	{
		return arrivalSlot;
	}
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	
	public void setShippingDate(final Date shippingDate)
	{
		this.shippingDate = shippingDate;
	}

	public Date getShippingDate() 
	{
		return shippingDate;
	}
	
	public void setDeliveryMode(final DeliveryModeWsDTO deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}

	public DeliveryModeWsDTO getDeliveryMode() 
	{
		return deliveryMode;
	}
	
	public void setWarehouseCode(final String warehouseCode)
	{
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseCode() 
	{
		return warehouseCode;
	}
	
	public void setPackagingInfo(final PackagingInfoWsDTO packagingInfo)
	{
		this.packagingInfo = packagingInfo;
	}

	public PackagingInfoWsDTO getPackagingInfo() 
	{
		return packagingInfo;
	}
	

}