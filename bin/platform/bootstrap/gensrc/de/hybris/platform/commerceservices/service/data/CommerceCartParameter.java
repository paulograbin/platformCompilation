/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.commerceservices.service.data;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.service.data.ProductConfigurationItem;
import de.hybris.platform.configurablebundleservices.model.BundleTemplateModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;
import java.util.Collection;
import java.util.Set;

public  class CommerceCartParameter  implements java.io.Serializable 

{

	public static final long DEFAULT_ENTRY_NUMBER = -1L;


	/** The CartModel<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.cart</code> property defined at extension <code>commerceservices</code>. */

	private CartModel cart;

	/** The ProductModel<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.product</code> property defined at extension <code>commerceservices</code>. */

	private ProductModel product;

	/** The quantity to add<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.quantity</code> property defined at extension <code>commerceservices</code>. */

	private long quantity;

	/** The units to add<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.unit</code> property defined at extension <code>commerceservices</code>. */

	private UnitModel unit;

	/** Should create new Entry<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.createNewEntry</code> property defined at extension <code>commerceservices</code>. */

	private boolean createNewEntry;

	/** The PointOfServiceModel<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.pointOfService</code> property defined at extension <code>commerceservices</code>. */

	private PointOfServiceModel pointOfService;

	/** The entry number to update<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.entryNumber</code> property defined at extension <code>commerceservices</code>. */

	private long entryNumber = DEFAULT_ENTRY_NUMBER;

	/** Should the method hooks be executed<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.enableHooks</code> property defined at extension <code>commerceservices</code>. */

	private boolean enableHooks;

	/** The current user<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.user</code> property defined at extension <code>commerceservices</code>. */

	private UserModel user;

	/** The current base site<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.baseSite</code> property defined at extension <code>commerceservices</code>. */

	private BaseSiteModel baseSite;

	/** A unique identifier<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.guid</code> property defined at extension <code>commerceservices</code>. */

	private String guid;

	/** Should cart be calculated or recalculated<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.recalculate</code> property defined at extension <code>commerceservices</code>. */

	private boolean recalculate;

	/** Country ISO code of delivery address<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.deliveryCountryIso</code> property defined at extension <code>commerceservices</code>. */

	private String deliveryCountryIso;

	/** Delivery zip code<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.deliveryZipCode</code> property defined at extension <code>commerceservices</code>. */

	private String deliveryZipCode;

	/** Entry group numbers<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.entryGroupNumbers</code> property defined at extension <code>commerceservices</code>. */

	private Set<Integer> entryGroupNumbers;

	/** New values for configuration<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.productConfiguration</code> property defined at extension <code>commerceservices</code>. */

	private Collection<ProductConfigurationItem> productConfiguration;

	/** Should ignore cart recalculation while restoring cart<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.ignoreRecalculation</code> property defined at extension <code>commerceservices</code>. */

	private boolean ignoreRecalculation;

	/** 
                Current version of the bundleTemplate model based on which the product is added to the cart. It will be
                stored on the cart entry.
            <br/><br/><i>Generated property</i> for <code>CommerceCartParameter.bundleTemplate</code> property defined at extension <code>configurablebundleservices</code>. */

	private BundleTemplateModel bundleTemplate;

	/** 
                Indicates the status of the update to cart.
            <br/><br/><i>Generated property</i> for <code>CommerceCartParameter.modificationStatus</code> property defined at extension <code>configurablebundleservices</code>. */

	private String modificationStatus;

	/** The configuration ID that needs to be deleted.<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.configToBeDeleted</code> property defined at extension <code>sapproductconfigservices</code>. */

	private String configToBeDeleted;

	/** The drafted configuration ID that needs to be deleted.<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.draftConfigToBeDeleted</code> property defined at extension <code>sapproductconfigservices</code>. */

	private String draftConfigToBeDeleted;

	/** The configuration ID of the cart item.<br/><br/><i>Generated property</i> for <code>CommerceCartParameter.configId</code> property defined at extension <code>sapproductconfigservices</code>. */

	private String configId;

	public CommerceCartParameter()
	{
		// default constructor
	}



