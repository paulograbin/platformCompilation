/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto.conversation;

import java.io.Serializable;
import de.hybris.platform.notificationocc.dto.conversation.NotificationPreferenceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Notification preference list
 */
@Schema(name="notificationPreferenceList", description="Notification preference list")
public  class NotificationPreferenceListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** notification preferences<br/><br/><i>Generated property</i> for <code>NotificationPreferenceListWsDTO.preferences</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="preferences", description="notification preferences") 	
	private List<NotificationPreferenceWsDTO> preferences;
	
	public NotificationPreferenceListWsDTO()
	{
		// default constructor
	}
	
	public void setPreferences(final List<NotificationPreferenceWsDTO> preferences)
	{
		this.preferences = preferences;
	}

	public List<NotificationPreferenceWsDTO> getPreferences() 
	{
		return preferences;
	}
	

}