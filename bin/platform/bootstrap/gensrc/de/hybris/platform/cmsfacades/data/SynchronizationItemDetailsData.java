/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.core.model.ItemModel;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class SynchronizationItemDetailsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.item</code> property defined at extension <code>cmsfacades</code>. */
	
	private ItemModel item;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.catalogId</code> property defined at extension <code>cmsfacades</code>. */
	
	private String catalogId;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.sourceVersionId</code> property defined at extension <code>cmsfacades</code>. */
	
	private String sourceVersionId;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.targetVersionId</code> property defined at extension <code>cmsfacades</code>. */
	
	private String targetVersionId;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.syncStatus</code> property defined at extension <code>cmsfacades</code>. */
	
	private String syncStatus;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.lastSyncStatusDate</code> property defined at extension <code>cmsfacades</code>. */
	
	private Date lastSyncStatusDate;

	/** <i>Generated property</i> for <code>SynchronizationItemDetailsData.relatedItemStatuses</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<SyncItemInfoJobStatusData> relatedItemStatuses;
	
	public SynchronizationItemDetailsData()
	{
		// default constructor
	}
	
	public void setItem(final ItemModel item)
	{
		this.item = item;
	}

	public ItemModel getItem() 
	{
		return item;
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
	
	public void setSyncStatus(final String syncStatus)
	{
		this.syncStatus = syncStatus;
	}

	public String getSyncStatus() 
	{
		return syncStatus;
	}
	
	public void setLastSyncStatusDate(final Date lastSyncStatusDate)
	{
		this.lastSyncStatusDate = lastSyncStatusDate;
	}

	public Date getLastSyncStatusDate() 
	{
		return lastSyncStatusDate;
	}
	
	public void setRelatedItemStatuses(final List<SyncItemInfoJobStatusData> relatedItemStatuses)
	{
		this.relatedItemStatuses = relatedItemStatuses;
	}

	public List<SyncItemInfoJobStatusData> getRelatedItemStatuses() 
	{
		return relatedItemStatuses;
	}
	

}