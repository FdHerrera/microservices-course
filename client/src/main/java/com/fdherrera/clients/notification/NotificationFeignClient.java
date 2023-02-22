package com.fdherrera.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTIFICATION/api/v1/notifications")
public interface NotificationFeignClient {

    @PostMapping
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
