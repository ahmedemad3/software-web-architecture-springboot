package com.solid.code.dip.not.follow;

public class MessagingClient {
	
	private EmailService emailService;
	private SMSService smsService;

    public MessagingClient() {
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    public void sendMessage(String recipient, String message) {
        emailService.sendMessage(recipient, message);
    }
    
    public void sendSMSMessage(String recipient, String message) {
        smsService.sendMessage(recipient, message);
    }


}
