package com.fdherrera.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.dto.request.CustomerRequest;
import com.fdherrera.model.Customer;
import com.fdherrera.repo.CustomerRepo;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepo customerRepo, ObjectMapper mapper) {

	public void signUpCustomer(CustomerRequest request) {
		Customer customer = mapper.convertValue(request, Customer.class);
		//TODO validate
		customerRepo.save(customer);
	}

}
