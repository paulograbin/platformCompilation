/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationcmsweb.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * cxCmsComponentContainer details
 */
@Schema(name="cxCmsComponentContainer", description="cxCmsComponentContainer details")
public  class CxCmsComponentContainerData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Unique ID of the container<br/><br/><i>Generated property</i> for <code>CxCmsComponentContainerData.uid</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="uid", description="Unique ID of the container") 	
	private String uid;

	/** ID of the original container shared across catalog hierarchy<br/><br/><i>Generated property</i> for <code>CxCmsComponentContainerData.sourceId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="sourceId", description="ID of the original container shared across catalog hierarchy") 	
	private String sourceId;

	/** ID of the container's default component<br/><br/><i>Generated property</i> for <code>CxCmsComponentContainerData.defaultComponentUid</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="defaultComponentUid", description="ID of the container's default component") 	
	private String defaultComponentUid;
	
	public CxCmsComponentContainerData()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setSourceId(final String sourceId)
	{
		this.sourceId = sourceId;
	}

	public String getSourceId() 
	{
		return sourceId;
	}
	
	public void setDefaultComponentUid(final String defaultComponentUid)
	{
		this.defaultComponentUid = defaultComponentUid;
	}

	public String getDefaultComponentUid() 
	{
		return defaultComponentUid;
	}
	

}