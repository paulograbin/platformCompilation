/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordersplitting.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.enums.ConsignmentStatus;
import de.hybris.platform.commerceservices.order.EntryArrivalSlot;
import de.hybris.platform.consignmenttrackingservices.model.CarrierModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.delivery.DeliveryModeModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.ordersplitting.model.ConsignmentEntryModel;
import de.hybris.platform.ordersplitting.model.ConsignmentProcessModel;
import de.hybris.platform.ordersplitting.model.WarehouseModel;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.storelocator.model.PointOfServiceModel;
import de.hybris.platform.warehousing.model.PackagingInfoModel;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Generated model class for type Consignment first defined at extension basecommerce.
 */
@SuppressWarnings("all")
public class ConsignmentModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Consignment";
	
	/**<i>Generated relation code constant for relation <code>ConsignmentEntryConsignmentRelation</code> defining source attribute <code>consignmentEntries</code> in extension <code>basecommerce</code>.</i>*/
	public static final String _CONSIGNMENTENTRYCONSIGNMENTRELATION = "ConsignmentEntryConsignmentRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.code</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.shippingAddress</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SHIPPINGADDRESS = "shippingAddress";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.deliveryMode</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String DELIVERYMODE = "deliveryMode";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.namedDeliveryDate</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String NAMEDDELIVERYDATE = "namedDeliveryDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.shippingDate</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SHIPPINGDATE = "shippingDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.trackingID</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String TRACKINGID = "trackingID";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.carrier</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String CARRIER = "carrier";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.status</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.warehouse</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String WAREHOUSE = "warehouse";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.consignmentEntries</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String CONSIGNMENTENTRIES = "consignmentEntries";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.order</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String ORDER = "order";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.consignmentProcesses</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String CONSIGNMENTPROCESSES = "consignmentProcesses";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.deliveryPointOfService</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String DELIVERYPOINTOFSERVICE = "deliveryPointOfService";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.arrivalSlot</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String ARRIVALSLOT = "arrivalSlot";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.statusDisplay</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String STATUSDISPLAY = "statusDisplay";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.carrierDetails</code> attribute defined at extension <code>consignmenttrackingservices</code>. */
	public static final String CARRIERDETAILS = "carrierDetails";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.packagingInfo</code> attribute defined at extension <code>warehousing</code>. */
	public static final String PACKAGINGINFO = "packagingInfo";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.shippingLabel</code> attribute defined at extension <code>warehousing</code>. */
	public static final String SHIPPINGLABEL = "shippingLabel";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.returnLabel</code> attribute defined at extension <code>warehousing</code>. */
	public static final String RETURNLABEL = "returnLabel";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.returnForm</code> attribute defined at extension <code>warehousing</code>. */
	public static final String RETURNFORM = "returnForm";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.taskAssignmentWorkflow</code> attribute defined at extension <code>warehousing</code>. */
	public static final String TASKASSIGNMENTWORKFLOW = "taskAssignmentWorkflow";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.fulfillmentSystemConfig</code> attribute defined at extension <code>warehousing</code>. */
	public static final String FULFILLMENTSYSTEMCONFIG = "fulfillmentSystemConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.packaginginfos</code> attribute defined at extension <code>warehousing</code>. */
	public static final String PACKAGINGINFOS = "packaginginfos";
	
	/** <i>Generated constant</i> - Attribute key of <code>Consignment.paymentTransactionEntries</code> attribute defined at extension <code>warehousing</code>. */
	public static final String PAYMENTTRANSACTIONENTRIES = "paymentTransactionEntries";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConsignmentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConsignmentModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _shippingAddress initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _status initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _warehouse initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConsignmentModel(final String _code, final AddressModel _shippingAddress, final ConsignmentStatus _status, final WarehouseModel _warehouse)
	{
		super();
		setCode(_code);
		setShippingAddress(_shippingAddress);
		setStatus(_status);
		setWarehouse(_warehouse);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _deliveryMode initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _namedDeliveryDate initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _order initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _shippingAddress initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _status initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 * @param _warehouse initial attribute declared by type <code>Consignment</code> at extension <code>basecommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConsignmentModel(final String _code, final DeliveryModeModel _deliveryMode, final Date _namedDeliveryDate, final AbstractOrderModel _order, final ItemModel _owner, final AddressModel _shippingAddress, final ConsignmentStatus _status, final WarehouseModel _warehouse)
	{
		super();
		setCode(_code);
		setDeliveryMode(_deliveryMode);
		setNamedDeliveryDate(_namedDeliveryDate);
		setOrder(_order);
		setOwner(_owner);
		setShippingAddress(_shippingAddress);
		setStatus(_status);
		setWarehouse(_warehouse);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.arrivalSlot</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the arrivalSlot - The consignment arrival slot
	 */
	@Accessor(qualifier = "arrivalSlot", type = Accessor.Type.GETTER)
	public EntryArrivalSlot getArrivalSlot()
	{
		return getPersistenceContext().getPropertyValue(ARRIVALSLOT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.carrier</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the carrier
	 */
	@Accessor(qualifier = "carrier", type = Accessor.Type.GETTER)
	public String getCarrier()
	{
		return getPersistenceContext().getPropertyValue(CARRIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.carrierDetails</code> attribute defined at extension <code>consignmenttrackingservices</code>. 
	 * @return the carrierDetails
	 */
	@Accessor(qualifier = "carrierDetails", type = Accessor.Type.GETTER)
	public CarrierModel getCarrierDetails()
	{
		return getPersistenceContext().getPropertyValue(CARRIERDETAILS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.code</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.consignmentEntries</code> attribute defined at extension <code>basecommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the consignmentEntries
	 */
	@Accessor(qualifier = "consignmentEntries", type = Accessor.Type.GETTER)
	public Set<ConsignmentEntryModel> getConsignmentEntries()
	{
		return getPersistenceContext().getPropertyValue(CONSIGNMENTENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.consignmentProcesses</code> attribute defined at extension <code>basecommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the consignmentProcesses
	 */
	@Accessor(qualifier = "consignmentProcesses", type = Accessor.Type.GETTER)
	public Collection<ConsignmentProcessModel> getConsignmentProcesses()
	{
		return getPersistenceContext().getPropertyValue(CONSIGNMENTPROCESSES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.deliveryMode</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the deliveryMode
	 */
	@Accessor(qualifier = "deliveryMode", type = Accessor.Type.GETTER)
	public DeliveryModeModel getDeliveryMode()
	{
		return getPersistenceContext().getPropertyValue(DELIVERYMODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.deliveryPointOfService</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the deliveryPointOfService - The point of service to deliver to/collect from.
	 */
	@Accessor(qualifier = "deliveryPointOfService", type = Accessor.Type.GETTER)
	public PointOfServiceModel getDeliveryPointOfService()
	{
		return getPersistenceContext().getPropertyValue(DELIVERYPOINTOFSERVICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.fulfillmentSystemConfig</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the fulfillmentSystemConfig - Property that represents configuration to route the fulfillment of a consignment
	 */
	@Accessor(qualifier = "fulfillmentSystemConfig", type = Accessor.Type.GETTER)
	public Object getFulfillmentSystemConfig()
	{
		return getPersistenceContext().getPropertyValue(FULFILLMENTSYSTEMCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.namedDeliveryDate</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the namedDeliveryDate
	 */
	@Accessor(qualifier = "namedDeliveryDate", type = Accessor.Type.GETTER)
	public Date getNamedDeliveryDate()
	{
		return getPersistenceContext().getPropertyValue(NAMEDDELIVERYDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.order</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.GETTER)
	public AbstractOrderModel getOrder()
	{
		return getPersistenceContext().getPropertyValue(ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.packagingInfo</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the packagingInfo
	 */
	@Accessor(qualifier = "packagingInfo", type = Accessor.Type.GETTER)
	public PackagingInfoModel getPackagingInfo()
	{
		return getPersistenceContext().getPropertyValue(PACKAGINGINFO);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.packaginginfos</code> attribute defined at extension <code>warehousing</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the packaginginfos
	 */
	@Accessor(qualifier = "packaginginfos", type = Accessor.Type.GETTER)
	public List<PackagingInfoModel> getPackaginginfos()
	{
		return getPersistenceContext().getPropertyValue(PACKAGINGINFOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.paymentTransactionEntries</code> attribute defined at extension <code>warehousing</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the paymentTransactionEntries
	 */
	@Accessor(qualifier = "paymentTransactionEntries", type = Accessor.Type.GETTER)
	public Set<PaymentTransactionEntryModel> getPaymentTransactionEntries()
	{
		return getPersistenceContext().getPropertyValue(PAYMENTTRANSACTIONENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.returnForm</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the returnForm - The return form for the consignment.
	 */
	@Accessor(qualifier = "returnForm", type = Accessor.Type.GETTER)
	public MediaModel getReturnForm()
	{
		return getPersistenceContext().getPropertyValue(RETURNFORM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.returnLabel</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the returnLabel - The return label for the consignment.
	 */
	@Accessor(qualifier = "returnLabel", type = Accessor.Type.GETTER)
	public MediaModel getReturnLabel()
	{
		return getPersistenceContext().getPropertyValue(RETURNLABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.shippingAddress</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the shippingAddress
	 */
	@Accessor(qualifier = "shippingAddress", type = Accessor.Type.GETTER)
	public AddressModel getShippingAddress()
	{
		return getPersistenceContext().getPropertyValue(SHIPPINGADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.shippingDate</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the shippingDate
	 */
	@Accessor(qualifier = "shippingDate", type = Accessor.Type.GETTER)
	public Date getShippingDate()
	{
		return getPersistenceContext().getPropertyValue(SHIPPINGDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.shippingLabel</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the shippingLabel - The shipping label for the consignment.
	 */
	@Accessor(qualifier = "shippingLabel", type = Accessor.Type.GETTER)
	public MediaModel getShippingLabel()
	{
		return getPersistenceContext().getPropertyValue(SHIPPINGLABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.status</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public ConsignmentStatus getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.statusDisplay</code> dynamic attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the statusDisplay
	 */
	@Accessor(qualifier = "statusDisplay", type = Accessor.Type.GETTER)
	public String getStatusDisplay()
	{
		return getPersistenceContext().getDynamicValue(this,STATUSDISPLAY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.taskAssignmentWorkflow</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the taskAssignmentWorkflow - The task assignment workflow code assigned to the consignment.
	 */
	@Accessor(qualifier = "taskAssignmentWorkflow", type = Accessor.Type.GETTER)
	public String getTaskAssignmentWorkflow()
	{
		return getPersistenceContext().getPropertyValue(TASKASSIGNMENTWORKFLOW);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.trackingID</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the trackingID
	 */
	@Accessor(qualifier = "trackingID", type = Accessor.Type.GETTER)
	public String getTrackingID()
	{
		return getPersistenceContext().getPropertyValue(TRACKINGID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.warehouse</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the warehouse
	 */
	@Accessor(qualifier = "warehouse", type = Accessor.Type.GETTER)
	public WarehouseModel getWarehouse()
	{
		return getPersistenceContext().getPropertyValue(WAREHOUSE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.arrivalSlot</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the arrivalSlot - The consignment arrival slot
	 */
	@Accessor(qualifier = "arrivalSlot", type = Accessor.Type.SETTER)
	public void setArrivalSlot(final EntryArrivalSlot value)
	{
		getPersistenceContext().setPropertyValue(ARRIVALSLOT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.carrier</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the carrier
	 */
	@Accessor(qualifier = "carrier", type = Accessor.Type.SETTER)
	public void setCarrier(final String value)
	{
		getPersistenceContext().setPropertyValue(CARRIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.carrierDetails</code> attribute defined at extension <code>consignmenttrackingservices</code>. 
	 *  
	 * @param value the carrierDetails
	 */
	@Accessor(qualifier = "carrierDetails", type = Accessor.Type.SETTER)
	public void setCarrierDetails(final CarrierModel value)
	{
		getPersistenceContext().setPropertyValue(CARRIERDETAILS, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Consignment.code</code> attribute defined at extension <code>basecommerce</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.consignmentEntries</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the consignmentEntries
	 */
	@Accessor(qualifier = "consignmentEntries", type = Accessor.Type.SETTER)
	public void setConsignmentEntries(final Set<ConsignmentEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(CONSIGNMENTENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.consignmentProcesses</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the consignmentProcesses
	 */
	@Accessor(qualifier = "consignmentProcesses", type = Accessor.Type.SETTER)
	public void setConsignmentProcesses(final Collection<ConsignmentProcessModel> value)
	{
		getPersistenceContext().setPropertyValue(CONSIGNMENTPROCESSES, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Consignment.deliveryMode</code> attribute defined at extension <code>basecommerce</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the deliveryMode
	 */
	@Accessor(qualifier = "deliveryMode", type = Accessor.Type.SETTER)
	public void setDeliveryMode(final DeliveryModeModel value)
	{
		getPersistenceContext().setPropertyValue(DELIVERYMODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.deliveryPointOfService</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the deliveryPointOfService - The point of service to deliver to/collect from.
	 */
	@Accessor(qualifier = "deliveryPointOfService", type = Accessor.Type.SETTER)
	public void setDeliveryPointOfService(final PointOfServiceModel value)
	{
		getPersistenceContext().setPropertyValue(DELIVERYPOINTOFSERVICE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.fulfillmentSystemConfig</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the fulfillmentSystemConfig - Property that represents configuration to route the fulfillment of a consignment
	 */
	@Accessor(qualifier = "fulfillmentSystemConfig", type = Accessor.Type.SETTER)
	public void setFulfillmentSystemConfig(final Object value)
	{
		getPersistenceContext().setPropertyValue(FULFILLMENTSYSTEMCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Consignment.namedDeliveryDate</code> attribute defined at extension <code>basecommerce</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the namedDeliveryDate
	 */
	@Accessor(qualifier = "namedDeliveryDate", type = Accessor.Type.SETTER)
	public void setNamedDeliveryDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(NAMEDDELIVERYDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Consignment.order</code> attribute defined at extension <code>basecommerce</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.SETTER)
	public void setOrder(final AbstractOrderModel value)
	{
		getPersistenceContext().setPropertyValue(ORDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.packagingInfo</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the packagingInfo
	 */
	@Accessor(qualifier = "packagingInfo", type = Accessor.Type.SETTER)
	public void setPackagingInfo(final PackagingInfoModel value)
	{
		getPersistenceContext().setPropertyValue(PACKAGINGINFO, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.packaginginfos</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the packaginginfos
	 */
	@Accessor(qualifier = "packaginginfos", type = Accessor.Type.SETTER)
	public void setPackaginginfos(final List<PackagingInfoModel> value)
	{
		getPersistenceContext().setPropertyValue(PACKAGINGINFOS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.paymentTransactionEntries</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the paymentTransactionEntries
	 */
	@Accessor(qualifier = "paymentTransactionEntries", type = Accessor.Type.SETTER)
	public void setPaymentTransactionEntries(final Set<PaymentTransactionEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(PAYMENTTRANSACTIONENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.returnForm</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the returnForm - The return form for the consignment.
	 */
	@Accessor(qualifier = "returnForm", type = Accessor.Type.SETTER)
	public void setReturnForm(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(RETURNFORM, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.returnLabel</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the returnLabel - The return label for the consignment.
	 */
	@Accessor(qualifier = "returnLabel", type = Accessor.Type.SETTER)
	public void setReturnLabel(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(RETURNLABEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Consignment.shippingAddress</code> attribute defined at extension <code>basecommerce</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the shippingAddress
	 */
	@Accessor(qualifier = "shippingAddress", type = Accessor.Type.SETTER)
	public void setShippingAddress(final AddressModel value)
	{
		getPersistenceContext().setPropertyValue(SHIPPINGADDRESS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.shippingDate</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the shippingDate
	 */
	@Accessor(qualifier = "shippingDate", type = Accessor.Type.SETTER)
	public void setShippingDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(SHIPPINGDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.shippingLabel</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the shippingLabel - The shipping label for the consignment.
	 */
	@Accessor(qualifier = "shippingLabel", type = Accessor.Type.SETTER)
	public void setShippingLabel(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(SHIPPINGLABEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.status</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final ConsignmentStatus value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.taskAssignmentWorkflow</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the taskAssignmentWorkflow - The task assignment workflow code assigned to the consignment.
	 */
	@Accessor(qualifier = "taskAssignmentWorkflow", type = Accessor.Type.SETTER)
	public void setTaskAssignmentWorkflow(final String value)
	{
		getPersistenceContext().setPropertyValue(TASKASSIGNMENTWORKFLOW, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Consignment.trackingID</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the trackingID
	 */
	@Accessor(qualifier = "trackingID", type = Accessor.Type.SETTER)
	public void setTrackingID(final String value)
	{
		getPersistenceContext().setPropertyValue(TRACKINGID, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Consignment.warehouse</code> attribute defined at extension <code>basecommerce</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the warehouse
	 */
	@Accessor(qualifier = "warehouse", type = Accessor.Type.SETTER)
	public void setWarehouse(final WarehouseModel value)
	{
		getPersistenceContext().setPropertyValue(WAREHOUSE, value);
	}
	
}
