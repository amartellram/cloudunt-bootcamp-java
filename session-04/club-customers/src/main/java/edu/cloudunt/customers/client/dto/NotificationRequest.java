package edu.cloudunt.customers.client.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
    private String email;
    private String description;
    private String message;
}
