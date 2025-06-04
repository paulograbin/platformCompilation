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
import de.hybris.platform.sap.productconfig.occ.FilterDataWsDTO;
import de.hybris.platform.sap.productconfig.occ.GroupOverviewWsDTO;
import de.hybris.platform.sap.productconfig.occ.PriceSummaryWsDTO;
import de.hybris.platform.sap.productconfig.occ.ProductConfigMessageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a product configuration overview, a condensed read-only view of a product configuration. Contains only the selected values.
 */
@Schema(name="CCPConfigurationOverview", description="Representation of a product configuration overview, a condensed read-only view of a product configuration. Contains only the selected values.")
public  class ConfigurationOverviewWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Identifier of document that owns this configuration. Can be the identifier of a saved cart, a quote, or an order.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.sourceDocumentId</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="sourceDocumentId", description="Identifier of document that owns this configuration. Can be the identifier of a saved cart, a quote, or an order.", example="0001012345") 	
	private String sourceDocumentId;

	/** Configuration Identifier. A randomly generated UUID owned by the product configurator.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.id</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="id", description="Configuration Identifier. A randomly generated UUID owned by the product configurator.", example="ee520001-3e9a-4321-acc8-b92783c8ca4e") 	
	private String id;

	/** Product code of configuration's root product.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.productCode</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="productCode", description="Product code of configuration's root product.", example="CONF_LAPTOP") 	
	private String productCode;

	/** Total number of issues: sum of number of conflicts and number of incomplete mandatory fields.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.totalNumberOfIssues</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="totalNumberOfIssues", description="Total number of issues: sum of number of conflicts and number of incomplete mandatory fields.", example="1") 	
	private int totalNumberOfIssues;

	/** Total number of incomplete attributes.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.numberOfIncompleteCharacteristics</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="numberOfIncompleteCharacteristics", description="Total number of incomplete attributes.", example="1") 	
	private int numberOfIncompleteCharacteristics;

	/** Total number of conflicts.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.numberOfConflicts</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="numberOfConflicts", description="Total number of conflicts.", example="1") 	
	private int numberOfConflicts;

	/** For filtering the configuration overview according to attribute facets such as price relevance or attribute author.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.appliedCsticFilter</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="appliedCsticFilter", description="For filtering the configuration overview according to attribute facets such as price relevance or attribute author.") 	
	private List<FilterDataWsDTO> appliedCsticFilter;

	/** For filtering the configuration overview according to the UI groups.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.groupFilterList</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="groupFilterList", description="For filtering the configuration overview according to the UI groups.") 	
	private List<FilterDataWsDTO> groupFilterList;

	/** Configuration overview groups.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.groups</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="groups", description="Configuration overview groups.") 	
	private List<GroupOverviewWsDTO> groups;

	/** Price summary.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.pricing</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="pricing", description="Price summary.") 	
	private PriceSummaryWsDTO pricing;

	/** Pricing is enabled, meaning that pricing related APIs are called and prices are shown during configuration.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.pricingEnabled</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="pricingEnabled", description="Pricing is enabled, meaning that pricing related APIs are called and prices are shown during configuration.", example="true") 	
	private boolean pricingEnabled;

	/** Message list.<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.messages</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="messages", description="Message list.") 	
	private List<ProductConfigMessageWsDTO> messages;
	
	public ConfigurationOverviewWsDTO()
	{
		// default constructor
	}
	
	public void setSourceDocumentId(final String sourceDocumentId)
	{
		this.sourceDocumentId = sourceDocumentId;
	}

	public String getSourceDocumentId() 
	{
		return sourceDocumentId;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setTotalNumberOfIssues(final int totalNumberOfIssues)
	{
		this.totalNumberOfIssues = totalNumberOfIssues;
	}

	public int getTotalNumberOfIssues() 
	{
		return totalNumberOfIssues;
	}
	
	public void setNumberOfIncompleteCharacteristics(final int numberOfIncompleteCharacteristics)
	{
		this.numberOfIncompleteCharacteristics = numberOfIncompleteCharacteristics;
	}

	public int getNumberOfIncompleteCharacteristics() 
	{
		return numberOfIncompleteCharacteristics;
	}
	
	public void setNumberOfConflicts(final int numberOfConflicts)
	{
		this.numberOfConflicts = numberOfConflicts;
	}

	public int getNumberOfConflicts() 
	{
		return numberOfConflicts;
	}
	
	public void setAppliedCsticFilter(final List<FilterDataWsDTO> appliedCsticFilter)
	{
		this.appliedCsticFilter = appliedCsticFilter;
	}

	public List<FilterDataWsDTO> getAppliedCsticFilter() 
	{
		return appliedCsticFilter;
	}
	
	public void setGroupFilterList(final List<FilterDataWsDTO> groupFilterList)
	{
		this.groupFilterList = groupFilterList;
	}

	public List<FilterDataWsDTO> getGroupFilterList() 
	{
		return groupFilterList;
	}
	
	public void setGroups(final List<GroupOverviewWsDTO> groups)
	{
		this.groups = groups;
	}

	public List<GroupOverviewWsDTO> getGroups() 
	{
		return groups;
	}
	
	public void setPricing(final PriceSummaryWsDTO pricing)
	{
		this.pricing = pricing;
	}

	public PriceSummaryWsDTO getPricing() 
	{
		return pricing;
	}
	
	public void setPricingEnabled(final boolean pricingEnabled)
	{
		this.pricingEnabled = pricingEnabled;
	}

	public boolean isPricingEnabled() 
	{
		return pricingEnabled;
	}
	
	public void setMessages(final List<ProductConfigMessageWsDTO> messages)
	{
		this.messages = messages;
	}

	public List<ProductConfigMessageWsDTO> getMessages() 
	{
		return messages;
	}
	

}