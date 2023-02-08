package com.fdherrera.config;

import com.fdherrera.constants.QueueConstants;

import org.springframework.amqp.core.Queue;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AdditionalBeansConfig {

	@Bean
	public Queue queue(Environment env) {
		String notificationsQueueName = env.getProperty(QueueConstants.NOTIFICATIONS_QUEUE_NAME);
		return new Queue(String.valueOf(notificationsQueueName), true);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
