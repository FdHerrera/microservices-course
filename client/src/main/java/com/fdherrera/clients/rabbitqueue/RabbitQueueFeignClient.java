package com.fdherrera.clients.rabbitqueue;

import com.fdherrera.clients.notification.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("RABBIT-QUEUE/api/v1/queue")
public interface RabbitQueueFeignClient {

    @PostMapping("notifications")
    void postNotificationInQueue(@RequestBody NotificationRequest notificationRequest);

}
