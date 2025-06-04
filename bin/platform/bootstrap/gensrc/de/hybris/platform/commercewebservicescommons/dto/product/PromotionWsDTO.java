/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ImageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionRestrictionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Promotion
 */
@Schema(name="Promotion", description="Representation of a Promotion")
public  class PromotionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of the promotion") 	
	private String code;

	/** Promotion title<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.title</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="title", description="Promotion title") 	
	private String title;

	/** Type of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.promotionType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="promotionType", description="Type of the promotion") 	
	private String promotionType;

	/** The initial date of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.startDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="startDate", description="The initial date of the promotion") 	
	private Date startDate;

	/** Last date of validity of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.endDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="endDate", description="Last date of validity of the promotion") 	
	private Date endDate;

	/** Description of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Description of the promotion") 	
	private String description;

	/** Message about promotion which is displayed when planning potential promotion. This field has higher priority over promotion description<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.couldFireMessages</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="couldFireMessages", description="Message about promotion which is displayed when planning potential promotion. This field has higher priority over promotion description") 	
	private List<String> couldFireMessages;

	/** Message fired while the promotion is active. This is info how much you will get when applying the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.firedMessages</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="firedMessages", description="Message fired while the promotion is active. This is info how much you will get when applying the promotion") 	
	private List<String> firedMessages;

	/** Image banner of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.productBanner</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productBanner", description="Image banner of the promotion") 	
	private ImageWsDTO productBanner;

	/** Boolean flag if promotion is enabled<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.enabled</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="enabled", description="Boolean flag if promotion is enabled") 	
	private Boolean enabled;

	/** Priority index as numeric value of the promotion. Higher number means higher priority<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.priority</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="priority", description="Priority index as numeric value of the promotion. Higher number means higher priority") 	
	private Integer priority;

	/** Group of the promotion<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.promotionGroup</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="promotionGroup", description="Group of the promotion") 	
	private String promotionGroup;

	/** List of promotion restrictions<br/><br/><i>Generated property</i> for <code>PromotionWsDTO.restrictions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="restrictions", description="List of promotion restrictions") 	
	private Collection<PromotionRestrictionWsDTO> restrictions;
	
	public PromotionWsDTO()
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
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	
	public void setPromotionType(final String promotionType)
	{
		this.promotionType = promotionType;
	}

	public String getPromotionType() 
	{
		return promotionType;
	}
	
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setCouldFireMessages(final List<String> couldFireMessages)
	{
		this.couldFireMessages = couldFireMessages;
	}

	public List<String> getCouldFireMessages() 
	{
		return couldFireMessages;
	}
	
	public void setFiredMessages(final List<String> firedMessages)
	{
		this.firedMessages = firedMessages;
	}

	public List<String> getFiredMessages() 
	{
		return firedMessages;
	}
	
	public void setProductBanner(final ImageWsDTO productBanner)
	{
		this.productBanner = productBanner;
	}

	public ImageWsDTO getProductBanner() 
	{
		return productBanner;
	}
	
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}

	public Boolean getEnabled() 
	{
		return enabled;
	}
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

	public Integer getPriority() 
	{
		return priority;
	}
	
	public void setPromotionGroup(final String promotionGroup)
	{
		this.promotionGroup = promotionGroup;
	}

	public String getPromotionGroup() 
	{
		return promotionGroup;
	}
	
	public void setRestrictions(final Collection<PromotionRestrictionWsDTO> restrictions)
	{
		this.restrictions = restrictions;
	}

	public Collection<PromotionRestrictionWsDTO> getRestrictions() 
	{
		return restrictions;
	}
	

}