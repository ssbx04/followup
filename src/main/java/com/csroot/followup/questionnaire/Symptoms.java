package com.csroot.followup.questionnaire;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Embeddable
public class Symptoms {
    @Column(name = "appetit_severite")
    @JsonProperty("appetit_severite")
    private String appetitSeverite;

    @Column(name = "appetit_perturbation")
    @JsonProperty("appetit_perturbation")
    private String appetitPerturbation;

    @Column(name = "nausees_frequence")
    @JsonProperty("nausees_frequence")
    private String nauseesFrequence;

    @Column(name = "nausees_severite")
    @JsonProperty("nausees_severite")
    private String nauseesSeverite;

    @Column(name = "vomissements_frequence")
    @JsonProperty("vomissements_frequence")
    private String vomissementsFrequence;

    @Column(name = "vomissements_severite")
    @JsonProperty("vomissements_severite")
    private String vomissementsSeverite;

    @Column(name = "diarrhee_frequence")
    @JsonProperty("diarrhee_frequence")
    private String diarrheeFrequence;

    @Column(name = "perte_cheveux_impact")
    @JsonProperty("perte_cheveux_impact")
    private String perteCheveuxImpact;

    @Column(name = "alteration_ongles")
    @JsonProperty("alteration_ongles")
    private String alterationOngles;

    @Column(name = "assombrissement_peau")
    @JsonProperty("assombrissement_peau")
    private String assombrissementPeau;

    @Column(name = "douleur_frequence")
    @JsonProperty("douleur_frequence")
    private String douleurFrequence;

    @Column(name = "douleur_severite")
    @JsonProperty("douleur_severite")
    private String douleurSeverite;

    @Column(name = "douleur_perturbation")
    @JsonProperty("douleur_perturbation")
    private String douleurPerturbation;

    @Column(name = "insomnie_severite")
    @JsonProperty("insomnie_severite")
    private String insomnieSeverite;

    @Column(name = "fatigue_severite")
    @JsonProperty("fatigue_severite")
    private String fatigueSeverite;

    @Column(name = "autres_symptomes", length = 1000)
    @JsonProperty("autres_symptomes")
    private String autresSymptomes;

    public String getAppetitSeverite() {
        return appetitSeverite;
    }

    public void setAppetitSeverite(String appetitSeverite) {
        this.appetitSeverite = appetitSeverite;
    }

    public String getAppetitPerturbation() {
        return appetitPerturbation;
    }

    public void setAppetitPerturbation(String appetitPerturbation) {
        this.appetitPerturbation = appetitPerturbation;
    }

    public String getNauseesFrequence() {
        return nauseesFrequence;
    }

    public void setNauseesFrequence(String nauseesFrequence) {
        this.nauseesFrequence = nauseesFrequence;
    }

    public String getNauseesSeverite() {
        return nauseesSeverite;
    }

    public void setNauseesSeverite(String nauseesSeverite) {
        this.nauseesSeverite = nauseesSeverite;
    }

    public String getVomissementsFrequence() {
        return vomissementsFrequence;
    }

    public void setVomissementsFrequence(String vomissementsFrequence) {
        this.vomissementsFrequence = vomissementsFrequence;
    }

    public String getVomissementsSeverite() {
        return vomissementsSeverite;
    }

    public void setVomissementsSeverite(String vomissementsSeverite) {
        this.vomissementsSeverite = vomissementsSeverite;
    }

    public String getDiarrheeFrequence() {
        return diarrheeFrequence;
    }

    public void setDiarrheeFrequence(String diarrheeFrequence) {
        this.diarrheeFrequence = diarrheeFrequence;
    }

    public String getPerteCheveuxImpact() {
        return perteCheveuxImpact;
    }

    public void setPerteCheveuxImpact(String perteCheveuxImpact) {
        this.perteCheveuxImpact = perteCheveuxImpact;
    }

    public String getAlterationOngles() {
        return alterationOngles;
    }

    public void setAlterationOngles(String alterationOngles) {
        this.alterationOngles = alterationOngles;
    }

    public String getAssombrissementPeau() {
        return assombrissementPeau;
    }

    public void setAssombrissementPeau(String assombrissementPeau) {
        this.assombrissementPeau = assombrissementPeau;
    }

    public String getDouleurFrequence() {
        return douleurFrequence;
    }

    public void setDouleurFrequence(String douleurFrequence) {
        this.douleurFrequence = douleurFrequence;
    }

    public String getDouleurSeverite() {
        return douleurSeverite;
    }

    public void setDouleurSeverite(String douleurSeverite) {
        this.douleurSeverite = douleurSeverite;
    }

    public String getDouleurPerturbation() {
        return douleurPerturbation;
    }

    public void setDouleurPerturbation(String douleurPerturbation) {
        this.douleurPerturbation = douleurPerturbation;
    }

    public String getInsomnieSeverite() {
        return insomnieSeverite;
    }

    public void setInsomnieSeverite(String insomnieSeverite) {
        this.insomnieSeverite = insomnieSeverite;
    }

    public String getFatigueSeverite() {
        return fatigueSeverite;
    }

    public void setFatigueSeverite(String fatigueSeverite) {
        this.fatigueSeverite = fatigueSeverite;
    }

    public String getAutresSymptomes() {
        return autresSymptomes;
    }

    public void setAutresSymptomes(String autresSymptomes) {
        this.autresSymptomes = autresSymptomes;
    }

}
