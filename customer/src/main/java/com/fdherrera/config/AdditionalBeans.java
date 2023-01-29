package com.fdherrera.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdditionalBeans {

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
