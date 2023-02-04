package com.fdherrera.config;

import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fdherrera.constants.QueueConstants;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdditionalBeansConfig {

	@Bean
	public Properties props() throws IOException {
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("application.yml"));
		return props;
	}

	@Bean
	public Queue queue(Properties props) {
		return new Queue(String.valueOf(props.get(QueueConstants.NOTIFICATIONS_QUEUE_NAME)), true);
	}

}
