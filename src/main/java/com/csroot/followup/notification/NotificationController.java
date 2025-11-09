package com.csroot.followup.notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications/api")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * GET /notifications/unread?doctorId=1
     * Récupérer les notifications non lues
     */
    @GetMapping("/unread")
    public ResponseEntity<List<NotificationDTO>> getUnreadNotifications(
            @RequestParam Long doctorId
    ) {
        List<NotificationDTO> notifications = notificationService.getUnreadNotifications(doctorId);
        return ResponseEntity.ok(notifications);
    }

    /**
     * PATCH /notifications/{id}/mark-read
     * Marquer une notification comme lue
     */
    @PatchMapping("/{id}/mark-read")
    public ResponseEntity<Void> markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /notifications?doctorId=1
     * Récupérer toutes les notifications (historique)
     */
    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAllNotifications(
            @RequestParam Long doctorId
    ) {
        List<NotificationDTO> notifications = notificationService.getAllNotifications(doctorId);
        return ResponseEntity.ok(notifications);
    }
}