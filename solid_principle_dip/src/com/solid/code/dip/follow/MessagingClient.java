package com.solid.code.dip.follow;

public class MessagingClient {

	private MessagingService messagingService;

	public MessagingClient(MessagingService messagingService) {
		this.messagingService = messagingService;
	}

	public void sendMessage(String recipient, String message) {
		messagingService.sendMessage(recipient, message);
	}

}
