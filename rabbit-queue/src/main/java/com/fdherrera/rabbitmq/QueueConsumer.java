package com.fdherrera.rabbitmq;

import java.util.logging.Logger;

import com.fdherrera.constants.QueueConstants;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
	private static final Logger log = Logger.getLogger(QueueConsumer.class.getName());

	@RabbitListener(queues = { QueueConstants.NOTIFICATIONS_QUEUE_PROP })
	public void receiveMessage(@Payload String message) {
		log.info("Message received: " + message);

		waitASec();

	}

	private void waitASec() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException ie) {
			log.severe("Uh oh! Error: " + ie.getMessage());
		}
	}
}