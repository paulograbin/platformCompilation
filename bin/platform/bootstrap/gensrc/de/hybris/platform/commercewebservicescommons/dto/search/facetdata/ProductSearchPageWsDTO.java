/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.search.facetdata;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.SearchStateWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.BreadcrumbWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.FacetWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.SpellingSuggestionWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Product Search Page
 */
@Schema(name="ProductSearchPage", description="Representation of a Product Search Page")
public  class ProductSearchPageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Free text search<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.freeTextSearch</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="freeTextSearch", description="Free text search") 	
	private String freeTextSearch;

	/** Code of category<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.categoryCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="categoryCode", description="Code of category") 	
	private String categoryCode;

	/** Redirect url address keyword<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.keywordRedirectUrl</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="keywordRedirectUrl", description="Redirect url address keyword") 	
	private String keywordRedirectUrl;

	/** Spelling suggestion<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.spellingSuggestion</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="spellingSuggestion", description="Spelling suggestion") 	
	private SpellingSuggestionWsDTO spellingSuggestion;

	/** List of products<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.products</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="products", description="List of products") 	
	private List<ProductWsDTO> products;

	/** List of sorts<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.sorts</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sorts", description="List of sorts") 	
	private List<SortWsDTO> sorts;

	/** Pagination number<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.pagination</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="pagination", description="Pagination number") 	
	private PaginationWsDTO pagination;

	/** Current query<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.currentQuery</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currentQuery", description="Current query") 	
	private SearchStateWsDTO currentQuery;

	/** List of breadcrumbs info<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.breadcrumbs</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="breadcrumbs", description="List of breadcrumbs info") 	
	private List<BreadcrumbWsDTO> breadcrumbs;

	/** List of facets<br/><br/><i>Generated property</i> for <code>ProductSearchPageWsDTO.facets</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="facets", description="List of facets") 	
	private List<FacetWsDTO> facets;
	
	public ProductSearchPageWsDTO()
	{
		// default constructor
	}
	
	public void setFreeTextSearch(final String freeTextSearch)
	{
		this.freeTextSearch = freeTextSearch;
	}

	public String getFreeTextSearch() 
	{
		return freeTextSearch;
	}
	
	public void setCategoryCode(final String categoryCode)
	{
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() 
	{
		return categoryCode;
	}
	
	public void setKeywordRedirectUrl(final String keywordRedirectUrl)
	{
		this.keywordRedirectUrl = keywordRedirectUrl;
	}

	public String getKeywordRedirectUrl() 
	{
		return keywordRedirectUrl;
	}
	
	public void setSpellingSuggestion(final SpellingSuggestionWsDTO spellingSuggestion)
	{
		this.spellingSuggestion = spellingSuggestion;
	}

	public SpellingSuggestionWsDTO getSpellingSuggestion() 
	{
		return spellingSuggestion;
	}
	
	public void setProducts(final List<ProductWsDTO> products)
	{
		this.products = products;
	}

	public List<ProductWsDTO> getProducts() 
	{
		return products;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setCurrentQuery(final SearchStateWsDTO currentQuery)
	{
		this.currentQuery = currentQuery;
	}

	public SearchStateWsDTO getCurrentQuery() 
	{
		return currentQuery;
	}
	
	public void setBreadcrumbs(final List<BreadcrumbWsDTO> breadcrumbs)
	{
		this.breadcrumbs = breadcrumbs;
	}

	public List<BreadcrumbWsDTO> getBreadcrumbs() 
	{
		return breadcrumbs;
	}
	
	public void setFacets(final List<FacetWsDTO> facets)
	{
		this.facets = facets;
	}

	public List<FacetWsDTO> getFacets() 
	{
		return facets;
	}
	

}