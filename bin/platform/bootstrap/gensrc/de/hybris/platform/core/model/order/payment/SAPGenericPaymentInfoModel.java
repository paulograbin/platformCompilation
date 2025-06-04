/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:27:36 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core.model.order.payment;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.enums.SAPCapturePattern;
import de.hybris.platform.core.enums.CreditCardType;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type SAPGenericPaymentInfo first defined at extension basecommerce.
 */
@SuppressWarnings("all")
public class SAPGenericPaymentInfoModel extends PaymentInfoModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SAPGenericPaymentInfo";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapCartId</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPCARTID = "sapCartId";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapCapturePattern</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPCAPTUREPATTERN = "sapCapturePattern";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapPaymentMethod</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPPAYMENTMETHOD = "sapPaymentMethod";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapPaymentMethodCode</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPPAYMENTMETHODCODE = "sapPaymentMethodCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapCardExpiredAt</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPCARDEXPIREDAT = "sapCardExpiredAt";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapCardType</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPCARDTYPE = "sapCardType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPGenericPaymentInfo.sapCardNumber</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String SAPCARDNUMBER = "sapCardNumber";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SAPGenericPaymentInfoModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SAPGenericPaymentInfoModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SAPGenericPaymentInfoModel(final String _code, final UserModel _user)
	{
		super();
		setCode(_code);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 * @param _original initial attribute declared by type <code>SAPGenericPaymentInfo</code> at extension <code>basecommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SAPGenericPaymentInfoModel(final String _code, final ItemModel _original, final ItemModel _owner, final UserModel _user)
	{
		super();
		setCode(_code);
		setOriginal(_original);
		setOwner(_owner);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapCapturePattern</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapCapturePattern
	 */
	@Accessor(qualifier = "sapCapturePattern", type = Accessor.Type.GETTER)
	public SAPCapturePattern getSapCapturePattern()
	{
		return getPersistenceContext().getPropertyValue(SAPCAPTUREPATTERN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapCardExpiredAt</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapCardExpiredAt
	 */
	@Accessor(qualifier = "sapCardExpiredAt", type = Accessor.Type.GETTER)
	public String getSapCardExpiredAt()
	{
		return getPersistenceContext().getPropertyValue(SAPCARDEXPIREDAT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapCardNumber</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapCardNumber
	 */
	@Accessor(qualifier = "sapCardNumber", type = Accessor.Type.GETTER)
	public String getSapCardNumber()
	{
		return getPersistenceContext().getPropertyValue(SAPCARDNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapCardType</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapCardType
	 */
	@Accessor(qualifier = "sapCardType", type = Accessor.Type.GETTER)
	public CreditCardType getSapCardType()
	{
		return getPersistenceContext().getPropertyValue(SAPCARDTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapCartId</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapCartId
	 */
	@Accessor(qualifier = "sapCartId", type = Accessor.Type.GETTER)
	public String getSapCartId()
	{
		return getPersistenceContext().getPropertyValue(SAPCARTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapPaymentMethod</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapPaymentMethod
	 */
	@Accessor(qualifier = "sapPaymentMethod", type = Accessor.Type.GETTER)
	public String getSapPaymentMethod()
	{
		return getPersistenceContext().getPropertyValue(SAPPAYMENTMETHOD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPGenericPaymentInfo.sapPaymentMethodCode</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the sapPaymentMethodCode
	 */
	@Accessor(qualifier = "sapPaymentMethodCode", type = Accessor.Type.GETTER)
	public String getSapPaymentMethodCode()
	{
		return getPersistenceContext().getPropertyValue(SAPPAYMENTMETHODCODE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PaymentInfo.original</code> attribute defined at extension <code>core</code> and redeclared at extension <code>basecommerce</code>. Will only accept values of type {@link de.hybris.platform.core.model.ItemModel}. 
	 *  
	 * @param value the original
	 */
	@Override
	@Accessor(qualifier = "original", type = Accessor.Type.SETTER)
	public void setOriginal(final ItemModel value)
	{
		super.setOriginal(value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapCapturePattern</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapCapturePattern
	 */
	@Accessor(qualifier = "sapCapturePattern", type = Accessor.Type.SETTER)
	public void setSapCapturePattern(final SAPCapturePattern value)
	{
		getPersistenceContext().setPropertyValue(SAPCAPTUREPATTERN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapCardExpiredAt</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapCardExpiredAt
	 */
	@Accessor(qualifier = "sapCardExpiredAt", type = Accessor.Type.SETTER)
	public void setSapCardExpiredAt(final String value)
	{
		getPersistenceContext().setPropertyValue(SAPCARDEXPIREDAT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapCardNumber</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapCardNumber
	 */
	@Accessor(qualifier = "sapCardNumber", type = Accessor.Type.SETTER)
	public void setSapCardNumber(final String value)
	{
		getPersistenceContext().setPropertyValue(SAPCARDNUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapCardType</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapCardType
	 */
	@Accessor(qualifier = "sapCardType", type = Accessor.Type.SETTER)
	public void setSapCardType(final CreditCardType value)
	{
		getPersistenceContext().setPropertyValue(SAPCARDTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapCartId</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapCartId
	 */
	@Accessor(qualifier = "sapCartId", type = Accessor.Type.SETTER)
	public void setSapCartId(final String value)
	{
		getPersistenceContext().setPropertyValue(SAPCARTID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapPaymentMethod</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapPaymentMethod
	 */
	@Accessor(qualifier = "sapPaymentMethod", type = Accessor.Type.SETTER)
	public void setSapPaymentMethod(final String value)
	{
		getPersistenceContext().setPropertyValue(SAPPAYMENTMETHOD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPGenericPaymentInfo.sapPaymentMethodCode</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the sapPaymentMethodCode
	 */
	@Accessor(qualifier = "sapPaymentMethodCode", type = Accessor.Type.SETTER)
	public void setSapPaymentMethodCode(final String value)
	{
		getPersistenceContext().setPropertyValue(SAPPAYMENTMETHODCODE, value);
	}
	
}
