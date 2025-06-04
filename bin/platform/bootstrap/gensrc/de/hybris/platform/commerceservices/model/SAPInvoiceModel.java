/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.commerceservices.enums.ExternalSystemId;
import de.hybris.platform.commerceservices.model.SAPInvoiceMediaModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.ordersplitting.model.ConsignmentEntryModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Generated model class for type SAPInvoice first defined at extension commerceservices.
 * <p>
 * SAP Invoice type.
 */
@SuppressWarnings("all")
public class SAPInvoiceModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SAPInvoice";
	
	/**<i>Generated relation code constant for relation <code>SAPInvoice2ConsignmentEntryRel</code> defining source attribute <code>consignmentEntries</code> in extension <code>commerceservices</code>.</i>*/
	public static final String _SAPINVOICE2CONSIGNMENTENTRYREL = "SAPInvoice2ConsignmentEntryRel";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.id</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.totalPrice</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String TOTALPRICE = "totalPrice";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.netPrice</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String NETPRICE = "netPrice";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.currency</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.externalSystemId</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String EXTERNALSYSTEMID = "externalSystemId";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.invoiceMedia</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String INVOICEMEDIA = "invoiceMedia";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPInvoice.consignmentEntries</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String CONSIGNMENTENTRIES = "consignmentEntries";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SAPInvoiceModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SAPInvoiceModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SAPInvoice</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SAPInvoiceModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SAPInvoice</code> at extension <code>commerceservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SAPInvoiceModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.consignmentEntries</code> attribute defined at extension <code>commerceservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the consignmentEntries
	 */
	@Accessor(qualifier = "consignmentEntries", type = Accessor.Type.GETTER)
	public Set<ConsignmentEntryModel> getConsignmentEntries()
	{
		return getPersistenceContext().getPropertyValue(CONSIGNMENTENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.currency</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.externalSystemId</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the externalSystemId - External System ID where the invoice resides.
	 */
	@Accessor(qualifier = "externalSystemId", type = Accessor.Type.GETTER)
	public ExternalSystemId getExternalSystemId()
	{
		return getPersistenceContext().getPropertyValue(EXTERNALSYSTEMID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.id</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.invoiceMedia</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the invoiceMedia
	 */
	@Accessor(qualifier = "invoiceMedia", type = Accessor.Type.GETTER)
	public SAPInvoiceMediaModel getInvoiceMedia()
	{
		return getPersistenceContext().getPropertyValue(INVOICEMEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.netPrice</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the netPrice
	 */
	@Accessor(qualifier = "netPrice", type = Accessor.Type.GETTER)
	public BigDecimal getNetPrice()
	{
		return getPersistenceContext().getPropertyValue(NETPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPInvoice.totalPrice</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the totalPrice
	 */
	@Accessor(qualifier = "totalPrice", type = Accessor.Type.GETTER)
	public BigDecimal getTotalPrice()
	{
		return getPersistenceContext().getPropertyValue(TOTALPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.consignmentEntries</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the consignmentEntries
	 */
	@Accessor(qualifier = "consignmentEntries", type = Accessor.Type.SETTER)
	public void setConsignmentEntries(final Set<ConsignmentEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(CONSIGNMENTENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.currency</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.externalSystemId</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the externalSystemId - External System ID where the invoice resides.
	 */
	@Accessor(qualifier = "externalSystemId", type = Accessor.Type.SETTER)
	public void setExternalSystemId(final ExternalSystemId value)
	{
		getPersistenceContext().setPropertyValue(EXTERNALSYSTEMID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.id</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.invoiceMedia</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the invoiceMedia
	 */
	@Accessor(qualifier = "invoiceMedia", type = Accessor.Type.SETTER)
	public void setInvoiceMedia(final SAPInvoiceMediaModel value)
	{
		getPersistenceContext().setPropertyValue(INVOICEMEDIA, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.netPrice</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the netPrice
	 */
	@Accessor(qualifier = "netPrice", type = Accessor.Type.SETTER)
	public void setNetPrice(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(NETPRICE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPInvoice.totalPrice</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the totalPrice
	 */
	@Accessor(qualifier = "totalPrice", type = Accessor.Type.SETTER)
	public void setTotalPrice(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(TOTALPRICE, value);
	}
	
}
