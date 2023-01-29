package com.fdherrera.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;

    public Notification() {

    }

    public Notification(Integer toCustomerId, String toCustomerEmail, String sender, String message,
            LocalDateTime sentAt) {
        this.toCustomerId = toCustomerId;
        this.toCustomerEmail = toCustomerEmail;
        this.sender = sender;
        this.message = message;
        this.sentAt = sentAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "Notification [id=" + id + ", message=" + message + ", sender=" + sender + ", sentAt=" + sentAt
                + ", toCustomerEmail=" + toCustomerEmail + ", toCustomerId=" + toCustomerId + "]";
    }

}
