package com.solid.code.dip.not.follow;

public class SendService {

	public static void main(String[] args) {
		MessagingClient client = new MessagingClient();
		client.sendMessage("", "");
		
		MessagingClient client_2 = new MessagingClient();
		client_2.sendSMSMessage("", "");
		

	}

}
