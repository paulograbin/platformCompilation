/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.spi.data;

import java.io.Serializable;
import de.hybris.platform.searchservices.admin.data.SnIndexConfiguration;
import de.hybris.platform.searchservices.admin.data.SnIndexType;
import de.hybris.platform.searchservices.admin.data.SnSynonymDictionary;
import de.hybris.platform.searchservices.core.data.SnQualifierTypeData;
import java.util.List;


import java.util.Objects;
public  class SnExportConfiguration  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SnExportConfiguration.synonymDictionaries</code> property defined at extension <code>searchservices</code>. */
	
	private List<SnSynonymDictionary> synonymDictionaries;

	/** <i>Generated property</i> for <code>SnExportConfiguration.indexConfiguration</code> property defined at extension <code>searchservices</code>. */
	
	private SnIndexConfiguration indexConfiguration;

	/** <i>Generated property</i> for <code>SnExportConfiguration.indexTypes</code> property defined at extension <code>searchservices</code>. */
	
	private List<SnIndexType> indexTypes;

	/** <i>Generated property</i> for <code>SnExportConfiguration.qualifiers</code> property defined at extension <code>searchservices</code>. */
	
	private List<SnQualifierTypeData> qualifiers;
	
	public SnExportConfiguration()
	{
		// default constructor
	}
	
	public void setSynonymDictionaries(final List<SnSynonymDictionary> synonymDictionaries)
	{
		this.synonymDictionaries = synonymDictionaries;
	}

	public List<SnSynonymDictionary> getSynonymDictionaries() 
	{
		return synonymDictionaries;
	}
	
	public void setIndexConfiguration(final SnIndexConfiguration indexConfiguration)
	{
		this.indexConfiguration = indexConfiguration;
	}

	public SnIndexConfiguration getIndexConfiguration() 
	{
		return indexConfiguration;
	}
	
	public void setIndexTypes(final List<SnIndexType> indexTypes)
	{
		this.indexTypes = indexTypes;
	}

	public List<SnIndexType> getIndexTypes() 
	{
		return indexTypes;
	}
	
	public void setQualifiers(final List<SnQualifierTypeData> qualifiers)
	{
		this.qualifiers = qualifiers;
	}

	public List<SnQualifierTypeData> getQualifiers() 
	{
		return qualifiers;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final SnExportConfiguration other = (SnExportConfiguration) o;
		return Objects.equals(getSynonymDictionaries(), other.getSynonymDictionaries())

			&& Objects.equals(getIndexConfiguration(), other.getIndexConfiguration())

			&& Objects.equals(getIndexTypes(), other.getIndexTypes())

			&& Objects.equals(getQualifiers(), other.getQualifiers());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = synonymDictionaries;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexConfiguration;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexTypes;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = qualifiers;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}