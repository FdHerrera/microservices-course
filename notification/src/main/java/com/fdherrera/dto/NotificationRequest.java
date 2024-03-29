package com.fdherrera.dto;

public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;

    public Integer getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(Integer toCustomerId) {
        this.toCustomerId = toCustomerId;
    }

    public String getToCustomerEmail() {
        return toCustomerEmail;
    }

    public void setToCustomerEmail(String toCustomerEmail) {
        this.toCustomerEmail = toCustomerEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotificationRequest [message=" + message + ", toCustomerEmail=" + toCustomerEmail + ", toCustomerId="
                + toCustomerId + "]";
    }

}
