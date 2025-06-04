/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of knowledge base key and administrative data.
 */
@Schema(name="CCPKBData", description="Representation of knowledge base key and administrative data.")
public  class KBWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Knowledge base name.<br/><br/><i>Generated property</i> for <code>KBWsDTO.kbName</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="kbName", description="Knowledge base name.", example="KB_CONF_LAPTOP") 	
	private String kbName;

	/** Logical system identifier of source system.<br/><br/><i>Generated property</i> for <code>KBWsDTO.kbLogsys</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="kbLogsys", description="Logical system identifier of source system.", example="YXZCLNT200") 	
	private String kbLogsys;

	/** Knowledge base version.<br/><br/><i>Generated property</i> for <code>KBWsDTO.kbVersion</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="kbVersion", description="Knowledge base version.", example="1.0") 	
	private String kbVersion;

	/** Knowledge base build number.<br/><br/><i>Generated property</i> for <code>KBWsDTO.kbBuildNumber</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="kbBuildNumber", description="Knowledge base build number.", example="23") 	
	private String kbBuildNumber;
	
	public KBWsDTO()
	{
		// default constructor
	}
	
	public void setKbName(final String kbName)
	{
		this.kbName = kbName;
	}

	public String getKbName() 
	{
		return kbName;
	}
	
	public void setKbLogsys(final String kbLogsys)
	{
		this.kbLogsys = kbLogsys;
	}

	public String getKbLogsys() 
	{
		return kbLogsys;
	}
	
	public void setKbVersion(final String kbVersion)
	{
		this.kbVersion = kbVersion;
	}

	public String getKbVersion() 
	{
		return kbVersion;
	}
	
	public void setKbBuildNumber(final String kbBuildNumber)
	{
		this.kbBuildNumber = kbBuildNumber;
	}

	public String getKbBuildNumber() 
	{
		return kbBuildNumber;
	}
	

}