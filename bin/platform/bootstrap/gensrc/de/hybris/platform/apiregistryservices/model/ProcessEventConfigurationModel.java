/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.apiregistryservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel;
import de.hybris.platform.apiregistryservices.model.events.EventConfigurationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ProcessEventConfiguration first defined at extension apiregistryservices.
 * <p>
 * Event configuration for business process result exporting.
 */
@SuppressWarnings("all")
public class ProcessEventConfigurationModel extends EventConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProcessEventConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProcessEventConfiguration.process</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String PROCESS = "process";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProcessEventConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProcessEventConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationTarget initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _eventClass initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _exportName initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _process initial attribute declared by type <code>ProcessEventConfiguration</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProcessEventConfigurationModel(final DestinationTargetModel _destinationTarget, final String _eventClass, final String _exportName, final String _process)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEventClass(_eventClass);
		setExportName(_exportName);
		setProcess(_process);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationTarget initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _eventClass initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _exportName initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _process initial attribute declared by type <code>ProcessEventConfiguration</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProcessEventConfigurationModel(final DestinationTargetModel _destinationTarget, final String _eventClass, final String _exportName, final ItemModel _owner, final String _process)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEventClass(_eventClass);
		setExportName(_exportName);
		setOwner(_owner);
		setProcess(_process);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProcessEventConfiguration.process</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the process - Fully qualified classname of business process
	 */
	@Accessor(qualifier = "process", type = Accessor.Type.GETTER)
	public String getProcess()
	{
		return getPersistenceContext().getPropertyValue(PROCESS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProcessEventConfiguration.process</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the process - Fully qualified classname of business process
	 */
	@Accessor(qualifier = "process", type = Accessor.Type.SETTER)
	public void setProcess(final String value)
	{
		getPersistenceContext().setPropertyValue(PROCESS, value);
	}
	
}
