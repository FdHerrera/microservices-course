package com.fdherrera.controller;

import com.fdherrera.dto.NotificationRequest;
import com.fdherrera.rabbitmq.QueueProducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/queue")
public class QueueController {

	private final QueueProducer producer;

	public QueueController(QueueProducer producer) {
		this.producer = producer;
	}

	@PostMapping("notifications")
	public ResponseEntity<Void> postNotificationInQueue(@RequestBody NotificationRequest notificationRequest) {
		producer.publishMessage(notificationRequest);
		return ResponseEntity.ok().build();
	}

}
