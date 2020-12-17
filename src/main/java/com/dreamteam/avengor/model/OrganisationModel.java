package com.dreamteam.avengor.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrganisationModel {
    private int id_Organisations;
    private String nom;
    private String adresse;
    private int dirigeant;
    private String commentaire;
    private Timestamp dateAjout;
    private LocalDateTime dateDerniereModif;
    private int nbIncidentsDeclares;
    private int nbMissionsImplique;

    public OrganisationModel(int id_Organisations, String nom, String adresse, int dirigeant, String commentaire, Timestamp dateAjout, LocalDateTime dateDerniereModif, int nbIncidentsDeclares, int nbMissionsImplique){
        super();
        this.id_Organisations = id_Organisations;
        this.nom = nom;
        this.adresse = adresse;
        this.dirigeant = dirigeant;
        this.commentaire = commentaire;
        this.dateAjout = dateAjout;
        this.dateDerniereModif = dateDerniereModif;
        this.nbIncidentsDeclares = nbIncidentsDeclares;
        this.nbMissionsImplique = nbMissionsImplique;

    }

    public int getId_Organisations() {
        return id_Organisations;
    }

    public void setId_Organisations(int id_Organisations) {
        this.id_Organisations = id_Organisations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        adresse = adresse;
    }

    public int getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(int dirigeant) {
        dirigeant = dirigeant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    public LocalDateTime getDateDerniereModif() {
        return dateDerniereModif;
    }

    public void setDateDerniereModif(LocalDateTime dateDerniereModif) {
        this.dateDerniereModif = dateDerniereModif;
    }

    public int getNbIncidentsDeclares() {
        return nbIncidentsDeclares;
    }

    public void setNbIncidentsDeclares(int nbIncidentsDeclares) {
        this.nbIncidentsDeclares = nbIncidentsDeclares;
    }

    public int getNbMissionsImplique() {
        return nbMissionsImplique;
    }

    public void setNbMissionsImplique(int nbMissionsImplique) {
        this.nbMissionsImplique = nbMissionsImplique;
    }


}
