/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsocc.dto.conversation;

import java.io.Serializable;
import de.hybris.platform.messagecentercsocc.dto.conversation.ConversationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Conversation list
 */
@Schema(name="conversationList", description="Conversation list")
public  class ConversationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** conversation data<br/><br/><i>Generated property</i> for <code>ConversationListWsDTO.conversations</code> property defined at extension <code>messagecentercsocc</code>. */
@Schema(name="conversations", description="conversation data") 	
	private List<ConversationWsDTO> conversations;
	
	public ConversationListWsDTO()
	{
		// default constructor
	}
	
	public void setConversations(final List<ConversationWsDTO> conversations)
	{
		this.conversations = conversations;
	}

	public List<ConversationWsDTO> getConversations() 
	{
		return conversations;
	}
	

}