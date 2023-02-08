package com.fdherrera.rabbitmq;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.constants.QueueConstants;
import com.fdherrera.dto.NotificationRequest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QueueConsumer {
	private static final Logger log = Logger.getLogger(QueueConsumer.class.getName());

	private final RestTemplate restTemplate;
	private final ObjectMapper mapper;

	public QueueConsumer(RestTemplate restTemplate, ObjectMapper mapper) {
		this.restTemplate = restTemplate;
		this.mapper = mapper;
	}

	@RabbitListener(queues = { QueueConstants.NOTIFICATIONS_QUEUE_PROP })
	public void receiveMessage(@Payload String message) {
		log.info("Message received: " + message);

		NotificationRequest notificationReceived = getNotificationRequest(message);

		restTemplate.postForEntity("http://NOTIFICATION/api/v1/notification", notificationReceived, Void.class);

		log.info("Message processed: " + message);

		waitASec();

	}

	private NotificationRequest getNotificationRequest(String message) {
		NotificationRequest notificationReceived = null;
		try {
			notificationReceived = mapper.readValue(message, NotificationRequest.class);
		} catch (JsonProcessingException jpe) {
			log.severe("Fail transforming msg into an object: " + message + " with message: " + jpe.getMessage());
		}
		return notificationReceived;
	}

	private void waitASec() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException ie) {
			log.severe("Uh oh! Error: " + ie.getMessage());
		}
	}
}
