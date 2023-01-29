package com.fdherrera.controller;

import java.util.logging.Logger;

import com.fdherrera.dto.FraudCheckResponse;
import com.fdherrera.service.FraudCheckService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {

	private static final Logger log = Logger.getLogger(FraudController.class.getSimpleName());

	@GetMapping("{customerId}")
	public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable Integer customerId) {
		FraudCheckResponse response = new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
		log.info("Response: " + response.toString());
		return ResponseEntity.ok(response);
	}

}
