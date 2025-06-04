/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.previewwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.personalizationservices.data.CxVariationKey;
import de.hybris.platform.previewwebservices.dto.CatalogVersionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Preview Ticket.
 */
@Schema(name="previewTicket", description="Preview Ticket.")
public  class PreviewTicketWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Resource path.<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.resourcePath</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="resourcePath", description="Resource path.", required=true) 	
	private String resourcePath;

	/** User of the preview ticket<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.user</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="user", description="User of the preview ticket") 	
	private String user;

	/** User group of the preview ticket<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.userGroup</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="userGroup", description="User group of the preview ticket") 	
	private String userGroup;

	/** Language of the preview ticket<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.language</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="language", description="Language of the preview ticket") 	
	private String language;

	/** Time of the preview ticket<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.time</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="time", description="Time of the preview ticket") 	
	private Date time;

	/** Preview ticket ID<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.ticketId</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="ticketId", description="Preview ticket ID") 	
	private String ticketId;

	/** CMS page ID to use for the preview<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.pageId</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="pageId", description="CMS page ID to use for the preview") 	
	private String pageId;

	/** Catalog version list<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.catalogVersions</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="catalogVersions", description="Catalog version list") 	
	private List<CatalogVersionWsDTO> catalogVersions;

	/** UID of the site<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.siteId</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="siteId", description="UID of the site") 	
	private String siteId;

	/** CMS version ID to use for the preview<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.versionId</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="versionId", description="CMS version ID to use for the preview") 	
	private String versionId;

	/** Set to true to evaluate the restrictions against all matching pages.<br/><br/><i>Generated property</i> for <code>PreviewTicketWsDTO.evaluateRestrictions</code> property defined at extension <code>previewwebservices</code>. */
@Schema(name="evaluateRestrictions", description="Set to true to evaluate the restrictions against all matching pages.") 	
	private boolean evaluateRestrictions;

	/** <i>Generated property</i> for <code>PreviewTicketWsDTO.variations</code> property defined at extension <code>previewpersonalizationweb</code>. */
@Schema(name="variations") 	
	private Collection<CxVariationKey> variations;

	/** <i>Generated property</i> for <code>PreviewTicketWsDTO.segments</code> property defined at extension <code>previewpersonalizationweb</code>. */
@Schema(name="segments") 	
	private Collection<String> segments;
	
	public PreviewTicketWsDTO()
	{
		// default constructor
	}
	
	public void setResourcePath(final String resourcePath)
	{
		this.resourcePath = resourcePath;
	}

	public String getResourcePath() 
	{
		return resourcePath;
	}
	
	public void setUser(final String user)
	{
		this.user = user;
	}

	public String getUser() 
	{
		return user;
	}
	
	public void setUserGroup(final String userGroup)
	{
		this.userGroup = userGroup;
	}

	public String getUserGroup() 
	{
		return userGroup;
	}
	
	public void setLanguage(final String language)
	{
		this.language = language;
	}

	public String getLanguage() 
	{
		return language;
	}
	
	public void setTime(final Date time)
	{
		this.time = time;
	}

	public Date getTime() 
	{
		return time;
	}
	
	public void setTicketId(final String ticketId)
	{
		this.ticketId = ticketId;
	}

	public String getTicketId() 
	{
		return ticketId;
	}
	
	public void setPageId(final String pageId)
	{
		this.pageId = pageId;
	}

	public String getPageId() 
	{
		return pageId;
	}
	
	public void setCatalogVersions(final List<CatalogVersionWsDTO> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

	public List<CatalogVersionWsDTO> getCatalogVersions() 
	{
		return catalogVersions;
	}
	
	public void setSiteId(final String siteId)
	{
		this.siteId = siteId;
	}

	public String getSiteId() 
	{
		return siteId;
	}
	
	public void setVersionId(final String versionId)
	{
		this.versionId = versionId;
	}

	public String getVersionId() 
	{
		return versionId;
	}
	
	/**
	 * @deprecated no longer needed
	 */
	@Deprecated(since = "1905", forRemoval = true)
	public void setEvaluateRestrictions(final boolean evaluateRestrictions)
	{
		this.evaluateRestrictions = evaluateRestrictions;
	}

	/**
	 * @deprecated no longer needed
	 */
	@Deprecated(since = "1905", forRemoval = true)
	public boolean isEvaluateRestrictions() 
	{
		return evaluateRestrictions;
	}
	
	public void setVariations(final Collection<CxVariationKey> variations)
	{
		this.variations = variations;
	}

	public Collection<CxVariationKey> getVariations() 
	{
		return variations;
	}
	
	public void setSegments(final Collection<String> segments)
	{
		this.segments = segments;
	}

	public Collection<String> getSegments() 
	{
		return segments;
	}
	

}