/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.ActionData;
import de.hybris.platform.personalizationfacades.data.CustomizationData;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import de.hybris.platform.personalizationfacades.enums.ItemStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Variation
 */
@Schema(name="variation", description="Variation")
public  class VariationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Variation code<br/><br/><i>Generated property</i> for <code>VariationData.code</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="code", description="Variation code") 	
	private String code;

	/** Variation name<br/><br/><i>Generated property</i> for <code>VariationData.name</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="name", description="Variation name") 	
	private String name;

	/** Dynamic attribute describing whether the variation affects the experience<br/><br/><i>Generated property</i> for <code>VariationData.active</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="active", description="Dynamic attribute describing whether the variation affects the experience") 	
	private Boolean active;

	/** This is deprecated field (use status field instead)<br/><br/><i>Generated property</i> for <code>VariationData.enabled</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="enabled", description="This is deprecated field (use status field instead)") 	
	private Boolean enabled;

	/** Priority of the variation<br/><br/><i>Generated property</i> for <code>VariationData.rank</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="rank", description="Priority of the variation") 	
	private Integer rank;

	/** Status of the variation<br/><br/><i>Generated property</i> for <code>VariationData.status</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="status", description="Status of the variation", allowableValues="ENABLED,DISABLED,DELETED") 	
	private ItemStatus status;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>VariationData.catalog</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="catalog", description="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>VariationData.catalogVersion</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="catalogVersion", description="Catalog version") 	
	private String catalogVersion;

	/** Details of the customization the variation belongs to<br/><br/><i>Generated property</i> for <code>VariationData.customization</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="customization", description="Details of the customization the variation belongs to") 	
	private CustomizationData customization;

	/** Details of the variation triggers<br/><br/><i>Generated property</i> for <code>VariationData.triggers</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="triggers", description="Details of the variation triggers") 	
	private List<TriggerData> triggers;

	/** Details of the variation actions<br/><br/><i>Generated property</i> for <code>VariationData.actions</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="actions", description="Details of the variation actions") 	
	private List<ActionData> actions;
	
	public VariationData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	/**
	 * @deprecated Use status field instead
	 */
	@Deprecated(since = "6.5", forRemoval = true)
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}

	/**
	 * @deprecated Use status field instead
	 */
	@Deprecated(since = "6.5", forRemoval = true)
	public Boolean getEnabled() 
	{
		return enabled;
	}
	
	public void setRank(final Integer rank)
	{
		this.rank = rank;
	}

	public Integer getRank() 
	{
		return rank;
	}
	
	public void setStatus(final ItemStatus status)
	{
		this.status = status;
	}

	public ItemStatus getStatus() 
	{
		return status;
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
	
	public void setCustomization(final CustomizationData customization)
	{
		this.customization = customization;
	}

	public CustomizationData getCustomization() 
	{
		return customization;
	}
	
	public void setTriggers(final List<TriggerData> triggers)
	{
		this.triggers = triggers;
	}

	public List<TriggerData> getTriggers() 
	{
		return triggers;
	}
	
	public void setActions(final List<ActionData> actions)
	{
		this.actions = actions;
	}

	public List<ActionData> getActions() 
	{
		return actions;
	}
	

}