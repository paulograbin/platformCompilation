/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorservices.model.promotions;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.OrderPromotionModel;
import de.hybris.platform.promotions.model.PromotionPriceRowModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type OrderThresholdDiscountPercentagePromotion first defined at extension b2bacceleratorservices.
 */
@SuppressWarnings("all")
public class OrderThresholdDiscountPercentagePromotionModel extends OrderPromotionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OrderThresholdDiscountPercentagePromotion";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderThresholdDiscountPercentagePromotion.thresholdTotals</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String THRESHOLDTOTALS = "thresholdTotals";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderThresholdDiscountPercentagePromotion.percentageDiscount</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String PERCENTAGEDISCOUNT = "percentageDiscount";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderThresholdDiscountPercentagePromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String MESSAGEFIRED = "messageFired";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderThresholdDiscountPercentagePromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String MESSAGECOULDHAVEFIRED = "messageCouldHaveFired";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OrderThresholdDiscountPercentagePromotionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OrderThresholdDiscountPercentagePromotionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderThresholdDiscountPercentagePromotionModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderThresholdDiscountPercentagePromotionModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderThresholdDiscountPercentagePromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.GETTER)
	public String getMessageCouldHaveFired()
	{
		return getMessageCouldHaveFired(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderThresholdDiscountPercentagePromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @param loc the value localization key 
	 * @return the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.GETTER)
	public String getMessageCouldHaveFired(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(MESSAGECOULDHAVEFIRED, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderThresholdDiscountPercentagePromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the messageFired - The message to show when the promotion has fired.
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.GETTER)
	public String getMessageFired()
	{
		return getMessageFired(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderThresholdDiscountPercentagePromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @param loc the value localization key 
	 * @return the messageFired - The message to show when the promotion has fired.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.GETTER)
	public String getMessageFired(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(MESSAGEFIRED, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderThresholdDiscountPercentagePromotion.percentageDiscount</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the percentageDiscount - Percentage discount.
	 */
	@Accessor(qualifier = "percentageDiscount", type = Accessor.Type.GETTER)
	public Double getPercentageDiscount()
	{
		return getPersistenceContext().getPropertyValue(PERCENTAGEDISCOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderThresholdDiscountPercentagePromotion.thresholdTotals</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the thresholdTotals - The cart total value threshold in specific currencies.
	 */
	@Accessor(qualifier = "thresholdTotals", type = Accessor.Type.GETTER)
	public Collection<PromotionPriceRowModel> getThresholdTotals()
	{
		return getPersistenceContext().getPropertyValue(THRESHOLDTOTALS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderThresholdDiscountPercentagePromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.SETTER)
	public void setMessageCouldHaveFired(final String value)
	{
		setMessageCouldHaveFired(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>OrderThresholdDiscountPercentagePromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.SETTER)
	public void setMessageCouldHaveFired(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(MESSAGECOULDHAVEFIRED, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderThresholdDiscountPercentagePromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageFired - The message to show when the promotion has fired.
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.SETTER)
	public void setMessageFired(final String value)
	{
		setMessageFired(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>OrderThresholdDiscountPercentagePromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageFired - The message to show when the promotion has fired.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.SETTER)
	public void setMessageFired(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(MESSAGEFIRED, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderThresholdDiscountPercentagePromotion.percentageDiscount</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the percentageDiscount - Percentage discount.
	 */
	@Accessor(qualifier = "percentageDiscount", type = Accessor.Type.SETTER)
	public void setPercentageDiscount(final Double value)
	{
		getPersistenceContext().setPropertyValue(PERCENTAGEDISCOUNT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderThresholdDiscountPercentagePromotion.thresholdTotals</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the thresholdTotals - The cart total value threshold in specific currencies.
	 */
	@Accessor(qualifier = "thresholdTotals", type = Accessor.Type.SETTER)
	public void setThresholdTotals(final Collection<PromotionPriceRowModel> value)
	{
		getPersistenceContext().setPropertyValue(THRESHOLDTOTALS, value);
	}
	
}
