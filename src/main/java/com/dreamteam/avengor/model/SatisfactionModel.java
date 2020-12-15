package com.dreamteam.avengor.model;

public class SatisfactionModel {
    private int id_Satisfaction;
    private int id_Civil;
    private int id_Incidents;
    private int id_Mission;
    private String message;
    private int note;
    private String commentaire;

    public SatisfactionModel(){

    }

    public SatisfactionModel(int id_Satisfaction,int id_Civil,int id_Incidents,int id_Mission,String message,int note,String commentaire){

        super();
        this.id_Satisfaction = id_Satisfaction;
        this.id_Civil = id_Civil;
        this.id_Incidents = id_Incidents;
        this.id_Mission = id_Mission;
        this.message = message;
        this.note = note;
        this.commentaire = commentaire;
    }

    public int getId_Satisfaction() {
        return id_Satisfaction;
    }

    public void setId_Satisfaction(int id_Satisfaction) {
        this.id_Satisfaction = id_Satisfaction;
    }

    public int getId_Civil() {
        return id_Civil;
    }

    public void setId_Civil(int id_Civil) {
        this.id_Civil = id_Civil;
    }

    public int getId_Incidents() {
        return id_Incidents;
    }

    public void setId_Incidents(int id_Incidents) {
        this.id_Incidents = id_Incidents;
    }

    public int getId_Mission() {
        return id_Mission;
    }

    public void setId_Mission(int id_Mission) {
        this.id_Mission = id_Mission;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


}
