package com.solid.code.isp.not.follow;

public interface MessageService {

	void sendEmail(String recipient, String message);
    void sendSMS(String recipient, String message);
    void sendPushNotification(String recipient, String message);
}
