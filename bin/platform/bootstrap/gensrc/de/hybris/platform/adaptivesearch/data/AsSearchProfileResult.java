/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AbstractAsBoostItemConfiguration;
import de.hybris.platform.adaptivesearch.data.AbstractAsBoostRuleConfiguration;
import de.hybris.platform.adaptivesearch.data.AbstractAsFacetConfiguration;
import de.hybris.platform.adaptivesearch.data.AbstractAsSortConfiguration;
import de.hybris.platform.adaptivesearch.data.AsBoostRule;
import de.hybris.platform.adaptivesearch.data.AsConfigurationHolder;
import de.hybris.platform.adaptivesearch.data.AsExcludedFacet;
import de.hybris.platform.adaptivesearch.data.AsExcludedItem;
import de.hybris.platform.adaptivesearch.data.AsExcludedSort;
import de.hybris.platform.adaptivesearch.data.AsFacet;
import de.hybris.platform.adaptivesearch.data.AsGroup;
import de.hybris.platform.adaptivesearch.data.AsPromotedFacet;
import de.hybris.platform.adaptivesearch.data.AsPromotedItem;
import de.hybris.platform.adaptivesearch.data.AsPromotedSort;
import de.hybris.platform.adaptivesearch.data.AsSort;
import de.hybris.platform.adaptivesearch.enums.AsBoostItemsMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsBoostRulesMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsFacetsMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsGroupMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsSortsMergeMode;
import de.hybris.platform.core.PK;
import java.util.List;
import java.util.Map;


