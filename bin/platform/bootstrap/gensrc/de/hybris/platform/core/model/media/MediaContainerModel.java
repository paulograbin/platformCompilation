/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core.model.media;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.mediaconversion.enums.ConversionStatus;
import de.hybris.platform.mediaconversion.model.ConversionErrorLogModel;
import de.hybris.platform.mediaconversion.model.ConversionGroupModel;
import de.hybris.platform.mediaconversion.model.MediaMetaDataModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type MediaContainer first defined at extension core.
 */
@SuppressWarnings("all")
public class MediaContainerModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MediaContainer";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.qualifier</code> attribute defined at extension <code>core</code>. */
	public static final String QUALIFIER = "qualifier";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.name</code> attribute defined at extension <code>core</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.medias</code> attribute defined at extension <code>core</code>. */
	public static final String MEDIAS = "medias";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.catalogVersion</code> attribute defined at extension <code>catalog</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.master</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String MASTER = "master";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.metaData</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String METADATA = "metaData";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.conversionStatus</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String CONVERSIONSTATUS = "conversionStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.conversionGroup</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String CONVERSIONGROUP = "conversionGroup";
	
	/** <i>Generated constant</i> - Attribute key of <code>MediaContainer.conversionErrorLog</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String CONVERSIONERRORLOG = "conversionErrorLog";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MediaContainerModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MediaContainerModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>MediaContainer</code> at extension <code>catalog</code>
	 * @param _qualifier initial attribute declared by type <code>MediaContainer</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MediaContainerModel(final CatalogVersionModel _catalogVersion, final String _qualifier)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setQualifier(_qualifier);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>MediaContainer</code> at extension <code>catalog</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _qualifier initial attribute declared by type <code>MediaContainer</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MediaContainerModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _qualifier)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setQualifier(_qualifier);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.catalogVersion</code> attribute defined at extension <code>catalog</code>. 
	 * @return the catalogVersion
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.conversionErrorLog</code> attribute defined at extension <code>mediaconversion</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the conversionErrorLog - Failed conversion for this container.
	 */
	@Accessor(qualifier = "conversionErrorLog", type = Accessor.Type.GETTER)
	public Collection<ConversionErrorLogModel> getConversionErrorLog()
	{
		return getPersistenceContext().getPropertyValue(CONVERSIONERRORLOG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.conversionGroup</code> attribute defined at extension <code>mediaconversion</code>. 
	 * @return the conversionGroup - Optional conversionGroup to restrict converted formats.
	 */
	@Accessor(qualifier = "conversionGroup", type = Accessor.Type.GETTER)
	public ConversionGroupModel getConversionGroup()
	{
		return getPersistenceContext().getPropertyValue(CONVERSIONGROUP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.conversionStatus</code> dynamic attribute defined at extension <code>mediaconversion</code>. 
	 * @return the conversionStatus - Accesses this container's current conversion status
	 */
	@Accessor(qualifier = "conversionStatus", type = Accessor.Type.GETTER)
	public ConversionStatus getConversionStatus()
	{
		return getPersistenceContext().getDynamicValue(this,CONVERSIONSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.master</code> dynamic attribute defined at extension <code>mediaconversion</code>. 
	 * @return the master - Accesses the current 'master' media.
	 */
	@Accessor(qualifier = "master", type = Accessor.Type.GETTER)
	public MediaModel getMaster()
	{
		return getPersistenceContext().getDynamicValue(this,MASTER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.medias</code> attribute defined at extension <code>core</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the medias
	 */
	@Accessor(qualifier = "medias", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getMedias()
	{
		return getPersistenceContext().getPropertyValue(MEDIAS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.metaData</code> dynamic attribute defined at extension <code>mediaconversion</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the metaData - Accesses this container's master media's meta data
	 */
	@Accessor(qualifier = "metaData", type = Accessor.Type.GETTER)
	public Collection<MediaMetaDataModel> getMetaData()
	{
		return getPersistenceContext().getDynamicValue(this,METADATA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.name</code> attribute defined at extension <code>core</code>. 
	 * @return the name - Name of this container
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.name</code> attribute defined at extension <code>core</code>. 
	 * @param loc the value localization key 
	 * @return the name - Name of this container
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MediaContainer.qualifier</code> attribute defined at extension <code>core</code>. 
	 * @return the qualifier - Qualifying name of this container
	 */
	@Accessor(qualifier = "qualifier", type = Accessor.Type.GETTER)
	public String getQualifier()
	{
		return getPersistenceContext().getPropertyValue(QUALIFIER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MediaContainer.catalogVersion</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the catalogVersion
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MediaContainer.conversionGroup</code> attribute defined at extension <code>mediaconversion</code>. 
	 *  
	 * @param value the conversionGroup - Optional conversionGroup to restrict converted formats.
	 */
	@Accessor(qualifier = "conversionGroup", type = Accessor.Type.SETTER)
	public void setConversionGroup(final ConversionGroupModel value)
	{
		getPersistenceContext().setPropertyValue(CONVERSIONGROUP, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MediaContainer.medias</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the medias
	 */
	@Accessor(qualifier = "medias", type = Accessor.Type.SETTER)
	public void setMedias(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(MEDIAS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MediaContainer.name</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the name - Name of this container
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>MediaContainer.name</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the name - Name of this container
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MediaContainer.qualifier</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the qualifier - Qualifying name of this container
	 */
	@Accessor(qualifier = "qualifier", type = Accessor.Type.SETTER)
	public void setQualifier(final String value)
	{
		getPersistenceContext().setPropertyValue(QUALIFIER, value);
	}
	
}
