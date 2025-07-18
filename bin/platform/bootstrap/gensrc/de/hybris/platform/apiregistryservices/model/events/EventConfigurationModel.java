/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.apiregistryservices.model.events;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.enums.EventMappingType;
import de.hybris.platform.apiregistryservices.enums.EventPriority;
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel;
import de.hybris.platform.apiregistryservices.model.events.EventPropertyConfigurationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type EventConfiguration first defined at extension apiregistryservices.
 * <p>
 * Event exporting configuration.
 */
@SuppressWarnings("all")
public class EventConfigurationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "EventConfiguration";
	
	/**<i>Generated relation code constant for relation <code>DestinationTarget2EventConfiguration</code> defining source attribute <code>destinationTarget</code> in extension <code>apiregistryservices</code>.</i>*/
	public static final String _DESTINATIONTARGET2EVENTCONFIGURATION = "DestinationTarget2EventConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.eventClass</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EVENTCLASS = "eventClass";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.version</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String VERSION = "version";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.exportFlag</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EXPORTFLAG = "exportFlag";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.priority</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String PRIORITY = "priority";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.exportName</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EXPORTNAME = "exportName";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.mappingType</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String MAPPINGTYPE = "mappingType";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.converterBean</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String CONVERTERBEAN = "converterBean";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.description</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.extensionName</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EXTENSIONNAME = "extensionName";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.filterLocation</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String FILTERLOCATION = "filterLocation";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.eventPropertyConfigurations</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EVENTPROPERTYCONFIGURATIONS = "eventPropertyConfigurations";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventConfiguration.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONTARGET = "destinationTarget";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public EventConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public EventConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationTarget initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _eventClass initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _exportName initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public EventConfigurationModel(final DestinationTargetModel _destinationTarget, final String _eventClass, final String _exportName)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEventClass(_eventClass);
		setExportName(_exportName);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationTarget initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _eventClass initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _exportName initial attribute declared by type <code>EventConfiguration</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public EventConfigurationModel(final DestinationTargetModel _destinationTarget, final String _eventClass, final String _exportName, final ItemModel _owner)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEventClass(_eventClass);
		setExportName(_exportName);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.converterBean</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the converterBean - Spring Bean Name
	 */
	@Accessor(qualifier = "converterBean", type = Accessor.Type.GETTER)
	public String getConverterBean()
	{
		return getPersistenceContext().getPropertyValue(CONVERTERBEAN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.description</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the description - Human-readable Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the destinationTarget - Destination Target
	 */
	@Accessor(qualifier = "destinationTarget", type = Accessor.Type.GETTER)
	public DestinationTargetModel getDestinationTarget()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONTARGET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.eventClass</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the eventClass - Full path of Class
	 */
	@Accessor(qualifier = "eventClass", type = Accessor.Type.GETTER)
	public String getEventClass()
	{
		return getPersistenceContext().getPropertyValue(EVENTCLASS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.eventPropertyConfigurations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the eventPropertyConfigurations - Event Property Configurations
	 */
	@Accessor(qualifier = "eventPropertyConfigurations", type = Accessor.Type.GETTER)
	public List<EventPropertyConfigurationModel> getEventPropertyConfigurations()
	{
		return getPersistenceContext().getPropertyValue(EVENTPROPERTYCONFIGURATIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.exportName</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the exportName - Name of the event in the target system
	 */
	@Accessor(qualifier = "exportName", type = Accessor.Type.GETTER)
	public String getExportName()
	{
		return getPersistenceContext().getPropertyValue(EXPORTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.extensionName</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the extensionName - Name of the EC extension where the event class is defined
	 */
	@Accessor(qualifier = "extensionName", type = Accessor.Type.GETTER)
	public String getExtensionName()
	{
		return getPersistenceContext().getPropertyValue(EXTENSIONNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.filterLocation</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the filterLocation - Specifies the filter script URI to filter Kyma events. The filter script URI should follow this format model://yourScriptName
	 */
	@Accessor(qualifier = "filterLocation", type = Accessor.Type.GETTER)
	public String getFilterLocation()
	{
		return getPersistenceContext().getPropertyValue(FILTERLOCATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.mappingType</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the mappingType - Way of event data mapping
	 */
	@Accessor(qualifier = "mappingType", type = Accessor.Type.GETTER)
	public EventMappingType getMappingType()
	{
		return getPersistenceContext().getPropertyValue(MAPPINGTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.priority</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the priority - Export Priority
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.GETTER)
	public EventPriority getPriority()
	{
		return getPersistenceContext().getPropertyValue(PRIORITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.version</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the version - Event Configuration Version
	 */
	@Accessor(qualifier = "version", type = Accessor.Type.GETTER)
	public int getVersion()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(VERSION));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventConfiguration.exportFlag</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the exportFlag - Export Flag. Indicates whether the event or its specification is exported to its target destination.
	 */
	@Accessor(qualifier = "exportFlag", type = Accessor.Type.GETTER)
	public boolean isExportFlag()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(EXPORTFLAG));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.converterBean</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the converterBean - Spring Bean Name
	 */
	@Accessor(qualifier = "converterBean", type = Accessor.Type.SETTER)
	public void setConverterBean(final String value)
	{
		getPersistenceContext().setPropertyValue(CONVERTERBEAN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.description</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the description - Human-readable Description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>EventConfiguration.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the destinationTarget - Destination Target
	 */
	@Accessor(qualifier = "destinationTarget", type = Accessor.Type.SETTER)
	public void setDestinationTarget(final DestinationTargetModel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONTARGET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.eventClass</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the eventClass - Full path of Class
	 */
	@Accessor(qualifier = "eventClass", type = Accessor.Type.SETTER)
	public void setEventClass(final String value)
	{
		getPersistenceContext().setPropertyValue(EVENTCLASS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.eventPropertyConfigurations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the eventPropertyConfigurations - Event Property Configurations
	 */
	@Accessor(qualifier = "eventPropertyConfigurations", type = Accessor.Type.SETTER)
	public void setEventPropertyConfigurations(final List<EventPropertyConfigurationModel> value)
	{
		getPersistenceContext().setPropertyValue(EVENTPROPERTYCONFIGURATIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.exportFlag</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the exportFlag - Export Flag. Indicates whether the event or its specification is exported to its target destination.
	 */
	@Accessor(qualifier = "exportFlag", type = Accessor.Type.SETTER)
	public void setExportFlag(final boolean value)
	{
		getPersistenceContext().setPropertyValue(EXPORTFLAG, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.exportName</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the exportName - Name of the event in the target system
	 */
	@Accessor(qualifier = "exportName", type = Accessor.Type.SETTER)
	public void setExportName(final String value)
	{
		getPersistenceContext().setPropertyValue(EXPORTNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.extensionName</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the extensionName - Name of the EC extension where the event class is defined
	 */
	@Accessor(qualifier = "extensionName", type = Accessor.Type.SETTER)
	public void setExtensionName(final String value)
	{
		getPersistenceContext().setPropertyValue(EXTENSIONNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.filterLocation</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the filterLocation - Specifies the filter script URI to filter Kyma events. The filter script URI should follow this format model://yourScriptName
	 */
	@Accessor(qualifier = "filterLocation", type = Accessor.Type.SETTER)
	public void setFilterLocation(final String value)
	{
		getPersistenceContext().setPropertyValue(FILTERLOCATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.mappingType</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the mappingType - Way of event data mapping
	 */
	@Accessor(qualifier = "mappingType", type = Accessor.Type.SETTER)
	public void setMappingType(final EventMappingType value)
	{
		getPersistenceContext().setPropertyValue(MAPPINGTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventConfiguration.priority</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the priority - Export Priority
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.SETTER)
	public void setPriority(final EventPriority value)
	{
		getPersistenceContext().setPropertyValue(PRIORITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>EventConfiguration.version</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the version - Event Configuration Version
	 */
	@Accessor(qualifier = "version", type = Accessor.Type.SETTER)
	public void setVersion(final int value)
	{
		getPersistenceContext().setPropertyValue(VERSION, toObject(value));
	}
	
}
