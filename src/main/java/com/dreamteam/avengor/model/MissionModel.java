package com.dreamteam.avengor.model;

import com.dreamteam.avengor.database.Db;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class MissionModel {

    private int id_Mission;
    private String Titre;
    private Timestamp DateDebut;
    private Timestamp DateFin;
    private int Niveaux;
    private int Urgence;
    private int id_Incidents;
    private String rapportFinMission;
    private SuperHerosModel hero;

       public MissionModel(int id_Mission, String Titre, Timestamp DateDebut, Timestamp DateFin, int Niveaux, int Urgence, int Id_Incidents, String rapportFinMission, SuperHerosModel hero) {
        super();
        this.id_Mission = id_Mission;
        this.Titre = Titre;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Niveaux = Niveaux;
        this.Urgence = Urgence;
        this.id_Incidents = Id_Incidents;
        this.rapportFinMission = rapportFinMission;
        this.hero = hero;
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

    public Timestamp getDateDebut(){
        return DateDebut;
    }
    public void setDateDebut(Timestamp DateDebut){
        this.DateDebut = DateDebut;
    }

    public Timestamp getDateFin(){
        return DateFin;
    }
    public void setDateFin(Timestamp DateFin){
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

    public SuperHerosModel getHero(){
        return hero;
    }
    public void setHero(SuperHerosModel hero){
        this.hero = hero;
    }

    public String getRapportFinMission() { return rapportFinMission; }

    public void setRapportFinMission(String rapportFinMission) { this.rapportFinMission = rapportFinMission; }

    //==================================================================================
    //                              CALLBACK QUERIES DB
    //==================================================================================

    public static List<MissionModel> getAllMissions(){
        return Db.getAllMission();
    }


}
