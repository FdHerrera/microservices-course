package com.fdherrera.dto.response;

public class FraudCheckResponse {

	private Boolean isFraudulent;

	public Boolean isFraudulent() {
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
