/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Specifies properties of the synchronization job.
 */
@Schema(name="SyncJobData", description="Specifies properties of the synchronization job.")
public  class SyncJobData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncJobData.syncStatus</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="syncStatus", example="IN_SYNC") 	
	private String syncStatus;

	/** <i>Generated property</i> for <code>SyncJobData.startDate</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="startDate", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date startDate;

	/** <i>Generated property</i> for <code>SyncJobData.endDate</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="endDate", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date endDate;

	/** <i>Generated property</i> for <code>SyncJobData.creationDate</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="creationDate", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationDate;

	/** <i>Generated property</i> for <code>SyncJobData.lastModifiedDate</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="lastModifiedDate", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date lastModifiedDate;

	/** <i>Generated property</i> for <code>SyncJobData.syncResult</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="syncResult", example="SUCCESS") 	
	private String syncResult;

	/** <i>Generated property</i> for <code>SyncJobData.sourceCatalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="sourceCatalogVersion", example="electronicsContentCatalog/Staged") 	
	private String sourceCatalogVersion;

	/** <i>Generated property</i> for <code>SyncJobData.targetCatalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="targetCatalogVersion", example="electronicsContentCatalog/Online") 	
	private String targetCatalogVersion;

	/** <i>Generated property</i> for <code>SyncJobData.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="ProductPage") 	
	private String code;
	
	public SyncJobData()
	{
		// default constructor
	}
	
	public void setSyncStatus(final String syncStatus)
	{
		this.syncStatus = syncStatus;
	}

	public String getSyncStatus() 
	{
		return syncStatus;
	}
	
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setCreationDate(final Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public Date getCreationDate() 
	{
		return creationDate;
	}
	
	public void setLastModifiedDate(final Date lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getLastModifiedDate() 
	{
		return lastModifiedDate;
	}
	
	public void setSyncResult(final String syncResult)
	{
		this.syncResult = syncResult;
	}

	public String getSyncResult() 
	{
		return syncResult;
	}
	
	public void setSourceCatalogVersion(final String sourceCatalogVersion)
	{
		this.sourceCatalogVersion = sourceCatalogVersion;
	}

	public String getSourceCatalogVersion() 
	{
		return sourceCatalogVersion;
	}
	
	public void setTargetCatalogVersion(final String targetCatalogVersion)
	{
		this.targetCatalogVersion = targetCatalogVersion;
	}

	public String getTargetCatalogVersion() 
	{
		return targetCatalogVersion;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	

}