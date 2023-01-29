package com.fdherrera.repo;

import com.fdherrera.model.FraudCheckHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepo extends JpaRepository<FraudCheckHistory, Integer> {

}
