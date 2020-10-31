package edu.cloudunt.club.notifications.service;

import edu.cloudunt.club.notifications.web.dto.NotificationRequest;
import edu.cloudunt.club.notifications.web.dto.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public NotificationResponse send(NotificationRequest request) {
        var response = new NotificationResponse();
        response.setMessage("Email sended");
        return response;
    }
}
