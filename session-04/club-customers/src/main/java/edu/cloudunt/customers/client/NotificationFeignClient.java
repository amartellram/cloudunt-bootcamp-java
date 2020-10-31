package edu.cloudunt.customers.client;

import edu.cloudunt.customers.client.dto.NotificationRequest;
import edu.cloudunt.customers.client.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="notifications", url = "${app.client.notification.url}")
public interface NotificationFeignClient {

    @PostMapping
    NotificationResponse send(@RequestBody NotificationRequest request);
}
