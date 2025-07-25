/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.FeatureUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.FeatureValueWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of a Feature
 */
@Schema(name="Feature", description="Representation of a Feature")
public  class FeatureWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the feature<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the feature") 	
	private String code;

	/** Name of the feature<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the feature") 	
	private String name;

	/** Description of the feature<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the feature") 	
	private String description;

	/** Type of the feature<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.type</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="type", description="Type of the feature") 	
	private String type;

	/** Range number of the feature<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.range</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="range", description="Range number of the feature") 	
	private Boolean range;

	/** Flag defining it feature is comparable<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.comparable</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="comparable", description="Flag defining it feature is comparable") 	
	private Boolean comparable;

	/** Feature unit<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.featureUnit</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="featureUnit", description="Feature unit") 	
	private FeatureUnitWsDTO featureUnit;

	/** List of feature values<br/><br/><i>Generated property</i> for <code>FeatureWsDTO.featureValues</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="featureValues", description="List of feature values") 	
	private Collection<FeatureValueWsDTO> featureValues;
	
	public FeatureWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setRange(final Boolean range)
	{
		this.range = range;
	}

	public Boolean getRange() 
	{
		return range;
	}
	
	public void setComparable(final Boolean comparable)
	{
		this.comparable = comparable;
	}

	public Boolean getComparable() 
	{
		return comparable;
	}
	
	public void setFeatureUnit(final FeatureUnitWsDTO featureUnit)
	{
		this.featureUnit = featureUnit;
	}

	public FeatureUnitWsDTO getFeatureUnit() 
	{
		return featureUnit;
	}
	
	public void setFeatureValues(final Collection<FeatureValueWsDTO> featureValues)
	{
		this.featureValues = featureValues;
	}

	public Collection<FeatureValueWsDTO> getFeatureValues() 
	{
		return featureValues;
	}
	

}