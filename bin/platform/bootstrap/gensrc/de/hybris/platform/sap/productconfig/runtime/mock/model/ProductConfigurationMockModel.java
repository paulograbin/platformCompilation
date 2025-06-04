/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 12, 2025, 10:11:41 AM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.runtime.mock.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ProductConfigurationMock first defined at extension sapproductconfigruntimemock.
 * <p>
 * ProductConfigurationMock stores the state of a runtime configuration created by ProductConfig Mock Configurator,
 * 			which is only suitable for demo or test purpose, but not for production use.
 */
@SuppressWarnings("all")
public class ProductConfigurationMockModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProductConfigurationMock";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductConfigurationMock.configId</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. */
	public static final String CONFIGID = "configId";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductConfigurationMock.currentConfigState</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. */
	public static final String CURRENTCONFIGSTATE = "currentConfigState";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductConfigurationMock.externalConfigState</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. */
	public static final String EXTERNALCONFIGSTATE = "externalConfigState";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductConfigurationMockModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductConfigurationMockModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _configId initial attribute declared by type <code>ProductConfigurationMock</code> at extension <code>sapproductconfigruntimemock</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProductConfigurationMockModel(final String _configId)
	{
		super();
		setConfigId(_configId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _configId initial attribute declared by type <code>ProductConfigurationMock</code> at extension <code>sapproductconfigruntimemock</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProductConfigurationMockModel(final String _configId, final ItemModel _owner)
	{
		super();
		setConfigId(_configId);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductConfigurationMock.configId</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. 
	 * @return the configId - Id of the persisted mock configuration
	 */
	@Accessor(qualifier = "configId", type = Accessor.Type.GETTER)
	public String getConfigId()
	{
		return getPersistenceContext().getPropertyValue(CONFIGID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductConfigurationMock.currentConfigState</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. 
	 * @return the currentConfigState - mock configuration content
	 */
	@Accessor(qualifier = "currentConfigState", type = Accessor.Type.GETTER)
	public Object getCurrentConfigState()
	{
		return getPersistenceContext().getPropertyValue(CURRENTCONFIGSTATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductConfigurationMock.externalConfigState</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. 
	 * @return the externalConfigState - mock configuration content of an external Configuration
	 */
	@Accessor(qualifier = "externalConfigState", type = Accessor.Type.GETTER)
	public Object getExternalConfigState()
	{
		return getPersistenceContext().getPropertyValue(EXTERNALCONFIGSTATE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductConfigurationMock.configId</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. 
	 *  
	 * @param value the configId - Id of the persisted mock configuration
	 */
	@Accessor(qualifier = "configId", type = Accessor.Type.SETTER)
	public void setConfigId(final String value)
	{
		getPersistenceContext().setPropertyValue(CONFIGID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductConfigurationMock.currentConfigState</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. 
	 *  
	 * @param value the currentConfigState - mock configuration content
	 */
	@Accessor(qualifier = "currentConfigState", type = Accessor.Type.SETTER)
	public void setCurrentConfigState(final Object value)
	{
		getPersistenceContext().setPropertyValue(CURRENTCONFIGSTATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductConfigurationMock.externalConfigState</code> attribute defined at extension <code>sapproductconfigruntimemock</code>. 
	 *  
	 * @param value the externalConfigState - mock configuration content of an external Configuration
	 */
	@Accessor(qualifier = "externalConfigState", type = Accessor.Type.SETTER)
	public void setExternalConfigState(final Object value)
	{
		getPersistenceContext().setPropertyValue(EXTERNALCONFIGSTATE, value);
	}
	
}
