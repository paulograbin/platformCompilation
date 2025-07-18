/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.returns.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.enums.OrderModificationEntryStatus;
import de.hybris.platform.basecommerce.enums.ReturnStatus;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.orderhistory.model.OrderHistoryEntryModel;
import de.hybris.platform.ordermodify.model.OrderModificationRecordEntryModel;
import de.hybris.platform.ordermodify.model.OrderModificationRecordModel;
import de.hybris.platform.returns.model.ReturnRequestModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type OrderReturnRecordEntry first defined at extension basecommerce.
 */
@SuppressWarnings("all")
public class OrderReturnRecordEntryModel extends OrderModificationRecordEntryModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OrderReturnRecordEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderReturnRecordEntry.returnStatus</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String RETURNSTATUS = "returnStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderReturnRecordEntry.expectedQuantity</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String EXPECTEDQUANTITY = "expectedQuantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderReturnRecordEntry.returnRequest</code> attribute defined at extension <code>warehousing</code>. */
	public static final String RETURNREQUEST = "returnRequest";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OrderReturnRecordEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OrderReturnRecordEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _modificationRecord initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _originalVersion initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _status initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _timestamp initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderReturnRecordEntryModel(final String _code, final OrderModificationRecordModel _modificationRecord, final OrderHistoryEntryModel _originalVersion, final OrderModificationEntryStatus _status, final Date _timestamp)
	{
		super();
		setCode(_code);
		setModificationRecord(_modificationRecord);
		setOriginalVersion(_originalVersion);
		setStatus(_status);
		setTimestamp(_timestamp);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _modificationRecord initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _originalVersion initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _status initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 * @param _timestamp initial attribute declared by type <code>OrderModificationRecordEntry</code> at extension <code>basecommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderReturnRecordEntryModel(final String _code, final OrderModificationRecordModel _modificationRecord, final OrderHistoryEntryModel _originalVersion, final ItemModel _owner, final OrderModificationEntryStatus _status, final Date _timestamp)
	{
		super();
		setCode(_code);
		setModificationRecord(_modificationRecord);
		setOriginalVersion(_originalVersion);
		setOwner(_owner);
		setStatus(_status);
		setTimestamp(_timestamp);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderReturnRecordEntry.expectedQuantity</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the expectedQuantity
	 */
	@Accessor(qualifier = "expectedQuantity", type = Accessor.Type.GETTER)
	public Long getExpectedQuantity()
	{
		return getPersistenceContext().getPropertyValue(EXPECTEDQUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderReturnRecordEntry.returnRequest</code> attribute defined at extension <code>warehousing</code>. 
	 * @return the returnRequest
	 */
	@Accessor(qualifier = "returnRequest", type = Accessor.Type.GETTER)
	public ReturnRequestModel getReturnRequest()
	{
		return getPersistenceContext().getPropertyValue(RETURNREQUEST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderReturnRecordEntry.returnStatus</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the returnStatus
	 */
	@Accessor(qualifier = "returnStatus", type = Accessor.Type.GETTER)
	public ReturnStatus getReturnStatus()
	{
		return getPersistenceContext().getPropertyValue(RETURNSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderReturnRecordEntry.expectedQuantity</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the expectedQuantity
	 */
	@Accessor(qualifier = "expectedQuantity", type = Accessor.Type.SETTER)
	public void setExpectedQuantity(final Long value)
	{
		getPersistenceContext().setPropertyValue(EXPECTEDQUANTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderReturnRecordEntry.returnRequest</code> attribute defined at extension <code>warehousing</code>. 
	 *  
	 * @param value the returnRequest
	 */
	@Accessor(qualifier = "returnRequest", type = Accessor.Type.SETTER)
	public void setReturnRequest(final ReturnRequestModel value)
	{
		getPersistenceContext().setPropertyValue(RETURNREQUEST, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderReturnRecordEntry.returnStatus</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the returnStatus
	 */
	@Accessor(qualifier = "returnStatus", type = Accessor.Type.SETTER)
	public void setReturnStatus(final ReturnStatus value)
	{
		getPersistenceContext().setPropertyValue(RETURNSTATUS, value);
	}
	
}
