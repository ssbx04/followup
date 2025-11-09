package com.csroot.followup.notification;

import com.csroot.followup.doctor.Doctor;
import com.csroot.followup.doctor.DoctorRepository;
import com.csroot.followup.questionnaire.Questionnaire;
import com.csroot.followup.questionnaire.QuestionnaireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final DoctorRepository doctorRepository;
    private final QuestionnaireRepository questionnaireRepository;

    public NotificationService(
            NotificationRepository notificationRepository,
            NotificationMapper notificationMapper,
            DoctorRepository doctorRepository,
            QuestionnaireRepository questionnaireRepository
    ) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
        this.doctorRepository = doctorRepository;
        this.questionnaireRepository = questionnaireRepository;
    }

    /**
     * Créer une notification pour un médecin
     */
    @Transactional
    public NotificationDTO createNotification(
            Long questionnaireId,
            Long doctorId,
            String patientName,
            String patientPhone,
            String notificationType,
            String message
    ) {
        Questionnaire questionnaire = questionnaireRepository.findById(questionnaireId)
                .orElseThrow(() -> new RuntimeException("Questionnaire not found"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Notification notification = new Notification();
        notification.setQuestionnaire(questionnaire);
        notification.setDoctor(doctor);
        notification.setPatientName(patientName);
        notification.setPatientPhone(patientPhone);
        notification.setNotificationType(notificationType);
        notification.setMessage(message);
        notification.setIsRead(false);

        Notification saved = notificationRepository.save(notification);
        return notificationMapper.toDTO(saved);
    }

    /**
     * Récupérer les notifications non lues d'un médecin
     */
    public List<NotificationDTO> getUnreadNotifications(Long doctorId) {
        List<Notification> notifications = notificationRepository
                .findByDoctorIdAndIsReadFalseOrderBySentAtDesc(doctorId);

        return notifications.stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Marquer une notification comme lue
     */
    @Transactional
    public void markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setIsRead(true);
        notification.setReadAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    /**
     * Récupérer toutes les notifications d'un médecin (historique)
     */
    public List<NotificationDTO> getAllNotifications(Long doctorId) {
        List<Notification> notifications = notificationRepository
                .findByDoctorIdOrderBySentAtDesc(doctorId);

        return notifications.stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }
}