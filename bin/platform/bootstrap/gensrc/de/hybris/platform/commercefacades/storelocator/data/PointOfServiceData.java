/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.storelocator.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.storelocator.data.OpeningScheduleData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commerceservices.store.data.GeoPoint;
import java.util.Collection;
import java.util.List;
import java.util.Map;


import java.util.Objects;
public  class PointOfServiceData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PointOfServiceData.name</code> property defined at extension <code>commercefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>PointOfServiceData.displayName</code> property defined at extension <code>commercefacades</code>. */
	
	private String displayName;

	/** <i>Generated property</i> for <code>PointOfServiceData.url</code> property defined at extension <code>commercefacades</code>. */
	
	private String url;

	/** <i>Generated property</i> for <code>PointOfServiceData.description</code> property defined at extension <code>commercefacades</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>PointOfServiceData.openingHours</code> property defined at extension <code>commercefacades</code>. */
	
	private OpeningScheduleData openingHours;

	/** <i>Generated property</i> for <code>PointOfServiceData.storeContent</code> property defined at extension <code>commercefacades</code>. */
	
	private String storeContent;

	/** <i>Generated property</i> for <code>PointOfServiceData.features</code> property defined at extension <code>commercefacades</code>. */
	
	private Map<String, String> features;

	/** <i>Generated property</i> for <code>PointOfServiceData.geoPoint</code> property defined at extension <code>commercefacades</code>. */
	
	private GeoPoint geoPoint;

	/** <i>Generated property</i> for <code>PointOfServiceData.formattedDistance</code> property defined at extension <code>commercefacades</code>. */
	
	private String formattedDistance;

	/** <i>Generated property</i> for <code>PointOfServiceData.distanceKm</code> property defined at extension <code>commercefacades</code>. */
	
	private Double distanceKm;

	/** <i>Generated property</i> for <code>PointOfServiceData.mapIcon</code> property defined at extension <code>commercefacades</code>. */
	
	private ImageData mapIcon;

	/** <i>Generated property</i> for <code>PointOfServiceData.address</code> property defined at extension <code>commercefacades</code>. */
	
	private AddressData address;

	/** <i>Generated property</i> for <code>PointOfServiceData.storeImages</code> property defined at extension <code>commercefacades</code>. */
	
	private Collection<ImageData> storeImages;

	/** <i>Generated property</i> for <code>PointOfServiceData.pickUpInStoreInstructions</code> property defined at extension <code>commercefacades</code>. */
	
	private String pickUpInStoreInstructions;

	/** <i>Generated property</i> for <code>PointOfServiceData.warehouseCodes</code> property defined at extension <code>warehousingfacades</code>. */
	
	private List<String> warehouseCodes;
	
	public PointOfServiceData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDisplayName(final String displayName)
	{
		this.displayName = displayName;
	}

	public String getDisplayName() 
	{
		return displayName;
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setOpeningHours(final OpeningScheduleData openingHours)
	{
		this.openingHours = openingHours;
	}

	public OpeningScheduleData getOpeningHours() 
	{
		return openingHours;
	}
	
	public void setStoreContent(final String storeContent)
	{
		this.storeContent = storeContent;
	}

	public String getStoreContent() 
	{
		return storeContent;
	}
	
	public void setFeatures(final Map<String, String> features)
	{
		this.features = features;
	}

	public Map<String, String> getFeatures() 
	{
		return features;
	}
	
	public void setGeoPoint(final GeoPoint geoPoint)
	{
		this.geoPoint = geoPoint;
	}

	public GeoPoint getGeoPoint() 
	{
		return geoPoint;
	}
	
	public void setFormattedDistance(final String formattedDistance)
	{
		this.formattedDistance = formattedDistance;
	}

	public String getFormattedDistance() 
	{
		return formattedDistance;
	}
	
	public void setDistanceKm(final Double distanceKm)
	{
		this.distanceKm = distanceKm;
	}

	public Double getDistanceKm() 
	{
		return distanceKm;
	}
	
	public void setMapIcon(final ImageData mapIcon)
	{
		this.mapIcon = mapIcon;
	}

	public ImageData getMapIcon() 
	{
		return mapIcon;
	}
	
	public void setAddress(final AddressData address)
	{
		this.address = address;
	}

	public AddressData getAddress() 
	{
		return address;
	}
	
	public void setStoreImages(final Collection<ImageData> storeImages)
	{
		this.storeImages = storeImages;
	}

	public Collection<ImageData> getStoreImages() 
	{
		return storeImages;
	}
	
	public void setPickUpInStoreInstructions(final String pickUpInStoreInstructions)
	{
		this.pickUpInStoreInstructions = pickUpInStoreInstructions;
	}

	public String getPickUpInStoreInstructions() 
	{
		return pickUpInStoreInstructions;
	}
	
	public void setWarehouseCodes(final List<String> warehouseCodes)
	{
		this.warehouseCodes = warehouseCodes;
	}

	public List<String> getWarehouseCodes() 
	{
		return warehouseCodes;
	}
	

}