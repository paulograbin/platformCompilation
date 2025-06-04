/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.occ.GroupWsDTO;
import de.hybris.platform.sap.productconfig.occ.KBWsDTO;
import de.hybris.platform.sap.productconfig.occ.ProductConfigMessageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a product configuration. Contains the entities that describe a complex product: attributes of different types, groups of attributes, hierarchies of groups, statuses and messages. Typically, the attributes are connected through dependencies.
 */
@Schema(name="CCPConfiguration", description="Representation of a product configuration. Contains the entities that describe a complex product: attributes of different types, groups of attributes, hierarchies of groups, statuses and messages. Typically, the attributes are connected through dependencies.")
public  class ConfigurationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** If active, price components 'base price' and 'selected options' are not provided, only the total price of a configuration is provided.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.hideBasePriceAndSelectedOptions</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="hideBasePriceAndSelectedOptions", description="If active, price components 'base price' and 'selected options' are not provided, only the total price of a configuration is provided.", example="false") 	
	private boolean hideBasePriceAndSelectedOptions;

	/** Configuration Identifier. A randomly generated UUID owned by the product configurator.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.configId</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="configId", description="Configuration Identifier. A randomly generated UUID owned by the product configurator.", example="ee520001-3e9a-4321-acc8-b92783c8ca4e") 	
	private String configId;

	/** Code of the configuration root product.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.rootProduct</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="rootProduct", description="Code of the configuration root product.", example="CONF_LAPTOP") 	
	private String rootProduct;

	/** Configuration is consistent, meaning it contains no conflicts.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.consistent</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="consistent", description="Configuration is consistent, meaning it contains no conflicts.", example="true") 	
	private boolean consistent;

	/** Configuration is complete, meaning each mandatory attribute has been specified.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.complete</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="complete", description="Configuration is complete, meaning each mandatory attribute has been specified.", example="true") 	
	private boolean complete;

	/** Configuration quantity.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.quantity</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="quantity", description="Configuration quantity.", example="1") 	
	private long quantity;

	/** Total number of issues: sum of number of conflicts and number of incomplete mandatory fields.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.totalNumberOfIssues</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="totalNumberOfIssues", description="Total number of issues: sum of number of conflicts and number of incomplete mandatory fields.", example="1") 	
	private int totalNumberOfIssues;

	/** Attribute groups.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.groups</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="groups", description="Attribute groups.") 	
	private List<GroupWsDTO> groups;

	/** Knowledge base (master data) key and administrative data. Only available if configuration is requested in expert mode and user is assigned to group 'sapproductconfigexpmodegroup'.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.kbKey</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="kbKey", description="Knowledge base (master data) key and administrative data. Only available if configuration is requested in expert mode and user is assigned to group 'sapproductconfigexpmodegroup'.") 	
	private KBWsDTO kbKey;

	/** Pricing is enabled, meaning that pricing related APIs are called and prices are shown during configuration.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.pricingEnabled</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="pricingEnabled", description="Pricing is enabled, meaning that pricing related APIs are called and prices are shown during configuration.", example="true") 	
	private boolean pricingEnabled;

	/** Indicates that conflicts need to be resolved immediately, before any other action is taken.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.immediateConflictResolution</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="immediateConflictResolution", description="Indicates that conflicts need to be resolved immediately, before any other action is taken.", example="true") 	
	private boolean immediateConflictResolution;

	/** Message list<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.messages</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="messages", description="Message list") 	
	private List<ProductConfigMessageWsDTO> messages;

	/** Indicates whether the configuration is a new configuration.<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.newConfiguration</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="newConfiguration", description="Indicates whether the configuration is a new configuration.", example="true") 	
	private Boolean newConfiguration;
	
	public ConfigurationWsDTO()
	{
		// default constructor
	}
	
	public void setHideBasePriceAndSelectedOptions(final boolean hideBasePriceAndSelectedOptions)
	{
		this.hideBasePriceAndSelectedOptions = hideBasePriceAndSelectedOptions;
	}

	public boolean isHideBasePriceAndSelectedOptions() 
	{
		return hideBasePriceAndSelectedOptions;
	}
	
	public void setConfigId(final String configId)
	{
		this.configId = configId;
	}

	public String getConfigId() 
	{
		return configId;
	}
	
	public void setRootProduct(final String rootProduct)
	{
		this.rootProduct = rootProduct;
	}

	public String getRootProduct() 
	{
		return rootProduct;
	}
	
	public void setConsistent(final boolean consistent)
	{
		this.consistent = consistent;
	}

	public boolean isConsistent() 
	{
		return consistent;
	}
	
	public void setComplete(final boolean complete)
	{
		this.complete = complete;
	}

	public boolean isComplete() 
	{
		return complete;
	}
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

	public long getQuantity() 
	{
		return quantity;
	}
	
	public void setTotalNumberOfIssues(final int totalNumberOfIssues)
	{
		this.totalNumberOfIssues = totalNumberOfIssues;
	}

	public int getTotalNumberOfIssues() 
	{
		return totalNumberOfIssues;
	}
	
	public void setGroups(final List<GroupWsDTO> groups)
	{
		this.groups = groups;
	}

	public List<GroupWsDTO> getGroups() 
	{
		return groups;
	}
	
	public void setKbKey(final KBWsDTO kbKey)
	{
		this.kbKey = kbKey;
	}

	public KBWsDTO getKbKey() 
	{
		return kbKey;
	}
	
	public void setPricingEnabled(final boolean pricingEnabled)
	{
		this.pricingEnabled = pricingEnabled;
	}

	public boolean isPricingEnabled() 
	{
		return pricingEnabled;
	}
	
	public void setImmediateConflictResolution(final boolean immediateConflictResolution)
	{
		this.immediateConflictResolution = immediateConflictResolution;
	}

	public boolean isImmediateConflictResolution() 
	{
		return immediateConflictResolution;
	}
	
	public void setMessages(final List<ProductConfigMessageWsDTO> messages)
	{
		this.messages = messages;
	}

	public List<ProductConfigMessageWsDTO> getMessages() 
	{
		return messages;
	}
	
	public void setNewConfiguration(final Boolean newConfiguration)
	{
		this.newConfiguration = newConfiguration;
	}

	public Boolean getNewConfiguration() 
	{
		return newConfiguration;
	}
	

}