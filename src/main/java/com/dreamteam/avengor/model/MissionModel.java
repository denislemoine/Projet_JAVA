package com.dreamteam.avengor.model;

public class MissionModel {
    
    private int id_Mission;
    private String Titre;
    private String DateDebut;
    private String DateFin;
    private int Niveaux;
    private int Urgence;
    private int id_Incidents;
    private IncidentModel incident;

    public MissionModel(int id_Mission, String Titre, String DateDebut, String DateFin, int Niveaux, int Urgence, int Id_Incidents, IncidentModel incident) {
        super();
        this.id_Mission = id_Mission;
        this.Titre = Titre;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Niveaux = Niveaux;
        this.Urgence = Urgence;
        this.id_Incidents = Id_Incidents;
        this.incident = incident;
    }

    //==================================================================================
    //                               GETTERS & SETTERS
    //==================================================================================

    public int getId_Mission(){
        return id_Mission;
    }
    public void setId_Mission(int id_Mission){
        this.id_Mission = id_Mission;
    }

    public String getTitre(){
        return Titre;
    }
    public void setTitre(String Titre){
        this.Titre = Titre;
    }

    public String getDateDebut(){
        return DateDebut;
    }
    public void setDateDebut(String DateDebut){
        this.DateDebut = DateDebut;
    }

    public String getDateFin(){
        return DateFin;
    }
    public void setDateFin(String DateFin){
        this.DateFin = DateFin;
    }

    public int getNiveaux(){
        return Niveaux;
    }
    public void setNiveaux(int Niveaux){
        this.Niveaux = Niveaux;
    }

    public int getUrgence(){
        return Urgence;
    }
    public void setUrgence(int Urgence){
        this.Urgence = Urgence;
    }

    public int getId_Incidents(){
        return id_Incidents;
    }
    public void setId_Incidents(int id_Incidents){
        this.id_Incidents = id_Incidents;
    }

    public IncidentModel getIncident(){
        return incident;
    }
    public void setIncident(IncidentModel incdient){
        this.incident = incident;
    }

    //==================================================================================
    //                              CALLBACK QUERIES DB
    //==================================================================================




}
