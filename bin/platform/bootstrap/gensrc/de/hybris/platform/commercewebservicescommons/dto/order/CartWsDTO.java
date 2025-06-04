/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import de.hybris.platform.commercewebservicescommons.dto.order.AbstractOrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.ApiMessageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionResultWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Cart. Note that sapBillingAddress is mutually exclusive with paymentInfo.billingAddress, which is used when the billing address is created concurrently with the paymentInfo.
        sapBillingAddress is used when there is a need to save the billing address, but the related paymentInfo has not been created yet.
 */
@Schema(name="Cart", description="Representation of a Cart. Note that sapBillingAddress is mutually exclusive with paymentInfo.billingAddress, which is used when the billing address is created concurrently with the paymentInfo. sapBillingAddress is used when there is a need to save the billing address, but the related paymentInfo has not been created yet.")
public  class CartWsDTO extends AbstractOrderWsDTO 

{



	/** Total unit count<br/><br/><i>Generated property</i> for <code>CartWsDTO.totalUnitCount</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalUnitCount", description="Total unit count") 	
	private Integer totalUnitCount;

	/** List of potential order promotions for cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.potentialOrderPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="potentialOrderPromotions", description="List of potential order promotions for cart") 	
	private List<PromotionResultWsDTO> potentialOrderPromotions;

	/** List of potential product promotions for cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.potentialProductPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="potentialProductPromotions", description="List of potential product promotions for cart") 	
	private List<PromotionResultWsDTO> potentialProductPromotions;

	/** Name of the cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of the cart") 	
	private String name;

	/** Description of the cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the cart") 	
	private String description;

	/** Date of cart expiration time<br/><br/><i>Generated property</i> for <code>CartWsDTO.expirationTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="expirationTime", description="Date of cart expiration time") 	
	private Date expirationTime;

	/** Date of saving cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.saveTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="saveTime", description="Date of saving cart") 	
	private Date saveTime;

	/** Information about person who saved cart<br/><br/><i>Generated property</i> for <code>CartWsDTO.savedBy</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="savedBy", description="Information about person who saved cart") 	
	private PrincipalWsDTO savedBy;

	/** Earliest possible retrieval date available for order<br/><br/><i>Generated property</i> for <code>CartWsDTO.earliestRetrievalAt</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="earliestRetrievalAt", description="Earliest possible retrieval date available for order") 	
	private String earliestRetrievalAt;

	/** Messages about supplementary info, warning messages related to the cart<br/><br/><i>Generated property</i> for <code>CartWsDTO._messages</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="_messages", description="Messages about supplementary info, warning messages related to the cart") 	
	private List<ApiMessageWsDTO> _messages;
	
	public CartWsDTO()
	{
		// default constructor
	}
	
	public void setTotalUnitCount(final Integer totalUnitCount)
	{
		this.totalUnitCount = totalUnitCount;
	}

	public Integer getTotalUnitCount() 
	{
		return totalUnitCount;
	}
	
	public void setPotentialOrderPromotions(final List<PromotionResultWsDTO> potentialOrderPromotions)
	{
		this.potentialOrderPromotions = potentialOrderPromotions;
	}

	public List<PromotionResultWsDTO> getPotentialOrderPromotions() 
	{
		return potentialOrderPromotions;
	}
	
	public void setPotentialProductPromotions(final List<PromotionResultWsDTO> potentialProductPromotions)
	{
		this.potentialProductPromotions = potentialProductPromotions;
	}

	public List<PromotionResultWsDTO> getPotentialProductPromotions() 
	{
		return potentialProductPromotions;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	
	public void setSaveTime(final Date saveTime)
	{
		this.saveTime = saveTime;
	}

	public Date getSaveTime() 
	{
		return saveTime;
	}
	
	public void setSavedBy(final PrincipalWsDTO savedBy)
	{
		this.savedBy = savedBy;
	}

	public PrincipalWsDTO getSavedBy() 
	{
		return savedBy;
	}
	
	public void setEarliestRetrievalAt(final String earliestRetrievalAt)
	{
		this.earliestRetrievalAt = earliestRetrievalAt;
	}

	public String getEarliestRetrievalAt() 
	{
		return earliestRetrievalAt;
	}
	
	public void set_messages(final List<ApiMessageWsDTO> _messages)
	{
		this._messages = _messages;
	}

	public List<ApiMessageWsDTO> get_messages() 
	{
		return _messages;
	}
	

}