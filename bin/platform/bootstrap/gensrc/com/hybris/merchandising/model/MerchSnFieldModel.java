/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 12, 2025, 10:11:41 AM                   ---
 * ----------------------------------------------------------------
 */
package com.hybris.merchandising.model;

import com.hybris.merchandising.model.MerchSnConfigModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.searchservices.model.SnFieldModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type MerchSnField first defined at extension merchandisingservices.
 * <p>
 * Merchandising field mapping.
 */
@SuppressWarnings("all")
public class MerchSnFieldModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MerchSnField";
	
	/**<i>Generated relation code constant for relation <code>MerchSnConfig2MerchSnField</code> defining source attribute <code>merchSnConfig</code> in extension <code>merchandisingservices</code>.</i>*/
	public static final String _MERCHSNCONFIG2MERCHSNFIELD = "MerchSnConfig2MerchSnField";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnField.indexedField</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String INDEXEDFIELD = "indexedField";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnField.merchMappedName</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String MERCHMAPPEDNAME = "merchMappedName";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnField.merchSnConfigPOS</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String MERCHSNCONFIGPOS = "merchSnConfigPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnField.merchSnConfig</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String MERCHSNCONFIG = "merchSnConfig";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MerchSnFieldModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MerchSnFieldModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _indexedField initial attribute declared by type <code>MerchSnField</code> at extension <code>merchandisingservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MerchSnFieldModel(final SnFieldModel _indexedField)
	{
		super();
		setIndexedField(_indexedField);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _indexedField initial attribute declared by type <code>MerchSnField</code> at extension <code>merchandisingservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MerchSnFieldModel(final SnFieldModel _indexedField, final ItemModel _owner)
	{
		super();
		setIndexedField(_indexedField);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnField.indexedField</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the indexedField - Unique identifier
	 */
	@Accessor(qualifier = "indexedField", type = Accessor.Type.GETTER)
	public SnFieldModel getIndexedField()
	{
		return getPersistenceContext().getPropertyValue(INDEXEDFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnField.merchMappedName</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the merchMappedName - Mapped property name
	 */
	@Accessor(qualifier = "merchMappedName", type = Accessor.Type.GETTER)
	public String getMerchMappedName()
	{
		return getPersistenceContext().getPropertyValue(MERCHMAPPEDNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnField.merchSnConfig</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the merchSnConfig
	 */
	@Accessor(qualifier = "merchSnConfig", type = Accessor.Type.GETTER)
	public MerchSnConfigModel getMerchSnConfig()
	{
		return getPersistenceContext().getPropertyValue(MERCHSNCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnField.indexedField</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the indexedField - Unique identifier
	 */
	@Accessor(qualifier = "indexedField", type = Accessor.Type.SETTER)
	public void setIndexedField(final SnFieldModel value)
	{
		getPersistenceContext().setPropertyValue(INDEXEDFIELD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnField.merchMappedName</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the merchMappedName - Mapped property name
	 */
	@Accessor(qualifier = "merchMappedName", type = Accessor.Type.SETTER)
	public void setMerchMappedName(final String value)
	{
		getPersistenceContext().setPropertyValue(MERCHMAPPEDNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnField.merchSnConfig</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the merchSnConfig
	 */
	@Accessor(qualifier = "merchSnConfig", type = Accessor.Type.SETTER)
	public void setMerchSnConfig(final MerchSnConfigModel value)
	{
		getPersistenceContext().setPropertyValue(MERCHSNCONFIG, value);
	}
	
}
