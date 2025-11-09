package com.csroot.followup.questionnaire;

public record QuestionnaireDTO(
        Long id,
        String filledBy,
        String patientName,
        String patientPhone,
        SymptomsDTO symptoms
) {
}
