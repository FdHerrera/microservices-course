package com.fdherrera.service;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.clients.fraud.FraudCheckResponse;
import com.fdherrera.clients.fraud.FraudFeignClient;
import com.fdherrera.clients.notification.NotificationRequest;
import com.fdherrera.clients.rabbitqueue.RabbitQueueFeignClient;
import com.fdherrera.dto.request.CustomerRequest;
import com.fdherrera.model.Customer;
import com.fdherrera.repo.CustomerRepo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

	private static final Logger logger = Logger.getLogger(CustomerService.class.getSimpleName());

	private final ObjectMapper mapper;
	private final CustomerRepo customerRepo;
	private final FraudFeignClient fraudClient;
	private final RabbitQueueFeignClient rabbitClient;

	public CustomerService(ObjectMapper mapper, CustomerRepo customerRepo, FraudFeignClient fraudClient, RabbitQueueFeignClient rabbitClient) {
		this.mapper = mapper;
		this.customerRepo = customerRepo;
		this.fraudClient = fraudClient;
		this.rabbitClient = rabbitClient;
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
		rabbitClient.postNotificationInQueue(new NotificationRequest(customer.getId(), customer.getEmail(), "Thanks for registering!"));
	}
}
