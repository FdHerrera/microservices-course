package com.fdherrera.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdherrera.dto.request.CustomerRequest;
import com.fdherrera.model.Customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(ObjectMapper mapper) {

	public void signUpCustomer(CustomerRequest request) {
		Customer customer = mapper.convertValue(request, Customer.class);

		//TODO validate and save
	}

}
