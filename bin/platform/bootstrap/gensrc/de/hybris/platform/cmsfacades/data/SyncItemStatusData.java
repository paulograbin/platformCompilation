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
import java.util.List;


import java.util.Objects;
public  class SyncItemStatusData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncItemStatusData.itemId</code> property defined at extension <code>cmsfacades</code>. */
	
	private String itemId;

	/** <i>Generated property</i> for <code>SyncItemStatusData.itemType</code> property defined at extension <code>cmsfacades</code>. */
	
	private String itemType;

	/** <i>Generated property</i> for <code>SyncItemStatusData.name</code> property defined at extension <code>cmsfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>SyncItemStatusData.status</code> property defined at extension <code>cmsfacades</code>. */
	
	private String status;

	/** <i>Generated property</i> for <code>SyncItemStatusData.lastSyncStatus</code> property defined at extension <code>cmsfacades</code>. */
	
	private Long lastSyncStatus;

	/** <i>Generated property</i> for <code>SyncItemStatusData.lastModifiedDate</code> property defined at extension <code>cmsfacades</code>. */
	
	private Long lastModifiedDate;

	/** <i>Generated property</i> for <code>SyncItemStatusData.catalogVersionUuid</code> property defined at extension <code>cmsfacades</code>. */
	
	private String catalogVersionUuid;

	/** <i>Generated property</i> for <code>SyncItemStatusData.dependentItemTypesOutOfSync</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<ItemTypeData> dependentItemTypesOutOfSync;

	/** <i>Generated property</i> for <code>SyncItemStatusData.selectedDependencies</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<SyncItemStatusData> selectedDependencies;

	/** <i>Generated property</i> for <code>SyncItemStatusData.sharedDependencies</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<SyncItemStatusData> sharedDependencies;

	/** <i>Generated property</i> for <code>SyncItemStatusData.unavailableDependencies</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<SyncItemStatusData> unavailableDependencies;
	
	public SyncItemStatusData()
	{
		// default constructor
	}
	
	public void setItemId(final String itemId)
	{
		this.itemId = itemId;
	}

	public String getItemId() 
	{
		return itemId;
	}
	
	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

	public String getItemType() 
	{
		return itemType;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setLastSyncStatus(final Long lastSyncStatus)
	{
		this.lastSyncStatus = lastSyncStatus;
	}

	public Long getLastSyncStatus() 
	{
		return lastSyncStatus;
	}
	
	public void setLastModifiedDate(final Long lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getLastModifiedDate() 
	{
		return lastModifiedDate;
	}
	
	public void setCatalogVersionUuid(final String catalogVersionUuid)
	{
		this.catalogVersionUuid = catalogVersionUuid;
	}

	public String getCatalogVersionUuid() 
	{
		return catalogVersionUuid;
	}
	
	public void setDependentItemTypesOutOfSync(final List<ItemTypeData> dependentItemTypesOutOfSync)
	{
		this.dependentItemTypesOutOfSync = dependentItemTypesOutOfSync;
	}

	public List<ItemTypeData> getDependentItemTypesOutOfSync() 
	{
		return dependentItemTypesOutOfSync;
	}
	
	public void setSelectedDependencies(final List<SyncItemStatusData> selectedDependencies)
	{
		this.selectedDependencies = selectedDependencies;
	}

	public List<SyncItemStatusData> getSelectedDependencies() 
	{
		return selectedDependencies;
	}
	
	public void setSharedDependencies(final List<SyncItemStatusData> sharedDependencies)
	{
		this.sharedDependencies = sharedDependencies;
	}

	public List<SyncItemStatusData> getSharedDependencies() 
	{
		return sharedDependencies;
	}
	
	public void setUnavailableDependencies(final List<SyncItemStatusData> unavailableDependencies)
	{
		this.unavailableDependencies = unavailableDependencies;
	}

	public List<SyncItemStatusData> getUnavailableDependencies() 
	{
		return unavailableDependencies;
	}
	

}