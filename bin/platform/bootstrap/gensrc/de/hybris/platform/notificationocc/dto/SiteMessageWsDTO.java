/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto;

import java.io.Serializable;
import de.hybris.platform.notificationservices.enums.NotificationType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Site message
 */
@Schema(name="siteMessage", description="Site message")
public  class SiteMessageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** message uid<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.uid</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="uid", description="message uid") 	
	private String uid;

	/** message subject<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.subject</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="subject", description="message subject") 	
	private String subject;

	/** message body<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.body</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="body", description="message body") 	
	private String body;

	/** notification type used for this message<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.notificationType</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="notificationType", description="notification type used for this message") 	
	private NotificationType notificationType;

	/** sent date<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.sentDate</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="sentDate", description="sent date") 	
	private Date sentDate;
	
	public SiteMessageWsDTO()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setBody(final String body)
	{
		this.body = body;
	}

	public String getBody() 
	{
		return body;
	}
	
	public void setNotificationType(final NotificationType notificationType)
	{
		this.notificationType = notificationType;
	}

	public NotificationType getNotificationType() 
	{
		return notificationType;
	}
	
	public void setSentDate(final Date sentDate)
	{
		this.sentDate = sentDate;
	}

	public Date getSentDate() 
	{
		return sentDate;
	}
	

}