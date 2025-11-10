package com.csroot.followup.questionnaire;

import java.time.LocalDateTime;

public record QuestionnaireDTO(
        Long id,
        String filledBy,
        String patientName,
        String patientPhone,
        LocalDateTime date,
        SymptomsDTO symptoms
) {
}
