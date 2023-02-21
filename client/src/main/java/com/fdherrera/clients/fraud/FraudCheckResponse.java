package com.fdherrera.clients.fraud;

public class FraudCheckResponse {
	private Boolean isFraudulent;

	public FraudCheckResponse() {
	}

	public FraudCheckResponse(Boolean isFraudulent) {
		this.isFraudulent = isFraudulent;
	}

	public Boolean getIsFraudulent() {
		return isFraudulent;
	}

	public void setIsFraudulent(Boolean isFraudulent) {
		this.isFraudulent = isFraudulent;
	}

	@Override
	public String toString() {
		return "FraudCheckResponse [isFraudulent=" + isFraudulent + "]";
	}

}

