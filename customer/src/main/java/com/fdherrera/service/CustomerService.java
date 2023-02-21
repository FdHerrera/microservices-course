package com.fdherrera.service;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.clients.fraud.FraudCheckResponse;
import com.fdherrera.clients.fraud.FraudFeignClient;
import com.fdherrera.dto.request.CustomerRequest;
import com.fdherrera.dto.request.NotificationRequest;
import com.fdherrera.model.Customer;
import com.fdherrera.repo.CustomerRepo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

	private static final Logger logger = Logger.getLogger(CustomerService.class.getSimpleName());

	private final ObjectMapper mapper;
	private final RestTemplate restTemplate;
	private final CustomerRepo customerRepo;
	private final FraudFeignClient fraudClient;

	public CustomerService(ObjectMapper mapper, RestTemplate restTemplate, CustomerRepo customerRepo, FraudFeignClient fraudClient) {
		this.mapper = mapper;
		this.restTemplate = restTemplate;
		this.customerRepo = customerRepo;
		this.fraudClient = fraudClient;
	}

	public void signUpCustomer(CustomerRequest request) {
		Customer customer = mapper.convertValue(request, Customer.class);
		// TODO validate
		customerRepo.saveAndFlush(customer);
		FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
		logger.info(fraudCheckResponse.toString());
		if (fraudCheckResponse.getIsFraudulent()) {
			throw new IllegalStateException("Is a fraudster customer");
		}
		restTemplate.postForObject("http://RABBIT-QUEUE/api/v1/queue/notifications",
				new NotificationRequest(customer.getId(), customer.getEmail(), "Thanks for registering!"), Void.class);
	}
}
