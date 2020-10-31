package edu.cloudunt.club.notifications.service;

import edu.cloudunt.club.notifications.web.dto.NotificationRequest;
import edu.cloudunt.club.notifications.web.dto.NotificationResponse;

public interface NotificationService {
    NotificationResponse send(NotificationRequest request);
}
