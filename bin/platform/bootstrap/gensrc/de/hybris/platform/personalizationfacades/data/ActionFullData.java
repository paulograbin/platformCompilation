/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Action Full Data
 */
@Schema(name="action", description="Action Full Data")
public  class ActionFullData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ActionFullData.customizationCode</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="customizationCode") 	
	private String customizationCode;

	/** <i>Generated property</i> for <code>ActionFullData.customizationName</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="customizationName") 	
	private String customizationName;

	/** <i>Generated property</i> for <code>ActionFullData.customizationStatus</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="customizationStatus") 	
	private String customizationStatus;

	/** <i>Generated property</i> for <code>ActionFullData.customizationRank</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="customizationRank") 	
	private Integer customizationRank;

	/** <i>Generated property</i> for <code>ActionFullData.variationCode</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="variationCode") 	
	private String variationCode;

	/** <i>Generated property</i> for <code>ActionFullData.variationName</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="variationName") 	
	private String variationName;

	/** <i>Generated property</i> for <code>ActionFullData.variationStatus</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="variationStatus") 	
	private String variationStatus;

	/** <i>Generated property</i> for <code>ActionFullData.variationRank</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="variationRank") 	
	private Integer variationRank;

	/** <i>Generated property</i> for <code>ActionFullData.actionCode</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="actionCode") 	
	private String actionCode;

	/** <i>Generated property</i> for <code>ActionFullData.actionCatalog</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="actionCatalog") 	
	private String actionCatalog;

	/** <i>Generated property</i> for <code>ActionFullData.actionCatalogVersion</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="actionCatalogVersion") 	
	private String actionCatalogVersion;

	/** <i>Generated property</i> for <code>ActionFullData.actionRank</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="actionRank") 	
	private Integer actionRank;
	
	public ActionFullData()
	{
		// default constructor
	}
	
	public void setCustomizationCode(final String customizationCode)
	{
		this.customizationCode = customizationCode;
	}

	public String getCustomizationCode() 
	{
		return customizationCode;
	}
	
	public void setCustomizationName(final String customizationName)
	{
		this.customizationName = customizationName;
	}

	public String getCustomizationName() 
	{
		return customizationName;
	}
	
	public void setCustomizationStatus(final String customizationStatus)
	{
		this.customizationStatus = customizationStatus;
	}

	public String getCustomizationStatus() 
	{
		return customizationStatus;
	}
	
	public void setCustomizationRank(final Integer customizationRank)
	{
		this.customizationRank = customizationRank;
	}

	public Integer getCustomizationRank() 
	{
		return customizationRank;
	}
	
	public void setVariationCode(final String variationCode)
	{
		this.variationCode = variationCode;
	}

	public String getVariationCode() 
	{
		return variationCode;
	}
	
	public void setVariationName(final String variationName)
	{
		this.variationName = variationName;
	}

	public String getVariationName() 
	{
		return variationName;
	}
	
	public void setVariationStatus(final String variationStatus)
	{
		this.variationStatus = variationStatus;
	}

	public String getVariationStatus() 
	{
		return variationStatus;
	}
	
	public void setVariationRank(final Integer variationRank)
	{
		this.variationRank = variationRank;
	}

	public Integer getVariationRank() 
	{
		return variationRank;
	}
	
	public void setActionCode(final String actionCode)
	{
		this.actionCode = actionCode;
	}

	public String getActionCode() 
	{
		return actionCode;
	}
	
	public void setActionCatalog(final String actionCatalog)
	{
		this.actionCatalog = actionCatalog;
	}

	public String getActionCatalog() 
	{
		return actionCatalog;
	}
	
	public void setActionCatalogVersion(final String actionCatalogVersion)
	{
		this.actionCatalogVersion = actionCatalogVersion;
	}

	public String getActionCatalogVersion() 
	{
		return actionCatalogVersion;
	}
	
	public void setActionRank(final Integer actionRank)
	{
		this.actionRank = actionRank;
	}

	public Integer getActionRank() 
	{
		return actionRank;
	}
	

}