package com.fdherrera.controller;

import java.util.logging.Logger;

import com.fdherrera.dto.NotificationRequest;
import com.fdherrera.service.NotificationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {
    private static final Logger log = Logger.getLogger(NotificationController.class.getName());

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification to send: " + notificationRequest.toString());
        notificationService.sendNotification(notificationRequest);
    }

}
