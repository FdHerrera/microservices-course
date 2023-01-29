package com.fdherrera.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FraudCheckHistory {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer customerId;
	private Boolean isFraudster;
	private LocalDateTime createdAt;

	public FraudCheckHistory() {

	}

	public FraudCheckHistory(Integer customerId, Boolean isFraudster, LocalDateTime createdAt) {
		this.customerId = customerId;
		this.isFraudster = isFraudster;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Boolean getIsFraudster() {
		return isFraudster;
	}

	public void setIsFraudster(Boolean isFraudster) {
		this.isFraudster = isFraudster;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
