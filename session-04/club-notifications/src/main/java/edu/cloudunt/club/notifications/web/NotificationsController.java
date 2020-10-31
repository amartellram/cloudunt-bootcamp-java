package edu.cloudunt.club.notifications.web;

import edu.cloudunt.club.notifications.service.NotificationService;
import edu.cloudunt.club.notifications.web.dto.NotificationRequest;
import edu.cloudunt.club.notifications.web.dto.NotificationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    private NotificationService notificationService;

    public NotificationsController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping()
    public NotificationResponse send(@RequestBody() NotificationRequest request) {
        return this.notificationService.send(request);
    }
}
