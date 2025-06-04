/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the synchronization requests.
 */
@Schema(name="SyncJobRequestData", description="Specifies properties of the synchronization requests.")
public  class SyncJobRequestData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncJobRequestData.catalogId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>SyncJobRequestData.sourceVersionId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="sourceVersionId", example="Staged") 	
	private String sourceVersionId;

	/** <i>Generated property</i> for <code>SyncJobRequestData.targetVersionId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="targetVersionId", example="Online") 	
	private String targetVersionId;
	
	public SyncJobRequestData()
	{
		// default constructor
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setSourceVersionId(final String sourceVersionId)
	{
		this.sourceVersionId = sourceVersionId;
	}

	public String getSourceVersionId() 
	{
		return sourceVersionId;
	}
	
	public void setTargetVersionId(final String targetVersionId)
	{
		this.targetVersionId = targetVersionId;
	}

	public String getTargetVersionId() 
	{
		return targetVersionId;
	}
	

}