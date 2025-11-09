package com.csroot.followup.notification;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NotificationMapper {

    public NotificationDTO toDTO(Notification notification) {
        return new NotificationDTO(
                notification.getId(),
                notification.getQuestionnaire().getId(),
                notification.getDoctor().getId(),
                notification.getDoctor().getName(),
                notification.getPatientName(),
                notification.getPatientPhone(),
                notification.getNotificationType(),
                notification.getMessage(),
                notification.getSentAt(),
                notification.getReadAt(),
                notification.getIsRead()
        );
    }
}