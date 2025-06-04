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
 * Principal DTO
 */
@Schema(name="PermissionsPrincipal", description="Principal DTO")
public  class PermissionsPrincipalWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Principal identifier<br/><br/><i>Generated property</i> for <code>PermissionsPrincipalWsDTO.principalUid</code> property defined at extension <code>permissionswebservices</code>. */
@Schema(name="principalUid", description="Principal identifier", required=true) 	
	private String principalUid;
	
	public PermissionsPrincipalWsDTO()
	{
		// default constructor
	}
	
	public void setPrincipalUid(final String principalUid)
	{
		this.principalUid = principalUid;
	}

	public String getPrincipalUid() 
	{
		return principalUid;
	}
	

}