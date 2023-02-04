package com.fdherrera.rabbitmq;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class QueueProducer {
	private static final Logger log = Logger.getLogger(QueueProducer.class.getName());

	private final RabbitTemplate rabbitTemplate;
	private final Queue queue;
	private final ObjectMapper mapper;

	public QueueProducer(RabbitTemplate rabbitTemplate, Queue queue, ObjectMapper mapper) {
		this.rabbitTemplate = rabbitTemplate;
		this.queue = queue;
		this.mapper = mapper;
	}

	public void publishMessage(Object msg) {
		log.info("Publishing a message in queue: " + msg);

		try {
			rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(msg));
		} catch (JsonProcessingException e) {
			log.severe("Error converting value: " + msg.toString() + " with message: " + e.getMessage());
		}

	}
}
