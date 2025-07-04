/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core.model.security;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;
import java.util.Set;

/**
 * Generated model class for type PrincipalGroup first defined at extension core.
 */
@SuppressWarnings("all")
public class PrincipalGroupModel extends PrincipalModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PrincipalGroup";
	
	/**<i>Generated relation code constant for relation <code>PrincipalGroupRelation</code> defining source attribute <code>members</code> in extension <code>core</code>.</i>*/
	public static final String _PRINCIPALGROUPRELATION = "PrincipalGroupRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. */
	public static final String LOCNAME = "locName";
	
	/** <i>Generated constant</i> - Attribute key of <code>PrincipalGroup.maxBruteForceLoginAttempts</code> attribute defined at extension <code>core</code>. */
	public static final String MAXBRUTEFORCELOGINATTEMPTS = "maxBruteForceLoginAttempts";
	
	/** <i>Generated constant</i> - Attribute key of <code>PrincipalGroup.passwordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. */
	public static final String PASSWORDEXPIRYPERIODDAYS = "passwordExpiryPeriodDays";
	
	/** <i>Generated constant</i> - Attribute key of <code>PrincipalGroup.inactivePasswordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. */
	public static final String INACTIVEPASSWORDEXPIRYPERIODDAYS = "inactivePasswordExpiryPeriodDays";
	
	/** <i>Generated constant</i> - Attribute key of <code>PrincipalGroup.initialPasswordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. */
	public static final String INITIALPASSWORDEXPIRYPERIODDAYS = "initialPasswordExpiryPeriodDays";
	
	/** <i>Generated constant</i> - Attribute key of <code>PrincipalGroup.members</code> attribute defined at extension <code>core</code>. */
	public static final String MEMBERS = "members";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PrincipalGroupModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PrincipalGroupModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PrincipalGroupModel(final String _uid)
	{
		super();
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PrincipalGroupModel(final ItemModel _owner, final String _uid)
	{
		super();
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.inactivePasswordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. 
	 * @return the inactivePasswordExpiryPeriodDays
	 */
	@Accessor(qualifier = "inactivePasswordExpiryPeriodDays", type = Accessor.Type.GETTER)
	public Integer getInactivePasswordExpiryPeriodDays()
	{
		return getPersistenceContext().getPropertyValue(INACTIVEPASSWORDEXPIRYPERIODDAYS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.initialPasswordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. 
	 * @return the initialPasswordExpiryPeriodDays
	 */
	@Accessor(qualifier = "initialPasswordExpiryPeriodDays", type = Accessor.Type.GETTER)
	public Integer getInitialPasswordExpiryPeriodDays()
	{
		return getPersistenceContext().getPropertyValue(INITIALPASSWORDEXPIRYPERIODDAYS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 * @return the locName
	 * @deprecated since ages - use { @link #getLocName()} instead
	 */
	@Deprecated(since = "ages", forRemoval = true)
	public String getLocname()
	{
		return this.getLocName();
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 * @return the locName
	 * @deprecated since ages - use { @link #getLocName(Locale)} instead
	 */
	@Deprecated(since = "ages", forRemoval = true)
	public String getLocname(final Locale loc)
	{
		return this.getLocName(loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 * @return the locName
	 */
	@Accessor(qualifier = "locName", type = Accessor.Type.GETTER)
	public String getLocName()
	{
		return getLocName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 * @param loc the value localization key 
	 * @return the locName
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "locName", type = Accessor.Type.GETTER)
	public String getLocName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(LOCNAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.maxBruteForceLoginAttempts</code> attribute defined at extension <code>core</code>. 
	 * @return the maxBruteForceLoginAttempts
	 */
	@Accessor(qualifier = "maxBruteForceLoginAttempts", type = Accessor.Type.GETTER)
	public Integer getMaxBruteForceLoginAttempts()
	{
		return getPersistenceContext().getPropertyValue(MAXBRUTEFORCELOGINATTEMPTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.members</code> attribute defined at extension <code>core</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the members
	 */
	@Accessor(qualifier = "members", type = Accessor.Type.GETTER)
	public Set<PrincipalModel> getMembers()
	{
		return getPersistenceContext().getPropertyValue(MEMBERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PrincipalGroup.passwordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. 
	 * @return the passwordExpiryPeriodDays
	 */
	@Accessor(qualifier = "passwordExpiryPeriodDays", type = Accessor.Type.GETTER)
	public Integer getPasswordExpiryPeriodDays()
	{
		return getPersistenceContext().getPropertyValue(PASSWORDEXPIRYPERIODDAYS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.inactivePasswordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the inactivePasswordExpiryPeriodDays
	 */
	@Accessor(qualifier = "inactivePasswordExpiryPeriodDays", type = Accessor.Type.SETTER)
	public void setInactivePasswordExpiryPeriodDays(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INACTIVEPASSWORDEXPIRYPERIODDAYS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.initialPasswordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the initialPasswordExpiryPeriodDays
	 */
	@Accessor(qualifier = "initialPasswordExpiryPeriodDays", type = Accessor.Type.SETTER)
	public void setInitialPasswordExpiryPeriodDays(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INITIALPASSWORDEXPIRYPERIODDAYS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the locName
	 * @deprecated since ages - use { @link #setLocName(java.lang.String)} instead
	 */
	@Deprecated(since = "ages", forRemoval = true)
	public void setLocname(final String value)
	{
		this.setLocName(value);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the locName
	 * @deprecated since ages - use { @link #setLocName(java.lang.String,Locale)} instead
	 */
	@Deprecated(since = "ages", forRemoval = true)
	public void setLocname(final String value, final Locale loc)
	{
		this.setLocName(value,loc);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the locName
	 */
	@Accessor(qualifier = "locName", type = Accessor.Type.SETTER)
	public void setLocName(final String value)
	{
		setLocName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.locName</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the locName
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "locName", type = Accessor.Type.SETTER)
	public void setLocName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(LOCNAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.maxBruteForceLoginAttempts</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the maxBruteForceLoginAttempts
	 */
	@Accessor(qualifier = "maxBruteForceLoginAttempts", type = Accessor.Type.SETTER)
	public void setMaxBruteForceLoginAttempts(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXBRUTEFORCELOGINATTEMPTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.members</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the members
	 */
	@Accessor(qualifier = "members", type = Accessor.Type.SETTER)
	public void setMembers(final Set<PrincipalModel> value)
	{
		getPersistenceContext().setPropertyValue(MEMBERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PrincipalGroup.passwordExpiryPeriodDays</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the passwordExpiryPeriodDays
	 */
	@Accessor(qualifier = "passwordExpiryPeriodDays", type = Accessor.Type.SETTER)
	public void setPasswordExpiryPeriodDays(final Integer value)
	{
		getPersistenceContext().setPropertyValue(PASSWORDEXPIRYPERIODDAYS, value);
	}
	
}
