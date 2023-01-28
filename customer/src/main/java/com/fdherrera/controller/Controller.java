package com.fdherrera.controller;

import java.util.logging.Logger;

import com.fdherrera.dto.request.CustomerRequest;
import com.fdherrera.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public record Controller(CustomerService customerservice) {

	private static final Logger log = Logger.getLogger(Controller.class.getSimpleName());

	@PostMapping
	public ResponseEntity<Void> createNewCustomer(@RequestBody CustomerRequest request) {
		log.info("Create new customer request: {}" + request);
		customerservice.signUpCustomer(request);
		return ResponseEntity.ok(null);
	}

}