import java.util.Objects;
public  class AsSearchProfileResult  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.facetsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsFacetsMergeMode facetsMergeMode;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.facets</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<String,AsConfigurationHolder<AsFacet,AbstractAsFacetConfiguration>> facets;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.promotedFacets</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<String,AsConfigurationHolder<AsPromotedFacet,AbstractAsFacetConfiguration>> promotedFacets;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.excludedFacets</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<String,AsConfigurationHolder<AsExcludedFacet,AbstractAsFacetConfiguration>> excludedFacets;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.boostItemsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsBoostItemsMergeMode boostItemsMergeMode;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.promotedItems</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<PK,AsConfigurationHolder<AsPromotedItem,AbstractAsBoostItemConfiguration>> promotedItems;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.excludedItems</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<PK,AsConfigurationHolder<AsExcludedItem,AbstractAsBoostItemConfiguration>> excludedItems;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.boostRulesMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsBoostRulesMergeMode boostRulesMergeMode;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.boostRules</code> property defined at extension <code>adaptivesearch</code>. */
	
	private List<AsConfigurationHolder<AsBoostRule,AbstractAsBoostRuleConfiguration>> boostRules;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.sortsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsSortsMergeMode sortsMergeMode;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.promotedSorts</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<String,AsConfigurationHolder<AsPromotedSort,AbstractAsSortConfiguration>> promotedSorts;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.sorts</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<String,AsConfigurationHolder<AsSort,AbstractAsSortConfiguration>> sorts;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.excludedSorts</code> property defined at extension <code>adaptivesearch</code>. */
	
	private Map<String,AsConfigurationHolder<AsExcludedSort,AbstractAsSortConfiguration>> excludedSorts;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.groupMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsGroupMergeMode groupMergeMode;

	/** <i>Generated property</i> for <code>AsSearchProfileResult.group</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsConfigurationHolder<AsGroup,AsGroup> group;
	
	public AsSearchProfileResult()
	{
		// default constructor
	}
	
	public void setFacetsMergeMode(final AsFacetsMergeMode facetsMergeMode)
	{
		this.facetsMergeMode = facetsMergeMode;
	}

	public AsFacetsMergeMode getFacetsMergeMode() 
	{
		return facetsMergeMode;
	}
	
	public void setFacets(final Map<String,AsConfigurationHolder<AsFacet,AbstractAsFacetConfiguration>> facets)
	{
		this.facets = facets;
	}

	public Map<String,AsConfigurationHolder<AsFacet,AbstractAsFacetConfiguration>> getFacets() 
	{
		return facets;
	}
	
	public void setPromotedFacets(final Map<String,AsConfigurationHolder<AsPromotedFacet,AbstractAsFacetConfiguration>> promotedFacets)
	{
		this.promotedFacets = promotedFacets;
	}

	public Map<String,AsConfigurationHolder<AsPromotedFacet,AbstractAsFacetConfiguration>> getPromotedFacets() 
	{
		return promotedFacets;
	}
	
	public void setExcludedFacets(final Map<String,AsConfigurationHolder<AsExcludedFacet,AbstractAsFacetConfiguration>> excludedFacets)
	{
		this.excludedFacets = excludedFacets;
	}

	public Map<String,AsConfigurationHolder<AsExcludedFacet,AbstractAsFacetConfiguration>> getExcludedFacets() 
	{
		return excludedFacets;
	}
	
	public void setBoostItemsMergeMode(final AsBoostItemsMergeMode boostItemsMergeMode)
	{
		this.boostItemsMergeMode = boostItemsMergeMode;
	}

	public AsBoostItemsMergeMode getBoostItemsMergeMode() 
	{
		return boostItemsMergeMode;
	}
	
	public void setPromotedItems(final Map<PK,AsConfigurationHolder<AsPromotedItem,AbstractAsBoostItemConfiguration>> promotedItems)
	{
		this.promotedItems = promotedItems;
	}

	public Map<PK,AsConfigurationHolder<AsPromotedItem,AbstractAsBoostItemConfiguration>> getPromotedItems() 
	{
		return promotedItems;
	}
	
	public void setExcludedItems(final Map<PK,AsConfigurationHolder<AsExcludedItem,AbstractAsBoostItemConfiguration>> excludedItems)
	{
		this.excludedItems = excludedItems;
	}

	public Map<PK,AsConfigurationHolder<AsExcludedItem,AbstractAsBoostItemConfiguration>> getExcludedItems() 
	{
		return excludedItems;
	}
	
	public void setBoostRulesMergeMode(final AsBoostRulesMergeMode boostRulesMergeMode)
	{
		this.boostRulesMergeMode = boostRulesMergeMode;
	}

	public AsBoostRulesMergeMode getBoostRulesMergeMode() 
	{
		return boostRulesMergeMode;
	}
	
	public void setBoostRules(final List<AsConfigurationHolder<AsBoostRule,AbstractAsBoostRuleConfiguration>> boostRules)
	{
		this.boostRules = boostRules;
	}

	public List<AsConfigurationHolder<AsBoostRule,AbstractAsBoostRuleConfiguration>> getBoostRules() 
	{
		return boostRules;
	}
	
	public void setSortsMergeMode(final AsSortsMergeMode sortsMergeMode)
	{
		this.sortsMergeMode = sortsMergeMode;
	}

	public AsSortsMergeMode getSortsMergeMode() 
	{
		return sortsMergeMode;
	}
	
	public void setPromotedSorts(final Map<String,AsConfigurationHolder<AsPromotedSort,AbstractAsSortConfiguration>> promotedSorts)
	{
		this.promotedSorts = promotedSorts;
	}

	public Map<String,AsConfigurationHolder<AsPromotedSort,AbstractAsSortConfiguration>> getPromotedSorts() 
	{
		return promotedSorts;
	}
	
	public void setSorts(final Map<String,AsConfigurationHolder<AsSort,AbstractAsSortConfiguration>> sorts)
	{
		this.sorts = sorts;
	}

	public Map<String,AsConfigurationHolder<AsSort,AbstractAsSortConfiguration>> getSorts() 
	{
		return sorts;
	}
	
	public void setExcludedSorts(final Map<String,AsConfigurationHolder<AsExcludedSort,AbstractAsSortConfiguration>> excludedSorts)
	{
		this.excludedSorts = excludedSorts;
	}

	public Map<String,AsConfigurationHolder<AsExcludedSort,AbstractAsSortConfiguration>> getExcludedSorts() 
	{
		return excludedSorts;
	}
	
	public void setGroupMergeMode(final AsGroupMergeMode groupMergeMode)
	{
		this.groupMergeMode = groupMergeMode;
	}

	public AsGroupMergeMode getGroupMergeMode() 
	{
		return groupMergeMode;
	}
	
	public void setGroup(final AsConfigurationHolder<AsGroup,AsGroup> group)
	{
		this.group = group;
	}

	public AsConfigurationHolder<AsGroup,AsGroup> getGroup() 
	{
		return group;
	}
	

}