	public void setCart(final CartModel cart)
	{
		this.cart = cart;
	}



	public CartModel getCart()
	{
		return cart;
	}



	public void setProduct(final ProductModel product)
	{
		this.product = product;
	}



	public ProductModel getProduct()
	{
		return product;
	}



	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}



	public long getQuantity()
	{
		return quantity;
	}



	public void setUnit(final UnitModel unit)
	{
		this.unit = unit;
	}



	public UnitModel getUnit()
	{
		return unit;
	}



	public void setCreateNewEntry(final boolean createNewEntry)
	{
		this.createNewEntry = createNewEntry;
	}



	public boolean isCreateNewEntry()
	{
		return createNewEntry;
	}



	public void setPointOfService(final PointOfServiceModel pointOfService)
	{
		this.pointOfService = pointOfService;
	}



	public PointOfServiceModel getPointOfService()
	{
		return pointOfService;
	}



	public void setEntryNumber(final long entryNumber)
	{
		this.entryNumber = entryNumber;
	}



	public long getEntryNumber()
	{
		return entryNumber;
	}



	public void setEnableHooks(final boolean enableHooks)
	{
		this.enableHooks = enableHooks;
	}



	public boolean isEnableHooks()
	{
		return enableHooks;
	}



	public void setUser(final UserModel user)
	{
		this.user = user;
	}



	public UserModel getUser()
	{
		return user;
	}



	public void setBaseSite(final BaseSiteModel baseSite)
	{
		this.baseSite = baseSite;
	}



	public BaseSiteModel getBaseSite()
	{
		return baseSite;
	}



	public void setGuid(final String guid)
	{
		this.guid = guid;
	}



	public String getGuid()
	{
		return guid;
	}



	public void setRecalculate(final boolean recalculate)
	{
		this.recalculate = recalculate;
	}



	public boolean isRecalculate()
	{
		return recalculate;
	}



	public void setDeliveryCountryIso(final String deliveryCountryIso)
	{
		this.deliveryCountryIso = deliveryCountryIso;
	}



	public String getDeliveryCountryIso()
	{
		return deliveryCountryIso;
	}



	public void setDeliveryZipCode(final String deliveryZipCode)
	{
		this.deliveryZipCode = deliveryZipCode;
	}



	public String getDeliveryZipCode()
	{
		return deliveryZipCode;
	}



	public void setEntryGroupNumbers(final Set<Integer> entryGroupNumbers)
	{
		this.entryGroupNumbers = entryGroupNumbers;
	}



	public Set<Integer> getEntryGroupNumbers()
	{
		return entryGroupNumbers;
	}



	public void setProductConfiguration(final Collection<ProductConfigurationItem> productConfiguration)
	{
		this.productConfiguration = productConfiguration;
	}



	public Collection<ProductConfigurationItem> getProductConfiguration()
	{
		return productConfiguration;
	}



	public void setIgnoreRecalculation(final boolean ignoreRecalculation)
	{
		this.ignoreRecalculation = ignoreRecalculation;
	}



	public boolean isIgnoreRecalculation()
	{
		return ignoreRecalculation;
	}



	public void setBundleTemplate(final BundleTemplateModel bundleTemplate)
	{
		this.bundleTemplate = bundleTemplate;
	}



	public BundleTemplateModel getBundleTemplate()
	{
		return bundleTemplate;
	}



	public void setModificationStatus(final String modificationStatus)
	{
		this.modificationStatus = modificationStatus;
	}



	public String getModificationStatus()
	{
		return modificationStatus;
	}



	public void setConfigToBeDeleted(final String configToBeDeleted)
	{
		this.configToBeDeleted = configToBeDeleted;
	}



	public String getConfigToBeDeleted()
	{
		return configToBeDeleted;
	}



	public void setDraftConfigToBeDeleted(final String draftConfigToBeDeleted)
	{
		this.draftConfigToBeDeleted = draftConfigToBeDeleted;
	}



	public String getDraftConfigToBeDeleted()
	{
		return draftConfigToBeDeleted;
	}



	public void setConfigId(final String configId)
	{
		this.configId = configId;
	}



	public String getConfigId()
	{
		return configId;
	}



}
