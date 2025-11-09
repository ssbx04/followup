package com.csroot.followup.notification;

import java.time.LocalDateTime;

public record NotificationDTO(
        Long id,
        Long questionnaireId,
        Long doctorId,
        String doctorName,
        String patientName,
        String patientPhone,
        String notificationType,
        String message,
        LocalDateTime sentAt,
        LocalDateTime readAt,
        Boolean isRead
) {
}
