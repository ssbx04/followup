package com.csroot.followup.questionnaire;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SymptomsDTO(
        @JsonProperty("appetit_severite")
        String appetitSeverite,

        @JsonProperty("appetit_perturbation")
        String appetitPerturbation,

        @JsonProperty("nausees_frequence")
        String nauseesFrequence,

        @JsonProperty("nausees_severite")
        String nauseesSeverite,

        @JsonProperty("vomissements_frequence")
        String vomissementsFrequence,

        @JsonProperty("vomissements_severite")
        String vomissementsSeverite,

        @JsonProperty("diarrhee_frequence")
        String diarrheeFrequence,

        @JsonProperty("perte_cheveux_impact")
        String perteCheveuxImpact,

        @JsonProperty("alteration_ongles")
        String alterationOngles,

        @JsonProperty("assombrissement_peau")
        String assombrissementPeau,

        @JsonProperty("douleur_frequence")
        String douleurFrequence,

        @JsonProperty("douleur_severite")
        String douleurSeverite,

        @JsonProperty("douleur_perturbation")
        String douleurPerturbation,

        @JsonProperty("insomnie_severite")
        String insomnieSeverite,

        @JsonProperty("fatigue_severite")
        String fatigueSeverite,

        @JsonProperty("autres_symptomes")
        String autresSymptomes
) {
}
