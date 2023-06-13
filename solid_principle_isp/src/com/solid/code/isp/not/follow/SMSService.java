package com.solid.code.isp.not.follow;

public class SMSService implements MessageService {

	@Override
	public void sendEmail(String recipient, String message) {
		// NOT USED

	}

	@Override
	public void sendSMS(String recipient, String message) {
		// LOGIC

	}

	@Override
	public void sendPushNotification(String recipient, String message) {
		// NOT USED

	}

}
