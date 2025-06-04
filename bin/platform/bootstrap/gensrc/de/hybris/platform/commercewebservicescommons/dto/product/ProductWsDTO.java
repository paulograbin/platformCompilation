/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:42 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.BaseOptionWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.CategoryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.ClassificationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.FutureStockWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.ImageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceRangeWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductReferenceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.ReviewWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.SAPUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.StockWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.VariantMatrixElementWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.VariantOptionWsDTO;
import de.hybris.platform.configurablebundleocc.data.BundleTemplateWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;
import java.util.List;
import java.util.Set;


import java.util.Objects;
/**
 * Representation of a Product
 */
@Schema(name="Product", description="Representation of a Product")
public  class ProductWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the product") 	
	private String code;

	/** Name of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the product") 	
	private String name;

	/** Url address of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.url</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="url", description="Url address of the product") 	
	private String url;

	/** Description of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the product") 	
	private String description;

	/** Flag defining if product is purchasable<br/><br/><i>Generated property</i> for <code>ProductWsDTO.purchasable</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="purchasable", description="Flag defining if product is purchasable") 	
	private Boolean purchasable;

	/** Stock value of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.stock</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="stock", description="Stock value of the product") 	
	private StockWsDTO stock;

	/** List of future stocks<br/><br/><i>Generated property</i> for <code>ProductWsDTO.futureStocks</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="futureStocks", description="List of future stocks") 	
	private List<FutureStockWsDTO> futureStocks;

	/** Flag defining if product is available for pickup<br/><br/><i>Generated property</i> for <code>ProductWsDTO.availableForPickup</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="availableForPickup", description="Flag defining if product is available for pickup") 	
	private Boolean availableForPickup;

	/** Rating number of average value<br/><br/><i>Generated property</i> for <code>ProductWsDTO.averageRating</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="averageRating", description="Rating number of average value") 	
	private Double averageRating;

	/** Number of reviews associated with the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.numberOfReviews</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="numberOfReviews", description="Number of reviews associated with the product") 	
	private Integer numberOfReviews;

	/** Product summary<br/><br/><i>Generated property</i> for <code>ProductWsDTO.summary</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="summary", description="Product summary") 	
	private String summary;

	/** Data of product manufacturer<br/><br/><i>Generated property</i> for <code>ProductWsDTO.manufacturer</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="manufacturer", description="Data of product manufacturer") 	
	private String manufacturer;

	/** Variant type of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.variantType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="variantType", description="Variant type of the product") 	
	private String variantType;

	/** Price of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.price</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="price", description="Price of the product") 	
	private PriceWsDTO price;

	/** Unit of the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.sapUnit</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sapUnit", description="Unit of the product") 	
	private SAPUnitWsDTO sapUnit;

	/** Information about base product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.baseProduct</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="baseProduct", description="Information about base product") 	
	private String baseProduct;

	/** List of images linked to product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.images</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="images", description="List of images linked to product") 	
	private Collection<ImageWsDTO> images;

	/** List of categories product belongs to<br/><br/><i>Generated property</i> for <code>ProductWsDTO.categories</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="categories", description="List of categories product belongs to") 	
	private Collection<CategoryWsDTO> categories;

	/** List of reviews associated with the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.reviews</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="reviews", description="List of reviews associated with the product") 	
	private Collection<ReviewWsDTO> reviews;

	/** List of classifications related to the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.classifications</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="classifications", description="List of classifications related to the product") 	
	private Collection<ClassificationWsDTO> classifications;

	/** List of potential promotions related to the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.potentialPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="potentialPromotions", description="List of potential promotions related to the product") 	
	private Collection<PromotionWsDTO> potentialPromotions;

	/** List of variant options related to the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.variantOptions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="variantOptions", description="List of variant options related to the product") 	
	private List<VariantOptionWsDTO> variantOptions;

	/** List of base options related to the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.baseOptions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="baseOptions", description="List of base options related to the product") 	
	private List<BaseOptionWsDTO> baseOptions;

	/** Flag stating if volume price should be displayed<br/><br/><i>Generated property</i> for <code>ProductWsDTO.volumePricesFlag</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="volumePricesFlag", description="Flag stating if volume price should be displayed") 	
	private Boolean volumePricesFlag;

	/** List of volume prices<br/><br/><i>Generated property</i> for <code>ProductWsDTO.volumePrices</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="volumePrices", description="List of volume prices") 	
	private List<PriceWsDTO> volumePrices;

	/** List of product references<br/><br/><i>Generated property</i> for <code>ProductWsDTO.productReferences</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productReferences", description="List of product references") 	
	private List<ProductReferenceWsDTO> productReferences;

	/** List of variant matrixes associated with the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.variantMatrix</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="variantMatrix", description="List of variant matrixes associated with the product") 	
	private List<VariantMatrixElementWsDTO> variantMatrix;

	/** Price range assigned to the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.priceRange</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="priceRange", description="Price range assigned to the product") 	
	private PriceRangeWsDTO priceRange;

	/** Flag stating if product is multidimensional<br/><br/><i>Generated property</i> for <code>ProductWsDTO.multidimensional</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="multidimensional", description="Flag stating if product is multidimensional") 	
	private Boolean multidimensional;

	/** Configurator type related to the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.configuratorType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="configuratorType", description="Configurator type related to the product") 	
	private String configuratorType;

	/** Flag stating if product is configurable<br/><br/><i>Generated property</i> for <code>ProductWsDTO.configurable</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="configurable", description="Flag stating if product is configurable") 	
	private Boolean configurable;

	/** Tags associated with the product<br/><br/><i>Generated property</i> for <code>ProductWsDTO.tags</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="tags", description="Tags associated with the product") 	
	private Set<String> tags;

	/** Flag specifies whether product can be added to cart. When addToCartDisabled=true, the product is not allowed to be added into cart and the reason is explained through sapAddToCartDisabledMessage; when addToCartDisabled=false, the product is allowed to be added into cart.<br/><br/><i>Generated property</i> for <code>ProductWsDTO.sapAddToCartDisabled</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sapAddToCartDisabled", description="Flag specifies whether product can be added to cart. When addToCartDisabled=true, the product is not allowed to be added into cart and the reason is explained through sapAddToCartDisabledMessage; when addToCartDisabled=false, the product is allowed to be added into cart.", example="true") 	
	private Boolean sapAddToCartDisabled;

	/** Message shows why product can not be added to cart.<br/><br/><i>Generated property</i> for <code>ProductWsDTO.sapAddToCartDisabledMessage</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sapAddToCartDisabledMessage", description="Message shows why product can not be added to cart.", example="'EF-S 60mm f/2.8 USM Macro' is not available with 'EOS450D + 18-55 IS Kit'") 	
	private String sapAddToCartDisabledMessage;

	/** <i>Generated property</i> for <code>ProductWsDTO.firstVariantCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="firstVariantCode") 	
	private String firstVariantCode;

	/** <i>Generated property</i> for <code>ProductWsDTO.firstVariantImage</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="firstVariantImage") 	
	private String firstVariantImage;

	/** Set of bundle templates that are identified as starter components and can initiate a bundle in the cart<br/><br/><i>Generated property</i> for <code>ProductWsDTO.bundleTemplates</code> property defined at extension <code>configurablebundleocc</code>. */
