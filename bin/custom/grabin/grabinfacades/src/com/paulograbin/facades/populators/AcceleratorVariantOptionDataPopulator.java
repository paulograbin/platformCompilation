/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.paulograbin.facades.populators;

import de.hybris.platform.commercefacades.product.ImageFormatMapping;
import de.hybris.platform.commercefacades.product.converters.populator.VariantOptionDataPopulator;
import de.hybris.platform.commercefacades.product.data.VariantOptionData;
import de.hybris.platform.commercefacades.product.data.VariantOptionQualifierData;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.media.MediaContainerService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.variants.model.VariantProductModel;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;


/**
 * Accelerator specific variant option data converter implementation.
 */
public class AcceleratorVariantOptionDataPopulator extends VariantOptionDataPopulator
{
	private static final Logger LOG = LoggerFactory.getLogger(AcceleratorVariantOptionDataPopulator.class);

	private TypeService typeService;
	private MediaService mediaService;
	private MediaContainerService mediaContainerService;
	private ImageFormatMapping imageFormatMapping;
	private Map<String, String> variantAttributeMapping;

	@Override
	public void populate(final VariantProductModel source, final VariantOptionData target)
	{
		super.populate(source, target);

		final MediaContainerModel mediaContainer = getPrimaryImageMediaContainer(source);
		if (mediaContainer != null)
		{
			final ComposedTypeModel productType = getTypeService().getComposedTypeForClass(source.getClass());
			for (final VariantOptionQualifierData variantOptionQualifier : target.getVariantOptionQualifiers())
			{
				final MediaModel media = getMediaWithImageFormat(mediaContainer, lookupImageFormat(productType, variantOptionQualifier.getQualifier()));
				if (media != null)
				{
					variantOptionQualifier.setImage(getImageConverter().convert(media));
				}
			}
		}
	}

	protected MediaModel getMediaWithImageFormat(final MediaContainerModel mediaContainer, final String imageFormat)
	{
		if (mediaContainer != null && imageFormat != null)
		{
			return getMediaWithImageFormatImmediately(mediaContainer, imageFormat);
		}
		return null;
	}

	private MediaModel getMediaWithImageFormatImmediately(final MediaContainerModel mediaContainer, final String imageFormat)
	{
		final String mediaFormatQualifier = getImageFormatMapping().getMediaFormatQualifierForImageFormat(imageFormat);
		if (mediaFormatQualifier != null)
		{
			final MediaFormatModel mediaFormat = getMediaService().getFormat(mediaFormatQualifier);
			if (mediaFormat != null)
			{
				try{
					return getMediaContainerService().getMediaForFormat(mediaContainer, mediaFormat);
				}
				catch (ModelNotFoundException e)
				{
					LOG.debug("No media found using media container {} and image format {}", mediaContainer, imageFormat);
				}
			}
		}
		return null;
	}

	protected String lookupImageFormat(final ComposedTypeModel productType, final String attributeQualifier)
	{
		if (productType == null)
		{
			return null;
		}

		// Lookup the image format mapping
		final String key = productType.getCode() + "." + attributeQualifier;
		final String imageFormat = getVariantAttributeMapping().get(key);

		// Try super type of not found for this type
		return imageFormat != null ? imageFormat : lookupImageFormat(productType.getSuperType(), attributeQualifier);
	}

	protected MediaContainerModel getPrimaryImageMediaContainer(final VariantProductModel variantProductModel)
	{
		final MediaModel picture = variantProductModel.getPicture();
		if (picture != null)
		{
			return picture.getMediaContainer();
		}
		return null;
	}


	protected TypeService getTypeService()
	{
		return typeService;
	}

	@Required
	public void setTypeService(final TypeService typeService)
	{
		this.typeService = typeService;
	}

	protected MediaService getMediaService()
	{
		return mediaService;
	}

	@Required
	public void setMediaService(final MediaService mediaService)
	{
		this.mediaService = mediaService;
	}

	protected MediaContainerService getMediaContainerService()
	{
		return mediaContainerService;
	}

	@Required
	public void setMediaContainerService(final MediaContainerService mediaContainerService)
	{
		this.mediaContainerService = mediaContainerService;
	}

	protected ImageFormatMapping getImageFormatMapping()
	{
		return imageFormatMapping;
	}

	@Required
	public void setImageFormatMapping(final ImageFormatMapping imageFormatMapping)
	{
		this.imageFormatMapping = imageFormatMapping;
	}

	protected Map<String, String> getVariantAttributeMapping()
	{
		return variantAttributeMapping;
	}

	@Required
	public void setVariantAttributeMapping(final Map<String, String> variantAttributeMapping)
	{
		this.variantAttributeMapping = variantAttributeMapping;
	}
}
