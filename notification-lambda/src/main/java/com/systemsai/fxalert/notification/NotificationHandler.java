package com.systemsai.fxalert.notification;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class NotificationHandler implements RequestHandler<AlertEvent, String> {
	private final NotificationService notificationService = new NotificationService();

	@Override
	public String handleRequest(AlertEvent event, Context context) {
		String subject = "🚨 FX Alert Triggered!";
		String body = String.format(
				"Hello,\n\nThe FX rate for %s has crossed your threshold %.2f.\nCurrent rate: %.2f.", event.getFxPair(),
				event.getThreshold(), event.getCurrentRate());

		notificationService.sendEmail(event.getEmail(), subject, body);

		return "Notification sent successfully!";
	}

}
