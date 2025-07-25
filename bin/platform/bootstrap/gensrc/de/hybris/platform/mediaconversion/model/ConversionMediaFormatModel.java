/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.mediaconversion.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type ConversionMediaFormat first defined at extension mediaconversion.
 */
@SuppressWarnings("all")
public class ConversionMediaFormatModel extends MediaFormatModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ConversionMediaFormat";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConversionMediaFormat.mimeType</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String MIMETYPE = "mimeType";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConversionMediaFormat.conversion</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String CONVERSION = "conversion";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConversionMediaFormat.conversionStrategy</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String CONVERSIONSTRATEGY = "conversionStrategy";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConversionMediaFormat.inputFormat</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String INPUTFORMAT = "inputFormat";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConversionMediaFormat.mediaAddOns</code> attribute defined at extension <code>mediaconversion</code>. */
	public static final String MEDIAADDONS = "mediaAddOns";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConversionMediaFormatModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConversionMediaFormatModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _qualifier initial attribute declared by type <code>MediaFormat</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConversionMediaFormatModel(final String _qualifier)
	{
		super();
		setQualifier(_qualifier);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _qualifier initial attribute declared by type <code>MediaFormat</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConversionMediaFormatModel(final ItemModel _owner, final String _qualifier)
	{
		super();
		setOwner(_owner);
		setQualifier(_qualifier);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConversionMediaFormat.conversion</code> attribute defined at extension <code>mediaconversion</code>. 
	 * @return the conversion - Conversion command
	 */
	@Accessor(qualifier = "conversion", type = Accessor.Type.GETTER)
	public String getConversion()
	{
		return getPersistenceContext().getPropertyValue(CONVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConversionMediaFormat.conversionStrategy</code> attribute defined at extension <code>mediaconversion</code>. 
	 * @return the conversionStrategy - Bean name of the conversion strategy to use.
	 */
	@Accessor(qualifier = "conversionStrategy", type = Accessor.Type.GETTER)
	public String getConversionStrategy()
	{
		return getPersistenceContext().getPropertyValue(CONVERSIONSTRATEGY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConversionMediaFormat.inputFormat</code> attribute defined at extension <code>mediaconversion</code>. 
	 * @return the inputFormat - Media format to take as input for the conversion (optional).
	 */
	@Accessor(qualifier = "inputFormat", type = Accessor.Type.GETTER)
	public ConversionMediaFormatModel getInputFormat()
	{
		return getPersistenceContext().getPropertyValue(INPUTFORMAT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConversionMediaFormat.mediaAddOns</code> attribute defined at extension <code>mediaconversion</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the mediaAddOns - Additional media to be used in the conversion (optional).
	 */
	@Accessor(qualifier = "mediaAddOns", type = Accessor.Type.GETTER)
	public List<MediaModel> getMediaAddOns()
	{
		return getPersistenceContext().getPropertyValue(MEDIAADDONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConversionMediaFormat.mimeType</code> attribute defined at extension <code>mediaconversion</code>. 
	 * @return the mimeType - Mime type of this format.
	 */
	@Accessor(qualifier = "mimeType", type = Accessor.Type.GETTER)
	public String getMimeType()
	{
		return getPersistenceContext().getPropertyValue(MIMETYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConversionMediaFormat.conversion</code> attribute defined at extension <code>mediaconversion</code>. 
	 *  
	 * @param value the conversion - Conversion command
	 */
	@Accessor(qualifier = "conversion", type = Accessor.Type.SETTER)
	public void setConversion(final String value)
	{
		getPersistenceContext().setPropertyValue(CONVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConversionMediaFormat.conversionStrategy</code> attribute defined at extension <code>mediaconversion</code>. 
	 *  
	 * @param value the conversionStrategy - Bean name of the conversion strategy to use.
	 */
	@Accessor(qualifier = "conversionStrategy", type = Accessor.Type.SETTER)
	public void setConversionStrategy(final String value)
	{
		getPersistenceContext().setPropertyValue(CONVERSIONSTRATEGY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConversionMediaFormat.inputFormat</code> attribute defined at extension <code>mediaconversion</code>. 
	 *  
	 * @param value the inputFormat - Media format to take as input for the conversion (optional).
	 */
	@Accessor(qualifier = "inputFormat", type = Accessor.Type.SETTER)
	public void setInputFormat(final ConversionMediaFormatModel value)
	{
		getPersistenceContext().setPropertyValue(INPUTFORMAT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConversionMediaFormat.mediaAddOns</code> attribute defined at extension <code>mediaconversion</code>. 
	 *  
	 * @param value the mediaAddOns - Additional media to be used in the conversion (optional).
	 */
	@Accessor(qualifier = "mediaAddOns", type = Accessor.Type.SETTER)
	public void setMediaAddOns(final List<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(MEDIAADDONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConversionMediaFormat.mimeType</code> attribute defined at extension <code>mediaconversion</code>. 
	 *  
	 * @param value the mimeType - Mime type of this format.
	 */
	@Accessor(qualifier = "mimeType", type = Accessor.Type.SETTER)
	public void setMimeType(final String value)
	{
		getPersistenceContext().setPropertyValue(MIMETYPE, value);
	}
	
}
