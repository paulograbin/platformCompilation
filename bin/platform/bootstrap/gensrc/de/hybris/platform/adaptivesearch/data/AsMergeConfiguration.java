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
import de.hybris.platform.adaptivesearch.enums.AsBoostItemsMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsBoostRulesMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsFacetsMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsGroupMergeMode;
import de.hybris.platform.adaptivesearch.enums.AsSortsMergeMode;


import java.util.Objects;
public  class AsMergeConfiguration  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.facetsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsFacetsMergeMode facetsMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.boostRulesMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsBoostRulesMergeMode boostRulesMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.boostItemsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsBoostItemsMergeMode boostItemsMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.sortsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsSortsMergeMode sortsMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.groupMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsGroupMergeMode groupMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.resultFacetsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsFacetsMergeMode resultFacetsMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.resultBoostItemsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsBoostItemsMergeMode resultBoostItemsMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.resultBoostRulesMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsBoostRulesMergeMode resultBoostRulesMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.resultSortsMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsSortsMergeMode resultSortsMergeMode;

	/** <i>Generated property</i> for <code>AsMergeConfiguration.resultGroupMergeMode</code> property defined at extension <code>adaptivesearch</code>. */
	
	private AsGroupMergeMode resultGroupMergeMode;
	
	public AsMergeConfiguration()
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
	
	public void setBoostRulesMergeMode(final AsBoostRulesMergeMode boostRulesMergeMode)
	{
		this.boostRulesMergeMode = boostRulesMergeMode;
	}

	public AsBoostRulesMergeMode getBoostRulesMergeMode() 
	{
		return boostRulesMergeMode;
	}
	
	public void setBoostItemsMergeMode(final AsBoostItemsMergeMode boostItemsMergeMode)
	{
		this.boostItemsMergeMode = boostItemsMergeMode;
	}

	public AsBoostItemsMergeMode getBoostItemsMergeMode() 
	{
		return boostItemsMergeMode;
	}
	
	public void setSortsMergeMode(final AsSortsMergeMode sortsMergeMode)
	{
		this.sortsMergeMode = sortsMergeMode;
	}

	public AsSortsMergeMode getSortsMergeMode() 
	{
		return sortsMergeMode;
	}
	
	public void setGroupMergeMode(final AsGroupMergeMode groupMergeMode)
	{
		this.groupMergeMode = groupMergeMode;
	}

	public AsGroupMergeMode getGroupMergeMode() 
	{
		return groupMergeMode;
	}
	
	public void setResultFacetsMergeMode(final AsFacetsMergeMode resultFacetsMergeMode)
	{
		this.resultFacetsMergeMode = resultFacetsMergeMode;
	}

	public AsFacetsMergeMode getResultFacetsMergeMode() 
	{
		return resultFacetsMergeMode;
	}
	
	public void setResultBoostItemsMergeMode(final AsBoostItemsMergeMode resultBoostItemsMergeMode)
	{
		this.resultBoostItemsMergeMode = resultBoostItemsMergeMode;
	}

	public AsBoostItemsMergeMode getResultBoostItemsMergeMode() 
	{
		return resultBoostItemsMergeMode;
	}
	
	public void setResultBoostRulesMergeMode(final AsBoostRulesMergeMode resultBoostRulesMergeMode)
	{
		this.resultBoostRulesMergeMode = resultBoostRulesMergeMode;
	}

	public AsBoostRulesMergeMode getResultBoostRulesMergeMode() 
	{
		return resultBoostRulesMergeMode;
	}
	
	public void setResultSortsMergeMode(final AsSortsMergeMode resultSortsMergeMode)
	{
		this.resultSortsMergeMode = resultSortsMergeMode;
	}

	public AsSortsMergeMode getResultSortsMergeMode() 
	{
		return resultSortsMergeMode;
	}
	
	public void setResultGroupMergeMode(final AsGroupMergeMode resultGroupMergeMode)
	{
		this.resultGroupMergeMode = resultGroupMergeMode;
	}

	public AsGroupMergeMode getResultGroupMergeMode() 
	{
		return resultGroupMergeMode;
	}
	

}