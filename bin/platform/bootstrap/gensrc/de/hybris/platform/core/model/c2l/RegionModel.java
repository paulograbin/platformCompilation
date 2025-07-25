/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core.model.c2l;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.addressservices.model.CityModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.C2LItemModel;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type Region first defined at extension core.
 */
@SuppressWarnings("all")
public class RegionModel extends C2LItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Region";
	
	/**<i>Generated relation code constant for relation <code>Country2RegionRelation</code> defining source attribute <code>country</code> in extension <code>core</code>.</i>*/
	public static final String _COUNTRY2REGIONRELATION = "Country2RegionRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>Region.country</code> attribute defined at extension <code>core</code>. */
	public static final String COUNTRY = "country";
	
	/** <i>Generated constant</i> - Attribute key of <code>Region.isocodeShort</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String ISOCODESHORT = "isocodeShort";
	
	/** <i>Generated constant</i> - Attribute key of <code>Region.cities</code> attribute defined at extension <code>chineseaddressservices</code>. */
	public static final String CITIES = "cities";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public RegionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public RegionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _country initial attribute declared by type <code>Region</code> at extension <code>core</code>
	 * @param _isocode initial attribute declared by type <code>Region</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public RegionModel(final CountryModel _country, final String _isocode)
	{
		super();
		setCountry(_country);
		setIsocode(_isocode);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _country initial attribute declared by type <code>Region</code> at extension <code>core</code>
	 * @param _isocode initial attribute declared by type <code>Region</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public RegionModel(final CountryModel _country, final String _isocode, final ItemModel _owner)
	{
		super();
		setCountry(_country);
		setIsocode(_isocode);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Region.cities</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the cities
	 */
	@Accessor(qualifier = "cities", type = Accessor.Type.GETTER)
	public List<CityModel> getCities()
	{
		return getPersistenceContext().getPropertyValue(CITIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Region.country</code> attribute defined at extension <code>core</code>. 
	 * @return the country
	 */
	@Accessor(qualifier = "country", type = Accessor.Type.GETTER)
	public CountryModel getCountry()
	{
		return getPersistenceContext().getPropertyValue(COUNTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Region.isocodeShort</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the isocodeShort - 2 character isocode
	 */
	@Accessor(qualifier = "isocodeShort", type = Accessor.Type.GETTER)
	public String getIsocodeShort()
	{
		return getPersistenceContext().getPropertyValue(ISOCODESHORT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Region.cities</code> attribute defined at extension <code>chineseaddressservices</code>. 
	 *  
	 * @param value the cities
	 */
	@Accessor(qualifier = "cities", type = Accessor.Type.SETTER)
	public void setCities(final List<CityModel> value)
	{
		getPersistenceContext().setPropertyValue(CITIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Region.country</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the country
	 */
	@Accessor(qualifier = "country", type = Accessor.Type.SETTER)
	public void setCountry(final CountryModel value)
	{
		getPersistenceContext().setPropertyValue(COUNTRY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Region.isocodeShort</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the isocodeShort - 2 character isocode
	 */
	@Accessor(qualifier = "isocodeShort", type = Accessor.Type.SETTER)
	public void setIsocodeShort(final String value)
	{
		getPersistenceContext().setPropertyValue(ISOCODESHORT, value);
	}
	
}
