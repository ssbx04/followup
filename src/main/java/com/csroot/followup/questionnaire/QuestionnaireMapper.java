package com.csroot.followup.questionnaire;

import org.springframework.stereotype.Service;

@Service
public class QuestionnaireMapper {
    public Questionnaire toEntity(QuestionnaireDTO dto) {
        if (dto == null) {
            return null;
        }

        Questionnaire entity = new Questionnaire();
        entity.setId(dto.id());
        entity.setFilledBy(dto.filledBy());
        entity.setPatientName(dto.patientName());
        entity.setPatientPhone(dto.patientPhone());
        entity.setSymptoms(toSymptomsEntity(dto.symptoms()));
        entity.setDate(dto.date());
        return entity;
    }

    /**
     * Convertit une entité en DTO
     */
    public QuestionnaireDTO toDTO(Questionnaire entity) {
        if (entity == null) {
            return null;
        }

        return new QuestionnaireDTO(
                entity.getId(),
                entity.getFilledBy(),
                entity.getPatientName(),
                entity.getPatientPhone(),
                entity.getDate(),
                toSymptomsDTO(entity.getSymptoms())
        );
    }

    /**
     * Convertit un SymptomsDTO en Symptoms (entité embarquée)
     */
    private Symptoms toSymptomsEntity(SymptomsDTO dto) {
        if (dto == null) {
            return null;
        }
        Symptoms symptoms = new Symptoms();
        symptoms.setAppetitSeverite(dto.appetitSeverite());
        symptoms.setAppetitPerturbation(dto.appetitPerturbation());
        symptoms.setNauseesFrequence(dto.nauseesFrequence());
        symptoms.setNauseesSeverite(dto.nauseesSeverite());
        symptoms.setVomissementsFrequence(dto.vomissementsFrequence());
        symptoms.setVomissementsSeverite(dto.vomissementsSeverite());
        symptoms.setDiarrheeFrequence(dto.diarrheeFrequence());
        symptoms.setPerteCheveuxImpact(dto.perteCheveuxImpact());
        symptoms.setAlterationOngles(dto.alterationOngles());
        symptoms.setAssombrissementPeau(dto.assombrissementPeau());
        symptoms.setDouleurFrequence(dto.douleurFrequence());
        symptoms.setDouleurSeverite(dto.douleurSeverite());
        symptoms.setDouleurPerturbation(dto.douleurPerturbation());
        symptoms.setInsomnieSeverite(dto.insomnieSeverite());
        symptoms.setFatigueSeverite(dto.fatigueSeverite());
        symptoms.setAutresSymptomes(dto.autresSymptomes());
        return symptoms;
    }

    /**
     * Convertit Symptoms (entité embarquée) en SymptomsDTO
     */
    private SymptomsDTO toSymptomsDTO(Symptoms entity) {
        if (entity == null) {
            return null;
        }

        return new SymptomsDTO(
                entity.getAppetitSeverite(),
                entity.getAppetitPerturbation(),
                entity.getNauseesFrequence(),
                entity.getNauseesSeverite(),
                entity.getVomissementsFrequence(),
                entity.getVomissementsSeverite(),
                entity.getDiarrheeFrequence(),
                entity.getPerteCheveuxImpact(),
                entity.getAlterationOngles(),
                entity.getAssombrissementPeau(),
                entity.getDouleurFrequence(),
                entity.getDouleurSeverite(),
                entity.getDouleurPerturbation(),
                entity.getInsomnieSeverite(),
                entity.getFatigueSeverite(),
                entity.getAutresSymptomes()
        );
    }
}
