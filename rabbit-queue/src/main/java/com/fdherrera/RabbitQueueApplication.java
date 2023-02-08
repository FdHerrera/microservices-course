package com.fdherrera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RabbitQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitQueueApplication.class, args);
	}

}
