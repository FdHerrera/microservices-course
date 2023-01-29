package com.fdherrera.service;

import java.time.LocalDateTime;

import com.fdherrera.model.FraudCheckHistory;
import com.fdherrera.repo.FraudCheckHistoryRepo;

import org.springframework.stereotype.Service;

@Service
public record FraudCheckService(FraudCheckHistoryRepo fraudRepo) {

	public Boolean isFraudulentCustomer(Integer customerId) {
		fraudRepo.save(new FraudCheckHistory(customerId, false, LocalDateTime.now()));
		return false;
	}

}
