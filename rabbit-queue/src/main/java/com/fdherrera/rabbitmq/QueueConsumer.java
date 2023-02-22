package com.fdherrera.rabbitmq;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.clients.notification.NotificationFeignClient;
import com.fdherrera.clients.notification.NotificationRequest;
import com.fdherrera.constants.QueueConstants;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
	private static final Logger log = Logger.getLogger(QueueConsumer.class.getName());
	private final ObjectMapper mapper;
	private final NotificationFeignClient notificationClient;

	public QueueConsumer(ObjectMapper mapper, NotificationFeignClient notificationClient) {
		this.mapper = mapper;
		this.notificationClient = notificationClient;
	}

	@RabbitListener(queues = { QueueConstants.NOTIFICATIONS_QUEUE_PROP })
	public void receiveMessage(@Payload String message) {
		log.info("Message received: " + message);

		NotificationRequest notificationReceived = getNotificationRequest(message);
		notificationClient.sendNotification(notificationReceived);

		log.info("Message processed: " + message);

		waitASec();

	}

	private NotificationRequest getNotificationRequest(String message) {
		NotificationRequest notificationReceived = null;
		try {
			notificationReceived = mapper.readValue(message, NotificationRequest.class);
		} catch (JsonProcessingException jpe) {
			log.severe("Fail transforming msg: " + message + " into an object, error message: " + jpe.getMessage());
		}
		return notificationReceived;
	}

	private void waitASec() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException ie) {
			log.severe("Uh oh! Error: " + ie.getMessage());
		}
	}
}
