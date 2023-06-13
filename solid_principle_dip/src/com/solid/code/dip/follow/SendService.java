package com.solid.code.dip.follow;

public class SendService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessagingClient client = new MessagingClient(new EmailService());
		client.sendMessage("", "");
		
		
		MessagingClient client_2 = new MessagingClient(new SMSService());
		client_2.sendMessage("", "");

	}

}
