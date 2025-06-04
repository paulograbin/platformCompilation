/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 12, 2025, 10:11:41 AM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core.model.user;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

/**
 * Generated model class for type SitePreference first defined at extension commerceservices.
 * <p>
 * Preferences for one site.
 */
@SuppressWarnings("all")
public class SitePreferenceModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SitePreference";
	
	/**<i>Generated relation code constant for relation <code>Customer2SitePreferences</code> defining source attribute <code>customer</code> in extension <code>commerceservices</code>.</i>*/
	public static final String _CUSTOMER2SITEPREFERENCES = "Customer2SitePreferences";
	
	/** <i>Generated constant</i> - Attribute key of <code>SitePreference.site</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String SITE = "site";
	
	/** <i>Generated constant</i> - Attribute key of <code>SitePreference.pickUpLocation</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String PICKUPLOCATION = "pickUpLocation";
	
	/** <i>Generated constant</i> - Attribute key of <code>SitePreference.customer</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String CUSTOMER = "customer";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SitePreferenceModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SitePreferenceModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _customer initial attribute declared by type <code>SitePreference</code> at extension <code>commerceservices</code>
	 * @param _site initial attribute declared by type <code>SitePreference</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SitePreferenceModel(final CustomerModel _customer, final BaseSiteModel _site)
	{
		super();
		setCustomer(_customer);
		setSite(_site);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _customer initial attribute declared by type <code>SitePreference</code> at extension <code>commerceservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _site initial attribute declared by type <code>SitePreference</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SitePreferenceModel(final CustomerModel _customer, final ItemModel _owner, final BaseSiteModel _site)
	{
		super();
		setCustomer(_customer);
		setOwner(_owner);
		setSite(_site);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SitePreference.customer</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.GETTER)
	public CustomerModel getCustomer()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SitePreference.pickUpLocation</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the pickUpLocation
	 */
	@Accessor(qualifier = "pickUpLocation", type = Accessor.Type.GETTER)
	public PointOfServiceModel getPickUpLocation()
	{
		return getPersistenceContext().getPropertyValue(PICKUPLOCATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SitePreference.site</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the site
	 */
	@Accessor(qualifier = "site", type = Accessor.Type.GETTER)
	public BaseSiteModel getSite()
	{
		return getPersistenceContext().getPropertyValue(SITE);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SitePreference.customer</code> attribute defined at extension <code>commerceservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.SETTER)
	public void setCustomer(final CustomerModel value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SitePreference.pickUpLocation</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the pickUpLocation
	 */
	@Accessor(qualifier = "pickUpLocation", type = Accessor.Type.SETTER)
	public void setPickUpLocation(final PointOfServiceModel value)
	{
		getPersistenceContext().setPropertyValue(PICKUPLOCATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SitePreference.site</code> attribute defined at extension <code>commerceservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the site
	 */
	@Accessor(qualifier = "site", type = Accessor.Type.SETTER)
	public void setSite(final BaseSiteModel value)
	{
		getPersistenceContext().setPropertyValue(SITE, value);
	}
	
}
