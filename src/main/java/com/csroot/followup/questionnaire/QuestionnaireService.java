package com.csroot.followup.questionnaire;

import com.csroot.followup.doctor.Doctor;
import com.csroot.followup.doctor.DoctorRepository;
import com.csroot.followup.notification.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireMapper questionnaireMapper;
    private final NotificationService notificationService;
    private final DoctorRepository doctorRepository;

    public QuestionnaireService(
            QuestionnaireRepository questionnaireRepository,
            QuestionnaireMapper questionnaireMapper,
            NotificationService notificationService,
            DoctorRepository doctorRepository
    ) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireMapper = questionnaireMapper;
        this.notificationService = notificationService;
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    public QuestionnaireDTO save(QuestionnaireDTO questionnaireDTO) {
        // 1. Sauvegarder le questionnaire
        Questionnaire questionnaire = questionnaireRepository.save(
                questionnaireMapper.toEntity(questionnaireDTO)
        );

        // 2. Calculer le statut
        String status = calculateStatus(questionnaireDTO.symptoms());

        // 3. Si urgent ou danger, créer des notifications pour tous les médecins
        if ("URGENT".equals(status) || "DANGER".equals(status)) {
            List<Doctor> doctors = doctorRepository.findAll();

            for (Doctor doctor : doctors) {
                String message = String.format(
                        "Le patient %s présente des symptômes %s nécessitant votre attention",
                        questionnaireDTO.patientName(),
                        status.toLowerCase()
                );

                notificationService.createNotification(
                        questionnaire.getId(),
                        doctor.getId(),
                        questionnaireDTO.patientName(),
                        questionnaireDTO.patientPhone(),
                        status,
                        message
                );
            }
        }

        return questionnaireMapper.toDTO(questionnaire);
    }

    /**
     * Calculer le statut en fonction des 3 symptômes critiques
     */
    private String calculateStatus(SymptomsDTO symptoms) {
        if (symptoms == null) {
            return "STABLE";
        }

        // Vérifier "Presque constamment"
        boolean hasPresqueConstamment =
                "Presque constamment".equals(symptoms.vomissementsFrequence()) ||
                        "Presque constamment".equals(symptoms.diarrheeFrequence()) ||
                        "Presque constamment".equals(symptoms.douleurFrequence());

        if (hasPresqueConstamment) {
            return "DANGER";
        }

        // Vérifier "Fréquemment"
        boolean hasFrequemment =
                "Fréquemment".equals(symptoms.vomissementsFrequence()) ||
                        "Fréquemment".equals(symptoms.diarrheeFrequence()) ||
                        "Fréquemment".equals(symptoms.douleurFrequence());

        if (hasFrequemment) {
            return "URGENT";
        }

        return "STABLE";
    }

    public List<QuestionnaireDTO> findAll() {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        return questionnaires.stream()
                .map(questionnaireMapper::toDTO)
                .collect(Collectors.toList());
    }
}