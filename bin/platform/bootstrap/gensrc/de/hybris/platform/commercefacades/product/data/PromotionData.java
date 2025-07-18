/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.promotion.data.PromotionRestrictionData;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class PromotionData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PromotionData.code</code> property defined at extension <code>commercefacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>PromotionData.title</code> property defined at extension <code>commercefacades</code>. */
	
	private String title;

	/** <i>Generated property</i> for <code>PromotionData.promotionType</code> property defined at extension <code>commercefacades</code>. */
	
	private String promotionType;

	/** <i>Generated property</i> for <code>PromotionData.startDate</code> property defined at extension <code>commercefacades</code>. */
	
	private Date startDate;

	/** <i>Generated property</i> for <code>PromotionData.endDate</code> property defined at extension <code>commercefacades</code>. */
	
	private Date endDate;

	/** <i>Generated property</i> for <code>PromotionData.description</code> property defined at extension <code>commercefacades</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>PromotionData.couldFireMessages</code> property defined at extension <code>commercefacades</code>. */
	
	private List<String> couldFireMessages;

	/** <i>Generated property</i> for <code>PromotionData.firedMessages</code> property defined at extension <code>commercefacades</code>. */
	
	private List<String> firedMessages;

	/** <i>Generated property</i> for <code>PromotionData.productBanner</code> property defined at extension <code>commercefacades</code>. */
	
	private ImageData productBanner;

	/** <i>Generated property</i> for <code>PromotionData.enabled</code> property defined at extension <code>commercefacades</code>. */
	
	private Boolean enabled;

	/** <i>Generated property</i> for <code>PromotionData.priority</code> property defined at extension <code>commercefacades</code>. */
	
	private Integer priority;

	/** <i>Generated property</i> for <code>PromotionData.promotionGroup</code> property defined at extension <code>commercefacades</code>. */
	
	private String promotionGroup;

	/** <i>Generated property</i> for <code>PromotionData.restrictions</code> property defined at extension <code>commercefacades</code>. */
	
	private Collection<PromotionRestrictionData> restrictions;
	
	public PromotionData()
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
	
	public void setProductBanner(final ImageData productBanner)
	{
		this.productBanner = productBanner;
	}

	public ImageData getProductBanner() 
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
	
	public void setRestrictions(final Collection<PromotionRestrictionData> restrictions)
	{
		this.restrictions = restrictions;
	}

	public Collection<PromotionRestrictionData> getRestrictions() 
	{
		return restrictions;
	}
	

}