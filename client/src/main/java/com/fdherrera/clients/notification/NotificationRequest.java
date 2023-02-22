package com.fdherrera.clients.notification;

import java.io.Serializable;

public class NotificationRequest implements Serializable {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;

    public NotificationRequest() {
    }

    public NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message) {
        this.toCustomerId = toCustomerId;
        this.toCustomerEmail = toCustomerEmail;
        this.message = message;
    }

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
