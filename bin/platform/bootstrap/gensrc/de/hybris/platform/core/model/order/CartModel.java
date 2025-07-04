/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core.model.order;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.acceleratorservices.enums.ImportStatus;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.orderscheduling.model.CartToOrderCronJobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Date;

/**
 * Generated model class for type Cart first defined at extension core.
 */
@SuppressWarnings("all")
public class CartModel extends AbstractOrderModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Cart";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.sessionId</code> attribute defined at extension <code>core</code>. */
	public static final String SESSIONID = "sessionId";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.cartToOrderCronJob</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String CARTTOORDERCRONJOB = "cartToOrderCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.saveTime</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String SAVETIME = "saveTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.savedBy</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String SAVEDBY = "savedBy";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.quoteReference</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String QUOTEREFERENCE = "quoteReference";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.earliestRetrievalDate</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String EARLIESTRETRIEVALDATE = "earliestRetrievalDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.lastModifiedEntries</code> attribute defined at extension <code>configurablebundleservices</code>. */
	public static final String LASTMODIFIEDENTRIES = "lastModifiedEntries";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.importStatus</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String IMPORTSTATUS = "importStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.processingFlashBuyOrder</code> attribute defined at extension <code>timedaccesspromotionengineservices</code>. */
	public static final String PROCESSINGFLASHBUYORDER = "processingFlashBuyOrder";
	
	/** <i>Generated constant</i> - Attribute key of <code>Cart.visible</code> attribute defined at extension <code>selectivecartservices</code>. */
	public static final String VISIBLE = "visible";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CartModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CartModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _date initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>Cart</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CartModel(final CurrencyModel _currency, final Date _date, final UserModel _user)
	{
		super();
		setCurrency(_currency);
		setDate(_date);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _date initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>Cart</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CartModel(final CurrencyModel _currency, final Date _date, final ItemModel _owner, final UserModel _user)
	{
		super();
		setCurrency(_currency);
		setDate(_date);
		setOwner(_owner);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.cartToOrderCronJob</code> attribute defined at extension <code>basecommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the cartToOrderCronJob
	 */
	@Accessor(qualifier = "cartToOrderCronJob", type = Accessor.Type.GETTER)
	public Collection<CartToOrderCronJobModel> getCartToOrderCronJob()
	{
		return getPersistenceContext().getPropertyValue(CARTTOORDERCRONJOB);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.earliestRetrievalDate</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the earliestRetrievalDate - Date on which the earliest possible retrieval available for order
	 */
	@Accessor(qualifier = "earliestRetrievalDate", type = Accessor.Type.GETTER)
	public String getEarliestRetrievalDate()
	{
		return getPersistenceContext().getPropertyValue(EARLIESTRETRIEVALDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.importStatus</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the importStatus - set the status of the import cart process
	 */
	@Accessor(qualifier = "importStatus", type = Accessor.Type.GETTER)
	public ImportStatus getImportStatus()
	{
		return getPersistenceContext().getPropertyValue(IMPORTSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.lastModifiedEntries</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the lastModifiedEntries
	 */
	@Accessor(qualifier = "lastModifiedEntries", type = Accessor.Type.GETTER)
	public Collection<CartEntryModel> getLastModifiedEntries()
	{
		return getPersistenceContext().getPropertyValue(LASTMODIFIEDENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.quoteReference</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the quoteReference - The reference to quote from which the cart was created.
	 */
	@Accessor(qualifier = "quoteReference", type = Accessor.Type.GETTER)
	public QuoteModel getQuoteReference()
	{
		return getPersistenceContext().getPropertyValue(QUOTEREFERENCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.savedBy</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the savedBy - The user who saved the cart.
	 */
	@Accessor(qualifier = "savedBy", type = Accessor.Type.GETTER)
	public UserModel getSavedBy()
	{
		return getPersistenceContext().getPropertyValue(SAVEDBY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.saveTime</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the saveTime - The date/time when the cart was saved.
	 */
	@Accessor(qualifier = "saveTime", type = Accessor.Type.GETTER)
	public Date getSaveTime()
	{
		return getPersistenceContext().getPropertyValue(SAVETIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.sessionId</code> attribute defined at extension <code>core</code>. 
	 * @return the sessionId
	 */
	@Accessor(qualifier = "sessionId", type = Accessor.Type.GETTER)
	public String getSessionId()
	{
		return getPersistenceContext().getPropertyValue(SESSIONID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.visible</code> attribute defined at extension <code>selectivecartservices</code>. 
	 * @return the visible - set the status of the cart visible
	 */
	@Accessor(qualifier = "visible", type = Accessor.Type.GETTER)
	public Boolean getVisible()
	{
		return getPersistenceContext().getPropertyValue(VISIBLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cart.processingFlashBuyOrder</code> attribute defined at extension <code>timedaccesspromotionengineservices</code>. 
	 * @return the processingFlashBuyOrder - set the status for the flashbuy
	 */
	@Accessor(qualifier = "processingFlashBuyOrder", type = Accessor.Type.GETTER)
	public boolean isProcessingFlashBuyOrder()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(PROCESSINGFLASHBUYORDER));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.cartToOrderCronJob</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the cartToOrderCronJob
	 */
	@Accessor(qualifier = "cartToOrderCronJob", type = Accessor.Type.SETTER)
	public void setCartToOrderCronJob(final Collection<CartToOrderCronJobModel> value)
	{
		getPersistenceContext().setPropertyValue(CARTTOORDERCRONJOB, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.earliestRetrievalDate</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the earliestRetrievalDate - Date on which the earliest possible retrieval available for order
	 */
	@Accessor(qualifier = "earliestRetrievalDate", type = Accessor.Type.SETTER)
	public void setEarliestRetrievalDate(final String value)
	{
		getPersistenceContext().setPropertyValue(EARLIESTRETRIEVALDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.importStatus</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the importStatus - set the status of the import cart process
	 */
	@Accessor(qualifier = "importStatus", type = Accessor.Type.SETTER)
	public void setImportStatus(final ImportStatus value)
	{
		getPersistenceContext().setPropertyValue(IMPORTSTATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.lastModifiedEntries</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 *  
	 * @param value the lastModifiedEntries
	 */
	@Accessor(qualifier = "lastModifiedEntries", type = Accessor.Type.SETTER)
	public void setLastModifiedEntries(final Collection<CartEntryModel> value)
	{
		getPersistenceContext().setPropertyValue(LASTMODIFIEDENTRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.processingFlashBuyOrder</code> attribute defined at extension <code>timedaccesspromotionengineservices</code>. 
	 *  
	 * @param value the processingFlashBuyOrder - set the status for the flashbuy
	 */
	@Accessor(qualifier = "processingFlashBuyOrder", type = Accessor.Type.SETTER)
	public void setProcessingFlashBuyOrder(final boolean value)
	{
		getPersistenceContext().setPropertyValue(PROCESSINGFLASHBUYORDER, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.quoteReference</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the quoteReference - The reference to quote from which the cart was created.
	 */
	@Accessor(qualifier = "quoteReference", type = Accessor.Type.SETTER)
	public void setQuoteReference(final QuoteModel value)
	{
		getPersistenceContext().setPropertyValue(QUOTEREFERENCE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.savedBy</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the savedBy - The user who saved the cart.
	 */
	@Accessor(qualifier = "savedBy", type = Accessor.Type.SETTER)
	public void setSavedBy(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(SAVEDBY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.saveTime</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the saveTime - The date/time when the cart was saved.
	 */
	@Accessor(qualifier = "saveTime", type = Accessor.Type.SETTER)
	public void setSaveTime(final Date value)
	{
		getPersistenceContext().setPropertyValue(SAVETIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.sessionId</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the sessionId
	 */
	@Accessor(qualifier = "sessionId", type = Accessor.Type.SETTER)
	public void setSessionId(final String value)
	{
		getPersistenceContext().setPropertyValue(SESSIONID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Cart.visible</code> attribute defined at extension <code>selectivecartservices</code>. 
	 *  
	 * @param value the visible - set the status of the cart visible
	 */
	@Accessor(qualifier = "visible", type = Accessor.Type.SETTER)
	public void setVisible(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(VISIBLE, value);
	}
	
}
