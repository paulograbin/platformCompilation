/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type SnRetryConfiguration first defined at extension searchservices.
 */
@SuppressWarnings("all")
public class SnRetryConfigurationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SnRetryConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.id</code> attribute defined at extension <code>searchservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.maxAttempts</code> attribute defined at extension <code>searchservices</code>. */
	public static final String MAXATTEMPTS = "maxAttempts";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.timeout</code> attribute defined at extension <code>searchservices</code>. */
	public static final String TIMEOUT = "timeout";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.initialDelay</code> attribute defined at extension <code>searchservices</code>. */
	public static final String INITIALDELAY = "initialDelay";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.interval</code> attribute defined at extension <code>searchservices</code>. */
	public static final String INTERVAL = "interval";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.maxInterval</code> attribute defined at extension <code>searchservices</code>. */
	public static final String MAXINTERVAL = "maxInterval";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnRetryConfiguration.multiplier</code> attribute defined at extension <code>searchservices</code>. */
	public static final String MULTIPLIER = "multiplier";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SnRetryConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SnRetryConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SnRetryConfiguration</code> at extension <code>searchservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SnRetryConfigurationModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SnRetryConfiguration</code> at extension <code>searchservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SnRetryConfigurationModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.id</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.initialDelay</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the initialDelay
	 */
	@Accessor(qualifier = "initialDelay", type = Accessor.Type.GETTER)
	public Long getInitialDelay()
	{
		return getPersistenceContext().getPropertyValue(INITIALDELAY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.interval</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the interval
	 */
	@Accessor(qualifier = "interval", type = Accessor.Type.GETTER)
	public Long getInterval()
	{
		return getPersistenceContext().getPropertyValue(INTERVAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.maxAttempts</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the maxAttempts
	 */
	@Accessor(qualifier = "maxAttempts", type = Accessor.Type.GETTER)
	public Integer getMaxAttempts()
	{
		return getPersistenceContext().getPropertyValue(MAXATTEMPTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.maxInterval</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the maxInterval
	 */
	@Accessor(qualifier = "maxInterval", type = Accessor.Type.GETTER)
	public Long getMaxInterval()
	{
		return getPersistenceContext().getPropertyValue(MAXINTERVAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.multiplier</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the multiplier
	 */
	@Accessor(qualifier = "multiplier", type = Accessor.Type.GETTER)
	public Double getMultiplier()
	{
		return getPersistenceContext().getPropertyValue(MULTIPLIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnRetryConfiguration.timeout</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the timeout
	 */
	@Accessor(qualifier = "timeout", type = Accessor.Type.GETTER)
	public Long getTimeout()
	{
		return getPersistenceContext().getPropertyValue(TIMEOUT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.id</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.initialDelay</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the initialDelay
	 */
	@Accessor(qualifier = "initialDelay", type = Accessor.Type.SETTER)
	public void setInitialDelay(final Long value)
	{
		getPersistenceContext().setPropertyValue(INITIALDELAY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.interval</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the interval
	 */
	@Accessor(qualifier = "interval", type = Accessor.Type.SETTER)
	public void setInterval(final Long value)
	{
		getPersistenceContext().setPropertyValue(INTERVAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.maxAttempts</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the maxAttempts
	 */
	@Accessor(qualifier = "maxAttempts", type = Accessor.Type.SETTER)
	public void setMaxAttempts(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXATTEMPTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.maxInterval</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the maxInterval
	 */
	@Accessor(qualifier = "maxInterval", type = Accessor.Type.SETTER)
	public void setMaxInterval(final Long value)
	{
		getPersistenceContext().setPropertyValue(MAXINTERVAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.multiplier</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the multiplier
	 */
	@Accessor(qualifier = "multiplier", type = Accessor.Type.SETTER)
	public void setMultiplier(final Double value)
	{
		getPersistenceContext().setPropertyValue(MULTIPLIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnRetryConfiguration.timeout</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the timeout
	 */
	@Accessor(qualifier = "timeout", type = Accessor.Type.SETTER)
	public void setTimeout(final Long value)
	{
		getPersistenceContext().setPropertyValue(TIMEOUT, value);
	}
	
}
