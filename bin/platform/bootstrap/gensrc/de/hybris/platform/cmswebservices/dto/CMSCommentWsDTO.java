/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Specifies properties of the CMS comment.
 */
@Schema(name="CMSCommentWsDTO", description="Specifies properties of the CMS comment.")
public  class CMSCommentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.text</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="text") 	
	private String text;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.creationtime</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="creationtime", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationtime;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.authorName</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="authorName") 	
	private String authorName;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.decisionName</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="decisionName") 	
	private String decisionName;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.decisionCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="decisionCode") 	
	private String decisionCode;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.originalActionCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="originalActionCode") 	
	private String originalActionCode;

	/** <i>Generated property</i> for <code>CMSCommentWsDTO.createdAgoInMillis</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="createdAgoInMillis", example="128334524") 	
	private Long createdAgoInMillis;
	
	public CMSCommentWsDTO()
	{
		// default constructor
	}
	
	public void setText(final String text)
	{
		this.text = text;
	}

	public String getText() 
	{
		return text;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCreationtime(final Date creationtime)
	{
		this.creationtime = creationtime;
	}

	public Date getCreationtime() 
	{
		return creationtime;
	}
	
	public void setAuthorName(final String authorName)
	{
		this.authorName = authorName;
	}

	public String getAuthorName() 
	{
		return authorName;
	}
	
	public void setDecisionName(final String decisionName)
	{
		this.decisionName = decisionName;
	}

	public String getDecisionName() 
	{
		return decisionName;
	}
	
	public void setDecisionCode(final String decisionCode)
	{
		this.decisionCode = decisionCode;
	}

	public String getDecisionCode() 
	{
		return decisionCode;
	}
	
	public void setOriginalActionCode(final String originalActionCode)
	{
		this.originalActionCode = originalActionCode;
	}

	public String getOriginalActionCode() 
	{
		return originalActionCode;
	}
	
	public void setCreatedAgoInMillis(final Long createdAgoInMillis)
	{
		this.createdAgoInMillis = createdAgoInMillis;
	}

	public Long getCreatedAgoInMillis() 
	{
		return createdAgoInMillis;
	}
	

}