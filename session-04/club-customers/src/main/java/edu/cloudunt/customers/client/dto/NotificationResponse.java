package edu.cloudunt.customers.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NotificationResponse implements Serializable {
    private String message;
}