@Schema(name="bundleTemplates", description="Set of bundle templates that are identified as starter components and can initiate a bundle in the cart") 	
	private List<BundleTemplateWsDTO> bundleTemplates;

	/** <i>Generated property</i> for <code>ProductWsDTO.timedAccessPromotion</code> property defined at extension <code>timedaccesspromotionenginefacades</code>. */
@Schema(name="timedAccessPromotion") 	
	private PromotionWsDTO timedAccessPromotion;
	
	public ProductWsDTO()
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
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setPurchasable(final Boolean purchasable)
	{
		this.purchasable = purchasable;
	}

	public Boolean getPurchasable() 
	{
		return purchasable;
	}
	
	public void setStock(final StockWsDTO stock)
	{
		this.stock = stock;
	}

	public StockWsDTO getStock() 
	{
		return stock;
	}
	
	public void setFutureStocks(final List<FutureStockWsDTO> futureStocks)
	{
		this.futureStocks = futureStocks;
	}

	public List<FutureStockWsDTO> getFutureStocks() 
	{
		return futureStocks;
	}
	
	public void setAvailableForPickup(final Boolean availableForPickup)
	{
		this.availableForPickup = availableForPickup;
	}

	public Boolean getAvailableForPickup() 
	{
		return availableForPickup;
	}
	
	public void setAverageRating(final Double averageRating)
	{
		this.averageRating = averageRating;
	}

	public Double getAverageRating() 
	{
		return averageRating;
	}
	
	public void setNumberOfReviews(final Integer numberOfReviews)
	{
		this.numberOfReviews = numberOfReviews;
	}

	public Integer getNumberOfReviews() 
	{
		return numberOfReviews;
	}
	
	public void setSummary(final String summary)
	{
		this.summary = summary;
	}

	public String getSummary() 
	{
		return summary;
	}
	
	public void setManufacturer(final String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() 
	{
		return manufacturer;
	}
	
	public void setVariantType(final String variantType)
	{
		this.variantType = variantType;
	}

	public String getVariantType() 
	{
		return variantType;
	}
	
	public void setPrice(final PriceWsDTO price)
	{
		this.price = price;
	}

	public PriceWsDTO getPrice() 
	{
		return price;
	}
	
	public void setSapUnit(final SAPUnitWsDTO sapUnit)
	{
		this.sapUnit = sapUnit;
	}

	public SAPUnitWsDTO getSapUnit() 
	{
		return sapUnit;
	}
	
	public void setBaseProduct(final String baseProduct)
	{
		this.baseProduct = baseProduct;
	}

	public String getBaseProduct() 
	{
		return baseProduct;
	}
	
	public void setImages(final Collection<ImageWsDTO> images)
	{
		this.images = images;
	}

	public Collection<ImageWsDTO> getImages() 
	{
		return images;
	}
	
	public void setCategories(final Collection<CategoryWsDTO> categories)
	{
		this.categories = categories;
	}

	public Collection<CategoryWsDTO> getCategories() 
	{
		return categories;
	}
	
	public void setReviews(final Collection<ReviewWsDTO> reviews)
	{
		this.reviews = reviews;
	}

	public Collection<ReviewWsDTO> getReviews() 
	{
		return reviews;
	}
	
	public void setClassifications(final Collection<ClassificationWsDTO> classifications)
	{
		this.classifications = classifications;
	}

	public Collection<ClassificationWsDTO> getClassifications() 
	{
		return classifications;
	}
	
	public void setPotentialPromotions(final Collection<PromotionWsDTO> potentialPromotions)
	{
		this.potentialPromotions = potentialPromotions;
	}

	public Collection<PromotionWsDTO> getPotentialPromotions() 
	{
		return potentialPromotions;
	}
	
	public void setVariantOptions(final List<VariantOptionWsDTO> variantOptions)
	{
		this.variantOptions = variantOptions;
	}

	public List<VariantOptionWsDTO> getVariantOptions() 
	{
		return variantOptions;
	}
	
	public void setBaseOptions(final List<BaseOptionWsDTO> baseOptions)
	{
		this.baseOptions = baseOptions;
	}

	public List<BaseOptionWsDTO> getBaseOptions() 
	{
		return baseOptions;
	}
	
	public void setVolumePricesFlag(final Boolean volumePricesFlag)
	{
		this.volumePricesFlag = volumePricesFlag;
	}

	public Boolean getVolumePricesFlag() 
	{
		return volumePricesFlag;
	}
	
	public void setVolumePrices(final List<PriceWsDTO> volumePrices)
	{
		this.volumePrices = volumePrices;
	}

	public List<PriceWsDTO> getVolumePrices() 
	{
		return volumePrices;
	}
	
	public void setProductReferences(final List<ProductReferenceWsDTO> productReferences)
	{
		this.productReferences = productReferences;
	}

	public List<ProductReferenceWsDTO> getProductReferences() 
	{
		return productReferences;
	}
	
	public void setVariantMatrix(final List<VariantMatrixElementWsDTO> variantMatrix)
	{
		this.variantMatrix = variantMatrix;
	}

	public List<VariantMatrixElementWsDTO> getVariantMatrix() 
	{
		return variantMatrix;
	}
	
	public void setPriceRange(final PriceRangeWsDTO priceRange)
	{
		this.priceRange = priceRange;
	}

	public PriceRangeWsDTO getPriceRange() 
	{
		return priceRange;
	}
	
	public void setMultidimensional(final Boolean multidimensional)
	{
		this.multidimensional = multidimensional;
	}

	public Boolean getMultidimensional() 
	{
		return multidimensional;
	}
	
	public void setConfiguratorType(final String configuratorType)
	{
		this.configuratorType = configuratorType;
	}

	public String getConfiguratorType() 
	{
		return configuratorType;
	}
	
	public void setConfigurable(final Boolean configurable)
	{
		this.configurable = configurable;
	}

	public Boolean getConfigurable() 
	{
		return configurable;
	}
	
	public void setTags(final Set<String> tags)
	{
		this.tags = tags;
	}

	public Set<String> getTags() 
	{
		return tags;
	}
	
	public void setSapAddToCartDisabled(final Boolean sapAddToCartDisabled)
	{
		this.sapAddToCartDisabled = sapAddToCartDisabled;
	}

	public Boolean getSapAddToCartDisabled() 
	{
		return sapAddToCartDisabled;
	}
	
	public void setSapAddToCartDisabledMessage(final String sapAddToCartDisabledMessage)
	{
		this.sapAddToCartDisabledMessage = sapAddToCartDisabledMessage;
	}

	public String getSapAddToCartDisabledMessage() 
	{
		return sapAddToCartDisabledMessage;
	}
	
	public void setFirstVariantCode(final String firstVariantCode)
	{
		this.firstVariantCode = firstVariantCode;
	}

	public String getFirstVariantCode() 
	{
		return firstVariantCode;
	}
	
	public void setFirstVariantImage(final String firstVariantImage)
	{
		this.firstVariantImage = firstVariantImage;
	}

	public String getFirstVariantImage() 
	{
		return firstVariantImage;
	}
	
	public void setBundleTemplates(final List<BundleTemplateWsDTO> bundleTemplates)
	{
		this.bundleTemplates = bundleTemplates;
	}

	public List<BundleTemplateWsDTO> getBundleTemplates() 
	{
		return bundleTemplates;
	}
	
	public void setTimedAccessPromotion(final PromotionWsDTO timedAccessPromotion)
	{
		this.timedAccessPromotion = timedAccessPromotion;
	}

	public PromotionWsDTO getTimedAccessPromotion() 
	{
		return timedAccessPromotion;
	}
	

}