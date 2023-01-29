package com.fdherrera.service;

import java.time.LocalDateTime;

import com.fdherrera.dto.NotificationRequest;
import com.fdherrera.model.Notification;
import com.fdherrera.repo.NotificationRepository;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(NotificationRequest request) {
        notificationRepository.save(new Notification(request.getToCustomerId(), request.getToCustomerEmail(),
                "fdherrera", request.getMessage(), LocalDateTime.now()));

    }

}
