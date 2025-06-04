/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto.conversation;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Notification preference
 */
@Schema(name="notificationPreference", description="Notification preference")
public  class NotificationPreferenceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** preference channel<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.channel</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="channel", description="preference channel", example="email, sms, site_message") 	
	private String channel;

	/** the corresponding value of current channel, for example, for SMS it should be a mobile number; for email it should be an email address<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.value</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="value", description="the corresponding value of current channel, for example, for SMS it should be a mobile number; for email it should be an email address") 	
	private String value;

	/** if true, the channel is on; if false, the channel is off<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.enabled</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="enabled", description="if true, the channel is on; if false, the channel is off") 	
	private Boolean enabled;

	/** if true, the channel is visible; if false, the channel is invisible<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.visible</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="visible", description="if true, the channel is visible; if false, the channel is invisible") 	
	private Boolean visible;
	
	public NotificationPreferenceWsDTO()
	{
		// default constructor
	}
	
	public void setChannel(final String channel)
	{
		this.channel = channel;
	}

	public String getChannel() 
	{
		return channel;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}

	public Boolean getEnabled() 
	{
		return enabled;
	}
	
	public void setVisible(final Boolean visible)
	{
		this.visible = visible;
	}

	public Boolean getVisible() 
	{
		return visible;
	}
	

}