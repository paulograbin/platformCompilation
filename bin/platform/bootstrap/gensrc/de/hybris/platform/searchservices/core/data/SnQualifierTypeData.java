/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.core.data;

import java.io.Serializable;
import de.hybris.platform.searchservices.core.data.SnQualifierData;
import java.util.List;


import java.util.Objects;
public  class SnQualifierTypeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SnQualifierTypeData.id</code> property defined at extension <code>searchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SnQualifierTypeData.qualifiers</code> property defined at extension <code>searchservices</code>. */
	
	private List<SnQualifierData> qualifiers;
	
	public SnQualifierTypeData()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setQualifiers(final List<SnQualifierData> qualifiers)
	{
		this.qualifiers = qualifiers;
	}

	public List<SnQualifierData> getQualifiers() 
	{
		return qualifiers;
	}
	

}