/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


import java.util.Objects;
public  class AbstractCMSComponentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.modifiedtime</code> property defined at extension <code>cmsfacades</code>. */
	
	private Date modifiedtime;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.uid</code> property defined at extension <code>cmsfacades</code>. */
	
	private String uid;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.name</code> property defined at extension <code>cmsfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.typeCode</code> property defined at extension <code>cmsfacades</code>. */
	
	private String typeCode;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.catalogVersion</code> property defined at extension <code>cmsfacades</code>. */
	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.otherProperties</code> property defined at extension <code>cmsfacades</code>. */
	
	private Map<String, Object> otherProperties;

	/** <i>Generated property</i> for <code>AbstractCMSComponentData.uuid</code> property defined at extension <code>cmsfacades</code>. */
	
	private String uuid;
	
	public AbstractCMSComponentData()
	{
		// default constructor
	}
	
	public void setModifiedtime(final Date modifiedtime)
	{
		this.modifiedtime = modifiedtime;
	}

	public Date getModifiedtime() 
	{
		return modifiedtime;
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setOtherProperties(final Map<String, Object> otherProperties)
	{
		this.otherProperties = otherProperties;
	}

	public Map<String, Object> getOtherProperties() 
	{
		return otherProperties;
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	

}