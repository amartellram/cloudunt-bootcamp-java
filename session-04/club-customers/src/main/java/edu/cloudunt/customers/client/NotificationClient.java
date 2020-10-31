package edu.cloudunt.customers.client;

import edu.cloudunt.customers.client.dto.NotificationRequest;
import edu.cloudunt.customers.client.dto.NotificationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public class NotificationClient {

    private RestTemplate restTemplate;

    @Value("${app.client.notification.url}")
    private String notificationUrl;

    @PostConstruct()
    public void initialize() {
        restTemplate = new RestTemplate();

    }

    public NotificationResponse send(NotificationRequest notificationRequest) {
        ResponseEntity<NotificationResponse> response = restTemplate.postForEntity(notificationUrl, notificationRequest, NotificationResponse.class);
        return response.getBody();
    }

}
