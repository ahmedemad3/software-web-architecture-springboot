package com.solid.code.isp.not.follow;

public class EmailService implements MessageService {

	@Override
	public void sendEmail(String recipient, String message) {
		// BUSINESS lOGIC

	}

	@Override
	public void sendSMS(String recipient, String message) {
		// NOT USED

	}

	@Override
	public void sendPushNotification(String recipient, String message) {
		// NOT USED

	}

}
