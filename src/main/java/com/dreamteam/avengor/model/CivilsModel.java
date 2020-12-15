package com.dreamteam.avengor.model;

import java.util.Date;

public class CivilsModel {
    private int id_Civil;
    private String nom;
    private String prenom;
    private String civilite;
    private String adresse;
    private String email;
    private String tel;
    private String nationalité;
    private Date dateDeNaissance;
    private String encrytedPassword;

    public CivilsModel() {

    }

    public CivilsModel(int id_Civil,String nom,String prenom,String civilite,String adresse,String email,String tel,//
                           Date dateDeNaissance, String encrytedPassword){

        this.id_Civil = id_Civil;
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.dateDeNaissance = dateDeNaissance;
        this.encrytedPassword = encrytedPassword;
    }

    public int getId_Civil(){
        return id_Civil;
    }

    public void setId_Civil(int id_Civil){
        this.id_Civil = id_Civil;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String Nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getCivilite(){
        return civilite;
    }

    public void setCivilite(String civilite){
        this.civilite = civilite;
    }

    public String getAdresse(){
        return adresse;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTel(){
        return tel;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
    public Date getDateDeNaissance(){
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance){
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getencrytedPassword(){
        return encrytedPassword;
    }

    public void setencrytedPassword(String encrytedPassword){
        this.encrytedPassword = encrytedPassword;
    }
}
