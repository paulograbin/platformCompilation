/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Sync permission
 */
@Schema(name="SyncPermissions", description="Sync permission")
public  class SyncPermissionsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncPermissionsWsDTO.targetCatalogVersion</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="targetCatalogVersion") 	
	private String targetCatalogVersion;

	/** <i>Generated property</i> for <code>SyncPermissionsWsDTO.canSynchronize</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="canSynchronize") 	
	private boolean canSynchronize;
	
	public SyncPermissionsWsDTO()
	{
		// default constructor
	}
	
	public void setTargetCatalogVersion(final String targetCatalogVersion)
	{
		this.targetCatalogVersion = targetCatalogVersion;
	}

	public String getTargetCatalogVersion() 
	{
		return targetCatalogVersion;
	}
	
	public void setCanSynchronize(final boolean canSynchronize)
	{
		this.canSynchronize = canSynchronize;
	}

	public boolean isCanSynchronize() 
	{
		return canSynchronize;
	}
	

}