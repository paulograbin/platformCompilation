/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationcmsweb.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * cxCmsActionForContainer details
 */
@Schema(name="cxCmsActionForContainer", description="cxCmsActionForContainer details")
public  class CxCmsActionForContainerData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.catalog</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="catalog", description="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.catalogVersion</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="catalogVersion", description="Catalog version") 	
	private String catalogVersion;

	/** ID of the replacing component<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.newComponentId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="newComponentId", description="ID of the replacing component") 	
	private String newComponentId;

	/** ID of the replaced component<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.oldComponentId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="oldComponentId", description="ID of the replaced component") 	
	private String oldComponentId;

	/** ID of the container<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.containerId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="containerId", description="ID of the container") 	
	private String containerId;

	/** ID of the content slot<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.slotId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="slotId", description="ID of the content slot") 	
	private String slotId;

	/** ID of the variation<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.variationId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="variationId", description="ID of the variation") 	
	private String variationId;

	/** ID of the customization<br/><br/><i>Generated property</i> for <code>CxCmsActionForContainerData.customizationId</code> property defined at extension <code>personalizationcmsweb</code>. */
@Schema(name="customizationId", description="ID of the customization") 	
	private String customizationId;
	
	public CxCmsActionForContainerData()
	{
		// default constructor
	}
	
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}

	public String getCatalog() 
	{
		return catalog;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setNewComponentId(final String newComponentId)
	{
		this.newComponentId = newComponentId;
	}

	public String getNewComponentId() 
	{
		return newComponentId;
	}
	
	public void setOldComponentId(final String oldComponentId)
	{
		this.oldComponentId = oldComponentId;
	}

	public String getOldComponentId() 
	{
		return oldComponentId;
	}
	
	public void setContainerId(final String containerId)
	{
		this.containerId = containerId;
	}

	public String getContainerId() 
	{
		return containerId;
	}
	
	public void setSlotId(final String slotId)
	{
		this.slotId = slotId;
	}

	public String getSlotId() 
	{
		return slotId;
	}
	
	public void setVariationId(final String variationId)
	{
		this.variationId = variationId;
	}

	public String getVariationId() 
	{
		return variationId;
	}
	
	public void setCustomizationId(final String customizationId)
	{
		this.customizationId = customizationId;
	}

	public String getCustomizationId() 
	{
		return customizationId;
	}
	

}