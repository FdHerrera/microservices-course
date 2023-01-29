package com.fdherrera.service;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.dto.request.CustomerRequest;
import com.fdherrera.dto.response.FraudCheckResponse;
import com.fdherrera.model.Customer;
import com.fdherrera.repo.CustomerRepo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepo customerRepo, ObjectMapper mapper, RestTemplate restTemplate) {

	private static final Logger logger = Logger.getLogger(CustomerService.class.getSimpleName());

	public void signUpCustomer(CustomerRequest request) {
		Customer customer = mapper.convertValue(request, Customer.class);
		//TODO validate
		customerRepo.saveAndFlush(customer);
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
		logger.info(fraudCheckResponse.toString());
		if (fraudCheckResponse.isFraudulent()) {
			throw new IllegalStateException("Is a fraudster customer");
		}
	}

}
