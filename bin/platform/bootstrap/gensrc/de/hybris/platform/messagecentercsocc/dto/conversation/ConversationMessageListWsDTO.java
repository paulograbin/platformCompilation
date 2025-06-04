/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsocc.dto.conversation;

import java.io.Serializable;
import de.hybris.platform.messagecentercsocc.dto.conversation.ConversationMessageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Conversation message list
 */
@Schema(name="conversationMessageList", description="Conversation message list")
public  class ConversationMessageListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** conversation identifier<br/><br/><i>Generated property</i> for <code>ConversationMessageListWsDTO.conversationId</code> property defined at extension <code>messagecentercsocc</code>. */
@Schema(name="conversationId", description="conversation identifier") 	
	private String conversationId;

	/** the messages list of this conversation<br/><br/><i>Generated property</i> for <code>ConversationMessageListWsDTO.messages</code> property defined at extension <code>messagecentercsocc</code>. */
@Schema(name="messages", description="the messages list of this conversation") 	
	private List<ConversationMessageWsDTO> messages;
	
	public ConversationMessageListWsDTO()
	{
		// default constructor
	}
	
	public void setConversationId(final String conversationId)
	{
		this.conversationId = conversationId;
	}

	public String getConversationId() 
	{
		return conversationId;
	}
	
	public void setMessages(final List<ConversationMessageWsDTO> messages)
	{
		this.messages = messages;
	}

	public List<ConversationMessageWsDTO> getMessages() 
	{
		return messages;
	}
	

}