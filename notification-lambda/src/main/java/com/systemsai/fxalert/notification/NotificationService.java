package com.systemsai.fxalert.notification;

import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.Body;
import software.amazon.awssdk.services.ses.model.Content;
import software.amazon.awssdk.services.ses.model.Destination;
import software.amazon.awssdk.services.ses.model.Message;
import software.amazon.awssdk.services.ses.model.SendEmailRequest;

public class NotificationService {
	private final SesClient sesClient = SesClient.create();
	public void sendEmail(String toEmail,String subject, String body) {
		Destination destination = Destination.builder().toAddresses(toEmail).build();
		Content content = Content.builder().data(body).build();
		Message message = Message.builder()
                .subject(Content.builder().data(subject).build())
                .body(Body.builder().text(content).build())
                .build();
		SendEmailRequest request = SendEmailRequest.builder()
                .source("kavoyager@gmail.com")
                .destination(destination)
                .message(message)
                .build();
		sesClient.sendEmail(request);	
	}
}
