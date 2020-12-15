package com.dreamteam.avengor.model;

import java.util.Date;

public class CivilsModel {
    private int id_Civil;
    private String Nom;
    private String Prenom;
    private String Civilite;
    private String Adresse;
    private String Email;
    private String Tel;
    private String Nationalité;
    private Date DateDeNaissance;
    private String encrytedPassword;

    public CivilsModel() {

    }

    public CivilsModel(int id_Civil,String Nom,String Prenom,String Civilite,String Adresse,String Email,String Tel,//
                           Date DateDeNaissance, String encrytedPassword){
        super();
        this.id_Civil = id_Civil;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Civilite = Civilite;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Tel = Tel;
        this.DateDeNaissance = DateDeNaissance;
        this.encrytedPassword = encrytedPassword;
    }

    public int getId_Civil(int id_Civil){
        return id_Civil;
    }

    public void setId_Civil(int id_Civil){
        this.id_Civil = id_Civil;
    }

    public String getNom(String Nom){
        return Nom;
    }

    public void setNom(String Nom){
        this.Nom = Nom;
    }

    public String getPrenom(String Prenom){
        return Prenom;
    }

    public void setPrenom(String Prenom){
        this.Prenom = Prenom;
    }

    public String getCivilite(String Civilite){
        return Civilite;
    }

    public void setCivilite(String Civilite){
        this.Civilite = Civilite;
    }

    public String getAdresse(String Adresse){
        return Adresse;
    }

    public void setAdresse(String Adresse){
        this.Adresse = Adresse;
    }

    public String getEmail(String Email){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getTel(String Tel){
        return Tel;
    }

    public void setTel(String Tel){
        this.Tel = Tel;
    }
    public Date getDateDeNaissance(Date DateDeNaissance){
        return DateDeNaissance;
    }

    public void setDateDeNaissance(Date DateDeNaissance){
        this.DateDeNaissance = DateDeNaissance;
    }

    public String getencrytedPassword(String encrytedPassword){
        return encrytedPassword;
    }

    public void setencrytedPassword(String encrytedPassword){
        this.encrytedPassword = encrytedPassword;
    }
}
